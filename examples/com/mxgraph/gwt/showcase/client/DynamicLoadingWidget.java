package com.mxgraph.gwt.showcase.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Node;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.SimplePanel;
import com.mxgraph.gwt.client.IJavaScriptWrapper;
import com.mxgraph.gwt.client.io.mxCodec;
import com.mxgraph.gwt.client.model.mxCell;
import com.mxgraph.gwt.client.model.mxGeometry;
import com.mxgraph.gwt.client.model.mxGraphModel;
import com.mxgraph.gwt.client.model.mxGraphModel.mxChange;
import com.mxgraph.gwt.client.model.mxICell;
import com.mxgraph.gwt.client.util.mxConstants;
import com.mxgraph.gwt.client.util.mxEffects;
import com.mxgraph.gwt.client.util.mxEvent;
import com.mxgraph.gwt.client.util.mxEventObject;
import com.mxgraph.gwt.client.util.mxUndoableEdit;
import com.mxgraph.gwt.client.util.mxEventSource.mxIEventListener;
import com.mxgraph.gwt.client.util.mxUtils;
import com.mxgraph.gwt.client.view.mxGraph;
import com.mxgraph.gwt.client.view.mxPerimeter;

public class DynamicLoadingWidget extends AbstractContentWidget {

	private int requestId = 0;

	public DynamicLoadingWidget(String name, Showcase showcase) {
		super(name, showcase);
		description = "Loading graph model data dynamically to limit the number of cells in the model.";
	}

	@Override public void injectContent(final SimplePanel panel) {

		final mxGraph graph = new mxGraph();
		graph.getElement().setAttribute("style", "height: 100%; width : 100%");
		panel.setWidget(graph);

		// Disables all built-in interactions
		graph.setEnabled(false);

		graph.addListener(mxEvent.CLICK, new mxIEventListener<Object>() {

			@Override public void invoke(Object sender, mxEventObject evt) {
				mxCell cell = (mxCell)evt.getProperty("cell");

				if (cell != null) {
					load(graph, cell);
				}
			}
		});

		// Changes the default vertex style in-place
		Map<String, Object> style = graph.getStylesheet().getDefaultVertexStyle();
		style.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_ELLIPSE);
		style.put(mxConstants.STYLE_PERIMETER, mxPerimeter.wrapPerimeterCallback(mxPerimeter.getEllipsePerimeter()));
		style.put(mxConstants.STYLE_GRADIENTCOLOR, "white");
		//graph.getStylesheet().setDefaultVertexStyle(style);

		// Gets the default parent for inserting new cells. This
		// is normally the first child of the root (ie. layer 0).
		mxCell parent = graph.getDefaultParent();

		int cx = graph.getElement().getScrollWidth() / 2;
		int cy = Window.getClientHeight() / 2;

		mxCell cell = graph.insertVertex(parent, "0-0", "0-0", cx - 20, cy - 15, 40, 30);

		graph.getModel().addListener(mxEvent.CHANGE, new mxIEventListener<mxGraphModel>() {
			@Override public void invoke(mxGraphModel sender, mxEventObject evt) {
				List<mxChange> changes = ((mxUndoableEdit) evt.getProperty("edit")).getChanges();
				mxEffects.animateChanges(graph, changes, null);
			}
		});
		
		load(graph, cell);

	}

	private void load(mxGraph graph, mxCell cell) {
		if (graph.getModel().isVertex(cell)) {
			int cx = graph.getElement().getScrollWidth() / 2;
			int cy = graph.getElement().getScrollHeight() / 2;

			// Gets the default parent for inserting new cells. This
			// is normally the first child of the root (ie. layer 0).
			mxCell parent = graph.getDefaultParent();

			// Adds cells to the model in a single step
			graph.getModel().beginUpdate();
			try {
				String xml = server(cell.getId());
				Document doc = mxUtils.parseXml(xml);
				mxCodec dec = new mxCodec(doc);
				mxGraphModel model = (mxGraphModel) dec.decode(doc.getDocumentElement(), (IJavaScriptWrapper) null);

				// Removes all cells which are not in the response
				for (String key : graph.getModel().getCells().keySet()) {
					mxICell tmp = (mxICell) graph.getModel().getCell(key);

					if (tmp != cell && graph.getModel().isVertex(tmp)) {
						graph.removeCells(Arrays.asList(tmp), null);
					}
				}

				// Merges the response model with the client model
				graph.getModel().mergeChildren(model.getRoot().getChildAt(0), parent, null);

				// Moves the given cell to the center
				mxGeometry geo = graph.getModel().getGeometry(cell);

				if (geo != null) {
					geo = (mxGeometry) geo.clone();
					geo.setX(cx - geo.getWidth() / 2);
					geo.setY(cy - geo.getHeight() / 2);

					graph.getModel().setGeometry(cell, geo);
				}

				// Creates a list of the new vertices, if there is more
				// than the center vertex which might have existed
				// previously, then this needs to be changed to analyze
				// the target model before calling mergeChildren above
				List<mxICell> vertices = new ArrayList<mxICell>();

				for (String key : graph.getModel().getCells().keySet()) {
					mxICell tmp = graph.getModel().getCell(key);

					if (tmp != cell && model.isVertex(tmp)) {
						vertices.add(tmp);

						// Changes the initial location "in-place"
						// to get a nice animation effect from the
						// center to the radius of the circle
						geo = model.getGeometry((mxCell) tmp);

						if (geo != null) {
							geo.setX(cx - geo.getWidth() / 2);
							geo.setY(cy - geo.getHeight() / 2);
						}
					}
				}

				// Arranges the response in a circle
				int cellCount = vertices.size();
				double phi = 2 * Math.PI / cellCount;
				int r = Math.min(graph.getElement().getScrollWidth() / 4, graph.getElement().getScrollHeight() / 4);

				for (int i = 0; i < cellCount; i++) {
					geo = graph.getModel().getGeometry((mxCell) vertices.get(i));

					if (geo != null) {
						geo = (mxGeometry) geo.clone();
						geo.setX(geo.getX() + r * Math.sin(i * phi));
						geo.setY(geo.getY() + r * Math.cos(i * phi));

						graph.getModel().setGeometry((mxCell) vertices.get(i), geo);
					}
				}
			} finally {
				// Updates the display
				graph.getModel().endUpdate();
			}
		}
	}

	private String server(String cellID) {
		// Increments the request ID as a prefix for the cell IDs
		requestId++;

		// Creates a local graph with no display
		mxGraph graph = new mxGraph(null, null, null, null);

		// Gets the default parent for inserting new cells. This
		// is normally the first child of the root (ie. layer 0).
		mxICell parent = graph.getDefaultParent();

		// Adds cells to the model in a single step
		graph.getModel().beginUpdate();
		try {
			mxCell v0 = graph.insertVertex((mxCell) parent, cellID, "Dummy", 0, 0, 40, 30);
			int cellCount = (int) ((Math.random() * 16) + 4);

			// Creates the random links and cells for the response
			for (int i = 0; i < cellCount; i++) {
				String id = requestId + "-" + i;
				mxCell v = graph.insertVertex((mxCell) parent, id, id, 0, 0, 40, 30);
				graph.insertEdge((mxCell) parent, null, "Link" + i, v0, v);
			}
		} finally {
			// Updates the display
			graph.getModel().endUpdate();
		}

		mxCodec enc = new mxCodec(null);
		Node node = enc.encode(graph.getModel());

		return mxUtils.getXml(node, null);
	}
}

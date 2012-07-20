package com.mxgraph.gwt.showcase.client;

import java.util.Arrays;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.SimplePanel;
import com.mxgraph.gwt.client.model.mxCell;
import com.mxgraph.gwt.client.model.mxGraphModel;
import com.mxgraph.gwt.client.model.mxICell;
import com.mxgraph.gwt.client.model.mxPoint;
import com.mxgraph.gwt.client.shape.mxShape;
import com.mxgraph.gwt.client.view.mxGraph;

public class LayersWidget extends AbstractContentWidget {

	public LayersWidget(String name, Showcase showcase) {
		super(name, showcase);
		description = "Using multiple layers to contain cells.";
	}

	@Override public void injectContent(SimplePanel panel) {
		HorizontalPanel hp = new HorizontalPanel();
		PushButton layer1Btn = new PushButton("layer1");
		PushButton layer2Btn = new PushButton("layer2");
		hp.add(layer1Btn);
		hp.add(layer2Btn);
		FlowPanel fp = new FlowPanel();
		fp.add(hp);
		panel.setWidget(fp);
		
		
		// Enables crisp rendering of all shapes in SVG
		//mxShape.globalSettings.setCrisp(true);

		// Creates the graph inside the given container using a model
		// with a custom root and two layers. Layers can also be added
		// dynamically using var layer = model.add(root, new mxCell()).
		mxICell root = new mxCell();
		final mxICell layer0 = root.insert(new mxCell());
		final mxICell layer1 = root.insert(new mxCell());
		final mxGraphModel model = new mxGraphModel(root);

		SimplePanel graphContainer = new SimplePanel();
		final mxGraph graph = new mxGraph(graphContainer, model, null, null);
		fp.add(graph);

		// Disables basic selection and cell handling
		graph.setEnabled(false);

		// Adds cells to the model in a single step
		model.beginUpdate();
		try {

			mxICell v1 = graph.insertVertex((mxCell) layer1, null, "Hello,", 20, 20, 80, 30, "fillColor=#C0C0C0");
			mxICell v2 = graph.insertVertex((mxCell) layer1, null, "Hello,", 200, 20, 80, 30, "fillColor=#C0C0C0");
			mxICell v3 = graph.insertVertex((mxCell) layer0, null, "World!", 110, 150, 80, 30);
			mxICell e1 = graph.insertEdge((mxCell) layer1, null, "", (mxCell) v1, (mxCell) v3, "strokeColor=#0C0C0C");
			e1.getGeometry().setPoints(Arrays.asList((new mxPoint(60, 165))));
			mxICell e2 = graph.insertEdge((mxCell) layer0, null, "", (mxCell) v2, (mxCell) v3);
			e2.getGeometry().setPoints(Arrays.asList((new mxPoint(240, 165))));
			mxICell e3 = graph.insertEdge((mxCell) layer0, null, "", (mxCell) v1, (mxCell) v2, "edgeStyle=topToBottomEdgeStyle");
			e3.getGeometry().setPoints(Arrays.asList((new mxPoint(150, 30))));
			mxICell e4 = graph.insertEdge((mxCell) layer1, null, "", (mxCell) v2, (mxCell) v1, "strokeColor=#0C0C0C;edgeStyle=topToBottomEdgeStyle");
			e4.getGeometry().setPoints(Arrays.asList((new mxPoint(150, 40))));
		} finally {
			// Updates the display
			model.endUpdate();
		}

		layer1Btn.addClickHandler(new ClickHandler() {
			@Override public void onClick(ClickEvent event) {
				model.beginUpdate();
				try
				{
					boolean visible = model.isVisible(layer0);
					model.setVisible(layer0, !visible);

					// Forces a complete refresh to hide the edges in other
					// layers which are connected to children of this layer
					graph.getView().invalidate(null, null, null, null);
				}
				finally
				{
					model.endUpdate();
				}
				
			}
		});
		
		layer2Btn.addClickHandler(new ClickHandler() {
			@Override public void onClick(ClickEvent event) {
				model.beginUpdate();
				try
				{
					boolean visible = model.isVisible(layer1);
					model.setVisible(layer1, !visible);

					// Forces a complete refresh to hide the edges in other
					// layers which are connected to children of this layer
					graph.getView().invalidate(null, null, null, null);
				}
				finally
				{
					model.endUpdate();
				}
				
			}
		});

	}

}

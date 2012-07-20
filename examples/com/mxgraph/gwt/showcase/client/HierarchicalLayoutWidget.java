package com.mxgraph.gwt.showcase.client;

import java.util.Map;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.SimplePanel;
import com.mxgraph.gwt.client.handler.mxRubberband;
import com.mxgraph.gwt.client.layout.mxFastOrganicLayout;
import com.mxgraph.gwt.client.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.gwt.client.model.mxCell;
import com.mxgraph.gwt.client.util.mxConstants;
import com.mxgraph.gwt.client.view.mxGraph;

public class HierarchicalLayoutWidget extends AbstractContentWidget {

	public HierarchicalLayoutWidget(String name, Showcase showcase) {
		super(name, showcase);
		description = "Using the hierarchical and organic layout algorithms.";
	}

	@Override public void injectContent(SimplePanel panel) {
		mxGraph graph = new mxGraph();
		HorizontalPanel hp = new HorizontalPanel();
		PushButton horizontalBtn = new PushButton("horizontal");
		PushButton organicBtn = new PushButton("organic");
		hp.add(horizontalBtn);
		hp.add(organicBtn);
		FlowPanel fp = new FlowPanel();
		fp.add(hp);
		fp.add(graph);
		panel.setWidget(fp);

		// Adds rubberband selection
		new mxRubberband(graph);

		// Changes the default vertex style in-place
		Map<String, Object> style = graph.getStylesheet().getDefaultVertexStyle();
		style.put(mxConstants.STYLE_PERIMETER, "");
		style.put(mxConstants.STYLE_GRADIENTCOLOR, "white");
		style.put(mxConstants.STYLE_PERIMETER_SPACING, 6);
		style.put(mxConstants.STYLE_ROUNDED, true);
		style.put(mxConstants.STYLE_SHADOW, true);

		// Creates a layout algorithm to be used
		// with the graph
		final mxHierarchicalLayout layout = new mxHierarchicalLayout(graph);
		final mxFastOrganicLayout organic = new mxFastOrganicLayout(graph);
		organic.setForceConstant(120);

		final mxCell parent = graph.getDefaultParent();
		
		horizontalBtn.addClickHandler(new ClickHandler() {
			@Override public void onClick(ClickEvent event) {
				layout.execute(parent);
			}
		});
		
		organicBtn.addClickHandler(new ClickHandler() {
			@Override public void onClick(ClickEvent event) {
				organic.execute(parent);
			}
		});

		// Load cells and layouts the graph
		graph.getModel().beginUpdate();
		try {
			mxCell v1 = graph.insertVertex(parent, null, "1", 0, 0, 80, 30);
			mxCell v2 = graph.insertVertex(parent, null, "2", 0, 0, 80, 30);
			mxCell v3 = graph.insertVertex(parent, null, "3", 0, 0, 80, 30);
			mxCell v4 = graph.insertVertex(parent, null, "4", 0, 0, 80, 30);
			mxCell v5 = graph.insertVertex(parent, null, "5", 0, 0, 80, 30);
			mxCell v6 = graph.insertVertex(parent, null, "6", 0, 0, 80, 30);
			mxCell v7 = graph.insertVertex(parent, null, "7", 0, 0, 80, 30);
			mxCell v8 = graph.insertVertex(parent, null, "8", 0, 0, 80, 30);
			mxCell v9 = graph.insertVertex(parent, null, "9", 0, 0, 80, 30);

			graph.insertEdge(parent, null, "", v1, v2);
			graph.insertEdge(parent, null, "", v1, v3);
			graph.insertEdge(parent, null, "", v3, v4);
			graph.insertEdge(parent, null, "", v2, v5);
			graph.insertEdge(parent, null, "", v1, v6);
			graph.insertEdge(parent, null, "", v2, v3);
			graph.insertEdge(parent, null, "", v6, v4);
			graph.insertEdge(parent, null, "", v6, v1);
			graph.insertEdge(parent, null, "", v6, v7);
			graph.insertEdge(parent, null, "", v7, v8);
			graph.insertEdge(parent, null, "", v7, v9);
			graph.insertEdge(parent, null, "", v7, v6);
			graph.insertEdge(parent, null, "", v7, v5);

			// Executes the layout
			layout.execute(parent);
		} finally {
			// Updates the display
			graph.getModel().endUpdate();
		}

	}

}

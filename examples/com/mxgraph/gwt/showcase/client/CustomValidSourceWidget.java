package com.mxgraph.gwt.showcase.client;

import java.util.Arrays;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.SimplePanel;
import com.mxgraph.gwt.client.model.mxCell;
import com.mxgraph.gwt.client.model.mxGeometry;
import com.mxgraph.gwt.client.model.mxICell;
import com.mxgraph.gwt.client.util.mxImage;
import com.mxgraph.gwt.client.view.mxGraph;
import com.mxgraph.gwt.client.view.mxGraph.IsValidSourceCallback;

public class CustomValidSourceWidget extends AbstractContentWidget {

	public CustomValidSourceWidget(String name, Showcase showcase) {
		super(name, showcase);
		description = "Shows how change the default behaviour of graph in terms of deciding which vertices are connection sources. Drag connections between valid connection sources. 'Invalid source' vertice neither will accept nor start connections.";
	}

	@Override public void injectContent(SimplePanel panel) {
		final mxGraph graph = new mxGraph();
		panel.setWidget(graph);
		Examples.loadDefaultStyle(graph);
		
		graph.setFoldingEnabled(false);
		graph.setGridEnabled(true);
		graph.setAllowDanglingEdges(false);
		graph.getElement().getStyle().setBackgroundImage("url('images/grid.gif')");
		graph.getElement().getStyle().setHeight(100, Unit.PCT);
		
		graph.setConnectable(true);
		graph.getConnectionHandler().setConnectImage(new mxImage("images/connector.gif", 16, 16));

		mxICell valid = new mxCell("Valid source #1", new mxGeometry(0, 0, 160, 140), "");
		valid.setVertex(true);
		graph.importCells(Arrays.asList(valid), 20, 70, graph.getDefaultParent());

		mxICell invalid = new mxCell("Invalid source", new mxGeometry(0, 0, 160, 140), "rhombus");
		invalid.setVertex(true);
		graph.importCells(Arrays.asList(invalid), 300, 70, graph.getDefaultParent());

		mxICell dragMe = new mxCell("Valid source #2", new mxGeometry(0, 0, 110, 50), "ellipse");
		dragMe.setVertex(true);
		graph.importCells(Arrays.asList(dragMe), 150, 350, graph.getDefaultParent());
		
		graph.setIsValidSourceCallback(new IsValidSourceCallback() {
			@Override public boolean invoke(mxICell cell, IsValidSourceCallback old) {
				return !cell.getValue().equals("Invalid source");
			}
		});
	}

}

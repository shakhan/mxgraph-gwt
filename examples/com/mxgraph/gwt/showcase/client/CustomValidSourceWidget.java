package com.mxgraph.gwt.showcase.client;

import java.util.Arrays;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.SimplePanel;
import com.mxgraph.gwt.client.handler.mxConnectionHandler.ConnectCallback;
import com.mxgraph.gwt.client.model.mxCell;
import com.mxgraph.gwt.client.model.mxGeometry;
import com.mxgraph.gwt.client.model.mxICell;
import com.mxgraph.gwt.client.util.mxImage;
import com.mxgraph.gwt.client.view.mxGraph;
import com.mxgraph.gwt.client.view.mxGraph.IsValidSourceCallback;
import com.mxgraph.gwt.client.view.mxGraph.IsValidTargetCallback;

public class CustomValidSourceWidget extends AbstractContentWidget {

	public CustomValidSourceWidget(String name, Showcase showcase) {
		super(name, showcase);
		description = "Shows how to change the default behaviour of graph in terms of deciding which vertices are connection sources or targets. Drag connections between valid connection sources. 'Invalid source' vertice will not start connections and 'Invalid target' will not accept them.";
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
		
		invalid = new mxCell("Invalid target", new mxGeometry(0, 0, 160, 140), "rhombus");
		invalid.setVertex(true);
		graph.importCells(Arrays.asList(invalid), 320, 270, graph.getDefaultParent());
		
		graph.setIsValidSourceCallback(new IsValidSourceCallback() {
			@Override public boolean invoke(mxICell cell, IsValidSourceCallback old) {
				return !cell.getValue().equals("Invalid source");
			}
		});
		
		graph.setIsValidTargetCallback(new IsValidTargetCallback() {
			@Override public boolean invoke(mxICell cell, IsValidTargetCallback old) {
				return !cell.getValue().equals("Invalid target");
			}
		});
		
		
		graph.getConnectionHandler().setConnectCallback(new ConnectCallback() {
			
			@Override public void invoke(mxICell source, mxICell target, NativeEvent evt, mxICell dropTarget, ConnectCallback old) {
				source.getJso();
				old.invoke(source, target, evt, dropTarget, null);
			}
		});
	}

}

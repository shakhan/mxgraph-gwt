package com.mxgraph.gwt.showcase.client;

import java.util.List;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.SimplePanel;
import com.mxgraph.gwt.client.handler.mxRubberband;
import com.mxgraph.gwt.client.model.mxCell;
import com.mxgraph.gwt.client.model.mxGeometry;
import com.mxgraph.gwt.client.model.mxGraphModel;
import com.mxgraph.gwt.client.model.mxICell;
import com.mxgraph.gwt.client.shape.mxShape;
import com.mxgraph.gwt.client.util.mxEvent;
import com.mxgraph.gwt.client.view.mxGraph;
import com.mxgraph.gwt.client.view.mxGraph.MoveCellsCallback;
import com.mxgraph.gwt.client.view.mxGraph.GetTooltipForCellCallback;

public class HelloWorldWidget extends AbstractContentWidget {

	public HelloWorldWidget(String name, Showcase showcase) {
		super(name, showcase);
		description = " Hello, World! example for mxGraph. This example demonstrates creating a graph and adding vertices and edges. Also shows how to implement hit-detection for vertices and how to implement custom tooltips.";
	}

	public void injectContent(SimplePanel p) {

		mxShape.setCrispGlobal(false);

		final mxGraph graph = new mxGraph();
		
		//implements a listener that reacts to graph clicks
		mxEvent.addListener(graph.getElement(), mxEvent.CLICK, new mxEvent.EventHandler() {
			@Override public void handleEvent(NativeEvent event) {
				int left = graph.getElement().getAbsoluteLeft();
				int top = graph.getElement().getAbsoluteTop();
				int x = event.getClientX();
				int y = event.getClientY();
				mxICell cell = graph.getCellAt(x - left, y - top, null, true, true);
				
				if(cell !=null) {
					String id = cell.getValue().toString();
					Window.alert(id);
				}
			}
		});

		p.setWidget(graph);
		graph.getElement().getStyle().setBackgroundImage("url('images/grid.gif')");
		graph.getElement().getStyle().setHeight(100, Unit.PCT);
		
		new mxRubberband(graph);

		mxGraphModel graphModel = graph.getModel();
		graphModel.beginUpdate();
		graph.setTooltips(true);
		
		
		//add some vertices on the graph
		try {
			mxCell v1 = graph.insertVertex(graph.getDefaultParent(), null, "Hello", 20, 20, 80, 30, "ROUNDED");
			mxCell v2 = graph.insertVertex(graph.getDefaultParent(), null, "World", 220, 140, 80, 30, "ROUNDED");
			graph.insertEdge(graph.getDefaultParent(), null, "", v1, v2);
			

		} finally {
			graphModel.endUpdate();
		}
		
		graph.getTooltipHandler().setDelay(350);
	
		//create a custom tooltip 
		graph.setGetTooltipForCellCallback(new GetTooltipForCellCallback() {
			@Override public String invoke(mxICell cell, GetTooltipForCellCallback old) {
				mxGeometry geo = cell.getGeometry();
				if(!graph.getModel().isVertex(cell)) {
					return null;
				}
	
				return "X : " + geo.getX() + "\nY : " + geo.getY() + "\nWidth : " + geo.getWidth() + "\nHeight : " + geo.getHeight();
			}
		});
		
		
	}
}

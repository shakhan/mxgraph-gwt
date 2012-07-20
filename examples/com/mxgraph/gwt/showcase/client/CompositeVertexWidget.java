package com.mxgraph.gwt.showcase.client;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.SimplePanel;
import com.mxgraph.gwt.client.handler.mxGraphHandler.ShouldRemoveCellsFromParentCallback;
import com.mxgraph.gwt.client.model.mxCell;
import com.mxgraph.gwt.client.model.mxGeometry;
import com.mxgraph.gwt.client.model.mxICell;
import com.mxgraph.gwt.client.view.mxGraph;
import com.mxgraph.gwt.client.view.mxGraph.IsCellLockedCallback;

public class CompositeVertexWidget extends AbstractContentWidget {

	public CompositeVertexWidget(String name, Showcase showcase) {
		super(name, showcase);
		description = "Demonstrates how to disallow moving certain vertices out of their parent. Try dragging children of Composite #1 and Composite #2 out of their parent containers.";
	}

	@Override public void injectContent(SimplePanel panel) {
		final mxGraph graph = new mxGraph();
		panel.setWidget(graph);
		
		Examples.loadDefaultStyle(graph);
		graph.setFoldingEnabled(false);
		
		mxICell composite1 = new mxCell("Composite #1", new mxGeometry(0, 0, 150, 150), "");
		composite1.setVertex(true);
		
		mxICell cell = new mxCell("O", new mxGeometry(0, 0, 30, 30), "");
		cell.setVertex(true);
		mxICell imp = graph.importCells(Arrays.asList(composite1), 50, 50, graph.getDefaultParent()).get(0);
		
		int x = (int) imp.getGeometry().getX();
		int y = (int) imp.getGeometry().getY();
		
		graph.importCells(Arrays.asList(cell), x + 15, y + 15, imp);
		graph.importCells(Arrays.asList(cell), x + 90, y + 15, imp);
		graph.importCells(Arrays.asList(cell), x + 50, y + 80, imp);
		
		mxICell composite2 = new mxCell("Composite #2", new mxGeometry(0, 0, 150, 150), "");
		composite2.setVertex(true);
		
		cell = new mxCell("X", new mxGeometry(0, 0, 30, 30), "ellipse;selectable=0");
		cell.setVertex(true);
		
		imp = graph.importCells(Arrays.asList(composite2), 400, 30, graph.getDefaultParent()).get(0);
		x = (int) imp.getGeometry().getX();
		y = (int) imp.getGeometry().getY();
		
		graph.importCells(Arrays.asList(cell), x + 15, y + 15, imp);
		graph.importCells(Arrays.asList(cell), x + 90, y + 15, imp);
		graph.importCells(Arrays.asList(cell), x + 50, y + 80, imp);
		
		graph.getGraphHandler().setShouldRemoveCellsFromParentCallback(new ShouldRemoveCellsFromParentCallback() {
			
			@Override public boolean invoke(mxICell parent, List<mxICell> cells, NativeEvent event, ShouldRemoveCellsFromParentCallback old) {
				return !"Composite #2".equals(parent.getValue());
			}
		});
		
		graph.setIsCellLockedCallback(new IsCellLockedCallback() {
			
			@Override public boolean invoke(mxICell cell, IsCellLockedCallback old) {
				Map<String, String> style =  graph.getCellStyle(cell);
				boolean cellLocked = style.containsKey("selectable") && style.get("selectable").equals("0");
				
				return old.invoke(cell, null) || cellLocked;
			}
		});

		
	}

}

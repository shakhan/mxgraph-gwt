package com.mxgraph.gwt.showcase.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.SimplePanel;
import com.mxgraph.gwt.client.handler.mxCellHighlight;
import com.mxgraph.gwt.client.handler.mxConnectionHandler;
import com.mxgraph.gwt.client.handler.mxConnectionHandler.CreateShapeCallback;
import com.mxgraph.gwt.client.handler.mxConnectionHandler.GetEdgeColorCallback;
import com.mxgraph.gwt.client.handler.mxConnectionHandler.GetEdgeWidthCallback;
import com.mxgraph.gwt.client.model.mxCell;
import com.mxgraph.gwt.client.model.mxGeometry;
import com.mxgraph.gwt.client.model.mxGraphModel;
import com.mxgraph.gwt.client.model.mxICell;
import com.mxgraph.gwt.client.shape.mxShape;
import com.mxgraph.gwt.client.util.mxEvent;
import com.mxgraph.gwt.client.util.mxEventObject;
import com.mxgraph.gwt.client.util.mxEventSource;
import com.mxgraph.gwt.client.util.mxImage;
import com.mxgraph.gwt.client.view.mxCellState;
import com.mxgraph.gwt.client.view.mxGraph;
import com.mxgraph.gwt.client.view.mxGraph.IsValidSourceCallback;
import com.mxgraph.gwt.client.view.mxGraph.IsValidTargetCallback;

public class CustomValidSourceWidget extends AbstractContentWidget
{

	public CustomValidSourceWidget(String name, Showcase showcase)
	{
		super(name, showcase);
		description = "Shows how to change the default behaviour of graph in terms of deciding which vertices are connection sources or targets. Drag connections between valid connection sources. "
				+ "'Invalid source' vertice will not start connections and 'Invalid target' will not accept them.";
	}

	@Override
	public void injectContent(SimplePanel panel)
	{
		final mxGraph graph = new mxGraph();
		panel.setWidget(graph);
		Examples.loadDefaultStyle(graph);

		graph.setFoldingEnabled(false);
		graph.setGridEnabled(true);
		graph.setAllowDanglingEdges(false);
		graph.getElement().getStyle().setBackgroundImage("url('images/grid.gif')");
		graph.getElement().getStyle().setHeight(100, Unit.PCT);

		graph.setConnectable(true);

		final mxConnectionHandler connectionHandler = graph.getConnectionHandler();

		connectionHandler.setConnectImage(new mxImage("images/connector.gif", 16, 16));

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

		graph.setIsValidSourceCallback(new IsValidSourceCallback()
		{
			@Override
			public boolean invoke(mxICell cell, IsValidSourceCallback old)
			{
				return !cell.getValue().equals("Invalid source");
			}
		});

		graph.setIsValidTargetCallback(new IsValidTargetCallback()
		{
			@Override
			public boolean invoke(mxICell cell, IsValidTargetCallback old)
			{
				return !cell.getValue().equals("Invalid target");
			}
		});

		//customizing the connector line, valid/invalid colors, width and line style
		connectionHandler.setGetEdgeColorCallback(new GetEdgeColorCallback()
		{
			public String invoke(boolean valid, GetEdgeColorCallback old)
			{
				return valid ? "red" : "black";
			}
		});

		connectionHandler.setGetEdgeWidthCallback(new GetEdgeWidthCallback()
		{
			public int invoke(boolean valid, GetEdgeWidthCallback old)
			{
				return valid ? 5 : 3;
			}
		});

		connectionHandler.setCreateShapeCallback(new CreateShapeCallback()
		{
			public mxShape invoke(CreateShapeCallback old)
			{
				mxShape shape = old.invoke(null);
				shape.setDashed(false);
				return shape;
			}
		});

		final List<mxCellHighlight> highlights = new ArrayList<mxCellHighlight>();

		connectionHandler.addListener(mxEvent.START, new mxEventSource.mxIEventListener<Object>()
		{
			@Override
			public void invoke(Object sender, mxEventObject evt)
			{
				mxCellState state = (mxCellState) evt.getProperty("state");
				if (state != null)
				{
					List<mxICell> cells = getTargetsForCell(graph.getModel(), state.getCell());

					for (mxICell cell : cells)
					{
						mxCellHighlight hl = new mxCellHighlight(graph);
						hl.highlight(graph.getView().getState(cell, false));
						highlights.add(hl);
					}
				}

			}
		});

		connectionHandler.addListener(mxEvent.RESET, new mxEventSource.mxIEventListener<Object>()
		{
			@Override
			public void invoke(Object sender, mxEventObject evt)
			{
				if (highlights != null)
				{
					for (mxCellHighlight hl : highlights)
					{
						hl.destroy();
					}
					highlights.clear();
				}
			}
		});

	}

	private static List<mxICell> getTargetsForCell(mxGraphModel graphModel, mxICell cell)
	{

		List<mxICell> cells = new ArrayList<mxICell>();

		for (String key : graphModel.getCells().keySet())
		{
			mxICell candidate = graphModel.getCells().get(key);
			if (candidate != null && graphModel.isVertex(candidate) && !candidate.getValue().equals("Invalid target"))
			{
				cells.add(candidate);
			}
		}

		return cells;
	}

}

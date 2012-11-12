package com.mxgraph.gwt.showcase.client;

import java.util.Arrays;
import java.util.Map;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.SimplePanel;
import com.mxgraph.gwt.client.handler.mxGraphHandler;
import com.mxgraph.gwt.client.handler.mxGraphHandler.CreatePreviewShapeCallback;
import com.mxgraph.gwt.client.model.mxCell;
import com.mxgraph.gwt.client.model.mxGeometry;
import com.mxgraph.gwt.client.model.mxICell;
import com.mxgraph.gwt.client.shape.mxCylinder;
import com.mxgraph.gwt.client.shape.mxEllipse;
import com.mxgraph.gwt.client.shape.mxRectangleShape;
import com.mxgraph.gwt.client.shape.mxShape;
import com.mxgraph.gwt.client.util.mxConstants;
import com.mxgraph.gwt.client.util.mxRectangle;
import com.mxgraph.gwt.client.view.mxGraph;

public class CustomDragPreview extends AbstractContentWidget
{

	public CustomDragPreview(String name, Showcase showcase)
	{
		super(name, showcase);
		description = "The cells feature different drag previews depending on their shape.";
	}

	@Override
	public void injectContent(SimplePanel panel)
	{
		final mxGraph graph = new mxGraph();
		graph.getElement().getStyle().setBackgroundImage("url('images/grid.gif')");
		graph.getElement().getStyle().setHeight(100, Unit.PCT);
		Examples.loadDefaultStyle(graph);
		panel.setWidget(graph);

		mxICell dragMe = new mxCell("Drag me", new mxGeometry(0, 0, 150, 70), "ellipse");
		dragMe.setVertex(true);
		graph.importCells(Arrays.asList(dragMe), 150, 150, graph.getDefaultParent());

		dragMe = new mxCell("Drag me too!", new mxGeometry(0, 0, 150, 70), "shape=cylinder");
		dragMe.setVertex(true);
		graph.importCells(Arrays.asList(dragMe), 350, 150, graph.getDefaultParent());
		
		dragMe = new mxCell("And me", new mxGeometry(0, 0, 150, 70), "rounded");
		dragMe.setVertex(true);
		graph.importCells(Arrays.asList(dragMe), 550, 150, graph.getDefaultParent());

		final mxGraphHandler graphHandler = graph.getGraphHandler();

		graph.getGraphHandler().setCreatePreviewShapeCallback(new CreatePreviewShapeCallback()
		{
			@Override
			public mxShape invoke(mxRectangle bounds, CreatePreviewShapeCallback old)
			{
				mxICell cell = graphHandler.getCell();

				Map<String, String> stl = graph.getCellStyle(cell);
				String shapeType = stl.get("shape");
				mxShape shape = null;

				if (shapeType.equals("ellipse"))
				{
					shape = new mxEllipse(bounds, null, "black", null);
				}
				else if (shapeType.equals("cylinder"))
				{
					shape = new mxCylinder(bounds, null, "black", null);
				} else {
					shape = new mxRectangleShape(bounds, null, "black", null);
				}
				shape.setCrisp(true);
				shape.setDashed(true);
				shape.setDialect((!graph.getDialect().equals(mxConstants.DIALECT_SVG)) ? mxConstants.DIALECT_VML : mxConstants.DIALECT_SVG);
				shape.init(graph.getView().getOverlayPane());

				return shape;
			}
		});

	}

}

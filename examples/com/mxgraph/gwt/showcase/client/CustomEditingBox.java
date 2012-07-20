package com.mxgraph.gwt.showcase.client;

import java.util.Map;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.SimplePanel;
import com.mxgraph.gwt.client.model.mxICell;
import com.mxgraph.gwt.client.util.mxRectangle;
import com.mxgraph.gwt.client.view.mxCellEditor.GetEditorBoundsCallback;
import com.mxgraph.gwt.client.view.mxCellState;
import com.mxgraph.gwt.client.view.mxGraph;

public class CustomEditingBox extends AbstractContentWidget {

	public CustomEditingBox(String name, Showcase showcase) {
		super(name, showcase);
		description = "Demonstrates two ways of changing the size and the style of the cell editor's box. One via mxCellEditor style in the css file and the other via callback";

	}

	@Override public void injectContent(SimplePanel panel) {

		final mxGraph graph = new mxGraph();
		Examples.loadDefaultStyle(graph);

		panel.setWidget(graph);

		graph.getElement().getStyle().setBackgroundImage("url('images/grid.gif')");
		graph.getElement().getStyle().setHeight(100, Unit.PCT);

		graph.getModel().beginUpdate();

		try {
			graph.insertVertex(graph.getDefaultParent(), null, "Edit me!", 20, 20, 80, 30, "rounded=1;arcSize=20;");
			graph.insertVertex(graph.getDefaultParent(), null, "Edit me too!", 220, 20, 80, 30, "customCellEditor=1");
		} finally {
			graph.getModel().endUpdate();

		}

		graph.getCellEditor().setGetEditorBoundsCallback(new GetEditorBoundsCallback() {

			@Override public mxRectangle invoke(mxCellState state, GetEditorBoundsCallback old) {
				mxRectangle bounds = old.invoke(state, null);

				mxICell cell = state.getCell();
				Map<String, String> cellStyle = graph.getCellStyle(cell);

				// return customized edit boxes only for cells whose styles are flagged with 'customCellEditor'
				if (cellStyle.containsKey("customCellEditor") && cellStyle.get("customCellEditor").equals("1")) {
					bounds.setWidth(bounds.getWidth() * 1.5);
					bounds.setHeight(bounds.getHeight() * 1.5);

					bounds.setY(bounds.getY() + cell.getGeometry().getHeight() + 2);
					bounds.setX(cell.getGeometry().getX() - ((bounds.getWidth() - cell.getGeometry().getWidth()) / 2));
					// graph.getCellEditor().getTextArea().getStyle().setBackgroundColor("black");//it is possible to programmatically change the style of the
					// text area but doing so will change editing box for all cells!
				}

				return bounds;
			}
		});

	}

}

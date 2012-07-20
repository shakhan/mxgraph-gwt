package com.mxgraph.gwt.showcase.client;

import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.SimplePanel;
import com.mxgraph.gwt.client.mxClient;
import com.mxgraph.gwt.client.handler.mxRubberband;
import com.mxgraph.gwt.client.model.mxCell;
import com.mxgraph.gwt.client.util.mxEvent;
import com.mxgraph.gwt.client.util.mxMouseEvent;
import com.mxgraph.gwt.client.util.mxPanningHandler.ConsumePanningTriggerCallback;
import com.mxgraph.gwt.client.view.mxGraph;

public class LabelPositionWidget extends AbstractContentWidget {

	public LabelPositionWidget(String name, Showcase showcase) {
		super(name, showcase);
		description = "Using the label position styles to set the position of vertex labels. Also shows how to implements auto panning. Try dragging elements to the edge of the graph container.";
	}

	@Override public void injectContent(SimplePanel panel) {

		SimplePanel graphPanel = new SimplePanel();
		panel.setWidget(graphPanel);

		mxGraph graph = new mxGraph();
		graphPanel.setWidget(graph);
		// graph.setAllowAutoPanning(true);
		graph.setPanning(true);
		graph.getPanningHandler().setUseLeftButtonForPanning(true);
		graph.setGridEnabled(true);
		graph.getElement().getStyle().setWidth(600, Unit.PX);
		graph.getElement().getStyle().setHeight(400, Unit.PX);
		graph.getElement().getStyle().setBorderWidth(1, Unit.PX);
		graph.getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
		graph.getElement().getStyle().setBorderColor("#E5E5E5");
		graph.getElement().getStyle().setOverflow(Overflow.HIDDEN);// overflow must be set to hidden to allow auto panning!
		graph.getElement().getStyle().setBackgroundImage("url('images/grid2.gif')");
		//mxEvent.disableContextMenu(graph.getContainer());
		// new mxRubberband(graph);

		graph.getPanningHandler().setConsumePanningTriggerCallback(new ConsumePanningTriggerCallback() {

			@Override public void invoke(mxMouseEvent me, ConsumePanningTriggerCallback old) {
				
				// Sets local consumed state
				if (!mxClient.IS_SF && !mxClient.IS_MAC) {
					me.setConsumed(true);
					
				}
			}
		});

		// Gets the default parent for inserting new cells. This
		// is normally the first child of the root (ie. layer 0).
		mxCell parent = graph.getDefaultParent();

		// Defines the common part of all cell styles as a string-prefix
		String prefix = "shape=image;image=images/icons48/keys.png;";

		// Adds cells to the model in a single step and set the vertex
		// label positions using the label position styles. Vertical
		// and horizontal label position styles can be combined.
		// Note: Alternatively, vertex labels can be set be overriding
		// mxCellRenderer.getLabelBounds.
		graph.getModel().beginUpdate();
		try {
			graph.insertVertex(parent, null, "Bottom", 60, 60, 60, 60, prefix + "verticalLabelPosition=bottom;verticalAlign=top");
			graph.insertVertex(parent, null, "Top", 140, 60, 60, 60, prefix + "verticalLabelPosition=top;verticalAlign=bottom");
			graph.insertVertex(parent, null, "Left", 60, 160, 60, 60, prefix + "labelPosition=left;align=right");
			graph.insertVertex(parent, null, "Right", 140, 160, 60, 60, prefix + "labelPosition=right;align=left");
		} finally {
			// Updates the display
			graph.getModel().endUpdate();
		}

	}

}

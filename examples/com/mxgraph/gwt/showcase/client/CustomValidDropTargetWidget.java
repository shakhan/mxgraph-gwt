package com.mxgraph.gwt.showcase.client;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.SimplePanel;
import com.mxgraph.gwt.client.model.mxCell;
import com.mxgraph.gwt.client.model.mxGeometry;
import com.mxgraph.gwt.client.model.mxICell;
import com.mxgraph.gwt.client.view.mxGraph;
import com.mxgraph.gwt.client.view.mxGraph.IsValidDropTargetCallback;

public class CustomValidDropTargetWidget extends AbstractContentWidget {

	public CustomValidDropTargetWidget(String name, Showcase showcase) {
		super(name, showcase);
		description = "Shows how to implement custom Valid Target Handler. Try dropping 'Drag me' into both 'Container' and 'Not Container' vertices. Click the button and try again.";
	}

	@Override public void injectContent(SimplePanel panel) {
		final mxGraph graph = new mxGraph();
		final HorizontalPanel hp = new HorizontalPanel();
		final PushButton button = new PushButton("Click me");
		button.setTitle("Click on this button will cause all vertices to behave as containers(accept other vertices)");
		button.addClickHandler(new ClickHandler() {
			@Override public void onClick(ClickEvent event) {
				button.setEnabled(false);
				Label label = new Label("Good work! Now you can drag the 'Drag me' onto 'Not container'");
				label.getElement().getStyle().setMarginLeft(5, Unit.PX);
				label.getElement().getStyle().setMarginTop(3, Unit.PX);
				hp.add(label);
				graph.setIsValidDropTargetCallback(new IsValidDropTargetCallback() {
					@Override public boolean invoke(mxICell cell, List<mxICell> cells, NativeEvent event, IsValidDropTargetCallback old) {
						return true;//any vertex will now be a valid drop target
					}
				});
			}
		});

		hp.add(button);

		FlowPanel fp = new FlowPanel();
		fp.add(hp);
		fp.add(graph);
		panel.setWidget(fp);
		
		Examples.loadDefaultStyle(graph);

		graph.setFoldingEnabled(false);
		graph.setGridEnabled(true);
		graph.getElement().getStyle().setBackgroundImage("url('images/grid.gif')");
		fp.getElement().getStyle().setHeight(100, Unit.PCT);
		graph.getElement().getStyle().setHeight(100, Unit.PCT);

		graph.setDropEnabled(true);

		mxICell container = new mxCell("Container", new mxGeometry(0, 0, 160, 140), "swimlane");
		container.setVertex(true);
		graph.importCells(Arrays.asList(container), 20, 70, graph.getDefaultParent());

		mxICell notContainer = new mxCell("Not container", new mxGeometry(0, 0, 160, 140), "");
		notContainer.setVertex(true);
		graph.importCells(Arrays.asList(notContainer), 200, 70, graph.getDefaultParent());

		mxICell dragMe = new mxCell("Drag me", new mxGeometry(0, 0, 60, 60), "ellipse");
		dragMe.setVertex(true);
		graph.importCells(Arrays.asList(dragMe), 250, 250, graph.getDefaultParent());
	}
}

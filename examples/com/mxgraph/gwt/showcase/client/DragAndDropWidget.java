package com.mxgraph.gwt.showcase.client;

import java.util.Arrays;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.mxgraph.gwt.client.io.mxCodec;
import com.mxgraph.gwt.client.model.mxCell;
import com.mxgraph.gwt.client.model.mxGeometry;
import com.mxgraph.gwt.client.model.mxICell;
import com.mxgraph.gwt.client.util.mxDragSource.DropHandler;
import com.mxgraph.gwt.client.util.mxUtils;
import com.mxgraph.gwt.client.view.mxGraph;

public class DragAndDropWidget extends AbstractContentWidget {

	private static DragAndDropWidgetUiBinder uiBinder = GWT.create(DragAndDropWidgetUiBinder.class);

	interface DragAndDropWidgetUiBinder extends UiBinder<Widget, DragAndDropWidget> {
	}

	@UiField mxGraph graph;
	@UiField Image image1;
	@UiField Image image2;

	public DragAndDropWidget(String name, Showcase showcase) {
		super(name, showcase);
		description = "Drag and drop the items below onto the graph. They have different previews.";
	}

	@Override public void injectContent(SimplePanel panel) {

		panel.setWidget(uiBinder.createAndBindUi(this));// creates a widget defined via UiBinder and sets it on a panel

		graph.setGridEnabled(true);
		graph.getElement().getStyle().setHeight(100, Unit.PCT);

		Element node = mxUtils.load("resources/default-style2.xml").getDocumentElement();
		mxCodec decode = new mxCodec(node.getOwnerDocument());
		decode.decode(node, graph.getStylesheet());

		/**
		 * First image
		 */
		Element dragPreview1 = Document.get().createDivElement();
		Style style = dragPreview1.getStyle();
		style.setBorderWidth(1, Unit.PX);
		style.setBorderStyle(BorderStyle.DASHED);
		style.setBorderColor("black");
		style.setWidth(50, Unit.PX);
		style.setHeight(50, Unit.PX);

		final DropHandler image1Handler = new DropHandler() {
			@Override public void handleDrop(mxGraph graph, NativeEvent event, mxCell target, double x, double y) {
				mxICell iCell = new mxCell("", new mxGeometry(0, 0, 50, 50), "shape=image;image=images/icons48/earth.png");
				iCell.setVertex(true);
				graph.importCells(Arrays.asList(iCell), (int) x, (int) y, null);
			}
		};

		mxUtils.makeDraggable(image1.getElement(), graph, image1Handler, dragPreview1, 0, 0, graph.isAutoScroll(), false, false, null);

		/**
		 * Second image
		 */
		FocusPanel dragPreview2 = new FocusPanel();
		Image previewImage = new Image(image2.getUrl());
		previewImage.setHeight("100px");
		previewImage.setWidth("100px");
		dragPreview2.setWidget(previewImage);

		final DropHandler image2Handler = new DropHandler() {
			@Override public void handleDrop(mxGraph graph, NativeEvent event, mxCell target, double x, double y) {
				mxICell iCell = new mxCell("", new mxGeometry(0, 0, 100, 100), "shape=image;image=images/icons48/server.png");
				iCell.setVertex(true);
				graph.importCells(Arrays.asList(iCell), (int) x, (int) y, null);
			}
		};

		mxUtils.makeDraggable(image2.getElement(), graph, image2Handler, dragPreview2.getElement(), 0, 0, graph.isAutoScroll(), false, false, null);
	
	}

}

package com.mxgraph.gwt.showcase.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class Showcase extends Composite {

	@UiField FlowPanel examples;
	@UiField SimplePanel contentPanel;
	@UiField Label description;
	
	private static ShowcaseUiBinder uiBinder = GWT.create(ShowcaseUiBinder.class);

	interface ShowcaseUiBinder extends UiBinder<Widget, Showcase> {
	}

	public Showcase() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public void setDescription(String d) {
		description.setText(d);
	}
	
	public void add(AbstractContentWidget contentWidget) {
		examples.add(contentWidget);
	}
	
	public SimplePanel getContentPanel() {
		return contentPanel;
	}
}

package com.mxgraph.gwt.showcase.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.SimplePanel;

public abstract class AbstractContentWidget extends Composite {
	
	String description;

	public AbstractContentWidget(String name, final Showcase showcase) {
		
		initWidget(new PushButton(name));
		
		getWidget().addHandler(new ClickHandler() {
			@Override public void onClick(ClickEvent event) {
				showcase.setDescription(description);
				injectContent(showcase.getContentPanel());
			}
		}, ClickEvent.getType());
	}
	
	public abstract void injectContent(SimplePanel panel);

}

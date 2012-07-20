package com.mxgraph.gwt.client.util;

public class mxAnimation extends mxEventSource {

	/**
	 *  Starts the animation by repeatedly invoking updateAnimation.
	 */
	public native void startAnimation() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).startAnimation();
	}-*/;
}

package com.mxgraph.gwt.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.IJavaScriptWrapper;

public abstract class mxAbstractCanvas2D implements IJavaScriptWrapper {

	protected JavaScriptObject jso;
	
	@Override public JavaScriptObject getJso() {
		return jso;
	}

	@Override public void setJso(JavaScriptObject jso) {
		this.jso = jso;
	}
	
	/**
	 * Scales the current graphics object.
	 * 
	 * 
	 * @param value
	 */
	public native void scale(double value) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).scale(value);
	}-*/;

	/**
	 * Translates the current graphics object.
	 * 
	 * @param dx
	 * @param dy
	 */
	public native void translate(int dx, int dy) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).translate(dx, dy);
	}-*/;

}

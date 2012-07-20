package com.mxgraph.gwt.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.IJavaScriptWrapper;
import com.mxgraph.gwt.client.view.mxGraph;

/**
 * Implements a handler for panning.
 * 
 */
public class mxPanningManager implements IJavaScriptWrapper {

	private JavaScriptObject jso;

	@Override public JavaScriptObject getJso() {
		return jso;
	}

	@Override public void setJso(JavaScriptObject jso) {
		this.jso = jso;
	}

	private native JavaScriptObject createJso(JavaScriptObject graph) /*-{
		return new $wnd.mxPanningManager(graph);
	}-*/;
	
	private mxPanningManager() {
	}

	public mxPanningManager(mxGraph graph) {
		jso = createJso(graph.jso);
	}

	public native void panTo(int x, int y, int w, int h) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).panTo(x, y, w, h);
	}-*/;

}

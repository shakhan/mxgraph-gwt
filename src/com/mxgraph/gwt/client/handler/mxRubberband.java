package com.mxgraph.gwt.client.handler;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.IJavaScriptWrapper;
import com.mxgraph.gwt.client.view.mxGraph;

/**
 * Event handler that selects rectangular regions. This is not built-into <mxGraph>. To enable rubberband selection in a graph, use the following code.
 * 
 * Example:
 * 
 * (code) rubberband = new mxRubberband(graph); (end)
 * 
 */
public class mxRubberband implements IJavaScriptWrapper {

	private JavaScriptObject jso;

	private native JavaScriptObject createJso(JavaScriptObject graph) /*-{
		return new $wnd.mxRubberband(graph);
	}-*/;

	@Override public JavaScriptObject getJso() {
		return jso;
	}

	@Override public void setJso(JavaScriptObject jso) {
		this.jso = jso;
	}

	/**
	 * Constructs an event handler that selects rectangular regions in the graph using rubberband selection.
	 */
	public mxRubberband(mxGraph graph) {
		jso = createJso(graph.getJso());
	}

}

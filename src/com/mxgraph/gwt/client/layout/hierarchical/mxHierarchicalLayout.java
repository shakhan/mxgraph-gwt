package com.mxgraph.gwt.client.layout.hierarchical;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.layout.mxGraphLayout;
import com.mxgraph.gwt.client.view.mxGraph;

public class mxHierarchicalLayout extends mxGraphLayout {

	protected native JavaScriptObject createJso(JavaScriptObject graph) /*-{
		return new $wnd.mxHierarchicalLayout(graph);
	}-*/;

	public mxHierarchicalLayout(mxGraph graph) {
		jso = createJso(graph.getJso());
	}
}

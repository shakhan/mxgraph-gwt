package com.mxgraph.gwt.client.view;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.util.mxEventSource;

/**
 * Implements the selection model for a graph.
 * 
 * Event: mxEvent.UNDO
 * 
 * Fires after the selection was changed in <changeSelection>. The <code>edit</code> property contains the <mxUndoableEdit> which contains the
 * <mxSelectionChange>.
 * 
 * Event: mxEvent.CHANGE
 * 
 * Fires after the selection changes by executing an <mxSelectionChange>. The <code>added</code> and <code>removed</code> properties contain arrays of cells
 * that have been added to or removed from the selection, respectively.
 * 
 */
public class mxGraphSelectionModel extends mxEventSource {

	private native JavaScriptObject createJso(JavaScriptObject graph) /*-{
		return new $wnd.mxGraphSelectionModel(graph);
	}-*/;

	private mxGraphSelectionModel() {
	}

	/**
	 * Constructs a new graph selection model for the given {@link mxGraph}.
	 * 
	 * @param graph Reference to the enclosing {@link mxGraph}.
	 */
	public mxGraphSelectionModel(mxGraph graph) {
		jso = createJso(graph.getJso());
	}

}

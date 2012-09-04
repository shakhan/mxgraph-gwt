package com.mxgraph.gwt.client.handler;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.IJavaScriptWrapper;
import com.mxgraph.gwt.client.view.mxCellState;
import com.mxgraph.gwt.client.view.mxGraph;

/**
 * A helper class to highlight cells.
 *
 */
public class mxCellHighlight implements IJavaScriptWrapper
{
	private JavaScriptObject jso;

	private native JavaScriptObject createJso(JavaScriptObject graph) /*-{
		return new $wnd.mxCellHighlight(graph);
	}-*/;

	private native JavaScriptObject createJso(JavaScriptObject graph,
			String highlightColor, int strokeWidth) /*-{
		return new $wnd.mxCellHighlight(graph, highlightColor, strokeWidth);
	}-*/;

	@Override
	public JavaScriptObject getJso()
	{
		return jso;
	}

	@Override
	public void setJso(JavaScriptObject jso)
	{
		this.jso = jso;

	}

	public mxCellHighlight(mxGraph graph)
	{
		jso = createJso(graph.getJso());
	}

	public mxCellHighlight(mxGraph graph, String highlightColor, int strokeWidth)
	{
		jso = createJso(graph.getJso(), highlightColor, strokeWidth);
	}
	
	/**
	 * Marks the markedState and fires a mark event.
	 * 
	 * @param cellState
	 */
	public native void highlight(mxCellState cellState) /*-{
		var cellStateJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cellState);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).highlight(cellStateJS);
	}-*/;
	
	/**
	 * Destroys the handler and all its resources and DOM nodes.
	 */
	public native void destroy() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).destroy();
	}-*/;

}

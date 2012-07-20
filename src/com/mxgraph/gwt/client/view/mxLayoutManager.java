package com.mxgraph.gwt.client.view;

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.layout.mxGraphLayout;
import com.mxgraph.gwt.client.model.mxGraphModel.mxChange;
import com.mxgraph.gwt.client.model.mxICell;
import com.mxgraph.gwt.client.util.mxEventSource;

/**
 * Implements a layout manager that updates the layout for a given transaction.
 * 
 * 
 * Event: mxEvent.LAYOUT_CELLS
 * 
 * Fires between begin- and endUpdate after all cells have been laid out in <layoutCells>. The <code>cells</code> property contains all cells that have been
 * passed to <layoutCells>.
 * 
 * 
 */
public class mxLayoutManager extends mxEventSource {

	private native JavaScriptObject createJso(JavaScriptObject graph) /*-{
		return new $wnd.mxLayoutManager(@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(graph));
	}-*/;

	/**
	 * Constructs a new automatic layout for the given graph.
	 * 
	 * @param graph Reference to the enclosing graph.
	 */
	public mxLayoutManager(mxGraph graph) {
		this.jso = createJso(graph.getJso());
	}

	/**
	 * Returns the graph that this layout operates on.
	 * 
	 * @return the graph
	 */
	public native mxGraph getGraph() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getGraph());
	}-*/;

	/**
	 * Sets the graph that the layouts operate on.
	 * 
	 * @param graph the graph to set
	 */
	public native void setGraph(mxGraph graph) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this)
				.setGraph(@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(graph));
	}-*/;

	/**
	 * Returns true if a layout should bubble, that is, if the parent layout should be executed whenever a cell layout (layout of the children of a cell) has
	 * been executed. This implementation returns <bubbling>.
	 * 
	 * @return the bubbling
	 */
	public native boolean isBubbling() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isBubbling();
	}-*/;

	/**
	 * Sets bubbling.
	 * 
	 * @param bubbling the bubbling to set
	 */
	public native void setBubbling(boolean bubbling) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setBubbling(bubbling);
	}-*/;

	/**
	 * Returns true if events are handled. This implementation returns <enabled>.
	 * 
	 * @return the enabled
	 */
	public native boolean isEnabled() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isEnabled();
	}-*/;

	/**
	 * Enables or disables event handling. This implementation updates <enabled>.
	 * 
	 * @param enabled the enabled to set
	 */
	public native void setEnabled(boolean enabled) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setEnabled(enabled);
	}-*/;

	/**
	 * Sets the callback that handles the undo event.
	 * 
	 * @param listener
	 */
	public native void setUndoHandler(mxIEventListener<Object> listener) /*-{
		var listenerJS = listener != null ? @com.mxgraph.gwt.client.util.WrapperUtils::wrapCallbackInterface(Lcom/mxgraph/gwt/client/util/mxEventSource$mxIEventListener;)(listener)
				: null;
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).undoHandler = listenerJS;
	}-*/;

	/**
	 * Sets the callback that handles the move event.
	 * 
	 * @param listener
	 */
	public native void setMoveHandler(mxIEventListener<Object> listener) /*-{
		var listenerJS = listener != null ? @com.mxgraph.gwt.client.util.WrapperUtils::wrapCallbackInterface(Lcom/mxgraph/gwt/client/util/mxEventSource$mxIEventListener;)(listener)
				: null;
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).moveHandler = listenerJS;
	}-*/;

	/**
	 * Returns the cells to be laid out for the given sequence of changes.
	 * 
	 * @param changes
	 * @return
	 */
	public native List<mxICell> getCellsForChanges(List<mxChange> changes) /*-{
		var changesJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrapList(Ljava/util/List;)(changes);
		var cellsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getCellsForChanges(changesJS);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(cellsJS);
	}-*/;

	/**
	 * Returns the cells to be laid out for the given sequence of changes.
	 * 
	 * @param change
	 * @return
	 */
	public native List<mxICell> getCellsForChange(mxChange change) /*-{
		var changeJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(change);
		var cellsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getCellsForChange(changeJS);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(cellsJS);
	}-*/;

	/**
	 * Executes all layouts which have been scheduled during the changes.
	 * 
	 * @param cells
	 */
	public native void layoutCells(List<mxICell> cells) /*-{
		var cellsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrapList(Ljava/util/List;)(cells);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).layoutCells(cellsJS);
	}-*/;
	
	/**
	 * @param layout
	 * @param parent
	 */
	public native void executeLayout(mxGraphLayout layout, mxICell parent) /*-{
		var layoutJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(layout);
		var parentJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(parent);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).executeLayout(layoutJS, parentJS);
	}-*/;
	
	/**
	 * Removes all handlers from the <graph> and deletes the reference to it.
	 */
	public native void destroy() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).destroy();
	}-*/;
}

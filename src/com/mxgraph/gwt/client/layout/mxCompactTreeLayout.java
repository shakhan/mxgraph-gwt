package com.mxgraph.gwt.client.layout;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.model.mxCell;
import com.mxgraph.gwt.client.model.mxICell;
import com.mxgraph.gwt.client.view.mxGraph;

/**
 * Extends {@link mxGraphLayout} to implement a compact tree (Moen) algorithm. This layout is suitable for graphs that have no cycles (trees). Vertices that are
 * not connected to the tree will be ignored by this layout.
 * 
 * Example:
 * 
 * 
 * layout = new mxCompactTreeLayout(graph); layout.execute(graph.getDefaultParent());
 * 
 *
 */
public class mxCompactTreeLayout extends mxGraphLayout {

	private native JavaScriptObject createJso(JavaScriptObject graph, Boolean horizontal, Boolean invert) /*-{
		var horizontalJS = horizontal != null ? horizontal.@java.lang.Boolean::booleanValue()() : null;
		var invertJS = invert != null ? invert.@java.lang.Boolean::booleanValue()() : null;
		return new $wnd.mxCompactTreeLayout(graph, horizontalJS, invertJS);
	}-*/;

	/**
	 * Constructs a new compact tree layout for the specified graph and orientation.
	 * 
	 * @param graph
	 * @param horizontal
	 * @param invert
	 */
	public mxCompactTreeLayout(mxGraph graph, Boolean horizontal, Boolean invert) {
		this.jso = createJso(graph.getJso(), horizontal, invert);
	}

	/**
	 * If the parent has any connected edges, then it is used as the root of the tree. Else, <mxGraph.findTreeRoots> will be used to find a suitable root node
	 * within the set of children of the given parent.
	 * 
	 * @param parent {@link mxCell} whose children should be layed out.
	 * @param root Optional {@link mxCell} that will be used as the root of the tree.
	 */
	public native void execute(mxICell parent, mxICell root) /*-{
		var parentJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(parent);
		var rootJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(root);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).execute(parentJS, rootJS);
	}-*/;
	
	/**
	 * Gets the levelDistance. Default is 10.
	 * 
	 * @return the levelDistance
	 */
	public native int getLevelDistance() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).levelDistance;
	}-*/;

	/**
	 * Sets the levelDistance.
	 * 
	 * @param levelDistance the levelDistance to set
	 */
	public native void setLevelDistance(int levelDistance) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).levelDistance = levelDistance;
	}-*/;

	/**
	 * Returns the nodeDistance. Default is 20.
	 * 
	 * @return the nodeDistance
	 */
	public native int getNodeDistance() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).nodeDistance;
	}-*/;

	/**
	 * Gets the nodeDistance.
	 * 
	 * @param nodeDistance the nodeDistance to set
	 */
	public native void setNodeDistance(int nodeDistance) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).nodeDistance = nodeDistance;
	}-*/;
	
	

}

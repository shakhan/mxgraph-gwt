package com.mxgraph.gwt.client.layout;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.view.mxGraph;

public class mxFastOrganicLayout extends mxGraphLayout {

	protected native JavaScriptObject createJso(JavaScriptObject graph) /*-{
		return new $wnd.mxFastOrganicLayout(graph);
	}-*/;

	public mxFastOrganicLayout(mxGraph graph) {
		jso = createJso(graph.getJso());
	}

	/**
	 * Returns the force constant by which the attractive forces are divided and the repulsive forces are multiple by the square of. The value equates to the
	 * average radius there is of free space around each node. Default is 50.
	 * 
	 * @return
	 */
	public native int getForceConstant() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).forceConstant;
	}-*/;

	/**
	 * Sets new value for force constant
	 * 
	 * @param constant
	 */
	public native void setForceConstant(int constant) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).forceConstant = constant;
	}-*/;
}

package com.mxgraph.gwt.client.handler;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.IJavaScriptWrapper;
import com.mxgraph.gwt.client.view.mxGraph;

/**
 * Graph event handler that displays tooltips. <mxGraph.getTooltip> is used to get the tooltip for a cell or handle. This handler is built-into
 * <mxGraph.tooltipHandler> and enabled using <mxGraph.setTooltips>.
 * 
 * Example:
 * 
 * (code> new mxTooltipHandler(graph); (end)
 * 
 * Constructor: mxTooltipHandler
 * 
 * Constructs an event handler that displays tooltips with the specified delay (in milliseconds). If no delay is specified then a default delay of 500 ms (0.5
 * sec) is used.
 * 
 */
public class mxTooltipHandler implements IJavaScriptWrapper {

	private JavaScriptObject jso;

	@Override public JavaScriptObject getJso() {
		return jso;
	}

	@Override public void setJso(JavaScriptObject jso) {
		this.jso = jso;
	}

	private mxTooltipHandler() {
	}

	private native JavaScriptObject createJso(JavaScriptObject graph, Integer delay) /*-{
		var delayJS = delay != null ? delay.@java.lang.Integer::intValue() : null;
		return new $wnd.mxTooltipHandler(graph, delayJS);
	}-*/;

	/**
	 * @param graph Reference to the enclosing {@link mxGraph}.
	 * @param delay Optional delay in milliseconds.
	 */
	public mxTooltipHandler(mxGraph graph, Integer delay) {
		jso = createJso(graph.getJso(), delay);
	}

	/**
	 * Returns the delay for the the tooltip in milliseconds. Default is 500.
	 */
	public native int getDelay() /*-{       
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).delay;
	}-*/;

	/**
	 * Sets the delay for the the tooltip in milliseconds
	 */
	public native void setDelay(int delay) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).delay = delay;
	}-*/;

	/**
	 * Returns true if events are handled.
	 */
	public native boolean isEnabled() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).enabled;
	}-*/;

	/**
	 * Enables or disables event handling.
	 */
	public native void setEnabled(boolean enabled) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).enabled = enabled;
	}-*/;
	
	/**
	 * Hides the tooltip and resets the timer.
	 */
	public native void hide() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).hide();
	}-*/;

}

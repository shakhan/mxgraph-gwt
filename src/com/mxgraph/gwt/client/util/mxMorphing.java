package com.mxgraph.gwt.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.view.mxGraph;

/**
 * Implements animation for morphing cells. Here is an example of using this class for animating the result of a layout algorithm:
 * 
 * (code) graph.getModel().beginUpdate(); try { var circleLayout = new mxCircleLayout(graph); circleLayout.execute(graph.getDefaultParent()); } finally { var
 * morph = new mxMorphing(graph); morph.addListener(mxEvent.DONE, function() { graph.getModel().endUpdate(); });
 * 
 * morph.startAnimation(); } (end)
 * 
 */
public class mxMorphing extends mxAnimation {

	private native JavaScriptObject createJso(JavaScriptObject graph, Integer steps, Double ease, Integer delay) /*-{
		var stepsJS = steps != null ? steps.@java.lang.Integer::intValue()() : null;
		var easeJS = ease != null ? ease.@java.lang.Double::doubleValue()() : null;
		var delayJS = delay != null ? delay.@java.lang.Integer::intValue()() : null;
		return new $wnd.mxMorphing(graph, stepsJS, easeJS, delayJS);
	}-*/;

	private mxMorphing() {
	}
	
	/**
	 * @param graph Reference to the enclosing {@link mxGraph}.
	 * @param steps Optional number of steps in the morphing animation. Default is 6.
	 * @param ease Optional easing constant for the animation. Default is 1.5.
	 * @param delay Optional delay between the animation steps.
	 */
	public mxMorphing(mxGraph graph, Integer steps, Double ease, Integer delay) {
		jso = createJso(graph.jso, steps, ease, delay);
	}
}

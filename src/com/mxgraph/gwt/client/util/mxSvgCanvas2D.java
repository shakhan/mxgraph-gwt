package com.mxgraph.gwt.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.mxgraph.gwt.client.IJavaScriptWrapper;

/**
 * Implements a canvas to be used with <mxImageExport>. This canvas writes all calls as SVG output to the given SVG root node.
 * 
 * (code) var svgDoc = mxUtils.createXmlDocument(); var root = svgDoc.createElement('svg');
 * 
 * var bounds = graph.getGraphBounds(); root.setAttribute('width', (bounds.x + bounds.width + 4) + 'px'); root.setAttribute('height', (bounds.y + bounds.height
 * + 4) + 'px');
 * 
 * root.setAttribute('xmlns:xlink', mxConstants.NS_XLINK); root.setAttribute('xmlns', mxConstants.NS_SVG); root.setAttribute('version', '1.1');
 * 
 * svgDoc.appendChild(root);
 * 
 * var svgCanvas = new mxSvgCanvas2D(root); (end)
 * 
 */
public class mxSvgCanvas2D extends mxAbstractCanvas2D implements IJavaScriptWrapper {

	private native JavaScriptObject createJso(JavaScriptObject root, Boolean styleEnabled) /*-{
		return new $wnd.mxSvgCanvas2D(root, styleEnabled != null ? styleEnabled.@java.lang.Boolean::booleanValue()() : null);
	}-*/;

	/**
	 * Constructs an SVG canvas.
	 * 
	 * @param root SVG container for the output.
	 * @param styleEnabled Optional boolean that specifies if a style section should be added. The style section sets the default font-size, font-family and
	 *            stroke-miterlimit globally. Default is false.
	 */
	public mxSvgCanvas2D(Element root, Boolean styleEnabled) {
		jso = createJso(root, styleEnabled);
	}
}

package com.mxgraph.gwt.client.shape;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Node;
import com.mxgraph.gwt.client.util.mxRectangle;

/**
 * Extends {@link mxShape} to implement a rhombus (aka diamond) shape.
 * This shape is registered under {@link mxConstants#SHAPE_RHOMBUS}
 * in {@link mxCellRenderer}.
 *
 */
public class mxRhombus extends mxShape {

	private native JavaScriptObject createJso(mxRectangle bounds, String fill, String stroke, Integer strokeWidth) /*-{
		var boundsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(bounds);
		var strokeWidthJS = strokeWidth != null ? strokeWidth.@java.lang.Integer::intValue()() : null;
		return new $wnd.mxRhombus(boundsJS, fill, stroke, strokeWidthJS);
	}-*/;

	/**
	 * Constructs a new rhombus shape.
	 * 
	 * @param bounds {@link mxRectangle} that defines the bounds.
	 * @param fill String that defines the fill color.
	 * @param stroke String that defines the stroke color.
	 * @param strokeWidth Optional integer that defines the stroke width. Default is 1.
	 */
	public mxRhombus(mxRectangle bounds, String fill, String stroke, Integer strokeWidth) {
		jso = createJso(bounds, fill, stroke, strokeWidth);
	}
	
	/**
	 * Updates the path for the given SVG node.
	 * 
	 * @param node
	 */
	public native void updateSvgNode(Node node) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).updateSvgNode(node);
	}-*/;

}

package com.mxgraph.gwt.client.shape;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Node;
import com.mxgraph.gwt.client.util.mxRectangle;

/**
 * Extends {@link mxShape} to implement an ellipse shape.
 * This shape is registered under {@link mxConstants#SHAPE_ELLIPSE}
 * in {@link mxCellRenderer}.
 *
 */
public class mxEllipse extends mxShape {

	private native JavaScriptObject createJso(mxRectangle bounds, String fill, String stroke, Integer strokeWidth) /*-{
		var boundsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(bounds);
		var strokeWidthJS = strokeWidth != null ? strokeWidth.@java.lang.Integer::intValue()() : null;
		return new $wnd.mxEllipse(boundsJS, fill, stroke, strokeWidthJS);
	}-*/;

	/**
	 * Constructs a new ellipse.
	 * 
	 * @param bounds {@link mxRectangle} that defines the bounds.
	 * @param fill String that defines the fill color.
	 * @param stroke String that defines the stroke color.
	 * @param strokeWidth Optional integer that defines the stroke width. Default is 1.
	 */
	public mxEllipse(mxRectangle bounds, String fill, String stroke, Integer strokeWidth) {
		jso = createJso(bounds, fill, stroke, strokeWidth);
	}
	
	/**
	 * Updates the given node to reflect the new <bounds> and <scale>.
	 * @param node
	 */
	public native void updateSvgNode(Node node) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).updateSvgNode(node);
	}-*/;
}

package com.mxgraph.gwt.client.shape;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Node;
import com.mxgraph.gwt.client.util.mxRectangle;

/**
 * Extends {@link mxShape} to implement a swimlane shape. This shape is registered under {@link mxConstants#SHAPE_SWIMLANE} in {@link mxCellRenderer}.
 * 
 */
public class mxSwimlane extends mxShape {

	private native JavaScriptObject createJso(mxRectangle bounds, String fill, String stroke, Integer strokeWidth) /*-{
		var boundsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(bounds);
		var strokeWidthJS = strokeWidth != null ? strokeWidth.@java.lang.Integer::intValue()() : null;
		return new $wnd.mxSwimlane(boundsJS, fill, stroke, strokeWidthJS);
	}-*/;

	/**
	 * Constructs a new swimlane shape.
	 * 
	 * @param bounds {@link mxRectangle} that defines the bounds.
	 * @param fill String that defines the fill color.
	 * @param stroke String that defines the stroke color.
	 * @param strokeWidth Optional integer that defines the stroke width. Default is 1.
	 */
	public mxSwimlane(mxRectangle bounds, String fill, String stroke, Integer strokeWidth) {
		jso = createJso(bounds, fill, stroke, strokeWidth);
	}

	/**
	 * Gets the image height and width. Default is 16.
	 * 
	 * @return default image height and width
	 */
	public native int getImageSize() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).imageSize;
	}-*/;

	/**
	 * Sets the image height and width
	 * 
	 * @param imageSize
	 */
	public native void setImageSize(int imageSize) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).imageSize = imageSize;
	}-*/;

	/**
	 * Overrides to avoid filled contentPanel area in HTML and updates the shadow in SVG.
	 * 
	 * @param node
	 */
	public native void reconfigure(Node node) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).reconfigure(node);
	}-*/;

}

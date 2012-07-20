package com.mxgraph.gwt.client.shape;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.util.mxRectangle;

/**
 * Extends {@link mxShape} to implement a horizontal line shape. This shape is registered under {@link mxConstants#SHAPE_LINE} in {@link mxCellRenderer}.
 */
public class mxLine extends mxShape {

	private native JavaScriptObject createJso(mxRectangle bounds, String stroke, Integer strokeWidth) /*-{
		var boundsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(bounds);
		var strokeWidthJS = strokeWidth != null ? strokeWidth.@java.lang.Integer::intValue()() : null;
		return new $wnd.mxLine(boundsJS, fill, strokeWidthJS);
	}-*/;
	
	private mxLine(JavaScriptObject jso) {
		this.jso = jso;
	}

	/**
	 * Constructs a new line shape.
	 * 
	 * @param bounds {@link mxRectangle} that defines the bounds.
	 * @param stroke String that defines the stroke color.
	 * @param strokeWidth Optional integer that defines the stroke width. Default is 1.
	 */
	public mxLine(mxRectangle bounds, String stroke, Integer strokeWidth) {
		jso = createJso(bounds, stroke, strokeWidth);
	}
	
	/**
	 * Overrides the clone method to add special fields.
	 */
	public native mxLine clone() /*-{
		var cloneJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this);
		return @com.mxgraph.gwt.client.shape.mxLine::new(Lcom/google/gwt/core/client/JavaScriptObject;)(cloneJS);
	}-*/;
}

package com.mxgraph.gwt.client.shape;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.util.mxConstants;
import com.mxgraph.gwt.client.util.mxRectangle;

/**
 * Extends {@link mxShape} to implement a rectangle shape.
 * This shape is registered under {@link mxConstants#SHAPE_RECTANGLE}
 * in {@link mxCellRenderer}.
 */
public class mxRectangleShape extends mxShape {

	private native JavaScriptObject createJso(mxRectangle bounds,String fill,String stroke,Integer strokewidth) /*-{
		var boundsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(bounds);
		var strokeWidthJS = strokeWidth != null ? strokeWidth.@java.lang.Integer::intValue()() : null;
		return new $wnd.mxRectangleShape(boundsJS, fill, stroke, strokeWidth);
	}-*/;
	
	private mxRectangleShape() {
	}
	
	/**
	 * Constructs a new rectangle shape.
	 * 
	 * @param bounds {@link mxRectangle} that defines the bounds.
	 * @param fill String that defines the fill color.
	 * @param stroke String that defines the stroke color.
	 * @param strokeWidth Optional integer that defines the stroke width. Default is 1.
	 */
	public mxRectangleShape(mxRectangle bounds,String fill,String stroke,Integer strokewidth) {
		jso = createJso(bounds, fill, stroke, strokewidth);
	}

}

package com.mxgraph.gwt.client.shape;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.util.mxConstants;
import com.mxgraph.gwt.client.util.mxRectangle;

/**
 * Extends {@link mxShape} to implement an actor shape. If a custom shape with one filled area is needed, then this shape's <redrawPath> should be overridden.
 * 
 * Example:
 * 
 * (code) function SampleShape() { }
 * 
 * SampleShape.prototype = new mxActor(); SampleShape.prototype.constructor = vsAseShape;
 * 
 * mxCellRenderer.prototype.defaultShapes['sample'] = SampleShape; SampleShape.prototype.redrawPath = function(path, x, y, w, h) { path.moveTo(0, 0);
 * path.lineTo(w, h); // ... path.close(); } (end)
 * 
 * This shape is registered under {@link mxConstants#SHAPE_ACTOR} in {@link mxCellRenderer}.
 */
public class mxActor extends mxShape {

	private native JavaScriptObject createJso(mxRectangle bounds, String fill, String stroke, Integer strokeWidth) /*-{
		var boundsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(bounds);
		var strokeWidthJS = strokeWidth != null ? strokeWidth.@java.lang.Integer::intValue()() : null;
		return new $wnd.mxActor(boundsJS, fill, stroke, strokeWidthJS);
	}-*/;

	protected mxActor() {
	}

	/**
	 * Constructs a new actor shape.
	 * 
	 * @param bounds {@link mxRectangle} that defines the bounds.
	 * @param fill String that defines the fill color.
	 * @param stroke String that defines the stroke color.
	 * @param strokeWidth Optional integer that defines the stroke width. Default is 1.
	 */
	public mxActor(mxRectangle bounds, String fill, String stroke, Integer strokeWidth) {
		jso = createJso(bounds, fill, stroke, strokeWidth);
	}

	

}

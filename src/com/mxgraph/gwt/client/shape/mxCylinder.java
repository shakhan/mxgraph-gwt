package com.mxgraph.gwt.client.shape;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.util.mxPath;
import com.mxgraph.gwt.client.util.mxRectangle;
import com.mxgraph.gwt.client.view.mxCellState;

/**
 * Extends {@link mxShape} to implement an cylinder shape. If a custom shape with one filled area and an overlay path is needed, then this shape's <redrawPath>
 * should be overridden. This shape is registered under @{link mxConstants#SHAPE_CYLINDER} in {@link mxCellRenderer}.
 * 
 */
public class mxCylinder extends mxShape {

	private native JavaScriptObject createJso(mxRectangle bounds, String fill, String stroke, Integer strokeWidth) /*-{
		var boundsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(bounds);
		var strokeWidthJS = strokeWidth != null ? strokeWidth.@java.lang.Integer::intValue()() : null;
		return new $wnd.mxCylinder(boundsJS, fill, stroke, strokeWidthJS);
	}-*/;
	
	private native JavaScriptObject createJso() /*-{
		return new $wnd.mxCylinder();
	}-*/;
	
	/**
	 * Constructs a new cylinder shape.
	 */
	public mxCylinder() {
		
	}
	
	/**
	 * Constructs a new cylinder shape.
	 * 
	 * @param bounds @ mxRectangle} that defines the bounds.
	 * @param fill String that defines the fill color.
	 * @param stroke String that defines the stroke color.
	 * @param strokewidth Optional integer that defines the stroke width. Default is 1.
	 */
	public mxCylinder(mxRectangle bounds, String fill, String stroke, Integer strokewidth) {
		jso = createJso(bounds, fill, stroke, strokewidth);
	}

	/**
	 * Gets the maximum height of the top and bottom part of the cylinder shape.
	 * 
	 * @return max height
	 */
	public native int getMaxHeight() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).maxHeight;
	}-*/;

	/**
	 * Sets the maximum height of the top and bottom part of the cylinder shape.
	 * 
	 * @param maxHeight max height
	 */
	public native void setMaxHeight(int maxHeight) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).maxHeight = maxHeight;
	}-*/;

	/**
	 * Overrides the method to make sure the stroke is never null. If it is null is will be assigned the fill color.
	 * 
	 * @param cellState
	 */
	public native void create(mxCellState cellState) /*-{
		var cellStateJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cellstate);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).create(cellStateJS);
	}-*/;

	/**
	 * Draws the path for this shape. This method uses the <mxPath> abstraction to paint the shape for VML and SVG.
	 * 
	 * @param path
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param isForeground
	 */
	public native void redrawPath(mxPath path, double x, double y, double w, double h, boolean isForeground) /*-{
		var pathJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(path);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).redrawPath(pathJS, x, y, w, h, isForeground);
	}-*/;

}

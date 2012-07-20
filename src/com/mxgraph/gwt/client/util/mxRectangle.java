package com.mxgraph.gwt.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.model.mxPoint;

/**
 * Extends {@link mxPoint} to implement a 2-dimensional rectangle with double
 * precision coordinates.
 * @author jgraph
 *
 */
public class mxRectangle extends mxPoint {

	private static final long serialVersionUID = -1637392369314864148L;

	private native JavaScriptObject createJso() /*-{
		return new $wnd.mxRectangle();
	}-*/;

	private native JavaScriptObject createJso(double x, double y, double width, double height) /*-{
		return new $wnd.mxRectangle(x, y, width, height);
	}-*/;
	
	mxRectangle(JavaScriptObject jso) {
		this.jso = jso;
	}

	/**
	 * Constructs a new rectangle at (0, 0) with the width and height set to 0.
	 */
	public mxRectangle() {
		jso = createJso();
	}

	/**
	 * Constructs a rectangle using the given parameters.
	 * 
	 * @param x X-coordinate of the new rectangle.
	 * @param y Y-coordinate of the new rectangle.
	 * @param width Width of the new rectangle.
	 * @param height Height of the new rectangle.
	 */
	public mxRectangle(double x, double y, double width, double height) {
		jso = createJso(x, y, width, height);
	}

	/**
	 * Returns the height of the rectangle.
	 * 
	 * @return Returns the height.
	 */
	public native double getHeight() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).height;
	}-*/;

	/**
	 * Sets the height of the rectangle.
	 * 
	 * @param value Double that specifies the new height.
	 */
	public native void setHeight(double height) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).height = height;
	}-*/;

	/**
	 * Returns the width of the rectangle.
	 * 
	 * @return Returns the width.
	 */
	public native double getWidth() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).width;
	}-*/;


	/**
	 * Sets the width of the rectangle.
	 * 
	 * @param value Double that specifies the new width.
	 */
	public native void setWidth(double width) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).width = width;
	}-*/;
	
	/**
	 * Sets this rectangle to the specified values
	 * 
	 * @param x the new x-axis position
	 * @param y the new y-axis position
	 * @param w the new width of the rectangle
	 * @param h the new height of the rectangle
	 */
	public native void setRect(double x, double y, double w, double h) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setRect(x, y, w, h);
	}-*/;
	
	/**
	 * Returns the x-coordinate of the center.
	 * 
	 * @return Returns the x-coordinate of the center.
	 */
	public native double getCenterX() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getCenterX();
	}-*/;

	/**
	 * Returns the y-coordinate of the center.
	 * 
	 * @return Returns the y-coordinate of the center.
	 */
	public native double getCenterY() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getCenterY();
	}-*/;
	
	/**
	 * Adds the given rectangle to this rectangle.
	 */
	public native void add(mxRectangle rectangle) /*-{
		var jsRectangle = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(rectangle);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).add(jsRectangle);
	}-*/;
	
	/**
	 * Grows the rectangle by the given amount, that is, this method subtracts
	 * the given amount from the x- and y-coordinates and adds twice the amount
	 * to the width and height.
	 *
	 * @param amount Amount by which the rectangle should be grown.
	 */
	public native void grow(double amount) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).grow(amount);
	}-*/;
	
	/**
	 * Returns the top, left corner as a {@link mxPoint}
	 */
	public native mxPoint getPoint() /*-{
		var point = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getPoint();
		return new @com.mxgraph.gwt.client.model.mxPoint::new(Lcom/google/gwt/core/client/JavaScriptObject;)(point);
	}-*/;
}

package com.mxgraph.gwt.client.model;

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.util.WrapperUtils;
import com.mxgraph.gwt.client.util.mxRectangle;

/**
 * Represents the geometry of a cell. For vertices, the geometry consists of the x- and y-location, as well as the width and height. For edges, the geometry
 * either defines the source- and target-terminal, or it defines the respective terminal points.
 * 
 * For edges, if the geometry is relative (default), then the x-coordinate is used to describe the distance from the center of the edge from -1 to 1 with 0
 * being the center of the edge and the default value, and the y-coordinate is used to describe the absolute, orthogonal distance in pixels from that point. In
 * addition, the offset is used as an absolute offset vector from the resulting point.
 */
public class mxGeometry extends mxRectangle {

	private static final long serialVersionUID = -5223567179194422610L;

	private native JavaScriptObject createJSO() /*-{
		return new $wnd.mxGeometry();
	}-*/;

	private native JavaScriptObject createJSO(double x, double y, double width, double height) /*-{
		return new $wnd.mxGeometry(x, y, width, height);
	}-*/;

	/**
	 * Constructs a new geometry at (0, 0) with the width and height set to 0.
	 */
	public mxGeometry() {
		jso = createJSO();
	}

	/**
	 * Constructs a geometry using the given parameters.
	 * 
	 * @param x X-coordinate of the new geometry.
	 * @param y Y-coordinate of the new geometry.
	 * @param width Width of the new geometry.
	 * @param height Height of the new geometry.
	 */
	public mxGeometry(double x, double y, double width, double height) {
		jso = createJSO(x, y, width, height);
	}

	/**
	 * Returns the alternate bounds.
	 */
	public native mxRectangle getAlternateBounds() /*-{
		var jsRectangle = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).alternateBounds;
		return new @com.mxgraph.gwt.client.util.mxRectangle::new(Lcom/google/gwt/core/client/JavaScriptObject;)(jsRectangle);
	}-*/;

	/**
	 * Sets the alternate bounds to the given rectangle.
	 * 
	 * @param rect Rectangle to be used for the alternate bounds.
	 */
	public native void setAlternateBounds(mxRectangle rect) /*-{
		var jsRectangle = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(rect);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).alternateBounds = jsRectangle;
	}-*/;

	/**
	 * Returns the source point.
	 * 
	 * @return Returns the source point.
	 */
	public native mxPoint getSourcePoint() /*-{
		var jsPoint = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).sourcePoint;
		return new @com.mxgraph.gwt.client.model.mxPoint::new(Lcom/google/gwt/core/client/JavaScriptObject;)(jsPoint);
	}-*/;

	/**
	 * Sets the source point.
	 * 
	 * @param sourcePoint Source point to be used.
	 */
	public native void setSourcePoint(mxPoint sourcePoint) /*-{
		var jsPoint = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(sourcePoint);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).sourcePoint = jsPoint;
	}-*/;

	/**
	 * Returns the target point.
	 * 
	 * @return Returns the source point.
	 */
	public native mxPoint getTargetPoint() /*-{
		var jsPoint = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).targetPoint;
		return new @com.mxgraph.gwt.client.model.mxPoint::new(Lcom/google/gwt/core/client/JavaScriptObject;)(jsPoint);
	}-*/;

	/**
	 * Sets the source point.
	 * 
	 * @param sourcePoint Source point to be used.
	 */
	public native void setTargetPoint(mxPoint sourcePoint) /*-{
		var jsPoint = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(sourcePoint);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).targetPoint = jsPoint;
	}-*/;

	private native JavaScriptObject getPointsJS() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).points;
	}-*/;

	/**
	 * Returns the list of control points.
	 */

	public List<mxPoint> getPoints() {
		return WrapperUtils.wrapList(getPointsJS());
	}

	/**
	 * Sets the list of control points to the given list.
	 * 
	 * @param value List that contains the new control points.
	 */
	public native void setPoints(List<mxPoint> points) /*-{
		var jsList = @com.mxgraph.gwt.client.util.WrapperUtils::unwrapList(Ljava/util/List;)(points);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).points = jsList;
	}-*/;

	/**
	 * Returns the offset.
	 */
	public native mxPoint getOffset() /*-{
		var jsPoint = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).offset;
		return @com.mxgraph.gwt.client.model.mxPoint::new(Lcom/google/gwt/core/client/JavaScriptObject;)(jsPoint);
	}-*/;

	/**
	 * Sets the offset to the given point.
	 * 
	 * @param offset Point to be used for the offset.
	 */
	public native void setOffset(mxPoint point) /*-{
		var point = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(point);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).offset = point;
	}-*/;

	/**
	 * Returns true of the geometry is relative.
	 */
	public native boolean isRelative() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).relative;
	}-*/;

	/**
	 * Sets the relative state of the geometry.
	 * 
	 * @param value Boolean value to be used as the new relative state.
	 */
	public native void setRelative(boolean value) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).relative = value
	}-*/;

	/**
	 * Swaps the x, y, width and height with the values stored in <alternateBounds> and puts the previous values into <alternateBounds> as a rectangle. This
	 * operation is carried-out in-place, that is, using the existing geometry instance. If this operation is called during a graph model transactional change,
	 * then the geometry should be cloned before calling this method and setting the geometry of the cell using <mxGraphModel.setGeometry>.
	 */
	public native void swap() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).swap();
	}-*/;

	/**
	 * Returns the point representing the source or target point of this edge. This is only used if the edge has no source or target vertex.
	 * 
	 * @param isSource Boolean that specifies if the source or target point should be returned.
	 * @return Returns the source or target point.
	 */
	public native mxPoint getTerminalPoint(boolean isSource) /*-{
		var jsPoint = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getTerminalPoint();
		return new @com.mxgraph.gwt.client.model.mxPoint::new(Lcom/google/gwt/core/client/JavaScriptObject;)(jsPoint);
	}-*/;

	/**
	 * Sets the sourcePoint or targetPoint to the given point and returns the new point.
	 * 
	 * @param point Point to be used as the new source or target point.
	 * @param isSource Boolean that specifies if the source or target point should be set.
	 * @return Returns the new point.
	 */
	public native mxPoint setTerminalPoint(mxPoint point, boolean isSource) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setTerminalPoint(@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(point), isSource);
	}-*/;

	/**
	 * Translates the geometry by the specified amount. That is, x and y of the geometry, the sourcePoint, targetPoint and all elements of points are translated
	 * by the given amount. X and y are only translated if the geometry is not relative. If TRANSLATE_CONTROL_POINTS is false, then are not modified by this
	 * function.
	 * 
	 * @param dx Integer that specifies the x-coordinate of the translation.
	 * @param dy Integer that specifies the y-coordinate of the translation.
	 */
	public native void translate(double dx, double dy) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).translate(dx, dy);
	}-*/;

}

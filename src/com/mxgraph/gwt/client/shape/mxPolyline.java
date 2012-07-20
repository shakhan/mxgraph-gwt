package com.mxgraph.gwt.client.shape;

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Node;
import com.mxgraph.gwt.client.model.mxPoint;

/**
 * Extends {@link mxShape} to implement a polyline (a line with multiple points). This shape is registered under {@link mxConstants#SHAPE_POLYLINE} in
 * {@link mxCellRenderer}.
 * 
 */
public class mxPolyline extends mxShape {

	private native JavaScriptObject createJSO(List<mxPoint> points, String stroke, Integer strokeWidth) /*-{
		var strokeWidthJS = strokeWidth != null ? strokeWidth.@java.lang.Integer::intValue()() : null;

		var pointsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrapList(Ljava/util/List;)(points);
		return new $wnd.mxPolyline(pointsJS, stroke, strokeWidthJS);
	}-*/;

	/**
	 * Constructs a new polyline shape.
	 * 
	 * @param points Array of {@link mxPoints} that define the points.
	 * @param stroke String that defines the stroke color.
	 * @param strokeWidth Optional integer that defines the stroke width. Using null will default to 1.
	 */
	public mxPolyline(List<mxPoint> points, String stroke, Integer strokeWidth) {
		jso = createJSO(points, stroke, strokeWidth != null ? strokeWidth.intValue() : null);
	}

	/**
	 * Override to create HTML regardless of gradient and rounded property.
	 */
	public native Node create() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).create();
	}-*/;

}

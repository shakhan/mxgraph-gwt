package com.mxgraph.gwt.client.shape;

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.model.mxPoint;

/**
 * Extends {@link mxShape} to implement a connector shape. The connector shape allows for arrow heads on either side.
 * This shape is registered under {@link mxConstants#SHAPE_CONNECTOR} in {@link mxCellRenderer}.
 *
 */
public class mxConnector extends mxShape {
	
	private native JavaScriptObject createJSO(List<mxPoint> points, String stroke, Integer strokeWidth) /*-{
		var strokeWidthJS = strokeWidth != null ? strokeWidth.@java.lang.Integer::intValue()() : null;
		var pointsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrapList(Ljava/util/List;)(points);
		return new $wnd.mxConnector(pointsJS, stroke, strokeWidthJS);
	}-*/;
	
	/**
	 * @param points Array of {@link mxPoints} that define the points.
	 * @param stroke String that defines the stroke color.
	 * @param strokeWidth Optional integer that defines the stroke width.
	 */
	public mxConnector(List<mxPoint> points, String stroke, Integer strokeWidth) {
		jso = createJSO(points, stroke, strokeWidth);
	}


	/**
	 * Specifies if mxShape.crisp should be allowed for markers. Default is false.
	 * @return
	 */
	public native boolean isAllowCrispMarkers() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).allowCrispMarkers;
	}-*/;

	/**
	 * Sets new value for allowCrispMarkers
	 * @param allowCrispMarkers
	 */
	public native void setAllowCrispMarkers(boolean allowCrispMarkers) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).allowCrispMarkers = allowCrispMarkers;
	}-*/;
	
	public native void redrawMarker() /*-{
		//TODO ask for  parameter types
	}-*/;
}

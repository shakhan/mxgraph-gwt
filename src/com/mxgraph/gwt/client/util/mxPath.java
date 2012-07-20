package com.mxgraph.gwt.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.IJavaScriptWrapper;
import com.mxgraph.gwt.client.model.mxPoint;

public class mxPath implements IJavaScriptWrapper {
	
	protected JavaScriptObject jso;

	private native JavaScriptObject createJso(String format) /*-{
		return $wnd.mxPath(format);
	}-*/;

	public mxPath(String format) {
		jso = createJso(format);
	}
	
	@Override
	public JavaScriptObject getJso() {
		return jso;
	}

	@Override
	public void setJso(JavaScriptObject jso) {
		this.jso = jso;
	}

	/**
	 * Gets the format for the output of this path. Possible values are svg and vml.
	 * 
	 * @return format
	 */
	public native String getFormat() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).format;
	}-*/;

	/**
	 * Sets the format for the output of this path. Possible values are svg and vml.
	 * 
	 * @param format new format
	 */
	public native void setFormat(String format) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).format = format;
	}-*/;

	/**
	 * Returns the {@link mxPoint} that specifies the translation of the complete path.
	 * 
	 * @return mxPoint
	 */
	public native mxPoint getTranslate() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).translate;
	}-*/;

	/**
	 * Set the global translation of this path, that is, the origin of the coordinate system.
	 * 
	 * @param translate point of the new origin
	 */
	public native void setTranslate(mxPoint translate) /*-{
		var translateJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(translate);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).translate = translateJS;
	}-*/;

	/**
	 * Set the global translation of this path, that is, the origin of the coordinate system.
	 * 
	 * @param x X-coordinate of the new origin.
	 * @param y Y-coordinate of the new origin.
	 */
	public native void setTranslate(double x, double y) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setTranslate(x, y);
	}-*/;

	/**
	 * Returns string that represents the path in <format>.
	 * 
	 * @return path
	 */
	public native String getPath() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getPath();
	}-*/;

	/**
	 * Sets the textual representation of the path as an array.
	 * 
	 * @param path new path
	 */
	public native void setPath(String path) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).path = path;
	}-*/;

	/**
	 * Returns true if <format> is vml.
	 * 
	 * @return
	 */
	public native boolean isVml() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isVml();
	}-*/;

	/**
	 * Moves the cursor to (x, y).
	 * 
	 * @param x X-coordinate of the new cursor location.
	 * @param y Y-coordinate of the new cursor location.
	 */
	public native void moveTo(double x, double y) /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).moveTo(x, y);
	}-*/;

	/**
	 * Draws a straight line from the current point to (x, y).
	 * 
	 * @param x X-coordinate of the endpoint.
	 * @param y Y-coordinate of the endpoint.
	 */
	public native void lineTo(double x, double y) /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).lineTo(x, y);
	}-*/;

	/**
	 * Draws a quadratic Bézier curve from the current point to (x, y) using (x1, y1) as the control point.
	 * 
	 * @param x1 X-coordinate of the control point.
	 * @param y1 Y-coordinate of the control point.
	 * @param x X-coordinate of the endpoint.
	 * @param y Y-coordinate of the endpoint.
	 */
	public native void quadTo(double x1, double y1, double x, double y) /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).quadTo(x1, y1, x, y);
	}-*/;

	/**
	 * Draws a cubic Bézier curve from the current point to (x, y) using (x1, y1) as the control point at the beginning of the curve and (x2, y2) as the control
	 * point at the end of the curve.
	 * 
	 * @param x1 X-coordinate of the first control point.
	 * @param y1 Y-coordinate of the first control point.
	 * @param x2 X-coordinate of the second control point.
	 * @param y2 Y-coordinate of the second control point.
	 * @param x X-coordinate of the endpoint. 
	 * @param y Y-coordinate of the endpoint.
	 */
	public native void curveTo(double x1, double y1, double x2, double y2, double x, double y) /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).curveTo(x1, y1, x2, y2, x, y);
	}-*/;

	/**
	 *  Writes directly into the path. This bypasses all conversions.
	 * @param string
	 */
	public native void write(String string) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).write(string);
	}-*/;

	/**
	 * Ends the path.
	 */
	public native void end() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).end();
	}-*/;

	/**
	 * Closes the path.
	 */
	public native void close() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).close();
	}-*/;

}

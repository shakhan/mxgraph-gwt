package com.mxgraph.gwt.client.view;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.IJavaScriptWrapper;
import com.mxgraph.gwt.client.model.mxPoint;

/**
 * Defines an object that contains the constraints about how to connect one side of an edge to its terminal.
 * 
 */
public class mxConnectionConstraint implements IJavaScriptWrapper {

	protected JavaScriptObject jso;

	private native JavaScriptObject createJso(mxPoint point, Boolean perimeter) /*-{

		var pointJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(point);
		var perimeterJS = perimeter != null ? perimeter.@java.lang.Boolean::booleanValue()() : null;

		return new $wnd.mxConnectionConstraint(pointJS, perimeterJS);
	}-*/;

	protected mxConnectionConstraint() {
	}

	/**
	 * @param point Optional {@link mxPoint} that specifies the fixed location of the point in relative coordinates. Default is null.
	 * @param perimeter
	 */
	public mxConnectionConstraint(mxPoint point, Boolean perimeter) {
		jso = createJso(point, perimeter);
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
	 * Returns the {@link mxPoint} that specifies the fixed location of the connection point.
	 * 
	 * @return point
	 */
	public native mxPoint getPoint() /*-{
		var pointJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).point;
		return @com.mxgraph.gwt.client.model.mxPoint::new(Lcom/google/gwt/core/client/JavaScriptObject;)(pointJS);
	}-*/;

	/**
	 * Sets the {@link mxPoint} that specifies the fixed location of the connection point.
	 * 
	 * @param point
	 */
	public native void setPoint(mxPoint point) /*-{
		var pointJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(point).point;
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).point = pointJS;
	}-*/;

	/**
	 * Returns the boolean that specifies if the point should be projected onto the perimeter of the terminal.
	 * 
	 * @return
	 */
	public native boolean isPerimeter() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).point.perimeter;
	}-*/;

	/**
	 * Sets the boolean that specifies if the point should be projected onto the perimeter of the terminal.
	 * 
	 * @param perimeter
	 */
	public native void setPerimeter(boolean perimeter) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).point.perimeter = perimeter;
	}-*/;

}

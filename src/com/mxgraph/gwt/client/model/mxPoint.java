package com.mxgraph.gwt.client.model;

import java.io.Serializable;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.IJavaScriptWrapper;

/**
 * Implements a 2-dimensional vector with double precision coordinates.
 */
public class mxPoint implements IJavaScriptWrapper, Serializable, Cloneable {

	private static final long serialVersionUID = -7839779278842309010L;
	
	protected JavaScriptObject jso;
	
	private native JavaScriptObject createJSO() /*-{
		return new $wnd.mxPoint();
	}-*/;
	
	private native JavaScriptObject createJSO(double x, double y) /*-{
		return new $wnd.mxPoint(x, y);
	}-*/;
	
	mxPoint(JavaScriptObject jso) {
		this.jso = jso;
	}
	
	/**
	 * Constructs a new point at the location of the given point.
	 * 
	 * @param point Point that specifies the location.
	 */
	public mxPoint() {
		jso = createJSO();
	}
	
	/**
	 * Constructs a new point at (x, y).
	 * 
	 * @param x X-coordinate of the point to be created.
	 * @param y Y-coordinate of the point to be created.
	 */
	public mxPoint(double x, double y) {
		jso = createJSO(x, y);
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
	 * Returns true if the given JavaScript object equals this point.
	 */
	private native boolean equals(JavaScriptObject obj) /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).equals(obj);
	}-*/;
	
	/**
	 * Returns true if the given object equals this point.
	 */
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof mxPoint) {
			mxPoint point = (mxPoint)obj;
			return equals(point.jso);
		}
		
		return false;
	}

	/**
	 * Returns a new instance of the same point.
	 */
	public native mxPoint clone() /*-{
		var clone =  @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).clone();
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(clone);
	}-*/;

	/**
	 * Returns the x-coordinate of the point.
	 * 
	 * @return Returns the x-coordinate.
	 */
	public native double getX() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).x;
	}-*/;

	/**
	 * Sets the x-coordinate of the point.
	 * 
	 * @param value Double that specifies the new x-coordinate.
	 */
	public native void setX(double x) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).x = x;
	}-*/;


	/**
	 * Returns the y-coordinate of the point.
	 * 
	 * @return Returns the y-coordinate.
	 */
	public native double getY() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).y;
	}-*/;

	/**
	 * Sets the y-coordinate of the point.
	 * 
	 * @param value Double that specifies the new y-coordinate.
	 */
	public native void setY(double y) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).y = y;
	}-*/;

}

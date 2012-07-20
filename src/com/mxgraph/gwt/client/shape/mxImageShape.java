package com.mxgraph.gwt.client.shape;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.mxgraph.gwt.client.util.mxRectangle;

public class mxImageShape extends mxShape {

	private native JavaScriptObject createJso(mxRectangle bounds, String image, String fill, String stroke, Integer strokeWidth) /*-{
		var boundsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(bounds);
		var strokeWidthJS = strokeWidth != null ? strokeWidth.@java.lang.Integer::intValue()() : null;
		return new $wnd.mxImageShape(boundsJS, image, fill, stroke, strokeWidthJS);
	}-*/;

	/**
	 * Constructs a new image shape.
	 * 
	 * @param bounds {@link mxRectangle} that defines the bounds.
	 * @param image String that specifies the URL of the image.
	 * 
	 */
	public mxImageShape(mxRectangle bounds, String image) {
		this(bounds, image, null, null, null); 
	}
	
	/**
	 * Constructs a new image shape.
	 * 
	 * @param bounds {@link mxRectangle} that defines the bounds.
	 * @param image String that specifies the URL of the image.
	 * @param fill String that defines the fill color.
	 * @param stroke String that defines the stroke color.
	 * @param strokeWidth Optional integer that defines the stroke width. Default is 1.
	 */
	public mxImageShape(mxRectangle bounds, String image, String fill, String stroke, Integer strokeWidth) {
		jso = createJso(bounds, image, fill, stroke, strokeWidth);
	}

	/**
	 * Returns value preserve image aspect switch.
	 * 
	 * @return true if image aspect should be preserved, false otherwise
	 */
	public native boolean isPreserveImageAspect() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).preserveImageAspect;
	}-*/;

	/**
	 * Sets new value for preserveImageAspect switch
	 * 
	 * @param preserveImageAspect
	 */
	public native void setPreserveImageAspect(boolean preserveImageAspect) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).preserveImageAspect = preserveImageAspect;
	}-*/;

	/**
	 * Override to create HTML regardless of gradient and rounded property.
	 */
	public native Element create() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).create();
	}-*/;

	/**
	 * Updates the aspect of the image for the given image width and height.
	 * 
	 * @param width image width
	 * @param height image height
	 */
	public native void updateAspect(double width, double height) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).updateAspect(width, heigth);
	}-*/;

	/**
	 * Schedules an asynchronous {@link #updateAspect} using the current image.
	 */
	public native void scheduleUpdateAspect() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).scheduleUpdateAspect();
	}-*/;

	/**
	 * Workaround for security warning in IE if this is used in the overlay pane of a diagram.
	 */
	public native void configureTransparentBackground() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).configureTransparentBackground();
	}-*/;

}

package com.mxgraph.gwt.client.shape;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.util.mxRectangle;

/**
 * Extends {@link mxShape} to implement an image shape with a label.
 * This shape is registered under {@link mxConstants#SHAPE_LABEL} in
 * {@link mxCellRenderer}.
 *
 */
public class mxLabel extends mxShape {

	private native JavaScriptObject createJso(mxRectangle bounds, String fill, String stroke, Integer strokeWidth) /*-{
		var boundsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(bounds);
		var strokeWidthJS = strokeWidth != null ? strokeWidth.@java.lang.Integer::intValue()() : null;
		return new $wnd.mxLabel(boundsJS, fill, stroke, strokeWidthJS);
	}-*/;
	
	protected mxLabel()
	{
		super();
	}

	/**
	 * Constructs a new label shape.
	 * 
	 * @param bounds {@link mxRectangle} that defines the bounds.
	 * @param fill String that defines the fill color.
	 * @param stroke String that defines the stroke color.
	 * @param strokeWidth Optional integer that defines the stroke width. Default is 1.
	 */
	public mxLabel(mxRectangle bounds, String fill, String stroke, Integer strokeWidth) {
		jso = createJso(bounds, fill, stroke, strokeWidth);
	}
	
	/**
	 * Returns default width and height for the image. Default is {@link mxConstants#DEFAULT_IMAGESIZE}.
	 * @return
	 */
	public native int getImageSize() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).imageSize;
	}-*/;

	/**
	 * Sets new default width and height for the image
	 * @param imageSize
	 */
	public native void setImageSize(int imageSize) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).imageSize = imageSize;
	}-*/;

	/**
	 * Gets default value for spacing. Default is 2.
	 * @return
	 */
	public native int getSpacing() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).spacing;
	}-*/;

	/**
	 * Sets new default value for spacing.
	 * @param spacing
	 */
	public native void setSpacing(int spacing) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).spacing = spacing;
	}-*/;

	/**
	 * Default width and height for the indicator. Default is 10.
	 * @return
	 */
	public native int getIndicatorSize() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).indicatorSize;
	}-*/;

	/**
	 * Sets default width and height for the indicator.
	 * @param indicatorSize
	 */
	public native void setIndicatorSize(int indicatorSize) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).indicatorSize = indicatorSize;
	}-*/;

	/**
	 * Gets default spacing between image and indicator. Default is 2.
	 * @return
	 */
	public native int getIndicatorSpacing() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).indicatorSpacing;
	}-*/;

	/**
	 * Sets default spacing between image and indicator.
	 * @param indicatorSpacing
	 */
	public native void setIndicatorSpacing(int indicatorSpacing) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).indicatorSpacing = indicatorSpacing;
	}-*/;
	
	
	

}

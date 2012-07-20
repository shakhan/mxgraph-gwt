package com.mxgraph.gwt.client.layout;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.model.mxCell;
import com.mxgraph.gwt.client.model.mxGeometry;
import com.mxgraph.gwt.client.view.mxGraph;

/**
 * Extends {@link mxGraphLayout} to create a horizontal or vertical stack of the child vertices. The children do not need to be connected for this layout to
 * work.
 * 
 * Example:
 * 
 * (code) layout = new mxStackLayout(graph, true); layout.execute(graph.getDefaultParent()); (end)
 * 
 */
public class mxStackLayout extends mxGraphLayout {

	private native JavaScriptObject createJso(JavaScriptObject graph, Boolean horizontal, Integer spacing, Integer x0, Integer y0, Integer border) /*-{
		var h = horizontal != null ? horizontal.@java.lang.Boolean::booleanValue() : null;
		var s = spacing != null ? spacing.@java.lang.Integer::intValue() : null;
		var x = x0 != null ? x0.@java.lang.Integer::intValue() : null;
		var y = y0 != null ? y0.@java.lang.Integer::intValue() : null;
		var b = border != null ? border.@java.lang.Integer::intValue() : null;

		return new $wnd.mxStackLayout(graph, h, s, x, y, b);
	}-*/;

	/**
	 * Constructs a new stack layout layout for the specified graph, spacing, orientation and offset.
	 * 
	 * @param graph
	 * @param horizontal
	 * @param spacing
	 * @param x0
	 * @param y0
	 * @param border
	 */
	public mxStackLayout(mxGraph graph, Boolean horizontal, Integer spacing, Integer x0, Integer y0, Integer border) {
		jso = createJso(graph.getJso(), horizontal, spacing, x0, y0, border);
	}

	/**
	 * Gets the orientation of the layout. Default is true.
	 * 
	 * @return
	 */
	public native boolean isHorizontal() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isHorizontal();
	}-*/;

	/**
	 * Specifies the new orientation of the layout.
	 * 
	 * @param horizontal
	 */
	public native void setHorizontal(boolean horizontal) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).horizontal = horizontal;
	}-*/;

	/**
	 * Gets the spacing between the cells. Default is 0.
	 * 
	 * @return
	 */
	public native int getSpacing() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).spacing;
	}-*/;

	/**
	 * Specifies the spacing between the cells.
	 * 
	 * @param spacing
	 */
	public native void setSpacing(int spacing) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).spacing = spacing;
	}-*/;

	/**
	 * Gets the horizontal origin of the layout. Default is 0.
	 * 
	 * @return
	 */
	public native int getX0() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).x0;
	}-*/;

	/**
	 * Specifies the horizontal origin of the layout.
	 * 
	 * @param x0
	 */
	public native void setX0(int x0) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).x0 = x0;
	}-*/;

	/**
	 * Gets the vertical origin of the layout. Default is 0.
	 * 
	 * @return
	 */
	public native int getY0() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).y0;
	}-*/;

	/**
	 * Specifies the vertical origin of the layout.
	 * 
	 * @param y0
	 */
	public native void setY0(int y0) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).y0 = y0;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native int getBorder() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).border;
	}-*/;

	/**
	 * @param border
	 */
	public native void setBorder(int border) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).border = border;
	}-*/;

	/**
	 * Boolean indicating if the location of the first cell should be kept, that is, it will not be moved to x0 or y0.
	 * 
	 * @return
	 */
	public native boolean isKeepFirstLocation() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).keepFirstLocation;
	}-*/;

	/**
	 * @param keepFirstLocation
	 */
	public native void setKeepFirstLocation(boolean keepFirstLocation) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).keepFirstLocation = keepFirstLocation;
	}-*/;

	/**
	 * Boolean indicating if dimension should be changed to fill out the parent cell. Default is false.
	 * 
	 * @return
	 */
	public native boolean isFill() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).fill;
	}-*/;

	/**
	 * @param fill
	 */
	public native void setFill(boolean fill) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).fill = fill;
	}-*/;

	/**
	 * If the parent should be resized to match the width/height of the stack. Default is false.
	 * 
	 * @return
	 */
	public native boolean isResizeParent() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).resizeParent;
	}-*/;

	/**
	 * @param resizeParent
	 */
	public native void setResizeParent(boolean resizeParent) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).resizeParent = resizeParent;
	}-*/;

	/**
	 * Value at which a new column or row should be created. Default is null.
	 * 
	 * @return
	 */
	public native int getWrap() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).wrap;
	}-*/;

	/**
	 * @param wrap
	 */
	public native void setWrap(int wrap) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).wrap = wrap;
	}-*/;

	/**
	 * Returns the size for the parent container or the size of the graph container if the parent is a layer or the root of the model.
	 * 
	 * @param parent
	 * @return
	 */
	public native mxGeometry getParentSize(mxCell parent) /*-{
		var parentJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(parent);
		var parentSizeJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getParentSize(parentJS);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(parentSizeJS);
	}-*/;

}

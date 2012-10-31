package com.mxgraph.gwt.client.shape;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Node;
import com.google.gwt.user.client.Element;
import com.mxgraph.gwt.client.model.mxPoint;
import com.mxgraph.gwt.client.util.mxConstants;
import com.mxgraph.gwt.client.util.mxRectangle;

/**
 * Extends {@link mxShape} to implement a text shape.
 * 
 */
public class mxText extends mxShape {

	public native JavaScriptObject createJso(String value, mxRectangle bounds, String align, String valign, String color, String family, int size,
			String fontStyle, int spacing, int spacingTop, int spacingRight, int spacingBottom, int spacingLeft, boolean horizontal, String background,
			String border, boolean wrap, boolean clipped, String overflow) /*-{

		var boundsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(bounds);

		return new $wnd.mxText(value, boundsJS, align, valign, color, family, size, fontStyle, spacing, spacingTop, spacingRight, spacingBottom, spacingLeft,
				horizontal, background, border, wrap, clipped, overflow);

	}-*/;
	
	protected mxText()
	{
		super();
	}

	/**
	 * Constructs a new text shape.
	 * 
	 * @param value String that represents the text to be displayed.
	 * @param bounds {@link mxRectangle} that defines the bounds.
	 * @param align Specifies the horizontal alignment. Default is ''.
	 * @param valign Specifies the vertical alignment. Default is ''.
	 * @param color String that specifies the text color. Default is 'black'.
	 * @param family String that specifies the font family. Default is {@link mxConstants#DEFAULT_FONTFAMILY}.
	 * @param size Integer that specifies the font size. Default is {@link mxConstants#DEFAULT_FONTSIZE}.
	 * @param fontStyle Specifies the font style. Default is 0.
	 * @param spacing Integer that specifies the global spacing. Default is 2.
	 * @param spacingTop Integer that specifies the top spacing. Default is 0.
	 * @param spacingRight Integer that specifies the right spacing. Default is 0.
	 * @param spacingBottom Integer that specifies the bottom spacing. Default is 0.
	 * @param spacingLeft Integer that specifies the left spacing. Default is 0.
	 * @param horizontal Boolean that specifies if the label is horizontal. Default is true.
	 * @param background String that specifies the background color. Default is null.
	 * @param border String that specifies the label border color. Default is null.
	 * @param wrap Specifies if word-wrapping should be enabled. Default is false.
	 * @param clipped Specifies if the label should be clipped. Default is false.
	 * @param overflow Value of the overflow style. Default is 'visible'.
	 */
	public mxText(String value, mxRectangle bounds, String align, String valign, String color, String family, int size, String fontStyle, int spacing,
			int spacingTop, int spacingRight, int spacingBottom, int spacingLeft, boolean horizontal, String background, String border, boolean wrap,
			boolean clipped, String overflow) {
		jso = createJso(value, bounds, align, valign, color, family, size, fontStyle, spacing, spacingTop, spacingRight, spacingBottom, spacingLeft,
				horizontal, background, border, wrap, clipped, overflow);
	}

	/**
	 * Returns true if the given font style (bold, italic etc) is true in this shape's fontStyle.
	 * 
	 * @param style Fontstyle constant from {@link mxConstants}.
	 * @return
	 */
	public native boolean isStyleSet(String style) /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isStyleSet(style);
	}-*/;

	/**
	 * Creates and returns the foreignObject node to represent this shape.
	 * 
	 * @return foreignObject node
	 */
	public native Node createForeignObject() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).createForeignObject();
	}-*/;

	/**
	 * Returns the description of the space between the <bounds> size and the label size as an {@link mxPoint}.
	 * 
	 * @param outerWidth
	 * @param outerHeight
	 * @param actualWidth
	 * @param actualHeight
	 * @param horizontal
	 * @return
	 */
	public native mxPoint getOffset(double outerWidth, double outerHeight, double actualWidth, double actualHeight, boolean horizontal) /*-{
		var offsetJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getOffset(outerWidth, outerHeight, actualWidth, actualHeight, horizontal);
		return @com.mxgraph.gwt.client.model.mxPoint::new(Lcom/google/gwt/core/client/JavaScriptObject;)(offsetJS);
	}-*/;

	/**
	 * Returns the spacing as an {@link mxPoint}.
	 * 
	 * @param horizontal
	 * @return spacing as an instance of {@link mxPoint}
	 */
	public native mxPoint getSpacing(boolean horizontal) /*-{
		var spacingJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getSpacing(horizontal);
		return @com.mxgraph.gwt.client.model.mxPoint::new(Lcom/google/gwt/core/client/JavaScriptObject;)(spacingJS);
	}-*/;

	/**
	 * Creates and returns a HTML table with a table body and a single row with a single cell.
	 * 
	 * @return HTML table
	 */
	public native Element createHtmlTable() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).createHtmlTable();
	}-*/;

	/**
	 * Updates the style of the given HTML table and the value within the table.
	 * 
	 * @param table table for update
	 * @param scale
	 */
	public native void updateHtmlTable(Element table, double scale) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).updateHtmlTable(table, scale);
	}-*/;

	/**
	 * Updates the width of the given HTML table.
	 * 
	 * @param table table for update
	 */
	public native void updateHtmlTableWidth(Element table) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).updateHtmlTableWidth(table);
	}-*/;

	/**
	 * Redraws the textbox for this text. This is only used in IE in exact rendering mode.
	 */
	public native void redrawTextbox() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).redrawTextbox();
	}-*/;

	/**
	 * Redraws the HTML table. This is used for HTML labels in all modes except exact in IE and if NO_FO is false for the browser.
	 */
	public native void redrawHtmlTable() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).redrawHtmlTable();
	}-*/;

	/**
	 * Redraws the foreign object for this text.
	 */
	public native void redrawForeignObject() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).redrawForeignObject();
	}-*/;

	/**
	 * Updates the text represented by the SVG DOM nodes.
	 * 
	 * @param node node for update
	 */
	public native void updateSvgValue(Node node) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).updateSvgValue(node);
	}-*/;

	/**
	 * Releases the given SVG clip removing it from the DOM if required.
	 */
	public native void releaseSvgClip() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).releaseSvgClip();
	}-*/;

	/**
	 * Returns a new or existing SVG clip path which is a descendant of the given SVG node with a unique ID.
	 * 
	 * @param svg
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @return
	 */
	public native Node getSvgClip(Node svg, double x, double y, double w, double h) /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getSvgClip(svg, x, y, w, h);
	}-*/;

	/**
	 * Returns true if the given string is empty or contains only whitespace.
	 * 
	 * @param text string to be tested
	 * @return
	 */
	public native boolean isEmptyString(String text) /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isEmptyString(text);
	}-*/;

	/**
	 * Creates an SVG tspan node for the given text.
	 * 
	 * @param text text
	 * @return SVG node
	 */
	public native Node createSvgSpan(String text) /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).createSvgSpan(text);
	}-*/;

}

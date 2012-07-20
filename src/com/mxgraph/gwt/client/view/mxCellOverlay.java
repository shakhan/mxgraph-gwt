package com.mxgraph.gwt.client.view;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.model.mxPoint;
import com.mxgraph.gwt.client.util.mxEventSource;
import com.mxgraph.gwt.client.util.mxImage;
import com.mxgraph.gwt.client.util.mxRectangle;

/**
 * Extends <mxEventSource> to implement a graph overlay, represented by an icon and a tooltip. Overlays can handle and fire <click> events and are added to the
 * graph using <mxGraph.addCellOverlay>, and removed using <mxGraph.removeCellOverlay>, or <mxGraph.removeCellOverlays> to remove all overlays. The
 * <mxGraph.getCellOverlays> function returns the array of overlays for a given cell in a graph. If multiple overlays exist for the same cell, then <getBounds>
 * should be overridden in at least one of the overlays.
 * 
 * Overlays appear on top of all cells in a special layer. If this is not desirable, then the image must be rendered as part of the shape or label of the cell
 * instead.
 * 
 * Example:
 * 
 * The following adds a new overlays for a given vertex and selectes the cell if the overlay is clicked.
 * 
 * (code) var overlay = new mxCellOverlay(img, html); graph.addCellOverlay(vertex, overlay); overlay.addListener(mxEvent.CLICK, function(sender, evt) { var cell
 * = evt.getProperty('cell'); graph.setSelectionCell(cell); }); (end)
 * 
 * For cell overlays to be printed use <mxPrintPreview.printOverlays>.
 * 
 * Event: mxEvent.CLICK
 * 
 * Fires when the user clicks on the overlay. The <code>event</code> property contains the corresponding mouse event and the <code>cell</code> property contains
 * the cell. For touch devices this is fired if the element receives a touchend event.
 * 
 */
public class mxCellOverlay extends mxEventSource {

	private native JavaScriptObject createJso(JavaScriptObject image, String tooltip, String align, String verticalAlign, JavaScriptObject offset, String cursor) /*-{
		return new $wnd.mxCellOverlay(image, tooltip, align, verticalAlign, offset, cursor);
	}-*/;

	/**
	 * Constructs a new overlay using the given image and tooltip.
	 * 
	 * @param image <mxImage> that represents the icon to be displayed.
	 * @param tooltip Optional string that specifies the tooltip.
	 * @param align Optional horizontal alignment for the overlay. Possible values are <ALIGN_LEFT>, <ALIGN_CENTER> and <ALIGN_RIGHT> (default).
	 * @param verticalAlign verticalAlign - Vertical alignment for the overlay. Possible values are <ALIGN_TOP>, <ALIGN_MIDDLE> and <ALIGN_BOTTOM> (default).
	 * @param offset
	 * @param cursor
	 */
	public mxCellOverlay(mxImage image, String tooltip, String align, String verticalAlign, mxPoint offset, String cursor) {
		this.jso = createJso(image.getJso(), tooltip, align, verticalAlign, offset.getJso(), cursor);
	}

	/**
	 * Gets the <mxImage> to be used as the icon.
	 * 
	 * @return the image
	 */
	public native mxImage getImage() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).image);
	}-*/;

	/**
	 * Sets the <mxImage> to be used as the icon.
	 * 
	 * @param image the image to set
	 */
	public native void setImage(mxImage image) /*-{
		var imageJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(image);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).image = imageJS;
	}-*/;

	/**
	 * Gets the optional string to be used as the tooltip.
	 * 
	 * @return the tooltip
	 */
	public native String getTooltip() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).tooltip;
	}-*/;

	/**
	 * Sets the optional string to be used as the tooltip.
	 * 
	 * @param tooltip the tooltip to set
	 */
	public native void setTooltip(String tooltip) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).tooltip = tooltip;
	}-*/;

	/**
	 * Gets the horizontal alignment for the overlay. Default is <mxConstants.ALIGN_RIGHT>. For edges, the overlay always appears in the center of the edge.
	 * 
	 * @return the align
	 */
	public native String getAlign() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).align;
	}-*/;

	/**
	 * Sets the horizontal alignment for the overlay.
	 * 
	 * @param align the align to set
	 */
	public native void setAlign(String align) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).align = align;
	}-*/;

	/**
	 * Gets the vertical alignment for the overlay. Default is <mxConstants.ALIGN_BOTTOM>. For edges, the overlay always appears in the center of the edge.
	 * 
	 * @return the verticalAlign
	 */
	public native String getVerticalAlign() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).verticalAlign;
	}-*/;

	/**
	 * Sets the vertical alignment for the overlay. Default is <mxConstants.ALIGN_BOTTOM>. For edges, the overlay always appears in the center of the edge.
	 * 
	 * @param verticalAlign the verticalAlign to set
	 */
	public native void setVerticalAlign(String verticalAlign) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).verticalAlign = verticalAlign;
	}-*/;

	/**
	 * Gets the offset as an <mxPoint>. The offset will be scaled according to the current scale.
	 * 
	 * @return the offset
	 */
	public native mxPoint getOffset() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).offset);
	}-*/;

	/**
	 * Sets the offset as an <mxPoint>. The offset will be scaled according to the current scale.
	 * 
	 * @param offset the offset to set
	 */
	public native void setOffset(mxPoint offset) /*-{
		var offsetJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(offset);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).offset = offsetJS;
	}-*/;

	/**
	 * Gets the cursor for the overlay. Default is 'help'.
	 * 
	 * @return the cursor
	 */
	public native String getCursor() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).cursor;
	}-*/;

	/**
	 * Sets the cursor for the overlay. Default is 'help'.
	 * 
	 * @param cursor the cursor to set
	 */
	public native void setCursor(String cursor) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).cursor = cursor;
	}-*/;

	/**
	 * Gets the overlapping for the overlay, that is, the proportional distance from the origin to the point defined by the alignment. Default is 0.5.
	 * 
	 * @return the defaultOverlap
	 */
	public native double getDefaultOverlap() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).defaultOverlap;
	}-*/;

	/**
	 * Sets the overlapping for the overlay, that is, the proportional distance from the origin to the point defined by the alignment.
	 * 
	 * @param defaultOverlap the defaultOverlap to set
	 */
	public native void setDefaultOverlap(double defaultOverlap) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).defaultOverlap = defaultOverlap;
	}-*/;

	/**
	 * Returns the bounds of the overlay for the given {@link mxCellState} as an {@link mxRectangle}. This should be overridden when using multiple overlays per
	 * cell so that the overlays do not overlap.
	 * 
	 * @param state {@link mxCellState} that represents the current state of the associated cell.
	 * @return
	 */
	public native mxRectangle getBounds(mxCellState state) /*-{
		var stateJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(state);
		var boundsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getBounds(stateJS);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(boundsJS);
	}-*/;

	/**
	 * Returns the textual representation of the overlay to be used as the tooltip. This implementation returns <tooltip>.
	 */
	@Override public native String toString() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).toString();
	}-*/;

}

package com.mxgraph.gwt.client.shape;

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.model.mxPoint;
import com.mxgraph.gwt.client.util.mxConstants;

/**
 * Extends {@link mxShape} to implement an arrow shape. (The shape is used to represent edges, not vertices.) This shape is registered under
 * {@link mxConstants#SHAPE_ARROW} in {@link mxCellRenderer}.
 * 
 */
public class mxArrow extends mxShape {

	private native JavaScriptObject createJSO(List<mxPoint> points, String fill, String stroke, Integer strokeWidth, Integer arrowWidth, Integer spacing,
			Integer endSize) /*-{
		var strokeWidthJS = strokeWidth != null ? strokeWidth.@java.lang.Integer::intValue()() : null;
		var arrowWidthJS = arrowWidth != null ? arrowWidth.@java.lang.Integer::intValue()() : null;
		var spacingJS = spacing != null ? spacing.@java.lang.Integer::intValue()() : null;
		var endSizeJS = endSize != null ? endSize.@java.lang.Integer::intValue()() : null;

		var pointsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrapList(Ljava/util/List;)(points);
		return new $wnd.mxArrow(pointsJS, fill, stroke, strokeWidthJS, arrowWidthJS, spacingJS, endSizeJS);
	}-*/;

	/**
	 * Constructs a new arrow shape.
	 * 
	 * @param points Array of {@link mxPoints} that define the points.
	 * @param fill String that defines the fill color.
	 * @param stroke String that defines the stroke color.
	 * @param strokeWidth Optional integer that defines the stroke width. Using null will default to 1.
	 * @param arrowWidth Optional integer that defines the spacing between the arrow shape and its endpoints. Using null will default to
	 *            {@link mxConstants#ARROW_WIDTH}.
	 * @param spacing Optional integer that defines the spacing between the arrow shape and its endpoints. Using null will default to
	 *            {@link mxConstants#ARROW_SPACING}.
	 * @param endSize Optional integer that defines the size of the arrowhead. Using null will default to {@link mxConstants#ARROW_SIZE}.
	 */
	public mxArrow(List<mxPoint> points, String fill, String stroke, Integer strokeWidth, Integer arrowWidth, Integer spacing, Integer endSize) {
		jso = createJSO(points, fill, stroke, strokeWidth != null ? strokeWidth.intValue() : null, arrowWidth != null ? arrowWidth.intValue() : null,
				spacing != null ? spacing.intValue() : null, endSize != null ? endSize.intValue() : null);
	}

	/**
	 * Returns the number of degrees per radiant. Default is 57.2957795.
	 * 
	 * @return
	 */
	public native float getDegPerRad() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).DEG_PER_RAD;
	}-*/;

	/**
	 * Sets the number of degrees per radiant.
	 * 
	 * @param defPerRad
	 */
	public native void setDegPerRad(float degPerRad) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).DEG_PER_RAD = degPerRad;
	}-*/;

}

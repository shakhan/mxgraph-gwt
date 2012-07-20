package com.mxgraph.gwt.client.shape;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.util.mxRectangle;

/**
 * Implementation of the hexagon shape.
 *
 */
public class mxHexagon extends mxActor {

	private native JavaScriptObject createJso(mxRectangle bounds, String fill, String stroke, Integer strokeWidth) /*-{
		var boundsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(bounds);
		var strokeWidthJS = strokeWidth != null ? strokeWidth.@java.lang.Integer::intValue()() : null;
		return new $wnd.mxHexagon(boundsJS, fill, stroke, strokeWidthJS);
	}-*/;

	/**
	 * Constructs a new hexagon shape.
	 * 
	 * @param bounds {@link mxRectangle} that defines the bounds.
	 * @param fill String that defines the fill color.
	 * @param stroke String that defines the stroke color.
	 * @param strokeWidth Optional integer that defines the stroke width. Default is 1.
	 */
	public mxHexagon(mxRectangle bounds, String fill, String stroke, Integer strokeWidth) {
		jso = createJso(bounds, fill, stroke, strokeWidth);
	}

}

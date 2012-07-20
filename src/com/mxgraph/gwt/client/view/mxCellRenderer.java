package com.mxgraph.gwt.client.view;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.IJavaScriptWrapper;
import com.mxgraph.gwt.client.shape.mxShape;

/**
 * Renders cells into a document object model. The <defaultShapes> is a global map of shapename, constructor pairs that is used in all instances. You can get a
 * list of all available shape names using the following code.
 * 
 * In general the cell renderer is in charge of creating, redrawing and destroying the shape and label associated with a cell state, as well as some other
 * graphical objects, namely controls and overlays. The shape hieararchy in the display (ie. the hierarchy in which the DOM nodes appear in the document) does
 * not reflect the cell hierarchy. The shapes are a (flat) sequence of shapes and labels inside the draw pane of the graph view, with some exceptions, namely
 * the HTML labels being placed directly inside the graph container for certain browsers.
 * 
 */
public class mxCellRenderer implements IJavaScriptWrapper {

	private JavaScriptObject jso;

	private native JavaScriptObject createJso() /*-{
		return new $wnd.mxCellRenderer();
	}-*/;

	/**
	 * Constructs a new cell renderer with the following built-in shapes: arrow, rectangle, ellipse, rhombus, image, line, label, cylinder, swimlane, connector,
	 * actor and cloud.
	 * 
	 */
	public mxCellRenderer() {
		jso = createJso();
	}

	@Override public JavaScriptObject getJso() {
		return jso;
	}

	@Override public void setJso(JavaScriptObject jso) {
		this.jso = jso;
	}

	public native void addShape(String shapeName, mxShape shape) /*-{
		var shapeJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(shape);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).shapes[shapeName] = shapeJS.constructor;
	}-*/;

	/**
	 * Redraws the label for the given cell state.
	 * 
	 * @param state {@link mxCellState} whose label should be redrawn.
	 */
	public native void redrawLabel(mxCellState state) /*-{
		var stateJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(state);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).redrawLabel(stateJS);
	}-*/;

}

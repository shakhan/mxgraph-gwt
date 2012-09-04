package com.mxgraph.gwt.client.view;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;

import com.mxgraph.gwt.client.model.mxICell;
import com.mxgraph.gwt.client.model.mxPoint;
import com.mxgraph.gwt.client.util.mxEventSource;

/**
 * Extends {@link mxEventSource} to implement a view for a graph. This class is in charge of computing the absolute coordinates for the relative child
 * geometries, the points for perimeters and edge styles and keeping them cached in <mxCellStates> for faster retrieval. The states are updated whenever the
 * model or the view state (translate, scale) changes. The scale and translate are honoured in the bounds.
 * 
 * Event: mxEvent.UNDO
 * 
 * Fires after the root was changed in <setCurrentRoot>. The <code>edit</code> property contains the <mxUndoableEdit> which contains the <mxCurrentRootChange>.
 * 
 * Event: mxEvent.SCALE_AND_TRANSLATE
 * 
 * Fires after the scale and translate have been changed in <scaleAndTranslate>. The <code>scale</code>, <code>previousScale</code>, <code>translate</code> and
 * <code>previousTranslate</code> properties contain the new and previous scale and translate, respectively.
 * 
 * Event: mxEvent.SCALE
 * 
 * Fires after the scale was changed in <setScale>. The <code>scale</code> and <code>previousScale</code> properties contain the new and previous scale.
 * 
 * Event: mxEvent.TRANSLATE
 * 
 * Fires after the translate was changed in <setTranslate>. The <code>translate</code> and <code>previousTranslate</code> properties contain the new and
 * previous value for translate.
 * 
 * Event: mxEvent.DOWN and mxEvent.UP
 * 
 * Fire if the current root is changed by executing an <mxCurrentRootChange>. The event name depends on the location of the root in the cell hierarchy with
 * respect to the current root. The <code>root</code> and <code>previous</code> properties contain the new and previous root, respectively.
 * 
 */
public class mxGraphView extends mxEventSource {

	private native JavaScriptObject createJso(JavaScriptObject graph) /*-{
		return new $wnd.mxGraphView(graph);
	}-*/;

	private mxGraphView() {
	}

	/**
	 * Constructs a new view for the given {@link mxGraph}.
	 * 
	 * @param graph Reference to the enclosing {@link mxGraph}.
	 */
	public mxGraphView(mxGraph graph) {
		jso = createJso(graph.getJso());
	}

	/**
	 * Revalidates the complete view with all cell states.
	 */
	public native void revalidate() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).revalidate();
	}-*/;

	/**
	 * First validates all bounds and then validates all points recursively on all visible cells starting at the given cell. Finally the background is validated
	 * using <validateBackground>.
	 * 
	 * @param cell Optional {@link mxCell} to be used as the root of the validation. Default is <currentRoot> or the root of the model.
	 */
	public native void validate(mxICell cell) /*-{
		var cellJS = cell != null ? @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell) : null;
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).validate(cellJS);
	}-*/;

	/**
	 * Returns the scale. Default is 1 (100%).
	 * 
	 * @return
	 */
	public native double getScale() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getScale();
	}-*/;

	/**
	 * Specifies the scale.
	 * 
	 * @param scale new scale value
	 */
	public native void setScale(double scale) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setScale(scale);
	}-*/;

	/**
	 * Returns the {@link mxCellState} for the given cell. If create is true, then the state is created if it does not yet exist.
	 * 
	 * @param cell {@link mxCell} for which the {@link mxCellState} should be returned.
	 * @param create boolean indicating if a new state should be created if it does not yet exist.
	 * @return mxCellState
	 */
	public native mxCellState getState(mxICell cell, boolean create) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		var cellStateJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getState(cellJS, create);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(cellStateJS);
	}-*/;

	/**
	 * Invalidates the state of the given cell, all its descendants and connected edges.
	 * 
	 * @param cell Optional {@link mxCell} to be invalidated. Default is the root of the model.
	 * @param recurse
	 * @param includeEdges
	 * @param orderChanged
	 * @return
	 */
	public native void invalidate(mxICell cell, Boolean recurse, Boolean includeEdges, Boolean orderChanged) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		var recurseJS = recurse != null ? recurse.@java.lang.Boolean::booleanValue()() : null;
		var includeEdgesJS = includeEdges != null ? includeEdges.@java.lang.Boolean::booleanValue()() : null;
		var orderChangedJS = orderChanged != null ? orderChanged.@java.lang.Boolean::booleanValue()() : null;

		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).invalidate(cellJS, recurseJS, includeEdgesJS,
				orderChangedJS);
	}-*/;

	/**
	 * Gets the {@link mxPoint} that specifies the current translation. Default is a new empty mxPoint.
	 * 
	 * @return
	 */
	public native mxPoint getTranslate() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getTranslate());
	}-*/;

	/**
	 * Sets the translation and fires a <translate> event before calling <revalidate> followed by <mxGraph.sizeDidChange>. The translation is the negative of
	 * the origin.
	 * 
	 * @param dx X-coordinate of the translation.
	 * @param dy Y-coordinate of the translation.
	 */
	public native void setTranslate(int dx, int dy) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setTranslate(dx, dy);
	}-*/;

	/**
	 * Returns the DOM node that contains the background-, draw- and overlaypane.
	 * 
	 * @return
	 */
	public native Element getCanvas() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getCanvas();
	}-*/;

}

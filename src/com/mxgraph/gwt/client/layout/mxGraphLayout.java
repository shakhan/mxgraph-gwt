package com.mxgraph.gwt.client.layout;

import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.IJavaScriptWrapper;
import com.mxgraph.gwt.client.model.mxCell;
import com.mxgraph.gwt.client.model.mxPoint;
import com.mxgraph.gwt.client.util.mxRectangle;
import com.mxgraph.gwt.client.view.mxGraph;

/**
 * Base class for all layout algorithms in mxGraph. Main public functions are <move> for handling a moved cell within a layouted parent, and <execute> for
 * running the layout on a given parent cell.
 * 
 */
public abstract class mxGraphLayout implements IJavaScriptWrapper, mxIGraphLayout {

	protected JavaScriptObject jso;

	/**
	 * Callback interface invoked implicitly by {@link mxGraphLayout#isEdgeIgnored(mxCell)}, {@link mxGraphLayout#isVertexIgnored(mxCell)}, {@link mxGraphLayout#isVertexMovable(mxCell)}.
	 * Use {@link mxGraphLayout#setIsEdgeIgnoredCallback(CellCallback)}, {@link mxGraphLayout#setIsVertexIgnoredCallback(CellCallback)}, {@link mxGraphLayout#setIsVertexMovableCallback(CellCallback)} to set the appropriate callbacks.
	 *
	 */
	public static interface CellCallback {
		boolean invoke(mxCell cell);
	}

	private native JavaScriptObject wrapCallback(CellCallback callback) /*-{
		var funct = function(cell) {
			var cellJ = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(cell);
			return callback.@com.mxgraph.gwt.client.layout.mxGraphLayout.CellCallback::invoke(Lcom/mxgraph/gwt/client/model/mxCell;)(cell);
		};

		return funct;
	}-*/;

	@Override public JavaScriptObject getJso() {
		return jso;
	}

	@Override public void setJso(JavaScriptObject jso) {
		this.jso = jso;
	}

	protected native JavaScriptObject createJso(JavaScriptObject graph) /*-{
		return new $wnd.mxGraphLayout(graph);
	}-*/;

	protected mxGraphLayout() {
	}

	public mxGraphLayout(mxGraph graph) {
		jso = createJso(graph.getJso());
	}

	/**
	 * Returns the reference to the enclosing <mxGraph>.
	 * 
	 * @return
	 */
	public native mxGraph getGraph() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this));
	}-*/;

	/**
	 * @return
	 */
	public native boolean isUseBoundingBox() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).useBoundingBox;
	}-*/;

	/**
	 * @param useBoundingBox the useBoundingBox to set
	 */
	public native void setUseBoundingBox(boolean useBoundingBox) /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).useBoundingBox = useBoundingBox;
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.layout.mxIGraphLayout#execute(com.mxgraph.gwt.client.model.mxCell)
	 */
	@Override public native void execute(mxCell parent) /*-{
		var parentJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(parent);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).execute(parentJS);
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.layout.mxIGraphLayout#moveCell(com.mxgraph.gwt.client.model.mxCell, double, double)
	 */
	@Override public native void moveCell(mxCell cell, double x, double y) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).moveCell(cellJS, x, y);
	}-*/;

	/**
	 * Returns the constraint for the given key and cell. The optional edge and source arguments are used to return inbound and outgoing routing- constraints
	 * for the given edge and vertex. This implementation always returns the value for the given key in the style of the given cell.
	 * 
	 * @param key Key of the constraint to be returned.
	 * @param cell {@link mxCell} whose constraint should be returned.
	 * @param edge Optional {@link mxCell} that represents the connection whose constraint should be returned. Default is null.
	 * @param source Optional boolean that specifies if the connection is incoming or outgoing. Default is null.
	 * @return map
	 */
	public native Map<String, ?> getConstraint(String key, mxCell cell, mxCell edge, boolean source) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		var edgeJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(edge);
		var constraintJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getConstraint(key, cellJS,
				edgeJS, source);
		return @com.mxgraph.gwt.client.util.CollectionUtils::convertMap(Lcom/google/gwt/core/client/JavaScriptObject;)(constraintJS);
	}-*/;

	/**
	 * Returns a boolean indicating if the given {@link mxCell} is movable or bendable by the algorithm. This implementation returns true if the given cell is
	 * movable in the graph.
	 * 
	 * @param cell {@link mxCell} whose movable state should be returned.
	 * @return
	 */
	public native boolean isVertexMovable(mxCell cell) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isVertexMovable(cellJS);
	}-*/;

	/**
	 * Sets the callback that indicates if the given {@link mxCell} is movable or bendable by the algorithm.
	 * 
	 * @param callback
	 */
	public native void setIsVertexMovableCallback(CellCallback callback) /*-{
		var callbackJS = this.@com.mxgraph.gwt.client.layout.mxGraphLayout::wrapCallback(Lcom/mxgraph/gwt/client/layout/mxGraphLayout$CellCallback;)(callback);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isVertexMovable = callbackJS;
	}-*/;

	/**
	 * Returns a boolean indicating if the given {@link mxCell} should be ignored by the algorithm. This implementation returns false for all vertices.
	 * 
	 * @param vertex {@link mxCell} whose ignored state should be returned.
	 * @return
	 */
	public native boolean isVertexIgnored(mxCell vertex) /*-{
		var vertexJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(vertex);
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isVertexIgnored(vertexJS);
	}-*/;

	/**
	 * Sets the callback that indicates if the given {@link mxCell} should be ignored by the algorithm.
	 * 
	 * @param callback
	 */
	public native void setIsVertexIgnoredCallback(CellCallback callback) /*-{
		var callbackJS = this.@com.mxgraph.gwt.client.layout.mxGraphLayout::wrapCallback(Lcom/mxgraph/gwt/client/layout/mxGraphLayout$CellCallback;)(callback);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isVertexIgnored = callbackJS;
	}-*/;

	/**
	 * Returns a boolean indicating if the given {@link mxCell} should be ignored by the algorithm. This implementation returns false for all vertices.
	 * 
	 * @param edge {@link mxCell} whose ignored state should be returned.
	 * @return
	 */
	public native boolean isEdgeIgnored(mxCell edge) /*-{
		var edgeJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(edge);
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isEdgeIgnored(edgeJS);
	}-*/;

	/**
	 * Sets the callback that indicates if the given {@link mxCell} should be ignored by the algorithm.
	 * 
	 * @param callback
	 */
	public native void setIsEdgeIgnoredCallback(CellCallback callback) /*-{
		var callbackJS = this.@com.mxgraph.gwt.client.layout.mxGraphLayout::wrapCallback(Lcom/mxgraph/gwt/client/layout/mxGraphLayout$CellCallback;)(callback);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isEdgeIgnored = callbackJS;
	}-*/;

	/**
	 * Disables or enables the edge style of the given edge.
	 * 
	 * @param edge
	 * @param value
	 */
	public native void setEdgeStyleEnabled(mxCell edge, boolean value) /*-{
		var edgeJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(edge);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setEdgeStyleEnabled(edgeJS, value);
	}-*/;

	/**
	 * Disables or enables orthogonal end segments of the given edge.
	 * 
	 * @param edge
	 * @param value
	 */
	public native void setOrthogonalEdge(mxCell edge, boolean value) /*-{
		var edgeJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(edge);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setOrthogonalEdge(edgeJS, value);
	}-*/;

	/**
	 * Replaces the array of mxPoints in the geometry of the given edge with the given array of mxPoints.
	 * 
	 * @param edge
	 * @param points
	 */
	public native void setEdgePoints(mxCell edge, List<mxPoint> points) /*-{
		var edgeJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(edge);
		var pointsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrapList(Ljava/util/List;)(points);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setEdgePoints(edgeJS, pointsJS);
	}-*/;

	/**
	 * Sets the new position of the given cell taking into account the size of the bounding box if <useBoundingBox> is true. The change is only carried out if
	 * the new location is not equal to the existing location, otherwise the geometry is not replaced with an updated instance. The new or old bounds are
	 * returned (including overlapping labels).
	 * 
	 * @param cell <mxCell> whose geometry is to be set.
	 * @param x Integer that defines the x-coordinate of the new location.
	 * @param y Integer that defines the y-coordinate of the new location.
	 * @return
	 */
	public native mxRectangle setVertexLocation(mxCell cell, int x, int y) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		var retvalJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setVertexLocation(cellJS, x, y);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(retvalJS);
	}-*/;

	/**
	 * Returns an {@link mxRectangle} that defines the bounds of the given cell or the bounding box if <useBoundingBox> is true.
	 * 
	 * @param cell
	 * @return
	 */
	public native mxRectangle getVertexBounds(mxCell cell) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		var retvalJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getVertexBounds(cellJS);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(retvalJS);
	}-*/;

}

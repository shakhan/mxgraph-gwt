package com.mxgraph.gwt.client.model;

import java.io.Serializable;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Cells are the elements of the graph model. They represent the state of the groups, vertices and edges in a graph.
 * 
 * <h4>Edge Labels</h4>
 * 
 * Using the x- and y-coordinates of a cell's geometry it is possible to position the label on edges on a specific location on the actual edge shape as it
 * appears on the screen. The x-coordinate of an edge's geometry is used to describe the distance from the center of the edge from -1 to 1 with 0 being the
 * center of the edge and the default value. The y-coordinate of an edge's geometry is used to describe the absolute, orthogonal distance in pixels from that
 * point. In addition, the mxGeometry.offset is used as a absolute offset vector from the resulting point.
 * 
 * The width and height of an edge geometry are ignored.
 * 
 * To add more than one edge label, add a child vertex with a relative geometry. The x- and y-coordinates of that geometry will have the same semantic as the
 * above for edge labels.
 */
public class mxCell implements mxICell, Cloneable, Serializable {

	private static final long serialVersionUID = -3835896565174093540L;

	private JavaScriptObject jso;

	@Override public JavaScriptObject getJso() {
		return jso;
	}

	@Override public void setJso(JavaScriptObject jso) {
		this.jso = jso;
	}

	public mxCell() {
		jso = createJso(null, null, null);
	}

	private native JavaScriptObject createJso(Object value, JavaScriptObject geometry, String style) /*-{
		return new $wnd.mxCell(value, geometry, style);
	}-*/;

	protected mxCell(JavaScriptObject jso) {
		this.jso = jso;
	}

	public mxCell(Object value, mxGeometry geometry, String style) {
		jso = createJso(value, geometry.getJso(), style);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#getId()
	 */
	@Override public native String getId() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getId();
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#setId(java.lang.String)
	 */
	@Override public native void setId(String id) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setId(id);
	}-*/;

	@Override public native Object getValue() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getValue();
	}-*/;

	@Override public native void setValue(Object value) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setValue(value);
	}-*/;

	/**
	 * Changes the user object after an in-place edit and returns the previous value. This implementation replaces the user object with the given value and
	 * returns the old user object.
	 * 
	 * @param newValue new value for user object
	 * @return old user object
	 */
	public native Object valueChanged(Object newValue) /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).valueChanged(newValue);
	}-*/;

	@Override public native mxGeometry getGeometry() /*-{
		var geometryJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getGeometry();
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(geometryJS);
	}-*/;

	@Override public native void setGeometry(mxGeometry geometry) /*-{
		var geometryJs = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(geometry);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setGeometry(geometryJs);
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#getStyle()
	 */
	@Override public native String getStyle() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getStyle();
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#setStyle(java.lang.String)
	 */
	@Override public native void setStyle(String style) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setStyle(style);
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#isVertex()
	 */
	@Override public native boolean isVertex() /*-{
		var retvalJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isVertex();
		return typeof retvalJS == "boolean" ? retvalJS : retvalJS == 0 ? false : true;
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#setVertex(boolean)
	 */
	public native void setVertex(boolean isVertex) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setVertex(isVertex);
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#isEdge()
	 */
	@Override public native boolean isEdge() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isEdge();
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#setEdge(boolean)
	 */
	public native void setEdge(boolean edge) /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setEdge(edge);
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#isConnectable()
	 */
	@Override public native boolean isConnectable() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isConnectable();
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#setConnectable(boolean)
	 */
	@Override public native void setConnectable(boolean connectable) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setConnectable(connectable);
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#isVisible()
	 */
	@Override public native boolean isVisible() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isVisible();
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#setVisible(boolean)
	 */
	@Override public native void setVisible(boolean visible) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setVisible(visible);
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#isCollapsed()
	 */
	@Override public native boolean isCollapsed() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isCollapsed();
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#setCollapsed(boolean)
	 */
	@Override public native void setCollapsed(boolean collapsed) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setCollapsed(collapsed);
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#getParent()
	 */
	@Override public native mxICell getParent() /*-{
		var parentJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getParent();
		return new @com.mxgraph.gwt.client.model.mxCell::new(Lcom/google/gwt/core/client/JavaScriptObject;)(parentJS);
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#setParent(com.mxgraph.gwt.client.model.mxICell)
	 */
	@Override public native void setParent(mxICell parent) /*-{
		var parentJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(parent);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setParent(parentJS);
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#getTerminal(boolean)
	 */
	@Override public native mxICell getTerminal(boolean source) /*-{
		var terminalJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getTerminal(source);
		return new @com.mxgraph.gwt.client.model.mxCell::new(Lcom/google/gwt/core/client/JavaScriptObject;)(terminalJS);
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#setTerminal(com.mxgraph.gwt.client.model.mxICell, boolean)
	 */
	@Override public native mxICell setTerminal(mxICell terminal, boolean isSource) /*-{
		var terminalJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setTerminal(terminal, isSource);
		return new @com.mxgraph.gwt.client.model.mxCell::new(Lcom/google/gwt/core/client/JavaScriptObject;)(terminalJS);
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#getChildCount()
	 */
	@Override public native int getChildCount() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getChildCount();
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#getIndex(com.mxgraph.gwt.client.model.mxICell)
	 */
	@Override public native int getIndex(mxICell child) /*-{
		var childJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(child);
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getIndex(childJS);
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#getChildAt(int)
	 */
	@Override public native mxICell getChildAt(int index) /*-{
		var childJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getChildAt(index);
		return new @com.mxgraph.gwt.client.model.mxCell::new(Lcom/google/gwt/core/client/JavaScriptObject;)(childJS);
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#insert(com.mxgraph.gwt.client.model.mxICell)
	 */
	@Override public native mxICell insert(mxICell child) /*-{
		var childJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(child);
		var insertedChildJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).insert(childJS);
		return new @com.mxgraph.gwt.client.model.mxCell::new(Lcom/google/gwt/core/client/JavaScriptObject;)(insertedChildJS);
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#insert(com.mxgraph.gwt.client.model.mxICell, int)
	 */
	@Override public native mxICell insert(mxICell child, int index) /*-{
		var childJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(child);
		var insertedChildJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).insert(childJS, index);
		return new @com.mxgraph.gwt.client.model.mxCell::new(Lcom/google/gwt/core/client/JavaScriptObject;)(insertedChildJS);
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#remove(int)
	 */
	@Override public native mxICell remove(int index) /*-{
		var removedJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).remove(index);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(removedJS)
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#removeFromParent()
	 */
	@Override public native void removeFromParent() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).removeFromParent();
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#getEdgeCount()
	 */
	@Override public native int getEdgeCount() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getEdgeCount();
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#getEdgeIndex(com.mxgraph.gwt.client.model.mxICell)
	 */
	@Override public native int getEdgeIndex(mxICell edge) /*-{
		var edgeJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(edge);
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getEdgeIndex(edgeJS);
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#getEdgeAt(int)
	 */
	@Override public native mxICell getEdgeAt(int index) /*-{
		var mxCellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getEdgeAt(index);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(mxCellJS);
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#insertEdge(com.mxgraph.gwt.client.model.mxICell, boolean)
	 */
	@Override public native mxICell insertEdge(mxICell edge, boolean isOutgoing) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(edge);
		var insertedCellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this)
				.insertEdge(cellJS, isOutgoing);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(insertedCellJS);
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#removeEdge(com.mxgraph.gwt.client.model.mxICell, boolean)
	 */
	@Override public native mxICell removeEdge(mxICell edge, boolean isOutgoing) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(edge);
		var removedCellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).removeEdge(cellJS, isOutgoing);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(removedCellJS);
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.model.mxICell#removeFromTerminal(boolean)
	 */
	@Override public native void removeFromTerminal(boolean isSource) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).removeFromTerminal(isSource);
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override public native mxCell clone() /*-{
		var mxCellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).clone();
		return new @com.mxgraph.gwt.client.model.mxCell::new(Lcom/google/gwt/core/client/JavaScriptObject;)(mxCellJS);
	}-*/;

	/**
	 * Returns a clone of the cell's user object.
	 * 
	 * @return clone
	 */
	public native Object cloneValue() /*-{
		var clonedJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).cloneValue();
		return clonedJS;
	}-*/;

	
	/* (non-Javadoc)
	 * @see com.mxgraph.gwt.client.model.mxICell#getAttribute(java.lang.String, java.lang.String)
	 */
	public native String getAttribute(String name, String defaultValue) /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getAttribute(name, defaultValue);
	}-*/;

	/* (non-Javadoc)
	 * @see com.mxgraph.gwt.client.model.mxICell#setAttribute(java.lang.String, java.lang.String)
	 */
	@Override public native void setAttribute(String name, String value) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setAttribute(name, value);
	}-*/;
	
	

}

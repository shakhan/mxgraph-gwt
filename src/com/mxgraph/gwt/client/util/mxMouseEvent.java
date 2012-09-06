package com.mxgraph.gwt.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.NativeEvent;
import com.mxgraph.gwt.client.IJavaScriptWrapper;
import com.mxgraph.gwt.client.model.mxCell;
import com.mxgraph.gwt.client.model.mxICell;
import com.mxgraph.gwt.client.view.mxCellState;

/**
 * Base class for all mouse events in mxGraph.
 * 
 */

public class mxMouseEvent implements IJavaScriptWrapper {

	private JavaScriptObject jso;

	private native JavaScriptObject createJso(NativeEvent event, JavaScriptObject state) /*-{
		return new $wnd.mxMouseEvent(event, state);
	}-*/;
	
	public static interface mxIMouseListener<C> {
		void onMouseUp(C sender, mxMouseEvent event);
		void onMouseDown(C sender, mxMouseEvent event);
		void onMouseMove(C sender, mxMouseEvent event);
	}

	private mxMouseEvent() {
	}

	public mxMouseEvent(NativeEvent event, mxCellState state) {
		jso = createJso(event, state.getJso());
	}

	@Override public JavaScriptObject getJso() {
		return jso;
	}

	@Override public void setJso(JavaScriptObject jso) {
		this.jso = jso;

	}

	/**
	 * Returns the optional {@link mxCellState} associated with this event.
	 * 
	 * @return
	 */
	public native mxCellState getState() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getState());
	}-*/;

	/**
	 * Returns the x-coordinate of the event in the graph.
	 * 
	 * @return
	 */
	public native Double getGraphX() /*-{
		var val = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).graphX;
		return val != null ? @java.lang.Double::new(D)(val) : null;
	}-*/;

	/**
	 * Returns the y-coordinate of the event in the graph.
	 * 
	 * @return
	 */
	public native Double getGraphY() /*-{
		var val = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).graphY;
		return val != null ? @java.lang.Double::new(D)(val) : null;
	}-*/;

	/**
	 * Sets the x-coordinate of the event in the graph.
	 * 
	 * @return
	 */
	public native void setGraphX(Double x) /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).graphX = (x != null ? x.@java.lang.Double::doubleValue()() : null);
	}-*/;

	/**
	 * Sets the y-coordinate of the event in the graph.
	 * 
	 * @return
	 */
	public native void setGraphY(Double y) /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).graphY = (y != null ? y.@java.lang.Double::doubleValue()() : null);
	}-*/;

	/**
	 * Returns <evt.clientX>.
	 * 
	 * @return
	 */
	public native Double getX() /*-{
		var val = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getX();
		return val != null ? @java.lang.Double::new(D)(val) : null;
	}-*/;

	/**
	 * Returns <evt.clientY>.
	 * 
	 * @return
	 */
	public native Double getY() /*-{
		var val = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getY();
		return val != null ? @java.lang.Double::new(D)(val) : null;
	}-*/;
	
	/**
	 * Returns native event
	 * 
	 * @return
	 */
	public native NativeEvent getEvent() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getEvent();
	}-*/;
	
	/**
	 * Sets the consumed state of this event
	 * 
	 * @param consumed
	 */
	public native void setConsumed(boolean consumed) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).consumed = consumed;
	}-*/;
	
	
	/**
	 * Holds the consumed state of this event
	 * 
	 * @return 
	 */
	public native boolean isConsumed() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).consumed;
	}-*/;
	
	
	/**
	 * Returns the {@link mxCell} in state is not null.
	 * @return
	 */
	public native mxICell getCell() /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getCell();
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(cellJS);
	}-*/;

}

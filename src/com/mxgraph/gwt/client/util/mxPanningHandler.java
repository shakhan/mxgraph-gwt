package com.mxgraph.gwt.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.handler.mxRubberband;
import com.mxgraph.gwt.client.model.mxICell;
import com.mxgraph.gwt.client.view.mxGraph;

/**
 * Event handler that pans and creates popupmenus. To use the left mousebutton for panning without interfering with cell moving and resizing, use
 * <isUseLeftButton> and <isIgnoreCell>. For grid size steps while panning, use <useGrid>. This handler is built-into <mxGraph.panningHandler> and enabled using
 * <mxGraph.setPanning>.
 * 
 */
public class mxPanningHandler extends mxPopupMenu {

	public static interface ConsumePanningTriggerCallback {
		void invoke(mxMouseEvent me, ConsumePanningTriggerCallback old);

	}

	@SuppressWarnings("unused")
	private static class DefaultCallback implements ConsumePanningTriggerCallback {
		JavaScriptObject panningHandler;
		JavaScriptObject callback;

		public DefaultCallback(mxPanningHandler panningHandler, JavaScriptObject callback) {
			this.panningHandler = panningHandler.getJso();
			this.callback = callback;
		}

		public native void invoke(mxMouseEvent me, ConsumePanningTriggerCallback old) /*-{
			var meJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(me);
			this.@com.mxgraph.gwt.client.util.mxPanningHandler.DefaultCallback::callback.apply([ meJS ]);
		}-*/;

	}


	/**
	 * Allows user to redefine the behavior of {@link mxGraph#consumePanningTrigger(mxMouseEvent)}
	 * 
	 * @param callback a callback containing a new definition
	 */
	public native void setConsumePanningTriggerCallback(ConsumePanningTriggerCallback callback) /*-{
		var old = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).consumePanningTrigger;
		var oldJ = @com.mxgraph.gwt.client.util.mxPanningHandler.DefaultCallback::new(Lcom/mxgraph/gwt/client/util/mxPanningHandler;Lcom/google/gwt/core/client/JavaScriptObject;)(this, old);

		var funct = function(me) {
			var meJ = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(me);
			callback.@com.mxgraph.gwt.client.util.mxPanningHandler.ConsumePanningTriggerCallback::invoke(Lcom/mxgraph/gwt/client/util/mxMouseEvent;Lcom/mxgraph/gwt/client/util/mxPanningHandler$ConsumePanningTriggerCallback;)(meJ, oldJ);
		};
		
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).consumePanningTrigger = funct;

	}-*/;

	private native JavaScriptObject createJso(JavaScriptObject graph, JavaScriptObject factoryMethod) /*-{
		return new $wnd.mxPanningHandler(graph, factoryMethod);
	}-*/;

	private native JavaScriptObject createJso() /*-{
		return new $wnd.mxPanningHandler();
	}-*/;

	public static interface PanningTriggerHandler {
		boolean invoke(mxMouseEvent me);
	}

	public mxPanningHandler() {
		this.jso = createJso();
	}

	/**
	 * Constructs an event handler that creates a <mxPopupMenu> and pans the graph.
	 * 
	 * Event: mxEvent.PAN_START
	 * 
	 * Fires when the panning handler changes its <active> state to true. The <code>event</code> property contains the corresponding <mxMouseEvent>.
	 * 
	 * Event: mxEvent.PAN
	 * 
	 * Fires while handle is processing events. The <code>event</code> property contains the corresponding <mxMouseEvent>.
	 * 
	 * Event: mxEvent.PAN_END
	 * 
	 * Fires when the panning handler changes its <active> state to false. The <code>event</code> property contains the corresponding <mxMouseEvent>.
	 * 
	 * @param graph
	 * @param factoryMethod
	 */
	public mxPanningHandler(mxGraph graph, mxIFactoryMethod factoryMethod) {
		this.jso = createJso(WrapperUtils.unwrap(graph), wrapFactoryMethod(factoryMethod));
	}

	/**
	 * Gets the reference to the enclosing {@link mxGraph}
	 * 
	 * @return
	 */
	public native mxGraph getGraph() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).graph);
	}-*/;

	/**
	 * Sets the {@link mxGraph}
	 * 
	 * @param graph
	 */
	public native void setGraph(mxGraph graph) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).graph = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(graph);
	}-*/;

	/**
	 * Returns true if isPopupTrigger should be used for panning.
	 * 
	 * @return
	 */
	public native boolean isUsePopupTrigger() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).usePopupTrigger;
	}-*/;

	/**
	 * Specifies if the <isPopupTrigger> should also be used for panning. To avoid conflicts, the panning is only activated if the mouse was moved more than
	 * <mxGraph.tolerance>, otherwise, a single click is assumed and the popupmenu is displayed. Default is true.
	 * 
	 * @param usePopupTrigger
	 */
	public native void setUsePopupTrigger(boolean usePopupTrigger) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).usePopupTrigger = usePopupTrigger;
	}-*/;

	/**
	 * Returns true if panning should be active for the left mouse button. Default is false.
	 * 
	 * @return
	 */
	public native boolean isUseLeftButtonForPanning() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).useLeftButtonForPanning;
	}-*/;

	/**
	 * Specifies if panning should be active for the left mouse button. Setting this to true may conflict with {@link mxRubberband}.
	 * 
	 * @param useLeftButtonForPanning
	 */
	public native void setUseLeftButtonForPanning(boolean useLeftButtonForPanning) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).useLeftButtonForPanning = useLeftButtonForPanning;
	}-*/;

	/**
	 * Returns true if cells should be selected if a popupmenu is displayed for them. Default is true.
	 * 
	 * @return
	 */
	public native boolean isSelectOnPopup() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).selectOnPopup;
	}-*/;

	/**
	 * Specifies if cells should be selected if a popupmenu is displayed for them.
	 * 
	 * @param selectOnPopup
	 */
	public native void setSelectOnPopup(boolean selectOnPopup) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).selectOnPopup = selectOnPopup;
	}-*/;

	/**
	 * True if cells should be deselected if a popupmenu is displayed for the diagram background. Default is true.
	 * 
	 * @return
	 */
	public native boolean isClearSelectionOnBackground() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).clearSelectionOnBackground;
	}-*/;

	/**
	 * Specifies if cells should be deselected if a popupmenu is displayed for the diagram background.
	 * 
	 * @param clearSelectionOnBackground
	 */
	public native void setClearSelectionOnBackground(boolean clearSelectionOnBackground) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).clearSelectionOnBackground = clearSelectionOnBackground;
	}-*/;

	/**
	 * True if panning should be active even if there is a cell under the mousepointer. Default is false.
	 * 
	 * @return
	 */
	public native boolean isIgnoreCell() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).ignoreCell;
	}-*/;

	/**
	 * Specifies if panning should be active even if there is a cell under the mousepointer.
	 * 
	 * @param ignoreCell
	 */
	public native void setIgnoreCell(boolean ignoreCell) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).ignoreCell = ignoreCell;
	}-*/;

	/**
	 * 
	 * True if the panning should be previewed. Default is true.
	 * 
	 * @return
	 */
	public native boolean isPreviewEnabled() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).previewEnabled;
	}-*/;

	/**
	 * Specifies if the panning should be previewed.
	 * 
	 * @param previewEnabled
	 */
	public native void setPreviewEnabled(boolean previewEnabled) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).previewEnabled = previewEnabled;
	}-*/;

	/**
	 * True if the panning steps should be aligned to the grid size. Default is false.
	 * 
	 * @return
	 */
	public native boolean isUseGrid() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).useGrid;
	}-*/;

	/**
	 * Specifies if the panning steps should be aligned to the grid size.
	 * 
	 * @param useGrid
	 */
	public native void setUseGrid(boolean useGrid) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).useGrid = useGrid;
	}-*/;

	/**
	 * True if panning should be enabled. Default is true.
	 * 
	 * @return
	 */
	public native boolean isPanningEnabled() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).panningEnabled;
	}-*/;

	/**
	 * Specifies if panning should be enabled.
	 * 
	 * @param panningEnabled
	 */
	public native void setPanningEnabled(boolean panningEnabled) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).panningEnabled = panningEnabled;
	}-*/;

	/**
	 * Initializes the shapes required for this vertex handler.
	 */
	public native void init() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).init();
	}-*/;

	/**
	 * Returns true if the given event is a panning trigger for the optional given cell. This returns true if control-shift is pressed or if <usePopupTrigger>
	 * is true and the event is a popup trigger.
	 * 
	 * @param me
	 */
	public native void isPanningTrigger(mxMouseEvent me) /*-{
		var meJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(me);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isPanningTrigger(meJS);
	}-*/;

	/**
	 * Pans <graph> by the given amount.
	 */
	public native void panGraph(int dx, int dy) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).panGraph(dx, dy);
	}-*/;

	/**
	 * Allows user to redefine the behavior of {@link mxPanningHandler#isPanningTrigger(mxMouseEvent)}
	 * 
	 * @param callback a callback containing a new definition
	 */
	public native void setPanningTriggerCallback(PanningTriggerHandler callback) /*-{
		var funct = function(me) {
			var meJ = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(me);
			return callback.@com.mxgraph.gwt.client.util.mxPanningHandler.PanningTriggerHandler::invoke(Lcom/mxgraph/gwt/client/util/mxMouseEvent;)(meJ);
		};

		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isPanningTrigger = funct;
	}-*/;

}

package com.mxgraph.gwt.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.mxgraph.gwt.client.IJavaScriptWrapper;
import com.mxgraph.gwt.client.model.mxCell;
import com.mxgraph.gwt.client.model.mxICell;
import com.mxgraph.gwt.client.util.mxEvent.EventHandler;
import com.mxgraph.gwt.client.view.mxGraph;

public class mxDragSource implements IJavaScriptWrapper {

	private JavaScriptObject jso;

	/**
	 * Wraps a {@link DropHandler#handleDrop(mxGraph, com.google.gwt.dom.client.NativeEvent, mxCell, double, double)} into a JavaScript function to be used as a
	 * callback
	 * 
	 * @param dragHandler
	 * @return JavaScript function
	 */
	private static native JavaScriptObject wrapCallbackInterface(DropHandler dropHandler) /*-{
		var funct = function(graph, evt, target, x, y) {
			var graphJ = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(graph);
			var targetJ = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(target);
			dropHandler.@com.mxgraph.gwt.client.util.mxDragSource.DropHandler::handleDrop(Lcom/mxgraph/gwt/client/view/mxGraph;Lcom/google/gwt/dom/client/NativeEvent;Lcom/mxgraph/gwt/client/model/mxCell;DD)
				(graphJ, evt, targetJ, x, y);
		};

		return funct;
	}-*/;

	/**
	 * Wraps a {@link DropTargetHandler#getDropTarget(mxGraph, double, double)} into a JavaScript function to be used as a callback
	 * 
	 * @param dragHandler
	 * @return JavaScript function
	 */
	private static native JavaScriptObject wrapCallbackInterface(DropTargetHandler dropTargetHandler) /*-{
		var funct = function(graph, x, y) {
			var graphJ = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(graph);
			var cellJ = dropTargetHandler.@com.mxgraph.gwt.client.util.mxDragSource.DropTargetHandler::getDropTarget(Lcom/mxgraph/gwt/client/view/mxGraph;DD)(graphJ, x, y);
			return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cellJ);
		};

		return funct;
	}-*/;

	private static native JavaScriptObject wrapCallbackInterface(GuidesEnabledHandler guidesEnabledHandler) /*-{
		var funct = function() {
			return guidesEnabledHandler.@com.mxgraph.gwt.client.util.mxDragSource.GuidesEnabledHandler::isGuidesEnabled()();
		};

		return funct;
	}-*/;

	public interface DropHandler {
		void handleDrop(mxGraph graph, NativeEvent event, mxCell cell, double x, double y);
	}

	public interface DropTargetHandler {
		mxICell getDropTarget(mxGraph graph, double x, double y);
	}

	public interface GuidesEnabledHandler {
		boolean isGuidesEnabled();
	}

	private native JavaScriptObject createJso(Element element, JavaScriptObject dropHandler) /*-{
		return new $wnd.mxDragSource(element, dropHandler);
	}-*/;

	@Override public JavaScriptObject getJso() {
		return jso;
	}

	@Override public void setJso(JavaScriptObject jso) {
		this.jso = jso;
	}

	private mxDragSource() {
	}

	public mxDragSource(Element element, DropHandler dropHandler) {
		jso = createJso(element, mxDragSource.wrapCallbackInterface(dropHandler));
	}

	public native Element getElement() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).element;
	}-*/;

	/**
	 * Installs a callback to return the guidesEnabled property
	 * 
	 * @param guidesEnabledHandler
	 */
	public native void setGuidesEnabledHandler(GuidesEnabledHandler guidesEnabledHandler) /*-{
		var guidesEnabledJS = @com.mxgraph.gwt.client.util.mxDragSource::wrapCallbackInterface(Lcom/mxgraph/gwt/client/util/mxDragSource$GuidesEnabledHandler;)(guidesEnabledHandler);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isGuidesEnabled(guidesEnabledJS);
	}-*/;

	public native void setDropTargetHandler(DropTargetHandler dropTargetHandler) /*-{
		var dthJS = @com.mxgraph.gwt.client.util.mxDragSource::wrapCallbackInterface(Lcom/mxgraph/gwt/client/util/mxDragSource$DropTargetHandler;)(dropTargetHandler);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getDropTarget = dthJS;
	}-*/;

	public native mxCell getDropTarget(mxGraph graph, double x, double y) /*-{
		var graphJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(graph);
		var dtJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getDropTarget(graphJS, x, y);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(dtJS);
	}-*/;

	/**
	 * Processes the mouse up event and invokes <drop>, <dragExit> and <stopDrag> as required.
	 * 
	 * @param event
	 */
	public native void mouseUp(NativeEvent event) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).mouseUp(event);
	}-*/;

	//TODO find a better way to override the handler method
	/**
	 * Sets a handler for the mouseup event. This handler will be invoked before the native default handler.
	 * 
	 * @param eventHandler
	 */
	public native void setMouseUpHandler(EventHandler eventHandler) /*-{
		var handlerJS = @com.mxgraph.gwt.client.util.mxEvent::wrapCallbackInterface(Lcom/mxgraph/gwt/client/util/mxEvent$EventHandler;)(eventHandler);
		var oldMouseUp = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).mouseUp;
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).mouseUp = function(event) {
			handlerJS.apply(this, arguments);
			oldMouseUp.apply(this, arguments);
		};
	}-*/;

	/**
	 * Reference to the {@link mxGraph} that is the current drop target.
	 * 
	 * @return
	 */
	public native mxGraph getCurrentGraph() /*-{
		var graphJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).currentGraph;
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(graphJS);
	}-*/;

	/**
	 * Returns the drop target for the given graph and coordinates. This implementation uses <mxGraph.getCellAt>.
	 * 
	 */
	public native void drop(mxGraph graph, NativeEvent event, mxCell dropTarget, int x, int y) /*-{
		var graphJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(graph);
		var dropTargetJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(dropTarget);

		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).drop(graphJS, event, dropTargetJS, x, y);
	}-*/;
	
	/**
	 * Specifies if this drag source is enabled.
	 * 
	 * @param value
	 */
	public native void setEnabled(boolean value) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setEnabled(value);
	}-*/;
	
	/**
	 * Returns true if this drag source is enabled. Default is true.
	 * 
	 * @return
	 */
	public native boolean isEnabled() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isEnabled();
	}-*/;

}

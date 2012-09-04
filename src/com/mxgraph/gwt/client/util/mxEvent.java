package com.mxgraph.gwt.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;

public class mxEvent {

	static {
		initialize();
	}

	public static interface EventHandler {
		void handleEvent(NativeEvent event);
	}

	public static native JavaScriptObject wrapCallbackInterface(EventHandler eventHandler) /*-{
		var funct = function(event) {
			eventHandler.@com.mxgraph.gwt.client.util.mxEvent.EventHandler::handleEvent(Lcom/google/gwt/dom/client/NativeEvent;)(event);
		};

		return funct;
	}-*/;

	/**
	 * 
	 * 
	 * Specifies the event name for undo.
	 */
	public static String UNDO;

	/**
	 * 
	 */
	public static String ADD;

	/**
	 * 
	 * 
	 * Specifies the event name for redo.
	 */
	public static String REDO;
	
	/**
	 * 
	 * 
	 * Specifies the event name for done.
	 */
	public static String DONE;
	
	/**
	 * Specifies the event name for click.
	 */
	public static String CLICK;
	
	/**
	 * Specifies the event name for change.
	 */
	public static String CHANGE;
	
	/**
	 * Specifies the event name for change.
	 */
	public static String MOUSE_DOWN;
	
	/**
	 * Specifies the event name for labelChanged.
	 */
	public static String LABEL_CHANGED;
	
	/**
	 *
	 * Specifies the event name for start.
	 */
	public static String START;
	

	/**
	 *
	 * Specifies the event name for reset.
	 */
	public static String RESET;

	private static native void initialize() /*-{
		@com.mxgraph.gwt.client.util.mxEvent::ADD = $wnd.mxEvent.ADD;
		@com.mxgraph.gwt.client.util.mxEvent::UNDO = $wnd.mxEvent.UNDO;
		@com.mxgraph.gwt.client.util.mxEvent::REDO = $wnd.mxEvent.REDO;
		@com.mxgraph.gwt.client.util.mxEvent::DONE = $wnd.mxEvent.DONE;
		@com.mxgraph.gwt.client.util.mxEvent::CLICK = $wnd.mxEvent.CLICK;
		@com.mxgraph.gwt.client.util.mxEvent::CHANGE = $wnd.mxEvent.CHANGE;
		@com.mxgraph.gwt.client.util.mxEvent::MOUSE_DOWN = $wnd.mxEvent.MOUSE_DOWN;
		@com.mxgraph.gwt.client.util.mxEvent::LABEL_CHANGED = $wnd.mxEvent.LABEL_CHANGED;
		@com.mxgraph.gwt.client.util.mxEvent::START = $wnd.mxEvent.START;
		@com.mxgraph.gwt.client.util.mxEvent::RESET = $wnd.mxEvent.RESET;
	}-*/;

	/**
	 * Binds the function to the specified event on the given element. Use <mxUtils.bind> in order to bind the "this" keyword inside the function to a given
	 * execution scope.
	 * 
	 * @param element
	 * @param mode
	 * @param eventHandler
	 */
	public static native void addListener(Element element, String mode, EventHandler eventHandler) /*-{
		var handlerJS = @com.mxgraph.gwt.client.util.mxEvent::wrapCallbackInterface(Lcom/mxgraph/gwt/client/util/mxEvent$EventHandler;)(eventHandler);
		$wnd.mxEvent.addListener(element, mode, handlerJS);
	}-*/;
	
	public static native double getClientX(NativeEvent event) /*-{
		return $wnd.mxEvent.getClientX(event);
	}-*/;
	
	public static native double getClientY(NativeEvent event) /*-{
		return $wnd.mxEvent.getClientY(event);
	}-*/;
	
	/**
	 * Disables the context menu for the given element.
	 * 
	 * @param element
	 */
	public static native void disableContextMenu(Element element) /*-{
		$wnd.mxEvent.disableContextMenu(element);
	}-*/;
}

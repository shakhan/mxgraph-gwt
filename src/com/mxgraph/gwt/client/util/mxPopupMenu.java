package com.mxgraph.gwt.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.NativeEvent;
import com.mxgraph.gwt.client.model.mxCell;

/**
 * Event handler that pans and creates popupmenus. To use the left mousebutton for panning without interfering with cell moving and resizing, use
 * <isUseLeftButton> and <isIgnoreCell>. For grid size steps while panning, use <useGrid>. This handler is built-into <mxGraph.panningHandler> and enabled using
 * <mxGraph.setPanning>.
 * 
 */
public class mxPopupMenu extends mxEventSource {

	public static interface mxIFactoryMethod {
		void invoke(mxPopupMenu menu, mxCell cell, NativeEvent event);
	}

	protected static native JavaScriptObject wrapFactoryMethod(mxIFactoryMethod factoryMethod) /*-{
		var funct = function(menu, cell, event) {
			var menuJ = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(menu);
			var cellJ = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(cell);
			factoryMethod.@com.mxgraph.gwt.client.util.mxPopupMenu.mxIFactoryMethod::invoke(Lcom/mxgraph/gwt/client/util/mxPopupMenu;Lcom/mxgraph/gwt/client/model/mxCell;Lcom/google/gwt/dom/client/NativeEvent;)
			(menuJ, cellJ, event);
		};
		
		return funct;
	}-*/;

	private native JavaScriptObject createJso(mxIFactoryMethod factoryMethod) /*-{
		return new $wnd.mxPopupMenu(
				factoryMethod != null ? @com.mxgraph.gwt.client.util.mxPopupMenu::wrapFactoryMethod(Lcom/mxgraph/gwt/client/util/mxPopupMenu$mxIFactoryMethod;)(factoryMethod)
						: null);
	}-*/;

	/**
	 * Constructs an event handler that creates a popupmenu. The event handler is not installed anywhere in this ctor.
	 */
	public mxPopupMenu() {
		this.jso = createJso(null);
	}

	/**
	 * Constructs an event handler that creates a popupmenu. The event handler is not installed anywhere in this ctor.
	 * 
	 * @param factoryMethod callback interface
	 */
	public mxPopupMenu(mxIFactoryMethod factoryMethod) {
		this.jso = createJso(factoryMethod);
	}
	
	/**
	 * Destroys the handler and all its resources and DOM nodes.
	 */
	public native void destroy() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).destroy();
	}-*/;
}

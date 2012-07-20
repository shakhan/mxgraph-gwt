package com.mxgraph.gwt.client.handler;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.mxgraph.gwt.client.IJavaScriptWrapper;
import com.mxgraph.gwt.client.view.mxGraph;

/**
 * Event handler that listens to keystroke events. This is not a singleton, however, it is normally only required once if the target is the document element
 * (default).
 * 
 * This handler installs a key event listener in the topmost DOM node and processes all events that originate from descandants of <mxGraph.container> or from
 * the topmost DOM node. The latter means that all unhandled keystrokes are handled by this object regardless of the focused state of the <graph>.
 * 
 * Example:
 * 
 * The following example creates a key handler that listens to the delete key (46) and deletes the selection cells if the graph is enabled.
 * 
 * (code) var keyHandler = new mxKeyHandler(graph); keyHandler.bindKey(46, function(evt) { if (graph.isEnabled()) { graph.removeCells(); } }); (end)
 * 
 * Keycodes:
 * 
 * See http://tinyurl.com/yp8jgl or http://tinyurl.com/229yqw for a list of keycodes or install a key event listener into the document element and print the key
 * codes of the respective events to the console.
 * 
 * To support the Command key and the Control key on the Mac, the following code can be used.
 * 
 * (code) keyHandler.getFunction = function(evt) { if (evt != null) { return (mxEvent.isControlDown(evt) || (mxClient.IS_MAC && evt.metaKey)) ?
 * this.controlKeys[evt.keyCode] : this.normalKeys[evt.keyCode]; }
 * 
 * return null; }; (end)
 * 
 */
public class mxKeyHandler implements IJavaScriptWrapper {

	private JavaScriptObject jso;

	public static interface mxKeyHandlerCallback {
		void invoke(NativeEvent event);
	}

	private native JavaScriptObject wrapCallback(mxKeyHandlerCallback callback) /*-{
		var funct = function(evt) {
			callback.@com.mxgraph.gwt.client.handler.mxKeyHandler.mxKeyHandlerCallback::invoke(Lcom/google/gwt/dom/client/NativeEvent;)(evt);
		};

		return funct;
	}-*/;

	@Override public JavaScriptObject getJso() {
		return jso;
	}

	@Override public void setJso(JavaScriptObject jso) {
		this.jso = jso;
	}

	private native JavaScriptObject createJso(JavaScriptObject graph, Element target) /*-{
		return new $wnd.mxKeyHandler(graph, target);
	}-*/;

	/**
	 * Constructs an event handler that executes functions bound to specific keystrokes.
	 * 
	 * @param graph Reference to the associated <mxGraph>.
	 * @param target Optional reference to the event target. If null, the document element is used as the event target, that is, the object where the key event
	 *            listener is installed.
	 */
	public mxKeyHandler(mxGraph graph, Element target) {
		jso = createJso(graph.getJso(), target);
	}

	/**
	 * Binds the specified keycode to the given function. This binding is used if the control key is pressed.
	 * 
	 * @param code Integer that specifies the keycode.
	 * @param callback
	 */
	public native void bindKey(int code, mxKeyHandlerCallback callback) /*-{
		var funct = this.@com.mxgraph.gwt.client.handler.mxKeyHandler::wrapCallback(Lcom/mxgraph/gwt/client/handler/mxKeyHandler$mxKeyHandlerCallback;)(callback);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).bindKey(code, funct);
	}-*/;

	/**
	 * Binds the specified keycode to the given function. This binding is used if the control key is pressed.
	 * 
	 * @param code Integer that specifies the keycode.
	 * @param callback Callback interface that takes the key event as an argument.
	 */
	public native void bindControlKey(int code, mxKeyHandlerCallback callback) /*-{
		var funct = this.@com.mxgraph.gwt.client.handler.mxKeyHandler::wrapCallback(Lcom/mxgraph/gwt/client/handler/mxKeyHandler$mxKeyHandlerCallback;)(callback);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).bindControlKey(code, funct);
	}-*/;

	/**
	 * Binds the specified keycode to the given function. This binding is used if the control and shift key are pressed.
	 * 
	 * @param code Integer that specifies the keycode.
	 * @param callback Callback interface that takes the key event as an argument.
	 */
	public native void bindControlShiftKey(int code, mxKeyHandlerCallback callback) /*-{
		var funct = this.@com.mxgraph.gwt.client.handler.mxKeyHandler::wrapCallback(Lcom/mxgraph/gwt/client/handler/mxKeyHandler$mxKeyHandlerCallback;)(callback);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).bindControlShiftKey(code, funct);
	}-*/;

}

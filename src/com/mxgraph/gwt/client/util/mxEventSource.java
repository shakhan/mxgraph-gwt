package com.mxgraph.gwt.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.mxgraph.gwt.client.IJavaScriptWrapper;

/**
 * Base class for objects that dispatch named events.
 */
public class mxEventSource extends Composite implements IJavaScriptWrapper {

	protected JavaScriptObject jso;

	private native JavaScriptObject createJso(JavaScriptObject eventSource) /*-{
		return new $wnd.mxEventSource(eventSource);
	}-*/;
	
	public static interface mxIEventListener<C> {
		/**
		 * Called when the graph model has changed.
		 * 
		 * @param sender Reference to the source of the event.
		 * @param evt Event object to be dispatched.
		 */
		public void invoke(C sender, mxEventObject evt);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.IJavaScriptWrapper#getJso()
	 */
	@Override
	public JavaScriptObject getJso() {
		return jso;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mxgraph.gwt.client.IJavaScriptWrapper#setJso(com.google.gwt.core.client.JavaScriptObject)
	 */
	@Override
	public void setJso(JavaScriptObject jso) {
		this.jso = jso;
	}

	protected mxEventSource(JavaScriptObject jso) {
		this.jso = jso;
	}

	public mxEventSource() {
	}

	public mxEventSource(IJavaScriptWrapper eventSource) {
		jso = createJso(eventSource.getJso());
	}

	/**
	 * Returns true if events can be fired. Default is true.
	 * 
	 * @return
	 */
	public native boolean isEventsEnabled() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).eventsEnabled;
	}-*/;

	/**
	 * Specifies if events can be fired
	 * 
	 * @param eventsEnabled
	 */
	public native void setEventsEnabled(boolean eventsEnabled) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).eventsEnabled = eventsEnabled;
	}-*/;

	/**
	 * Gets event source.
	 * 
	 * @return event source
	 */
	public native IJavaScriptWrapper getEventSource() /*-{
		var eventSourceJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).eventSource;
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(eventSourceJS);
	}-*/;

	/**
	 * Sets event source.
	 * 
	 * @param eventSource
	 */
	public native void setEventSource(IJavaScriptWrapper eventSource) /*-{
		var eventSourceJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(eventSource);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).eventSource = eventSourceJS;
	}-*/;

	/**
	 * Binds the specified listener to the given event name. If no event name is given, then the listener is registered for all events.
	 * 
	 * @param eventName event to which to attach the listener
	 * @param listener listener
	 */
	public native void addListener(String eventName, mxIEventListener<?> listener) /*-{
		//Creates a native event listener (function) which really is just a delegate for Java listener
		var nativeListener = @com.mxgraph.gwt.client.util.WrapperUtils::wrapCallbackInterface(Lcom/mxgraph/gwt/client/util/mxEventSource$mxIEventListener;)(listener);

		//Binds native JavaScript function to Java listener. Needed when removing listeners 
		nativeListener.listenerHash = listener.@java.lang.Object::hashCode()();
		//Adds listener to native graph model instance
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).addListener(eventName, nativeListener);
	}-*/;

	/**
	 * Removes all occurrences of the given listener from the list of listeners.
	 * 
	 * @param listener listener for removal
	 */
	public native void removeListener(mxIEventListener<?> listener) /*-{
		var listenerHash = listener.@java.lang.Object::hashCode()();
		var eventListenersJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).eventListeners;

		for ( var i = 0; i < eventListenersJS.length; i++) {
			//only remove native listeners whose hash sum matches the hash sum of Java listeners
			if (eventListenersJS[i].listenerHash != null && eventListenersJS[i].listenerHash == listenerHash) {
				@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).removeListener(eventListenersJS[i]);
			}
		}

	}-*/;
	
	/**
	 * Dispatches the given event name with this object as the event source.
	 * <code>fireEvent(new mxEventObject("eventName", key1, val1, .., keyN, valN))</code>
	 */
	public void fireEvent(mxEventObject evt) {
		fireEvent(evt, null);
	}

	/**
	 * Dispatches the given event name, passing all arguments after the given
	 * name to the registered listeners for the event.
	 */
	public native void fireEvent(mxEventObject eventObject, mxEventSource eventSource) /*-{
		var eventObjectJS = eventObject != null ? @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(eventObject) : null;
		var eventSourceJS = eventSource != null ? @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(eventSource) : null;
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).fireEvent(eventObjectJS, eventSourceJS);
	}-*/;

}

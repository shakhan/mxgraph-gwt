package com.mxgraph.gwt.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.IJavaScriptWrapper;

public class mxEventObject implements IJavaScriptWrapper {

	protected JavaScriptObject jso;

	private native JavaScriptObject createJso(String name) /*-{
		return new $wnd.mxEventObject(name);
	}-*/;

	private mxEventObject() {
	}

	protected mxEventObject(JavaScriptObject jso) {
		this.jso = jso;
	}

	@Override public JavaScriptObject getJso() {
		return jso;
	}

	@Override public void setJso(JavaScriptObject jso) {
		this.jso = jso;
	}

	/**
	 * Constructs a new event for the given name.
	 */
	public mxEventObject(String name) {
		jso = createJso(name);
	}

	/**
	 * Constructs a new event for the given name and properties. The optional properties are specified using a sequence of keys and values, eg.
	 * <code>new mxEventObject("eventName", key1, val1, .., keyN, valN))</code>
	 */
	public mxEventObject(String name, Object... args) {

	}

	public native String getName() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getName();
	}-*/;

	/**
	 * Returns the property for the given key.
	 * 
	 * @param key property key
	 * @return property value
	 */
	//TODO allow method to return something other than wrapper instance
	public native Object getProperty(String key) /*-{
		var valueJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getProperty(key);
		
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(valueJS);
	}-*/;

}

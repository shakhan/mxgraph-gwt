package com.mxgraph.gwt.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * All classes that intend to expose the JavaScriptObject via wrapping should implement this interface.
 * @author JGraph
 *
 */
public interface IJavaScriptWrapper {

	/**
	 * Gets the wrapped object from this wrapper.
	 * @return wrapped JavaScriptObject
	 */
	JavaScriptObject getJso();
	
	/**
	 * Sets the wrapped object to this wrapper.
	 * @param jso JavaScriptObject that will get wrapped.
	 */
	void setJso(JavaScriptObject jso);
}

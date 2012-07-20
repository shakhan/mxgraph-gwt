package com.mxgraph.gwt.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.IJavaScriptWrapper;

/**
 * Encapsulates the URL, width and height of an image.
 *
 */
public class mxImage implements IJavaScriptWrapper {

	private JavaScriptObject jso;
	
	private native JavaScriptObject createJso(String src, int width, int height) /*-{
		return new $wnd.mxImage(src, width, height);
	}-*/;
	
	@Override public JavaScriptObject getJso() {
		return jso;
	}

	@Override public void setJso(JavaScriptObject jso) {
		this.jso = jso;
	}
	
	private mxImage() {}
	
	/**
	 * Constructs a new image.
	 */
	public mxImage(String src, int width, int height) {
		jso = createJso(src, width, height);
	}

	
}

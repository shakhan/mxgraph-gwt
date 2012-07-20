package com.mxgraph.gwt.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.mxgraph.gwt.client.IJavaScriptWrapper;

public class mxXmlRequest implements IJavaScriptWrapper {

	private JavaScriptObject jso;

	private native JavaScriptObject createJso(String url, String params, String method, boolean async, String username, String password) /*-{
		return new $wnd.mxXmlRequest(url, params, method, async, username, password);
	}-*/;

	@Override public JavaScriptObject getJso() {
		return jso;
	}

	@Override public void setJso(JavaScriptObject jso) {
		this.jso = jso;
	}

	protected mxXmlRequest() {
	}

	public mxXmlRequest(String url, String params, String method, boolean async, String username, String password) {
		jso = createJso(url, params, method, async, username, password);
	}

	public mxXmlRequest(String url, String params, String method, boolean async) {
		jso = createJso(url, params, method, async, null, null);
	}

	/**
	 * Returns the document element of the response XML document.
	 * 
	 * @return
	 */
	public native Element getDocumentElement() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getDocumentElement();
	}-*/;

	/**
	 * Creates and posts a request to the given target URL using a dynamically created form inside the given document.
	 * 
	 * @param document Document that contains the form element.
	 * @param targe  Target to send the form result to.
	 */
	public native void simulate(Document document, String target) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).simulate(document, target);
	}-*/;
}

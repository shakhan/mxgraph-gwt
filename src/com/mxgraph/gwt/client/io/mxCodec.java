package com.mxgraph.gwt.client.io;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Node;
import com.mxgraph.gwt.client.IJavaScriptWrapper;
import com.mxgraph.gwt.client.model.mxGraphModel;
import com.mxgraph.gwt.client.view.mxGraph;

public class mxCodec implements IJavaScriptWrapper {

	private JavaScriptObject jso;

	private native JavaScriptObject createJso(Document document) /*-{
		return new $wnd.mxCodec(document)
	}-*/;

	@Override public JavaScriptObject getJso() {
		return jso;
	}

	@Override public void setJso(JavaScriptObject jso) {
		this.jso = jso;
	}

	public mxCodec(Document document) {
		jso = createJso(document);
	}

	/**
	 * Decodes the given XML node. The optional "into" argument specifies an existing object to be used. If no object is given, then a new instance is created
	 * using the constructor from the codec.
	 * 
	 * The function returns the passed in object or the new instance if no object was given.
	 * 
	 * @param node XML node to be decoded.
	 * @param into Optional object to be decoded into.
	 * @return
	 */
	public native IJavaScriptWrapper decode(Node node, IJavaScriptWrapper into) /*-{
		var intoJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(into);
		var decodedJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).decode(node, intoJS);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(decodedJS);
	}-*/;

	public native Document decode(Node node, mxGraphModel graphModel) /*-{
		var intoJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(graphModel);
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).decode(node, intoJS);
	}-*/;

	public native Node encode(mxGraphModel graphModel) /*-{
		var intoJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(graphModel);
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).encode(intoJS);
	}-*/;

}

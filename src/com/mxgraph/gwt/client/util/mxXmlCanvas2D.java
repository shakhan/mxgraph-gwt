package com.mxgraph.gwt.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

public class mxXmlCanvas2D extends mxAbstractCanvas2D {

	private native JavaScriptObject createJso(Element root) /*-{
		return new $wnd.mxXmlCanvas2D(root);
	}-*/;
	
	public mxXmlCanvas2D(Element root) {
		jso = createJso(root);
	}
}

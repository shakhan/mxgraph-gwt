package com.mxgraph.gwt.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.IJavaScriptWrapper;
import com.mxgraph.gwt.client.view.mxCellState;

/**
 * Creates a new image export instance to be used with an export canvas. Here is an example that uses this class to create an image via a backend using
 * <mxXmlExportCanvas>.
 * 
 * (code) var xmlDoc = mxUtils.createXmlDocument(); var root = xmlDoc.createElement('output'); xmlDoc.appendChild(root);
 * 
 * var xmlCanvas = new mxXmlCanvas2D(root); var imgExport = new mxImageExport(); imgExport.drawState(graph.getView().getState(graph.model.root), xmlCanvas);
 * 
 * var bounds = graph.getGraphBounds(); var w = Math.round(bounds.x + bounds.width + 4); var h = Math.round(bounds.y + bounds.height + 4);
 * 
 * var xml = mxUtils.getXml(root); new mxXmlRequest('export', 'format=png&w=' + w + '&h=' + h + '&bg=#F9F7ED&xml=' + encodeURIComponent(xml))
 * .simulate(document, '_blank'); (end)
 * 
 */
public class mxImageExport implements IJavaScriptWrapper {

	private JavaScriptObject jso;

	@Override public JavaScriptObject getJso() {
		return jso;
	}

	@Override public void setJso(JavaScriptObject jso) {
		this.jso = jso;
	}

	private native JavaScriptObject createJso() /*-{
		return new $wnd.mxImageExport();
	}-*/;

	/**
	 * Creates a new image export instance to be used with an export canvas. Here is an example that uses this class to create an image via a backend using
	 * <mxXmlExportCanvas>.
	 * 
	 * (code) var xmlDoc = mxUtils.createXmlDocument(); var root = xmlDoc.createElement('output'); xmlDoc.appendChild(root);
	 * 
	 * var xmlCanvas = new mxXmlCanvas2D(root); var imgExport = new mxImageExport(); imgExport.drawState(graph.getView().getState(graph.model.root), xmlCanvas);
	 * 
	 * var bounds = graph.getGraphBounds(); var w = Math.round(bounds.x + bounds.width + 4); var h = Math.round(bounds.y + bounds.height + 4);
	 * 
	 * var xml = mxUtils.getXml(root); new mxXmlRequest('export', 'format=png&w=' + w + '&h=' + h + '&bg=#F9F7ED&xml=' + encodeURIComponent(xml))
	 * .simulate(document, '_blank'); (end)
	 */
	public mxImageExport() {
		this.jso = createJso();
	}

	/**
	 * Draws the given state and all its descendants to the given canvas.
	 * 
	 * @param state
	 * @param canvas
	 */
	public native void drawState(mxCellState state, mxAbstractCanvas2D canvas) /*-{
		var stateJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(state);
		var canvasJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(canvas);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).drawState(stateJS, canvasJS);
	}-*/;

}

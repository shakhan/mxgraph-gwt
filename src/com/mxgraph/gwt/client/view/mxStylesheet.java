package com.mxgraph.gwt.client.view;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.IJavaScriptWrapper;

/**
 * Defines the appearance of the cells in a graph. The following example changes the font size for all vertices by changing the default vertex style in-place:
 * <code>
 * getDefaultVertexStyle().put(mxConstants.STYLE_FONTSIZE, 16);
 * </code>
 * 
 * To change the default font size for all cells, set mxConstants.DEFAULT_FONTSIZE.
 */
public class mxStylesheet implements IJavaScriptWrapper {

	protected JavaScriptObject jso;

	mxStylesheet(JavaScriptObject jso) {
		this.jso = jso;
	}

	public mxStylesheet() {
		jso = createJSO();
	}

	private native JavaScriptObject createJSO() /*-{
		return new $wnd.mxStylesheet();
	}-*/;

	@Override
	public JavaScriptObject getJso() {
		return jso;
	}

	@Override
	public void setJso(JavaScriptObject jso) {
		this.jso = jso;
	}

	/**
	 * Stores the specified style under the given name.
	 * 
	 * @param name Name for the style to be stored.
	 * @param style Key, value pairs that define the style.
	 */
	public native void putCellStyle(String name, Map<String, Object> style) /*-{
		var jsStyle = @com.mxgraph.gwt.client.util.CollectionUtils::convertMap(Ljava/util/Map;)(style);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).putCellStyle(name, jsStyle);
	}-*/;

	/**
	 * Returns the cell style for the specified cell or the given defaultStyle if no style can be found for the given stylename.
	 * 
	 * @param name String of the form [(stylename|key=value);] that represents the style.
	 * @param defaultStyle Default style to be returned if no style can be found.
	 * @return Returns the style for the given formatted cell style.
	 */
	public native HashMap<String, Object> getCellsStyle(String name, HashMap<String, Object> defaultStyle) /*-{
		var style = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getCellStyle(name, defaultStyle);
		return @com.mxgraph.gwt.client.util.CollectionUtils::convertMap(Lcom/google/gwt/core/client/JavaScriptObject;)(style);
	}-*/;

	/**
	 * Returns the default style for edges.
	 * 
	 * @return Returns the default edge style.
	 */
	public native Map<String, Object> getDefaultEdgeStyle() /*-{
		var style = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getDefaultEdgeStyle();
		return @com.mxgraph.gwt.client.util.CollectionUtils::convertMap(Lcom/google/gwt/core/client/JavaScriptObject;)(style);
	}-*/;
	
	/**
	 * Returns the default style for vertices.
	 * 
	 * @return
	 */
	public native Map<String, Object> getDefaultVertexStyle() /*-{
		var style = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getDefaultVertexStyle();
		return @com.mxgraph.gwt.client.util.CollectionUtils::convertMap(Lcom/google/gwt/core/client/JavaScriptObject;)(style);
	}-*/;
	
	public void setDefaultVertexStyle(Map<String, Object> style) {
		putCellStyle("defaultVertex", style);
	}

}

package com.mxgraph.gwt.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.mxgraph.gwt.client.IJavaScriptWrapper;
import com.mxgraph.gwt.client.shape.mxRectangleShape;
import com.mxgraph.gwt.client.shape.mxShape;

/**
 * Class: mxOutline
 * 
 * Implements an outline (aka overview) for a graph.
 * 
 * Example:
 * <p>
 * <blockquote>
 * 
 * <pre>
 * Element outlineContainer = DOM.getElementById(&quot;outlineContainer&quot;);
 * mxOutline outline = new mxOutline(graph, outlineContainer);
 * 
 * </pre>
 * 
 * </blockquote>
 * </p>
 */
public class mxOutline extends Composite implements IJavaScriptWrapper {
	
	private static mxOutlineUiBinder uiBinder = GWT.create(mxOutlineUiBinder.class);

	interface mxOutlineUiBinder extends UiBinder<Widget, mxOutline> {
	}

	protected JavaScriptObject jso;
	private mxGraph graph;
	
	public static interface CreateSizerCallback {
		mxShape invoke(CreateSizerCallback old);
	}
	
	public static class DefaultCallback implements CreateSizerCallback {
		
		JavaScriptObject outline;
		JavaScriptObject callback;

		public DefaultCallback(JavaScriptObject outline, JavaScriptObject callback) {
			super();
			this.outline = outline;
			this.callback = callback;
		}

		public native mxShape invoke(CreateSizerCallback old) /*-{
			var sizerJS =  this.@com.mxgraph.gwt.client.view.mxOutline.DefaultCallback::callback.apply(this.@com.mxgraph.gwt.client.view.mxOutline.DefaultCallback::outline );
			return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(sizerJS);
		}-*/;
		
	}
	
	/**
	 * Allows the creation of {@link CreateSizerCallback} callback. Callback will be invoked by mxOutline.createSizer();
	 * 
	 * @param sizerCallback create sizer callback
	 */
	public static native void setCreateSizerCallback(CreateSizerCallback sizerCallback) /*-{
		var old = $wnd.mxOutline.prototype.createSizer;
		var oldJ = @com.mxgraph.gwt.client.view.mxOutline.DefaultCallback::new(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(this, old);
		$wnd.mxOutline.prototype.createSizer = function() {
			var sizerJ = sizerCallback.@com.mxgraph.gwt.client.view.mxOutline.CreateSizerCallback::invoke(Lcom/mxgraph/gwt/client/view/mxOutline$CreateSizerCallback;)(oldJ);
			return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(sizerJ);
		};
	}-*/;


	private native JavaScriptObject createJso(JavaScriptObject graph, Element container) /*-{
		return new $wnd.mxOutline(graph, container);
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
	 * Constructs an empty outline container. To initialize an empty outline, {@link #setGraph(mxGraph)} must be called.
	 * 
	 */
	public mxOutline() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public void setGraph(mxGraph graph) {
		assert jso == null : "Graph has already been set";
		jso = createJso(graph.getJso(), getElement());
	}

	/**
	 * Constructs a new outline for the specified graph inside the given container.
	 * 
	 * @param graph {@link mxGraph} to create the outline for
	 * @param container DOM node that will contain the outline
	 */
	public mxOutline(mxGraph graph, Element container) {
		jso = createJso(graph.getJso(), container);
		setElement(container);
	}
	
	/**
	 * Constructs a new outline for the specified graph inside the given container.
	 * 
	 * @param graph graph {@link mxGraph} to create the outline for
	 * @param containerName name of the DOM node that will contain the outline
	 */
	public mxOutline(mxGraph graph, String containerName) {
		this(graph, DOM.getElementById(containerName));
	}


	/**
	 * Returns the source {@link mxGraph}
	 * 
	 * @return source graph
	 */
	public native mxGraph getSource() /*-{
		var sourceJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).source;
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(sourceJS);
	}-*/;

	/**
	 * Sets the source {@link mxGraph}
	 * 
	 * @param source source {@link mxGraph}
	 */
	public native void setSource(mxGraph source) /*-{
		var sourceJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(source);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).source = sourceJS;
	}-*/;

	/**
	 * Returns the outline {@link mxGraph}
	 * 
	 * @return outline {@link mxGraph}
	 */
	public native mxGraph getOutline() /*-{
		var outlineJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).outline;
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(outlineJS);
	}-*/;

	/**
	 * Sets the outline {@link mxGraph}
	 * 
	 * @param outline outline {@link mxGraph}
	 */
	public native void setOutline(mxGraph outline) /*-{
		var outlineJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(outline);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).outline = outlineJS;
	}-*/;

	/**
	 * Returns the graphRenderHint used for the outline graph. Default is faster
	 * 
	 * @return graphRenderHint
	 */
	public native String getGraphRenderHint() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).graphRenderHint;
	}-*/;

	/**
	 * Sets the graphRenderHint
	 * 
	 * @param hint new value for graphRenderHint
	 */
	public native void setGraphRenderHint(String hint) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).graphRenderHint = hint;
	}-*/;

	/**
	 * Returns true if events are enabled. Default is true.
	 * 
	 * @return true if events are enabled, false otherwise.
	 */
	public native boolean isEnabled() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).enabled;
	}-*/;

	/**
	 * Enables or disables event handling. This implementation
	 * 
	 * @param enabled boolean that specifies the new enabled state.
	 */
	public native void setEnabled(boolean enabled) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).enabled = enabled;
	}-*/;

	/**
	 * showViewPort specifies whether to show viewport rectangle or not. Default is true;
	 * 
	 * @return true if viewport is shown, false otherwise
	 */
	public native boolean isShowViewPort() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).showViewPort;
	}-*/;

	/**
	 * Specifies if a viewport rectangle should be shown.
	 * 
	 * @param showViewPort true if viewport should be shown, false otherwise
	 */
	public native void setShowViewPort(boolean showViewPort) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).showViewPort = showViewPort;
	}-*/;

	/**
	 * Border at the bottom and right. Default is 10;
	 * 
	 * @return border
	 */
	public native int getBorder() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).border;
	}-*/;

	/**
	 * Specifies the border to be added at the bottom and right.
	 * 
	 * @param border new border value
	 */
	public native void setBorder(int border) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).border = border;
	}-*/;

	/**
	 * Gets the size of the sizer handler. Default is 4.
	 * 
	 * @return sizer size.
	 */
	public native int getSizerSize() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).sizerSize;
	}-*/;

	/**
	 * Sets the size of the sizer handler.
	 * 
	 * @param sizerSize new sizer size.
	 */
	public native void setSizerSize(int sizerSize) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).sizerSize = sizerSize;
	}-*/;

	/**
	 * Enables or disables the zoom handling by showing or hiding the respective handle.
	 * 
	 * @param zoomEnabled boolean that specifies the new enabled state.
	 */
	public native void setZoomEnabled(boolean zoomEnabled) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).zoomEnabled = zoomEnabled;
	}-*/;

	/**
	 * Updates the outline.
	 * 
	 * @param revalidate boolean specifying if view should be revalidated
	 */
	public native void update(boolean revalidate) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).update(revalidate);
	}-*/;

	/**
	 * Initializes the outline inside the given container.
	 * 
	 * @param container
	 */
	public native void init(Element container) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).init(container);
	}-*/;
	
	public native mxRectangleShape getSelectionBorder() /*-{
		var sbJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).selectionBorder;
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(sbJS);
	}-*/;

}

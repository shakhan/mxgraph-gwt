package com.mxgraph.gwt.client.handler;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.NativeEvent;
import com.mxgraph.gwt.client.model.mxCell;
import com.mxgraph.gwt.client.model.mxICell;
import com.mxgraph.gwt.client.util.WrapperUtils;
import com.mxgraph.gwt.client.util.mxEventSource;
import com.mxgraph.gwt.client.util.mxImage;
import com.mxgraph.gwt.client.view.mxGraph;

/**
 * * Graph event handler that creates new connections. Uses <mxTerminalMarker> for finding and highlighting the source and target vertices and <factoryMethod>
 * to create the edge instance. This handler is built-into <mxGraph.connectionHandler> and enabled using <mxGraph.setConnectable>.
 * 
 * Example:
 * 
 * (code) new mxConnectionHandler(graph, function(source, target, style) { edge = new mxCell('', new mxGeometry()); edge.setEdge(true); edge.setStyle(style);
 * edge.geometry.relative = true; return edge; }); (end)
 * 
 * Here is an alternative solution that just sets a specific user object for new edges by overriding <insertEdge>.
 * 
 * (code) mxConnectionHandlerInsertEdge = mxConnectionHandler.prototype.insertEdge; mxConnectionHandler.prototype.insertEdge = function(parent, id, value,
 * source, target, style) { value = 'Test';
 * 
 * return mxConnectionHandlerInsertEdge.apply(this, arguments); }; (end)
 * 
 * Using images to trigger connections:
 * 
 * This handler uses mxTerminalMarker to find the source and target cell for the new connection and creates a new edge using <connect>. The new edge is created
 * using <createEdge> which in turn uses <factoryMethod> or creates a new default edge.
 * 
 * The handler uses a "highlight-paradigm" for indicating if a cell is being used as a source or target terminal, as seen in MS Visio and other products. In
 * order to allow both, moving and connecting cells at the same time, <mxConstants.DEFAULT_HOTSPOT> is used in the handler to determine the hotspot of a cell,
 * that is, the region of the cell which is used to trigger a new connection. The constant is a value between 0 and 1 that specifies the amount of the width and
 * height around the center to be used for the hotspot of a cell and its default value is 0.5. In addition, <mxConstants.MIN_HOTSPOT_SIZE> defines the minimum
 * number of pixels for the width and height of the hotspot.
 * 
 * This solution, while standards compliant, may be somewhat confusing because there is no visual indicator for the hotspot and the highlight is seen to switch
 * on and off while the mouse is being moved in and out. Furthermore, this paradigm does not allow to create different connections depending on the highlighted
 * hotspot as there is only one hotspot per cell and it normally does not allow cells to be moved and connected at the same time as there is no clear indication
 * of the connectable area of the cell.
 * 
 * To come across these issues, the handle has an additional <createIcons> hook with a default implementation that allows to create one icon to be used to
 * trigger new connections. If this icon is specified, then new connections can only be created if the image is clicked while the cell is being highlighted. The
 * <createIcons> hook may be overridden to create more than one <mxImageShape> for creating new connections, but the default implementation supports one image
 * and is used as follows:
 * 
 * In order to display the "connect image" whenever the mouse is over the cell, an DEFAULT_HOTSPOT of 1 should be used:
 * 
 * (code) mxConstants.DEFAULT_HOTSPOT = 1; (end)
 * 
 * In order to avoid confusion with the highlighting, the highlight color should not be used with a connect image:
 * 
 * (code) mxConstants.HIGHLIGHT_COLOR = null; (end)
 * 
 * To install the image, the connectImage field of the mxConnectionHandler must be assigned a new <mxImage> instance:
 * 
 * (code) mxConnectionHandler.prototype.connectImage = new mxImage('images/green-dot.gif', 14, 14); (end)
 * 
 * This will use the green-dot.gif with a width and height of 14 pixels as the image to trigger new connections. In createIcons the icon field of the handler
 * will be set in order to remember the icon that has been clicked for creating the new connection. This field will be available under selectedIcon in the
 * connect method, which may be overridden to take the icon that triggered the new connection into account. This is useful if more than one icon may be used to
 * create a connection.
 * 
 * Group: Events
 * 
 * Event: mxEvent.CONNECT
 * 
 * Fires between begin- and endUpdate in <connect>. The <code>cell</code> property contains the inserted edge, the <code>event</code> and <code>target</code>
 * properties contain the respective arguments that were passed to <connect>.
 * 
 */
public class mxConnectionHandler extends mxEventSource {

	private native JavaScriptObject createJso(JavaScriptObject graph, JavaScriptObject factoryMethod) /*-{
		return new $wnd.mxConnectionHandler(graph, factoryMethod);
	}-*/;

	public static interface mxIFactoryMethod {
		mxCell invoke(mxCell source, mxCell target, String style);
	}

	public static interface ConnectCallback {
		void invoke(mxICell source, mxICell target, NativeEvent evt, mxICell dropTarget, ConnectCallback old);
	}

	@SuppressWarnings("unused") private static class DefaultCallback implements ConnectCallback {

		JavaScriptObject handler;
		JavaScriptObject callback;

		public DefaultCallback(mxConnectionHandler handler, JavaScriptObject callback) {
			this.handler = handler.jso;
			this.callback = callback;
		}

		@Override public native void invoke(mxICell source, mxICell target, NativeEvent evt, mxICell dropTarget, ConnectCallback old) /*-{
			var sourceJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(source);
			var targetJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(target);
			var dropTargetJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(dropTarget);

			this.@com.mxgraph.gwt.client.handler.mxConnectionHandler.DefaultCallback::callback.apply(
					this.@com.mxgraph.gwt.client.handler.mxConnectionHandler.DefaultCallback::handler, [ sourceJS, targetJS, evt, dropTargetJS ]);

		}-*/;

	}

	public native void setConnectCallback(ConnectCallback callback) /*-{
		var old = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).connect;
		var oldJ = @com.mxgraph.gwt.client.handler.mxConnectionHandler.DefaultCallback::new(Lcom/mxgraph/gwt/client/handler/mxConnectionHandler;Lcom/google/gwt/core/client/JavaScriptObject;)(this, old);
		
		var funct = function(source, target, evt, dropTarget) {
			var sourceJ = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
			var targetJ = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(target);
			var dropTargetJ = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(dropTarget);
			
			callback.@com.mxgraph.gwt.client.handler.mxConnectionHandler.ConnectCallback::invoke(Lcom/mxgraph/gwt/client/model/mxICell;Lcom/mxgraph/gwt/client/model/mxICell;Lcom/google/gwt/dom/client/NativeEvent;Lcom/mxgraph/gwt/client/model/mxICell;Lcom/mxgraph/gwt/client/handler/mxConnectionHandler$ConnectCallback;)
			(sourceJ, targetJ, evt, dropTargetJ, oldJ);
		};
		
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).connect = funct;
		
	}-*/;

	private mxConnectionHandler() {
	}

	/**
	 * Constructs an event handler that connects vertices.
	 * 
	 * @param graph Reference to the enclosing {@link mxGraph}.
	 */
	public mxConnectionHandler(mxGraph graph) {
		this(graph, null);
	}

	/**
	 * Constructs an event handler that connects vertices using the specified factory method to create the new edges
	 * 
	 * @param graph Reference to the enclosing {@link mxGraph}.
	 * @param factoryMethod Optional function to create the edge.
	 *            {@link mxIFactoryMethod#invoke(com.mxgraph.gwt.client.model.mxCell, com.mxgraph.gwt.client.model.mxCell, String)}
	 */
	public mxConnectionHandler(mxGraph graph, mxIFactoryMethod factoryMethod) {
		jso = createJso(graph.getJso(), factoryMethod != null ? WrapperUtils.wrapCallbackInterface(factoryMethod) : null);
	}

	/**
	 * {@link mxImage} that is used to trigger the creation of a new connection. This is used in <createIcons>. Default is null.
	 * 
	 * @return image
	 */
	public native mxImage getConnectImage() /*-{
		var imageJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).connectImage;
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(imageJS);
	}-*/;

	/**
	 * Sets {@link mxImage} that is used to trigger the creation of a new connection
	 * 
	 * @param image image
	 */
	public native void setConnectImage(mxImage image) /*-{
		var imageJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(image);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).connectImage = imageJS;
	}-*/;

	/**
	 * Returns true if events are handled. Default is true.
	 * 
	 * @return
	 */
	public native boolean isEnabled() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).enabled;
	}-*/;

	/**
	 * Specifies if events are to be handled.
	 * 
	 * @param enabled
	 */
	public native void setEnabled(boolean enabled) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).enabled = enabled;
	}-*/;

	/**
	 * Returns true if target should be created
	 */
	public native boolean isCreateTarget() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).createTarget;
	}-*/;

	/**
	 * Set true if target should be created, false otherwise
	 * 
	 * @param createTarget
	 */
	public native void setCreateTarget(boolean createTarget) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).createTarget = createTarget;
	}-*/;

}

package com.mxgraph.gwt.client.shape;


public class mxStencilRegistry   {
	
	public static native mxStencil addStencil(String name, mxStencil stencil) /*-{
		var stencilJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(stencil);
		var addedStencilJS = $wnd.mxStencilRegistry.addStencil(name, stencilJS);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(addedStencilJS); 
	}-*/;

}

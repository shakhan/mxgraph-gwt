package com.mxgraph.gwt.client.view;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.mxgraph.gwt.client.IJavaScriptWrapper;
import com.mxgraph.gwt.client.util.mxRectangle;

public class mxCellEditor implements IJavaScriptWrapper {
	
	private JavaScriptObject jso;
	
	public interface GetEditorBoundsCallback {
		mxRectangle invoke(mxCellState state, GetEditorBoundsCallback old); 
	}
	
	@SuppressWarnings("unused") private static class DefaultCallback implements GetEditorBoundsCallback {
		
		JavaScriptObject cellEditor;
		JavaScriptObject callback;
		
		public DefaultCallback(mxCellEditor cellEditor, JavaScriptObject callback) {
			this.cellEditor = cellEditor.jso;
			this.callback = callback;
		}

		public native mxRectangle invoke(mxCellState state, GetEditorBoundsCallback old) /*-{
			var stateJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(state);
			var retvalJS =  this.@com.mxgraph.gwt.client.view.mxCellEditor.DefaultCallback::callback.apply(this.@com.mxgraph.gwt.client.view.mxCellEditor.DefaultCallback::cellEditor, [ stateJS ] );
			return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(retvalJS);
		}-*/;
		
	}
	
	/**
	 * Allows redefining the {@link mxCellEditor#getEditorBounds(mxCellState)}
	 * 
	 * @param callback callback interface with the new definition of the function
	 */
	public native void setGetEditorBoundsCallback(GetEditorBoundsCallback callback) /*-{
		var old = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getEditorBounds;
		var oldJ = @com.mxgraph.gwt.client.view.mxCellEditor.DefaultCallback::new(Lcom/mxgraph/gwt/client/view/mxCellEditor;Lcom/google/gwt/core/client/JavaScriptObject;)(this, old);

		var funct = function(state) {
			var stateJ = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(state);
			var retvalJ = callback.@com.mxgraph.gwt.client.view.mxCellEditor.GetEditorBoundsCallback::invoke(Lcom/mxgraph/gwt/client/view/mxCellState;Lcom/mxgraph/gwt/client/view/mxCellEditor$GetEditorBoundsCallback;)(stateJ, oldJ);
			return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(retvalJ);
		};

		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getEditorBounds = funct;
	}-*/; 

	@Override public JavaScriptObject getJso() {
		return jso;
	}

	@Override public void setJso(JavaScriptObject jso) {
		this.jso = jso;
	}
	
	private native JavaScriptObject createJso(JavaScriptObject graph) /*-{
		return new $wnd.mxCellEditor(graph);
	}-*/;
	
	private mxCellEditor() {
	}

	public mxCellEditor(mxGraph graph) {
		jso = createJso(graph.getJso());
	}
	
	/**
	 * Returns the {@link mxRectangle} that defines the bounds of the editor.
	 * 
	 * @param state 
	 * @return
	 */
	public native mxRectangle getEditorBounds(mxCellState state) /*-{
		var stateJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(state);
		var boundsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getEditorBounds(stateJS);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(boundsJS);
	}-*/;
	
	public native Element getTextArea() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).textarea;
	}-*/;

}

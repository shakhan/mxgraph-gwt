package com.mxgraph.gwt.client.util;

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.IJavaScriptWrapper;
import com.mxgraph.gwt.client.model.mxGraphModel;

public class mxUndoableEdit implements IJavaScriptWrapper {

	protected JavaScriptObject jso;

	protected mxUndoableEdit(JavaScriptObject jso) {
		this.jso = jso;
	}

	private mxUndoableEdit() {
	}

	private native JavaScriptObject createJso(IJavaScriptWrapper source, boolean significant) /*-{
		var sourceJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(source);
		return new $wnd.mxUndoableEdit(sourceJS, significant);
	}-*/;

	public mxUndoableEdit(IJavaScriptWrapper source, boolean significant) {
		jso = createJso(source, significant);
	}

	@Override public JavaScriptObject getJso() {
		return jso;
	}

	@Override public void setJso(JavaScriptObject jso) {
		this.jso = jso;

	}

	/**
	 * Returns the list that contains the changes that make up this edit. The changes are expected to either have an undo and redo function, or an execute function.
	 * Default is an empty list.
	 * 
	 * @return list of changes
	 */
	public native List<mxGraphModel.mxChange> getChanges() /*-{
		var changesJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).changes;
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrapList(Lcom/google/gwt/core/client/JavaScriptObject;)(changesJS);
	}-*/;

}

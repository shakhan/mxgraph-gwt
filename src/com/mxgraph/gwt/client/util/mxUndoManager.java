package com.mxgraph.gwt.client.util;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Implements a command history. When changing the graph model, an <mxUndoableChange> object is created at the start of the transaction (when model.beginUpdate
 * is called). All atomic changes are then added to this object until the last model.endUpdate call, at which point the <mxUndoableEdit> is dispatched in an
 * event, and added to the history inside <mxUndoManager>. This is done by an event listener in <mxEditor.installUndoHandler>.
 * 
 * Each atomic change of the model is represented by an object (eg. <mxRootChange>, <mxChildChange>, <mxTerminalChange> etc) which contains the complete undo
 * information. The <mxUndoManager> also listens to the <mxGraphView> and stores it's changes to the current root as insignificant undoable changes, so that
 * drilling (step into, step up) is undone.
 * 
 * This means when you execute an atomic change on the model, then change the current root on the view and click undo, the change of the root will be undone
 * together with the change of the model so that the display represents the state at which the model was changed. However, these changes are not transmitted for
 * sharing as they do not represent a state change.
 * 
 * Example:
 * 
 * When adding an undo manager to a graph, make sure to add it to the model and the view as well to maintain a consistent display across multiple undo/redo
 * steps.
 * 
 * (code) var undoManager = new mxUndoManager(); var listener = function(sender, evt) { undoManager.undoableEditHappened(evt.getProperty('edit')); };
 * graph.getModel().addListener(mxEvent.UNDO, listener); graph.getView().addListener(mxEvent.UNDO, listener); (end)
 * 
 * The code creates a function that informs the undoManager of an undoable edit and binds it to the undo event of <mxGraphModel> and <mxGraphView> using
 * <mxEventSource.addListener>.
 * 
 * Event: mxEvent.CLEAR
 * 
 * Fires after <clear> was invoked. This event has no properties.
 * 
 * Event: mxEvent.UNDO
 * 
 * Fires afer a significant edit was undone in <undo>. The <code>edit</code> property contains the <mxUndoableEdit> that was undone.
 * 
 * Event: mxEvent.REDO
 * 
 * Fires afer a significant edit was redone in <redo>. The <code>edit</code> property contains the <mxUndoableEdit> that was redone.
 * 
 * Event: mxEvent.ADD
 * 
 * Fires after an undoable edit was added to the history. The <code>edit</code> property contains the <mxUndoableEdit> that was added.
 * 
 */
public class mxUndoManager extends mxEventSource {

	private native JavaScriptObject createJso(Integer size) /*-{
		return new $wnd.mxUndoManager(size != null ? size.@java.lang.Integer::intValue() : null);
	}-*/;

	public mxUndoManager() {
	}
	
	/**
	 * Constructs a new undo manager with the given history size. If no history size is given, then a default size of 100 steps is used.
	 * 
	 * @param size history size
	 */
	public mxUndoManager(Integer size) {
		jso = createJso(size);
	}

	/**
	 *  Undoes the last change.
	 */
	public native void undo() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).undo();
	}-*/;

	/**
	 * Redoes the last change.
	 */
	public native void redo() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).redo();
	}-*/;
	
	/**
	 * Method to be called to add new undoable edits to the <history>.
	 * 
	 * @param undoableEdit
	 */
	public native void undoableEditHappened(mxUndoableEdit undoableEdit) /*-{
		var undoableEditJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(undoableEdit);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).undoableEditHappened(undoableEditJS);
	}-*/;
	
	/**
	 * Returns true if an undo is possible.
	 */
	public native boolean canUndo() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).canUndo();
	}-*/;
	
	/**
	 * Returns true if an redo is possible.
	 */
	public native boolean canRedo() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).canRedo();
	}-*/;
	
	/**
	 * Clears the command history.
	 */
	public native void clear() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).clear();
	}-*/;
}

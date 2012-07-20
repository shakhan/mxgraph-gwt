package com.mxgraph.gwt.client.model;

import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.IJavaScriptWrapper;
import com.mxgraph.gwt.client.util.WrapperUtils;
import com.mxgraph.gwt.client.util.mxEventSource;
import com.mxgraph.gwt.client.view.mxCellState;

/**
 * Extends {@link mxEventSource} to implement a graph model. The graph model acts as a wrapper around the cells which are in charge of storing the actual graph
 * datastructure. The model acts as a transactional wrapper with event notification for all changes, whereas the cells contain the atomic operations for
 * updating the actual datastructure.
 * 
 * Layers:
 * 
 * The cell hierarchy in the model must have a top-level root cell which contains the layers (typically one default layer), which in turn contain the top-level
 * cells of the layers. This means each cell is contained in a layer. If no layers are required, then all new cells should be added to the default layer.
 * 
 * Layers are useful for hiding and showing groups of cells, or for placing groups of cells on top of other cells in the display. To identify a layer, the
 * <isLayer> function is used. It returns true if the parent of the given cell is the root of the model.
 * 
 * Encoding the model:
 * 
 * To encode a graph model, use the following code:
 * 
 * (code) var enc = new mxCodec(); var node = enc.encode(graph.getModel()); (end)
 * 
 * This will create an XML node that contains all the model information.
 * 
 * Encoding and decoding changes:
 * 
 * For the encoding of changes, a graph model listener is required that encodes each change from the given array of changes.
 * 
 * (code) model.addListener(mxEvent.CHANGE, function(sender, evt) { var changes = evt.getProperty('edit').changes; var nodes = []; var codec = new mxCodec();
 * 
 * for (var i = 0; i < changes.length; i++) { nodes.push(codec.encode(changes[i])); } // do something with the nodes }); (end)
 * 
 * For the decoding and execution of changes, the codec needs a lookup function that allows it to resolve cell IDs as follows:
 * 
 * (code) var codec = new mxCodec(); codec.lookup = function(id) { return model.getCell(id); } (end)
 * 
 * For each encoded change (represented by a node), the following code can be used to carry out the decoding and create a change object.
 * 
 * (code) var changes = []; var change = codec.decode(node); change.model = model; change.execute(); changes.push(change); (end)
 * 
 * The changes can then be dispatched using the model as follows.
 * 
 * (code) var edit = new mxUndoableEdit(model, false); edit.changes = changes;
 * 
 * edit.notify = function() { edit.source.fireEvent(new mxEventObject(mxEvent.CHANGE, 'edit', edit, 'changes', edit.changes)); edit.source.fireEvent(new
 * mxEventObject(mxEvent.NOTIFY, 'edit', edit, 'changes', edit.changes)); }
 * 
 * model.fireEvent(new mxEventObject(mxEvent.UNDO, 'edit', edit)); model.fireEvent(new mxEventObject(mxEvent.CHANGE, 'edit', edit, 'changes', changes)); (end)
 * 
 * Event: mxEvent.CHANGE
 * 
 * Fires when an undoable edit is dispatched. The <code>edit</code> property contains the <mxUndoableEdit>. The <code>changes</code> property contains the array
 * of atomic changes inside the undoable edit. The changes property is <strong>deprecated</strong>, please use edit.changes instead.
 * 
 * Example:
 * 
 * For finding newly inserted cells, the following code can be used:
 * 
 * (code) graph.model.addListener(mxEvent.CHANGE, function(sender, evt) { var changes = evt.getProperty('edit').changes;
 * 
 * for (var i = 0; i < changes.length; i++) { var change = changes[i];
 * 
 * if (change.constructor == mxChildChange && change.change.previous == null) { graph.startEditingAtCell(change.child); break; } } }); (end)
 * 
 * 
 * Event: mxEvent.NOTIFY
 * 
 * Same as <mxEvent.CHANGE>, this event can be used for classes that need to implement a sync mechanism between this model and, say, a remote model. In such a
 * setup, only local changes should trigger a notify event and all changes should trigger a change event.
 * 
 * Event: mxEvent.EXECUTE
 * 
 * Fires between begin- and endUpdate and after an atomic change was executed in the model. The <code>change</code> property contains the atomic change that was
 * executed.
 * 
 * Event: mxEvent.BEGIN_UPDATE
 * 
 * Fires after the <updateLevel> was incremented in <beginUpdate>. This event contains no properties.
 * 
 * Event: mxEvent.END_UPDATE
 * 
 * Fires after the <updateLevel> was decreased in <endUpdate> but before any notification or change dispatching. The <code>edit</code> property contains the
 * <currentEdit>.
 * 
 * Event: mxEvent.BEFORE_UNDO
 * 
 * Fires before the change is dispatched after the update level has reached 0 in <endUpdate>. The <code>edit</code> property contains the <curreneEdit>.
 * 
 * Event: mxEvent.UNDO
 * 
 * Fires after the change was dispatched in <endUpdate>. The <code>edit</code> property contains the <currentEdit>.
 */
public class mxGraphModel extends mxEventSource implements mxIGraphModel {

	/**
	 * Creates a JavaScript callback function that acts as a delegate to user created filter.
	 * 
	 * @param filter user created filter that gets invoked by native filter delegate
	 * @return native filter delegate
	 */
	protected static native JavaScriptObject createNativeFilterDelegate(Filter filter) /*-{
		var nfd = function(cell) {
			var cellJ = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(cell);
			return filter.@com.mxgraph.gwt.client.model.mxGraphModel.Filter::filter(Lcom/mxgraph/gwt/client/model/mxCell;)(cellJ);
		};
		return nfd;
	}-*/;

	public static interface Filter {
		boolean filter(mxCell cell);
	}

	private native JavaScriptObject createJso(JavaScriptObject root) /*-{
		return new $wnd.mxGraphModel(root);
	}-*/;

	protected mxGraphModel() {
	}

	protected mxGraphModel(JavaScriptObject jso) {
		super(jso);
	}

	/**
	 * Constructs a new graph model. If no root is specified then a new root {@link mxCell} with a default layer is created.
	 * 
	 * @param root {@link mxCell} that represents the root cell.
	 */
	public mxGraphModel(mxICell root) {
		jso = createJso(root != null ? root.getJso() : null);
	}

	/**
	 * Increments the <updateLevel> by one. The event notification is queued until <updateLevel> reaches 0 by use of <endUpdate>.
	 * 
	 * All changes on <mxGraphModel> are transactional, that is, they are executed in a single undoable change on the model (without transaction isolation).
	 * Therefore, if you want to combine any number of changes into a single undoable change, you should group any two or more API calls that modify the graph
	 * model between <beginUpdate> and <endUpdate> calls as shown here:
	 * 
	 * (code) var model = graph.getModel(); var parent = graph.getDefaultParent(); var index = model.getChildCount(parent); model.beginUpdate(); try {
	 * model.add(parent, v1, index); model.add(parent, v2, index+1); } finally { model.endUpdate(); } (end)
	 * 
	 * Of course there is a shortcut for appending a sequence of cells into the default parent:
	 * 
	 * (code) graph.addCells([v1, v2]). (end)
	 */
	public native void beginUpdate() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).beginUpdate();
	}-*/;

	/**
	 * * Decrements the <updateLevel> by one and fires an <undo> event if the <updateLevel> reaches 0. This function indirectly fires a <change> event by
	 * invoking the notify function on the <currentEdit> und then creates a new <currentEdit> using <createUndoableEdit>.
	 * 
	 * The <undo> event is fired only once per edit, whereas the <change> event is fired whenever the notify function is invoked, that is, on undo and redo of
	 * the edit.
	 */
	public native void endUpdate() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).endUpdate();
	}-*/;

	public native mxCell getRoot() /*-{
		var rootJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).root;
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(rootJS);
	}-*/;

	private native JavaScriptObject getCellsJS() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).cells;
	}-*/;

	/**
	 * Gets a map of IDs mapped to cells
	 * 
	 * @return map containing IDs and cells
	 */
	public Map<String, mxCell> getCells() {
		return WrapperUtils.wrapMap(getCellsJS());
	};

	/**
	 * Returns true if the model automatically update parents of edges so that the edge is contained in the nearest-common-ancestor of its terminals.
	 * 
	 * @return Returns true if the model maintains edge parents.
	 */
	public native boolean isMaintainEdgeParent() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).maintainEdgeParent;
	}-*/;

	/**
	 * Specifies if the model automatically updates parents of edges so that the edge is contained in the nearest-common-ancestor of its terminals.
	 * 
	 * @param maintainEdgeParent Boolean indicating if the model should maintain edge parents.
	 */
	public native void setMaintainEdgeParent(boolean maintainEdgeParent) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).maintainEdgeParent = maintainEdgeParent;
	}-*/;

	/**
	 * Returns true if the model automatically creates Ids and resolves Id collisions.
	 * 
	 * @return Returns true if the model creates Ids.
	 */
	public native boolean isCreateIds() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isCreateIds();
	}-*/;

	/**
	 * Specifies if the model automatically creates Ids for new cells and resolves Id collisions.
	 * 
	 * @param value Boolean indicating if the model should created Ids.
	 */
	public native void setCreateIds(boolean createIds) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setCreateIds(createIds);
	}-*/;

	/**
	 * Gets the prefix of new Ids. Default is an empty string.
	 * 
	 * @return
	 */
	public native String getPrefix() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).prefix;
	}-*/;

	/**
	 * Sets the prefix of new Ids.
	 * 
	 * @param prefix
	 */
	public native void setPrefix(String prefix) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).prefix = prefix;
	}-*/;

	/**
	 * Gets the postfix of new Ids. Default is an empty string.
	 * 
	 * @return
	 */
	public native String getPostfix() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).postfix;
	}-*/;

	/**
	 * Sets the postfix of new Ids.
	 * 
	 * @param postfix
	 */
	public native void setPostfix(String postfix) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).postfix = postfix;
	}-*/;

	/**
	 * Returns the counter for the depth of nested transactions. Each call to {@link #beginUpdate} will increment this number and each call to
	 * {@link $endUpdate} will decrement it. When the counter reaches 0, the transaction is closed and the respective events are fired. Initial value is 0.
	 * 
	 * @return counter
	 */
	public native int getUpdateLevel() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).updateLevel;
	}-*/;

	/**
	 * Sets a new root using {@link #createRoot}.
	 */
	public native void clear() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).clear();
	}-*/;

	/**
	 * Creates a new root cell with a default layer (child 0).
	 */
	public native void createRoot() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).createRoot();
	}-*/;

	/**
	 * Returns the {@link mxCell} for the specified Id or null if no cell can be found for the given Id.
	 * 
	 * @param id id of the cell
	 * @return cell
	 */
	public native mxCell getCell(String id) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getCell(id);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(cellJS);
	}-*/;

	public native List<mxCell> filterCells(List<mxCell> cells, Filter filter) /*-{
		var cellsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrapList(Ljava/util/List;)(cells);
		var nfd = @com.mxgraph.gwt.client.model.mxGraphModel::createNativeFilterDelegate(Lcom/mxgraph/gwt/client/model/mxGraphModel$Filter;)(filter);
		var filteredCellsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).filterCells(cellsJS, nfd);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrapList(Lcom/google/gwt/core/client/JavaScriptObject;)(filteredCellsJS);
	}-*/;

	private native JavaScriptObject getDescendantsJS(mxCell parent) /*-{
		var parentJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(parent);
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getDescendants(parentJS);
	}-*/;

	/**
	 * Returns all descendants of the given cell and the cell itself in an list.
	 * 
	 * @param parent {@link mxCell} whose descendants should be returned.
	 * @return list of descendants
	 */
	public List<mxCell> getDescendants(mxCell parent) {
		return WrapperUtils.wrapList(getDescendantsJS(parent));
	}

	/**
	 * Visits all cells recursively and applies the specified filter to each cell. If the function returns true then the cell is added to the resulting array.
	 * The parent and result parameters are optional. If parent is not specified then the recursion starts at <root>.
	 * 
	 * @param filter Java object with a method that takes an {@link mxCell} as an argument and returns a boolean.
	 * @param parent Optional {@link mxCell} that is used as the root of the recursion.
	 * @return
	 */
	public native List<mxCell> filterDescendants(Filter filter, mxCell parent) /*-{
		var parentJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(parent);
		var nfd = @com.mxgraph.gwt.client.model.mxGraphModel::createNativeFilterDelegate(Lcom/mxgraph/gwt/client/model/mxGraphModel$Filter;)(filter);
		var descendantsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).filterDescendants(nfd,
				parentJS);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrapList(Lcom/google/gwt/core/client/JavaScriptObject;)(descendantsJS);

	}-*/;

	/**
	 * Returns the root of the model or the topmost parent of the given cell.
	 * 
	 * @param cell Optional @{link mxCell} that specifies the child.
	 * 
	 * @return root cell
	 */
	public native mxCell getRoot(mxCell cell) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(cellJS);
	}-*/;

	/**
	 * Sets the <root> of the model using <mxRootChange> and adds the change to the current transaction. This resets all data structures in the model and is the
	 * preferred way of clearing an existing model. Returns the new root.
	 * 
	 * @param root {@link mxCell} that specifies the new root.
	 */
	public native void setRoot(mxCell root) /*-{
		var rootJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(root).root;
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setRoot(rootJS);
	}-*/;

	/**
	 * Returns true if the given cell is the root of the model and a non-null value.
	 * 
	 * @param root {@link mxCell} that represents the possible root.
	 * @return
	 */
	public native boolean isRoot(mxCell root) /*-{
		var rootJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(root).root;
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isRoot(rootJS);
	}-*/;

	/**
	 * Returns true if <isRoot> returns true for the parent of the given cell.
	 * 
	 * @param cell {@link mxCell} that represents the possible layer.
	 * @return
	 */
	public native boolean isLayer(mxCell cell) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(root).cell;
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isLayer(cellJS);
	}-*/;

	/**
	 * Returns true if the given parent is an ancestor of the given child.
	 * 
	 * @param parent {@link mxCell} that specifies the parent.
	 * @param child {@link mxCell} that specifies the child.
	 * @return
	 */
	public native boolean isAncestor(mxCell parent, mxCell child) /*-{
		var parentJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(parent).cell;
		var childJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(child).cell;
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isAncestor(parentJS, childJS);
	}-*/;

	/**
	 * Returns true if the model contains the given {@link mxCell}.
	 * 
	 * @param cell {@link mxCell} that specifies the cell.
	 * @return
	 */
	public native boolean contains(mxCell cell) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(root).cell;
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).contains(cellJS);
	}-*/;

	/**
	 * Returns the parent of the given cell.
	 * 
	 * @param cell @{link mxCell} whose parent should be returned.
	 * @return parent cell
	 */
	public native mxCell getParent(mxCell cell) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		var parentJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getParent(cellJS);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(parentJS);
	}-*/;

	/**
	 * Adds the specified child to the parent at the given index using @{link mxChildChange} and adds the change to the current transaction. If no index is
	 * specified then the child is appended to the parent's array of children. Returns the inserted child.
	 * 
	 * @param parent
	 * @param child
	 * @param index
	 * @return
	 */
	public native mxCell add(mxCell parent, mxCell child, Integer index) /*-{
		var parentJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(parent).cell;
		var childJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(child).cell;
		var indexJS = index != null ? index.@java.lang.Integer::intValue() : null;
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isAncestor(parentJS, childJS, indexJS);
		return child;
	}-*/;

	/**
	 * Hook method to create an Id for the specified cell. This implementation concatenates <prefix>, id and <postfix> to create the Id and increments <nextId>.
	 * The cell is ignored by this implementation, but can be used in overridden methods to prefix the Ids with eg. the cell type.
	 * 
	 * @param cell @{link mxCell} to create the Id for.
	 * @return created Id
	 */
	public native String createId(mxCell cell) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).createId(cellJS);
	}-*/;

	/**
	 * Updates the parent for all edges that are connected to cell or one of its descendants
	 * 
	 * @param cell
	 * @param root
	 */
	public native void updateEdgeParents(mxCell cell, mxCell root) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		var rootJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(root);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).updateEdgeParents(cellJS, rootJS);
	}-*/;

	/**
	 * Returns the absolute, accumulated origin for the children inside the given parent as an {@link mxPoint}.
	 * 
	 * @param cell
	 * @return
	 */
	public native mxPoint getOrigin(mxCell cell) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		var pointJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getOrigin(cellJS);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(pointJS);
	}-*/;

	/**
	 * Returns the nearest common ancestor for the specified cells.
	 * 
	 * @param cell1 {@link mxCell} that specifies the first cell in the tree.
	 * @param cell2 {@link mxCell} that specifies the second cell in the tree.
	 * @return
	 */
	public native mxCell getNearestCommonAncestor(mxCell cell1, mxCell cell2) /*-{
		var cell1JS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell1);
		var cell2JS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell2);
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getNearestCommonAncestor(cell1JS,
				cell2JS);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(cellsJS);
	}-*/;

	/**
	 * Removes the specified cell from the model using <mxChildChange> and adds the change to the current transaction. This operation will remove the cell and
	 * all of its children from the model. Returns the removed cell.
	 * 
	 * @param cell {@link mxCell} that should be removed.
	 * @return removed cell
	 */
	public native mxCell remove(mxCell cell) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).remove(cellJS);
		return cell;
	}-*/;

	/**
	 * Returns the number of children in the given cell.
	 * 
	 * @param cell {@link mxCell} whose number of children should be returned.
	 * @return child count
	 */
	public native int getChildCount(mxCell cell) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getChildCount(cellJS);
	}-*/;

	/**
	 * Returns the child of the given {@link mxCell} at the given index.
	 * 
	 * @param index Integer that specifies the index of the child to be returned.
	 * @return mxCell at specified position or null
	 */
	public native mxCell getChildAt(int index) /*-{
		var childJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getChildAt(index);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(childJS);
	}-*/;

	/**
	 * Returns the child of the given {@link mxCell} at the given index.
	 * 
	 * @param cell {@link mxCell} that represents the parent.
	 * @return
	 */
	public native List<mxCell> getChildren(mxCell cell) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		var childrenJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getChildren(cellJS);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrapList(Lcom/google/gwt/core/client/JavaScriptObject;)(childrenJS);
	}-*/;

	/**
	 * Returns the child vertices of the given parent.
	 * 
	 * @param parent {@link mxCell} whose child vertices should be returned.
	 * @return
	 */
	public native List<mxCell> getChildVertices(mxCell parent) /*-{
		var parentJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(parent);
		var childVerticesJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getChildVertices(parentJS);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrapList(Lcom/google/gwt/core/client/JavaScriptObject;)(childVerticesJS);
	}-*/;

	/**
	 * Returns the child edges of the given parent.
	 * 
	 * @param parent {@link mxCell} whose child edges should be returned.
	 * @return child edges
	 */
	public native List<mxCell> getChildEges(mxCell parent) /*-{
		var parentJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(parent);
		var childEdgesJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getChildEges(parentJS);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrapList(Lcom/google/gwt/core/client/JavaScriptObject;)(childEdgesJS);
	}-*/;

	/**
	 * Returns the children of the given cell that are vertices and/or edges depending on the arguments.
	 * 
	 * @param parent {@link mxCell} the represents the parent.
	 * @param vertices Boolean indicating if child vertices should be returned. Default is false.
	 * @param edges Boolean indicating if child edges should be returned. Default is false.
	 * @return list of child cells
	 */
	public native List<mxCell> getChildCells(mxCell parent, boolean vertices, boolean edges) /*-{
		var parentJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(parent);
		var childCellsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getChildCells(parentJS);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrapList(Lcom/google/gwt/core/client/JavaScriptObject;)(childCellsJS);
	}-*/;

	/**
	 * Returns the source or target {@link mxCell} of the given edge depending on the value of the boolean parameter.
	 * 
	 * @param edge {@link mxCell} that specifies the edge.
	 * @param isSource Boolean indicating which end of the edge should be returned.
	 * @return
	 */
	public native mxCell getTerminal(mxCell edge, boolean isSource) /*-{
		var edgeJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(edge);
		var terminalJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getTerminal(edgeJS, isSource);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(terminalJS);
	}-*/;

	/**
	 * Sets the source or target terminal of the given {@link mxCell} using mxTerminalChange and adds the change to the current transaction. This implementation
	 * updates the parent of the edge using {@link #updateEdgeParents(mxCell, mxCell)} if required.
	 * 
	 * @param edge {@link mxCell} that specifies the edge.
	 * @param terminal {@link mxCell} that specifies the new terminal.
	 * @param isSource Boolean indicating if the terminal is the new source or target terminal of the edge.
	 */
	public native void setTerminal(mxCell edge, mxCell terminal, boolean isSource) /*-{
		var edgeJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(edge);
		var terminalJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(terminal);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setTerminal(edgeJS, terminalJS, isSource);
	}-*/;

	/**
	 * Sets the source and target {@link mxCell} of the given mxCell in a single transaction using {@link #setTerminal(mxCell, mxCell, boolean)} for each end of
	 * the edge.
	 * 
	 * @param edge <mxCell> that specifies the edge.
	 * @param source <mxCell> that specifies the new source terminal.
	 * @param target <mxCell> that specifies the new target terminal.
	 */
	public native void setTerminals(mxCell edge, mxCell source, mxCell target) /*-{
		var edgeJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(edge);
		var sourceJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(source);
		var targetJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(target);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setTerminals(edgeJS, sourceJS, targetJS);
	}-*/;

	/**
	 * Returns the number of distinct edges connected to the given cell.
	 * 
	 * @param cell {@link mxCell} that represents the vertex.
	 * @return
	 */
	public native int getEdgeCount(mxCell cell) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getEdgeCount(cellJS);
	}-*/;

	/**
	 * Returns the edge of cell at the given index.
	 * 
	 * @param cell {@link mxCell} that specifies the vertex.
	 * @param index Integer that specifies the index of the edge
	 * @return
	 */
	public native mxCell getEdgeAt(mxCell cell, int index) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		var edgeJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getEdgeAt(cellJS);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(edgeJS);
	}-*/;

	/**
	 * Returns the number of incoming or outgoing edges, ignoring the given edge.
	 * 
	 * @param cell mxCell whose edge count should be returned.
	 * @param outgoing Boolean that specifies if the number of outgoing or incoming edges should be returned.
	 * @param ignoredEdge mxCell that represents an edge to be ignored.
	 * @return
	 */
	public native int getDirectedEdgeCount(mxCell cell, boolean outgoing, mxCell ignoredEdge) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		var ignoredEdgeJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(ignoredEdge);
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getDirectedEdgeCount(cellJS, outgoing,
				ignoredEdgeJS);
	}-*/;

	/**
	 * Returns all edges of the given cell without loops.
	 * 
	 * @param cell {@link mxCell} whose edges should be returned.
	 * @return
	 */
	public native List<mxCell> getConnections(mxCell cell) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		var connectionsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getConnections(cellJS);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrapList(Lcom/google/gwt/core/client/JavaScriptObject;)(connectionsJS);
	}-*/;

	/**
	 * Returns the incoming edges of the given cell without loops.
	 * 
	 * @param cell {@link mxCell} whose incoming edges should be returned.
	 * @return
	 */
	public native List<mxCell> getIncomingEdges(mxCell cell) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		var edgesJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getIncomingEdges(cellJS);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrapList(Lcom/google/gwt/core/client/JavaScriptObject;)(edgesJS);
	}-*/;

	/**
	 * Returns the outgoing edges of the given cell without loops.
	 * 
	 * @param cell {@link mxCell} whose outgoing edges should be returned.
	 * @return
	 */
	public native List<mxCell> getOutgoingEdges(mxCell cell) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		var edgesJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getOutgoingEdges(cellJS);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrapList(Lcom/google/gwt/core/client/JavaScriptObject;)(edgesJS);
	}-*/;

	/**
	 * Returns all edges connected to this cell including loops.
	 * 
	 * @param cell cell whose edges should be returned.
	 * @return list of edges
	 */
	public List<mxCell> getEdges(mxCell cell) {
		return getEdges(cell, true, true, true);
	}

	/**
	 * Returns all distinct edges connected to this cell as a new array of {@link mxCellState}. If at least one of incoming or outgoing is true, then loops are
	 * ignored, otherwise if both are false, then all edges connected to the given cell are returned including loops.
	 * 
	 * @param cell {@link mxCell} that specifies the cell.
	 * @param incoming boolean that specifies if incoming edges should be returned.
	 * @param outgoing boolean that specifies if outgoing edges should be returned.
	 * @param includeLoops boolean that specifies if loops should be returned.
	 * @return Returns the list of connected edges for the given cell.
	 */
	public native List<mxCell> getEdges(mxCell cell, boolean incoming, boolean outgoing, boolean includeLoops) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		var edgesJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getEdges(cellJS);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrapList(Lcom/google/gwt/core/client/JavaScriptObject;)(edgesJS);
	}-*/;

	/**
	 * Returns all edges from the given source to the given target.
	 * 
	 * @param source the source cell.
	 * @param target the target cell.
	 * @return Returns all edges from source to target.
	 */
	public List<mxCell> getEdgesBetween(mxCell source, mxCell target) {
		return getEdgesBetween(source, target, false);
	}

	/**
	 * Returns all edges between the given source and target pair. If directed is true, then only edges from the source to the target are returned, otherwise,
	 * all edges between the two cells are returned.
	 * 
	 * @param source {@link mxCell} that defines the source terminal of the edge to be returned.
	 * @param target {@link mxCell} that defines the target terminal of the edge to be returned.
	 * @param directed boolean that specifies if the direction of the edge should be taken into account.
	 * @return list of edges
	 */
	public native List<mxCell> getEdgesBetween(mxCell source, mxCell target, boolean directed) /*-{
		var sourceJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(source);
		var targetJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(target);
		var edgesJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getEdgesBetween(sourceJS, targetJS,
				directed);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrapList(Lcom/google/gwt/core/client/JavaScriptObject;)(edgesJS);
	}-*/;

	/**
	 * Returns all opposite vertices wrt terminal for the given edges, only returning sources and/or targets as specified. The result is returned as a list of
	 * mxCell.
	 * 
	 * @param edges list of mxCells that contain the edges to be examined.
	 * @param terminal {@link mxCell} that specifies the known end of the edges.
	 * @param sources Boolean that specifies if source terminals should be contained in the result.
	 * @param targets Boolean that specifies if target terminals should be contained in the result.
	 * @return list of cells
	 */
	public native List<mxCell> getOpposites(List<mxCell> edges, mxCell terminal, boolean sources, boolean targets) /*-{
		var edgesJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrapList(Ljava/util/List;)(edges);
		var sourceJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
	}-*/;

	/**
	 * Returns the topmost cells of the hierarchy in an array that contains no descendants for each {@link mxCell} that it contains. Duplicates should be
	 * removed in the cells array to improve performance.
	 * 
	 * @param cells list of cells whose topmost ancestors should be returned.
	 * @return
	 */
	public native List<mxCell> getTopmostCells(List<mxCell> cells) /*-{
		var cellsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrapList(Ljava/util/List;)(cells);
		var topCellsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getTopmostCells(cellsJS);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrapList(Lcom/google/gwt/core/client/JavaScriptObject;)(topCellsJS);
	}-*/;

	/**
	 * Returns true if the given cell is a vertex.
	 * 
	 * @param cell {@link mxCell} that represents the possible vertex.
	 * @return
	 */
	public native boolean isVertex(mxICell cell) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		var retvalJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isVertex(cellJS);
		return typeof retvalJS == "boolean" ? retvalJS : retvalJS == 0 ? false : true;
	}-*/;

	/**
	 * Returns true if the given cell is an edge.
	 * 
	 * @param cell {@link mxCell} that represents the possible edge.
	 * @return
	 */
	public native boolean isEdge(mxICell cell) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		var retvalJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isEdge(cellJS);
		return typeof retvalJS == "boolean" ? retvalJS : retvalJS == 0 ? false : true;
	}-*/;

	/**
	 * Returns true if the given {@link mxCell} is connectable. If edgesConnectable is false, then this function returns false for all edges else it returns the
	 * return value of {@link mxCell#isConnectable()}.
	 * 
	 * @param cell mxCell whose connectable state should be returned.
	 * @return
	 */
	public native boolean isConnectable(mxCell cell) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isConnectable(cellJS);
	}-*/;

	/**
	 * Returns the user object of the given {@link mxCell} using {@link mxCell#getValue()}.
	 * 
	 * @param cell {@link mxCell} whose user object should be returned.
	 * @return Returns the user object of the given cell.
	 */
	public native Object getValue(mxCell cell) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getValue(cellsJS);
	}-*/;

	/**
	 * Sets the user object of then given {@link mxCell} using {@link mxValueChange} and adds the change to the current transaction.
	 * 
	 * @param cell {@link mxCell} whose user object should be changed.
	 * @param value Object that defines the new user object.
	 * @return Returns the new value.
	 */
	public native String setValue(mxICell cell, Object value) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setValue(cellJS, value);
	}-*/;

	/**
	 * Returns the {@link mxGeometry} of the given {@link mxCell}.
	 * 
	 * @param cell
	 * @return
	 */
	public native mxGeometry getGeometry(mxCell cell) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		var geometryJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getGeometry(cellJS);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(geometryJS);
	}-*/;

	public static abstract class mxChange implements IJavaScriptWrapper {

		protected JavaScriptObject jso;

		protected mxChange() {
		}

		@Override public JavaScriptObject getJso() {
			return jso;
		}

		@Override public void setJso(JavaScriptObject jso) {
			this.jso = jso;
		}

		public native void execute() /*-{
			@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).execute();
		}-*/;
	}

	public static class mxRootChange extends mxChange {

		private native JavaScriptObject createJso(JavaScriptObject model, JavaScriptObject root) /*-{
			return new $wnd.mxRootChange(model, root);
		}-*/;

		private mxRootChange() {
		}

		public mxRootChange(mxGraphModel model, mxCell root) {
			jso = createJso(model.getJso(), root.getJso());
		}
	}

	public static class mxChildChange extends mxChange {

		private native JavaScriptObject createJso(JavaScriptObject model, JavaScriptObject parent, JavaScriptObject child, int index) /*-{
			return new $wnd.mxChildChange(model, parent, child, index);
		}-*/;

		private mxChildChange() {
		}

		public mxChildChange(mxGraphModel model, mxCell parent, mxCell child, int index) {
			jso = createJso(model.getJso(), parent.getJso(), child.getJso(), index);
		}
	}

	public static class mxTerminalChange extends mxChange {

		private native JavaScriptObject createJso(JavaScriptObject model, JavaScriptObject cell, JavaScriptObject terminal, JavaScriptObject source) /*-{
			return new $wnd.mxTerminalChange(model, cell, terminal, source);
		}-*/;

		private mxTerminalChange() {
		}

		public mxTerminalChange(mxGraphModel model, mxCell cell, mxCell terminal, mxCell source) {
			jso = createJso(model.getJso(), cell.getJso(), terminal.getJso(), source.getJso());
		}
	}

	public static class mxValueChange extends mxChange {

		private native JavaScriptObject createJso(JavaScriptObject model, JavaScriptObject cell, Object value) /*-{
			return new $wnd.mxValueChange(model, cell, value);
		}-*/;

		private mxValueChange() {
		}

		public mxValueChange(mxGraphModel model, mxCell cell, Object value) {
			jso = createJso(model.getJso(), cell.getJso(), value);
		}
	}

	public static class mxStyleChange extends mxChange {

		private native JavaScriptObject createJso(JavaScriptObject model, JavaScriptObject cell, String style) /*-{
			return new $wnd.mxStyleChange(model, cell, style);
		}-*/;

		private mxStyleChange() {
		}

		public mxStyleChange(mxGraphModel model, mxCell cell, String style) {
			jso = createJso(model.getJso(), cell.getJso(), style);
		}
	}

	public static class mxGeometryChange extends mxChange {

		private native JavaScriptObject createJso(JavaScriptObject model, JavaScriptObject cell, JavaScriptObject geometry) /*-{
			return new $wnd.mxGeometryChange(model, cell, geometry);
		}-*/;

		private mxGeometryChange() {
		}

		public mxGeometryChange(mxGraphModel model, mxCell cell, mxGeometry geometry) {
			jso = createJso(model.getJso(), cell.getJso(), geometry.getJso());
		}
	}

	public static class mxCollapseChange extends mxChange {

		private native JavaScriptObject createJso(JavaScriptObject model, JavaScriptObject cell, boolean collapse) /*-{
			return new $wnd.mxCollapseChange(model, cell, collapse);
		}-*/;

		private mxCollapseChange() {
		}

		public mxCollapseChange(mxGraphModel model, mxCell cell, boolean collapse) {
			jso = createJso(model.getJso(), cell.getJso(), collapse);
		}
	}

	public static class mxVisibleChange extends mxChange {

		private native JavaScriptObject createJso(JavaScriptObject model, JavaScriptObject cell, boolean visible) /*-{
			return new $wnd.mxVisibleChange(model, cell, visible);
		}-*/;

		private mxVisibleChange() {
		}

		public mxVisibleChange(mxGraphModel model, mxCell cell, boolean visible) {
			jso = createJso(model.getJso(), cell.getJso(), visible);
		}
	}

	public static class mxCellAttributeChange extends mxChange {

		private native JavaScriptObject createJso(JavaScriptObject cell, String attribute, String value) /*-{
			return new $wnd.mxCellAttributeChange(cell, attribute, value);
		}-*/;

		private mxCellAttributeChange() {
		}

		public mxCellAttributeChange(mxICell cell, String attribute, String value) {
			jso = createJso(cell.getJso(), attribute, value);
		}
	}

	/**
	 * Returns the style of the given {@link mxCell}.
	 * 
	 * @param cell
	 * @return
	 */
	public native String getStyle(mxICell cell) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getStyle(cellJS);
	}-*/;

	/**
	 * Sets the {@link mxGeometry} of the given {@link mxCell}. The actual update of the cell is carried out in <geometryForCellChanged>. The
	 * {@link mxGeometryChange} action is used to encapsulate the change.
	 * 
	 * @param cell
	 * @param geometry
	 * @return
	 */
	public native mxGeometry setGeometry(mxCell cell, mxGeometry geometry) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		var geometryJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(geometry);
		var retvalJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setGeometry(cellJS, geometryJS);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(retvalJS);
	}-*/;

	/**
	 * Returns true if the given {@link mxCell} is visible.
	 * 
	 * @param cell {@link mxCell} whose visible state should be returned.
	 * @return
	 */
	public native boolean isVisible(mxICell cell) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isVisible(cellJS);
	}-*/;

	/**
	 * Sets the visible state of the given {@link mxCell} using {@link mxVisibleChange} and adds the change to the current transaction.
	 * 
	 * @param cell {@link mxCell} whose visible state should be changed.
	 * @param visible Boolean that specifies the new visible state.
	 * @return
	 */
	public native boolean setVisible(mxICell cell, boolean visible) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setVisible(cellJS, visible);
	}-*/;

	/**
	 * Merges the children of the given cell into the given target cell inside this model. All cells are cloned unless there is a corresponding cell in the
	 * model with the same id, in which case the source cell is ignored and all edges are connected to the corresponding cell in this model. Edges are
	 * considered to have no identity and are always cloned unless the cloneAllEdges flag is set to false, in which case edges with the same id in the target
	 * model are reconnected to reflect the terminals of the source edges.
	 * 
	 * @param from source {@link mxCell}
	 * @param to target {@link mxCell}
	 * @param cloneAllEdges optional boolean specifying if all edges should be cloned
	 */
	public native void mergeChildren(mxICell from, mxICell to, Boolean cloneAllEdges) /*-{
		var fromJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(from);
		var toJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(to);
		var cloneAllEdgesJS = cloneAllEdges != null ? cloneAllEdges.@java.lang.Boolean::booleanValue()() : null;
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).mergeChildren(fromJS, toJS, cloneAllEdgesJS);

	}-*/;

	/**
	 * Returns the source or target {@link mxCell} of the given edge depending on the value of the boolean parameter.
	 * 
	 * @param cell {@link mxCell} that specifies the edge.
	 * @param isSource Boolean indicating which end of the edge should be returned.
	 * @return
	 */
	public native mxICell getTerminal(mxICell cell, boolean isSource) /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cell);
		var retvalJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getTerminal(cellJS, isSource);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(retvalJS);
	}-*/;

	/**
	 * Executes the given edit and fires events if required. The edit object requires an execute function which is invoked. The edit is added to the
	 * currentEdit between beginUpdate and endUpdate calls, so that events will be fired if this execute is an individual transaction, that is, if no
	 * previous beginUpdate calls have been made without calling endUpdate. This implementation fires an execute event before executing the given change.
	 * 
	 * @param change
	 */
	public native void execute(mxChange change) /*-{
		var changeJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(change);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).execute(changeJS);
	}-*/;
}

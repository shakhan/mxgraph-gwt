package com.mxgraph.gwt.client.util;

import java.util.List;

import com.mxgraph.gwt.client.model.mxCell;
import com.mxgraph.gwt.client.view.mxGraph;

/**
 * 
 * Singleton that implements a clipboard for graph cells.
 * 
 * Example:
 * 
 * (code) mxClipboard.copy(graph); mxClipboard.paste(graph2); (end)
 * 
 * This copies the selection cells from the graph to the clipboard and pastes them into graph2.
 * 
 * For fine-grained control of the clipboard data the <mxGraph.canExportCell> and <mxGraph.canImportCell> functions can be overridden.
 * 
 * 
 */
public class mxClipboard {

	/**
	 * Cuts the given array of {@link mxCell}S from the specified graph. If cells is null then the selection cells of the graph will be used. Returns the cells
	 * that have been cut from the graph.
	 * 
	 * @param graph {@link mxGraph} that contains the cells to be cut.
	 * @param cells Optional list of {@link mxCell}S to be cut.
	 */
	public static native void cut(mxGraph graph, List<mxCell> cells) /*-{
		var cellsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrapList(Ljava/util/List;)(cells);
		var graphJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(graph);
		$wnd.mxClipboard.cut(graphJS, cellsJS);
	}-*/;

	/**
	 * Copies the given array of {@link mxCell} from the specified graph to <cells>.Returns the original array of cells that has been cloned.
	 * 
	 * @param graph {@link mxGraph} that contains the cells to be copied.
	 * @param cells Optional list of {@link mxCell}S to be copied.
	 */
	public static native List<mxCell> copy(mxGraph graph, List<mxCell> cells) /*-{
		var graphJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(graph);
		var cellsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrapList(Ljava/util/List;)(cells);
		var resultCellsJS = $wnd.mxClipboard.copy(graphJS, cellsJS);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrapList(Lcom/google/gwt/core/client/JavaScriptObject;)(resultCellsJS);
	}-*/;

	/**
	 * Pastes the <cells> into the specified graph restoring the relation to <parents>, if possible. If the parents are no longer in the graph or invisible then
	 * the cells are added to the graph's default or into the swimlane under the cell's new location if one exists. The cells are added to the graph using
	 * <mxGraph.importCells>.
	 * 
	 * @param graph {@link mxGraph} to paste the <cells> into.
	 */
	public static native void paste(mxGraph graph) /*-{
		var graphJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(graph);
		$wnd.mxClipboard.paste(graphJS);
	}-*/;
	
	/**
	 * Returns true if the clipboard currently has not data stored.
	 * 
	 * @return
	 */
	public static native boolean isEmpty() /*-{
		return $wnd.mxClipboard.isEmpty();
	}-*/;
}

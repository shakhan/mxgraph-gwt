package com.mxgraph.gwt.client.handler;

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.NativeEvent;
import com.mxgraph.gwt.client.IJavaScriptWrapper;
import com.mxgraph.gwt.client.model.mxICell;
import com.mxgraph.gwt.client.shape.mxRectangleShape;
import com.mxgraph.gwt.client.shape.mxShape;
import com.mxgraph.gwt.client.util.mxMouseEvent;
import com.mxgraph.gwt.client.util.mxRectangle;
import com.mxgraph.gwt.client.view.mxGraph;

/**
 * Graph event handler that handles selection. Individual cells are handled separately using <mxVertexHandler> or one of the edge handlers. These handlers are
 * created using <mxGraph.createHandler> in <mxGraphSelectionModel.cellAdded>.
 * 
 * To avoid the container to scroll a moved cell into view, set <scrollAfterMove> to false.
 * 
 */
public class mxGraphHandler implements IJavaScriptWrapper
{

	private JavaScriptObject jso;

	private native JavaScriptObject createJso(JavaScriptObject graph) /*-{
		return new $wnd.mxGraphHandler(graph);
	}-*/;

	public static interface ShouldRemoveCellsFromParentCallback
	{
		boolean invoke(mxICell parent, List<mxICell> cells, NativeEvent event, ShouldRemoveCellsFromParentCallback old);
	}

	public static interface MoveCellsCallback
	{
		List<mxICell> invoke(List<mxICell> cells, int dx, int dy, boolean clone, mxICell target, NativeEvent event, MoveCellsCallback old);
	}

	public static interface MouseMoveCallback
	{
		void invoke(Object sender, mxMouseEvent me, MouseMoveCallback old);
	}

	public static interface GetInitialCellForEventCallback
	{
		mxICell invoke(mxMouseEvent me, GetInitialCellForEventCallback old);
	}
	
	public static interface CreatePreviewShapeCallback 
	{
		mxShape invoke(mxRectangle bounds, CreatePreviewShapeCallback old);
	}

	@SuppressWarnings("unused")
	private static class DefaultCallback implements ShouldRemoveCellsFromParentCallback, MoveCellsCallback, MouseMoveCallback,
			GetInitialCellForEventCallback, CreatePreviewShapeCallback
	{

		JavaScriptObject graphHandler;

		JavaScriptObject callback;

		public DefaultCallback(mxGraphHandler graphHandler, JavaScriptObject callback)
		{
			this.graphHandler = graphHandler.jso;
			this.callback = callback;
		}

		@Override
		public native boolean invoke(mxICell parent, List<mxICell> cells, NativeEvent event, ShouldRemoveCellsFromParentCallback old) /*-{
			var parentJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(parent);
			var cellsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrapList(Ljava/util/List;)(cells);
			return this.@com.mxgraph.gwt.client.handler.mxGraphHandler.DefaultCallback::callback.apply(
					this.@com.mxgraph.gwt.client.handler.mxGraphHandler.DefaultCallback::graphHandler, [ parentJS, cellsJS, event ]);
		}-*/;

		public native List<mxICell> invoke(List<mxICell> cells, int dx, int dy, boolean clone, mxICell target, NativeEvent event,
				MoveCellsCallback old) /*-{
			var cellsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrapList(Ljava/util/List;)(cells);
			var targetJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(target);
			var retvalJS = this.@com.mxgraph.gwt.client.handler.mxGraphHandler.DefaultCallback::callback.apply(
					this.@com.mxgraph.gwt.client.handler.mxGraphHandler.DefaultCallback::graphHandler, [ cellsJS, dx, dy, clone, targetJS,
							event ]);
			return @com.mxgraph.gwt.client.util.WrapperUtils::wrapList(Lcom/google/gwt/core/client/JavaScriptObject;)(retvalJS);
		}-*/;

		public native void invoke(Object sender, mxMouseEvent me, MouseMoveCallback old) /*-{
			var meJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(me);
			this.@com.mxgraph.gwt.client.handler.mxGraphHandler.DefaultCallback::callback.apply(
					this.@com.mxgraph.gwt.client.handler.mxGraphHandler.DefaultCallback::graphHandler, [ sender, meJS ]);
		}-*/;

		@Override
		public native mxICell invoke(mxMouseEvent me, GetInitialCellForEventCallback old) /*-{
			var meJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(me);
			var cellJS = this.@com.mxgraph.gwt.client.handler.mxGraphHandler.DefaultCallback::callback.apply(
					this.@com.mxgraph.gwt.client.handler.mxGraphHandler.DefaultCallback::graphHandler, [ meJS ]);

			return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(cellJS);
		}-*/;

		@Override
		public native mxShape invoke(mxRectangle bounds, CreatePreviewShapeCallback old) /*-{
			var boundsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(bounds);
			var cellJS = this.@com.mxgraph.gwt.client.handler.mxGraphHandler.DefaultCallback::callback.apply(
					this.@com.mxgraph.gwt.client.handler.mxGraphHandler.DefaultCallback::graphHandler, [ boundsJS ]);

			return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(cellJS); 
		}-*/;
		
		

	}

	@Override
	public JavaScriptObject getJso()
	{
		return jso;
	}

	@Override
	public void setJso(JavaScriptObject jso)
	{
		this.jso = jso;
	}

	private mxGraphHandler()
	{
	}

	/**
	 * Constructs an event handler that creates handles for the selection cells
	 * 
	 * @param graph Reference to the enclosing {@link mxGraph}.
	 */
	public mxGraphHandler(mxGraph graph)
	{
		jso = createJso(graph.getJso());
	}

	/**
	 * Gets the flag that specifies if other cells should be used for snapping the right, center or left side of the current selection. Default is false.
	 * 
	 * @return
	 */
	public native boolean isGuidesEnabled() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).guidesEnabled;
	}-*/;

	/**
	 * Sets new value for guides enabled flag
	 * 
	 * @param guidesEnabled new value
	 */
	public native void setGuidesEnabled(boolean guidesEnabled) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).guidesEnabled = guidesEnabled;
	}-*/;

	/**
	 * Allows user to specify which cells can or can't be removed from parent
	 * 
	 * @param callback a callback containing a new definition
	 */
	public native void setShouldRemoveCellsFromParentCallback(ShouldRemoveCellsFromParentCallback callback) /*-{
		var old = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).shouldRemoveCellsFromParent;
		var oldJ = @com.mxgraph.gwt.client.handler.mxGraphHandler.DefaultCallback::new(Lcom/mxgraph/gwt/client/handler/mxGraphHandler;Lcom/google/gwt/core/client/JavaScriptObject;)(this, old);

		var funct = function(parent, cells, event)
		{
			var parentJ = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(parent);
			var cellsJ = @com.mxgraph.gwt.client.util.WrapperUtils::wrapList(Lcom/google/gwt/core/client/JavaScriptObject;)(cells);
			return callback.@com.mxgraph.gwt.client.handler.mxGraphHandler.ShouldRemoveCellsFromParentCallback::invoke(Lcom/mxgraph/gwt/client/model/mxICell;Ljava/util/List;Lcom/google/gwt/dom/client/NativeEvent;Lcom/mxgraph/gwt/client/handler/mxGraphHandler$ShouldRemoveCellsFromParentCallback;)(parentJ, cellsJ, event, oldJ);
		};

		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).shouldRemoveCellsFromParent = funct;
	}-*/;

	/**
	 * Allows user to redefine the behavior of {@link mxGraphHandler#moveCells(List, int, int, boolean, mxICell)}
	 * 
	 * @param callback a callback containing a new definition
	 */
	public native void setMoveCellsCallback(MoveCellsCallback callback) /*-{
		var old = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).moveCells;//get the default implementation of the function
		var oldJ = @com.mxgraph.gwt.client.handler.mxGraphHandler.DefaultCallback::new(Lcom/mxgraph/gwt/client/handler/mxGraphHandler;Lcom/google/gwt/core/client/JavaScriptObject;)(this, old);

		var funct = function(cells, dx, dy, clone, target, evt)
		{
			var cellsJ = @com.mxgraph.gwt.client.util.WrapperUtils::wrapList(Lcom/google/gwt/core/client/JavaScriptObject;)(cells);
			var targetJ = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(target);
			var retvalJ = callback.@com.mxgraph.gwt.client.handler.mxGraphHandler.MoveCellsCallback::invoke(Ljava/util/List;IIZLcom/mxgraph/gwt/client/model/mxICell;Lcom/google/gwt/dom/client/NativeEvent;Lcom/mxgraph/gwt/client/handler/mxGraphHandler$MoveCellsCallback;)(cellsJ, dx, dy, clone, targetJ, evt, oldJ);
			return @com.mxgraph.gwt.client.util.WrapperUtils::unwrapList(Ljava/util/List;)(retvalJ);
		};

		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).moveCells = funct;
	}-*/;

	public native void setMouseMoveCallback(MouseMoveCallback callback) /*-{
		var old = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).mouseMove;
		var oldJ = @com.mxgraph.gwt.client.handler.mxGraphHandler.DefaultCallback::new(Lcom/mxgraph/gwt/client/handler/mxGraphHandler;Lcom/google/gwt/core/client/JavaScriptObject;)(this, old);

		var funct = function(sender, me)
		{
			var meJ = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(me);
			callback.@com.mxgraph.gwt.client.handler.mxGraphHandler.MouseMoveCallback::invoke(Ljava/lang/Object;Lcom/mxgraph/gwt/client/util/mxMouseEvent;Lcom/mxgraph/gwt/client/handler/mxGraphHandler$MouseMoveCallback;)(sender, meJ, oldJ);

		};

		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).mouseMove = funct;
	}-*/;

	public native void setGetInitialCellForEventCallback(GetInitialCellForEventCallback callback) /*-{
		var old = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getInitialCellForEvent;
		var oldJ = @com.mxgraph.gwt.client.handler.mxGraphHandler.DefaultCallback::new(Lcom/mxgraph/gwt/client/handler/mxGraphHandler;Lcom/google/gwt/core/client/JavaScriptObject;)(this, old);

		var funct = function(me)
		{
			var meJ = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(me);
			var cellJ = callback.@com.mxgraph.gwt.client.handler.mxGraphHandler.GetInitialCellForEventCallback::invoke(Lcom/mxgraph/gwt/client/util/mxMouseEvent;Lcom/mxgraph/gwt/client/handler/mxGraphHandler$GetInitialCellForEventCallback;)(meJ, oldJ);
			return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cellJ);
		};

		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getInitialCellForEvent = funct;
	}-*/;
	
	public native void setCreatePreviewShapeCallback(CreatePreviewShapeCallback callback) /*-{
		var old = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).createPreviewShape;
		var oldJ = @com.mxgraph.gwt.client.handler.mxGraphHandler.DefaultCallback::new(Lcom/mxgraph/gwt/client/handler/mxGraphHandler;Lcom/google/gwt/core/client/JavaScriptObject;)(this, old);
		
		var funct = function(bounds)
		{
			var boundsJ = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(bounds);
			var shapeJ = callback.@com.mxgraph.gwt.client.handler.mxGraphHandler.CreatePreviewShapeCallback::invoke(Lcom/mxgraph/gwt/client/util/mxRectangle;Lcom/mxgraph/gwt/client/handler/mxGraphHandler$CreatePreviewShapeCallback;)(boundsJ, oldJ);
			return  @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(shapeJ);
		}
		
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).createPreviewShape = funct;
		
	}-*/;

	/**
	 * Returns true if cells may be moved out of their parents. Default is true.
	 * 
	 * @return
	 */
	public native boolean isRemoveCellsFromParent() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this)
				.isRemoveCellsFromParent();
	}-*/;

	/**
	 * Specifies if cells may be moved out of their parents.
	 * 
	 * @param value
	 */
	public native void setRemoveCellsFromParent(boolean value) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this)
				.setRemoveCellsFromParent(value);
	}-*/;

	/**
	 * Specifies if cloning by control-drag is enabled.
	 */
	public native void setCloneEnabled(boolean value) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).setCloneEnabled(value);
	}-*/;

	/**
	 * Returns true if cloning by control-drag is enabled. Default is true.
	 * 
	 * @return
	 */
	public native boolean isCloneEnabled() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isCloneEnabled();
	}-*/;

	public native mxRectangle getBounds()/*-{
		var boundsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).bounds;
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(boundsJS);
	}-*/;

	public native int getCurrentX() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).currentX;
	}-*/;

	public native void setCurrentX(int currentX) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).currentX = currentX;
	}-*/;

	public native int getCurrentY() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).currentY;
	}-*/;

	public native void setCurrentY(int currentY) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).currentX = currentY;
	}-*/;

	/**
	 * Creates the shape used to draw the preview for the given bounds.
	 * 
	 * @param bounds
	 * @return
	 */
	public native mxShape createPreviewShape(mxRectangle bounds) /*-{
		var boundsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(bounds);
		var shapeJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this)
				.createPreviewShape(boundsJS);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(shapeJS);
	}-*/;
	
	/**
	 * Returns the color of the preview shape. Default is black.
	 * @return
	 */
	public native String getPreviewColor() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(this).getPreviewColor();
	}-*/;
	
	/**
	 * @return
	 */
	public native mxICell getCell() /*-{
		var cellJS =  @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).cell
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(cellJS);
	}-*/;

}

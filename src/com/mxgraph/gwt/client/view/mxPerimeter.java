package com.mxgraph.gwt.client.view;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.model.mxCell;
import com.mxgraph.gwt.client.model.mxPoint;
import com.mxgraph.gwt.client.util.mxRectangle;

public abstract class mxPerimeter {
	public interface PerimeterCallback {
		void invoke(mxRectangle rectangle, mxCell vertex, mxPoint next, boolean orthogonal);
	}

	public static native JavaScriptObject wrapPerimeterCallback(PerimeterCallback callback) /*-{
		var func = function(bounds, vertex, next, orthogonal) {
			var boundsJ = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(bounds);
			var vertexJ = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(vertex);
			var nextJ = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(next);
			callback.@com.mxgraph.gwt.client.view.mxPerimeter.PerimeterCallback::invoke(Lcom/mxgraph/gwt/client/util/mxRectangle;Lcom/mxgraph/gwt/client/model/mxCell;Lcom/mxgraph/gwt/client/model/mxPoint;Z)(boundsJ, vertexJ, nextJ, orthogonal);
		};
		
		return func;
	}-*/;

	public static PerimeterCallback getEllipsePerimeter() {
		return new PerimeterCallback() {
			@Override public native void invoke(mxRectangle rectangle, mxCell vertex, mxPoint next, boolean orthogonal) /*-{
				var rectangleJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(rectangle);
				var vertexJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(vertex);
				var nextJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(next);

				$wnd.mxPerimeter.EllipsePerimeter(rectangleJS, vertexJS, nextJS, orthogonal);
			}-*/;
		};
	}
	
	

}

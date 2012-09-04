package com.mxgraph.gwt.client.view;

import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.model.mxCell;
import com.mxgraph.gwt.client.model.mxICell;
import com.mxgraph.gwt.client.shape.mxShape;
import com.mxgraph.gwt.client.util.CollectionUtils;
import com.mxgraph.gwt.client.util.mxRectangle;

public class mxCellState extends mxRectangle {

	private static final long serialVersionUID = 4338366351958012453L;
	
	private native JavaScriptObject createJso(JavaScriptObject graph, JavaScriptObject cell, JavaScriptObject style) /*-{
		return new $wnd.mxCellState(graph, cell, style);
	}-*/;
	
	private mxCellState() {
	}
	
	public mxCellState(mxGraphView view, mxCell cell, Map<String, String> style) {
		jso = createJso(view.getJso(), cell.getJso(), CollectionUtils.convertMap(style));
	}

	public native String getStyle(String key) /*-{
		var val = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).style[key];
		return val === undefined ? null : val + ''; 
	}-*/;
	
	/**
	 * Returns the reference to the {@link mxCell} that is represented by this state.
	 * 
	 * @return
	 */
	public native mxICell getCell() /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).cell;
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(cellJS);
	}-*/;
	
	/**
	 *  Holds the {@link mxShape} that represents the cell graphically.
	 * 
	 * @return
	 */
	public native mxShape getShape() /*-{
		var cellJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).shape;
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(cellJS);
		
	}-*/;

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		
		if (getClass() != obj.getClass())
			return false;
		mxCellState other = (mxCellState) obj;
		
		if(other.getJso().equals(this.getJso())) {
			return true;
		}
		
		return true;
	}
	
	
}

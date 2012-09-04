package com.mxgraph.gwt.showcase.client;

import java.util.Arrays;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.SimplePanel;
import com.mxgraph.gwt.client.model.mxCell;
import com.mxgraph.gwt.client.model.mxGeometry;
import com.mxgraph.gwt.client.model.mxICell;
import com.mxgraph.gwt.client.util.mxMouseEvent;
import com.mxgraph.gwt.client.util.mxMouseEvent.mxIMouseListener;
import com.mxgraph.gwt.client.view.mxCellState;
import com.mxgraph.gwt.client.view.mxGraph;

public class CustomCellHoverStyle extends AbstractContentWidget
{

	public CustomCellHoverStyle(String name, Showcase showcase)
	{
		super(name, showcase);
		description = "Hover styles of the cells are customizable as demonstrated in this example.";
	}

	@Override
	public void injectContent(SimplePanel panel)
	{
		
		final mxGraph graph = new mxGraph();
		graph.getElement().getStyle().setBackgroundImage("url('images/grid.gif')");
		graph.getElement().getStyle().setHeight(100, Unit.PCT);
		Examples.loadDefaultStyle(graph);
		panel.setWidget(graph);
		
		mxICell dragMe = new mxCell("Hover over me!", new mxGeometry(0, 0, 150, 70), "ellipse");
		dragMe.setVertex(true);
		graph.importCells(Arrays.asList(dragMe), 150, 150, graph.getDefaultParent());
		
		graph.addMouseListener(new mxIMouseListener<mxGraph>()
		{
			mxCellState currentState = null;
			String previousFill = null;
			
			@Override
			public void onMouseDown(mxGraph sender, mxMouseEvent event)
			{
				if (currentState != null) {
					
					dragEnter(event.getEvent(), currentState);
					currentState = null;
				}
			}
			
			@Override
			public void onMouseMove(mxGraph sender, mxMouseEvent event)
			{
				if (this.currentState != null && event.getState() != null && event.getState().equals(currentState))
		        {
		            return;
		        }

		        mxCellState tmp = graph.getView().getState(event.getCell(), false);

		        // Ignores everything but vertices
		        if (graph.getIsMouseDown() || (tmp != null && ! graph.getModel().isVertex(tmp.getCell())))
		        {
		            tmp = null;
		        }

		        if (tmp != this.currentState)
		        {
		            if (this.currentState != null)
		            {
		                this.dragLeave(event.getEvent(), this.currentState);
		            }

		            this.currentState = tmp;

		            if (this.currentState != null)
		            {
		                this.dragEnter(event.getEvent(), this.currentState);
		            }
		        }
			}
			
			@Override
			public void onMouseUp(mxGraph sender, mxMouseEvent event)
			{
			}
			
			private void dragEnter(NativeEvent event, mxCellState state)
		    {
		        if (state != null)
		        {
		          previousFill = state.getShape().getFill();
		          state.getShape().setFill("red");
		          state.getShape().reconfigure();
		        }
		    }
			
			private void dragLeave(NativeEvent event, mxCellState state)
		    {
				if (state != null)
		        {
		          state.getShape().setFill(this.previousFill);
		          state.getShape().reconfigure();
		        }
		    }
		});

	}

}

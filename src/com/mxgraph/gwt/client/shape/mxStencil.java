package com.mxgraph.gwt.client.shape;

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Node;
import com.mxgraph.gwt.client.IJavaScriptWrapper;
import com.mxgraph.gwt.client.util.WrapperUtils;
import com.mxgraph.gwt.client.util.mxRectangle;
import com.mxgraph.gwt.client.view.mxConnectionConstraint;

public class mxStencil implements IJavaScriptWrapper {

	protected JavaScriptObject jso;

	private native JavaScriptObject createJso(Node node) /*-{
		return new $wnd.mxStencil(node);
	}-*/;

	public mxStencil(Node desc) {
		jso = createJso(desc);
	}

	@Override
	public JavaScriptObject getJso() {
		return jso;
	}

	@Override
	public void setJso(JavaScriptObject jso) {
		this.jso = jso;
	}

	/**
	 * Gets the XML node with the stencil description.
	 * 
	 * @return
	 */
	public native Node getDesc() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).desc;
	}-*/;

	/**
	 * Sets the XML node with the stencil description.
	 * 
	 * @param desc
	 */
	public native void setDesc(Node desc) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).desc = desc;
	}-*/;

	private native JavaScriptObject getConstraintsJS() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).constraints;
	}-*/;

	/**
	 * Returns the list of {@link mxConnectionConstraint} as defined in the shape.
	 * 
	 * @return list
	 */
	public List<mxConnectionConstraint> getConstraints() {
		return WrapperUtils.wrapList(getConstraintsJS());
	}

	/**
	 * Sets the list of {@link mxConnectionConstraint}
	 * 
	 * @param constraints
	 */
	public native void setConstraints(List<mxConnectionConstraint> constraints) /*-{
		var constraintsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrapList(Ljava/util/List;)(constraints);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).constraintsJS;
	}-*/;

	/**
	 * Gets the aspect of the shape. Default is 'auto'.
	 * 
	 * @return
	 */
	public native String getAspect() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).aspect;
	}-*/;

	/**
	 * Sets the aspect of the shape.
	 * 
	 * @param aspect
	 */
	public native void setAspect(String aspect) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).aspect = aspect;
	}-*/;

	/**
	 * Gets the width of the shape. Default is 100.
	 * 
	 * @return
	 */
	public native double getW0() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).w0;
	}-*/;

	/**
	 * Sets the width of the shape.
	 * 
	 * @param w0
	 */
	public native void setW0(double w0) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).w0 = w0;
	}-*/;

	/**
	 * Gets the height of the shape. Default is 100.
	 * 
	 * @return
	 */
	public native double getH0() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).h0;
	}-*/;

	/**
	 * Sets the height of the shape.
	 * 
	 * @param h0
	 */
	public native void setH0(double h0) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).h0 = h0;
	}-*/;

	/**
	 * @return
	 */
	public native Node getBgNode() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).bgNode;
	}-*/;

	/**
	 * @param bgNode
	 */
	public native void setBgNode(Node bgNode) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).bgNode = bgNode;
	}-*/;

	/**
	 * @return
	 */
	public native Node getFgNode() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).fgNode;
	}-*/;

	/**
	 * @param fgNode
	 */
	public native void setFgNode(Node fgNode) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).fgNode = fgNode;
	}-*/;

	/**
	 * Gets the strokewidth direction from the description.
	 * 
	 * @return
	 */
	public native int getStrokewidth() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).strokewidth;
	}-*/;

	/**
	 * Sets the strokewidth
	 * 
	 * @param strokewidth
	 */
	public native void setStrokewidth(int strokewidth) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).strokewidth = strokewidth;
	}-*/;

	/**
	 * Reads <w0>, <h0>, <aspect>, <bgNodes> and <fgNodes> from <desc>.
	 */
	public native void parseDescription() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).parseDescription();
	}-*/;

	/**
	 * Reads the constraints from <desc> into <constraints> using {@link #parseConstraint}.
	 */
	public native void parseConstraints() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).parseConstraints();
	}-*/;

	/**
	 * Parses the given XML node and returns its {@link mxConnectionConstraint}.
	 */
	public native void parseConstraint() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).parseConstraint();
	}-*/;

	/**
	 * Gets the attribute for the given name from the given node. If the attribute does not exist then the text contentPanel of the node is evaluated and if it is a
	 * function it is invoked with <state> as the only argument and the return value is used as the attribute value to be returned.
	 * 
	 * @param node node with the attribute or text for evaluation
	 * @param attribute name of the attribute
	 * @param state argument for the function
	 * @return
	 */
	public native JavaScriptObject evaluateAttribute(Node node, String attribute, String state) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).evaluateAttribute(node, attribute, state);
	}-*/;

	/**
	 * Updates the SVG or VML shape.
	 * 
	 * @param shape shape for update
	 * @param bounds
	 * @param parentNode
	 * @param state
	 */
	public native void renderDom(mxShape shape, mxRectangle bounds, Node parentNode, String state) /*-{
		var shapeJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(shape);
		var boundsJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(bounds);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).renderDom(shapeJS, boundsJS, parentNode, state);
	}-*/;

	public native boolean drawShape() /*-{
		
	}-*/;
}

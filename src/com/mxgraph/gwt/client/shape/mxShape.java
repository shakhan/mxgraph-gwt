package com.mxgraph.gwt.client.shape;

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Node;
import com.google.gwt.user.client.Element;
import com.mxgraph.gwt.client.IJavaScriptWrapper;
import com.mxgraph.gwt.client.model.mxPoint;
import com.mxgraph.gwt.client.util.WrapperUtils;
import com.mxgraph.gwt.client.util.mxConstants;
import com.mxgraph.gwt.client.util.mxPath;
import com.mxgraph.gwt.client.util.mxRectangle;
import com.mxgraph.gwt.client.view.mxCellState;

/**
 * Base class for all shapes. A shape in mxGraph is a separate implementation for SVG, VML and HTML. Which implementation to use is controlled by the <dialect>
 * property which is assigned from within the <mxCellRenderer> when the shape is created. The dialect must be assigned for a shape, and it does normally depend
 * on the browser and the configuration of the graph (see <mxGraph> rendering hint).
 * 
 * For each supported shape in SVG and VML, a corresponding shape exists in mxGraph, namely for text, image, rectangle, rhombus, ellipse and polyline. The other
 * shapes are a combination of these shapes (eg. label and swimlane) or they consist of one or more (filled) path objects (eg. actor and cylinder). The HTML
 * implementation is optional but may be required for a HTML-only view of the graph.
 * 
 * Custom Shapes:
 * 
 * To extend from this class, the basic code looks as follows. In the special case where the custom shape consists only of one filled region or one filled
 * region and an additional stroke the {@link mxActor} and {@link mxCylinder} should be subclassed, respectively. These implement <redrawPath> in order to
 * create the path expression for VML and SVG via a unified API (see <mxPath>). <mxCylinder.redrawPath> has an additional boolean argument to draw the
 * foreground and background separately.
 * 
 * <p>
 * <blockquote>
 * 
 * <pre>
 * function CustomShape() { }
 * 
 * CustomShape.prototype = new mxShape();
 * CustomShape.prototype.constructor = CustomShape;
 * </pre>
 * 
 * </blockquote>
 * </p>
 * 
 * To register a custom shape in an existing graph instance, one must register the shape under a new name in the graph's cell renderer as follows:
 * 
 * <p>
 * <blockquote>
 * 
 * <pre>
 * graph.cellRenderer.registerShape('customShape', CustomShape);
 * </pre>
 * 
 * </blockquote>
 * </p>
 * 
 * The second argument is the name of the constructor.
 * 
 * In order to use the shape you can refer to the given name above in a stylesheet. For example, to change the shape for the default vertex style, the following
 * code is used:
 * 
 * <p>
 * <blockquote>
 * 
 * <pre>
 * style = graph.getStylesheet().getDefaultVertexStyle(); 
 * style[mxConstants.STYLE_SHAPE] = 'customShape';
 * 
 * </pre>
 * 
 * </blockquote>
 * </p>
 */
public abstract class mxShape implements IJavaScriptWrapper {

	protected JavaScriptObject jso;
	
	private native JavaScriptObject createJso() /*-{
		return $wnd.mxShape();
	}-*/;
	
	public static abstract class globalSettings {
		public native static void setCrisp(boolean crisp) /*-{
			$wnd.mxShape.prototype.crisp = crisp;
		}-*/;
	}

	/**
	 * Constructs a new shape.
	 */
	public mxShape() {
		jso = createJso();
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
	 * Event-tolerance for SVG strokes (in px). Default is 8
	 * 
	 * @return
	 */
	public native int getSvgStrokeTolerance() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).SVG_STROKE_TOLERANCE;
	}-*/;

	/**
	 * Sets the event tolerance for SVG strokes
	 * 
	 * @param svgStrokeTolerance
	 */
	public native void setSvgStrokeTolerance(int svgStrokeTolerance) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).SVG_STROKE_TOLERANCE = svgStrokeTolerance;
	}-*/;

	/**
	 * Returns the scale in which the shape is being painted.
	 * 
	 * @return scale
	 */
	public native int getScale() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).scale;
	}-*/;

	/**
	 * Sets the scale in which the shape is being painted.
	 * 
	 * @param scale
	 */
	public native void setScale(int scale) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).scale = scale;
	}-*/;

	/**
	 * Holds the dialect in which the shape is to be painted. This can be one of the DIALECT constants in {@link mxConstants}.
	 * 
	 * @return dialect
	 */
	public native String getDialect() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).dialect;
	}-*/;

	/**
	 * Sets the dialect in which the shape is to be painted.
	 * 
	 * @param dialect
	 */
	public native void setDialect(String dialect) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).dialect = dialect;
	}-*/;

	/**
	 * Returns the special attribute for SVG rendering to set the shape-rendering attribute to crispEdges in the output. This is ignored in IE. Default is false
	 * 
	 * @return
	 */
	public native boolean isCrisp() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).crisp;
	}-*/;
	
	/**
	 * Returns the global attribute for SVG rendering. It affects all shapes.
	 * 
	 * @return
	 */
	public static native boolean isCrispGlobal() /*-{
		return $wnd.mxShape.prototype.crisp;
	}-*/;

	/**
	 * Sets the special attribute for SVG rendering
	 * 
	 * @param crisp
	 */
	public native void setCrisp(boolean crisp) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).crisp = crisp;
	}-*/;
	
	/**
	 *  Sets the special attribute for SVG rendering globally
	 * 
	 * @param crisp
	 */
	public static native void setCrispGlobal(boolean crisp) /*-{
		$wnd.mxShape.prototype.crisp = crisp;
	}-*/;

	/**
	 * Returns true if {@link mxShape#createHtml()} should be used in mixed Html mode.
	 * 
	 * @return
	 */
	public native boolean isMixedModeHtml() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).isMixedModeHtml();
	}-*/;

	/**
	 * Sets new value for mixedModeHtml flag.
	 * 
	 * @param mixedModeHtml
	 */
	public native void setMixedModeHtml(boolean mixedModeHtml) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).mixedModeHtml = mixedModeHtml;
	}-*/;

	/**
	 * Returns true if <createHtml> should be used in prefer Html mode.
	 * 
	 * @return
	 */
	public native boolean isPreferModeHtml() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).preferModeHtml;
	}-*/;

	/**
	 * Sets new value for preferModeHtml flag.
	 * 
	 * @param preferModeHtml
	 */
	public native void setPreferModeHtml(boolean preferModeHtml) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).preferModeHtml = preferModeHtml;
	}-*/;

	/**
	 * Returns the {@link mxRectangle} that specifies the bounds of this shape.
	 * 
	 * @return rectangle
	 */
	public native mxRectangle getBounds() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).bounds;
	}-*/;

	/**
	 * Sets the new bounds for this shape.
	 * 
	 * @param bounds rectangle with new bounds
	 */
	public native void setBounds(mxRectangle bounds) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).bounds = bounds;
	}-*/;

	private native JavaScriptObject getPointsJS() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).points;
	}-*/;

	/**
	 * Returns the list of {@link mxPoint}S that specify the points of this shape.
	 * 
	 * @return list of points
	 */
	public List<mxPoint> getPoints() {
		return WrapperUtils.wrapList(getPointsJS());
	}

	/**
	 * Sets the list of points that specify points of this shape.
	 * 
	 * @param points list of new points
	 */
	public native void setPoints(List<mxPoint> points) /*-{
		var jsList = @com.mxgraph.gwt.client.util.WrapperUtils::unwrapList(Ljava/util/List;)(points);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).points = jsList;
	}-*/;

	/**
	 * Returns the outermost DOM node that represents this shape.
	 * 
	 * @return DOM node
	 */
	public native Node getNode() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).node;
	}-*/;

	/**
	 * Sets the outermost DOM node that represents this shape.
	 * 
	 * @param node DOM node
	 */
	public native void setNode(Node node) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).node = node;
	}-*/;

	/**
	 * Returns the reference to the DOM node that should contain the label. This is null if the label should be placed inside {@link mxShape#node} or
	 * {@link mxShape#innerNode}.
	 * 
	 * @return DOM node holding the label.
	 */
	public native Node getLabel() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).label;
	}-*/;

	/**
	 * Sets the new DOM node holding the label.
	 * 
	 * @param label DOM node.
	 */
	public native void setLabel(Node label) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).label = label;
	}-*/;

	/**
	 * Holds the DOM node that graphically represents this shape. This may be null if the outermost DOM node represents this shape.
	 * 
	 * @return DOM node
	 */
	public native Node getInnerNode() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).innerNode;
	}-*/;

	/**
	 * Sets the DOM node that will graphically represents this shape.
	 * 
	 * @param innerNode new DOM node
	 */
	public native void setInnerNode(Node innerNode) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).innerNode = innerNode;
	}-*/;

	/**
	 * Gets the offset in pixels from the first point in points and the actual start of the shape
	 * 
	 * @return start offset
	 */
	public native int getStartOffset() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).startOffset;
	}-*/;

	/**
	 * Sets the new start offset
	 * 
	 * @param startOffset new value for offset
	 */
	public native void setStartOffset(int startOffset) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).startOffset = startOffset;
	}-*/;

	/**
	 * Specifies the offset in pixels from the last point in <points> and the actual start of the shape.
	 * 
	 * @return
	 */
	public native int getEndOffset() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).endOffset;
	}-*/;

	/**
	 * Sets the new end offset
	 * 
	 * @param endOffset new value for offset
	 */
	public native void setEndOffset(int endOffset) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).endOffset = endOffset;
	}-*/;

	/**
	 * Creates and returns the HTML DOM node(s) to represent this shape. This implementation falls back to {@link mxShape#createVml} so that the HTML creation
	 * is optional.
	 * 
	 * @return DOM node
	 */
	public native Element createHtml() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).createHtml();
	}-*/;

	/**
	 * Creates and returns the VML node(s) to represent this shape.
	 * 
	 * @return created node(s)
	 */
	public native Node createVml() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).createVml();
	}-*/;

	/**
	 * Creates and returns the SVG node(s) to represent this shape.
	 * 
	 * @return created node(s)
	 */
	public native Node createSvg() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).createSvg();
	}-*/;

	/**
	 * Initializes the shape by creating the DOM node using {@link mxShape#init(Element)} and adding it into the given container.
	 * 
	 * @param container
	 */
	public native void init(Element container) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).init(container);
	}-*/;

	/**
	 * Inserts the given gradient node.
	 * 
	 * @param node gradient node
	 */
	public native void insertGradient(Node node) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).insertGradient(node);
	}-*/;

	/**
	 * 
	 * Creates and returns the DOM node(s) for the shape in the given container. This implementation invokes {@link mxShape#createSvg},
	 * {@link mxShape#createHtml} or {@link mxShape#createVml} depending on the <dialect> and style settings.
	 * 
	 * @return
	 */
	public native Element create(Element container) /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).create(container);
	}-*/;

	/**
	 * Destroys the shape by removing it from the DOM and releasing the DOM node associated with the shape using <mxEvent.release>.
	 */
	public native void destroy() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).destroy();
	}-*/;

/**
	 * Applies the style of the given {@link mxCellState} to the shape. This
	 * implementation assigns the following styles to local fields:
	 * 
	 * - {@link mxConstants#STYLE_FILLCOLOR> => fill -
	 * 
	 * @link mxConstants#STYLE_GRADIENTCOLOR} => gradient -
	 *       {@link mxConstants#STYLE_GRADIENT_DIRECTION} => gradientDirection -
	 *       {@link mxConstants#STYLE_OPACITY} => opacity -
	 *       {@link mxConstants#STYLE_STROKECOLOR} => stroke -
	 *       {@link mxConstants#STYLE_STROKEWIDTH} => strokewidth -
	 *       {@link mxConstants#STYLE_SHADOW} => isShadow -
	 *       {@link mxConstants#STYLE_DASHED} => isDashed -
	 *       {@link mxConstants#STYLE_SPACING} => spacing -
	 *       {@link mxConstants#STYLE_STARTSIZE} => startSize -
	 *       {@link mxConstants#STYLE_ENDSIZE} => endSize -
	 *       {@link mxConstants#STYLE_ROUNDED} => isRounded -
	 *       {@link mxConstants#STYLE_STARTARROW} => startArrow -
	 *       {@link mxConstants#STYLE_ENDARROW} => endArrow -
	 *       {@link mxConstants#STYLE_ROTATION} => rotation -
	 *       {@link mxConstants#STYLE_DIRECTION} => direction
	 * 
	 *       This keeps a reference to the <style>. If you need to keep a
	 *       reference to the cell, you can override this method and store a
	 *       local reference to state.cell or the {@link mxCellState} itself.
	 * 
	 *       Parameters:
	 * 
	 *       state - {@link mxCellState} of the corresponding cell.
	 */
	public native void apply(mxCellState cellState) /*-{
	var cellStateJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cellState);
	@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).apply(cellStateJS);
}-*/;

	/**
	 * Creates a SVG group element and adds the given shape as a child of the element. The child is stored in <innerNode> for later access.
	 * 
	 * @param shape
	 * @return
	 */
	public native Element createSvgGroup(String shape) /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).createSvgGroup(shape);
	}-*/;

	/**
	 * Creates a clone of the given node and configures the node's color to use {@link mxConstants#SHADOWCOLOR} with a {@link mxConstants#SVG_SHADOWTRANSFORM}.
	 * 
	 * @param element element for cloning
	 * @return cloned element
	 */
	public native Element createSvgShadow(Element element) /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).createSvgShadow(element);
	}-*/;

	/**
	 * Configures the specified HTML node by applying the current color, bounds, shadow, opacity etc.
	 * 
	 * @param node node to be configured
	 */
	public native void configureHtmlShape(Node node) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).configureHtmlShape(node);
	}-*/;

	/**
	 * Updates the given VML fill node.
	 * 
	 * @param node
	 * @param color1
	 * @param color2
	 * @param alpha
	 */
	public native void updateVmlFill(Node node, String color1, String color2, int alpha) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).updateVmlFill(node, color1, color2, alpha);
	}-*/;

	/**
	 * Configures the specified VML node by applying the current color, bounds, shadow, opacity etc.
	 * 
	 * @param node node to be configured
	 */
	public native void configureVmlShape(Node node) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).configureVmlShape(node);
	}-*/;

	/**
	 * Hook to make the background of a shape transparent. This hook was added as a workaround for the "display non secure items" warning dialog in IE which
	 * appears if the background:url(transparent.gif) is used in the overlay pane of a diagram. Since only mxImageShapes currently exist in the overlay pane
	 * this function is only overridden in mxImageShape.
	 * 
	 * @param node
	 */
	public native void configureTransparentBackground(Node node) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).configureTransparentBackground(node);
	}-*/;

	/**
	 * Configures the specified SVG node by applying the current color, bounds, shadow, opacity etc.
	 * 
	 * @param node
	 */
	public native void configureSvgShape(Node node) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).configureSvgShape(node);
	}-*/;

	/**
	 * Creates a unique ID for the gradient of this shape.
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public native String getGradientId(String start, String end) /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).getGradientId(start, end);
	}-*/;

	/**
	 * Creates a gradient object for SVG using the specified startcolor, endcolor and opacity.
	 * 
	 * @param id
	 * @param start
	 * @param end
	 * @param node
	 * @return
	 */
	public native Node createSvgGradient(String id, String start, String end, Node node) /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).createSvgGradient(id, start, end, node);
	}-*/;

	/**
	 * Creates a path expression using the specified commands for this.points. If isRounded is true, then the path contains curves for the corners.
	 * 
	 * @param moveCmd
	 * @param lineCmd
	 * @param curveCmd
	 * @param isRounded
	 * @return
	 */
	public native String createPoints(String moveCmd, String lineCmd, String curveCmd, boolean isRounded) /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).createPoints(moveCmd, lineCmd, curveCmd, isRounded);
	}-*/;

	/**
	 * Updates the bounds or points of the specified HTML node and updates the inner children to reflect the changes.
	 * 
	 * @param node
	 */
	public native void updateHtmlShape(Node node) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).updateHtmlShape(node);
	}-*/;

	/**
	 * Updates the bounds or points of the specified VML node and updates the inner children to reflect the changes.
	 * 
	 * @param node
	 */
	public native void updateVmlShape(Node node) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).updateVmlShape(node);
	}-*/;

	/**
	 * Updates the bounds or points of the specified SVG node and updates the inner children to reflect the changes.
	 * 
	 * @param node
	 */
	public native void updateSvgShape(Node node) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).updateSvgShape(node);
	}-*/;

	/**
	 * Updates the transform of the given node.
	 * 
	 * @param node
	 * @param shadow
	 */
	public native void updateSvgTransform(Node node, boolean shadow) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).updateSvgTransform(node, shadow);
	}-*/;

	/**
	 * Reconfigures this shape. This will update the colors etc in addition to the bounds or points.
	 */
	public native void reconfigure() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).reconfigure();
	}-*/;

	/**
	 * Invokes {@link mxShape#redrawSvg}, {@link mxShape#redrawVml} or {@link mxShape#redrawHtml} depending on the dialect of the shape.
	 */
	public native void redraw() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).redraw();
	}-*/;

	/**
	 * * Redraws this SVG shape by invoking {@link mxShape#updateSvgShape} on this.node, this.innerNode and this.shadowNode.
	 */
	public native void redrawSvg() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).redrawSvg();
	}-*/;

	/**
	 * Redraws this SVG shape by invoking {@link mxShape#updateVmlShape} on this.node, this.innerNode and this.shadowNode.
	 */
	public native void updateVmlGlassPane() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).updateVmlGlassPane();
	}-*/;

	/**
	 * Redraws this SVG shape by invoking {@link mxShape#updateSvgShape} on this.node, this.innerNode and this.shadowNode.
	 */
	public native void updateSvgGlassPane() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).updateSvgGlassPane();
	}-*/;

	/**
	 * Redraws this VML shape by invoking {@link mxShape#updateVmlShape} on this.node.
	 */
	public native void redrawVml() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).redrawVml();
	}-*/;

	/**
	 * Redraws this HTML shape by invoking {@link mxShape#updateHtmlShape} on this.node.
	 */
	public native void redrawHtml() /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).redrawHtml();
	}-*/;

	/**
	 * Creates an {@link mxPath} for the specified format and origin. The path object is then passed to redrawPath and {@link mxPath#getPath} is returned.
	 * 
	 * @param isForeground
	 * @return
	 */
	public native String createPath(boolean isForeground) /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).createPath(isForeground);
	}-*/;

	/**
	 * @param path
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	public native void redrawPath(mxPath path, double x, double y, double w, double h) /*-{
		var pathJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(path);
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).redrawPath(pathJS, x, y, w, h);
	}-*/;


}

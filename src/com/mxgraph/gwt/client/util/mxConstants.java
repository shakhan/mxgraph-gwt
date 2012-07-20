package com.mxgraph.gwt.client.util;

/**
 * Defines various global constants.
 */
public class mxConstants {

	/**
	 * Defines the portion of the cell which is to be used as a connectable region. Default is 0.3. Possible values are 0 < x <= 1.
	 */
	public static double DEFAULT_HOTSPOT;

	/**
	 * Defines the minimum size in pixels of the portion of the cell which is to be used as a connectable region. Default is 8.
	 */
	public static int MIN_HOTSPOT_SIZE;

	/**
	 * Defines the maximum size in pixels of the portion of the cell which is to be used as a connectable region. Use 0 for no maximum. Default is 0.
	 */
	public static int MAX_HOTSPOT_SIZE;

	/**
	 * Defines the exact rendering hint.
	 */
	public static String RENDERING_HINT_EXACT;

	/**
	 * Defines the faster rendering hint.
	 */
	public static String RENDERING_HINT_FASTER;

	/**
	 * Defines the fastest rendering hint.
	 */
	public static String RENDERING_HINT_FASTEST;

	/**
	 * Defines the SVG display dialect name.
	 */
	public static String DIALECT_SVG;

	/**
	 * Defines the VML display dialect name.
	 */
	public static String DIALECT_VML;

	/**
	 * Defines the mixed HTML display dialect name.
	 */
	public static String DIALECT_MIXEDHTML;

	/**
	 * Defines the preferred HTML display dialect name.
	 */
	public static String DIALECT_PREFERHTML;

	/**
	 * Defines the strict HTML display dialect.
	 */
	public static String DIALECT_STRICTHTML;

	/**
	 * Defines the SVG namespace.
	 */
	public static String NS_SVG;

	/**
	 * Defines the XHTML namespace.
	 */
	public static String NS_XHTML;

	/**
	 * Defines the XLink namespace.
	 */
	public static String NS_XLINK;

	/**
	 * Defines the color to be used to draw shadows in shapes and windows. Default is gray.
	 */
	public static String SHADOWCOLOR;

	/**
	 * Defines the transformation used to draw shadows in SVG. Default is translate(2 3)
	 */
	public static String SVG_SHADOWTRANSFORM;

	/**
	 * Specifies the x-offset of the shadow. Default is 2. Note: This must match <SVG_SHADOWTRANSFORM>. This is only used in <mxStencil>.
	 */
	public static int SHADOW_OFFSET_X;

	/**
	 * Specifies the y-offset of the shadow. Default is 3. Note: This must match <SVG_SHADOWTRANSFORM>. This is only used in <mxStencil>.
	 */
	public static int SHADOW_OFFSET_Y;

	/**
	 * Defines the opacity for shadows. Default is 1. This is only used in <mxStencil>.
	 */
	public static int SHADOW_OPACITY;

	/**
	 * DOM node of type ELEMENT.
	 */
	public static int NODETYPE_ELEMENT;

	/**
	 * DOM node of type ATTRIBUTE.
	 */
	public static int NODETYPE_ATTRIBUTE;

	/**
	 * DOM node of type TEXT.
	 */
	public static int NODETYPE_TEXT;

	/**
	 * DOM node of type CDATA.
	 */
	public static int NODETYPE_CDATA;

	/**
	 * DOM node of type ENTITY_REFERENCE.
	 */
	public static int NODETYPE_ENTITY_REFERENCE;

	/**
	 * DOM node of type ENTITY.
	 */
	public static int NODETYPE_ENTITY;

	/**
	 * DOM node of type PROCESSING_INSTRUCTION.
	 */
	public static int NODETYPE_PROCESSING_INSTRUCTION;

	/**
	 * DOM node of type COMMENT.
	 */
	public static int NODETYPE_COMMENT;

	/**
	 * DOM node of type DOCUMENT.
	 */
	public static int NODETYPE_DOCUMENT;

	/**
	 * DOM node of type DOCUMENTTYPE.
	 */
	public static int NODETYPE_DOCUMENTTYPE;

	/**
	 * DOM node of type DOCUMENT_FRAGMENT.
	 */
	public static int NODETYPE_DOCUMENT_FRAGMENT;

	/**
	 * DOM node of type NOTATION.
	 */
	public static int NODETYPE_NOTATION;

	/**
	 * Defines the vertical offset for the tooltip. Default is 16.
	 */
	public static int TOOLTIP_VERTICAL_OFFSET;

	/**
	 * Specifies the default valid color. Default is #0000FF.
	 */
	public static String DEFAULT_VALID_COLOR;

	/**
	 * Specifies the default invalid color. Default is #FF0000.
	 */
	public static String DEFAULT_INVALID_COLOR;

	/**
	 * Defines the strokewidth to be used for the highlights. Default is 3.
	 */
	public static String HIGHLIGHT_STROKEWIDTH;

	/**
	 * Defines the cursor for a movable vertex. Default is 'move'.
	 */
	public static String CURSOR_MOVABLE_VERTEX;

	/**
	 * Defines the cursor for a movable edge. Default is 'move'.
	 */
	public static String CURSOR_MOVABLE_EDGE;

	/**
	 * Defines the cursor for a movable label. Default is 'default'.
	 */
	public static String CURSOR_MOVABLE_LABEL;

	/**
	 * Defines the cursor for a movable bend. Default is 'pointer'.
	 */
	public static String CURSOR_BEND_HANDLE;

	/**
	 * Defines the cursor for a connectable state. Default is 'pointer'.
	 */
	public static String CURSOR_CONNECT;

	/**
	 * Defines the color to be used for the cell highlighting. Use 'none' for no color. Default is #00FF00.
	 */
	public static String HIGHLIGHT_COLOR;

	/**
	 * Defines the color to be used for highlighting a target cell for a new or changed connection. Note that this may be either a source or target terminal in
	 * the graph. Use 'none' for no color. Default is #0000FF.
	 */
	public static String CONNECT_TARGET_COLOR;

	/**
	 * Defines the color to be used for highlighting a invalid target cells for a new or changed connections. Note that this may be either a source or target
	 * terminal in the graph. Use 'none' for no color. Default is #FF0000.
	 */
	public static String INVALID_CONNECT_TARGET_COLOR;

	/**
	 * Defines the color to be used for the highlighting target parent cells (for drag and drop). Use 'none' for no color. Default is #0000FF.
	 */
	public static String DROP_TARGET_COLOR;

	/**
	 * Defines the color to be used for the coloring valid connection previews. Use 'none' for no color. Default is #FF0000.
	 */
	public static String VALID_COLOR;

	/**
	 * Defines the color to be used for the coloring invalid connection previews. Use 'none' for no color. Default is #FF0000.
	 */
	public static String INVALID_COLOR;

	/**
	 * Defines the color to be used for the selection border of edges. Use 'none' for no color. Default is #00FF00.
	 */
	public static String EDGE_SELECTION_COLOR;

	/**
	 * Defines the color to be used for the selection border of vertices. Use 'none' for no color. Default is #00FF00.
	 */
	public static String VERTEX_SELECTION_COLOR;

	/**
	 * Defines the strokewidth to be used for vertex selections. Default is 1.
	 */
	public static int VERTEX_SELECTION_STROKEWIDTH;

	/**
	 * Defines the strokewidth to be used for edge selections. Default is 1.
	 */
	public static int EDGE_SELECTION_STROKEWIDTH;

	/**
	 * Defines the dashed state to be used for the vertex selection border. Default is true.
	 */
	public static boolean VERTEX_SELECTION_DASHED;

	/**
	 * Defines the dashed state to be used for the edge selection border. Default is true.
	 */
	public static boolean EDGE_SELECTION_DASHED;

	/**
	 * Defines the color to be used for the guidelines in mxGraphHandler. Default is #FF0000.
	 */
	public static String GUIDE_COLOR;

	/**
	 * Defines the strokewidth to be used for the guidelines in mxGraphHandler. Default is 1.
	 */
	public static int GUIDE_STROKEWIDTH;

	/**
	 * Defines the color to be used for the outline rectangle border. Use 'none' for no color. Default is #0099FF.
	 */
	public static String OUTLINE_COLOR;

	/**
	 * Defines the strokewidth to be used for the outline rectangle stroke width. Default is 3.
	 */
	public static int OUTLINE_STROKEWIDTH;

	/**
	 * Defines the default size for handles. Default is 7.
	 */
	public static int HANDLE_SIZE;

	/**
	 * Defines the default size for label handles. Default is 4.
	 */
	public static int LABEL_HANDLE_SIZE;

	/**
	 * Defines the color to be used for the handle fill color. Use 'none' for no color. Default is #00FF00 (green).
	 */
	public static String HANDLE_FILLCOLOR;

	/**
	 * Defines the color to be used for the handle stroke color. Use 'none' for no color. Default is black.
	 */
	public static String HANDLE_STROKECOLOR;

	/**
	 * Defines the color to be used for the label handle fill color. Use 'none' for no color. Default is yellow.
	 */
	public static String LABEL_HANDLE_FILLCOLOR;

	/**
	 * Defines the color to be used for the connect handle fill color. Use 'none' for no color. Default is #0000FF (blue).
	 */
	public static String CONNECT_HANDLE_FILLCOLOR;

	/**
	 * Defines the color to be used for the locked handle fill color. Use 'none' for no color. Default is #FF0000 (red).
	 */
	public static String LOCKED_HANDLE_FILLCOLOR;

	/**
	 * Defines the color to be used for the outline sizer fill color. Use 'none' for no color. Default is #00FFFF.
	 */
	public static String OUTLINE_HANDLE_FILLCOLOR;

	/**
	 * Defines the color to be used for the outline sizer stroke color. Use 'none' for no color. Default is #0033FF.
	 */
	public static String OUTLINE_HANDLE_STROKECOLOR;

	/**
	 * Defines the default family for all fonts in points. Default is Arial,Helvetica.
	 */
	public static String DEFAULT_FONTFAMILY;

	/**
	 * Defines the default size for all fonts in points. Default is 11.
	 */
	public static int DEFAULT_FONTSIZE;

	/**
	 * Defines the default start size for swimlanes. Default is 40.
	 */
	public static int DEFAULT_STARTSIZE;

	/**
	 * Defines the default size for all markers. Default is 6.
	 */
	public static int DEFAULT_MARKERSIZE;

	/**
	 * Defines the default width and height for images used in the label shape. Default is 24.
	 */
	public static int DEFAULT_IMAGESIZE;

	/**
	 * Defines the length of the horizontal segment of an Entity Relation. This can be overridden using <mxConstants.STYLE_SEGMENT> style. Default is 30.
	 */
	public static int ENTITY_SEGMENT;

	/**
	 * Defines the rounding factor for rounded rectangles in percent between 0 and 1. Values should be smaller than 0.5. Default is 0.15.
	 */
	public static double RECTANGLE_ROUNDING_FACTOR;

	/**
	 * Defines the size of the arcs for rounded edges. Default is 20.
	 */
	public static int LINE_ARCSIZE;

	/**
	 * Defines the spacing between the arrow shape and its terminals. Default is 10.
	 */
	public static int ARROW_SPACING;

	/**
	 * Defines the width of the arrow shape. Default is 30.
	 */
	public static int ARROW_WIDTH;

	/**
	 * Defines the size of the arrowhead in the arrow shape. Default is 30.
	 */
	public static int ARROW_SIZE;

	/**
	 * Defines the rectangle for the A4 portrait page format. The dimensions of this page format are 826x1169 pixels.
	 */
	public static mxRectangle PAGE_FORMAT_A4_PORTRAIT;

	/**
	 * Defines the rectangle for the A4 portrait page format. The dimensions of this page format are 826x1169 pixels.
	 */
	public static mxRectangle PAGE_FORMAT_A4_LANDSCAPE;

	/**
	 * Defines the rectangle for the Letter portrait page format. The dimensions of this page format are 850x1100 pixels.
	 */
	public static mxRectangle PAGE_FORMAT_LETTER_PORTRAIT;

	/**
	 * Defines the rectangle for the Letter portrait page format. The dimensions of this page format are 850x1100 pixels.
	 */
	public static mxRectangle PAGE_FORMAT_LETTER_LANDSCAPE;

	/**
	 * Defines the value for none. Default is "none".
	 */
	public static String NONE;

	/**
	 * Defines the key for the perimeter style. This is a function that defines the perimeter around a particular shape. Possible values are the functions
	 * defined in <mxPerimeter>. Alternatively, the constants in this class that start with <code>PERIMETER_</code> may be used to access perimeter styles in
	 * <mxStyleRegistry>.
	 */
	public static String STYLE_PERIMETER;

	/**
	 * Defines the ID of the cell that should be used for computing the perimeter point of the source for an edge. This allows for graphically connecting to a
	 * cell while keeping the actual terminal of the edge.
	 */
	public static String STYLE_SOURCE_PORT;

	/**
	 * Variable: STYLE_TARGET_PORT
	 * 
	 * Defines the ID of the cell that should be used for computing the perimeter point of the target for an edge. This allows for graphically connecting to a
	 * cell while keeping the actual terminal of the edge.
	 */
	public static String STYLE_TARGET_PORT;

	/**
	 * Defines the direction(s) that edges are allowed to connect to cells in. Possible values are <code>DIRECTION_NORTH, DIRECTION_SOUTH, 
	 * DIRECTION_EAST</code> and <code>DIRECTION_WEST</code>.
	 */
	public static String STYLE_PORT_CONSTRAINT;

	/**
	 * Defines the key for the opacity style. The type of the value is numeric and the possible range is 0-100.
	 */
	public static String STYLE_OPACITY;

	/**
	 * Defines the key for the text opacity style. The type of the value is numeric and the possible range is 0-100.
	 */
	public static String STYLE_TEXT_OPACITY;

	/**
	 * Defines the key for the overflow style. Possible values are 'visible', 'hidden' and 'fill'. The default value is 'visible'. This value specifies how
	 * overlapping vertex labels are handled. A value of 'visible' will show the complete label. A value of 'hidden' will clip the label so that it does not
	 * overlap the vertex bounds. A value of 'fill' will use the vertex bounds for the label. See <mxGraph.isLabelClipped>.
	 */
	public static String STYLE_OVERFLOW;

	/**
	 * Defines if the connection points on either end of the edge should be computed so that the edge is vertical or horizontal if possible and if the point is
	 * not at a fixed location. Default is false. This is used in <mxGraph.isOrthogonal>, which also returns true if the edgeStyle of the edge is an elbow or
	 * entity.
	 */
	public static String STYLE_ORTHOGONAL;

	/**
	 * Defines the key for the horizontal relative coordinate connection point of an edge with its source terminal.
	 */
	public static String STYLE_EXIT_X;

	/**
	 * Defines the key for the vertical relative coordinate connection point of an edge with its source terminal.
	 */
	public static String STYLE_EXIT_;

	/**
	 * Defines if the perimeter should be used to find the exact entry point along the perimeter of the source. Possible values are 0 (false) and 1 (true).
	 * Default is 1 (true).
	 */
	public static String STYLE_EXIT_PERIMETER;

	/**
	 * Defines the key for the horizontal relative coordinate connection point of an edge with its target terminal.
	 */
	public static String STYLE_ENTRY_X;

	/**
	 * Defines the key for the vertical relative coordinate connection point of an edge with its target terminal.
	 */
	public static String STYLE_ENTRY_Y;

	/**
	 * Defines if the perimeter should be used to find the exact entry point along the perimeter of the target. Possible values are 0 (false) and 1 (true).
	 * Default is 1 (true).
	 */
	public static String STYLE_ENTRY_PERIMETER;

	/**
	 * Defines the key for the white-space style. Possible values are 'nowrap' and 'wrap'. The default value is 'nowrap'. This value specifies how white-space
	 * inside a HTML vertex label should be handled. A value of 'nowrap' means the text will never wrap to the next line until a linefeed is encountered. A
	 * value of 'wrap' means text will wrap when necessary. This style is only used for HTML labels. See <mxGraph.isWrapping>.
	 */
	public static String STYLE_WHITE_SPACE;

	/**
	 * Defines the key for the rotation style. The type of the value is numeric and the possible range is 0-360.
	 */
	public static String STYLE_ROTATION;

	/**
	 * Defines the key for the fill color. Possible values are all HTML color names or HEX codes, as well as special keywords such as 'swimlane, 'inherit' or
	 * 'indicated' to use the color code of a related cell or the indicator shape.
	 */
	public static String STYLE_FILLCOLOR;

	/**
	 * Defines the key for the gradient color. Possible values are all HTML color names or HEX codes, as well as special keywords such as 'swimlane, 'inherit'
	 * or 'indicated' to use the color code of a related cell or the indicator shape. This is ignored if no fill color is defined.
	 */
	public static String STYLE_GRADIENTCOLOR;

	/**
	 * Defines the key for the gradient direction. Possible values are <DIRECTION_EAST>, <DIRECTION_WEST>, <DIRECTION_NORTH> and <DIRECTION_SOUTH>. Default is
	 * <DIRECTION_SOUTH>. Generally, and by default in mxGraph, gradient painting is done from the value of <STYLE_FILLCOLOR> to the value of
	 * <STYLE_GRADIENTCOLOR>. Taking the example of <DIRECTION_NORTH>, this means <STYLE_FILLCOLOR> color at the bottom of paint pattern and
	 * <STYLE_GRADIENTCOLOR> at top, with a gradient in-between.
	 */
	public static String STYLE_GRADIENT_DIRECTION;

	/**
	 * Defines the key for the strokeColor style. Possible values are all HTML color names or HEX codes, as well as special keywords such as 'swimlane,
	 * 'inherit', 'indicated' to use the color code of a related cell or the indicator shape or 'none' for no color.
	 */
	public static String STYLE_STROKECOLOR;

	/**
	 * Defines the key for the separatorColor style. Possible values are all HTML color names or HEX codes. This style is only used for <SHAPE_SWIMLANE> shapes.
	 */
	public static String STYLE_SEPARATORCOLOR;

	/**
	 * Defines the key for the strokeWidth style. The type of the value is numeric and the possible range is any non-negative value larger or equal to 1. The
	 * value defines the stroke width in pixels. Note: To hide a stroke use strokeColor none.
	 */
	public static String STYLE_STROKEWIDTH;

	/**
	 * Defines the key for the align style. Possible values are <ALIGN_LEFT>, <ALIGN_CENTER> and <ALIGN_RIGHT>. This value defines how the lines of the label
	 * are horizontally aligned. <ALIGN_LEFT> mean label text lines are aligned to left of the label bounds, <ALIGN_RIGHT> to the right of the label bounds and
	 * <ALIGN_CENTER> means the center of the text lines are aligned in the center of the label bounds. Note this value doesn't affect the positioning of the
	 * overall label bounds relative to the vertex, to move the label bounds horizontally, use <STYLE_LABEL_POSITION>.
	 */
	public static String STYLE_ALIGN;

	/**
	 * Defines the key for the verticalAlign style. Possible values are <ALIGN_TOP>, <ALIGN_MIDDLE> and <ALIGN_BOTTOM>. This value defines how the lines of the
	 * label are vertically aligned. <ALIGN_TOP> means the topmost label text line is aligned against the top of the label bounds, <ALIGN_BOTTOM> means the
	 * bottom-most label text line is aligned against the bottom of the label bounds and <ALIGN_MIDDLE> means there is equal spacing between the topmost text
	 * label line and the top of the label bounds and the bottom-most text label line and the bottom of the label bounds. Note this value doesn't affect the
	 * positioning of the overall label bounds relative to the vertex, to move the label bounds vertically, use <STYLE_VERTICAL_LABEL_POSITION>.
	 */
	public static String STYLE_VERTICAL_ALIGN;

	/**
	 * Defines the key for the horizontal label position of vertices. Possible values are <ALIGN_LEFT>, <ALIGN_CENTER> and <ALIGN_RIGHT>. Default is
	 * <ALIGN_CENTER>. The label align defines the position of the label relative to the cell. <ALIGN_LEFT> means the entire label bounds is placed completely
	 * just to the left of the vertex, <ALIGN_RIGHT> means adjust to the right and <ALIGN_CENTER> means the label bounds are vertically aligned with the bounds
	 * of the vertex. Note this value doesn't affect the positioning of label within the label bounds, to move the label horizontally within the label bounds,
	 * use <STYLE_ALIGN>.
	 */
	public static String STYLE_LABEL_POSITION;

	/**
	 * Defines the key for the vertical label position of vertices. Possible values are <ALIGN_TOP>, <ALIGN_BOTTOM> and <ALIGN_MIDDLE>. Default is
	 * <ALIGN_MIDDLE>. The label align defines the position of the label relative to the cell. <ALIGN_TOP> means the entire label bounds is placed completely
	 * just on the top of the vertex, <ALIGN_BOTTOM> means adjust on the bottom and <ALIGN_MIDDLE> means the label bounds are horizontally aligned with the
	 * bounds of the vertex. Note this value doesn't affect the positioning of label within the label bounds, to move the label vertically within the label
	 * bounds, use <STYLE_VERTICAL_ALIGN>.
	 */
	public static String STYLE_VERTICAL_LABEL_POSITION;

	/**
	 * Defines the key for the align style. Possible values are <ALIGN_LEFT>, <ALIGN_CENTER> and <ALIGN_RIGHT>. The value defines how any image in the vertex
	 * label is aligned horizontally within the label bounds of a <SHAPE_LABEL> shape.
	 */
	public static String STYLE_IMAGE_ALIGN;

	/**
	 * Defines the key for the verticalAlign style. Possible values are <ALIGN_TOP>, <ALIGN_MIDDLE> and <ALIGN_BOTTOM>. The value defines how any image in the
	 * vertex label is aligned vertically within the label bounds of a <SHAPE_LABEL> shape.
	 */
	public static String STYLE_IMAGE_VERTICAL_ALIGN;

	/**
	 * Defines the key for the glass style. Possible values are 0 (disabled) and 1(enabled). The default value is 0. This is used in <mxLabel>.
	 */
	public static String STYLE_GLASS;

	/**
	 * Defines the key for the image style. Possible values are any image URL, the type of the value is String. This is the path to the image to image that is
	 * to be displayed within the label of a vertex.
	 */
	public static String STYLE_IMAGE;

	/**
	 * Defines the key for the imageWidth style. The type of this value is int, the value is the image width in pixels and must be greater than 0.
	 */
	public static String STYLE_IMAGE_WIDTH;

	/**
	 * Defines the key for the imageHeight style. The type of this value is int, the value is the image height in pixels and must be greater than 0.
	 */
	public static String STYLE_IMAGE_HEIGHT;

	/**
	 * Defines the key for the image background color. This style is only used in <mxImageShape>. Possible values are all HTML color names or HEX codes.
	 */
	public static String STYLE_IMAGE_BACKGROUND;

	/**
	 * Defines the key for the image border color. This style is only used in <mxImageShape>. Possible values are all HTML color names or HEX codes.
	 */
	public static String STYLE_IMAGE_BORDER;

	/**
	 * Defines the key for the horizontal image flip. This style is only used in <mxImageShape>. Possible values are 0 and 1. Default is 0.
	 */
	public static String STYLE_IMAGE_FLIPH;

	/**
	 * Defines the key for the vertical image flip. This style is only used in <mxImageShape>. Possible values are 0 and 1. Default is 0.
	 */
	public static String STYLE_IMAGE_FLIPV;

	/**
	 * Defines the key for the horizontal stencil flip. This style is only used in <mxStencilShape>. Possible values are 0 and 1. Default is 0.
	 */
	public static String STYLE_FLIPH;

	/**
	 * Defines the key for the vertical stencil flip. This style is only used in <mxStencilShape>. Possible values are 0 and 1. Default is 0.
	 */
	public static String STYLE_FLIPV;

	/**
	 * Defines the key for the noLabel style. If this is true then no label is visible for a given cell. Possible values are true or false (1 or 0). Default is
	 * false.
	 */
	public static String STYLE_NOLABEL;

	/**
	 * Defines the key for the noEdgeStyle style. If this is true then no edge style is applied for a given edge. Possible values are true or false (1 or 0).
	 * Default is false.
	 */
	public static String STYLE_NOEDGESTYLE;

	/**
	 * Defines the key for the label background color. Possible values are all HTML color names or HEX codes.
	 */
	public static String STYLE_LABEL_BACKGROUNDCOLOR;

	/**
	 * Defines the key for the label border color. Possible values are all HTML color names or HEX codes.
	 */
	public static String STYLE_LABEL_BORDERCOLOR;

	/**
	 * Defines the key for the indicator shape used within an <mxLabel>. Possible values are all SHAPE_* constants or the names of any new shapes.
	 */
	public static String STYLE_INDICATOR_SHAPE;

	/**
	 * Defines the key for the indicator image used within an <mxLabel>. Possible values are all image URLs.
	 */
	public static String STYLE_INDICATOR_IMAGE;

	/**
	 * Defines the key for the indicatorColor style. Possible values are all HTML color names or HEX codes, as well as the special 'swimlane' keyword to refer
	 * to the color of the parent swimlane if one exists.
	 */
	public static String STYLE_INDICATOR_COLOR;

	/**
	 * Defines the key for the indicator stroke color in <mxLabel>. Possible values are all color codes.
	 */
	public static String STYLE_INDICATOR_STROKECOLOR;

	/**
	 * Defines the key for the indicatorGradientColor style. Possible values are all HTML color names or HEX codes. This style is only supported in
	 * <SHAPE_LABEL> shapes.
	 */
	public static String STYLE_INDICATOR_GRADIENTCOLOR;

	/**
	 * The defines the key for the spacing between the label and the indicator in <mxLabel>. Possible values are in pixels.
	 */
	public static String STYLE_INDICATOR_SPACING;

	/**
	 * Defines the key for the indicator width. Possible values start at 0 (in pixels).
	 */
	public static String STYLE_INDICATOR_WIDTH;

	/**
	 * Defines the key for the indicator height. Possible values start at 0 (in pixels).
	 */
	public static String STYLE_INDICATOR_HEIGHT;

	/**
	 * Defines the key for the indicatorDirection style. The direction style is used to specify the direction of certain shapes (eg. <mxTriangle>). Possible
	 * values are <DIRECTION_EAST> (default), <DIRECTION_WEST>, <DIRECTION_NORTH> and <DIRECTION_SOUTH>.
	 */
	public static String STYLE_INDICATOR_DIRECTION;

	/**
	 * Defines the key for the shadow style. The type of the value is Boolean.
	 */
	public static String STYLE_SHADOW;

	/**
	 * Defines the key for the segment style. The type of this value is double and the value represents the size of the horizontal segment of the entity
	 * relation style. Default is ENTITY_SEGMENT.
	 */
	public static String STYLE_SEGMENT;

	/**
	 * Defines the key for the end arrow marker. Possible values are all constants with an ARROW-prefix. This is only used in <mxConnector>.
	 * 
	 * Example: (code) style[mxConstants.STYLE_ENDARROW] = mxConstants.ARROW_CLASSIC; (end)
	 */
	public static String STYLE_ENDARROW;

	/**
	 * Defines the key for the start arrow marker. Possible values are all constants with an ARROW-prefix. This is only used in <mxConnector>. See
	 * <STYLE_ENDARROW>.
	 */
	public static String STYLE_STARTARROW;

	/**
	 * Defines the key for the endSize style. The type of this value is numeric and the value represents the size of the end marker in pixels.
	 */
	public static String STYLE_ENDSIZE;

	/**
	 * Defines the key for the startSize style. The type of this value is numeric and the value represents the size of the start marker or the size of the
	 * swimlane title region depending on the shape it is used for.
	 */
	public static String STYLE_STARTSIZE;

	/**
	 * Defines the key for the endSize style. The type of this value is numeric and the value represents the size of the end marker in pixels.
	 */
	public static String STYLE_DASHED;

	/**
	 * Defines the key for the rounded style. The type of this value is Boolean. For edges this determines whether or not joins between edges segments are
	 * smoothed to a rounded finish. For vertices that have the rectangle shape, this determines whether or not the rectangle is rounded.
	 */
	public static String STYLE_ROUNDED;

	/**
	 * An experimental style for edges. This style is currently not available in the backends and is implemented differently for VML and SVG. The use of this
	 * style is currently only recommended for VML.
	 */
	public static String STYLE_SMOOTH;

	/**
	 * Defines the key for the source perimeter spacing. The type of this value is numeric. This is the distance between the source connection point of an edge
	 * and the perimeter of the source vertex in pixels. This style only applies to edges.
	 */
	public static String STYLE_SOURCE_PERIMETER_SPACING;

	/**
	 * Defines the key for the target perimeter spacing. The type of this value is numeric. This is the distance between the target connection point of an edge
	 * and the perimeter of the target vertex in pixels. This style only applies to edges.
	 */
	public static String STYLE_TARGET_PERIMETER_SPACING;

	/**
	 * Defines the key for the perimeter spacing. This is the distance between the connection point and the perimeter in pixels. When used in a vertex style,
	 * this applies to all incoming edges to floating ports (edges that terminate on the perimeter of the vertex). When used in an edge style, this spacing
	 * applies to the source and target separately, if they terminate in floating ports (on the perimeter of the vertex).
	 */
	public static String STYLE_PERIMETER_SPACING;

	/**
	 * Defines the key for the spacing. The value represents the spacing, in pixels, added to each side of a label in a vertex (style applies to vertices only).
	 */
	public static String STYLE_SPACING;

	/**
	 * Defines the key for the spacingTop style. The value represents the spacing, in pixels, added to the top side of a label in a vertex (style applies to
	 * vertices only).
	 */
	public static String STYLE_SPACING_TOP;

	/**
	 * Defines the key for the spacingLeft style. The value represents the spacing, in pixels, added to the left side of a label in a vertex (style applies to
	 * vertices only).
	 */
	public static String STYLE_SPACING_LEFT;

	/**
	 * Defines the key for the spacingBottom style The value represents the spacing, in pixels, added to the bottom side of a label in a vertex (style applies
	 * to vertices only).
	 */
	public static String STYLE_SPACING_BOTTOM;

	/**
	 * Defines the key for the spacingRight style The value represents the spacing, in pixels, added to the right side of a label in a vertex (style applies to
	 * vertices only).
	 */
	public static String STYLE_SPACING_RIGHT;

	/**
	 * Defines the key for the horizontal style. Possible values are true or false. This value only applies to vertices. If the <STYLE_SHAPE> is
	 * <code>SHAPE_SWIMLANE</code> a value of false indicates that the swimlane should be drawn vertically, true indicates to draw it horizontally. If the shape
	 * style does not indicate that this vertex is a swimlane, this value affects only whether the label is drawn horizontally or vertically.
	 */
	public static String STYLE_HORIZONTAL;

	/**
	 * Defines the key for the direction style. The direction style is used to specify the direction of certain shapes (eg. <mxTriangle>). Possible values are
	 * <DIRECTION_EAST> (default), <DIRECTION_WEST>, <DIRECTION_NORTH> and <DIRECTION_SOUTH>.
	 */
	public static String STYLE_DIRECTION;

	/**
	 * Defines the key for the elbow style. Possible values are <ELBOW_HORIZONTAL> and <ELBOW_VERTICAL>. Default is <ELBOW_HORIZONTAL>. This defines how the
	 * three segment orthogonal edge style leaves its terminal vertices. The vertical style leaves the terminal vertices at the top and bottom sides.
	 */
	public static String STYLE_ELBOW;

	/**
	 * Defines the key for the fontColor style. Possible values are all HTML color names or HEX codes.
	 */
	public static String STYLE_FONTCOLOR;

	/**
	 * Defines the key for the fontFamily style. Possible values are names such as Arial; Dialog; Verdana; Times New Roman. The value is of type String.
	 */
	public static String STYLE_FONTFAMILY;

	/**
	 * Defines the key for the fontSize style (in points). The type of the value is int.
	 */
	public static String STYLE_FONTSIZE;

	/**
	 * Defines the key for the fontStyle style. Values may be any logical AND (sum) of <FONT_BOLD>, <FONT_ITALIC>, <FONT_UNDERLINE> and <FONT_SHADOW>. The type
	 * of the value is int.
	 */
	public static String STYLE_FONTSTYLE;

	/**
	 * Defines the key for the autosize style. This specifies if a cell should be resized automatically if the value has changed. Possible values are 0 or 1.
	 * Default is 0. See <mxGraph.isAutoSizeCell>. This is normally combined with <STYLE_RESIZABLE> to disable manual sizing.
	 */
	public static String STYLE_AUTOSIZE;

	/**
	 * Defines the key for the foldable style. This specifies if a cell is foldable using a folding icon. Possible values are 0 or 1. Default is 1. See
	 * <mxGraph.isCellFoldable>.
	 */
	public static String STYLE_FOLDABLE;

	/**
	 * Defines the key for the editable style. This specifies if the value of a cell can be edited using the in-place editor. Possible values are 0 or 1.
	 * Default is 1. See <mxGraph.isCellEditable>.
	 */
	public static String STYLE_EDITABLE;

	/**
	 * Defines the key for the bendable style. This specifies if the control points of an edge can be moved. Possible values are 0 or 1. Default is 1. See
	 * <mxGraph.isCellBendable>.
	 */
	public static String STYLE_BENDABLE;

	/**
	 * Defines the key for the movable style. This specifies if a cell can be moved. Possible values are 0 or 1. Default is 1. See <mxGraph.isCellMovable>.
	 */
	public static String STYLE_MOVABLE;

	/**
	 * Defines the key for the resizable style. This specifies if a cell can be resized. Possible values are 0 or 1. Default is 1. See
	 * <mxGraph.isCellResizable>.
	 */
	public static String STYLE_RESIZABLE;

	/**
	 * Defines the key for the cloneable style. This specifies if a cell can be cloned. Possible values are 0 or 1. Default is 1. See <mxGraph.isCellCloneable>.
	 */
	public static String STYLE_CLONEABLE;

	/**
	 * Defines the key for the deletable style. This specifies if a cell can be deleted. Possible values are 0 or 1. Default is 1. See
	 * <mxGraph.isCellDeletable>.
	 */
	public static String STYLE_DELETABLE;

	/**
	 * Defines the key for the shape. Possible values are all constants with a SHAPE-prefix or any newly defined shape names.
	 */
	public static String STYLE_SHAPE;

	/**
	 * Defines the key for the edge style. Possible values are the functions defined in <mxEdgeStyle>.
	 */
	public static String STYLE_EDGE;

	/**
	 * Defines the key for the loop style. Possible values are the functions defined in <mxEdgeStyle>.
	 */
	public static String STYLE_LOOP;

	/**
	 * Defines the key for the horizontal routing center. Possible values are between -0.5 and 0.5. This is the relative offset from the center used for
	 * connecting edges. The type of this value is numeric.
	 */
	public static String STYLE_ROUTING_CENTER_X;

	/**
	 * Defines the key for the vertical routing center. Possible values are between -0.5 and 0.5. This is the relative offset from the center used for
	 * connecting edges. The type of this value is numeric.
	 */
	public static String STYLE_ROUTING_CENTER_Y;

	/**
	 * Constant for bold fonts. Default is 1.
	 */
	public static int FONT_BOLD;

	/**
	 * Constant for italic fonts. Default is 2.
	 */
	public static int FONT_ITALIC;

	/**
	 * Constant for underlined fonts. Default is 4.
	 */
	public static int FONT_UNDERLINE;

	/**
	 * Constant for fonts with a shadow. Default is 8.
	 */
	public static int FONT_SHADOW;

	/**
	 * Name under which <mxRectangleShape> is registered in <mxCellRenderer>. Default is rectangle.
	 */
	public static String SHAPE_RECTANGLE;

	/**
	 * Name under which <mxEllipse> is registered in <mxCellRenderer>. Default is ellipse.
	 */
	public static String SHAPE_ELLIPSE;

	/**
	 * Name under which <mxDoubleEllipse> is registered in <mxCellRenderer>. Default is doubleEllipse.
	 */
	public static String SHAPE_DOUBLE_ELLIPSE;

	/**
	 * Name under which <mxRhombus> is registered in <mxCellRenderer>. Default is rhombus.
	 */
	public static String SHAPE_RHOMBUS;

	/**
	 * Name under which <mxLine> is registered in <mxCellRenderer>. Default is line.
	 */
	public static String SHAPE_LINE;

	/**
	 * Name under which <mxImageShape> is registered in <mxCellRenderer>. Default is image.
	 */
	public static String SHAPE_IMAGE;

	/**
	 * Name under which <mxArrow> is registered in <mxCellRenderer>. Default is arrow.
	 */
	public static String SHAPE_ARROW;

	/**
	 * Name under which <mxLabel> is registered in <mxCellRenderer>. Default is label.
	 */
	public static String SHAPE_LABEL;

	/**
	 * Name under which <mxCylinder> is registered in <mxCellRenderer>. Default is cylinder.
	 */
	public static String SHAPE_CYLINDER;

	/**
	 * Name under which <mxSwimlane> is registered in <mxCellRenderer>. Default is swimlane.
	 */
	public static String SHAPE_SWIMLANE;

	/**
	 * Name under which <mxConnector> is registered in <mxCellRenderer>. Default is connector.
	 */
	public static String SHAPE_CONNECTOR;

	/**
	 * Name under which <mxActor> is registered in <mxCellRenderer>. Default is actor.
	 */
	public static String SHAPE_ACTOR;

	/**
	 * Name under which <mxCloud> is registered in <mxCellRenderer>. Default is cloud.
	 */
	public static String SHAPE_CLOUD;

	/**
	 * Name under which <mxTriangle> is registered in <mxCellRenderer>. Default is triangle.
	 */
	public static String SHAPE_TRIANGLE;

	/**
	 * Name under which <mxHexagon> is registered in <mxCellRenderer>. Default is hexagon.
	 */
	public static String SHAPE_HEXAGON;

	/**
	 * Constant for classic arrow markers.
	 */
	public static String ARROW_CLASSIC;

	/**
	 * Constant for block arrow markers.
	 */
	public static String ARROW_BLOCK;

	/**
	 * Constant for open arrow markers.
	 */
	public static String ARROW_OPEN;

	/**
	 * Constant for oval arrow markers.
	 */
	public static String ARROW_OVAL;

	/**
	 * Constant for diamond arrow markers.
	 */
	public static String ARROW_DIAMOND;

	/**
	 * Constant for left horizontal alignment. Default is left.
	 */
	public static String ALIGN_LEFT;

	/**
	 * Constant for center horizontal alignment. Default is center.
	 */
	public static String ALIGN_CENTER;

	/**
	 * Constant for right horizontal alignment. Default is right.
	 */
	public static String ALIGN_RIGHT;

	/**
	 * Constant for top vertical alignment. Default is top.
	 */
	public static String ALIGN_TOP;

	/**
	 * Constant for middle vertical alignment. Default is middle.
	 */
	public static String ALIGN_MIDDLE;

	/**
	 * Constant for bottom vertical alignment. Default is bottom.
	 */
	public static String ALIGN_BOTTOM;

	/**
	 * Constant for direction north. Default is north.
	 */
	public static String DIRECTION_NORTH;

	/**
	 * Constant for direction south. Default is south.
	 */
	public static String DIRECTION_SOUTH;

	/**
	 * Constant for direction east. Default is east.
	 */
	public static String DIRECTION_EAST;

	/**
	 * Constant for direction west. Default is west.
	 */
	public static String DIRECTION_WEST;

	/**
	 * Constant for no direction.
	 */
	public static int DIRECTION_MASK_NONE;

	/**
	 * Bitwise mask for west direction.
	 */
	public static int DIRECTION_MASK_WEST;

	/**
	 * Bitwise mask for north direction.
	 */
	public static int DIRECTION_MASK_NORTH;

	/**
	 * Bitwise mask for south direction.
	 */
	public static int DIRECTION_MASK_SOUTH;

	/**
	 * Bitwise mask for east direction.
	 */
	public static int DIRECTION_MASK_EAST;

	/**
	 * Bitwise mask for all directions.
	 */
	public static int DIRECTION_MASK_ALL;

	/**
	 * Constant for elbow vertical. Default is horizontal.
	 */
	public static String ELBOW_VERTICAL;

	/**
	 * Constant for elbow horizontal. Default is horizontal.
	 */
	public static String ELBOW_HORIZONTAL;

	/**
	 * Name of the elbow edge style. Can be used as a string value for the STYLE_EDGE style.
	 */
	public static String EDGESTYLE_ELBOW;

	/**
	 * Name of the entity relation edge style. Can be used as a string value for the STYLE_EDGE style.
	 */
	public static String EDGESTYLE_ENTITY_RELATION;

	/**
	 * Name of the loop edge style. Can be used as a string value for the STYLE_EDGE style.
	 */
	public static String EDGESTYLE_LOOP;

	/**
	 * Name of the side to side edge style. Can be used as a string value for the STYLE_EDGE style.
	 */
	public static String EDGESTYLE_SIDETOSIDE;

	/**
	 * Name of the top to bottom edge style. Can be used as a string value for the STYLE_EDGE style.
	 */
	public static String EDGESTYLE_TOPTOBOTTOM;

	/**
	 * Name of the generic orthogonal edge style. Can be used as a string value for the STYLE_EDGE style.
	 */
	public static String EDGESTYLE_ORTHOGONAL;

	/**
	 * Name of the generic segment edge style. Can be used as a string value for the STYLE_EDGE style.
	 */
	public static String EDGESTYLE_SEGMENT;

	/**
	 * Name of the ellipse perimeter. Can be used as a string value for the STYLE_PERIMETER style.
	 */
	public static String PERIMETER_ELLIPSE;

	/**
	 * Name of the rectangle perimeter. Can be used as a string value for the STYLE_PERIMETER style.
	 */
	public static String PERIMETER_RECTANGLE;

	/**
	 * Name of the rhombus perimeter. Can be used as a string value for the STYLE_PERIMETER style.
	 */
	public static String PERIMETER_RHOMBUS;

	/**
	 * Name of the triangle perimeter. Can be used as a string value for the STYLE_PERIMETER style.
	 */
	public static String PERIMETER_TRIANGLE;

	static {
		initialize();
	}

	private static native void initialize() /*-{
		@com.mxgraph.gwt.client.util.mxConstants::DEFAULT_HOTSPOT = $wnd.mxConstants.DEFAULT_HOTSPOT;
		@com.mxgraph.gwt.client.util.mxConstants::MIN_HOTSPOT_SIZE = $wnd.mxConstants.MIN_HOTSPOT_SIZE;
		@com.mxgraph.gwt.client.util.mxConstants::MAX_HOTSPOT_SIZE = $wnd.mxConstants.MAX_HOTSPOT_SIZE;
		@com.mxgraph.gwt.client.util.mxConstants::RENDERING_HINT_EXACT = $wnd.mxConstants.RENDERING_HINT_EXACT;
		@com.mxgraph.gwt.client.util.mxConstants::RENDERING_HINT_FASTER = $wnd.mxConstants.RENDERING_HINT_FASTER;
		@com.mxgraph.gwt.client.util.mxConstants::RENDERING_HINT_FASTEST = $wnd.mxConstants.RENDERING_HINT_FASTEST;
		@com.mxgraph.gwt.client.util.mxConstants::DIALECT_SVG = $wnd.mxConstants.DIALECT_SVG;
		@com.mxgraph.gwt.client.util.mxConstants::DIALECT_VML = $wnd.mxConstants.DIALECT_VML;
		@com.mxgraph.gwt.client.util.mxConstants::DIALECT_MIXEDHTML = $wnd.mxConstants.DIALECT_MIXEDHTML;
		@com.mxgraph.gwt.client.util.mxConstants::DIALECT_PREFERHTML = $wnd.mxConstants.DIALECT_PREFERHTML;
		@com.mxgraph.gwt.client.util.mxConstants::DIALECT_STRICTHTML = $wnd.mxConstants.DIALECT_STRICTHTML;
		@com.mxgraph.gwt.client.util.mxConstants::NS_SVG = $wnd.mxConstants.NS_SVG;
		@com.mxgraph.gwt.client.util.mxConstants::NS_XHTML = $wnd.mxConstants.NS_XHTML;
		@com.mxgraph.gwt.client.util.mxConstants::NS_XLINK = $wnd.mxConstants.NS_XLINK;
		@com.mxgraph.gwt.client.util.mxConstants::SHADOWCOLOR = $wnd.mxConstants.SHADOWCOLOR;
		@com.mxgraph.gwt.client.util.mxConstants::SVG_SHADOWTRANSFORM = $wnd.mxConstants.SVG_SHADOWTRANSFORM;
		@com.mxgraph.gwt.client.util.mxConstants::SHADOW_OFFSET_X = $wnd.mxConstants.SHADOW_OFFSET_X;
		@com.mxgraph.gwt.client.util.mxConstants::SHADOW_OFFSET_Y = $wnd.mxConstants.SHADOW_OFFSET_Y;
		@com.mxgraph.gwt.client.util.mxConstants::SHADOW_OPACITY = $wnd.mxConstants.SHADOW_OPACITY;
		@com.mxgraph.gwt.client.util.mxConstants::NODETYPE_ELEMENT = $wnd.mxConstants.NODETYPE_ELEMENT;
		@com.mxgraph.gwt.client.util.mxConstants::NODETYPE_ATTRIBUTE = $wnd.mxConstants.NODETYPE_ATTRIBUTE;
		@com.mxgraph.gwt.client.util.mxConstants::NODETYPE_TEXT = $wnd.mxConstants.NODETYPE_TEXT;
		@com.mxgraph.gwt.client.util.mxConstants::NODETYPE_CDATA = $wnd.mxConstants.NODETYPE_CDATA;
		@com.mxgraph.gwt.client.util.mxConstants::NODETYPE_ENTITY_REFERENCE = $wnd.mxConstants.NODETYPE_ENTITY_REFERENCE;
		@com.mxgraph.gwt.client.util.mxConstants::NODETYPE_ENTITY = $wnd.mxConstants.NODETYPE_ENTITY;
		@com.mxgraph.gwt.client.util.mxConstants::NODETYPE_PROCESSING_INSTRUCTION = $wnd.mxConstants.NODETYPE_PROCESSING_INSTRUCTION;
		@com.mxgraph.gwt.client.util.mxConstants::NODETYPE_COMMENT = $wnd.mxConstants.NODETYPE_COMMENT;
		@com.mxgraph.gwt.client.util.mxConstants::NODETYPE_DOCUMENT = $wnd.mxConstants.NODETYPE_DOCUMENT;
		@com.mxgraph.gwt.client.util.mxConstants::NODETYPE_DOCUMENTTYPE = $wnd.mxConstants.NODETYPE_DOCUMENTTYPE;
		@com.mxgraph.gwt.client.util.mxConstants::NODETYPE_DOCUMENT_FRAGMENT = $wnd.mxConstants.NODETYPE_DOCUMENT_FRAGMENT;
		@com.mxgraph.gwt.client.util.mxConstants::NODETYPE_NOTATION = $wnd.mxConstants.NODETYPE_NOTATION;
		@com.mxgraph.gwt.client.util.mxConstants::TOOLTIP_VERTICAL_OFFSET = $wnd.mxConstants.TOOLTIP_VERTICAL_OFFSET;
		@com.mxgraph.gwt.client.util.mxConstants::DEFAULT_VALID_COLOR = $wnd.mxConstants.DEFAULT_VALID_COLOR;
		@com.mxgraph.gwt.client.util.mxConstants::DEFAULT_INVALID_COLOR = $wnd.mxConstants.DEFAULT_INVALID_COLOR;
		@com.mxgraph.gwt.client.util.mxConstants::HIGHLIGHT_STROKEWIDTH = $wnd.mxConstants.HIGHLIGHT_STROKEWIDTH;
		@com.mxgraph.gwt.client.util.mxConstants::CURSOR_MOVABLE_VERTEX = $wnd.mxConstants.CURSOR_MOVABLE_VERTEX;
		@com.mxgraph.gwt.client.util.mxConstants::CURSOR_MOVABLE_EDGE = $wnd.mxConstants.CURSOR_MOVABLE_EDGE;
		@com.mxgraph.gwt.client.util.mxConstants::CURSOR_MOVABLE_LABEL = $wnd.mxConstants.CURSOR_MOVABLE_LABEL;
		@com.mxgraph.gwt.client.util.mxConstants::CURSOR_BEND_HANDLE = $wnd.mxConstants.CURSOR_BEND_HANDLE;
		@com.mxgraph.gwt.client.util.mxConstants::CURSOR_CONNECT = $wnd.mxConstants.CURSOR_CONNECT;
		@com.mxgraph.gwt.client.util.mxConstants::HIGHLIGHT_COLOR = $wnd.mxConstants.HIGHLIGHT_COLOR;
		@com.mxgraph.gwt.client.util.mxConstants::CONNECT_TARGET_COLOR = $wnd.mxConstants.CONNECT_TARGET_COLOR;
		@com.mxgraph.gwt.client.util.mxConstants::INVALID_CONNECT_TARGET_COLOR = $wnd.mxConstants.INVALID_CONNECT_TARGET_COLOR;
		@com.mxgraph.gwt.client.util.mxConstants::DROP_TARGET_COLOR = $wnd.mxConstants.DROP_TARGET_COLOR;
		@com.mxgraph.gwt.client.util.mxConstants::VALID_COLOR = $wnd.mxConstants.VALID_COLOR;
		@com.mxgraph.gwt.client.util.mxConstants::INVALID_COLOR = $wnd.mxConstants.INVALID_COLOR;
		@com.mxgraph.gwt.client.util.mxConstants::EDGE_SELECTION_COLOR = $wnd.mxConstants.EDGE_SELECTION_COLOR;
		@com.mxgraph.gwt.client.util.mxConstants::VERTEX_SELECTION_COLOR = $wnd.mxConstants.VERTEX_SELECTION_COLOR;
		@com.mxgraph.gwt.client.util.mxConstants::VERTEX_SELECTION_STROKEWIDTH = $wnd.mxConstants.VERTEX_SELECTION_STROKEWIDTH;
		@com.mxgraph.gwt.client.util.mxConstants::EDGE_SELECTION_STROKEWIDTH = $wnd.mxConstants.EDGE_SELECTION_STROKEWIDTH;
		@com.mxgraph.gwt.client.util.mxConstants::VERTEX_SELECTION_DASHED = $wnd.mxConstants.VERTEX_SELECTION_DASHED;
		@com.mxgraph.gwt.client.util.mxConstants::EDGE_SELECTION_DASHED = $wnd.mxConstants.EDGE_SELECTION_DASHED;
		@com.mxgraph.gwt.client.util.mxConstants::GUIDE_COLOR = $wnd.mxConstants.GUIDE_COLOR;
		@com.mxgraph.gwt.client.util.mxConstants::GUIDE_STROKEWIDTH = $wnd.mxConstants.GUIDE_STROKEWIDTH;
		@com.mxgraph.gwt.client.util.mxConstants::OUTLINE_COLOR = $wnd.mxConstants.OUTLINE_COLOR;
		@com.mxgraph.gwt.client.util.mxConstants::OUTLINE_STROKEWIDTH = $wnd.mxConstants.OUTLINE_STROKEWIDTH;
		@com.mxgraph.gwt.client.util.mxConstants::HANDLE_SIZE = $wnd.mxConstants.HANDLE_SIZE;
		@com.mxgraph.gwt.client.util.mxConstants::LABEL_HANDLE_SIZE = $wnd.mxConstants.LABEL_HANDLE_SIZE;
		@com.mxgraph.gwt.client.util.mxConstants::HANDLE_FILLCOLOR = $wnd.mxConstants.HANDLE_FILLCOLOR;
		@com.mxgraph.gwt.client.util.mxConstants::HANDLE_STROKECOLOR = $wnd.mxConstants.HANDLE_STROKECOLOR;
		@com.mxgraph.gwt.client.util.mxConstants::LABEL_HANDLE_FILLCOLOR = $wnd.mxConstants.LABEL_HANDLE_FILLCOLOR;
		@com.mxgraph.gwt.client.util.mxConstants::CONNECT_HANDLE_FILLCOLOR = $wnd.mxConstants.CONNECT_HANDLE_FILLCOLOR;
		@com.mxgraph.gwt.client.util.mxConstants::LOCKED_HANDLE_FILLCOLOR = $wnd.mxConstants.LOCKED_HANDLE_FILLCOLOR;
		@com.mxgraph.gwt.client.util.mxConstants::OUTLINE_HANDLE_FILLCOLOR = $wnd.mxConstants.OUTLINE_HANDLE_FILLCOLOR;
		@com.mxgraph.gwt.client.util.mxConstants::OUTLINE_HANDLE_STROKECOLOR = $wnd.mxConstants.OUTLINE_HANDLE_STROKECOLOR;
		@com.mxgraph.gwt.client.util.mxConstants::DEFAULT_FONTFAMILY = $wnd.mxConstants.DEFAULT_FONTFAMILY;
		@com.mxgraph.gwt.client.util.mxConstants::DEFAULT_FONTSIZE = $wnd.mxConstants.DEFAULT_FONTSIZE;
		@com.mxgraph.gwt.client.util.mxConstants::DEFAULT_STARTSIZE = $wnd.mxConstants.DEFAULT_STARTSIZE;
		@com.mxgraph.gwt.client.util.mxConstants::DEFAULT_MARKERSIZE = $wnd.mxConstants.DEFAULT_MARKERSIZE;
		@com.mxgraph.gwt.client.util.mxConstants::DEFAULT_IMAGESIZE = $wnd.mxConstants.DEFAULT_IMAGESIZE;
		@com.mxgraph.gwt.client.util.mxConstants::ENTITY_SEGMENT = $wnd.mxConstants.ENTITY_SEGMENT;
		@com.mxgraph.gwt.client.util.mxConstants::RECTANGLE_ROUNDING_FACTOR = $wnd.mxConstants.RECTANGLE_ROUNDING_FACTOR;
		@com.mxgraph.gwt.client.util.mxConstants::LINE_ARCSIZE = $wnd.mxConstants.LINE_ARCSIZE;
		@com.mxgraph.gwt.client.util.mxConstants::ARROW_SPACING = $wnd.mxConstants.ARROW_SPACING;
		@com.mxgraph.gwt.client.util.mxConstants::ARROW_WIDTH = $wnd.mxConstants.ARROW_WIDTH;
		@com.mxgraph.gwt.client.util.mxConstants::ARROW_SIZE = $wnd.mxConstants.ARROW_SIZE;
		@com.mxgraph.gwt.client.util.mxConstants::PAGE_FORMAT_A4_PORTRAIT = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)($wnd.mxConstants.PAGE_FORMAT_A4_PORTRAIT);
		@com.mxgraph.gwt.client.util.mxConstants::PAGE_FORMAT_A4_LANDSCAPE = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)($wnd.mxConstants.PAGE_FORMAT_A4_LANDSCAPE);
		@com.mxgraph.gwt.client.util.mxConstants::PAGE_FORMAT_LETTER_PORTRAIT = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)($wnd.mxConstants.PAGE_FORMAT_LETTER_PORTRAIT);
		@com.mxgraph.gwt.client.util.mxConstants::PAGE_FORMAT_LETTER_LANDSCAPE = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)($wnd.mxConstants.PAGE_FORMAT_LETTER_LANDSCAPE);
		@com.mxgraph.gwt.client.util.mxConstants::NONE = $wnd.mxConstants.NONE;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_PERIMETER = $wnd.mxConstants.STYLE_PERIMETER;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_SOURCE_PORT = $wnd.mxConstants.STYLE_SOURCE_PORT;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_TARGET_PORT = $wnd.mxConstants.STYLE_TARGET_PORT;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_PORT_CONSTRAINT = $wnd.mxConstants.STYLE_PORT_CONSTRAINT;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_OPACITY = $wnd.mxConstants.STYLE_OPACITY;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_TEXT_OPACITY = $wnd.mxConstants.STYLE_TEXT_OPACITY;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_OVERFLOW = $wnd.mxConstants.STYLE_OVERFLOW;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_ORTHOGONAL = $wnd.mxConstants.STYLE_ORTHOGONAL;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_EXIT_X = $wnd.mxConstants.STYLE_EXIT_X;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_EXIT_ = $wnd.mxConstants.STYLE_EXIT_;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_EXIT_PERIMETER = $wnd.mxConstants.STYLE_EXIT_PERIMETER;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_ENTRY_X = $wnd.mxConstants.STYLE_ENTRY_X;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_ENTRY_Y = $wnd.mxConstants.STYLE_ENTRY_Y;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_ENTRY_PERIMETER = $wnd.mxConstants.STYLE_ENTRY_PERIMETER;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_WHITE_SPACE = $wnd.mxConstants.STYLE_WHITE_SPACE;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_ROTATION = $wnd.mxConstants.STYLE_ROTATION;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_FILLCOLOR = $wnd.mxConstants.STYLE_FILLCOLOR;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_GRADIENTCOLOR = $wnd.mxConstants.STYLE_GRADIENTCOLOR;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_GRADIENT_DIRECTION = $wnd.mxConstants.STYLE_GRADIENT_DIRECTION;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_STROKECOLOR = $wnd.mxConstants.STYLE_STROKECOLOR;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_SEPARATORCOLOR = $wnd.mxConstants.STYLE_SEPARATORCOLOR;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_STROKEWIDTH = $wnd.mxConstants.STYLE_STROKEWIDTH;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_ALIGN = $wnd.mxConstants.STYLE_ALIGN;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_VERTICAL_ALIGN = $wnd.mxConstants.STYLE_VERTICAL_ALIGN;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_LABEL_POSITION = $wnd.mxConstants.STYLE_LABEL_POSITION;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_VERTICAL_LABEL_POSITION = $wnd.mxConstants.STYLE_VERTICAL_LABEL_POSITION;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_IMAGE_ALIGN = $wnd.mxConstants.STYLE_IMAGE_ALIGN;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_IMAGE_VERTICAL_ALIGN = $wnd.mxConstants.STYLE_IMAGE_VERTICAL_ALIGN;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_GLASS = $wnd.mxConstants.STYLE_GLASS;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_IMAGE = $wnd.mxConstants.STYLE_IMAGE;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_IMAGE_WIDTH = $wnd.mxConstants.STYLE_IMAGE_WIDTH;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_IMAGE_HEIGHT = $wnd.mxConstants.STYLE_IMAGE_HEIGHT;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_IMAGE_BACKGROUND = $wnd.mxConstants.STYLE_IMAGE_BACKGROUND;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_IMAGE_BORDER = $wnd.mxConstants.STYLE_IMAGE_BORDER;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_IMAGE_FLIPH = $wnd.mxConstants.STYLE_IMAGE_FLIPH;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_IMAGE_FLIPV = $wnd.mxConstants.STYLE_IMAGE_FLIPV;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_FLIPH = $wnd.mxConstants.STYLE_FLIPH;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_FLIPV = $wnd.mxConstants.STYLE_FLIPV;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_NOLABEL = $wnd.mxConstants.STYLE_NOLABEL;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_NOEDGESTYLE = $wnd.mxConstants.STYLE_NOEDGESTYLE;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_LABEL_BACKGROUNDCOLOR = $wnd.mxConstants.STYLE_LABEL_BACKGROUNDCOLOR;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_LABEL_BORDERCOLOR = $wnd.mxConstants.STYLE_LABEL_BORDERCOLOR;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_INDICATOR_SHAPE = $wnd.mxConstants.STYLE_INDICATOR_SHAPE;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_INDICATOR_IMAGE = $wnd.mxConstants.STYLE_INDICATOR_IMAGE;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_INDICATOR_COLOR = $wnd.mxConstants.STYLE_INDICATOR_COLOR;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_INDICATOR_STROKECOLOR = $wnd.mxConstants.STYLE_INDICATOR_STROKECOLOR;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_INDICATOR_GRADIENTCOLOR = $wnd.mxConstants.STYLE_INDICATOR_GRADIENTCOLOR;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_INDICATOR_SPACING = $wnd.mxConstants.STYLE_INDICATOR_SPACING;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_INDICATOR_WIDTH = $wnd.mxConstants.STYLE_INDICATOR_WIDTH;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_INDICATOR_HEIGHT = $wnd.mxConstants.STYLE_INDICATOR_HEIGHT;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_INDICATOR_DIRECTION = $wnd.mxConstants.STYLE_INDICATOR_DIRECTION;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_SHADOW = $wnd.mxConstants.STYLE_SHADOW;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_SEGMENT = $wnd.mxConstants.STYLE_SEGMENT;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_ENDARROW = $wnd.mxConstants.STYLE_ENDARROW;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_STARTARROW = $wnd.mxConstants.STYLE_STARTARROW;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_ENDSIZE = $wnd.mxConstants.STYLE_ENDSIZE;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_STARTSIZE = $wnd.mxConstants.STYLE_STARTSIZE;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_DASHED = $wnd.mxConstants.STYLE_DASHED;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_ROUNDED = $wnd.mxConstants.STYLE_ROUNDED;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_SMOOTH = $wnd.mxConstants.STYLE_SMOOTH;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_SOURCE_PERIMETER_SPACING = $wnd.mxConstants.STYLE_SOURCE_PERIMETER_SPACING;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_TARGET_PERIMETER_SPACING = $wnd.mxConstants.STYLE_TARGET_PERIMETER_SPACING;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_PERIMETER_SPACING = $wnd.mxConstants.STYLE_PERIMETER_SPACING;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_SPACING = $wnd.mxConstants.STYLE_SPACING;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_SPACING_TOP = $wnd.mxConstants.STYLE_SPACING_TOP;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_SPACING_LEFT = $wnd.mxConstants.STYLE_SPACING_LEFT;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_SPACING_BOTTOM = $wnd.mxConstants.STYLE_SPACING_BOTTOM;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_SPACING_RIGHT = $wnd.mxConstants.STYLE_SPACING_RIGHT;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_HORIZONTAL = $wnd.mxConstants.STYLE_HORIZONTAL;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_DIRECTION = $wnd.mxConstants.STYLE_DIRECTION;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_ELBOW = $wnd.mxConstants.STYLE_ELBOW;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_FONTCOLOR = $wnd.mxConstants.STYLE_FONTCOLOR;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_FONTFAMILY = $wnd.mxConstants.STYLE_FONTFAMILY;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_FONTSIZE = $wnd.mxConstants.STYLE_FONTSIZE;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_FONTSTYLE = $wnd.mxConstants.STYLE_FONTSTYLE;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_AUTOSIZE = $wnd.mxConstants.STYLE_AUTOSIZE;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_FOLDABLE = $wnd.mxConstants.STYLE_FOLDABLE;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_EDITABLE = $wnd.mxConstants.STYLE_EDITABLE;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_BENDABLE = $wnd.mxConstants.STYLE_BENDABLE;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_MOVABLE = $wnd.mxConstants.STYLE_MOVABLE;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_RESIZABLE = $wnd.mxConstants.STYLE_RESIZABLE;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_CLONEABLE = $wnd.mxConstants.STYLE_CLONEABLE;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_DELETABLE = $wnd.mxConstants.STYLE_DELETABLE;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_SHAPE = $wnd.mxConstants.STYLE_SHAPE;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_EDGE = $wnd.mxConstants.STYLE_EDGE;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_LOOP = $wnd.mxConstants.STYLE_LOOP;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_ROUTING_CENTER_X = $wnd.mxConstants.STYLE_ROUTING_CENTER_X;
		@com.mxgraph.gwt.client.util.mxConstants::STYLE_ROUTING_CENTER_Y = $wnd.mxConstants.STYLE_ROUTING_CENTER_Y;
		@com.mxgraph.gwt.client.util.mxConstants::FONT_BOLD = $wnd.mxConstants.FONT_BOLD;
		@com.mxgraph.gwt.client.util.mxConstants::FONT_ITALIC = $wnd.mxConstants.FONT_ITALIC;
		@com.mxgraph.gwt.client.util.mxConstants::FONT_UNDERLINE = $wnd.mxConstants.FONT_UNDERLINE;
		@com.mxgraph.gwt.client.util.mxConstants::FONT_SHADOW = $wnd.mxConstants.FONT_SHADOW;
		@com.mxgraph.gwt.client.util.mxConstants::SHAPE_RECTANGLE = $wnd.mxConstants.SHAPE_RECTANGLE;
		@com.mxgraph.gwt.client.util.mxConstants::SHAPE_ELLIPSE = $wnd.mxConstants.SHAPE_ELLIPSE;
		@com.mxgraph.gwt.client.util.mxConstants::SHAPE_DOUBLE_ELLIPSE = $wnd.mxConstants.SHAPE_DOUBLE_ELLIPSE;
		@com.mxgraph.gwt.client.util.mxConstants::SHAPE_RHOMBUS = $wnd.mxConstants.SHAPE_RHOMBUS;
		@com.mxgraph.gwt.client.util.mxConstants::SHAPE_LINE = $wnd.mxConstants.SHAPE_LINE;
		@com.mxgraph.gwt.client.util.mxConstants::SHAPE_IMAGE = $wnd.mxConstants.SHAPE_IMAGE;
		@com.mxgraph.gwt.client.util.mxConstants::SHAPE_ARROW = $wnd.mxConstants.SHAPE_ARROW;
		@com.mxgraph.gwt.client.util.mxConstants::SHAPE_LABEL = $wnd.mxConstants.SHAPE_LABEL;
		@com.mxgraph.gwt.client.util.mxConstants::SHAPE_CYLINDER = $wnd.mxConstants.SHAPE_CYLINDER;
		@com.mxgraph.gwt.client.util.mxConstants::SHAPE_SWIMLANE = $wnd.mxConstants.SHAPE_SWIMLANE;
		@com.mxgraph.gwt.client.util.mxConstants::SHAPE_CONNECTOR = $wnd.mxConstants.SHAPE_CONNECTOR;
		@com.mxgraph.gwt.client.util.mxConstants::SHAPE_ACTOR = $wnd.mxConstants.SHAPE_ACTOR;
		@com.mxgraph.gwt.client.util.mxConstants::SHAPE_CLOUD = $wnd.mxConstants.SHAPE_CLOUD;
		@com.mxgraph.gwt.client.util.mxConstants::SHAPE_TRIANGLE = $wnd.mxConstants.SHAPE_TRIANGLE;
		@com.mxgraph.gwt.client.util.mxConstants::SHAPE_HEXAGON = $wnd.mxConstants.SHAPE_HEXAGON;
		@com.mxgraph.gwt.client.util.mxConstants::ARROW_CLASSIC = $wnd.mxConstants.ARROW_CLASSIC;
		@com.mxgraph.gwt.client.util.mxConstants::ARROW_BLOCK = $wnd.mxConstants.ARROW_BLOCK;
		@com.mxgraph.gwt.client.util.mxConstants::ARROW_OPEN = $wnd.mxConstants.ARROW_OPEN;
		@com.mxgraph.gwt.client.util.mxConstants::ARROW_OVAL = $wnd.mxConstants.ARROW_OVAL;
		@com.mxgraph.gwt.client.util.mxConstants::ARROW_DIAMOND = $wnd.mxConstants.ARROW_DIAMOND;
		@com.mxgraph.gwt.client.util.mxConstants::ALIGN_LEFT = $wnd.mxConstants.ALIGN_LEFT;
		@com.mxgraph.gwt.client.util.mxConstants::ALIGN_CENTER = $wnd.mxConstants.ALIGN_CENTER;
		@com.mxgraph.gwt.client.util.mxConstants::ALIGN_RIGHT = $wnd.mxConstants.ALIGN_RIGHT;
		@com.mxgraph.gwt.client.util.mxConstants::ALIGN_TOP = $wnd.mxConstants.ALIGN_TOP;
		@com.mxgraph.gwt.client.util.mxConstants::ALIGN_MIDDLE = $wnd.mxConstants.ALIGN_MIDDLE;
		@com.mxgraph.gwt.client.util.mxConstants::ALIGN_BOTTOM = $wnd.mxConstants.ALIGN_BOTTOM;
		@com.mxgraph.gwt.client.util.mxConstants::DIRECTION_NORTH = $wnd.mxConstants.DIRECTION_NORTH;
		@com.mxgraph.gwt.client.util.mxConstants::DIRECTION_SOUTH = $wnd.mxConstants.DIRECTION_SOUTH;
		@com.mxgraph.gwt.client.util.mxConstants::DIRECTION_EAST = $wnd.mxConstants.DIRECTION_EAST;
		@com.mxgraph.gwt.client.util.mxConstants::DIRECTION_WEST = $wnd.mxConstants.DIRECTION_WEST;
		@com.mxgraph.gwt.client.util.mxConstants::DIRECTION_MASK_NONE = $wnd.mxConstants.DIRECTION_MASK_NONE;
		@com.mxgraph.gwt.client.util.mxConstants::DIRECTION_MASK_WEST = $wnd.mxConstants.DIRECTION_MASK_WEST;
		@com.mxgraph.gwt.client.util.mxConstants::DIRECTION_MASK_NORTH = $wnd.mxConstants.DIRECTION_MASK_NORTH;
		@com.mxgraph.gwt.client.util.mxConstants::DIRECTION_MASK_SOUTH = $wnd.mxConstants.DIRECTION_MASK_SOUTH;
		@com.mxgraph.gwt.client.util.mxConstants::DIRECTION_MASK_EAST = $wnd.mxConstants.DIRECTION_MASK_EAST;
		@com.mxgraph.gwt.client.util.mxConstants::DIRECTION_MASK_ALL = $wnd.mxConstants.DIRECTION_MASK_ALL;
		@com.mxgraph.gwt.client.util.mxConstants::ELBOW_VERTICAL = $wnd.mxConstants.ELBOW_VERTICAL;
		@com.mxgraph.gwt.client.util.mxConstants::ELBOW_HORIZONTAL = $wnd.mxConstants.ELBOW_HORIZONTAL;
		@com.mxgraph.gwt.client.util.mxConstants::EDGESTYLE_ELBOW = $wnd.mxConstants.EDGESTYLE_ELBOW;
		@com.mxgraph.gwt.client.util.mxConstants::EDGESTYLE_ENTITY_RELATION = $wnd.mxConstants.EDGESTYLE_ENTITY_RELATION;
		@com.mxgraph.gwt.client.util.mxConstants::EDGESTYLE_LOOP = $wnd.mxConstants.EDGESTYLE_LOOP;
		@com.mxgraph.gwt.client.util.mxConstants::EDGESTYLE_SIDETOSIDE = $wnd.mxConstants.EDGESTYLE_SIDETOSIDE;
		@com.mxgraph.gwt.client.util.mxConstants::EDGESTYLE_TOPTOBOTTOM = $wnd.mxConstants.EDGESTYLE_TOPTOBOTTOM;
		@com.mxgraph.gwt.client.util.mxConstants::EDGESTYLE_ORTHOGONAL = $wnd.mxConstants.EDGESTYLE_ORTHOGONAL;
		@com.mxgraph.gwt.client.util.mxConstants::EDGESTYLE_SEGMENT = $wnd.mxConstants.EDGESTYLE_SEGMENT;
		@com.mxgraph.gwt.client.util.mxConstants::PERIMETER_ELLIPSE = $wnd.mxConstants.PERIMETER_ELLIPSE;
		@com.mxgraph.gwt.client.util.mxConstants::PERIMETER_RECTANGLE = $wnd.mxConstants.PERIMETER_RECTANGLE;
		@com.mxgraph.gwt.client.util.mxConstants::PERIMETER_RHOMBUS = $wnd.mxConstants.PERIMETER_RHOMBUS;
		@com.mxgraph.gwt.client.util.mxConstants::PERIMETER_TRIANGLE = $wnd.mxConstants.PERIMETER_TRIANGLE;

	}-*/;

	public static native void update(String key, String value) /*-{
		$wnd.mxConstants[key] = value;
		@com.mxgraph.gwt.client.util.mxConstants::initialize()();
	}-*/;

	public static native void update(String key, boolean value) /*-{
		$wnd.mxConstants[key] = value;
		@com.mxgraph.gwt.client.util.mxConstants::initialize()();
	}-*/;

	public static native void update(String key, double value) /*-{
		$wnd.mxConstants[key] = value;
		@com.mxgraph.gwt.client.util.mxConstants::initialize()();
	}-*/;

	public static native void update(String key, int value) /*-{
		$wnd.mxConstants[key] = value;
		@com.mxgraph.gwt.client.util.mxConstants::initialize()();
	}-*/;
}

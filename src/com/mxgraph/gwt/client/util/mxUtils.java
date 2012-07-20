package com.mxgraph.gwt.client.util;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.mxgraph.gwt.client.util.mxDragSource.DropHandler;
import com.mxgraph.gwt.client.util.mxDragSource.DropTargetHandler;
import com.mxgraph.gwt.client.view.mxGraph;
import com.mxgraph.gwt.client.view.mxPrintPreview;

public class mxUtils {

	/**
	 * Loads the specified URL *synchronously* and returns the {@link mxXmlRequest}. Throws an exception if the file cannot be loaded. See <mxUtils.get> for an
	 * asynchronous implementation.
	 * 
	 * Example:
	 * 
	 * (code) try { var req = mxUtils.load(filename); var root = req.getDocumentElement(); // Process XML DOM... } catch (ex) { mxUtils.alert('Cannot load
	 * '+filename+': '+ex); } (end)
	 * 
	 * @param url URL to get the data from.
	 * @return mxXmlRequest
	 */
	public native static mxXmlRequest load(String url) /*-{
		var xmlRequestJS = $wnd.mxUtils.load(url);
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(xmlRequestJS);
	}-*/;

	public native static void show(mxGraph graph, Document document, int x0, int y0) /*-{
		var graphJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(graph);
		$wnd.mxUtils.show(graphJS, document, x0, y0);
	}-*/;

	/**
	 * Returns the scale to be used for printing the graph with the given bounds across the specifies number of pages with the given format. The scale is always
	 * computed such that it given the given amount or fewer pages in the print output. See {@link mxPrintPreview} for an example.
	 * 
	 * @param pageCount Specifies the number of pages in the print output.
	 * @param graph {@link mxGraph} that should be printed.
	 * @param pageFormat Optional {@link mxRectangle} that specifies the page format. Default is {@link mxConstants#PAGE_FORMAT_A4_PORTRAIT}.
	 * @param border The border along each side of every page.
	 * @return scale
	 */
	public native static double getScaleForPageCount(int pageCount, mxGraph graph, mxRectangle pageFormat, Integer border) /*-{
		var graphJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(graph);
		var pageFormatJS = pageFormat != null ? @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(pageFormat) : null;
		var borderJS = border != null ? border.@java.lang.Integer::intValue()() : null;
		return $wnd.mxUtils.getScaleForPageCount(pageCount, graphJS, pageFormatJS, borderJS);
	}-*/;

	/**
	 * Parses the specified XML string into a new XML document and returns the new document.
	 * 
	 * Example:
	 * 
	 * (code) var doc = mxUtils.parseXml( '<mxGraphModel><root><MyDiagram id="0"><mxCell/></MyDiagram>'+ '<MyLayer id="1"><mxCell parent="0"
	 * /></MyLayer><MyObject id="2">'+ '<mxCell style="strokeColor=blue;fillColor=red" parent="1" vertex="1">'+ '<mxGeometry x="10" y="10" width="80"
	 * height="30" as="geometry"/>'+ '</mxCell></MyObject></root></mxGraphModel>'); (end)
	 * 
	 * @param xml String that contains the XML data.
	 */
	public native static Document parseXml(String xml) /*-{
		return $wnd.mxUtils.parseXml(xml);
	}-*/;

	/**
	 * Returns a new, empty XML document.
	 * 
	 * @return
	 */
	public native static Document createXmlDocument() /*-{
		return $wnd.mxUtils.createXmlDocument();
	}-*/;

	/**
	 * Returns the XML contentPanel of the specified node. For Internet Explorer, all \r\n\t[\t]* are removed from the XML string and the remaining \r\n are replaced
	 * by \n. All \n are then replaced with linefeed, or &#xa; if no linefeed is defined.
	 * 
	 * @param node DOM node to return the XML for.
	 * @param lineFeed Optional string that linefeeds are converted into. Default is &#xa;
	 * @return
	 */
	public native static String getXml(Node node, String lineFeed) /*-{
		return $wnd.mxUtils.getXml(node, lineFeed);
	}-*/;

	/**
	 * @param element DOM element to make draggable.
	 * @param graph {@link mxGraph} that acts as the drop target or a function that takes a mouse event and returns the current {@link mxGraph}.
	 * @param dropHandler callback interface that will be invoked a successful drop.
	 * @param dragElement Optional DOM node to be used for the drag preview.
	 * @param dx Optional horizontal offset between the cursor and the drag preview.
	 * @param dy Optional vertical offset between the cursor and the drag preview.
	 * @param autoscroll Optional boolean that specifies if autoscroll should be used. Default is mxGraph.autoscroll.
	 * @param scalePreview Optional boolean that specifies if the preview element should be scaled according to the graph scale. If this is true, then the
	 *            offsets will also be scaled. Default is false.
	 * @param highlightDropTargets Optional boolean that specifies if dropTargets should be highlighted. Default is true.
	 * @param getDropTarget Optional function to return the drop target for a given location (x, y). Default is mxGraph.getCellAt.
	 * @return
	 */
	public static native mxDragSource makeDraggable(Element element, mxGraph graph, DropHandler dropHandler, Element dragElement, int dx, int dy, Boolean autoScroll,
			Boolean scalePreview, Boolean highlightDropTargets, DropTargetHandler getDropTarget) /*-{

		var graphJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(graph);
		var dropHandlerJS = @com.mxgraph.gwt.client.util.mxDragSource::wrapCallbackInterface(Lcom/mxgraph/gwt/client/util/mxDragSource$DropHandler;)(dropHandler);
		var autoScrollJS =  autoScroll != null ? autoScroll.@java.lang.Boolean::booleanValue()() : null;
		var scalePreviewJS = scalePreview != null ? scalePreview.@java.lang.Boolean::booleanValue()() : null;
		var highlightDropTargetsJS = highlightDropTargets != null ? highlightDropTargets.@java.lang.Boolean::booleanValue()() : null;
		var getDropTargetJS = getDropTarget != null ? @com.mxgraph.gwt.client.util.mxDragSource::wrapCallbackInterface(Lcom/mxgraph/gwt/client/util/mxDragSource$DropTargetHandler;)(getDropTarget) : null;

		var dragSourceJS = $wnd.mxUtils.makeDraggable(element, graphJS, dropHandlerJS, dragElement, dx, dy, autoScrollJS,
			scalePreviewJS, highlightDropTargetsJS, getDropTargetJS);
				
		return @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(dragSourceJS);		

	}-*/;

}

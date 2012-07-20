package com.mxgraph.gwt.client.view;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Window;
import com.mxgraph.gwt.client.IJavaScriptWrapper;
import com.mxgraph.gwt.client.util.mxRectangle;

/**
 * * Class: mxPrintPreview
 * 
 * Implements printing of a diagram across multiple pages. The following opens a print preview for an existing graph:
 * 
 * (code) var preview = new mxPrintPreview(graph); preview.open(); (end)
 * 
 * Use <mxUtils.getScaleForPageCount> as follows in order to print the graph across a given number of pages:
 * 
 * (code) var pageCount = mxUtils.prompt('Enter page count', '1');
 * 
 * if (pageCount != null) { var scale = mxUtils.getScaleForPageCount(pageCount, graph); var preview = new mxPrintPreview(graph, scale); preview.open(); } (end)
 * 
 * Headers:
 * 
 * Apart from setting the title argument in the mxPrintPreview constructor you can override <renderPage> as follows to add a header to any page:
 * 
 * (code) var oldRenderPage = mxPrintPreview.prototype.renderPage; mxPrintPreview.prototype.renderPage = function(w, h, dx, dy, scale, pageNumber) { var div =
 * oldRenderPage.apply(this, arguments);
 * 
 * var header = document.createElement('div'); header.style.position = 'absolute'; header.style.top = '0px'; header.style.width = '100%'; header.style.textAlign
 * = 'right'; mxUtils.write(header, 'Your header here - Page ' + pageNumber + ' / ' + this.pageCount); div.firstChild.appendChild(header);
 * 
 * return div; }; (end)
 * 
 * Page Format:
 * 
 * For landscape printing, use <mxConstants.PAGE_FORMAT_A4_LANDSCAPE> as the pageFormat in <mxUtils.getScaleForPageCount> and <mxPrintPreview>. Keep in mind
 * that one can not set the defaults for the print dialog of the operating system from JavaScript so the user must manually choose a page format that matches
 * this setting.
 * 
 * You can try passing the following CSS directive to <open> to set the page format in the print dialog to landscape. However, this CSS directive seems to be
 * ignored in most major browsers, including IE.
 * 
 * (code)
 * 
 * @page { size: landscape; } (end)
 * 
 *       Note that the print preview behaves differently in IE when used from the filesystem or via HTTP so printing should always be tested via HTTP.
 * 
 */
public class mxPrintPreview implements IJavaScriptWrapper {

	private JavaScriptObject jso;

	private native JavaScriptObject createJso(JavaScriptObject graph, Double scale, mxRectangle pageFormat, Integer x0, Integer y0, Integer border,
			String borderColor, String title, Boolean pageSelector) /*-{
		var scaleJS = scale != null ? scale.@java.lang.Double::doubleValue()() : null;
		var x0JS = x0 != null ? x0.@java.lang.Integer::intValue()() : null;
		var y0JS = y0 != null ? y0.@java.lang.Integer::intValue()() : null;
		var borderJS = border != null ? border.@java.lang.Integer::intValue()() : null;
		var pageSelectorJS = pageSelector != null ? pageSelector.@java.lang.Boolean::booleanValue()() : null;
		var scaleJS = scale != null ? scale.@java.lang.Double::doubleValue()() : null;
		var pageFormatJS = pageFormat != null ? @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(pageFormat) : null;

		return new $wnd.mxPrintPreview(graph, scaleJS, pageFormatJS, borderJS, x0JS, y0JS, borderColor, title, pageSelectorJS);

	}-*/;

	@Override public JavaScriptObject getJso() {
		return jso;
	}

	@Override public void setJso(JavaScriptObject jso) {
		this.jso = jso;
	}

	/**
	 * Constructs a new print preview for the given parameters.
	 * 
	 * @param graph {@link mxGraph} to be previewed.
	 * @param scale Optional scale of the output. Default is 1 / <mxGraph.pageScale>.
	 * @param pageFormat {@link mxRectangle} that specifies the page format (in pixels). This should match the page format of the printer. Default uses the
	 *            <mxGraph.pageFormat> of the given graph.
	 */
	public mxPrintPreview(mxGraph graph, Double scale, mxRectangle pageFormat) {
		this(graph, scale, pageFormat, null, null, null, null, null, null);
	}

	/**
	 * Constructs a new print preview for the given parameters.
	 * 
	 * @param graph {@link mxGraph} to be previewed.
	 * @param scale Optional scale of the output. Default is 1 / <mxGraph.pageScale>.
	 * @param pageFormat {@link mxRectangle} that specifies the page format (in pixels). This should match the page format of the printer. Default uses the
	 *            <mxGraph.pageFormat> of the given graph.
	 * @param border Border in pixels along each side of every page. Note that the actual print function in the browser will add another border for printing.
	 * @param x0 Optional left offset of the output. Default is 0.
	 * @param y0 Optional top offset of the output. Default is 0.
	 * @param borderColor Optional color of the page border. Default is no border. Note that a border is sometimes useful to highlight the printed page border
	 *            in the print preview of the browser.
	 * @param title Optional string that is used for the window title. Default is 'Printer-friendly version'.
	 * @param pageSelector Optional boolean that specifies if the page selector should appear in the window with the print preview. Default is true.
	 */
	public mxPrintPreview(mxGraph graph, Double scale, mxRectangle pageFormat, Integer border, Integer x0, Integer y0, String borderColor, String title,
			Boolean pageSelector) {
		jso = createJso(graph.getJso(), scale, pageFormat, x0, y0, border, borderColor, title, pageSelector);
	}

	/**
	 * Returns true if the origin should be automatically computed based on the top, left corner of the actual diagram contents. If this is set to false then
	 * the values for <x0> and <y0> will be overridden in <open>. Default is true.
	 * 
	 * @return
	 */
	public native boolean isAutoOrigin() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).autoOrigin;
	}-*/;

	/**
	 * Sets new value for autoOrigin property
	 * 
	 * @param autoOrigin
	 */
	public native void setAutoOrigin(boolean autoOrigin) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).autoOrigin = autoOrigin;
	}-*/;

	/**
	 * Shows the print preview window. The window is created here if it does not exist.
	 * 
	 * @param css Optional CSS string to be used in the new page's head section.
	 * @return
	 */
	public native void open(String css) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).open(css);
	}-*/;
	
	public native String getTitle() /*-{
		return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).title;
	}-*/;
	
	/**
	 * 
	 * @param title
	 */
	public native void setTitle(String title) /*-{
		@com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(this).title = title;
	}-*/;

}

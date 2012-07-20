package com.mxgraph.gwt.client;

import com.google.gwt.dom.client.Node;

/**
 * Bootstrapping mechanism for the mxGraph thin client. The production version of this file contains all code required to run the mxGraph thin client, as well
 * as global constants to identify the browser and operating system in use.
 * 
 * @author jgraph
 * 
 */
public class mxClient {

	/**
	 * Contains the current version of the mxGraph library. The strings that communicate versions of mxGraph use the following format.
	 * 
	 * versionMajor.versionMinor.buildNumber.revisionNumber
	 */
	public static String VERSION;

	/**
	 * True if the current browser is Internet Explorer.
	 */
	public static boolean IS_IE;

	/**
	 * True if the current browser is Internet Explorer 6.x.
	 */
	public static boolean IS_IE6;

	/**
	 * True if the current browser is Netscape (including Firefox).
	 */
	public static boolean IS_NS;

	/**
	 * True if the current browser is Opera.
	 */
	public static boolean IS_OP;

	/**
	 * True if -o-transform is available as a CSS style. This is the case for Opera browsers that use Presto/2.5 and later.
	 */
	public static boolean IS_OT;

	/**
	 * True if the current browser is Safari.
	 */
	public static boolean IS_SF;

	/**
	 * True if the current browser is Google Chrome.
	 */
	public static boolean IS_GC;

	/**
	 * True if -moz-transform is available as a CSS style. This is the case for all Firefox-based browsers newer than or equal 3, such as Camino, Iceweasel,
	 * Seamonkey and Iceape.
	 */
	public static boolean IS_MT;

	/**
	 * True if the browser supports SVG.
	 */
	public static boolean IS_SVG;

	/**
	 * True if foreignObject support is not available. This is the case for Opera and older SVG-based browsers. IE does not require this type of tag.
	 */
	public static boolean IS_NOFO;

	/**
	 * True if the browser supports VML.
	 */
	public static boolean IS_VML;

	/**
	 * True if the client is a Mac.
	 */
	public static boolean IS_MAC;

	/**
	 * True if this client uses a touch interface (no mouse). Currently this detects IPads, IPods and IPhones.
	 */
	public static boolean IS_TOUCH;

	/**
	 * True if the documents location does not start with http:// or https://.
	 */
	public static boolean IS_LOCAL;

	static {
		initialize();
	}

	/**
	 * Performs initialization at class-load time.
	 */
	private static native void initialize() /*-{
		@com.mxgraph.gwt.client.mxClient::VERSION = $wnd.mxClient.VERSION;
		@com.mxgraph.gwt.client.mxClient::IS_IE = $wnd.mxClient.IS_IE;
		@com.mxgraph.gwt.client.mxClient::IS_IE6 = $wnd.mxClient.IS_IE6;
		@com.mxgraph.gwt.client.mxClient::IS_NS = $wnd.mxClient.IS_NS;
		@com.mxgraph.gwt.client.mxClient::IS_OP = $wnd.mxClient.IS_OP;
		@com.mxgraph.gwt.client.mxClient::IS_OT = $wnd.mxClient.IS_OT;
		@com.mxgraph.gwt.client.mxClient::IS_SF = $wnd.mxClient.IS_SF;
		@com.mxgraph.gwt.client.mxClient::IS_GC = $wnd.mxClient.IS_GC;
		@com.mxgraph.gwt.client.mxClient::IS_MT = $wnd.mxClient.IS_MT;
		@com.mxgraph.gwt.client.mxClient::IS_SVG = $wnd.mxClient.IS_SVG;
		@com.mxgraph.gwt.client.mxClient::IS_NOFO = $wnd.mxClient.NO_FO;
		@com.mxgraph.gwt.client.mxClient::IS_VML = $wnd.mxClient.IS_VML;
		@com.mxgraph.gwt.client.mxClient::IS_MAC = $wnd.mxClient.IS_MAC;
		@com.mxgraph.gwt.client.mxClient::IS_TOUCH = $wnd.mxClient.IS_TOUCH;
		@com.mxgraph.gwt.client.mxClient::IS_LOCAL = $wnd.mxClient.IS_LOCAL;
	}-*/;

	/**
	 * Returns true if the current browser is supported, that is, if <mxClient.IS_VML> or <mxClient.IS_SVG> is true.
	 * 
	 * Example:
	 * 
	 * <code> if (!mxClient.isBrowserSupported()) { mxUtils.error('Browser is
	 * not supported!', 200, false); } </code>
	 */
	public static native boolean isBrowserSupported()/*-{
		return $wnd.mxClient.isBrowserSupported();
	}-*/;

	/**
	 * Adds a link node to the head of the document. Use this to add a stylesheet to the page as follows:
	 * 
	 * (code) mxClient.link('stylesheet', filename); (end)
	 * 
	 * where filename is the (relative) URL of the stylesheet. The charset is hardcoded to ISO-8859-1 and the type is text/css.
	 * 
	 * @param rel String that represents the rel attribute of the link node.
	 * @param href String that represents the href attribute of the link node.
	 * @param doc Optional parent document of the link node.
	 */
	public static native void link(String rel, String href, Node doc) /*-{
		$wnd.mxClient.link(rel, href, doc);
	}-*/;

	/**
	 * Frees up memory in IE by resolving cyclic dependencies between the DOM and the JavaScript objects. This is always invoked in IE when the page unloads.
	 */
	public static native void dispose() /*-{
		$wnd.mxClient.dispose(rel, href, doc);
	}-*/;

	/**
	 * Basepath for all URLs in the core without trailing slash. Default is '.'. Set mxBasePath prior to loading the mxClient library as follows to override
	 * this setting:
	 * 
	 * (code) <script type="text/javascript"> mxBasePath = '/path/to/core/directory'; </script> <script type="text/javascript"
	 * src="/path/to/core/directory/js/mxClient.js"></script> (end)
	 * 
	 * When using a relative path, the path is relative to the URL of the page that contains the assignment. Trailing slashes are automatically removed.
	 * 
	 * @return base path
	 */
	public static native String getBasePath() /*-{
		return $wnd.mxClient.basePath;
	}-*/;

	/**
	 * Sets base path to new value
	 * 
	 * @param basePath new value of base path
	 */
	public static native void setBasePath(String basePath) /*-{
		$wnd.mxClient.basePath = basePath;
	}-*/;

	/**
	 * Appends the give path to the base path and returns the new base path.
	 * 
	 * @param path path to be appended
	 * @return base path
	 */
	public static native String appendToBasePath(String path) /*-{
		$wnd.mxClient.basePath += path;
		return $wnd.mxClient.basePath;
	}-*/;

	/**
	 * @return
	 */
	public native String getImageBasePath() /*-{
		return imageBasePath;
	}-*/;

	/**
	 * @param imageBasePath
	 */
	public native void setImageBasePath(String imageBasePath) /*-{
		this.imageBasePath = imageBasePath;
	}-*/;

	/**
	 * Returns  the language of the client, eg. en for english, de for german etc. The special value 'none' will disable all built-in internationalization and
	 * resource loading.
	 * 
	 * Set mxLanguage prior to loading the mxClient library as follows to override this setting:
	 * 
	 * (code) <script type="text/javascript"> mxLanguage = 'en'; </script> <script type="text/javascript" src="js/mxClient.js"></script> (end)
	 * 
	 * If internationalization is disabled, then the following variables should be overridden to reflect the current language of the system. These variables are
	 * cleared when i18n is disabled. <mxEditor.askZoomResource>, <mxEditor.lastSavedResource>, <mxEditor.currentFileResource>, <mxEditor.propertiesResource>,
	 * <mxEditor.tasksResource>, <mxEditor.helpResource>, <mxEditor.outlineResource>, <mxElbowEdgeHandler.doubleClickOrientationResource>,
	 * <mxUtils.errorResource>, <mxUtils.closeResource>, <mxGraphSelectionModel.doneResource>, <mxGraphSelectionModel.updatingSelectionResource>,
	 * <mxGraphView.doneResource>, <mxGraphView.updatingDocumentResource>, <mxCellRenderer.collapseExpandResource>, <mxGraph.containsValidationErrorsResource>
	 * and <mxGraph.alreadyConnectedResource>.
	 * 
	 * @return language
	 */
	public native String getLanguage() /*-{
		return language;
	}-*/;

	/**
	 * Sets the language to new value
	 * @param language new language value
	 */
	public native void setLanguage(String language) /*-{
		this.language = language;
	}-*/;

}

package com.mxgraph.gwt.client.util;

public class mxLog {

	public static String consoleName;
	public static boolean TRACE;
	public static String DEBUG;
	public static String WARN;

	static {
		initialize();
	}

	private static native void initialize() /*-{
		@com.mxgraph.gwt.client.util.mxLog::consoleName = $wnd.mxLog.consoleName;
		@com.mxgraph.gwt.client.util.mxLog::TRACE = $wnd.mxLog.TRACE;
		@com.mxgraph.gwt.client.util.mxLog::DEBUG = $wnd.mxLog.DEBUG;
		@com.mxgraph.gwt.client.util.mxLog::WARN = $wnd.mxLog.WARN;
	}-*/;

	/**
	 * Writes the current navigator information to the console.
	 */
	public static native void info() /*-{
		$wnd.mxLog.info();
	}-*/;

	/**
	 * Returns true if the console is visible.
	 * 
	 * @return
	 */
	public static native boolean isVisible() /*-{
		return $wnd.mxLog.isVisible();
	}-*/;

	/**
	 * Shows the console.
	 */
	public static native void show() /*-{
		$wnd.mxLog.show();
	}-*/;

	/**
	 * Writes the specified string to the console if <TRACE> is true and returns the current time in milliseconds.
	 * 
	 * Example:
	 * 
	 * (code) mxLog.show(); var t0 = mxLog.enter('Hello'); // Do something mxLog.leave('World!', t0); (end)
	 * 
	 * @param string
	 */
	public static native int enter(String string) /*-{
		return $wnd.mxLog.enter(string);
	}-*/;

	/**
	 * Writes the specified string to the console if <TRACE> is true and computes the difference between the current time and t0 in milliseconds. See <enter>
	 * for an example.
	 * 
	 * @param string
	 * @param t0
	 */
	public static native void leave(String string, int t0) /*-{
		return $wnd.mxLog.leave(string, t0);
	}-*/;

	/**
	 * Adds all arguments to the console if <DEBUG> is enabled.
	 * 
	 * (code) mxLog.show(); mxLog.debug('Hello, World!'); (end)
	 * 
	 * @param args
	 */
	public static native void debug(String args) /*-{
		$wnd.mxLog.debug(args);
	}-*/;

	/**
	 * Adds all arguments to the console if <WARN> is enabled.
	 * 
	 * (code) mxLog.show(); mxLog.warn('Hello, World!'); (end)
	 * 
	 * @param args
	 */
	public static native void warn(String args) /*-{
		$wnd.mxLog.warn(args);
	}-*/;

	/**
	 * Adds the specified strings to the console.
	 * 
	 * @param args
	 */
	public static native void write(String args) /*-{
		$wnd.mxLog.write(args);
	}-*/;

	/**
	 * Adds the specified strings to the console, appending a linefeed at the end of each string.
	 * 
	 * @param args
	 */
	public static native void writeln(String args) /*-{
		$wnd.mxLog.writeln(args);
	}-*/;

}

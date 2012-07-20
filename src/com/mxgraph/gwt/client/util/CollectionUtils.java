package com.mxgraph.gwt.client.util;

import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.IJavaScriptWrapper;

/**
 * Utility class containing map conversion methods, map helpers etc.
 * 
 * @author jgraph
 */
public abstract class CollectionUtils {

	/**
	 * Converts a JavaScript map to Java map.
	 * 
	 * @param map JavaScript map to be converted
	 * @return Fully initialized Java map.
	 */
	public static native Map<?, ?> convertMap(JavaScriptObject map) /*-{
		var javaMap = @java.util.HashMap::new()();
		
		for(var key in map) {
			javaMap.@java.util.HashMap::put(Ljava/lang/Object;Ljava/lang/Object;)(key,new String(map[key]));
		}
		
		return javaMap;
	}-*/;

	/**
	 * Converts a Java map to JavaScriptMap.
	 * 
	 * @param map Java map to be converted
	 * @return JavaScript map
	 */
	public static native JavaScriptObject convertMap(Map<?, ?> map) /*-{
		var jsMap = {};
		var iterator = map.@java.util.Map::keySet()().@java.util.Set::iterator()();
		var key = null;

		while (iterator.@java.util.Iterator::hasNext()()) {
			key = iterator.@java.util.Iterator::next()();
			jsMap[key] = map.@java.util.Map::get(Ljava/lang/Object;)(key);
		}

		return jsMap;
	}-*/;

	

	/**
	 * Does this object wrap a JavaScript object?
	 * 
	 * @param object potential wrapper object
	 * @return true if it is wrapper, false otherwise
	 */
	private static boolean isWrapper(Object object) {
		return object instanceof IJavaScriptWrapper;
	}

}

package com.mxgraph.gwt.client.util;

import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.mxgraph.gwt.client.IJavaScriptWrapper;
import com.mxgraph.gwt.client.handler.mxConnectionHandler;
import com.mxgraph.gwt.client.handler.mxConnectionHandler.mxIFactoryMethod;
import com.mxgraph.gwt.client.handler.mxGraphHandler;
import com.mxgraph.gwt.client.handler.mxTooltipHandler;
import com.mxgraph.gwt.client.model.mxCell;
import com.mxgraph.gwt.client.model.mxGeometry;
import com.mxgraph.gwt.client.model.mxGraphModel;
import com.mxgraph.gwt.client.model.mxGraphModel.mxCellAttributeChange;
import com.mxgraph.gwt.client.model.mxGraphModel.mxChildChange;
import com.mxgraph.gwt.client.model.mxGraphModel.mxCollapseChange;
import com.mxgraph.gwt.client.model.mxGraphModel.mxGeometryChange;
import com.mxgraph.gwt.client.model.mxGraphModel.mxRootChange;
import com.mxgraph.gwt.client.model.mxGraphModel.mxStyleChange;
import com.mxgraph.gwt.client.model.mxGraphModel.mxTerminalChange;
import com.mxgraph.gwt.client.model.mxGraphModel.mxValueChange;
import com.mxgraph.gwt.client.model.mxGraphModel.mxVisibleChange;
import com.mxgraph.gwt.client.model.mxPoint;
import com.mxgraph.gwt.client.shape.mxPolyline;
import com.mxgraph.gwt.client.shape.mxRectangleShape;
import com.mxgraph.gwt.client.util.mxDragSource.DropHandler;
import com.mxgraph.gwt.client.util.mxDragSource.DropTargetHandler;
import com.mxgraph.gwt.client.util.mxDragSource.GuidesEnabledHandler;
import com.mxgraph.gwt.client.util.mxEventSource.mxIEventListener;
import com.mxgraph.gwt.client.view.mxCellEditor;
import com.mxgraph.gwt.client.view.mxCellRenderer;
import com.mxgraph.gwt.client.view.mxCellState;
import com.mxgraph.gwt.client.view.mxConnectionConstraint;
import com.mxgraph.gwt.client.view.mxGraph;
import com.mxgraph.gwt.client.view.mxGraphSelectionModel;
import com.mxgraph.gwt.client.view.mxGraphView;
import com.mxgraph.gwt.client.view.mxStylesheet;

/**
 * Class with various methods that involve wrapping and unwrapping of JavaScript objects
 * 
 */
public class WrapperUtils {

	/**
	 * Performs wrapping on given JavaScriptObject. Wrapper is chosen and instantiated based on the constructor of the passed object. For passed null returns
	 * null. For unknown objects it will raise a runtime exception.
	 * 
	 * @param jso object that will be wrapped
	 * @return initialized wrapper
	 */
	public static IJavaScriptWrapper wrap(JavaScriptObject jso) {

		if (jso == null) {
			return null;
		}

		String className = getJavaScriptClassName(jso);

		IJavaScriptWrapper wrapper = createWrapper(className);

		if (wrapper == null) {
			throw new RuntimeException("Unsupported class : " + className);
		}

		wrapper.setJso(jso);

		return wrapper;
	}

	private static IJavaScriptWrapper createWrapper(String className) {
		IJavaScriptWrapper wrapper = null;

		// GWT compiler cannot dynamically create the class with GWT.create(classLiteral) method. Hence the if-else.
		if (className.equals(getSimpleName(mxCell.class))) {
			wrapper = GWT.create(mxCell.class);
		} else if (className.equals(getSimpleName(mxPoint.class))) {
			wrapper = GWT.create(mxPoint.class);
		} else if (className.equals(getSimpleName(mxConnectionConstraint.class))) {
			wrapper = GWT.create(mxConnectionConstraint.class);
		} else if (className.equals(getSimpleName(mxGraphModel.class))) {
			wrapper = GWT.create(mxGraphModel.class);
		} else if (className.equals(getSimpleName(mxGraph.class))) {
			wrapper = GWT.create(mxGraph.class);
		} else if (className.equals(getSimpleName(mxGeometry.class))) {
			wrapper = GWT.create(mxGeometry.class);
		} else if (className.equals(getSimpleName(mxXmlRequest.class))) {
			wrapper = GWT.create(mxXmlRequest.class);
		} else if (className.equals(getSimpleName(mxStylesheet.class))) {
			wrapper = GWT.create(mxStylesheet.class);
		} else if (className.equals(getSimpleName(mxGraphHandler.class))) {
			wrapper = GWT.create(mxGraphHandler.class);
		} else if (className.equals(getSimpleName(mxGraphView.class))) {
			wrapper = GWT.create(mxGraphView.class);
		} else if (className.equals(getSimpleName(mxImage.class))) {
			wrapper = GWT.create(mxImage.class);
		} else if (className.equals(getSimpleName(mxConnectionHandler.class))) {
			wrapper = GWT.create(mxConnectionHandler.class);
		} else if (className.equals(getSimpleName(mxCellRenderer.class))) {
			wrapper = GWT.create(mxCellRenderer.class);
		} else if (className.equals(getSimpleName(mxGraphSelectionModel.class))) {
			wrapper = GWT.create(mxGraphSelectionModel.class);
		} else if (className.equals(getSimpleName(mxCellState.class))) {
			wrapper = GWT.create(mxCellState.class);
		} else if (className.equals(getSimpleName(mxEventObject.class))) {
			wrapper = GWT.create(mxEventObject.class);
		} else if (className.equals(getSimpleName(mxUndoableEdit.class))) {
			wrapper = GWT.create(mxUndoableEdit.class);
		} else if (className.equals(getSimpleName(mxUndoManager.class))) {
			wrapper = GWT.create(mxUndoManager.class);
		} else if (className.equals(getSimpleName(mxRootChange.class))) {
			wrapper = GWT.create(mxRootChange.class);
		} else if (className.equals(getSimpleName(mxChildChange.class))) {
			wrapper = GWT.create(mxChildChange.class);
		} else if (className.equals(getSimpleName(mxTerminalChange.class))) {
			wrapper = GWT.create(mxTerminalChange.class);
		} else if (className.equals(getSimpleName(mxValueChange.class))) {
			wrapper = GWT.create(mxValueChange.class);
		} else if (className.equals(getSimpleName(mxStyleChange.class))) {
			wrapper = GWT.create(mxStyleChange.class);
		} else if (className.equals(getSimpleName(mxGeometryChange.class))) {
			wrapper = GWT.create(mxGeometryChange.class);
		} else if (className.equals(getSimpleName(mxCollapseChange.class))) {
			wrapper = GWT.create(mxCollapseChange.class);
		} else if (className.equals(getSimpleName(mxVisibleChange.class))) {
			wrapper = GWT.create(mxVisibleChange.class);
		} else if (className.equals(getSimpleName(mxCellAttributeChange.class))) {
			wrapper = GWT.create(mxCellAttributeChange.class);
		} else if (className.equals(getSimpleName(mxRectangle.class))) {
			wrapper = GWT.create(mxRectangle.class);
		} else if (className.equals(getSimpleName(mxDragSource.class))) {
			wrapper = GWT.create(mxDragSource.class);
		} else if (className.equals(getSimpleName(mxMouseEvent.class))) {
			wrapper = GWT.create(mxMouseEvent.class);
		} else if (className.equals(getSimpleName(mxMorphing.class))) {
			wrapper = GWT.create(mxMorphing.class);
		} else if (className.equals(getSimpleName(mxPopupMenu.class))) {
			wrapper = GWT.create(mxPopupMenu.class);
		} else if (className.equals(getSimpleName(mxRectangleShape.class))) {
			wrapper = GWT.create(mxRectangleShape.class);
		} else if (className.equals(getSimpleName(mxPanningHandler.class))) {
			wrapper = GWT.create(mxPanningHandler.class);
		} else if (className.equals(getSimpleName(mxTooltipHandler.class))) {
			wrapper = GWT.create(mxTooltipHandler.class);
		} else if (className.equals(getSimpleName(mxPanningManager.class))) {
			wrapper = GWT.create(mxPanningManager.class);
		} else if (className.equals(getSimpleName(mxCellEditor.class))) {
			wrapper = GWT.create(mxCellEditor.class);
		} else if (className.equals(getSimpleName(mxPolyline.class))) {
			wrapper = GWT.create(mxPolyline.class);
		}

		return wrapper;
	}

	private static native String getJavaScriptClassName(JavaScriptObject jso) /*-{
		return jso.constructor.name ? jso.constructor.name : jso.constructor.toString().match(/function ([a-zA-z0-9]*)/)[1];
	}-*/;

	/**
	 * Does the same thing as {@link Class#getSimpleName()} which isn't currently supported by GWT.
	 * 
	 * @param klass class for which to return the name
	 * @return name of the class stripped of it's package name
	 */
	public static String getSimpleName(Class<?> klass) {
		String simpleName = klass.getName().substring(klass.getName().lastIndexOf(".") + 1);
		simpleName = simpleName.contains("$") ? simpleName.substring(simpleName.lastIndexOf('$') + 1) : simpleName;
		return simpleName;
	}

	/**
	 * Wraps JavaScript list into Java list. Also wraps the objects inside the list.
	 * 
	 * @param list JavaScript list for conversion
	 * @return new instance of Java list
	 */
	public static native <C extends IJavaScriptWrapper> List<C> wrapList(JavaScriptObject list) /*-{

		var javaList = null;

		if (list != null) {
			javaList = @java.util.ArrayList::new(I)(list.length);

			for ( var i = 0; i < list.length; i++) {
				//create an instance of wrapper
				var instance = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(list[i]);
				//and add it to the list
				javaList.@java.util.ArrayList::add(Ljava/lang/Object;)(instance);
			}
		}

		return javaList;
	}-*/;

	/**
	 * Converts Java list into JavaScript list and unwraps the objects contained in it by exposing the underlying JavaScriptObjectS.
	 * 
	 * @param list list for conversion
	 * @return JavaScript list
	 */
	public static native JavaScriptObject unwrapList(List<? extends IJavaScriptWrapper> list) /*-{
		var jsList = null;

		if (list != null) {
			jsList = [];
			var iterator = list.@java.util.List::iterator()();

			for ( var i = 0; i < list.@java.util.List::size()(); i++) {
				var elem = list.@java.util.List::get(I)(i);
				jsList[i] = elem.@com.mxgraph.gwt.client.IJavaScriptWrapper::getJso()();
			}
		}

		return jsList;
	}-*/;

	/**
	 * Converts a Java map into a JavaScript map. Also unwraps the objects inside.
	 * 
	 * @param map
	 * @return
	 */
	public static native <K extends Object, V extends IJavaScriptWrapper> JavaScriptObject unwrapMap(Map<K, V> map) /*-{

		if (map == null) {
			return null;
		}

		var mapJS = {}, key = null, jso = null;
		var keySetIterator = map.@java.util.Map::keySet()().@java.util.Set::iterator()();

		while (keySetIterator.@java.util.Iterator::hasNext()()) {
			key = keySetIterator.@java.util.Iterator::next()();
			//this gets the wrapping object and then the wrapped object from it
			jso = map.@java.util.Map::get(Ljava/lang/Object;)(key).@com.mxgraph.gwt.client.IJavaScriptWrapper::getJso()();
			mapJS[key] = jso;
		}

		return mapJS;

	}-*/;

	public static JavaScriptObject unwrap(IJavaScriptWrapper wrapper) {
		if (wrapper == null) {
			return null;
		} else {
			return wrapper.getJso();
		}
	}

	/**
	 * Converts a JavaScript map into a Java map. Also wraps the objects inside.
	 * 
	 * @param map JavaScript map for conversion
	 * @return Java map containing wrapper objects or null if passed object is not a JavaScript map
	 */
	public static native <K extends Object, V extends IJavaScriptWrapper> Map<K, V> wrapMap(JavaScriptObject map) /*-{
		var mapJ = @java.util.HashMap::new()();

		if (typeof map != typeof {}) {
			return null;
		}

		for ( var key in map) {
			//workaround for issue 4486 http://code.google.com/p/google-web-toolkit/issues/detail?id=4486
			if (key == "__gwt_ObjectId") {
				continue;
			}
			//create an instance of wrapper
			var instanceJ = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(map[key]);
			//add it to the map
			mapJ.@java.util.Map::put(Ljava/lang/Object;Ljava/lang/Object;)(key, instanceJ);
		}

		return mapJ;

	}-*/;

	/**
	 * Creates a JavaScript function that is used in event handling. It wraps the event and sender objects and invokes the
	 * {@link mxIEventListener#invoke(Object, mxEventObject)} on the passed listener.
	 * 
	 * @param listener listener that will get invoked by the JavaScript function
	 * @return JavaScript function that will invoke the listener
	 */
	public static native JavaScriptObject wrapCallbackInterface(mxIEventListener<?> listener) /*-{
		var callbackFunction = function(sender, eventObject) {
			//wraps event object
			var eventObjectJ = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(eventObject)
			//wraps the sender object
			var senderJ = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(sender);
			//Calls mxIEventListener.invoke with wrapped event object
			listener.@com.mxgraph.gwt.client.util.mxEventSource.mxIEventListener::invoke(Ljava/lang/Object;Lcom/mxgraph/gwt/client/util/mxEventObject;)(senderJ,eventObjectJ);
		};

		return callbackFunction;
	}-*/;

	/**
	 * Wraps a {@link mxIFactoryMethod#invoke(mxCell, mxCell, String)} into a JavaScript function to be used as a callback
	 * 
	 * @param factoryMethod
	 * @return JavaScript function
	 */
	public static native JavaScriptObject wrapCallbackInterface(mxIFactoryMethod factoryMethod) /*-{
		var factoryMethod = function(source, target, style) {
			var sourceJ = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
			var targetJ = @com.mxgraph.gwt.client.util.WrapperUtils::wrap(Lcom/google/gwt/core/client/JavaScriptObject;)(target);
			var cellJ = factoryMethod.@com.mxgraph.gwt.client.handler.mxConnectionHandler.mxIFactoryMethod::invoke(Lcom/mxgraph/gwt/client/model/mxCell;Lcom/mxgraph/gwt/client/model/mxCell;Ljava/lang/String;)
				(sourceJ, targetJ, style);
			return @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(cellJ);
				
		};
		
		return factoryMethod;
	}-*/;

	
}

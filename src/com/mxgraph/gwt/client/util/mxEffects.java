package com.mxgraph.gwt.client.util;

import java.util.List;

import com.mxgraph.gwt.client.model.mxGraphModel.mxChange;
import com.mxgraph.gwt.client.view.mxGraph;

/**
 * Provides animation effects.
 * 
 */
public class mxEffects {

	public interface DoneCallback {
		void invoke();
	}

	/**
	 * Asynchronous animated move operation. See also: {@link mxMorphing}.
	 * 
	 * @param graph {@link mxGraph} that received the changes.
	 * @param changes List of changes to be animated.
	 * @param done Optional callback that is invoked after the last step of the animation.
	 */
	public static native void animateChanges(mxGraph graph, List<mxChange> changes, DoneCallback done) /*-{

		var doneJS = null;
		if (done != null) {
			doneJS = function() {
				done.@com.mxgraph.gwt.client.util.mxEffects.DoneCallback::invoke();
			};
		}

		var graphJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrap(Lcom/mxgraph/gwt/client/IJavaScriptWrapper;)(graph);
		var changesJS = @com.mxgraph.gwt.client.util.WrapperUtils::unwrapList(Ljava/util/List;)(changes);
		$wnd.mxEffects.animateChanges(graphJS, changesJS, doneJS);

	}-*/;
}

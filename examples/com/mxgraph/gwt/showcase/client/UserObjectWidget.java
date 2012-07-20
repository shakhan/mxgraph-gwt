package com.mxgraph.gwt.showcase.client;


import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.mxgraph.gwt.client.handler.mxKeyHandler;
import com.mxgraph.gwt.client.handler.mxRubberband;
import com.mxgraph.gwt.client.model.mxCell;
import com.mxgraph.gwt.client.model.mxGraphModel;
import com.mxgraph.gwt.client.model.mxICell;
import com.mxgraph.gwt.client.util.mxEvent;
import com.mxgraph.gwt.client.util.mxEvent.EventHandler;
import com.mxgraph.gwt.client.util.mxEventObject;
import com.mxgraph.gwt.client.util.mxEventSource.mxIEventListener;
import com.mxgraph.gwt.client.util.mxRectangle;
import com.mxgraph.gwt.client.util.mxUtils;
import com.mxgraph.gwt.client.view.mxGraph;
import com.mxgraph.gwt.client.view.mxGraph.IsCellEditableCallback;
import com.mxgraph.gwt.client.view.mxGraph.CellLabelChangedCallback;
import com.mxgraph.gwt.client.view.mxGraph.ConvertValueToStringCallback;
import com.mxgraph.gwt.client.view.mxGraph.GetEditingValueCallback;
import com.mxgraph.gwt.client.view.mxGraph.GetTooltipForCellCallback;

public class UserObjectWidget extends AbstractContentWidget {

	public UserObjectWidget(String name, Showcase showcase) {
		super(name, showcase);
		description = "Shows how to use complex objects as cell values. In this case an XML is used. Try editing their values using cell editor and text fields.";
	}

	@Override public void injectContent(SimplePanel panel) {
		final mxGraph graph = new mxGraph();
		HorizontalPanel vp = new HorizontalPanel();
		final FlowPanel fp = new FlowPanel();
		vp.add(graph);
		vp.add(fp);
		panel.setWidget(vp);

		Document doc = mxUtils.createXmlDocument();

		Element person1 = doc.createElement("Person");
		person1.setAttribute("firstName", "Daffy");
		person1.setAttribute("lastName", "Duck");

		Element person2 = doc.createElement("Person");
		person2.setAttribute("firstName", "Bugs");
		person2.setAttribute("lastName", "Bunny");

		Element relation = doc.createElement("Knows");
		relation.setAttribute("since", "1985");

		graph.setCellsResizable(false);
		graph.getElement().getStyle().setBackgroundImage("url('images/grid.gif')");
		graph.setResizeContainer(true);
		graph.setMinimumContainerSize(new mxRectangle(0, 0, 500, 380));
		graph.setBorder(60);
		graph.setTooltips(true);
		graph.setCellsCloneable(false);//disables cloning cells when doing Ctrl + Drag
		graph.getElement().getStyle().setBorderWidth(1, Unit.PX);
		graph.getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
		graph.getElement().getStyle().setBorderColor("#E5E5E5");

		new mxKeyHandler(graph, null);

		graph.setIsCellEditableCallback(new IsCellEditableCallback() {
			@Override public boolean invoke(mxICell cell, IsCellEditableCallback old) {
				return !graph.getModel().isEdge(cell);
			}
		});

		graph.setConvertValueToStringCallback(new ConvertValueToStringCallback() {
			@Override public String invoke(mxICell cell, ConvertValueToStringCallback old) {
				if (cell.getValue() instanceof Element) {
					Element el = (Element) cell.getValue();

					if (el.getNodeName().toLowerCase().equals("person")) {
						String firstName = cell.getAttribute("firstName", "");
						String lastName = cell.getAttribute("lastName", "");

						if (lastName != null && lastName.length() > 0) {
							return lastName + ", " + firstName;
						}

						return firstName;
					} else if (el.getNodeName().toLowerCase().equals("knows")) {
						return el.getNodeName() + " (Since " + cell.getAttribute("since", "") + ")";
					}

				}

				return "";
			}
		});

		graph.setCellLabelChangedCallback(new CellLabelChangedCallback() {
			@Override public void invoke(mxICell cell, Object newValue, boolean autoSize, CellLabelChangedCallback old) {
				if ((cell.getValue() instanceof Element) && ((Element) cell.getValue()).getNodeName().toLowerCase().equals("person")) {
					String val = (String)newValue;
					int pos = val.indexOf(" ");

					String firstName = (pos > 0) ? val.substring(0, pos) : val;
					String lastName = (pos > 0) ? val.substring(pos + 1, val.length()) : "";

					// Clones the value for correct undo/redo
					Element elt = (Element) ((Element) cell.getValue()).cloneNode(true);

					elt.setAttribute("firstName", firstName);
					elt.setAttribute("lastName", lastName);

					autoSize = true;

					old.invoke(cell, elt, autoSize, null);
				}
			}
		});

		graph.setGetEditingValueCallback(new GetEditingValueCallback() {
			@Override public Object invoke(mxICell cell,NativeEvent evt, GetEditingValueCallback old) {
				if ((cell.getValue() instanceof Element) && ((Element) cell.getValue()).getNodeName().toLowerCase().equals("person")) {
					String firstName = cell.getAttribute("firstName", "");
					String lastName = cell.getAttribute("lastName", "");

					return firstName + " " + lastName;
				}

				return old.invoke(cell,evt, null);
			}
		});

		graph.setGetTooltipForCellCallback(new GetTooltipForCellCallback() {
			@Override public String invoke(mxICell cell, GetTooltipForCellCallback old) {
				// Adds some relation details for edges
				if (graph.getModel().isEdge(cell)) {
					String src = graph.getLabel(graph.getModel().getTerminal(cell, true));
					String trg = graph.getLabel(graph.getModel().getTerminal(cell, false));

					return src + " " + ((Element) cell.getValue()).getNodeName() + " " + trg;
				}

				return old.invoke(cell, null);
			}
		});

		new mxRubberband(graph);

		mxICell parent = graph.getDefaultParent();

		// Adds cells to the model in a single step
		graph.getModel().beginUpdate();
		try {
			mxICell v1 = graph.insertVertex((mxCell) parent, null, person1, 40, 40, 80, 20);
			mxICell v2 = graph.insertVertex((mxCell) parent, null, person2, 200, 150, 80, 20);
			mxICell e1 = graph.insertEdge(parent, null, relation, v1, v2);
		} finally {
			// Updates the display
			graph.getModel().endUpdate();
		}
		
		graph.getSelectionModel().addListener(mxEvent.CHANGE, new mxIEventListener<Object>() {
			@Override public void invoke(Object sender, mxEventObject evt) {
				mxICell cell = graph.getSelectionCell();
				
				fp.clear();
				if(cell == null) {
					return;
				}
				
				if(graph.getModel().isVertex(cell)) {
					addText(graph, cell, fp, "firstName", "First Name : ");
					addText(graph, cell, fp, "lastName", "Last Name : ");
				} else {
					addText(graph, cell, fp, "since", "Knows : ");
				}
			}
		});

	}
	
	private void addText(final mxGraph graph, final mxICell cell, FlowPanel fp, final String attribute,final String label) {
		Element value = (Element)cell.getValue();
		
		final TextBox tb = new TextBox();
		tb.getElement().getStyle().setPadding(2, Unit.PX);
		tb.getElement().getStyle().setProperty("borderRadius", "5px");
		tb.setText(value.getAttribute(attribute));
		Label lbl = new Label(label);
		lbl.getElement().getStyle().setPaddingLeft(5, Unit.PX);
		fp.add(lbl);
		fp.add(tb);
		
		mxEvent.addListener(tb.getElement(), "blur", new EventHandler() {
			
			@Override public void handleEvent(NativeEvent event) {
				updateValue(graph, cell, attribute, tb.getText());
				graph.updateCellSize(cell, true);
			}
		});
	}
	
	private static void updateValue(mxGraph graph,mxICell cell, String attribute, String value) {
		graph.getModel().beginUpdate();
		try {
			graph.getModel().execute(new mxGraphModel.mxCellAttributeChange(cell, attribute, value));
		} finally {
			graph.getModel().endUpdate();
		}
	}

}

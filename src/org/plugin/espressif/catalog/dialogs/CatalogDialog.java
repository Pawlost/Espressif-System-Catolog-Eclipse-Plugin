package org.plugin.espressif.catalog.dialogs;

import java.util.ArrayList;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.plugin.espressif.catalog.Item;
import org.plugin.espressif.catalog.ItemType;
import org.plugin.espressif.catalog.JSONFileManager;

import java.util.List;

public class CatalogDialog extends Dialog {
	
	private List<Item> items;
	
	private Label label;

	public CatalogDialog(Shell parentShell) {
		super(parentShell);
		items = new ArrayList<Item>();
		items.add(new Item("gdsadg", ItemType.DevKit, "gfdsagds"));
			}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(3, false));
		container.setLayoutData(new GridData(500, 300));
				
		label = new Label(container, SWT.LEFT);
		label.setText("Search by name: ");
		
		Text text = new Text(container, SWT.SINGLE);
		
		Button button = new Button(container, SWT.PUSH);
		button.setText("Go");
		
	    button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Pressed");
			}
		});
		
		GridData data = new GridData();
		data.horizontalSpan = 4;
		
		Composite composit = new Composite(container, SWT.NONE);
		GridLayout layout = new GridLayout();
		composit.setLayout(layout);
		composit.setLayoutData(data);
		
	    TableViewer viewer = new TableViewer(composit, SWT.MULTI | SWT.H_SCROLL
	            | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);

	    createColumns(viewer);
	    
        final Table table = viewer.getTable();
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

		viewer.setContentProvider(new ArrayContentProvider());
	    viewer.setInput(items);	    

		return container;
	}

	// overriding this methods allows you to set the
	// title of the custom dialog
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Selection dialog");
	} 
	
	private void createColumns(TableViewer viewer) {
	    TableViewerColumn colName = new TableViewerColumn(viewer, SWT.NONE);
	    colName.getColumn().setWidth(100);
	    colName.getColumn().setText("Name:");
	    colName.setLabelProvider(new ColumnLabelProvider() {
	        @Override
	        public String getText(Object element) {
	            Item i = (Item) element;
	            return i.getName();
	        }
	    });
	    
	    TableViewerColumn colType = new TableViewerColumn(viewer, SWT.NONE);
	    colType.getColumn().setWidth(50);
	    colType.getColumn().setText("Type");
	    colType.setLabelProvider(new ColumnLabelProvider() {
	        @Override
	        public String getText(Object element) {
	            Item i = (Item) element;
	            return i.getType().getName();
	        }
	    });
	    
	    TableViewerColumn colDescription = new TableViewerColumn(viewer, SWT.NONE);
	    colDescription.getColumn().setWidth(300);
	    colDescription.getColumn().setText("Name");
	    colDescription.setLabelProvider(new ColumnLabelProvider() {
	        @Override
	        public String getText(Object element) {
	            Item i = (Item) element;
	            return i.getDescription();
	        }
	    });
	}
	
	
	@Override
	protected Control createButtonBar(Composite parent)
	{
	    /* You don't want a button bar, so just return null */
	    return null;
	}
}
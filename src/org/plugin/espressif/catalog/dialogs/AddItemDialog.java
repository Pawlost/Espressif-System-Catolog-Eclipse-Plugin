package org.plugin.espressif.catalog.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class AddItemDialog extends Dialog {

	private Text name;
	private Text description;
	
	public AddItemDialog(Shell parentShell) {
		super(parentShell);
		setShellStyle(getShellStyle());
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(2, false));
		container.setLayoutData(new GridData(300, 300));

		Label nameLabel = new Label(container, SWT.RIGHT);
		nameLabel.setText("Name:");
		
		
		name = new Text(container, SWT.SINGLE);
		name.setLayoutData(new GridData(125, 25));
		
		Label typeLabel = new Label(container, SWT.RIGHT);
		typeLabel.setText("Type:");
		
		Combo combo = new Combo(container, SWT.READ_ONLY | SWT.BORDER);
		combo.setItems(new String[]{"Kokot", "Curak"});
		combo.select(0);
		
		Label descriptionLabel = new Label(container, SWT.RIGHT);
		descriptionLabel.setText("Description:");
		
		description = new Text(container, SWT.MULTI);
		description.setLayoutData(new GridData(150, 150));
				
		Button button = new Button(container, SWT.PUSH);
		GridData data = new GridData(100, 25);
		data.horizontalSpan = 2;
		data.verticalAlignment = SWT.CENTER;
		data.horizontalAlignment = SWT.CENTER;
		button.setLayoutData(data);
		button.setText("Submit");
		
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Pressed");
			}
		});
		

		return container;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Add Espressif Item");
	}
	
	@Override
	protected Control createButtonBar(Composite parent)
	{
	    /* You don't want a button bar, so just return null */
	    return null;
	}
}
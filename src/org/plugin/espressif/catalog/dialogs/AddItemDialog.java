package org.plugin.espressif.catalog.dialogs;

import java.io.IOException;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
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
import org.json.simple.parser.ParseException;
import org.plugin.espressif.catalog.Item;
import org.plugin.espressif.catalog.ItemType;
import org.plugin.espressif.catalog.JSONFileManager;

public class AddItemDialog extends Dialog {

    private Text name;
    private Combo type;
    private Text description;
    private JSONFileManager manager;

    public AddItemDialog(Shell parentShell) throws IOException, ParseException {
        super(parentShell);
        setShellStyle(getShellStyle());
        manager = new JSONFileManager();
    }

    @Override
    protected Control createDialogArea(Composite parent) {

        Composite container = (Composite) super.createDialogArea(parent);

        createDialog(container);

        container.addDisposeListener(
                new DisposeListener() {
                    @Override
                    public void widgetDisposed(DisposeEvent e) {
                        try {
                            manager.save();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
        });


        return container;
    }

    private void createDialog(Composite container) {
        container.setLayout(new GridLayout(2, false));
        container.setLayoutData(new GridData(300, 300));

        Label nameLabel = new Label(container, SWT.RIGHT);
        nameLabel.setText("Name:");

        name = new Text(container, SWT.SINGLE);
        name.setLayoutData(new GridData(125, 25));
        name.setTextLimit(100);

        Label typeLabel = new Label(container, SWT.RIGHT);
        typeLabel.setText("Type:");

        type = new Combo(container, SWT.READ_ONLY | SWT.BORDER);

        String[] itemNames = new String[ItemType.values().length];

        for (int i = 0; i < itemNames.length; i++) {
            itemNames[i] = ItemType.values()[i].name();
        }     

        type.setItems(itemNames);

        type.select(0);
        Label descriptionLabel = new Label(container, SWT.RIGHT);
        descriptionLabel.setText("Description:");

        description = new Text(container, SWT.MULTI);
        description.setLayoutData(new GridData(150, 150));
        description.setTextLimit(300);

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
                Item item = new Item(name.getText(), ItemType.valueOf(type.getText()), description.getText());
                name.setText("");
                description.setText("");
                type.select(0);
                manager.addItem(item);
                MessageDialog.openConfirm(getShell(), "Item Added", "Item succesfuly added");
            }
        });
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText("Add Espressif Item");
    }

    @Override
    protected Control createButtonBar(Composite parent) {
        return null;
    }
}
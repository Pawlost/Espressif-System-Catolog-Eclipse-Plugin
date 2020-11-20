package org.plugin.espressif.catalog.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.plugin.espressif.catalog.dialogs.AddItemDialog;

public class AddItemHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		AddItemDialog itemDialog = new AddItemDialog(window.getShell());
		itemDialog.open();
		return null;
	}
}

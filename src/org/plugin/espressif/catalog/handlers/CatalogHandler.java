package org.plugin.espressif.catalog.handlers;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.json.simple.parser.ParseException;
import org.plugin.espressif.catalog.JSONFileManager;
import org.plugin.espressif.catalog.dialogs.CatalogDialog;

public class CatalogHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        try {
            Shell shell = HandlerUtil.getActiveWorkbenchWindowChecked(event).getShell();
            CatalogDialog catalogDialog = new CatalogDialog(shell);
            catalogDialog.open();
        } catch (IOException | ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}

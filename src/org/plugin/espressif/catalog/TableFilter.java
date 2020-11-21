package org.plugin.espressif.catalog;

import java.util.regex.Pattern;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Text;

public class TableFilter extends ViewerFilter {

    private Text searchText;

    public TableFilter(Text searchText) {
        this.searchText = searchText;
    }

    @Override
    public boolean select(Viewer viewer, Object parentElement, Object element) {
        if (Pattern.matches(".*" + Pattern.quote(searchText.getText()) + ".*", ((Item) element).getName())) {
            return true;
        }
        return false;
    }
}

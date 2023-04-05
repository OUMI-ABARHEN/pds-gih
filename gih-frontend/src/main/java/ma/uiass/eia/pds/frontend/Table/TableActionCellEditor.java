package ma.uiass.eia.pds.frontend.Table;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;


public class TableActionCellEditor extends DefaultCellEditor {

    private TableActionEvent event;

    public TableActionCellEditor(TableActionEvent event) {
        super(new JCheckBox());
        this.event = event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        PanelAction action = null;
        try {
            action = new PanelAction();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        try {
            action.initEvent( event, row);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }
}

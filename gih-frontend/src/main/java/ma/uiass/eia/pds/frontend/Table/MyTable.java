package ma.uiass.eia.pds.frontend.Table;


import ma.uiass.eia.pds.backend.Entite.Chambre;
import ma.uiass.eia.pds.frontend.Scroll.ScrollPaneWin11;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class MyTable extends JTable implements TableActionEvent {

    public MyTable(List<Chambre> chambreData) {
        super(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "No", "Type", "Lits", "Action"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        setRowHeight(40);
        setSelectionBackground(new java.awt.Color(56, 138, 112));

        getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
        getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(this));

        DefaultTableModel model = (DefaultTableModel) getModel();
        for (Chambre chambre : chambreData) {
            model.addRow(new Object[]{chambre.getEspace_id(), chambre.getType(), chambre.getLits(), null});
        }
    }

    @Override
    public void onEdit(int row) {

    }

    @Override
    public void onDelete(int row) {

    }

    @Override
    public void onView(int row) {

    }

    // rest of the class implementation

}

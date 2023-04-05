package ma.uiass.eia.pds.frontend.Table;


import ma.uiass.eia.pds.backend.Entite.Chambre;
import ma.uiass.eia.pds.frontend.Scroll.ScrollPaneWin11;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class MyTable extends JFrame {

    private JTable table;

    public MyTable() {
        initComponents();
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                System.out.println("Edit row : " + row);
            }

//            @Override
//            public void onDelete(int row) {
//                if (table.isEditing()) {
//                    table.getCellEditor().stopCellEditing();
//                }
//                DefaultTableModel model = (DefaultTableModel) table.getModel();
//                model.removeRow(row);
//            }
//
//            @Override
//            public void onView(int row) {
//                System.out.println("View row : " + row);
//            }
        };
        table.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(event));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("My Table");
        add(new JScrollPane(table));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        table = new JTable(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"1", "A", "001", null},
                        {"2", "B", "002", null},
                        {"3", "C", "003", null},
                        {"4", "D", "004", null}
                },
                new String[]{
                        "ID", "Name", "Tel", "Action"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, true
            };

//            public boolean isCellEditable(int rowIndex, int columnIndex) {
//                return canEdit[columnIndex];
//            }
        });
        table.setRowHeight(40);
        //table.setSelectionBackground(new java.awt.Color(56, 138, 112));
    }

    public static void main(String[] args) {
        new MyTable();
    }

}




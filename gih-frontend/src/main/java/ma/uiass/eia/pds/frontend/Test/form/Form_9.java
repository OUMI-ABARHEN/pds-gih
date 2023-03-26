package ma.uiass.eia.pds.frontend.Test.form;

import ma.uiass.eia.pds.backend.Entite.Lit;
import ma.uiass.eia.pds.backend.Entite.Service;
import ma.uiass.eia.pds.backend.Server;
import ma.uiass.eia.pds.frontend.OkHttp.OkHttp;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class Form_9 extends javax.swing.JPanel {

    OkHttp o = new OkHttp();
    List<Service> services = o.getServices();


    public Form_9() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setBackground(new java.awt.Color(242, 242, 242));

        //jLabel1.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        //jLabel1.setForeground(new java.awt.Color(106, 106, 106));
        //jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        //jLabel1.setText("Form 1");

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Code", "Nom de service","Batiment","Etage"});
        table.setModel(tableModel);
        jScrollPane1.setViewportView(table);
        loadLits(tableModel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(125, 125, 125))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loadLits(DefaultTableModel tableModel) {
        tableModel.setRowCount(0);
        for (Service service : services) {
            Object[] row = new Object[]{service.getCode(), service.getNomService(),service.getEmplacement().getNomBatiment(),service.getEmplacement().getEtage()};
            tableModel.addRow(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
// End of variables declaration//GEN-END:variables
}
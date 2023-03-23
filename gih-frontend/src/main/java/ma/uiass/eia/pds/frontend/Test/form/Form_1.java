/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.uiass.eia.pds.frontend.Test.form;

import ma.uiass.eia.pds.backend.Entite.Identifiant;
import ma.uiass.eia.pds.frontend.OkHttp.OkHttp;

import javax.swing.table.DefaultTableModel;
import java.util.List;



public class Form_1 extends javax.swing.JPanel {

    OkHttp o = new OkHttp();
    List<Identifiant> identifiants = o.getIdentifiants();


    public Form_1() {
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

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Code", "Nom", "Prenom", "email", "Tel", "Sexe"});
        table.setModel(tableModel);
        jScrollPane1.setViewportView(table);
        loadIdentifiants();

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

    public void loadIdentifiants() {
        tableModel.setRowCount(0);
        for (Identifiant identifiant : identifiants) {
            Object[] row = new Object[]{identifiant.getCode(), identifiant.getNom(), identifiant.getPrenom(), identifiant.getEmail(), identifiant.getTel(), identifiant.getSexe()};
            tableModel.addRow(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    DefaultTableModel tableModel;
// End of variables declaration//GEN-END:variables
}
package ma.uiass.eia.pds.frontend.Test.formChefService;

import ma.uiass.eia.pds.backend.Entite.*;
import ma.uiass.eia.pds.frontend.OkHttp.OkHttp;
import ma.uiass.eia.pds.frontend.OkHttp.OkHttpDemande;

import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.ObjectView;
import javax.validation.constraints.AssertFalse;

public class Form_2 extends javax.swing.JPanel {
    OkHttpDemande o = new OkHttpDemande();
    OkHttp o1 = new OkHttp();

    public Form_2() throws MalformedURLException {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() throws MalformedURLException {

        typeBox = new javax.swing.JComboBox<>();
        Supprimer = new javax.swing.JButton();
        quantiteBox = new javax.swing.JComboBox<>();
        addButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        detailTable = new javax.swing.JTable();
        confirmButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        typeLabel = new javax.swing.JLabel();
        quantLabel = new javax.swing.JLabel();
        titreLabel = new javax.swing.JLabel();
        quantiteSpinner = new javax.swing.JSpinner();

        typeLabel.setText("Type Lit:");

        quantLabel.setText("quantite:");

        titreLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        titreLabel.setText("Ajouter une Demande:");





        typeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "hospitalisation", "soin" }));

        quantiteBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7" }));

        tableModelDetail= new DefaultTableModel();
        tableModelDetail.setColumnIdentifiers(new String[]{ "Type Lit",  "Quantite"});

        detailTable.setModel(tableModelDetail);
        jScrollPane1.setViewportView(detailTable);

        addButton.setIcon(new ImageIcon(new File("/Users/obarhen/Desktop/pds3/gih-frontend/src/main/resources/icon/confirmation.png").toURI().toURL())); // NOI18N
        addButton.setText("Add");
        List<String> lstCodeDetail = new ArrayList<>();
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String code = GenerateCode.generateCodeDetail();
                TypeLit type = TypeLit.valueOf((String) typeBox.getSelectedItem());
                int q = (int) quantiteSpinner.getValue();
                o.addDetailDemande(code,type,q);
                tableModelDetail.addRow(new Object[]{type,q});
                lstCodeDetail.add(code);
            }
        });


        //confirmButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/pds/confirmation-2.png"))); // NOI18N
        confirmButton.setText("Confirmer Demande");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(detailTable.getRowCount() == 0)
                    JOptionPane.showMessageDialog(null,"Votre demande est null");
                else if(detailTable.getRowCount() != 0){
                    String code = GenerateCode.generateCodeDemande();
                    o.addDemande(code, "chirurgie", EtatDemande.EnCours);
                    tableModelDetail.setRowCount(0);
                    for (String codeDD : lstCodeDetail) {
                        o.updateDetail(codeDD, code);
                    }
                    lstCodeDetail.clear();
                }

            }
        });
        Supprimer.setText("Supprimer");
        Supprimer.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int rowIndex = detailTable.getSelectedRow();
                ((DefaultTableModel)detailTable.getModel()).removeRow(rowIndex);
                o.delete(lstCodeDetail.get(rowIndex));
                lstCodeDetail.remove(rowIndex);
            }});



        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addComponent(Supprimer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(145, 145, 145))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(typeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(typeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(152, 152, 152)
                                .addComponent(quantLabel)
                                .addGap(18, 18, 18)
                                .addComponent(quantiteSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addButton)
                                .addGap(164, 164, 164))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(133, 133, 133)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(305, 305, 305)
                                                .addComponent(titreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(194, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(titreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(typeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addButton)
                                        .addComponent(typeLabel)
                                        .addComponent(quantLabel)
                                        .addComponent(quantiteSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(confirmButton)
                                        .addComponent(Supprimer))
                                .addContainerGap(109, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void serviceBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    // Variables declaration - do not modify

    DefaultTableModel tableModelDetail;
    private javax.swing.JButton addButton;
    private javax.swing.JButton confirmButton;
    private javax.swing.JTable detailTable;

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> quantiteBox;
    private javax.swing.JComboBox<String> typeBox;
    private List<DetailDemande> detailList = new ArrayList<>();
    private javax.swing.JButton Supprimer;
    private javax.swing.JLabel quantLabel;
    private javax.swing.JLabel titreLabel;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JSpinner quantiteSpinner;
    // End of variables declaration
}




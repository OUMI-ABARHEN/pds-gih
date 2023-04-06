package ma.uiass.eia.pds.frontend.Test.formChefService;


import ma.uiass.eia.pds.backend.Entite.DemandeFormat;
import ma.uiass.eia.pds.backend.Entite.DetailDemande;
import ma.uiass.eia.pds.backend.Entite.EtatDemande;
import ma.uiass.eia.pds.frontend.OkHttp.OkHttpDemande;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class Form_5 extends javax.swing.JPanel {

    OkHttpDemande o = new OkHttpDemande();



    public Form_5() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        box = new javax.swing.JComboBox<>();
        okButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24));
        jLabel1.setText("Vos Demandes:");

        tableModel= new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{ "N'Demande","Date demande","Etat"});
        table.setModel(tableModel);
        jScrollPane1.setViewportView(table);


        box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Demande traiter", "Demande non traiter", "Tous les demandes","Demande rejetee" }));

        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                if (box.getSelectedItem().equals("Demande traiter"))
                    loadDemandeTraiter(tableModel);
                else if (box.getSelectedItem().equals("Demande non traiter")) {
                    loadDemandeEnCours(tableModel);
                } else if (box.getSelectedItem().equals("Tous les demandes")) {
                    loadDemande(tableModel);
                }else if(box.getSelectedItem().equals("Demande rejetee")){
                    loadDemandeRejetee(tableModel);
                }
            }
        });

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int rowIndex = table.getSelectedRow();
                Object nDemande = tableModel.getValueAt(rowIndex, 0);
                List<String> newlst = new ArrayList<>();
                for(DetailDemande d : o.getDemande((String) nDemande).getLst()){
                    newlst.add(d.getQuantite()+" lits de type "+d.getType()+"\n");
                }
                JOptionPane.showMessageDialog(null,"Votre demmende contient"+newlst);


            }
        });


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(109, 109, 109)
                                                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addGap(79, 79, 79)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(368, 368, 368)
                                                .addComponent(jLabel1)))
                                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(31, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(okButton))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62))
        );
    }// </editor-fold>

    private void loadDemandeTraiter(DefaultTableModel tableModel){
        tableModel.setRowCount(0);
        for(DemandeFormat d : o.getDemandes()){
            if(d.getEtat().equals(EtatDemande.Traite))
                tableModel.addRow(new Object[]{d.getCode(),d.getDate(),d.getEtat()});
        }
    }
    private void loadDemandeEnCours(DefaultTableModel tableModel){
        tableModel.setRowCount(0);
        for(DemandeFormat d : o.getDemandes()){
            if(d.getEtat().equals(EtatDemande.EnCours))
                tableModel.addRow(new Object[]{d.getCode(),d.getDate(),d.getEtat()});
        }
    }
    private void loadDemande(DefaultTableModel tableModel){
        tableModel.setRowCount(0);
        for(DemandeFormat d : o.getDemandes()){
            tableModel.addRow(new Object[]{d.getCode(),d.getDate(),d.getEtat()});
        }
    }
    private void loadDemandeRejetee(DefaultTableModel tableModel){
        tableModel.setRowCount(0);
        for(DemandeFormat d : o.getDemandes()){
            if(d.getEtat().equals(EtatDemande.REJETEE))
                tableModel.addRow(new Object[]{d.getCode(),d.getDate(),d.getEtat()});
        }
    }


    // Variables declaration - do not modify
    private javax.swing.JComboBox<String> box;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton okButton;
    javax.swing.JTable table;
    DefaultTableModel tableModel;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration
}


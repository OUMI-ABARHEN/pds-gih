package ma.uiass.eia.pds.frontend.Test.formLogistique;

import ma.uiass.eia.pds.backend.Entite.DemandeFormat;
import ma.uiass.eia.pds.backend.Entite.DetailDemande;
import ma.uiass.eia.pds.backend.Entite.EtatDemande;
import ma.uiass.eia.pds.backend.Entite.Service;
import ma.uiass.eia.pds.frontend.OkHttp.OkHttp;
import ma.uiass.eia.pds.frontend.OkHttp.OkHttpDemande;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class Form_1 extends javax.swing.JPanel {

    OkHttpDemande o = new OkHttpDemande();
    OkHttp o1 = new OkHttp();
    List<Service> serviceList = o1.getServices();



    public Form_1() {
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
        serviceBox = new javax.swing.JComboBox<>();
        serviceLabel = new javax.swing.JLabel();
        rejeteCheck = new javax.swing.JCheckBox();
        enCoursCheck = new javax.swing.JCheckBox();
        traiteCheck = new javax.swing.JCheckBox();
        Etat = new javax.swing.JLabel();
        nDem = new javax.swing.JLabel();
        codeDemBox = new javax.swing.JComboBox<>();
        group = new ButtonGroup();
        saveButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24));
        jLabel1.setText("Vos Demandes:");

        tableModel= new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{ "N'Demande","service","Date demande","Etat"});
        table.setModel(tableModel);
        jScrollPane1.setViewportView(table);


        box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Demande traiter", "Demande non traiter", "Tous les demandes","Demande rejetee" }));

        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableModel.setRowCount(0);
                String nomS = (String) serviceBox.getSelectedItem();
                if (box.getSelectedItem().equals("Demande traiter"))
                    loadDemandeTraiter(tableModel,nomS);
                else if (box.getSelectedItem().equals("Demande non traiter")) {
                    loadDemandeEnCours(tableModel,nomS);
                } else if (box.getSelectedItem().equals("Tous les demandes")) {
                    loadDemande(tableModel,nomS);
                }else if(box.getSelectedItem().equals("Demande rejetee")){
                    loadDemandeRejete(tableModel,nomS);
                }
            }
        });
        saveButton.setText("save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String code =(String) codeDemBox.getSelectedItem();
                if(enCoursCheck.isSelected()==true){
                    o.updateEtatDemande(code,EtatDemande.EnCours);
                    loadDemandeEnCours(tableModel, (String) serviceBox.getSelectedItem());
                }else if(traiteCheck.isSelected()==true){
                    demadeTraite(code);
                    loadDemandeTraiter(tableModel, (String) serviceBox.getSelectedItem());
                }else if (rejeteCheck.isSelected()==true){
                    o.updateEtatDemande(code,EtatDemande.REJETEE);
                    loadDemandeRejete(tableModel, (String) serviceBox.getSelectedItem());
                }
                group.clearSelection();

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


        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24));
        jLabel1.setText("Vos Demandes:");

        for (Service s : serviceList) {
            serviceBox.addItem(s.getNomService());
        }

        serviceLabel.setText("Service:");

        rejeteCheck.setText("Rejetee");


        enCoursCheck.setText("EnCours");


        traiteCheck.setText("Traitee");

        group.add(traiteCheck);
        group.add(enCoursCheck);
        group.add(rejeteCheck);


        Etat.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        Etat.setText("Etat De Demande:");

        nDem.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        nDem.setText("Num Demande:");

        Etat.setVisible(false);
        rejeteCheck.setVisible(false);
        traiteCheck.setVisible(false);
        enCoursCheck.setVisible(false);
        saveButton.setVisible(false);
        codeDemBox.setVisible(false);
        nDem.setVisible(false);



        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(saveButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(nDem)
                                                                        .addComponent(Etat)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(8, 8, 8)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                        .addComponent(traiteCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(enCoursCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(rejeteCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(19, 19, 19)
                                                                .addComponent(codeDemBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 8, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(52, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(350, 350, 350)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(176, 176, 176)
                                                .addComponent(serviceLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(serviceBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(178, 178, 178)
                                                .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(121, 121, 121)
                                                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel1)
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(serviceBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(okButton)
                                        .addComponent(serviceLabel))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                                .addComponent(nDem)
                                                .addGap(18, 18, 18)
                                                .addComponent(codeDemBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(Etat)
                                                .addGap(18, 18, 18)
                                                .addComponent(rejeteCheck)
                                                .addGap(33, 33, 33)
                                                .addComponent(enCoursCheck)
                                                .addGap(35, 35, 35)
                                                .addComponent(traiteCheck)
                                                .addGap(44, 44, 44)
                                                .addComponent(saveButton)
                                                .addGap(141, 141, 141))))
        );
    }// </editor-fold>

    private void loadDemandeTraiter(DefaultTableModel tableModel, String nomS) {
        tableModel.setRowCount(0);
        codeDemBox.removeAllItems();
        for (DemandeFormat d : o.getByService(nomS)) {
            if (d.getEtat().equals(EtatDemande.Traite)) {
                codeDemBox.addItem(d.getCode());
                tableModel.addRow(new Object[]{d.getCode(), d.getService().getNomService(), d.getDate(), d.getEtat()});
            }
        }
        Etat.setVisible(false);
        rejeteCheck.setVisible(false);
        traiteCheck.setVisible(false);
        enCoursCheck.setVisible(false);
        saveButton.setVisible(false);
        codeDemBox.setVisible(false);
        nDem.setVisible(false);
    }

    private void loadDemandeEnCours(DefaultTableModel tableModel, String nomS) {
        tableModel.setRowCount(0);
        codeDemBox.removeAllItems();
        for (DemandeFormat d : o.getByService(nomS)) {
            if (d.getEtat().equals(EtatDemande.EnCours)) {
                codeDemBox.addItem(d.getCode());
                tableModel.addRow(new Object[]{d.getCode(), nomS, d.getDate(), d.getEtat()});
            }
        }
        Etat.setVisible(true);
        rejeteCheck.setVisible(true);
        traiteCheck.setVisible(true);
        enCoursCheck.setVisible(false);
        saveButton.setVisible(true);
        codeDemBox.setVisible(true);
        nDem.setVisible(true);


    }

    private void loadDemande(DefaultTableModel tableModel,String nomS){
        tableModel.setRowCount(0);
        codeDemBox.removeAllItems();
        for(DemandeFormat d : o.getByService(nomS)){
            codeDemBox.addItem(d.getCode());
            tableModel.addRow(new Object[]{d.getCode(),nomS,d.getDate(),d.getEtat()});
        }
        Etat.setVisible(true);
        rejeteCheck.setVisible(true);
        traiteCheck.setVisible(true);
        enCoursCheck.setVisible(true);
        saveButton.setVisible(true);
        codeDemBox.setVisible(true);
        nDem.setVisible(true);
    }
    private void loadDemandeRejete(DefaultTableModel tableModel, String nomS) {
        tableModel.setRowCount(0);
        codeDemBox.removeAllItems();
        for (DemandeFormat d : o.getByService(nomS)) {
            if (d.getEtat().equals(EtatDemande.REJETEE)) {
                codeDemBox.addItem(d.getCode());
                tableModel.addRow(new Object[]{d.getCode(), nomS, d.getDate(), d.getEtat()});
            }
        }
        Etat.setVisible(true);
        rejeteCheck.setVisible(false);
        traiteCheck.setVisible(true);
        enCoursCheck.setVisible(true);
        saveButton.setVisible(true);
        codeDemBox.setVisible(true);
        nDem.setVisible(true);


    }
    private void demadeTraite(String code){
        List<DetailDemande> lst = o.getDemande(code).getLst();
        for(DetailDemande d : lst){
            int q = d.getQuantite();
            while (q>0){
                q--;
                o.addLitStock(d.getType(),o.getDemande(code).getService().getNomService());
            }
        }
        o.updateEtatDemande(code,EtatDemande.Traite);


    }


    // Variables declaration - do not modify
    private javax.swing.JLabel Etat;
    private javax.swing.JComboBox<String> box;
    private javax.swing.JCheckBox enCoursCheck;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton okButton;
    private javax.swing.JCheckBox rejeteCheck;
    private javax.swing.JComboBox<String> serviceBox;
    private javax.swing.JLabel serviceLabel;
    private javax.swing.JTable table;
    private javax.swing.JCheckBox traiteCheck;
    private javax.swing.JComboBox<String> codeDemBox;
    private javax.swing.JLabel nDem;
    private ButtonGroup group;
    private DefaultTableModel tableModel;
    private javax.swing.JButton saveButton;
    // End of variables declaration
}

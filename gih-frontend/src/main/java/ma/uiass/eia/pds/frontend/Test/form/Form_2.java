package ma.uiass.eia.pds.frontend.Test.form;

import ma.uiass.eia.pds.backend.Entite.Identifiant;
import ma.uiass.eia.pds.backend.Entite.Job;
import ma.uiass.eia.pds.backend.Entite.Sexe;
import ma.uiass.eia.pds.frontend.OkHttp.OkHttp;

import javax.swing.*;

public class Form_2 extends javax.swing.JPanel {
    OkHttp o = new OkHttp();

    public Form_2() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {



        setBackground(new java.awt.Color(242, 242, 242));

        lblCode = new javax.swing.JLabel();
        lblNom = new javax.swing.JLabel();
        lblPrenom = new javax.swing.JLabel();
        lblSexe = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        txtNom = new javax.swing.JTextField();
        txtPrenom = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        lblJob = new javax.swing.JLabel();
        cboJob = new javax.swing.JComboBox<>();
        cboSexe = new javax.swing.JComboBox<>();
        form1 = new Form_1();




        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // set the font and size of the label
        jLabel1.setText("Enter Information:");

        lblCode.setText("Code:");

        lblNom.setText("Nom:");

        lblPrenom.setText("Prenom:");
        lblSexe.setText("Sexe:");

        lblEmail.setText("Email:");

        lblPhone.setText("Phone Number:");
        lblPassword.setText("Password:");
        lblJob.setText("Job:");
        cboJob.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "admin logistic", "chef de service" }));
        cboSexe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FEMELAE", "MALE" }));

        btnAdd.setText("Submit"); // set the text of the button
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String code = txtCode.getText();
                String nom = txtNom.getText();
                String prenom = txtPrenom.getText();
                String email = txtEmail.getText();
                int phone = Integer.parseInt(txtPhone.getText());
                String s = (String) cboSexe.getSelectedItem();
                Sexe sexe= Sexe.valueOf(s.toUpperCase());
                String password = txtPassword.getText();
                String j = (String)cboJob.getSelectedItem();
                Job job = new Job(j);
                Identifiant identifiant = new Identifiant(code,nom,prenom,email,phone,sexe,password,job);
                o.addIdentifiant(identifiant);
                form1.loadIdentifiants();
                JOptionPane.showMessageDialog(null,"Identifiant was added succesfully");
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblCode)
                                                        .addComponent(lblNom)
                                                        .addComponent(lblPrenom)
                                                        .addComponent(lblSexe)
                                                        .addComponent(lblEmail)
                                                        .addComponent(lblPhone)
                                                        .addComponent(lblPassword)
                                                        .addComponent(lblJob))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtCode)
                                                        .addComponent(txtNom)
                                                        .addComponent(txtPrenom)
                                                        .addComponent(cboSexe)
                                                        .addComponent(txtEmail)
                                                        .addComponent(txtPhone)
                                                        .addComponent(txtPassword)
                                                        .addComponent(cboJob, 0, 150, Short.MAX_VALUE))
                                                .addGap(44, 44, 44))))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(btnAdd)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCode)
                        .addComponent(txtCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNom)
                        .addComponent(txtNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPrenom)
                        .addComponent(txtPrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSexe)
                        .addComponent(cboSexe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEmail)
                        .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPassword)
                        .addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPhone)
                        .addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblJob)
                        .addComponent(cboJob, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAdd)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));


    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables

    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblNom;
    private javax.swing.JLabel lblPrenom;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtPrenom;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JLabel lblJob;
    private javax.swing.JComboBox<String> cboJob;
    private javax.swing.JLabel lblSexe;
    private javax.swing.JComboBox<String> cboSexe;
    private Form_1 form1;



    // End of variables declaration//GEN-END:variables
}

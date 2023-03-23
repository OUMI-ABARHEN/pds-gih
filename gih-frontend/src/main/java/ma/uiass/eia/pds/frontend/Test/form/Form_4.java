/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.uiass.eia.pds.frontend.Test.form;

import javax.swing.*;
import java.util.List;


import ma.uiass.eia.pds.backend.Entite.Identifiant;
import ma.uiass.eia.pds.frontend.OkHttp.OkHttp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form_4 extends javax.swing.JPanel {

    OkHttp o = new OkHttp();
    List<Identifiant> identifiants = o.getIdentifiants();

    private JLabel label;
    private JComboBox comboBox;
    private JButton button;
    public Form_4() {
        initComponents();
    }

    private void initComponents() {
        setBackground(new java.awt.Color(242, 242, 242));

        // Create the label and combo box
        label = new JLabel("Choisir un identifiant");
        comboBox = new JComboBox();
        for (Identifiant identifiant : identifiants) {
            comboBox.addItem(identifiant.getCode());
        }


        // Create the button and add an action listener to it
        button = new JButton("Delete");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to execute when the button is clicked
                deleteIdentifient(comboBox.getSelectedItem().toString());
                JOptionPane.showMessageDialog(null,"Identifiant deleted succesfully");
            }
        });

        // Set the layout of the panel
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(label)
                                        .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button))
                                .addContainerGap(238, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(label)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(button)
                                .addContainerGap(125, Short.MAX_VALUE))
        );
    }

    private void deleteIdentifient(String code) {
        o.deleteIdentifient(code);
    }
}
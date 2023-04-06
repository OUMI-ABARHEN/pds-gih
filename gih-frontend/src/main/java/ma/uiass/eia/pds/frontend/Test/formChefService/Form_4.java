package ma.uiass.eia.pds.frontend.Test.formChefService;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import ma.uiass.eia.pds.backend.Entite.EtatLit;
import ma.uiass.eia.pds.backend.Entite.Lit;
import ma.uiass.eia.pds.backend.Entite.SejourFormatted;
import ma.uiass.eia.pds.frontend.OkHttp.OkHttp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Form_4 extends JPanel implements ActionListener {
    private JLabel date_entre_label, date_sortie_label, lit_id_label;
    //    private JTextField date_entre_field, date_sortie_field;
    private JDateChooser date_entre_field, date_sortie_field;

    private JComboBox<String> lit_id_field;
    private JButton add_button, load_button;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private OkHttp okHttp = new OkHttp();
    List<SejourFormatted> sejours = okHttp.getSejours();
    List<Lit> lits = okHttp.getLits();
    public Form_4() {
        initComponents();
    }

    private void initComponents() {
        setBackground(new Color(242, 242, 242));

        JLabel jLabel1 = new JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1.setFont(new Font("sansserif", 0, 36));
        jLabel1.setForeground(new Color(106, 106, 106));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Gestion de sejours");


        date_entre_label = new JLabel("Date Entree:");
        date_entre_field = new JDateChooser();
        date_entre_field.setPreferredSize(new Dimension(150,50));
        ((JTextFieldDateEditor) date_entre_field.getDateEditor()).setEditable(false);
        date_entre_field.setDateFormatString("yyyy-MM-dd");
        date_sortie_label = new JLabel("Date Sortie:");
        date_sortie_field = new JDateChooser();
        date_sortie_field.setPreferredSize(new Dimension(150,50));
        ((JTextFieldDateEditor) date_sortie_field.getDateEditor()).setEditable(false);
        date_sortie_field.setDateFormatString("yyyy-MM-dd");

        lit_id_label = new JLabel("Code Lit:");
        lit_id_field = new JComboBox<>();
        lit_id_field.setPreferredSize(new Dimension(150,50));
        add_button = new JButton("Add Sejour");
        add_button.addActionListener(this);
        load_button = new JButton("Load Sejours");
        load_button.addActionListener(this);
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"ID", "Date Entree", "Date Sortie", "Code Lit"});
        table.setModel(tableModel);
        jScrollPane1.setViewportView(table);


        // Fetch lit IDs with EtatLit.DISPONIBLE and populate the combo box
        List<Lit> lits = okHttp.getLits();
        for (Lit lit : lits) {
            if (lit.getEtat() == EtatLit.DISPONIBLE) {
                lit_id_field.addItem(String.valueOf(lit.getCode()));
            }
        }


//        JPanel panel = new JPanel(new GridLayout(5, 2));
//        panel.add(date_entre_label);
//        panel.add(date_entre_field);
//        panel.add(date_sortie_label);
//        panel.add(date_sortie_field);
//        panel.add(lit_id_label);
//        panel.add(lit_id_field);
//        panel.setPreferredSize(new Dimension(300, 120));
//        panel.setMaximumSize(new Dimension(300, 120));
//        panel.setMinimumSize(new Dimension(300, 120));
        load_button.setSize(10,10);
        add_button.setSize(10,10);
//        panel.add(add_button);
//        panel.add(load_button);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(load_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(add_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lit_id_label)
                                                                .addGap(60, 60, 60)
                                                                .addComponent(lit_id_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(date_entre_label)
                                                                .addGap(60, 60, 60)
                                                                .addComponent(date_entre_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(date_sortie_label)
                                                                .addGap(60, 60, 60)
                                                                .addComponent(date_sortie_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGap(29, 29, 29)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(date_entre_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(date_entre_label))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(date_sortie_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(date_sortie_label))
                                                .addGap(29, 29, 29)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lit_id_field, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lit_id_label))
                                                .addGap(40, 40, 40)
                                                .addComponent(add_button)
                                                .addGap(26, 26, 26)
                                                .addComponent(load_button))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(19, Short.MAX_VALUE))
        );
    }











//        panel.add(table);

//        GroupLayout layout = new GroupLayout(this);
//        this.setLayout(layout);
//        layout.setHorizontalGroup(
//                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                        .addGroup(layout.createSequentialGroup()
//                                .addContainerGap()
//                                .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
//                                .addContainerGap())
//                        .addGroup(layout.createSequentialGroup()
//                                .addGap(25, 25, 25)
//                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
//                                .addGap(18, 18, 18)
//                                .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                .addGap(25, 25, 25))
//        );
//        layout.setVerticalGroup(
//                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                        .addGroup(layout.createSequentialGroup()
//                                .addContainerGap()
//                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
//                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
//                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))
//                                .addContainerGap())
//        );



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add_button) {
            Date date_entre = date_entre_field.getDate();
            Date date_sortie = date_sortie_field.getDate();
            String code = lit_id_field.getSelectedItem().toString();

//            Date date_entre = null;
//            Date date_sortie = null;
//
//            try {
//                date_entre = dateFormat.parse(date_entre_string);
//                date_sortie = dateFormat.parse(date_sortie_string);
//            } catch (ParseException ex) {
//                ex.printStackTrace();
//            }
            try {
                okHttp.addSejourok(date_entre, date_sortie, code);
                okHttp.updateEtatLit(code, EtatLit.OCCUPE);
                Lit lit = okHttp.getLitByCode(code);
                lit_id_field.removeItem(String.valueOf(lit.getCode()));
                JOptionPane.showMessageDialog(this, "Sejour added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Failed to add Sejour", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }







            // Update sejours list with newly added sejour
            sejours = okHttp.getSejours();
            lit_id_field.setSelectedIndex(0);
        } else if (e.getSource() == load_button) {
            loadSejoursToTable();
        }
    }


    private void loadSejoursToTable() {
        tableModel.setRowCount(0);
        for (SejourFormatted sejour : sejours) {
            Object[] row = new Object[]{sejour.getSejour_id(),sejour.getDate_entre(),sejour.getDate_sortie(),sejour.getLit().getCode()};
            tableModel.addRow(row);
        }

    }
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    DefaultTableModel tableModel;





    // </editor-fold>

}






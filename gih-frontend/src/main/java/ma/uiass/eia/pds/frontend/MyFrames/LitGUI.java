package ma.uiass.eia.pds.frontend.MyFrames;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import ma.uiass.eia.pds.backend.Entite.Lit;
import ma.uiass.eia.pds.frontend.Http.HttpClient;


public class LitGUI extends JFrame {
    private static HttpClient httpClient = new HttpClient();

    private JTable table;
    private JButton getLitsButton;

    public LitGUI() {
        super("Lit GUI");

        // create table model and table
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"ID", "Type", "Marque", "Espace", "Etat"});
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // create button to get Lits
        getLitsButton = new JButton("Get Lits");
        getLitsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadLits(tableModel);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(getLitsButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadLits(DefaultTableModel tableModel) {
        List<Lit> lits = httpClient.getLits();
        System.out.println(lits);
        tableModel.setRowCount(0);
        for (Lit lit : lits) {
            Object[] row = new Object[]{lit.getLit_id(), lit.getTypeLit(),  lit.getEspace(), lit.getEtat()};
            tableModel.addRow(row);
        }
    }

    public static void main(String[] args) {

        new LitGUI();
    }
}
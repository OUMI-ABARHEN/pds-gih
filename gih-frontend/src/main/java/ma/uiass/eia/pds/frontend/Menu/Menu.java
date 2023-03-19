package ma.uiass.eia.pds.frontend.Menu;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


import ma.uiass.eia.pds.backend.Entite.Chambre;
import ma.uiass.eia.pds.backend.Entite.Emplacement;
import ma.uiass.eia.pds.backend.Entite.Service;
import ma.uiass.eia.pds.frontend.Http.HttpClient;
import ma.uiass.eia.pds.frontend.Home.Home;
import ma.uiass.eia.pds.frontend.Login.LoginAndRegister;
import ma.uiass.eia.pds.frontend.MainLogin.MainLogin;
import ma.uiass.eia.pds.frontend.Table.MyTable;
import net.miginfocom.swing.MigLayout;

public class Menu extends JComponent {

    private MigLayout layout;
    HttpClient t = new HttpClient();
    List<Service> services = t.getServices();
    List<Emplacement> emplacements = t.getEmplacements();
    List<Chambre> chambres = t.getChambres();
   /* private String[][] menuItems = new String[][]{
            {"Dashboard"},
            {"Localisation 1", services.get(0).getNomService(), services.get(1).getNomService()},
            {"Localisation 2", "Sevice 2-1", "Sevice 2-2", "Sevice 2-3"},
            {"Localisation 3", "Sevice 3-1", "Sevice 3-2", "Sevice 3-3"},
            {"Informations", "User info" , "Update infos" },
            {"Log out"},


    };*/

    private List<List<String>> menuItems = new ArrayList<>();


    public Menu() {
        init();
    }
    public Menu(Home main) {
        this.myMain = main;
        init();
    }


    private void init() {
        layout = new MigLayout("wrap 1, fillx, gapy 0, inset 2", "fill");
        setLayout(layout);
        setOpaque(true);

        // Initialize menuItems
        menuItems.add(Collections.singletonList("Dashboard"));
        menuItems.add(Arrays.asList(emplacements.get(0).getNomBatiment(), services.get(0).getNomService()));
        menuItems.add(Arrays.asList("Localisation 2", "Service 2-1", "Service 2-2", "Service 2-3"));
        menuItems.add(Arrays.asList("Localisation 3", "Service 3-1", "Service 3-2", "Service 3-3"));
        menuItems.add(Arrays.asList("Informations", "User info", "Update infos"));
        menuItems.add(Collections.singletonList("Log out"));

        for (int i = 0; i < menuItems.size(); i++) {
            addMenu(menuItems.get(i).get(0), i);

            // Add action listener to "Log out" item
            if (menuItems.get(i).get(0).equals("Log out")) {
                MenuItem logoutItem = (MenuItem) getComponent(getComponentCount() - 1); // Get the last added item (which is "Log out")
                logoutItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        // Handle logout action
                        // Navigate to the Login page
                        JFrame loginFrame = new MainLogin();
                        loginFrame.setVisible(true);
                        JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(Menu.this);
                        mainFrame.dispose();

                    }
                });
            }
        }

    }

    private Icon getIcon(int index) {
        URL url = getClass().getResource(  index + ".png");
        if (url != null) {
            return new ImageIcon(url);
        } else {
            return null;
        }
    }

    private void addMenu(String menuName, int index) {
        List<String> items = menuItems.get(index);
        int length = items.size();
        MenuItem item = new MenuItem(menuName, index, length > 1);
        Icon icon = getIcon(index);
        if (icon != null) {
            item.setIcon(icon);
        }
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (length > 1) {
                    if (!item.isSelected()) {
                        item.setSelected(true);
                        addSubMenu(item, index, length, getComponentZOrder(item));
                    } else {
                        // Hide menu
                        hideMenu(item, index);
                        item.setSelected(false);
                    }
                }
            }
        });
        add(item);
        revalidate();
        repaint();

    }

    private void addSubMenu(MenuItem item, int index, int length, int indexZorder) {
        JPanel panel = new JPanel(new MigLayout("wrap 1, fillx, inset 0, gapy 0", "fill"));
        panel.setName(index + "");
        panel.setOpaque(false);


        List<String> items = menuItems.get(index);
        for (int i = 1; i < length; i++) {
            MenuItem subItem = new MenuItem(items.get(i), i, false);
            subItem.initSubMenu(i, length);
            subItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    // show message in JPanel1
                    //JOptionPane.showMessageDialog(null, "hello world");
                    //myMain.getLblNewLabel().setText("Hello world");
                    // add the Test component to jPanel1
                    myMain.getPanel().removeAll(); // remove any existing components from the panel
                    myMain.getPanel().setLayout(new MigLayout("fill")); // set the layout to MigLayout with fill constraint
                    myMain.getPanel().add(table, "grow"); // add the Test component to the panel
                    myMain.getPanel().revalidate(); // revalidate the panel to update its layout
                    myMain.getPanel().repaint(); // repaint the panel to reflect the changes



                }
            });
            panel.add(subItem);
            //myItems.add(subItem);
        }
        add(panel, "h 0!", indexZorder + 1);
        revalidate();
        repaint();
        MenuAnimation.showMenu(panel, item, layout, true);
    }

    private void hideMenu(MenuItem item, int index) {
        for (Component com : getComponents()) {
            if (com instanceof JPanel && com.getName() != null && com.getName().equals(index + "")) {
                com.setName(null);
                MenuAnimation.showMenu(com, item, layout, false);
                break;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setColor(new Color(46, 113, 176));
        g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        super.paintComponent(grphcs);
    }




    public Home myMain;
    private JPanel mainLogin = new JPanel() ;
    private JTable table = new JTable();
    public void loadTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // clear existing rows from the table
        for (Chambre chambre : chambres) {
            Object[] row = new Object[] { chambre.getEspace_id(), chambre.getType() };
            model.addRow(row);
        }
    }


}

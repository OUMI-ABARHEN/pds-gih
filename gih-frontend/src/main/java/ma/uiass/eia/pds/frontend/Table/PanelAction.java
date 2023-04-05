package ma.uiass.eia.pds.frontend.Table;

import ma.uiass.eia.pds.backend.Entite.Lit;
import ma.uiass.eia.pds.frontend.Test.formChefService.Form_1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.util.List;

public class PanelAction extends JPanel {


    int clickCount = 0;


    public PanelAction() throws MalformedURLException {
        initComponents();
    }
    Icon[] icons = {
            new ImageIcon(new File("/Users/mac/pds/gih-frontend/src/main/resources/icon/gryBed.png").toURI().toURL()),
            new ImageIcon(new File("/Users/mac/pds/gih-frontend/src/main/resources/icon/greenBed.png").toURI().toURL()),
            new ImageIcon(new File("/Users/mac/pds/gih-frontend/src/main/resources/icon/redBed.png").toURI().toURL())
    };

    public void initEvent(TableActionEvent event, int row) throws MalformedURLException {



//        cmdEdit.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                //event.onEdit(row);
//                try {
//                    cmdEdit.setIcon(new ImageIcon(new File("/Users/med/pds/gih-frontend/src/main/resources/icon/greenBed.png").toURI().toURL()));
//                } catch (MalformedURLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                int iconIndex = 0;
                // increment the click counter and update the icon index
                clickCount++;
                iconIndex = clickCount % 3;

                // set the new icon on the button
                btn.setIcon(icons[iconIndex]);

                event.onEdit(row);
            }
        });
//        cmdView.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                event.onView(row);
//            }
//        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() throws MalformedURLException {

        List<Lit> litList = form_1.getLits();
        btn = new JButton();
        for (Lit lit : litList) {
            Icon icon;
            if (lit.getEtat().equals("DISPONIBLE")) {
                icon = icons[1];
                System.out.println(lit.getEtat());
            } else if (lit.getEtat().equals("OCCUPE")) {
                icon = icons[1];
            } else {
                icon = icons[0];
            }
            btn.setIcon(icon);
            // add the button to your panel or container
        }


        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                //.addComponent(cmdEdit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                //.addComponent(cmdView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        //.addComponent(cmdView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                //.addComponent(cmdEdit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private JButton btn;
   private Form_1 form_1 = new Form_1();

    // End of variables declaration//GEN-END:variables
}

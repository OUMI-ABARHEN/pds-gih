package ma.uiass.eia.pds.frontend.Table;

import ma.uiass.eia.pds.backend.Entite.EtatLit;
import ma.uiass.eia.pds.backend.Entite.Lit;
import ma.uiass.eia.pds.frontend.OkHttp.OkHttp;
import ma.uiass.eia.pds.frontend.Test.formChefService.Form_1;

import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.net.MalformedURLException;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;


public class TableActionCellRender extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSeleted, boolean bln1, int row, int column) {
//        Component com = super.getTableCellRendererComponent(jtable, o, isSeleted, bln1, row, column);
//        PanelAction action = null;
//        try {
//            action = new PanelAction();
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//        if (isSeleted == false && row % 2 == 0) {
//            action.setBackground(Color.WHITE);
//        } else {
//            action.setBackground(com.getBackground());
//        }
//        return action;

//        OkHttp okHttp = new OkHttp();
//        List<Lit> lits = okHttp.getLits();
//        JButton button = new JButton();
//        for (Lit lit : lits) {
//            if (lit.getEtat() == EtatLit.DISPONIBLE) {
//                try {
//                    button.setIcon(new ImageIcon(new File("/Users/mac/pds/gih-frontend/src/main/resources/icon/greenBed.png").toURI().toURL()));
//                } catch (MalformedURLException e) {
//                    throw new RuntimeException(e);
//                }
//            } if(lit.getEtat() == EtatLit.OCCUPE) {
//                try {
//                    button.setIcon(new ImageIcon(new File("/Users/mac/pds/gih-frontend/src/main/resources/icon/redBed.png").toURI().toURL()));
//                } catch (MalformedURLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//        return button;
//    }

        super.getTableCellRendererComponent(jtable, o, isSeleted, bln1, row, column);

        // Get the corresponding EtatLit object for the current row
        OkHttp okHttp = new OkHttp();
        List<Lit> lits = okHttp.getLits();
        EtatLit etatLit = lits.get(row).getEtat();

        // Set the appropriate icon for the cell based on the value of the EtatLit object
        try {
            if (etatLit == EtatLit.DISPONIBLE) {
                setIcon(new ImageIcon(new File("/Users/obarhen/Desktop/pds-gih/gih-frontend/src/main/resources/icon/greenBed.png").toURI().toURL()));
            } else {
                setIcon(new ImageIcon(new File("/Users/obarhen/Desktop/pds-gih/gih-frontend/src/main/resources/icon/redBed.png").toURI().toURL()));
            }
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }

        return this;
        
    }


}

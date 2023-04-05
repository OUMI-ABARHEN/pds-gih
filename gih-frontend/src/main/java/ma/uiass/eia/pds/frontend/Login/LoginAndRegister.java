package ma.uiass.eia.pds.frontend.Login;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

import ma.uiass.eia.pds.frontend.Swing.EventLogin;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.PropertySetter;


public class LoginAndRegister extends javax.swing.JPanel {

    private MigLayout layout;

    private Login login;

    public static Color mainColor = new Color(104, 206, 246);



    public LoginAndRegister() {
        initComponents();
        init();

    }


    private void init() {
        setBackground(mainColor);
        layout = new MigLayout("fill, insets 100 450 100 450", "fill", "fill");
        setLayout(layout);
        login = new Login();
        add(login);
    }







    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 698, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 452, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public Login getLogin() {
        return login;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}


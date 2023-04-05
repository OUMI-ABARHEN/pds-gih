package ma.uiass.eia.pds.frontend.Login;

import ma.uiass.eia.pds.frontend.Swing.Button;
import ma.uiass.eia.pds.frontend.Swing.EventLogin;
import ma.uiass.eia.pds.frontend.Swing.Password;
import ma.uiass.eia.pds.frontend.Swing.TextField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class Login extends PanelCustom {

    private static final String LOGIN_URL = "http://localhost:2002/pds";


    private EventLogin event;


    public Login() {
        initComponents();
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSignIn = new JLabel();
        txtUsername = new TextField();
        password1 = new Password();
        button1 = new Button();


        setBackground(new java.awt.Color(247, 247, 247));

        lblSignIn.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lblSignIn.setForeground(new java.awt.Color(76, 76, 76));
        lblSignIn.setHorizontalAlignment(SwingConstants.CENTER);
        lblSignIn.setText("SIGN IN");

        txtUsername.setForeground(new java.awt.Color(76, 76, 76));
        txtUsername.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtUsername.setHint("USER NAME");

        password1.setForeground(new java.awt.Color(76, 76, 76));
        password1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        password1.setHint("PASSWORD");

        button1.setBackground(new java.awt.Color(86, 142, 255));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Sign In");
        button1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
//        button1.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                button1ActionPerformed(evt);
//            }
//        });



        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(password1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblSignIn, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                        .addComponent(button1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(30, 30, 30))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                )
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(lblSignIn)
                                .addGap(40, 40, 40)
                                .addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(password1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE))
                                        )
                                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

//    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
//        if (getAlpha() == 0) {
//            event.loginDone();
//        }
//    }//GEN-LAST:event_button1ActionPerformed

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == button1) {
            String username = txtUsername.getText();
            String password = new String(password1.getPassword());
            String authToken = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());


            try {
                URL url = new URL(LOGIN_URL + "/login");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Authorization", "Basic " + authToken);

                int responseCode = connection.getResponseCode();


                if (responseCode == HttpURLConnection.HTTP_OK) {
                    // Authentication successful
                   // dispose(); // Close the login window
                    JOptionPane.showMessageDialog(this, "yaaaay");
                    // Open the main window of the application
                    // ...
                } else {
                    // Authentication failed
                    JOptionPane.showMessageDialog(this, "Invalid username or password");
                }

                connection.disconnect();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "An error occurred. Please try again later.");
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Button button1;
    private JLabel lblSignIn;

    private Password password1;
    private TextField txtUsername;

    public Password getPassword1() {
        return password1;
    }

    public TextField getTxtUsername() {
        return txtUsername;
    }

    public Button getButton1() {
        return button1;
    }
    // End of variables declaration//GEN-END:variables
}

package ma.uiass.eia.pds.frontend.Test;

import ma.uiass.eia.pds.frontend.Login.Login;
import ma.uiass.eia.pds.frontend.Swing.Button;
import ma.uiass.eia.pds.frontend.Swing.Password;
import ma.uiass.eia.pds.frontend.Swing.TextField;
import net.miginfocom.swing.MigLayout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import javax.swing.*;

public class LoginFrame extends JFrame implements ActionListener {
    private static final String LOGIN_URL = "http://localhost:2002/pds";

    private JLabel usernameLabel;
    private TextField usernameField;
    private JLabel passwordLabel;
    private Password passwordField;
    private Button loginButton;
    private JLabel lblSignIn;

    private MigLayout layout;

    private Login login;

    public static Color mainColor = new Color(104, 206, 246);


    public LoginFrame() {
       // setTitle("Login");
        setSize(300, 150);
        //setResizable(false);
       // setDefaultCloseOperation(EXIT_ON_CLOSE);

        //setLayout(new FlowLayout());

//        usernameLabel = new JLabel("Username:");
//        add(usernameLabel);
//
//        usernameField = new JTextField(20);
//        add(usernameField);
//
//        passwordLabel = new JLabel("Password:");
//        add(passwordLabel);
//
//        passwordField = new JPasswordField(20);
//        add(passwordField);
//
//        loginButton = new JButton("Login");
//        loginButton.addActionListener(this);
//        add(loginButton);
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Set the background color
        getContentPane().setBackground(mainColor);

        // Create the panel and add components to it
        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout());

        // Add components to the panel
        panel.add(new JLabel("Username:"), "cell 0 0");
        panel.add(new JTextField(20), "cell 1 0");
        panel.add(new JLabel("Password:"), "cell 0 1");
        panel.add(new JPasswordField(20), "cell 1 1");
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        panel.add(loginButton, "cell 1 2");

        // Set the panel in the center of the frame
        getContentPane().add(panel, BorderLayout.CENTER);

        // Center the frame on the screen
        setLocationRelativeTo(null);
        initComponents();
    }
    private void initComponents() {
        lblSignIn = new JLabel();
        usernameField = new TextField();
        passwordField = new Password();
        loginButton = new Button();

        getContentPane().setBackground(mainColor);
        //setBackground(new java.awt.Color(247, 247, 247));

        lblSignIn.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lblSignIn.setForeground(new java.awt.Color(76, 76, 76));
        lblSignIn.setHorizontalAlignment(SwingConstants.CENTER);
        lblSignIn.setText("SIGN IN");

        usernameField.setForeground(new java.awt.Color(76, 76, 76));
        usernameField.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        usernameField.setHint("USER NAME");

        passwordField.setForeground(new java.awt.Color(76, 76, 76));
        passwordField.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        passwordField.setHint("PASSWORD");

        loginButton.setBackground(new java.awt.Color(86, 142, 255));
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Sign In");
        loginButton.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        loginButton.addActionListener(this);
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);

        panel.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(usernameField, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(passwordField, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblSignIn, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                        .addComponent(loginButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(lblSignIn)
                                .addGap(40, 40, 40)
                                .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGap(40, 40, 40))
        );
        add(panel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);

    }


    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String authToken = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());


            try {
                URL url = new URL(LOGIN_URL + "/login");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Authorization", "Basic " + authToken);

                int responseCode = connection.getResponseCode();


                if (responseCode == HttpURLConnection.HTTP_OK) {
                    // Authentication successful
                    dispose(); // Close the login window
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


    public static void main(String[] args) {
        LoginFrame frame = new LoginFrame();
        frame.setVisible(true);
    }
}

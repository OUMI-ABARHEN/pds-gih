package ma.uiass.eia.pds.frontend.MainLogin;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import ma.uiass.eia.pds.frontend.Home.Home;
import ma.uiass.eia.pds.frontend.Http.HttpClient;
import ma.uiass.eia.pds.frontend.Login.LoginAndRegister;
import ma.uiass.eia.pds.frontend.Swing.EventLogin;
import ma.uiass.eia.pds.frontend.Test.main.Main;
import ma.uiass.eia.pds.frontend.Test.mainChefService.MainChefService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.io.InputStreamReader;
import java.util.Scanner;


public class MainLogin extends javax.swing.JFrame {

    private static final String LOGIN_URL = "http://localhost:2002/pds";

//   private Home home;
//    HttpClient t = new HttpClient();
    private MainChefService mainChefService;

    public MainLogin() throws JsonProcessingException {
        initComponents();
        //home = new Home();
        mainChefService = new MainChefService();
        EventLogin event = new EventLogin() {
            @Override
            public void loginDone() {
                main.setVisible(false);
                //home.setVisible(true);
                mainChefService.setVisible(true);
            }

            @Override
            public void logOut() {
                main.removeAll();
                main.add(loginAndRegister1);
                main.revalidate();
                main.repaint();
            }
        };
        //home.setEventLogin(event);
        mainChefService.setEventLogin(event);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main = new javax.swing.JPanel();
        loginAndRegister1 = new LoginAndRegister();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        main.setLayout(new java.awt.BorderLayout());
        main.add(loginAndRegister1, java.awt.BorderLayout.CENTER);
//        loginAndRegister1.getLogin().getButton1().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Call the actionPerformed method
//                actionPerformed(e);
//            }
//        });

        loginAndRegister1.getLogin().getButton1().addActionListener(listener);



        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, 1309, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Call the actionPerformed method
            MainLogin.this.actionPerformed(e);
        }
    };


    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == loginAndRegister1.getLogin().getButton1()) {
            // Remove the listener from the button to avoid recursion
            //loginAndRegister1.getLogin().getButton1().removeActionListener(listener);
            String username = loginAndRegister1.getLogin().getTxtUsername().getText();
            String password = new String(loginAndRegister1.getLogin().getPassword1().getPassword());
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
                    //JOptionPane.showMessageDialog(this, "yaaaay");
                    main.setVisible(false);
                    mainChefService.setVisible(true);
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







    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainLogin().setVisible(true);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LoginAndRegister loginAndRegister1;
    private javax.swing.JPanel main;
    // End of variables declaration//GEN-END:variables
}





//    public void actionPerformed(ActionEvent event) {
//        if (event.getSource() == loginAndRegister1.getLogin().getButton1()) {
//            // Remove the listener from the button to avoid recursion
//            //loginAndRegister1.getLogin().getButton1().removeActionListener(listener);
//            String username = loginAndRegister1.getLogin().getTxtUsername().getText();
//            String password = new String(loginAndRegister1.getLogin().getPassword1().getPassword());
//            String authToken = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
//
//            try {
//                URL url = new URL(LOGIN_URL + "/login");
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                connection.setRequestMethod("POST");
//                connection.setRequestProperty("Authorization", "Basic " + authToken);
//
//                int responseCode = connection.getResponseCode();
//
//                if (responseCode == HttpURLConnection.HTTP_OK) {
//                    // Authentication successful
//                    InputStream inputStream = connection.getInputStream();
//                    Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
//                    String response = scanner.hasNext() ? scanner.next() : "";
//
//                    Gson gson = new GsonBuilder().setLenient().create();
//                    JsonElement jsonElement = gson.fromJson(response, JsonElement.class);
//
//                    if (jsonElement.isJsonObject()) {
//                        JsonObject jsonObject = jsonElement.getAsJsonObject();
//                        boolean success = jsonObject.get("success").getAsBoolean();
//                        String message = jsonObject.get("message").getAsString();
//                        String role = jsonObject.get("role").getAsString();
//
//                        // Rest of the code as before
//
//                        if (success) {
//                            // Authentication successful
//                            dispose(); // Close the login window
//
//                            if ("admin".equals(role)) {
//                                // Open the admin window
//                                MainChefService chefServiceWindow = new MainChefService();
//                                chefServiceWindow.setVisible(true);
//                            } else if ("chef service".equals(role)) {
//                                // Open the user window
//                                Main adminWindow = new Main();
//                                adminWindow.setVisible(true);
//                            }
//
//                        } else {
//                            // Authentication failed
//                            JOptionPane.showMessageDialog(this, message);
//                        }
//                    } else {
//                        // Authentication failed
//                        JOptionPane.showMessageDialog(this, "Invalid username or password");
//                    }
//                } else {
//                    // Authentication failed
//                    JOptionPane.showMessageDialog(this, "Invalid username or password");
//                }
//
//                connection.disconnect();
//            } catch (Exception e) {
//                e.printStackTrace();
//                JOptionPane.showMessageDialog(this, "An error occurred. Please try again later.");
//            }
//
//        }
//    }





//    public void actionPerformed(ActionEvent event) {
//        if (event.getSource() == loginAndRegister1.getLogin().getButton1()) {
//            // Remove the listener from the button to avoid recursion
//            loginAndRegister1.getLogin().getButton1().removeActionListener(listener);
//            String username = loginAndRegister1.getLogin().getTxtUsername().getText();
//            String password = new String(loginAndRegister1.getLogin().getPassword1().getPassword());
//            String authToken = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
//
//            try {
//                URL url = new URL(LOGIN_URL + "/login");
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                connection.setRequestMethod("POST");
//                connection.setRequestProperty("Authorization", "Basic " + authToken);
//
//                int responseCode = connection.getResponseCode();
//
//                if (responseCode == HttpURLConnection.HTTP_OK) {
//                    // Authentication successful
//                    dispose(); // Close the login window
//
//                    // Query the user's job from the server
//                    URL jobUrl = new URL(LOGIN_URL + "/job/" + username);
//                    HttpURLConnection jobConnection = (HttpURLConnection) jobUrl.openConnection();
//                    jobConnection.setRequestMethod("GET");
//                    jobConnection.setRequestProperty("Authorization", "Basic " + authToken);
//
//                    int jobResponseCode = jobConnection.getResponseCode();
//                    String job = "";
//
//                    if (jobResponseCode == HttpURLConnection.HTTP_OK) {
//                        InputStream jobInputStream = jobConnection.getInputStream();
//                        job = new String(jobInputStream.readAllBytes(), StandardCharsets.UTF_8);
//                        System.out.println(job);
//                    }
//
//                    jobConnection.disconnect();
//
//                    // Open the appropriate window based on the user's job
//                    switch (job) {
//                        case "admin":
//                            MainChefService mainChefService = new MainChefService();
//                            mainChefService.setVisible(true);
//                            break;
//                        case "chef service":
//                            Main mainWaiterService = new Main();
//                            mainWaiterService.setVisible(true);
//                            break;
//                        default:
//                            JOptionPane.showMessageDialog(this, "Invalid job");
//                            break;
//                    }
//                } else {
//                    // Authentication failed
//                    JOptionPane.showMessageDialog(this, "Invalid username or password");
//                }
//
//                connection.disconnect();
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(this, "An error occurred. Please try again later.");
//            }
//        }
//    }



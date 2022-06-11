import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class LoginpageController {
    @FXML
    private PasswordField passfield;
    @FXML
    private TextField textfield;
    @FXML
    private Button loginButton;
    @FXML
    private Button createAccountButton;
    @FXML
    private Label errormessageLabel;


    public void goToCreateAccount() throws IOException {

        long startTime = System.nanoTime();

        Main m = new Main();
        m.changeScene("createAccount.fxml");

        long elapsedTime =System.nanoTime() - startTime;
        System.out.println("Time execution for function() in " + "millis:"+elapsedTime/1000000);


    }


    public void goToHomepage (javafx.event.ActionEvent actionEvent) throws IOException {

        long startTime = System.nanoTime();

        String username = textfield.getText();
        String password = passfield.getText();


        if (username.equals("") && !password.equals("")) {

            JOptionPane.showMessageDialog(null, "Empty Username Field");
        }
        else if (password.equals("") && !username.equals("")) {

            JOptionPane.showMessageDialog(null, "Empty Password Field");
        }

        else if (username.equals("") && password.equals("")) {

            JOptionPane.showMessageDialog(null, "Empty Username and Password Field");
        }

        else {

            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingsystem", "root", "NourNagah89");

                PreparedStatement pst = con.prepareStatement("SELECT * FROM user_accounts WHERE Username = ? and Password =?");

                pst.setString(1, username);
                pst.setString(2, password);

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    JOptionPane.showMessageDialog(null, "Login Successful");

                    try {

                        Class.forName("com.mysql.jdbc.Driver");

                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }

                    Connection conn = null;

                    try {

                        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingsystem", "root", "NourNagah89");

                        String query = "UPDATE user_accounts SET UserID = 1 WHERE Username = '" + username + "'";

                        PreparedStatement pst1 = conn.prepareStatement(query);
                        pst1.execute();


                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    Main m = new Main();
                    m.changeScene("Homepage.fxml");
                }

                else {

                    JOptionPane.showMessageDialog(null, "Login Unsuccessful");
                    textfield.setText("");
                    passfield.setText("");
                    textfield.requestFocus();
                }


            }
            catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginpageController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(LoginpageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        long elapsedTime =System.nanoTime() - startTime;
        System.out.println("Time execution for function() in " + "millis:"+elapsedTime/1000000);

    }


}

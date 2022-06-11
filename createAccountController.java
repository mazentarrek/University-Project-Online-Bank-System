import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class createAccountController {

    @FXML
    private TextField firstnametextfield;
    @FXML
    private TextField lastnametextfield;
    @FXML
    private TextField usernametextfield;
    @FXML
    private TextField phonenumbertextfield;
    @FXML
    private TextField accountnumbertextfield;
    @FXML
    private TextField emailtextfield;
    @FXML
    private TextField passwordtextfield;
    @FXML
    private Button registerAccountbutton;


    public void registerAccount() throws IOException {

        long startTime = System.nanoTime();

        try {
            ResultSet rs = null;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingsystem", "root", "NourNagah89");
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO user_accounts (AccountNum, UserID, Fname, Lname, Username, Password, PhoneNumber, Email) VALUES('" + accountnumbertextfield.getText() + "','" + "0" + "','" + firstnametextfield.getText() + "','" + lastnametextfield.getText() + "','" + usernametextfield.getText() + "','" + passwordtextfield.getText() + "','" + phonenumbertextfield.getText() + "','" + emailtextfield.getText()  + "');" ;
            stmt.executeUpdate(sql);
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        JOptionPane.showMessageDialog(null, "Registration Successful");

        Main m = new Main();
        m.changeScene("LoginPage.fxml");

        long elapsedTime =System.nanoTime() - startTime;
        System.out.println("Time execution for function() in " + "millis:"+elapsedTime/1000000);


    }

}

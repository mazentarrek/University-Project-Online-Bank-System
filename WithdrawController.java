import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;

import static java.lang.Integer.parseInt;

public class WithdrawController {

    @FXML
    private TextField amounttextfield;

    @FXML
    private Button submitButton;

    @FXML
    private Button backButton;

    public void backbuttonOnAction() throws IOException {
        Main m = new Main();
        m.changeScene("Homepage.fxml");
    }

    public void submitButtonOnAction() {

        try {

            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        Connection conn = null;

        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingsystem", "root", "NourNagah89");
            String query1 = "SELECT accountBalance FROM user_accounts, account_balances WHERE user_accounts.AccountNum = account_balances.AccountNum and UserID='1'";
            PreparedStatement pst1 = conn.prepareStatement(query1);
            ResultSet rs = pst1.executeQuery();

            while (rs.next()) {

                int accoutbalance = rs.getInt("accountBalance");

                if (parseInt(amounttextfield.getText()) > accoutbalance) {

                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                } else {
                    String query = "UPDATE account_balances SET accountBalance = accountBalance - " + amounttextfield.getText() + " WHERE AccountNum IN (SELECT AccountNum From user_Accounts WHERE UserID='1')";

                    PreparedStatement pst = conn.prepareStatement(query);
                    pst.execute();

                    JOptionPane.showMessageDialog(null, "Withdraw Successful");
                    Main m = new Main();
                    m.changeScene("Homepage.fxml");
                }
            }

                } catch(SQLException e){
                    e.printStackTrace();
                } catch(IOException e){
                    e.printStackTrace();
                }

                }
            }





import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;

import static java.lang.Integer.parseInt;

public class TransferMoneyController {

    @FXML
    private Button submitButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField accountNumberTextfield;

    @FXML
    private TextField amountTextfield;


    public void backbuttonOnAction () throws IOException {
        Main m = new Main();
        m.changeScene("Homepage.fxml");
    }

    public void submitButtonOnAction () {

        try {

            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        Connection conn = null;

        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingsystem", "root", "NourNagah89");

            String query0 = "SELECT accountBalance FROM user_accounts, account_balances WHERE user_accounts.AccountNum = account_balances.AccountNum and UserID='1'";
            PreparedStatement pst0 = conn.prepareStatement(query0);
            ResultSet rs = pst0.executeQuery();

            while (rs.next()) {

                int accoutbalance = rs.getInt("accountBalance");

                if (parseInt(amountTextfield.getText()) > accoutbalance) {

                    JOptionPane.showMessageDialog(null, "Insufficient Balance");

                } else {

                    String query1 = "UPDATE account_balances SET accountBalance = accountBalance + " + amountTextfield.getText() + " WHERE AccountNum = '" + accountNumberTextfield.getText()  + "'";
                    String query2 = "UPDATE account_balances SET accountBalance = accountBalance - " + amountTextfield.getText() + " WHERE AccountNum IN (SELECT AccountNum From user_Accounts WHERE UserID='1')";

                    PreparedStatement pst1 = conn.prepareStatement(query1);
                    pst1.execute();

                    PreparedStatement pst2 = conn.prepareStatement(query2);
                    pst2.execute();

                    JOptionPane.showMessageDialog(null, "Transfer Successful");
                    Main m = new Main();
                    m.changeScene("Homepage.fxml");

                }

                }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

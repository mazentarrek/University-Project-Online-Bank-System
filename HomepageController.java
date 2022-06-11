import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.sql.*;

public class HomepageController {

    @FXML
    private Button paybills;

    @FXML
    private Button BuyItems;

    @FXML
    private Button TransferMoney;

    @FXML
    private Button BankStatement;

    @FXML
    private Button withdrawButton;

    @FXML
    private Button depositButton;

    @FXML
    private Label accontbalanceLabel;

    @FXML
    private Button showBalanceButton;

    @FXML
    private Button LogOutButton;

    public void showBalanceButtonOnAction () throws IOException {

        try {

            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        Connection conn = null;
        try {

             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingsystem", "root", "NourNagah89");

             String query = "SELECT accountBalance FROM user_accounts, account_balances WHERE user_accounts.AccountNum = account_balances.AccountNum and UserID='1'";

             Statement st = conn.createStatement();

             ResultSet rs = st.executeQuery(query);

             while (rs.next()) {
                 accontbalanceLabel.setText(rs.getString("accountBalance"));
             }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


        public void goToPayBills() throws IOException {
        Main m = new Main();
        m.changeScene("Paybills.fxml");
    }

    public void goToTransferMoney() throws IOException {
        Main m = new Main();
        m.changeScene("TransferMoney.fxml");
    }

    public void goToBankStatement() throws IOException {
        Main m = new Main();
        m.changeScene("BankStatement.fxml");
    }

    public void goToBuyItems() throws IOException {
        Main m = new Main();
        m.changeScene("Buyitemss.fxml");
    }

    public void goToDeposit() throws IOException {

        Main m = new Main();
        m.changeScene("Deposit.fxml");

    }

        public void goToWithdraw() throws IOException {
            Main m = new Main();
            m.changeScene("Withdraw.fxml");
        }

    public void LogOutButtonOnAction () throws IOException {

        try {

            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        Connection conn = null;

        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingsystem", "root", "NourNagah89");
            //String query = "UPDATE user_accounts SET UserID = 0 WHERE Username = '" + username + "'";

            String query = "UPDATE user_accounts SET UserID = 0 WHERE UserID = '1'";

            PreparedStatement pst1 = conn.prepareStatement(query);
            pst1.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        Main m = new Main();
        m.changeScene("loginPage.fxml");
    }






}





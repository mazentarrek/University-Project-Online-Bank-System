import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Random;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class PayBillsController implements Initializable {

    @FXML
    private Button backButton;

    @FXML
    private Button submitButton;

    @FXML
    private Button showBillButton;

    @FXML
    private Label showBillLabel;

    @FXML
    private ChoiceBox Billcb;

    @FXML
    private TextField billtextfield;

    private String[] bills = {"Electrical Bill", "Water Bill", "Phone Bill", "Gas Bill", "Internet Bill"};


    Random rand = new Random();

    int globalvalue;

    public void initialize (URL arg0, ResourceBundle arg1) {

        Billcb.getItems().addAll(bills);

    }

    @FXML
    void backbuttonOnAction() throws IOException {

        Main m = new Main();
        m.changeScene("Homepage.fxml");

    }

    @FXML
    void showBillButtonOnAction() {

        if (Billcb.getValue() == "Electrical Bill") {
//            globalvalue = rand.nextInt(1000);
//            showBillLabel.setText("Due amount: " + globalvalue);
            showBillLabel.setText("Due amount: " + 500);
        }

        if (Billcb.getValue() == "Water Bill") {
//            globalvalue = rand.nextInt(1000);
//            showBillLabel.setText("Due amount: " + globalvalue);
            showBillLabel.setText("Due amount: " + 150);

        }

        if (Billcb.getValue() == "Phone Bill") {
//            globalvalue = rand.nextInt(1000);
//            showBillLabel.setText("Due amount: " + globalvalue);
            showBillLabel.setText("Due amount: " + 750);

        }

        if (Billcb.getValue() == "Gas Bill") {
//            globalvalue = rand.nextInt(1000);
//            showBillLabel.setText("Due amount: " + globalvalue);
            showBillLabel.setText("Due amount: " + 100);

        }

        if (Billcb.getValue() == "Internet Bill") {
//            globalvalue = rand.nextInt(1000);
//            showBillLabel.setText("Due amount: " + globalvalue);
            showBillLabel.setText("Due amount: " + 210);

        }

    }

    @FXML
    void submitButtonOnAction() {

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

                if (parseInt(billtextfield.getText()) > accoutbalance) {

                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                } else {

                    String query = "UPDATE account_balances SET accountBalance = accountBalance - " + billtextfield.getText() + " WHERE AccountNum IN (SELECT AccountNum From user_Accounts WHERE UserID='1')";

                    PreparedStatement pst = conn.prepareStatement(query);
                    pst.execute();

                    JOptionPane.showMessageDialog(null, "Transaction Successful");
                    showBillLabel.setText("Due amount: 0");

                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

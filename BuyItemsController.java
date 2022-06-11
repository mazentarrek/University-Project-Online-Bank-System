import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class BuyItemsController implements Initializable {

    @FXML
    private TextField amounttextfield;

    @FXML
    private RadioButton americaneaglerb;

    @FXML
    private RadioButton hmrb;

    @FXML
    private RadioButton zararb;

    @FXML
    private ChoiceBox certificatescb;

    @FXML
    private Button buycertificatesButton;

    @FXML
    private Button buypointsButton;

    @FXML
    private Button backButton;

    @FXML
    private Label showPointsLabel;

    private String[] certificates = {"Al Qimma Certificate of deposits (1000)","Taalt Harb Certificate of deposit(2000)","Certificates of deposit for 5 years with fixed interest(3000)"};


    public void initialize (URL arg0, ResourceBundle arg1) {

        certificatescb.getItems().addAll(certificates);

    }

    public void backbuttonOnAction () throws IOException {
        Main m = new Main();
        m.changeScene("Homepage.fxml");
    }

    public void showPointsOnAction () {

        try {

            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        Connection conn = null;
        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingsystem", "root", "NourNagah89");

            String query = "SELECT Points FROM user_accounts WHERE UserID='1' ";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                showPointsLabel.setText(rs.getString("Points"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    public void buyItemsButtonOnAction () {

        if (certificatescb.getValue() == "Al Qimma Certificate of deposits (1000)") {

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

                    if (1000 > accoutbalance) {

                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    } else {

                        String query = "UPDATE account_balances SET accountBalance = accountBalance - 1000 WHERE AccountNum IN (SELECT AccountNum From user_Accounts WHERE UserID='1')";

                        PreparedStatement pst = conn.prepareStatement(query);
                        pst.execute();

                        JOptionPane.showMessageDialog(null, "Transaction Successful");
                    }

                }


            } catch (SQLException e) {
                e.printStackTrace();
            }


        }


        else if (certificatescb.getValue() == "Taalt Harb Certificate of deposit(2000)" ) {

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

                if (2000 > accoutbalance) {

                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                } else {

                    String query = "UPDATE account_balances SET accountBalance = accountBalance - 2000 WHERE AccountNum IN (SELECT AccountNum From user_Accounts WHERE UserID='1')";

                    PreparedStatement pst = conn.prepareStatement(query);
                    pst.execute();

                    JOptionPane.showMessageDialog(null, "Transaction Successful");
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        }

        else if (certificatescb.getValue() == "Certificates of deposit for 5 years with fixed interest(3000)" ){
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

                    if (3000 > accoutbalance) {

                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    } else {

                        String query = "UPDATE account_balances SET accountBalance = accountBalance - 3000 WHERE AccountNum IN (SELECT AccountNum From user_Accounts WHERE UserID='1')";

                        PreparedStatement pst = conn.prepareStatement(query);
                        pst.execute();

                        JOptionPane.showMessageDialog(null, "Transaction Successful");
                    }
                }


                } catch (SQLException e) {
                e.printStackTrace();
                }


                }

        }


        public void buyPointsOnAction () {

            if (americaneaglerb.isSelected()) {

                try {

                    Class.forName("com.mysql.jdbc.Driver");

                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }

                Connection conn = null;

                try {

                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingsystem", "root", "NourNagah89");

                    String query0 = "SELECT Points FROM user_accounts WHERE UserID='1'";
                    PreparedStatement pst0 = conn.prepareStatement(query0);
                    ResultSet rs = pst0.executeQuery();

                    while (rs.next()) {

                        int points = rs.getInt("Points");

                        if (parseInt(amounttextfield.getText()) > points) {

                            JOptionPane.showMessageDialog(null, "Insufficient Point Balance");

                        } else {

                            String query = "UPDATE user_accounts SET Points = Points - " + amounttextfield.getText() + " WHERE UserID='1'";

                            PreparedStatement pst = conn.prepareStatement(query);
                            pst.execute();

                            JOptionPane.showMessageDialog(null, "Transaction Successful");

                        }
                        }

                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }


            else if (hmrb.isSelected()) {

                try {

                    Class.forName("com.mysql.jdbc.Driver");

                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }

                Connection conn = null;

                try {

                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingsystem", "root", "NourNagah89");

                    String query0 = "SELECT Points FROM user_accounts WHERE UserID='1'";
                    PreparedStatement pst0 = conn.prepareStatement(query0);
                    ResultSet rs = pst0.executeQuery();

                    while (rs.next()) {

                        int points = rs.getInt("Points");

                        if (parseInt(amounttextfield.getText()) > points) {

                            JOptionPane.showMessageDialog(null, "Insufficient Point Balance");

                        } else {

                            String query = "UPDATE user_accounts SET Points = Points - " + amounttextfield.getText() + " WHERE UserID='1'";

                            PreparedStatement pst = conn.prepareStatement(query);
                            pst.execute();

                            JOptionPane.showMessageDialog(null, "Transaction Successful");
                        }
                    }





                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

            else if (zararb.isSelected()){
                try {

                    Class.forName("com.mysql.jdbc.Driver");

                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }

                Connection conn = null;

                try {

                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingsystem", "root", "NourNagah89");

                    String query0 = "SELECT Points FROM user_accounts WHERE UserID='1'";
                    PreparedStatement pst0 = conn.prepareStatement(query0);
                    ResultSet rs = pst0.executeQuery();

                    while (rs.next()) {

                        int points = rs.getInt("Points");

                        if (parseInt(amounttextfield.getText()) > points) {

                            JOptionPane.showMessageDialog(null, "Insufficient Point Balance");

                        } else {

                            String query = "UPDATE user_accounts SET Points = Points - " + amounttextfield.getText() + " WHERE UserID = '1'";

                            PreparedStatement pst = conn.prepareStatement(query);
                            pst.execute();

                            JOptionPane.showMessageDialog(null, "Transaction Successful");
                        }
                    }


                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }

        }

    }


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class BankStatementController implements Initializable{


    @FXML
    private TableView<Person> Table;

    @FXML
    private TableColumn<Person, String> TransactionColumn;

    @FXML
    private TableColumn<Person, String> TransactionDescriptionC;

    @FXML
    private Label StatementLabel;

    @FXML
    private Button backButton;

    public void backbuttonOnAction () throws IOException {
        Main m = new Main();
        m.changeScene("Homepage.fxml");
    }


    ObservableList<Person> list = FXCollections.observableArrayList(
            new Person("Deposit","Amount=1000"),
            new Person("Withdraw","Amount=780"),
            new Person("Transfer Money","Transfer to Account 1234457, Amount =3800")
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TransactionColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("TransactionColumn"));
        TransactionDescriptionC.setCellValueFactory(new PropertyValueFactory<Person,String>("TransactionDescriptionC"));

        Table.setItems(list);
    }
}

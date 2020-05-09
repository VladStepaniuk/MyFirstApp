package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField signUpName;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button SignUpButton;

    @FXML
    private TextField loginField;

    @FXML
    private TextField signUpSurname;

    @FXML
    private TextField signUpCountry;

    @FXML
    private CheckBox signUpCheckBoxMale;

    @FXML
    private CheckBox signUpCheckBoxFemale;

    @FXML
    void initialize() {

        SignUpButton.setOnAction(event -> {
            signUpNewUser();

        });
    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String firstName=signUpName.getText();
        String lastName=signUpSurname.getText();
        String password=passwordField.getText();
        String location =signUpCountry.getText();
        String login = loginField.getText();
        String gender="";
        if(signUpCheckBoxMale.isSelected()){
            gender="Male";
        }
        else
            gender="Female";
        User user = new User(firstName, lastName, password, login, location, gender);
        dbHandler.signUpUser(user);
    }
}


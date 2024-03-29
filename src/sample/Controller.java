package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import animations.shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button authSignInButton;

    @FXML
    private Button loginSignInButton;

    @FXML
    void initialize() {
        authSignInButton.setOnAction(event -> {
            String loginText = loginField.getText().trim();
            String loginPassword = passwordField.getText().trim();
            if(!loginText.equals("")||loginPassword.equals(""))
                loginUser(loginText, loginPassword);
            else
                System.out.println("Login or password error.");
        });
    loginSignInButton.setOnAction(event -> {
        openNewScene("/sample/signUp.fxml");
    });};

    private void loginUser(String loginText, String loginPassword) {
        DatabaseHandler dbHandler=new DatabaseHandler();
        User user = new User();
        user.setUsername(loginText);
        user.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;
        while(true){
            try {
                if (!result.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            counter++;
        }

        if(counter>=1){
            openNewScene("/sample/app.fxml");
        }
        else {
            shake loginanimation = new shake(loginField);
            shake passwordAnimation = new shake(passwordField);
            loginanimation.playAnim();
            passwordAnimation.playAnim();
        }

    }
    public void openNewScene(String window){
            loginSignInButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(window));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        }
    }





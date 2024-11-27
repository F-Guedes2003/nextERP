package org.example.eprsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.eprsystem.exceptions.NonExistentUserException;
import org.example.eprsystem.models.User;
import org.example.eprsystem.service.DatabaseService;
import org.example.eprsystem.service.UserDatabaseManager;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class LoginController {
    @FXML TextField cnpjField;
    @FXML PasswordField passwordField;

    public void handleLogin() {
        var cnpj = cnpjField.getText();
        var password = passwordField.getText();
        DatabaseService service = new UserDatabaseManager();
        Optional<User> user = service.findOne(cnpj, password);

        changeToHome(
                user.orElseThrow(NonExistentUserException::new)
        );
    }

    private void changeToHome(User user) {
        var view = new HomeView();
        view.start(user);
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) cnpjField.getScene().getWindow();
        stage.close();
    }

    public void changeToSignup(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("signup.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}

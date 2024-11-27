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
import org.example.eprsystem.service.DatabaseService;
import org.example.eprsystem.service.UserDatabaseManager;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.Objects;

public class SignupController {
    @FXML TextField nameField;
    @FXML TextField cnpjField;
    @FXML PasswordField passwordField;
    @FXML PasswordField confirmPasswordField;

    public void completeSignup(ActionEvent event) {
        createUser();

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void createUser() {
        String name = nameField.getText();
        String cnpj = cnpjField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if(name.isEmpty() || cnpj.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showErrorModal();
        }

        if(password.equals(confirmPassword)) {
            DatabaseService service = new UserDatabaseManager();
            service.create(name, cnpj, password);
        }
        else {
            System.out.println("Passwords dont match");
        }
    }

    public void showErrorModal() {
        var view = new SignupErrorView();
        view.start();
    }
}
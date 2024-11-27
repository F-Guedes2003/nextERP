package org.example.eprsystem;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupErrorView {
    public void start() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("signupErrorView.fxml"));
            var stage = new Stage();
            var scene = new Scene(root);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}

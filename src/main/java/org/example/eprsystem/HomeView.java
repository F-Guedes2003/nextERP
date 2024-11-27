package org.example.eprsystem;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.eprsystem.models.User;

import java.io.IOException;
import java.util.Objects;

public class HomeView {
    public void start(User user) {
        FXMLLoader loader = new FXMLLoader();

        try {
            Parent root = loader.load(Objects.requireNonNull(getClass().getResource("home.fxml")).openStream());
            HomeController controller = loader.getController();
            controller.setUser(user);
            var stage = new Stage();
            var scene = new Scene(root);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException e) {
            System.err.println(e + "Failed to load the Home view");
        }
    }
}

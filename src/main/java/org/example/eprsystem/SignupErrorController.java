package org.example.eprsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SignupErrorController {
    @FXML Button btn;

    public void close() {
        var stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

}

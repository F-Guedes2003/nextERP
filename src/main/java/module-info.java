module org.example.eprsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.eprsystem to javafx.fxml;
    exports org.example.eprsystem;
}
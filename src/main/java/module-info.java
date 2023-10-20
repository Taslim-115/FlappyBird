module com.example.cse215lp {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.cse215lp to javafx.fxml;
    exports com.example.cse215lp;
}
module com.download {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.download to javafx.fxml;
    exports com.download;
}

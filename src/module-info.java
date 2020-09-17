module RequireFX.App {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens main;
    opens controller;
    opens model;
    opens view.css;
    opens view.fxml;
    opens view.images;
}
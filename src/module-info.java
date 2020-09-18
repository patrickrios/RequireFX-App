module RequireFX.App {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens main;
    opens controller;
    opens model.entity;
    opens model.exception;
    opens model.util;
    opens view.css;
    opens view.fxml;
    opens view.images;
}
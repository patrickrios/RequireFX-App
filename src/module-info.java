module RequireFX.App {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;

    opens main;
    opens controller;
    opens model.entity;
    opens model.exception;
    opens model.database;
    opens model.dao;
    opens model.util;
    opens view.css;
    opens view.fxml;
    opens view.images;
}
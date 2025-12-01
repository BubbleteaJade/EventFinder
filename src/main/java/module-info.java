module Frontend.eventfinder {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires javafx.base;
    requires javafx.graphics;
    requires com.google.gson;
    requires serpapi.client;

    opens Frontend.eventfinder to javafx.fxml;
    exports Frontend.eventfinder;
}
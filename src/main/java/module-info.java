module lotrgame {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires transitive javafx.media;
    requires transitive javafx.base;
    requires transitive javafx.graphics;
    
    
    requires java.desktop;

    requires lombok;

    requires com.jfoenix;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.materialdesign2;

    opens lotrgame.controller to javafx.fxml;
    opens lotrgame to javafx.graphics
    ;
    
    exports lotrgame.controller;
    exports lotrgame.model;
    exports lotrgame.utils;
}
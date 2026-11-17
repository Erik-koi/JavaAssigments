package com.example.javafxproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DictionaryView extends Application {

    @Override
    public void start(Stage stage) {
        DictionaryController controller = new DictionaryController();

        Label title = new Label("Virtual Dictionary");
        title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        TextField wordField = new TextField();
        wordField.setPromptText("Enter a word (e.g. apple)");
        wordField.setPrefColumnCount(24);

        Button searchButton = new Button("Search");

        TextArea meaningArea = new TextArea();
        meaningArea.setPromptText("The meaning will appear here.");
        meaningArea.setEditable(false);
        meaningArea.setWrapText(true);
        meaningArea.setPrefRowCount(4);

        Runnable search = () -> meaningArea.setText(controller.search(wordField.getText()));
        searchButton.setOnAction(event -> search.run());
        wordField.setOnAction(event -> search.run());

        FlowPane root = new FlowPane();
        root.setAlignment(Pos.CENTER_LEFT);
        root.setHgap(10);
        root.setVgap(12);
        root.setPadding(new Insets(24));
        root.setPrefWrapLength(420);
        root.getChildren().addAll(title, wordField, searchButton, meaningArea);

        stage.setTitle("Virtual Dictionary");
        stage.setScene(new Scene(root, 480, 300));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package com.hymir.xeoncalamity.core.windows;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Popup {


    public static void display()
    {
        Stage popupwindow=new Stage();

        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25,25,25,25));

        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("This is a pop up window");

        Label heading = new Label("Pop up window now displayed");

        Button cancelButton = new Button("Close this pop up window");



        Button createButton = new Button("Create Book");

        cancelButton.setOnAction(e -> popupwindow.close());

        root.add(heading, 1, 1, 1, 1);
        root.add(cancelButton, 1, 2, 1, 1);
        root.add(itemsEntry("title"), 1, 3, 1, 1);
        root.add(itemsEntry("author"), 1, 4, 1, 1);
        root.add(itemsEntry("page count"), 1, 5, 1, 1);
        root.add(itemsEntry("ISBN"), 1, 6, 1, 1);
        root.add(dateEntry("release date"),1,7,1,1);
        root.add(itemsEntry("checked out"), 1, 8, 1, 1);
        root.add(createButton, 1, 10, 1, 1);

        Scene scene1= new Scene(root, 600, 500);

        popupwindow.setScene(scene1);

        popupwindow.showAndWait();

    }

    private static GridPane itemsEntry(String itemCategory) {
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);

        Label label = new Label(itemCategory);
        TextField textField = new TextField();

        root.add(label, 1, 1, 1, 1);
        root.add(textField, 2, 1, 1, 1);

        return root;
    }

    private static GridPane dateEntry(String itemCategory) {
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);

        Label label = new Label(itemCategory);
        DatePicker datePicker = new DatePicker();

        root.add(label,1,1,1,1);
        root.add(datePicker,2,1,1,1);

        return root;

    }

}

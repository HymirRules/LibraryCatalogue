package com.hymir.xeoncalamity.core.util.windowbuilder;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class WindowBuilder {
    public static GridPane itemsEntry(String itemCategory) {
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);

        Label label = new Label(itemCategory);
        TextField textField = new TextField();

        root.add(label, 1, 1, 1, 1);
        root.add(textField, 2, 1, 1, 1);

        return root;
    }
    public static GridPane dateEntry(String itemCategory) {
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);

        Label label = new Label(itemCategory);
        DatePicker datePicker = new DatePicker();

        root.add(label,1,1,1,1);
        root.add(datePicker,2,1,1,1);

        return root;
    }
    public static GridPane booleanEntry(String itemCategory) {
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);

        Label label = new Label(itemCategory);
        CheckBox checkBox = new CheckBox();

        root.add(label, 1, 1, 1, 1);
        root.add(checkBox, 2, 1, 1, 1);

        return root;
    }
    public static VBox table(String itemName, String[] columnTitles) {
        VBox root = new VBox();
        root.setSpacing(5);
        root.setPadding(new Insets(10, 0, 0, 10));

        Label label = new Label(itemName);

        TableView table = new TableView();

        for (String columnTitle:columnTitles) {
            TableColumn tableColumn = new TableColumn(columnTitle);
            table.getColumns().add(tableColumn);
        }

        root.getChildren().addAll(label, table);

        return root;
    }
}

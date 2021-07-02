package com.hymir.xeoncalamity.core.util.windowbuilder;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class Table {

    private String title;
    private String[] columnTitles;
    private TableView table = new TableView();

    public Table(String title, String[] columnTitles) {
        this.title = title;
        this.columnTitles = columnTitles;
    }

    public VBox getElement() {
        VBox root = new VBox();
        root.setSpacing(5);
        root.setPadding(new Insets(10, 0, 0, 10));

        Label label = new Label(this.title);



        for (String columnTitle:columnTitles) {
            TableColumn tableColumn = new TableColumn(columnTitle);
            this.table.getColumns().add(tableColumn);
        }

        root.getChildren().addAll(label, this.table);

        return root;
    }

    public String getTitle() {
        return title;
    }

    public String[] getColumnTitles() {
        return columnTitles;
    }

    public TableView getTable() {
        return table;
    }
}

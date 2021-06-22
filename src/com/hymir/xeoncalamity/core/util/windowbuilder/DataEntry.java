package com.hymir.xeoncalamity.core.util.windowbuilder;

import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class DataEntry {
    private String title;
    private GridPane content;
    private TextField textField;
    private DatePicker datePicker;
    private CheckBox checkBox;

    public DataEntry() {
        this.setTitle("null");
        this.setContent(new GridPane());
    }

    public DataEntry(String title, InputDataCategory inputDataCategory) {
        this.setTitle(title);
        this.setContent(createContent(inputDataCategory));
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(GridPane content) {
        this.content = content;
    }

    public GridPane createContent(InputDataCategory inputDataCategory) {
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);

        Label label = new Label(this.title);

        root.add(label, 1, 1, 1, 1);

        switch (inputDataCategory) {
            case TEXT_DATA_CATEGORY -> {

                textField = new TextField();

                root.add(textField, 2, 1, 1, 1);

            }
            case DATE_DATA_CATEGORY -> {

                datePicker = new DatePicker();

                root.add(datePicker,2,1,1,1);

            }
            case BOOLEAN_DATA_CATEGORY -> {

                checkBox = new CheckBox();

                root.add(checkBox, 2, 1, 1, 1);

            }
        }

        return root;
    }

    public String getTitle() {
        return title;
    }

    public TextField getTextField() {
        return textField;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public GridPane getContent() {
        return content;
    }
}

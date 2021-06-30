package com.hymir.xeoncalamity.core.windows;

import com.hymir.xeoncalamity.core.util.Book;
import com.hymir.xeoncalamity.core.util.Library;
import com.hymir.xeoncalamity.core.util.windowbuilder.DataEntry;
import com.hymir.xeoncalamity.core.util.windowbuilder.InputDataCategory;
import com.hymir.xeoncalamity.core.util.windowbuilder.WindowBuilder;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Popup {


    public static void display(Library library)
    {
        Stage popupwindow=new Stage();

        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25,25,25,25));

        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("This is a pop up window");

        Label heading = new Label("Pop up window now displayed");

        Button cancelButton = new Button("Cancel");

        Button createButton = new Button("Create Book");

        cancelButton.setOnAction(e -> popupwindow.close());

        DataEntry bookTitle = new DataEntry("title", InputDataCategory.TEXT_DATA_CATEGORY);
        root.add(bookTitle.getContent(), 1, 3, 1, 1);

        DataEntry author = new DataEntry("author", InputDataCategory.TEXT_DATA_CATEGORY);
        root.add(author.getContent(), 1, 4, 1, 1);

        DataEntry pageCount = new DataEntry("page count", InputDataCategory.TEXT_DATA_CATEGORY);
        root.add(pageCount.getContent(), 1, 5, 1, 1);

        DataEntry ISBN = new DataEntry("ISBN", InputDataCategory.TEXT_DATA_CATEGORY);
        root.add(ISBN.getContent(), 1, 6, 1, 1);

        DataEntry releaseDate = new DataEntry("release date", InputDataCategory.DATE_DATA_CATEGORY);
        root.add(releaseDate.getContent(),1,7,1,1);

        DataEntry checkedOut = new DataEntry("checked out", InputDataCategory.BOOLEAN_DATA_CATEGORY);
        root.add(checkedOut.getContent(), 1, 8, 1, 1);

        createButton.setOnAction(e -> {
            try {
                Integer count = Integer.parseInt(pageCount.getTextField().getText());
                LocalDate localDate = releaseDate.getDatePicker().getValue();
                Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
                Date date = Date.from(instant);
                Book book = new Book(bookTitle.getTextField().getText(), author.getTextField().getText(), count,
                        ISBN.getTextField().getText(), date, checkedOut.getCheckBox().isSelected());
                library.addBook(book);
                popupwindow.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });



        root.add(heading, 1, 1, 1, 1);

        root.add(cancelButton, 1, 10, 1, 1);
        root.add(createButton, 2, 10, 1, 1);

        Scene scene1= new Scene(root, 600, 500);

        popupwindow.setScene(scene1);

        popupwindow.showAndWait();

    }

}

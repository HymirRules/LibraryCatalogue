package com.hymir.xeoncalamity.core.windows;

import com.hymir.xeoncalamity.core.util.Book;
import com.hymir.xeoncalamity.core.util.Library;
import com.hymir.xeoncalamity.core.util.controllers.PopupController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Edward Price
 * @version 1
 */

public class Popup {

    /**
     * displays the popup window with the prefilled data in the data fields
     * @param tableView the table of the main window
     * @param selectedBook the book that was selected in the table of the main window
     * @throws IOException
     */

    public void display(TableView tableView, Book selectedBook) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("editbookpopup.fxml"));
        ScrollPane frame = fxmlLoader.load();
        PopupController popupController = (PopupController) fxmlLoader.getController();

        popupController.tableView = tableView;
        popupController.initData(selectedBook);
        popupController.selectedBook = selectedBook;

        Stage popupwindow=new Stage();

        Scene scene = new Scene(frame, 600, 400);

        popupwindow.setTitle("Edit Book");
        popupwindow.setScene(scene);
        popupwindow.showAndWait();
    }

    public void display(TableView tableView) throws IOException {
        Library library = LibraryCatalogue.getLibrary();

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("newbookpopup.fxml"));
        ScrollPane frame = fxmlLoader.load();
        PopupController popupController = (PopupController) fxmlLoader.getController();

        popupController.tableView = tableView;


        Stage popupwindow=new Stage();

        Scene scene = new Scene(frame, 600, 400);

        popupwindow.setTitle("Book Entry");
        popupwindow.setScene(scene);
        popupwindow.showAndWait();
    }

    public void display(Book book) {

    }
}

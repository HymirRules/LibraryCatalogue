package com.hymir.xeoncalamity.core.util.controllers;

import com.hymir.xeoncalamity.core.util.Book;
import com.hymir.xeoncalamity.core.util.Library;
import com.hymir.xeoncalamity.core.windows.LibraryCatalogue;
import com.hymir.xeoncalamity.core.windows.Popup;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Edward Price
 * @version 1
 */

public class Controller {
    @FXML private TableView<Book> tableView;
    @FXML private TextField searchField;
    @FXML private Label errorBox;

    /**
     * initializes the window by loading in all the books stored in the books.json file into the table.
     */

    @FXML
    protected void initialize() {
        Library library = LibraryCatalogue.getLibrary();
        try {
            library.loadBooks();
        } catch (Exception e) {
            System.out.println(e);
        }

        ArrayList<Book> books = library.getBooks();
        ObservableList<Book> data = tableView.getItems();
        data.addAll(books);
    }

    /**
     * Opens the new book popup window, that allows a user to enter data for a new book
     * @throws IOException
     */

    @FXML
    public void openPopupWindow() throws IOException {
        Popup popup = new Popup();
        popup.display(tableView);
    }

    /**
     * Opens an edit book popup window, allowing the user to edit an already existing book
     */

    @FXML
    public void editEntry() {

        Popup popup = new Popup();

        try {

            popup.display(tableView, tableView.getSelectionModel().getSelectedItem());
        } catch (Exception e) {
            errorBox.setText("You must select an entry first");
        }

    }

    /**
     * Searches through the table checking search term against author name and book title
     */

    @FXML
    public void searchTable() {

        ArrayList<Book> searchedArrayList = new ArrayList<>();
        ObservableList<Book> searchedObservableList = tableView.getItems();

        for (Book book: tableView.getItems()
             ) {
            if (book.getAuthor().contains(searchField.getCharacters()) || book.getTitle().contains(searchField.getCharacters())) {
                searchedArrayList.add(book);
            }
        }

        searchedObservableList.setAll(searchedArrayList);

    }

    /**
     * resets the table to display all of the data
     */

    @FXML
    public void resetTable() {
        Library library = LibraryCatalogue.getLibrary();
        ArrayList<Book> defaultArraylist = library.getBooks();

        ObservableList<Book> defaultObservableList = tableView.getItems();

        defaultObservableList.setAll(defaultArraylist);

        searchField.setText("");

    }

    /**
     * allows the user to search and reset using enter and escape keys
     * @param keyEvent
     */

    @FXML
    public void keyPressed(javafx.scene.input.KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case ENTER -> {
                this.searchTable();
            }
            case ESCAPE -> {
                this.resetTable();
            }
        }
    }
}

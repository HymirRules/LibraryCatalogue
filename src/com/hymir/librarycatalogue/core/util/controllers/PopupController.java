package com.hymir.librarycatalogue.core.util.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hymir.librarycatalogue.core.util.Book;
import com.hymir.librarycatalogue.core.util.Library;
import com.hymir.librarycatalogue.core.windows.LibraryCatalogue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author HymirRules
 * @version 1
 */

public class PopupController {

    @FXML public TableView tableView;
    @FXML public Book selectedBook;

    @FXML private Button closeButton;

    @FXML private TextField bookTitleField, authorField, pageCountField, ISBNField;
    @FXML private DatePicker releaseDateField;
    @FXML private CheckBox checkedOutField;

    private final String saveFileLocation = "src/com/hymir/xeoncalamity/data/library/books.json";

    @FXML
    protected void initialize() {

    }

    /**
     * initializes data into the data fields for the popup window
     * @param book passes in a selected book from the table in the main window
     */

    @FXML
    public void initData(Book book) {
        bookTitleField.setText(book.getTitle());
        authorField.setText(book.getAuthor());
        String pageCount = String.valueOf(book.getPageCount());
        pageCountField.setText(pageCount);
        ISBNField.setText(book.getISBN());
        checkedOutField.setSelected(book.isCheckedOut());
    }

    /**
     * Allows the changing of a book, it creates a new book replacing the old one in the data
     * @param event
     * @throws IOException
     */

    @FXML
    protected void changeBook(ActionEvent event) throws IOException {
        ObservableList<Book> data = tableView.getItems();

        Library library = LibraryCatalogue.getLibrary();

        Book book = newBook();

        library.getBooks().remove(selectedBook);

        data.remove(selectedBook);

        library.addBook(book);
        data.add(book);

        save(library);
    }

    /**
     * Adds a new book to the data
     * @param event
     * @throws IOException
     */

    @FXML
    protected void addBook(ActionEvent event) throws IOException {

        ObservableList<Book> data = tableView.getItems();

        Library library = LibraryCatalogue.getLibrary();

        Book book = newBook();

        library.addBook(book);
        data.add(book);


        save(library);
    }

    /**
     * creates a new book based on the values in the data fields of the popup window
     * @return the new book
     */

    protected Book newBook() {
        int pageCount = Integer.parseInt(pageCountField.getText());

        LocalDate localDate = releaseDateField.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);

        return new Book(
                bookTitleField.getText(),
                authorField.getText(),
                pageCount,
                ISBNField.getText(),
                date,
                checkedOutField.isSelected()
        );
    }

    /**
     * saves the library to the json file
     * @param library passes in a library object
     * @throws IOException
     */

    protected void save(Library library) throws IOException {

        try (Writer writer = new FileWriter(saveFileLocation)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(library.getBooks(), writer);
        }

    }

    /**
     * closes the window
     */

    @FXML
    protected void closeWindow() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}

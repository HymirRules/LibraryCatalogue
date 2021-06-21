package com.hymir.xeoncalamity.core.windows;

import com.hymir.xeoncalamity.core.util.Library;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LibraryCatalogue extends Application {

    private TableView table = new TableView();
    private Library library = new Library();

    public LibraryCatalogue() {

    }

    @Override
    public void start(Stage stage) {
        Label heading = new Label("Library Catalogue");
        heading.setFont(new Font(100));
        stage.setTitle("Library Catalogue");

        GridPane root = new GridPane();

        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25,25,25,25));

        TextField searchInput = new TextField();

        Button searchButton = new Button("Search");
        searchButton.setOnAction(e -> this.library.searchEvent(searchInput.getCharacters().toString()));

        Button createBookButton = new Button("Create Book");
        createBookButton.setOnAction(e -> Popup.display());

        final Label label = new Label("Books");

        TableColumn bookTitleCol = new TableColumn("Title");
        TableColumn authorCol = new TableColumn("Author");
        TableColumn pageCountCol = new TableColumn("Page Count");
        TableColumn isbnCol = new TableColumn("ISBN");
        TableColumn releaseDateCol = new TableColumn("Release Date");
        TableColumn checkedOutCol = new TableColumn("Checked Out");

        table.getColumns().addAll(bookTitleCol, authorCol, pageCountCol, isbnCol, releaseDateCol, checkedOutCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        root.add(heading, 0, 0, 1, 1);
        root.add(searchInput, 0, 1, 1, 1);
        root.add(searchButton, 1, 1, 1, 1);
        root.add(createBookButton, 1, 2, 1, 1);
        root.add(vbox, 0, 2, 1, 1);

        Scene scene = new Scene(root, 1280, 720);

        heading.setId("heading");
        searchInput.setId("searchInput");
        searchButton.setId("searchButton");
        scene.getStylesheets().add(LibraryCatalogue.class.getResource("styling.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

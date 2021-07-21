package com.hymir.xeoncalamity.core.windows;

import com.hymir.xeoncalamity.core.util.Library;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Edward Price
 * @version 1
 */

public class LibraryCatalogue extends Application {

    private static final Library library = new Library();


    public LibraryCatalogue() {

    }

    /**
     * A getter to return the library
     * @return returns the library that can then be used elesewhere in the program such as in the controllers
     */

    public static Library getLibrary() {
        return library;
    }

    /**
     * Starts the main window
     * @param stage the reference to the window
     * @throws Exception avoids an IO exception crashing the program
     */

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("fxml/xeoncalamitygui.fxml"));

        Scene scene = new Scene(root, 800, 500);

        stage.setTitle("Library Catalogue");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package com.hymir.xeoncalamity.core.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Library {

    private List<Book> books = new ArrayList<Book>();

    public Library() {

    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void loadBooks() {
        try {
            Gson gson = new Gson();

            Reader reader = Files.newBufferedReader(Paths.get("books.json"));

            this.books = new Gson().fromJson(reader, new TypeToken<List<Book>>() {}.getType());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchEvent(String searchTerm) {
        try {

            Writer writer = new FileWriter("src/com/hymir/xeoncalamity/data/library/books.json");

            new Gson().toJson(books, writer);

            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveBook(String title, String author, int pageCount, String ISBN, Date releaseDate, boolean checkedOut) {
        Book book = new Book(title, author, pageCount, ISBN, releaseDate, checkedOut);
        Gson gson = new Gson();
        gson.toJson(book);
    }
}

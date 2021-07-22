package com.hymir.librarycatalogue.core.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author HymirRules
 * @version 1
 */

public class Library {

    private ArrayList<Book> books;
    private int currentLibraryIdentifier;

    public Library() {
        this.books = new ArrayList<Book>();
    }

    /**
     * sets the library identifier
     * @param currentLibraryIdentifier
     */

    public void setCurrentLibraryIdentifier(int currentLibraryIdentifier) {
        this.currentLibraryIdentifier = currentLibraryIdentifier;
    }

    /**
     * adds a book to the books arraylist
     * @param book
     */

    public void addBook(Book book) {
        this.books.add(book);
    }

    /**
     * loads books into the books array from the file
     */

    public void loadBooks() {
        try {
            Reader reader = Files.newBufferedReader(Paths.get("src/com/hymir/xeoncalamity/data/library/books.json"));

            this.books = new Gson().fromJson(reader, new TypeToken<List<Book>>() {}.getType());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return the current library identifier
     */
    
    public int getCurrentLibraryIdentifier() {
        int currentToReturn;
        if (this.currentLibraryIdentifier == 0) {
            this.currentLibraryIdentifier += 1;
            currentToReturn = this.currentLibraryIdentifier;
        } else {
            currentToReturn = this.currentLibraryIdentifier;
            this.currentLibraryIdentifier += 1;
        }

        return currentToReturn;
    }

    /**
     * returns the books arraylist
     * @return
     */

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    /**
     * removes the defined book from the books arraylist
     * @param book
     */

    public void removeBook(Book book) {
        this.books.remove(book);
    }
}

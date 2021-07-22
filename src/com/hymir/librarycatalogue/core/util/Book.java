package com.hymir.librarycatalogue.core.util;

import com.hymir.librarycatalogue.core.windows.LibraryCatalogue;

import java.util.Date;

/**
 * @author HymirRules
 * @version 1
 */

public class Book {
    private String title;
    private String author;
    private int pageCount;
    private int libraryIdentifier;
    private String ISBN;
    private Date releaseDate;
    private boolean checkedOut;

    /**
     * tenDigitISBN is a constant that defines the date when the standards for ISBN changed from ten digits to thirteen
     * digits.
     */
    private final Date tenDigitISBN = new Date(1167609600000L);

    /**
     * Constructor for the Book class
     * @param title title for the book
     * @param author author of the book
     * @param pageCount number of pages in the book
     * @param ISBN the standard identifying number of the book
     * @param releaseDate date that the book was released
     * @param checkedOut whether or not the book has been checked out
     */

    public Book(String title, String author, int pageCount, String ISBN, Date releaseDate, boolean checkedOut) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPageCount(pageCount);
        this.setReleaseDate(releaseDate);
        this.setISBN(ISBN);
        this.setCheckedOut(checkedOut);

        Library library = LibraryCatalogue.getLibrary();
        this.setLibraryIdentifier(library.getCurrentLibraryIdentifier());

    }

    /**
     * sets the title of the book object
     * @param title
     */

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * sets the author of the book object
     * @param author
     */

    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * sets the page count and checks to make sure that the number of pages is positive
     * @param pageCount
     */

    public void setPageCount(int pageCount) {
        if (pageCount > 0) {
            this.pageCount = pageCount;
        } else {
            System.out.println("You cannot set a negative number of pages for a book");
        }
    }

    /**
     * Sets the ISBN for the book, checks that the correct ISBN format is used for the date that the book was released.
     * @param ISBN
     */

    public void setISBN(String ISBN) {

        if (this.releaseDate.before(tenDigitISBN)) {
            if (ISBN.length() == 10) {
                this.ISBN = ISBN;
            } else {
                System.out.println("A ten digit ISBN is standard for books published before 01/01/2007");
            }
        } else {
            if (ISBN.length() == 13) {
                this.ISBN = ISBN;
            } else {
                System.out.println("A thirteen digit ISBN is standard for books published on and after 01/01/2007");
            }
        }

    }

    /**
     * sets the release date for the book object
     * @param releaseDate
     */

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * sets whether the book has been checked out
     * @param checkedOut
     */

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    /**
     * sets the library identifier of the book
     * @param libraryIdentifier
     */

    public void setLibraryIdentifier(int libraryIdentifier) {
        this.libraryIdentifier = libraryIdentifier;
    }

    /**
     * returns the release date for the book object
     * @return
     */

    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * returns the value of the tenDigitISBN constant
     * @return
     */

    public Date getTenDigitISBN() {
        return tenDigitISBN;
    }

    /**
     * returns the library identifier of the book
     * @return
     */

    public int getLibraryIdentifier() {
        return libraryIdentifier;
    }

    /**
     * returns the page count of the book object
     * @return
     */

    public int getPageCount() {
        return pageCount;
    }

    /**
     * returns the author of the book object
     * @return
     */

    public String getAuthor() {
        return author;
    }

    /**
     * returns the ISBN of the book object
     * @return
     */

    public String getISBN() {
        return ISBN;
    }

    /**
     * returns the title of the book object
     * @return
     */

    public String getTitle() {
        return title;
    }

    /**
     * returns the boolean of whether the book has been checked out
     * @return
     */

    public boolean isCheckedOut() {
        return checkedOut;
    }
}


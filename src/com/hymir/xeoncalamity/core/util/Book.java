package com.hymir.xeoncalamity.core.util;

import java.util.Date;

public class Book {
    private String title;
    private String author;
    private int pageCount;
    private String ISBN;
    private Date releaseDate;
    private boolean checkedOut;

    /**
     * tenDigitISBN is a constant that defines the date when the standards for ISBN changed from ten digits to thirteen
     * digits.
     */
    private final Date tenDigitISBN = new Date(1167609600000L);

//    Book() {
//        this.setTitle("NO_TITLE");
//        this.setPageCount(0);
//        this.setISBN("NO_ISBN_AVAILABLE");
//        this.setCheckedOut(false);
//    }

    Book(String title, String author, int pageCount, String ISBN, boolean checkedOut, Date releaseDate) {
        this.setTitle(title);
        this.setPageCount(pageCount);
        this.setReleaseDate(releaseDate);
        this.setISBN(ISBN);
        this.setCheckedOut(checkedOut);
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}

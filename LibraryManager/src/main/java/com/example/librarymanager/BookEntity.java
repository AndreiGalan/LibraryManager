package com.example.librarymanager;


public class BookEntity {
    private int bookId;
    private String bookTitle;
    private String authorName;
    private String genre;

    public BookEntity(){

    }

    public BookEntity(String bookTitle, String authorName, String genre) {
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.genre = genre;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Title: " + bookTitle + ", Author: " + authorName + ", Genre: " + genre;
    }
}

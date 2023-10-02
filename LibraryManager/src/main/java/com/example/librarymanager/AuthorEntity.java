package com.example.librarymanager;

public class AuthorEntity {
    private String authorName;

    public AuthorEntity(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}

package com.example.librarymanager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryManagementApp {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Library";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "123456";
    private static Connection connection;

    public LibraryManagementApp() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static int addBook(String title, String authorName, String genre) throws SQLException {
        CallableStatement statement = connection.prepareCall("{? = call add_book(?, ?, ?)}");
        statement.registerOutParameter(1, Types.INTEGER);
        statement.setString(2, title);
        statement.setString(3, authorName);
        statement.setString(4, genre);
        statement.execute();

        return statement.getInt(1);
    }

    public static List<BookEntity> searchBooksByAuthor(String authorName) throws SQLException {
        CallableStatement statement = connection.prepareCall("{call search_books_by_author(?)}");
        statement.setString(1, authorName);
        ResultSet resultSet = statement.executeQuery();

        List<BookEntity> books = new ArrayList<>();

        while (resultSet.next()) {
            int bookId = resultSet.getInt("book_id");
            String bookTitle = resultSet.getString("book_title");
            String bookAuthor = resultSet.getString("author_name");
            String bookGenre = resultSet.getString("genre");
            System.out.println("Book ID: " + bookId + ", Title: " + bookTitle + ", Genre: " + bookGenre);
            books.add(new BookEntity(bookTitle, bookAuthor, bookGenre));
        }

        resultSet.close();
        return books;
    }

    public static String deleteBook(int bookId) throws SQLException {
        CallableStatement statement = connection.prepareCall("{ ? = call delete_book(?) }");
        statement.registerOutParameter(1, Types.VARCHAR);
        statement.setInt(2, bookId);
        statement.execute();

        return statement.getString(1);
    }

    public static void borrowBook(String bookTitle, String readerName) throws SQLException {
        CallableStatement statement = connection.prepareCall("{call borrow_book(?, ?)}");
        statement.setString(1, bookTitle);
        statement.setString(2, readerName);
        statement.execute();
    }



    public static void returnBook(String booTitle) throws SQLException {
        CallableStatement statement = connection.prepareCall("{call return_book(?)}");
        statement.setString(1, booTitle);
        statement.execute();
    }

    public static int addAuthor(String author) throws SQLException {
        CallableStatement statement = connection.prepareCall("{? = call add_author(?)}");
        statement.registerOutParameter(1, Types.INTEGER);
        statement.setString(2, author);
        statement.execute();

        int authorId = statement.getInt(1);

        return authorId;
    }

    public static List<BookEntity> searchByGenre(String genre) throws SQLException{
        CallableStatement statement = connection.prepareCall("{call search_books_by_genre(?)}");
        statement.setString(1, genre);
        ResultSet resultSet = statement.executeQuery();

        List<BookEntity> books = new ArrayList<>();

        while (resultSet.next()) {
            int bookId = resultSet.getInt("book_id");
            String bookTitle = resultSet.getString("book_title");
            String bookAuthor = resultSet.getString("author_name");
            String bookGenre = resultSet.getString("genre");
            System.out.println("Book ID: " + bookId + ", Title: " + bookTitle + ", Genre: " + bookGenre);
            books.add(new BookEntity(bookTitle, bookAuthor, bookGenre));
        }

        resultSet.close();
        return books;
    }
    public static List<BookEntity> searchBookByTitle(String genre) throws SQLException{
        CallableStatement statement = connection.prepareCall("{call search_book_by_title(?)}");
        statement.setString(1, genre);
        ResultSet resultSet = statement.executeQuery();

        List<BookEntity> books = new ArrayList<>();

        while (resultSet.next()) {
            int bookId = resultSet.getInt("book_id");
            String bookTitle = resultSet.getString("book_title");
            String bookAuthor = resultSet.getString("author_name");
            String bookGenre = resultSet.getString("genre");
            System.out.println("Book ID: " + bookId + ", Title: " + bookTitle + ", Genre: " + bookGenre);
            books.add(new BookEntity(bookTitle, bookAuthor, bookGenre));
        }

        resultSet.close();
        return books;
    }

    public static void deleteBookByTitle(String title) throws SQLException{
        CallableStatement statement = connection.prepareCall("{call delete_book_by_title(?)}");
        statement.setString(1, title);
        statement.execute();
    }
}



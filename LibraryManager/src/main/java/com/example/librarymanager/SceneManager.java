package com.example.librarymanager;

import com.example.librarymanager.Controller.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.Connection;
import java.util.Objects;

public class SceneManager {

    private Stage stage;
    private LibraryManagementApp libraryManagementApp;

    public SceneManager(Stage stage,LibraryManagementApp libraryManagementApp){
        this.stage = stage;
        this.libraryManagementApp = libraryManagementApp;
        stage.initStyle(StageStyle.UNDECORATED);
    }


    public void showMainMenu(){
        try{
            URL resourceUrl = getClass().getResource("hello-view.fxml");
            System.out.println("Resource URL: " + resourceUrl);
            FXMLLoader loader = new FXMLLoader(resourceUrl);

            Parent root = loader.load();
            Scene scene = new Scene(root);
            MenuController mainMenuController = loader.getController();
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
            mainMenuController.setSceneManager(this);

            stage.setTitle("Hello!");
            //stage.initStyle(StageStyle.UNDECORATED); // EXCEPTION : java.lang.IllegalStateException: Cannot set style once stage has been set visible
            stage.setScene(scene);
            stage.show();
            System.out.println("loader = " + loader);


        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void showAddAuthor() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("add-a-author.fxml"));
            Parent root = loader.load();
            AddAuthorController addAuthorController = loader.getController();
            addAuthorController.setSceneManager(this);

            Scene scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());

            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void showAddBook() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("add-a-book.fxml"));
            Parent root = loader.load();
            AddBookController addBookController = loader.getController();
            addBookController.setSceneManager(this);

            Scene scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());

            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void showBorrowBook() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("borrow-a-book.fxml"));
            Parent root = loader.load();
            BorrowBookController borrowBookController = loader.getController();
            borrowBookController.setSceneManager(this);

            Scene scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());

            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void showReturnBook() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("return-a-book.fxml"));
            Parent root = loader.load();
            ReturnBookController returnBookController = loader.getController();
            returnBookController.setSceneManager(this);

            Scene scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());

            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void showSearchAuthor() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("search-by-author.fxml"));
            Parent root = loader.load();
            SearchAuthorController searchAuthorController = loader.getController();
            searchAuthorController.setSceneManager(this);

            Scene scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());

            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void showSearchGenre(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("search-by-genre.fxml"));
            Parent root = loader.load();
            SearchGenreController searchGenreController = loader.getController();
            searchGenreController.setSceneManager(this);

            Scene scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());

            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void showSearchTitle(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("search-by-title.fxml"));
            Parent root = loader.load();
            SearchTitleController searchTitleController = loader.getController();
            searchTitleController.setSceneManager(this);

            Scene scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());

            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void showDeleteBook(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("delete-book.fxml"));
            Parent root = loader.load();
            DeleteBookController deleteBookController = loader.getController();
            deleteBookController.setSceneManager(this);

            Scene scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());

            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void showPopUp(String message) {
        Dialog<Void> dialog = new Dialog<>();
        dialog.initOwner(stage);
        dialog.setTitle("Pop-up");

        DialogPane dialogPane = new DialogPane();
        dialogPane.setContentText(message);
        dialogPane.getButtonTypes().add(javafx.scene.control.ButtonType.OK);

        dialog.setDialogPane(dialogPane);
        dialog.showAndWait();
    }

    public LibraryManagementApp getLibraryManagementApp() {
        return libraryManagementApp;
    }
}

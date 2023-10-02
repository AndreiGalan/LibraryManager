package com.example.librarymanager.Controller;

import com.example.librarymanager.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuController {

    private SceneManager sceneManager;

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @FXML
    private Button xButton;

    @FXML
    private AnchorPane topAnchorPane;

    @FXML
    private Button addBookButton;

    @FXML
    private Button addAuthorButton;

    @FXML
    private Button searchGenreButton;

    @FXML
    private Button searchAuthorButton;

    @FXML
    private Button borrowButton;

    @FXML
    private Button returnButton;

    @FXML Button searchTitleButton;

    @FXML
    private Button delete;

    @FXML
    private Button minButton;



    @FXML
    private void initialize() {;
        topAnchorPane.setOnMousePressed(e -> topAnchorPane.setOnMouseDragged(e2 -> {
            Stage stage = (Stage) topAnchorPane.getScene().getWindow();
            stage.setX(e2.getScreenX() - e.getSceneX());
            stage.setY(e2.getScreenY() - e.getSceneY());
        }));
    }

    public void xButtonAction() {
        System.out.println("X Button Pressed");
        Stage stage = (Stage) xButton.getScene().getWindow();
        stage.close();
    }

    public void addBookButtonAction() {
        sceneManager.showAddBook();
    }

    public void addAuthorButtonAction() {
        sceneManager.showAddAuthor();
    }

    public void searchGenreButtonAction() {
        sceneManager.showSearchGenre();
    }

    public void searchAuthorButtonAction() {
        sceneManager.showSearchAuthor();
    }

    public void borrowButtonAction() {
        sceneManager.showBorrowBook();
    }

    public void returnButtonAction() {
        sceneManager.showReturnBook();
    }

    public void searchTitleButtonAction() {
        sceneManager.showSearchTitle();
    }

    public void deleteButtonAction() {
        sceneManager.showDeleteBook();
    }

    public void minButtonAction() {
        Stage stage = (Stage) minButton.getScene().getWindow();
        stage.setIconified(true);
    }
}
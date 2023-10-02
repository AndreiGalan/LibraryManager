package com.example.librarymanager.Controller;

import com.example.librarymanager.LibraryManagementApp;
import com.example.librarymanager.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;

public class AddBookController {
    private SceneManager sceneManager;
    private Connection connection;
    private LibraryManagementApp libraryManagementApp;

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
        this.libraryManagementApp = sceneManager.getLibraryManagementApp();
    }

    @FXML
    private Button xButton;

    @FXML
    private AnchorPane topAnchorPane;

    @FXML
    private Button submitButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField author;

    @FXML
    private TextField genre;

    @FXML
    private TextField title;

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

    public void submitButtonAction() {
        if(!checkIfValid()){
            sceneManager.showPopUp("Please fill all fields");
            if(title.getText().isEmpty())
                title.setStyle("-fx-border-color: red");
            else
                title.setStyle("-fx-border-color: none");
            if(author.getText().isEmpty())
                author.setStyle("-fx-border-color: red");
            else
                author.setStyle("-fx-border-color: none");
            if(genre.getText().isEmpty())
                genre.setStyle("-fx-border-color: red");
            else
                genre.setStyle("-fx-border-color: none");
            return;
        }
        else{
            try{
                libraryManagementApp.addBook(title.getText(), author.getText(), genre.getText());
                sceneManager.showPopUp("Book added successfully");
            }
            catch (SQLException e){
                System.out.println("Error adding author");
                String errorMessage = e.getMessage();
                errorMessage = errorMessage.substring(0, errorMessage.indexOf("\n"));
                sceneManager.showPopUp(errorMessage);
                return;
            }
        }
        sceneManager.showMainMenu();
    }

    public void backButtonAction() {
        System.out.println("Back Button Pressed");
        sceneManager.showMainMenu();
    }

    public boolean checkIfValid() {
        if (title.getText().isEmpty() || author.getText().isEmpty() || genre.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    public void minButtonAction() {
        Stage stage = (Stage) minButton.getScene().getWindow();
        stage.setIconified(true);
    }
}

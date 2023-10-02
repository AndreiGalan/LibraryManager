package com.example.librarymanager.Controller;

import com.example.librarymanager.LibraryManagementApp;
import com.example.librarymanager.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.SQLException;

public class ReturnBookController {
    private SceneManager sceneManager;
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
    private Button backButton;

    @FXML
    private Button submitButton;

    @FXML
    private TextField bookName;

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

    public void backButtonAction() {
        System.out.println("Back Button Pressed");
        sceneManager.showMainMenu();
    }

    public void submitButtonAction() {
        if(isBookNameValid()) {
            try{
                libraryManagementApp.returnBook(bookName.getText());
                sceneManager.showPopUp("Return successful");
            }
            catch (SQLException e){
                System.out.println("Error adding author");
                String errorMessage = e.getMessage();
                errorMessage = errorMessage.substring(0, errorMessage.indexOf("\n"));
                sceneManager.showPopUp(errorMessage);
                return;
            }
        }
        else {
            sceneManager.showPopUp("Please enter a book name");
            bookName.setStyle("-fx-border-color: red");
            return;
        }
        sceneManager.showMainMenu();
    }

    public boolean isBookNameValid() {
        return !bookName.getText().isEmpty();
    }

    public void minButtonAction() {
        Stage stage = (Stage) minButton.getScene().getWindow();
        stage.setIconified(true);
    }
}

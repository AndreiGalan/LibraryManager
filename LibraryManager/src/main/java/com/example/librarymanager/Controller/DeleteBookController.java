package com.example.librarymanager.Controller;

import com.example.librarymanager.LibraryManagementApp;
import com.example.librarymanager.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.SQLException;

public class DeleteBookController {
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
    private Button submitButton;

    @FXML
    private Button backButton;

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

    public void submitButtonAction() throws SQLException {
        if(!checkIfValid()){
            title.setStyle("-fx-border-color: red");
            return;
        }
        else{
            try{
                libraryManagementApp.deleteBookByTitle(title.getText());
                sceneManager.showPopUp("Book deleted successfully");
            }
            catch (SQLException e){
                System.out.println("Error adding author");
                System.out.println(e.getMessage());
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

    public boolean checkIfValid(){
        if(title.getText().isEmpty()){
            sceneManager.showPopUp("Please enter a title");
            return false;
        }
        return true;
    }

    public void minButtonAction() {
        Stage stage = (Stage) minButton.getScene().getWindow();
        stage.setIconified(true);
    }
}

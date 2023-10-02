package com.example.librarymanager.Controller;

import com.example.librarymanager.BookEntity;
import com.example.librarymanager.LibraryManagementApp;
import com.example.librarymanager.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.List;

public class SearchAuthorController {
    private SceneManager sceneManager;
    LibraryManagementApp libraryManagementApp;

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
    private Button searchButton;

    @FXML
    private TextField searchField;

    @FXML
    private ListView<BookEntity> bookList;

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

    public void searchButtonAction() {
        System.out.println("Search Button Pressed");
        if(!checkIfValid()){
            searchField.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
            return;
        }
        else{
            try{
                searchField.setStyle("-fx-border-color: none ; -fx-border-width: none ;");
                List<BookEntity> bookEntities = libraryManagementApp.searchBooksByAuthor(searchField.getText());

                System.out.println("Books found: " + bookEntities);
                if (bookEntities.size() == 0){
                    sceneManager.showPopUp("No books found");
                    return;
                }

                bookList.getItems().clear();
                bookList.getItems().addAll(bookEntities);
            }
            catch (SQLException e){
                String errorMessage = e.getMessage();
                errorMessage = errorMessage.substring(0, errorMessage.indexOf("\n"));
                sceneManager.showPopUp(errorMessage);
                return;
            }
        }
    }

    public boolean checkIfValid(){
        if(searchField.getText().isEmpty()){
            sceneManager.showPopUp("Please enter a valid author name");
            return false;
        }
        return true;
    }

    public void minButtonAction() {
        Stage stage = (Stage) minButton.getScene().getWindow();
        stage.setIconified(true);
    }
}

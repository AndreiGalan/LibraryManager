package com.example.librarymanager;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;


public class LibraryManager extends Application {

    @Override
    public void start(Stage stage) throws IOException {
            LibraryManagementApp libraryManagementApp = new LibraryManagementApp();
            SceneManager sceneManager = new SceneManager(stage, libraryManagementApp);
            sceneManager.showMainMenu();
    }

    public static void main(String[] args) {
            launch(args);
    }
}
package com.example.sodoku;


import com.example.sodoku.view.WelcomeStage;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    // Método start que inicializa la aplicación JavaFX
    @Override
    public void start(Stage PrimaryStage) throws IOException {
        WelcomeStage.getInstance();// Inicia la ventana de bienvenida
    }
}

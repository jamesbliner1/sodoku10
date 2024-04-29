package com.example.sodoku.controller;



import com.example.sodoku.model.Word;
import com.example.sodoku.view.GameStage;
import com.example.sodoku.view.WelcomeStage;
import com.example.sodoku.view.alert.AlertBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;


// Controlador para la ventana de bienvenida
public class WelcomeController {
    private String namePlayer;// Variable para almacenar la palabra secreta

    @FXML
    private TextField nameTextField;// Campo de texto para ingresar la palabra secreta

    // Método que maneja el evento del botón "Jugar"
    @FXML
    void onHandlerButtonPlay(ActionEvent event) throws IOException {
        namePlayer = nameTextField.getText();// Obtiene la palabra ingresada por el usuario

        // Verifica si la palabra contiene solo letras (sin caracteres especiales)
        if (namePlayer.matches("[a-zA-ZñÑ]+")) {

            // Muestra una ventana de confirmación si la palabra es válida
            new AlertBox().showConfirm("Confirmado Tu nombre",namePlayer,"Puedes Jugar");

            // Crea un objeto Word con la palabra secreta
            Word word=new Word(namePlayer);

            // Establece la palabra en el controlador del juego
            GameStage.getInstance().getGameController().setWord(namePlayer);

            // Cierra la ventana de bienvenida
            WelcomeStage.deleteInstance();
        } else {

            // Muestra un mensaje de error si la palabra contiene caracteres especiales
            new AlertBox().showMessage("ERROR DE ESCRITURA","El nombre contiene caracteres especiales no validos","Por favor ingresar solo letras para su nombre");
        }

    }
}
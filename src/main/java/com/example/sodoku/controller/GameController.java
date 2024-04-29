package com.example.sodoku.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.Random;
public class GameController {


    @FXML
    private Label idtitulo;

    @FXML
    private TextArea MesaggeArea;

    @FXML
    private GridPane gridPaneTablero;
    private String namePlayer;
    @FXML

    private int[][] array = new int[9][9];


    public void setWord(String namePlayer) {
        this.namePlayer = namePlayer.toUpperCase();
        idtitulo.setText(this.namePlayer + " a Sodokjugar");
    }

    // traigo de sopa de letras

    @FXML
    public void initialize() {
        // inicializo la matriz en ceros
       inicializeArrayZeros();
       moatrarMatriz();
        revisa();
        //cuadro 1

        int numerosIniciales = 4;
        int contadorNumerosIniciales = 0;
        int x=0, y=0, cuadroX=0, cuadroY=0, valueXY=0;
        for (int i = 0; i < 4; i++) {

               x=generarNumeroAleatorio(3);
               y=generarNumeroAleatorio(3);

                //TextField textFieldLetter = new TextField();

                //textFieldLetter.setId("idText"+x+y);
               // idTablero1.add(textFieldLetter, x, y);
                // textFieldEnterText(textFieldLetter, x, y);
                // textFieldLetter.setText("" + generarNumeroAleatorio(9));

        }
    }


    private String revisa(){
        System.out.println("Revisando");
        return "Hola Revisado";
    }
    private void verificarXY(int x, int y, int cuadroX, int cuadroY, int valueXY) {
        int checkValue = verificaCuadro(x, y, cuadroX, cuadroY, valueXY);
        while(checkValue != 1) {
           checkValue  = verificaCuadro(x, y, cuadroX, cuadroY, valueXY);
      }
    }

    private int verificaCuadro(int x, int y, int cuadroX, int cuadroY, int valueXY ){
        this.array[x][y]=generarNumeroAleatorio(9);
        valueXY=this.array[x][y];
        int contador=0;
        for(int i= x; i<(x + 3); i++ ){
            for(int j=y; j<(y+3); j++) {

                if(this.array[i][j] == valueXY )
                { contador=contador+1; }
            }
        }
        return contador;
    }
    private void textFieldEnterText(TextField textFieldLetter, int i, int j) {
        textFieldLetter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //System.out.println("Button pressed in the position, " + i + " " + j);

            }
        });
    }
    // traigo de sopa de letras

    private int generarNumeroAleatorio(int rango) {
        // Generar un número aleatorio entre 1 y 9 (ambos inclusive)
        Random aleatorio = new Random();
        int numeroAleatorio = aleatorio.nextInt(rango) + 1;
        // Imprimir el número generado
        System.out.println("Número aleatorio entre 1 y" + rango + ": " + numeroAleatorio);
        return numeroAleatorio;
    }

    private void inicializeArrayZeros() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.array[i][j] = 0;
            }
        }

    }
    //
    private void moatrarMatriz(){
        System.out.println("|");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(this.array[i][j]);
            }
            System.out.println("|");
        }
    }


}

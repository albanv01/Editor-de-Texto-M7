package sample;

import com.sun.glass.ui.CommonDialogs;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.*;

public class Controller {

    @FXML
    private TextArea ta;

    private Stage stage;

    public void onClose(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void onAbout(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Sobre l'editor");
        alert.setContentText("Alumne: Alba Navarro Vargas || Curs: 2n DAM || M7 UF1 Pràctica 2");
        alert.show();
    }

    public void onClickCopiar (ActionEvent actionEvent){
        System.out.println("hola");
    }

    public void onClickCortar (ActionEvent actionEvent){

    }

    public void onClickPegar (ActionEvent actionEvent){

    }

    public void openFile (ActionEvent actionEvent){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files","*.txt"));

        Window mainStage = ta.getScene().getWindow();

        File selectedFile = fileChooser.showOpenDialog(mainStage);
    }

    public void guardarFile (ActionEvent actionEvent){
        try{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save As");
            File file = fileChooser.showSaveDialog(stage);

            if(file != null){
                PrintWriter savedText = new PrintWriter(file);
                BufferedWriter out = new BufferedWriter(savedText);
                out.write(ta.getText());
                out.close();
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Error: " + e);
        } catch (IOException e){
            e.printStackTrace();
        }
    }



    public void tamFuente (ActionEvent actionEvent){
        String opcion = ((MenuItem) actionEvent.getTarget()).getId();


        switch (opcion){
            case "small":
                ta.setStyle("-fx-font-size: 5px");
                break;
            case "default":
                ta.setStyle("-fx-font-size: 12px");
                break;
            case "big":
                ta.setStyle("-fx-font-size: 30px");
                break;


        }
    }

    public void estiloFuente (ActionEvent actionEvent){
        String opcion = ((MenuItem) actionEvent.getSource()).getId();


        switch (opcion){
            case "Arial":
                ta.setStyle("-fx-font-family: Arial");
                break;
            case "Helvetica":
                ta.setStyle("-fx-font-family: Helvetica");
                break;
            case "Verdana":
                ta.setStyle("-fx-font-family: Verdana");
                break;


        }
    }


}

package proejctAnimal;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;

public class ReservationscreenController extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("reservationscreen.fxml"));
        primaryStage.setTitle("Animal Clinic");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    private ToggleGroup aa;

    @FXML
    private ToggleGroup aaa;

    @FXML
    private CheckBox check;

    @FXML
    private TextField phoneText;

    @FXML
    private RadioButton radio1;

    @FXML
    private RadioButton radio13;

    @FXML
    private RadioButton radio2;

    @FXML
    private RadioButton radio4;

    @FXML
    void submitAction(ActionEvent event) {


        String phone = phoneText.getText();

        String animal = "";
        String service = "";


        if (radio1.isSelected()){

            animal = "PET";

        }
        if (radio2.isSelected()){

            animal  = "CAT";


        }

        if (radio13.isSelected()){

            service = "Clean";

        }

        if (radio4.isSelected()){

            service = "Cut Hair";

        }

        if (check.isSelected()){
            Platform.exit();

            new HomeAddress();

        }else {


            Alert a = new Alert(Alert.AlertType.INFORMATION,"You reservation is done");
            a.show();
        }




    }

}

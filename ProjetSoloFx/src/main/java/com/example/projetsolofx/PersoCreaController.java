package com.example.projetsolofx;
import chara.wizard.Pet;
import game.Game;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class PersoCreaController {
    ShareGame game;
    @FXML
    private Button createButton;
    @FXML
    private Scene PersoCreaController;
    @FXML
    private ComboBox animalListe;
    @FXML
    private FXCollections observableArrayList;
    @FXML
    private TextField fieldName;
    @FXML
    private Label wandField;
    @FXML
    private Label houseField;
    @FXML
    protected void onCreateClick(javafx.event.ActionEvent actionEvent) throws IOException {
        if(animalListe.getValue()==null){
            System.out.println("1");
        }else
            game.getGame().initFxPlayer(fieldName.getText(), (Pet) animalListe.getValue());
        game.goPersoInfo(actionEvent,"PersoInfo");
    }
    public void initialize() throws IOException{
        for(Pet var: Pet.values()){
            this.animalListe.getItems().add(var);
        }
        game=new ShareGame();


    }


}

package com.example.projetsolofx;
import chara.wizard.Pet;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class PersoCreaCrontroller {
    @FXML
    private Button createButton;
    @FXML
    private ComboBox animalListe;
    @FXML
    private FXCollections observableArrayList;
    @FXML
    private TextField fieldName;

    @FXML
    protected void onCreateClick() {
        if(animalListe.getValue()==null){
            System.out.println("1");
        }else
            System.out.println("Name : "+fieldName.getText()+"\n Pet : "+animalListe.getValue());
    }
    public void initialize() throws IOException{
        for(Pet var: Pet.values()){
            this.animalListe.getItems().add(var);
        }
    }


}

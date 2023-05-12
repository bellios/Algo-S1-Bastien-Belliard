package com.example.projetsolofx;

import chara.wizard.Pet;
import chara.wizard.wand.Wand;
import game.Game;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class PersoInfoController {
    @FXML
    private Label wandField;
    @FXML
    private Label houseField;
    @FXML
    private Label nameField;
    @FXML
    private Label petField;
    private ShareGame game;

    public void initialize() throws IOException {
        nameField.setText(ShareGame.getGame().getPlayer().getName());
        houseField.setText(ShareGame.getGame().getPlayer().getHouse().toString());
        petField.setText(String.valueOf(ShareGame.getGame().getPlayer().getPet()));
        wandField.setText(ShareGame.getGame().getPlayer().getWand().toString());
        game=new ShareGame();
    }

    public void clickReroll(javafx.event.ActionEvent actionEvent) throws IOException{
        game.goPersoInfo(actionEvent,"PersoCreation");
    }
}

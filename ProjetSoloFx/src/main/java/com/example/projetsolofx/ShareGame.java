package com.example.projetsolofx;


import game.Game;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ShareGame {
    private static Game game;

    public static Game getGame() {
        return game;
    }

    public static void setGame(Game game) {
        ShareGame.game = game;
    }

    public void goPersoInfo(javafx.event.ActionEvent actionEvent,String name) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(name+".fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

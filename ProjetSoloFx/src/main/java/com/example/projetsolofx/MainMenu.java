package com.example.projetsolofx;
import game.Game;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenu extends Application{
    ShareGame game;

    @Override
    public void start(Stage primaryStage) {
        game=new ShareGame();
        Game game1=new Game();
        game.setGame(game1);

        primaryStage.setTitle("Harih Potah into the meme world");
        VBox conteneur = new VBox();
        conteneur.setPadding(new Insets(10));
        conteneur.setSpacing(10);
        conteneur.setAlignment(Pos.BOTTOM_CENTER);
        VBox contTitle = new VBox();
        contTitle.setPadding(new Insets(50));
        contTitle.setSpacing(270);
        contTitle.setAlignment(Pos.TOP_CENTER);
        Label title = new Label("Harih Potah into the meme world");
        title.setId("title");
        Button playg = new Button("Play graphic");
        playg.setId("buttong");
        playg.setOnAction(event -> {
            System.out.println("Starting game");
            try {
                game.goPersoInfo(event,"PersoCreation");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        Button playc = new Button("Play consol");
        playc.setId("buttonc");
        playc.setOnAction(event -> {
            primaryStage.close();
            System.out.println("Starting consol game");
            Game game=new Game();
            game.startGame();
        });
        Button quitter = new Button("Quit");
        quitter.setId("button");
        quitter.setOnAction(event -> primaryStage.close());
        conteneur.getChildren().addAll(playc,playg, quitter);
        contTitle.getChildren().addAll(title,conteneur);
        Image imageFond = new Image(getClass().getResourceAsStream("/image/mainmenu.png"));
        ImageView imageView = new ImageView(imageFond);

        // Empiler l'image de fond et le conteneur
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, conteneur);

        // Ajouter le stackPane à la scène
        Scene scene = new Scene(stackPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

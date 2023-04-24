package com.example.projetsolofx;
import game.Game;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class MainMenu extends Application{
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Main menu");
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
        Scene scene = new Scene(contTitle, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

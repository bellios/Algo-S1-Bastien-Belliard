package game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("PersoCreation.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(400);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        //Game game=new Game();
        //game.startGame();

        // A faire
        // Boss = sorcier donc sort et potion à changer
        // ajouter les items
        // Faire les cas spéciaux de niveaux
        // Voir pour mettre les dialogue dans une enum ou class
        // finir choisir les action chaque année, shop, trouver ingre
        // random level

        //===========================================================
        //Menu création de personnage
        //Menu déroulement année
        //Menu de combat
        
    }
}
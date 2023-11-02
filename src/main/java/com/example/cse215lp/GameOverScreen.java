package com.example.cse215lp;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameOverScreen {


//    private Image gameOverImage;
//    private Image scoreImage;
    private static Scene scene;
    private static StackPane root;

    private static Button playAgainButton;

    public static void setGameOver(GraphicsContext gc, Image gameOverImage, Image scoreImage, Group root){

        gc.drawImage(gameOverImage, 400, 175, 200, 100);
        gc.drawImage(scoreImage,375, 325, 250, 300);

        gc.setFill(Color.ROSYBROWN);
        gc.setFont(Font.font("Arial", FontWeight.BOLD, 35)); // Set the font for the text

        // Draw the score on the screen at the specified position (e.g., x=20, y=40)
        gc.fillText("" + (int)Sprite.getTotalScore(), 490, 450);

        // It's time to add Play Again Button
        //root = new StackPane();
        //scene = new Scene(root, 200, 100 );

        playAgainButton = new Button("PLAY AGAIN");
       // root.getChildren().add(playAgainButton);




    }
}

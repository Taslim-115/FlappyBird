package com.example.cse215lp;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.*;


public class GameOverScreen {


;

    //private static Button playAgainButton;
    private static boolean flag = true;
    private static int bestScore;
    private static final File file = new File("best.dat");

    public static void setFlag(boolean flag) {
        GameOverScreen.flag = flag;
    }

    public static void setGameOver(GraphicsContext gc, Image gameOverImage, Image scoreImage, Group root, Scene scene, Button playAgainButton) {

        gc.drawImage(gameOverImage, 400, 175, 200, 100);
        gc.drawImage(scoreImage, 375, 325, 250, 300);

        gc.setFill(Color.ROSYBROWN);
        gc.setFont(Font.font("Arial", FontWeight.BOLD, 35)); // Set the font for the text

        // Draw the score on the screen at the specified position (e.g., x=20, y=40)
        gc.fillText("" + (int) Sprite.getTotalScore(), 490, 450);
        gc.fillText("" + getBestScore(), 490, 550);

        // It's time to add Play Again Button

        if (flag) {

            root.getChildren().add(playAgainButton);
            flag = false;


        }


    }

    public static int getBestScore() {
        int score;
        int currentScore = (int) Sprite.getTotalScore();


        if (!file.exists()) {
            try {
                file.createNewFile();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try (DataInputStream input = new DataInputStream(new FileInputStream(file));) {

                if (input.available() > 0) {
                    bestScore = input.readInt();
                }


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (DataOutputStream output = new DataOutputStream(new FileOutputStream(file, false));) {
            if (currentScore > bestScore) {
                bestScore = currentScore;
                output.writeInt(bestScore);
                return bestScore;
            } else {
                output.writeInt(bestScore);
                return bestScore;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

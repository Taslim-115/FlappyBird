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

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;

public class GameOverScreen {


//    private Image gameOverImage;
//    private Image scoreImage;
    private static Scene scene;
    private static StackPane root;

    //private static Button playAgainButton;
    private static boolean flag=true ;
    private static int bestScore ;

    private static String filePathString = "best.txt";

    private static Path path = Paths.get(filePathString);

    private static File file = new File("best.dat");

    public static void setFlag(boolean flag) {
        GameOverScreen.flag = flag;
    }

    public static void setGameOver(GraphicsContext gc, Image gameOverImage, Image scoreImage, Group root, Scene scene, Button playAgainButton){

        gc.drawImage(gameOverImage, 400, 175, 200, 100);
        gc.drawImage(scoreImage,375, 325, 250, 300);

        gc.setFill(Color.ROSYBROWN);
        gc.setFont(Font.font("Arial", FontWeight.BOLD, 35)); // Set the font for the text

        // Draw the score on the screen at the specified position (e.g., x=20, y=40)
        gc.fillText("" + (int)Sprite.getTotalScore(), 490, 450);
        gc.fillText("" + getBestScore(),490, 550);

        // It's time to add Play Again Button
        //root = new StackPane();
        //scene = new Scene(root, 200, 100 );

        if (flag) {
//            scene.getStylesheets().add(Objects.requireNonNull(GameOverScreen.class.getResource("styles.css")).toExternalForm());
//            playAgainButton = new Button("PLAY AGAIN");
//            playAgainButton.getStyleClass().add("play-button");
//             playAgainButton.setLayoutX(440);
//             playAgainButton.setLayoutY(565);
             root.getChildren().add(playAgainButton);
            flag = false;


        }





    }

    public  static int getBestScore(){
        int score;
        int currentScore = (int)Sprite.getTotalScore();
//        try(Scanner sc = new Scanner(new File("best.txt"))){
//
//            //
//            // bestScore = sc.nextInt();
//            if (sc.hasNextInt()) {
//                bestScore = sc.nextInt();
//            } else {
//                // Handle the case where the file does not contain a valid integer
//                bestScore = 0; // Set a default value
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
//            throw new RuntimeException(e);
//        }
//
//        try(PrintWriter out = new PrintWriter("best.txt")){
//            //System.out.println();
//
//            if(currentScore > bestScore){
//               // out.write(currentScore);
//                out.write(Integer.toString(currentScore));
//                return currentScore;
//            }
//            else return bestScore;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        try (Scanner sc = new Scanner(new File("best.txt"));
//             PrintWriter out = new PrintWriter("best.txt")) {
//
//            if (sc.hasNextInt()) {
//                bestScore = sc.nextInt();
//            } else {
//                bestScore = 0; // Set a default value
//            }
//
//            if (currentScore > bestScore) {
//                out.write(Integer.toString(currentScore));
//                return currentScore;
//            }
//            else return bestScore;
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
//            throw new RuntimeException(e);
//        }

      //  File file = new File("best.dat");

//        if (Files.exists(path)) {
//            // file exist
//        }
//
//        if (Files.notExists(path)) {
//            // file is not exist
//        }
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    bestScore = 0;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (   DataOutputStream output = new DataOutputStream(new FileOutputStream(file, false));
                DataInputStream input = new DataInputStream(new FileInputStream(file)) ) {

            if (input.available() > 0) {
                bestScore = input.readInt();
            }

            if (currentScore > bestScore) {
                bestScore = currentScore;
                output.writeInt(bestScore);
                return currentScore;
            }
            else return bestScore;
        } catch (IOException e) {
            System.out.println("Error handling binary file.");
            throw new RuntimeException(e);
        }


    }
}

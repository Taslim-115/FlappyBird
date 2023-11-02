package com.example.cse215lp;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import p1.SceneManager;
import p1.Updatable;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Play implements Updatable {

    private boolean flag = true;
    private Scene scene;
    private int width, height;
    private GraphicsContext gc;
    private Image backgroundImage;
    private Image gameOverImage;
    private Image scoreImage;

    public Image getBackgroundImage() {
        return backgroundImage;
    }

    private Bird bird;
    private Pipe pipe;
    private List<Pipe> pipes = new ArrayList<>();

    Button playAgainButton ;
    Group root;

    public Play(SceneManager sm) {


        this.width = sm.getWidth();
        this.height = sm.getHeight();

        //Its all about canvas

         root = new Group();
        this.scene = new Scene(root);

        Canvas canvas = new Canvas(this.width, this.height);
        this.gc = canvas.getGraphicsContext2D();

        //Load the background Image for Play
        String filePath = "/com/example/cse215lp/playBackground.png";
        backgroundImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(filePath)));
        gameOverImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/cse215lp/game_over.png")));
        scoreImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/cse215lp/score.png")));

        //Draw the backgroundImage on the canvas


        // gc.drawImage(backgroundImage, 0, 0, this.width, this.height);

        // Bring the bird
        bird = new Bird(gc);
        bird.setImage(bird.getFilePath());
        scene.setOnMouseClicked(e -> {
            bird.setPositionY(bird.getPositionY() - 150);
        });

        pipes.add(new Pipe(1000, 0, 50, 350));
        pipes.add(new Pipe(1000, 550, 50, 250));
        pipes.add(new Pipe(1250, 0, 50, 350));
        pipes.add(new Pipe(1250, 550, 50, 250));
        pipes.add(new Pipe(1500, 0, 50, 350));
        pipes.add(new Pipe(1500, 550, 50, 250));
        pipes.add(new Pipe(1750, 0, 50, 350));
        pipes.add(new Pipe(1750, 550, 50, 250));

        pipe = new Pipe();
        pipe.setImage(pipes);

        // Creating play again button

        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());

        playAgainButton = new Button("PLAY AGAIN");


        root.getChildren().add(canvas);


    }

    @Override
    public void update() {
        if(flag){
        gc.drawImage(backgroundImage, 0, 0, this.width, this.height);
        }

        if (!Sprite.isIsGameOver()) {
           // gc.drawImage(backgroundImage, 0, 0, this.width, this.height);
            bird.update();
            bird.render(gc);
            pipe.render(pipes, gc);
            pipe.update(pipes);
            bird.intersectSprite(pipes);
            bird.updateTotalScore(pipes, gc);
            //gc.drawImage(backgroundImage, 0, 0, this.width, this.height);
        }
       else {
           while(flag) {

               try {
                   Thread.sleep(250);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               flag = false;
           }
            //bird.setPositionX(bird.getPositionX() +10);
            //flag = false;
            gc.drawImage(backgroundImage, 0, 0, this.width, this.height);
            pipe.render(pipes, gc);
            pipe.update(pipes);
//            gc.drawImage(gameOverImage, 400, 175, 200, 100);
//            gc.drawImage(scoreImage,375, 325, 250, 300);
//
//            gc.setFill(Color.ROSYBROWN);
//            gc.setFont(Font.font("Arial", FontWeight.BOLD, 35)); // Set the font for the text
//
//            // Draw the score on the screen at the specified position (e.g., x=20, y=40)
//            gc.fillText("" + (int)Sprite.getTotalScore(), 490, 450);
            GameOverScreen.setGameOver(gc,gameOverImage, scoreImage, root);

//           // root.getChildren().add(playAgainButton);
//            VBox root = new VBox();
//            Scene scene1 = new Scene(root);
//              root.getChildren().add(playAgainButton);
        }
    }

    @Override
    public Scene getScene() {
        return this.scene;
    }


}

package com.example.cse215lp;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import p1.SceneManager;
import p1.Updatable;

import java.util.Objects;

public class MainMenu implements Updatable {

    private Scene scene;
    private GraphicsContext gc;
    private int width, height;


    public MainMenu(SceneManager sm) {

        this.width = sm.getWidth();
        this.height = sm.getHeight();

        //Main canvas
        Group root = new Group();
        this.scene = new Scene(root);

        Canvas canvas = new Canvas(this.width, this.height);

        this.gc = canvas.getGraphicsContext2D();

        // Load the background image
        //Image backgroundImage = new Image("file:///C:/Users/Dell/Desktop/Cse215LP/src/main/resources/com/example/cse215lp/mainMenuBackground.png");
        Image backgroundImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/cse215lp/mainMenuBackground.png")));

        //System.out.println("File path: " + backgroundImage.getUrl());

        // Draw the background image on the canvas
        gc.drawImage(backgroundImage, 0, 0, this.width, this.height);

        //Play Button
        Button btnPlay = new Button("PLAY");
        int width = 150, height = 60;
        btnPlay.setLayoutX((double) (this.width - width) / 2);
        btnPlay.setLayoutY((double) (this.height - height) / 2);

        btnPlay.setMinWidth(width - 20);
        btnPlay.setMinHeight(height - 20);


        // set action on Play button
        btnPlay.setOnAction(e -> {
            Play play = new Play(sm);
            sm.setScene(play);
        });

        // Load the CSS file
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());

       // Apply the CSS class to the button
        btnPlay.getStyleClass().add("play-button");


//        //Guide Button
//        Button btnGuide = new Button("Guide");
//        //width = 150;
//        //height = 60;
//        btnGuide.setLayoutX((double) (this.width - width) / 2);
//        btnGuide.setLayoutY((double) (this.height - height) / 2 + (height + 30));
//
//        btnGuide.setMinWidth(width - 20);
//        btnGuide.setMinHeight(height - 20);

        ;


        // Apply the CSS class to the button
       // btnGuide.getStyleClass().add("play-button");


        root.getChildren().addAll(canvas, btnPlay);

    }

    @Override
    public void update() {

    }

    @Override
    public Scene getScene() {
        return this.scene;
    }
}

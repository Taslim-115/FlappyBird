package com.example.cse215lp;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import p1.SceneManager;
import p1.Updatable;

import java.util.Objects;

public class Play implements Updatable {

    private Scene scene;
    private int width, height;
    private GraphicsContext gc;
    private Image backgroundImage ;

    public Play(SceneManager sm) {

        this.width = sm.getWidth();
        this.height = sm.getHeight();

        //Its all about canvas

        Group root = new Group();
        this.scene = new Scene(root);

        Canvas canvas = new Canvas(this.width, this.height);
        this.gc = canvas.getGraphicsContext2D();

        //Load the background Image for Play
        String filePath = "/com/example/cse215lp/playBackground.png";
        Image backgroundImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(filePath)));

        //Draw the backgroundImage on the canvas
        gc.drawImage(backgroundImage, 0, 0, this.width, this.height);

        root.getChildren().add(canvas);




    }

    @Override
    public void update(){

    }

    @Override
    public Scene getScene(){
        return this.scene;
    }


}

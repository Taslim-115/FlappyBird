package com.example.cse215lp;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.nio.file.attribute.GroupPrincipal;

public class Bird {

    private Sprite birdSprite;
    private double locationX = 70;
    private double locationY = 200;
    private int birdWidth = 100;
    private int getBirdheight = 50;
    private GraphicsContext gc;
    public Image image;
    private String filePath = "/com/example/cse215lp/bird1.png";



    public Bird(GraphicsContext gc){
        birdSprite = new Sprite();
        //bird.setImage();
        birdSprite.setPositionXY(locationX, locationY);
        birdSprite.render(gc, filePath);

    }
}

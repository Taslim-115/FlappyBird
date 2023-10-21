package com.example.cse215lp;

import javafx.scene.image.Image;

public class Sprite {

    private Image image;

    private double positionX;
    private double positionY;
    private double velocityX;
    private double velocityY;
    private double width;
    private double height;

    public Sprite(){
        this.positionX = 0;
        this.positionY = 0;
        this.velocityX = 0;
        this.velocityY = 0;

    }

    public Sprite(double positionX, double positionY, double velocityX, double velocityY){
        this.positionX = positionX;
        this.positionY = positionY;
        this.velocityX = velocityX;
        this.velocityY = velocityY;

    }


}

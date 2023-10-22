package com.example.cse215lp;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

public class Sprite {

    private Image image;

    private double positionX;
    private double positionY;
    private double velocityX;
    private double velocityY;
    private double width;
    private double height;

    public Sprite() {
        this.positionX = 0;
        this.positionY = 0;
        this.velocityX = 0;
        this.velocityY = 0;

    }

    public Sprite(double positionX, double positionY, double velocityX, double velocityY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.velocityX = velocityX;
        this.velocityY = velocityY;

    }

    public void setImage(Image image) {
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();

    }

    public void reseizeImage(String filepath, int width, int height) {
        Image toReturn = new Image(filepath, width, height, false, false);
        setImage(toReturn);
    }


    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public double getWidth() {
        return width;
    }

    public double getHidth() {
        return height;
    }

    public void setPositionXY(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }


    public void addVelocity(double x, double y) {
        this.velocityX += x;
        this.velocityY += y;
    }

    public void render(GraphicsContext gc, String filePath) {
        image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(filePath)));
        gc.drawImage(image, positionX, positionY, width, height);
    }

    public Rectangle2D getBoundary() {
        return new Rectangle2D(positionX, positionY, width, height);
    }

    public boolean intersectSprite(Sprite s) {
        return s.getBoundary().intersects(this.getBoundary());
    }

    public void update(double deltaTime) {
        positionX += velocityX * deltaTime;
        positionY += velocityY * deltaTime;
    }

}

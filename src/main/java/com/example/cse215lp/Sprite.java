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

    private GraphicsContext gc;

    public void setGc(GraphicsContext gc) {
        this.gc = gc;
    }

    public Sprite() {
        this.positionX = 0;
        this.positionY = 0;
        this.velocityX = 0;
        this.velocityY = 0;

    }


    public Sprite(double positionX, double positionY, double velocityX, double velocityY, double width, double height, Image image) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.width = width;
        this.height = height;
        this.image = image;

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

    public double getHeight() {
        return height;
    }

    public void setPositionXY(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public void addVelocity(double x, double y) {
        this.velocityX += x;
        this.velocityY += y;
    }

    public void render() {
        //image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(filePath)));
        gc.drawImage(image, positionX, positionY, 50, 45);
    }

    public void render(GraphicsContext gc) {
        //image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(filePath)));
        this.gc = gc;
        gc.drawImage(image, positionX, positionY, 50, 45);
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

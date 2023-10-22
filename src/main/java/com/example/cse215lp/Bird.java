package com.example.cse215lp;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.Objects;

public class Bird extends Sprite {

    private Sprite birdSprite;
    private String filePath = "/com/example/cse215lp/bird1.png";


    public Bird(GraphicsContext gc) {
        birdSprite = new Sprite(70, 200, 0, 0, 50, 45, new Image(Objects.requireNonNull(getClass().getResourceAsStream(filePath))));
        //bird.setImage();
        // birdSprite.setPositionXY(positionX, positionY);
        birdSprite.setGc(gc);
        birdSprite.render();

    }
}

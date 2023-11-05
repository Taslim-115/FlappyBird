package com.example.cse215lp;

import java.util.List;

public class Pipe extends Sprite {

    public static boolean isFaceUp = true;

    private String downPipePath = "/com/example/cse215lp/down_pipe.png";
    private String upPipePath = "/com/example/cse215lp/up_pipe.png";

    public String getPipeFilePath() {
        String filePath = isFaceUp ? downPipePath : upPipePath;

        isFaceUp = !(isFaceUp);

        return filePath;

    }

    public Pipe(double x, double y, double w, double h) {

        super(x, y, w, h);
    }

    public Pipe() {

    }

    public void backToScreen() throws OutOfScreen {

        if (getPositionX() - 2.5 + getWidth() <= 0) {
            setPositionX(1000);

        }

    }

    public void updateS() throws OutOfScreen {
        // Update the position of the pipe (e.g., move it to the left)
        //positionX -= 1; // Adjust the speed

        setPositionX(getPositionX() - 2.5);
//        if (getPositionX() - 2.5 + getWidth() <= 0) {
//            setPositionX(1000);
//
//        }
        try {
            backToScreen();
        } catch (OutOfScreen e) {
            System.out.println("OUt of Screen : " + e);
        }

    }

    public void update(List<Pipe> pipes) {
        // Update the position of all pipes
        int randomHeight;

        for (Pipe pipe : pipes) {
            try {
                pipe.updateS();
            } catch (OutOfScreen e) {
                System.out.println("Out of screen : " + e);
            }

        }

        for (int i = 0; i < pipes.size(); i += 2) {
            Pipe pipe = pipes.get(i); // Get the Pipe object at index i

            randomHeight = 250 + (int) (Math.random() * (450 - 250));
            if (pipe.getPositionX() == 1000) {

                pipe.setHeight(randomHeight);
                pipe = pipes.get(i + 1);

                pipe.setPositionY(randomHeight + 200);
                pipe.setHeight(800 - (randomHeight + 200));

            }
        }

    }

    public void reset(List<Pipe> pipes) {
        for (Pipe pipe : pipes) {
            pipe.setPositionX(pipe.getInitialX());
            pipe.setPositionY(pipe.getInitialY());
            pipe.setHeight(pipe.getInitialHeight());
            pipe.setWidth(pipe.getInitialWidth());
        }
    }
}

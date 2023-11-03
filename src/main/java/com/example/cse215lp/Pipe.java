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

    public String getUpperPipePath() {
        return upPipePath;
    }


    public Pipe(double x, double y, double w, double h) {
//        this.setPositionXY(x, y);
//       this.setInitilaX(x);
//       this.setInitilaY(y);
//        this.setWidth(w);
//        this.setHeight(h);

        super(x, y, w, h);
    }

    public Pipe() {

    }

//     public void render() {
//          // Render all the pipes
//          Pipe[] pipes;
//          for (Pipe pipe : pipes) {
//               pipe.render(gc); // gc is the GraphicsContext
//          }
//     }


    public void updateS() {
        // Update the position of the pipe (e.g., move it to the left)
        //positionX -= 1; // Adjust the speed

        this.setPositionX(getPositionX() - 2.5);
        if (this.getPositionX() - 2.5+ this.getWidth() <= 0) {
            this.setPositionX(1000);

        }


    }

    public void update(List<Pipe> pipes) {
        // Update the position of all pipes
        int randomHeight;


//        for (int i = 0; i < pipes.size(); i += 2) {
//            // Access the properties or methods of each Pipe object using the index i
//            Pipe pipe = pipes.get(i); // Get the Pipe object at index i
//            pipe.setPositionX(pipe.getPositionX() - 5);
//            randomHeight = 250 + (int) (Math.random() * (450 - 250));
//            //pipe.getPositionX()-5+ pipe.getWidth() <= 0
//            if (pipe.getPositionX() - 5 + pipe.getWidth() <= 0) {
//
//                //randomHeight = 250 + (int) (Math.random() * (450 - 250));
//                pipe.setHeight(randomHeight);
//                pipe = pipes.get(i + 1);
//
//                //pipe.setPositionX(pipe.getPositionX() - 5);
//
//                // pipe.setPositionY(randomHeight + 200);
//                // pipe.setHeight(800 - (randomHeight + 200));
//            }
//            pipe = pipes.get(i + 1);
//            pipe.setPositionX(pipe.getPositionX() - 5);
//
//            if (pipe.getPositionX() - 5 + pipe.getWidth() <= 0) {
//                pipe.setPositionY(randomHeight + 200);
//                pipe.setHeight(800 - (randomHeight + 200));
//            }
//
//
//        }


        for (Pipe pipe : pipes) {
            pipe.updateS();
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

    public  void reset(List<Pipe> pipes){
        for (Pipe pipe:pipes) {
            pipe.setPositionX(pipe.getInitilaX());
            pipe.setPositionY(pipe.getInitilaY());
            pipe.setHeight(pipe.getInitialHeight());
            pipe.setWidth(pipe.getInitialWidth());
        }
    }
}

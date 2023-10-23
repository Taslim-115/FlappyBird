package com.example.cse215lp;

import java.util.List;

public class Pipe extends Sprite {

     public boolean isFaceUp = true;

       private String downPipePath = "/com/example/cse215lp/down_pipe.png";
      private String upPipePath = "/com/example/cse215lp/up_pipe.png";

     public String getPipeFilePath() {
          String filePath = isFaceUp ? upPipePath : downPipePath;
          isFaceUp = !(isFaceUp);
          return filePath;


     }

     public String getUpperPipePath() {
          return upPipePath;
     }


     public Pipe(double x, double y, double w, double h) {
          this.setPositionXY(x, y);
          this.setWidth(w);
          this.setHeight(h);
     }
     public Pipe(){

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

          this.setPositionX(getPositionX() -5);
          if(getPositionX() - 5 + getWidth()<= 0) this.setPositionX(1000);
     }

     public void update(List<Pipe>  pipes) {
          // Update the position of all pipes
          for (Pipe pipe : pipes) {
               pipe.updateS();
          }
     }
}

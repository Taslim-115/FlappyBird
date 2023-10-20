package com.example.cse215lp;

import javafx.application.Application;
import javafx.stage.Stage;
import p1.SceneManager;

public class FlappyBird extends Application{

    public void start(Stage window){
        //Initialise Scene Manager
        SceneManager sm = new SceneManager(window);
        sm.setTitle("FlappyBird");
        sm.setDimension(1000, 800);

        //Initialise MainMenu
        MainMenu mainMenu = new MainMenu(sm);

        //set scene to MainMenu
        sm.setScene(mainMenu);

        window.show();
    }
    public static void main(String []args){
        launch(args);
    }
}

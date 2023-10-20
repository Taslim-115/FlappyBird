package p1;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class SceneManager {

    private Stage window;
    private Updatable scene;
    private int width, height;

    public SceneManager(Stage window) {
        this.window = window;


        //default size
        this.width = 600;
        this.height = 600;

    }

    public void setTitle(String title) {
        this.window.setTitle(title);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setDimension(int width, int height) {
        this.width = width;
        this.height = height;

    }

    public void setScene(Updatable scene) { // here using Updatable interface to get scene cause sm doesnot has its own scene.
        this.scene = scene;
        this.window.setScene(scene.getScene()); //here we will get scene form the class that will implement Updatable interface.


        // Event Handler
        scene.getScene().setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                Stage stage = (Stage) scene.getScene().getWindow(); // Get the main stage
                stage.hide(); // Hide the main stage
            }
            //Platform.exit();
        });

    }

    public Scene getScene() {
        return this.window.getScene();
    }

    public void update() {
        this.scene.update();
    }


}

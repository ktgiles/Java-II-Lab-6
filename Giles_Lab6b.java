/*Kaitlin Giles, Lab 6 B, 04/04/2021
Draw lines with arrow keys */

package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.shape.*;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;


public class Giles_Lab6b extends Application {
    @Override
    public void start(Stage stage) {
        double initX = 250; //starting point at center of stage
        double initY = 250; //starting point at center of stage
        double z = 10; // length of movement with each arrow key press

        Circle circle = new Circle(initX, initY, 5); //create circle
        Group root = new Group(circle); //create group object

        //create event handler
        EventHandler<KeyEvent> eventHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                //if right arrow key pressed
                if (e.getCode() == KeyCode.RIGHT) {
                    double x = getX(circle);
                    root.getChildren().add(new Line(getX(circle), getY(circle), x + z, getY(circle))); //create line and add to root
                    circle.setCenterX(x + z); //update circle location
                }
                //if left arrow key pressed
                else if (e.getCode() == KeyCode.LEFT) {
                    double x = getX(circle);
                    root.getChildren().add(new Line(getX(circle), getY(circle), x - z, getY(circle))); //create line and add to root
                    circle.setCenterX(x - z); //update circle location
                }
                else if (e.getCode() == KeyCode.DOWN) {
                    double y = getY(circle);
                    root.getChildren().add(new Line(getX(circle), getY(circle), getX(circle), y + z)); //create line and add to root
                    circle.setCenterY(y + z); //update circle location
                }
                else if (e.getCode() == KeyCode.UP) {
                    double y = getY(circle);
                    root.getChildren().add(new Line(getX(circle), getY(circle), getX(circle), y - z)); //create line and add to root
                    circle.setCenterY(y - z); //update circle location
                }
                else if (e.getCode() == KeyCode.SPACE) {
                    circle.setCenterY(initY); //reset circle location to original
                    circle.setCenterX(initX); //reset circle location to original
                    root.getChildren().clear(); //clear all of root children
                    root.getChildren().add(circle); //put circle back into root
                }
            }
        };

        Scene scene = new Scene(root, 500, 500); //create scene object
        scene.addEventHandler(KeyEvent.KEY_PRESSED, eventHandler);//register event filter
        stage.setTitle("Use Arrow Keys to Move, Space to Reset"); //set stage title
        stage.setScene(scene); //add scene to stage
        stage.show(); //display stage
    }

    public static void main(String args[]) {
        launch(args);
    }

    //getter method circle x axis location
    public static double getX(Circle circle){
        double x = circle.getCenterX();
        return x;
    }

    //getter method circle y axis location
    public static double getY(Circle circle){
        double y = circle.getCenterY();
        return y;
    }
}

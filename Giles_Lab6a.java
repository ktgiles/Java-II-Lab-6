/*Kaitlin Giles, Lab 6 A, 03/26/2021
Create and Remove Points with click */

package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Giles_Lab6a extends Application {
    //set variables
    int j = 0;
    int k = 0;
    int grid = 15; //this variable controls grid size
    int gridSize = grid * grid;
    int count = 0;
    Button[] buttArr = new Button[gridSize]; //create array of buttons to match grid size
    int i = 0;

    @Override
    public void start(Stage stage) {
        GridPane pane = new GridPane(); //create pane
        pane.setAlignment(Pos.CENTER); //align pane
        pane.setStyle("-fx-background-color: #000000"); //make pane pretty

        //this block populates buttons to fill grid
        while (j < grid) {
            buttArr[count] = new Button(" "); //create button and place into array
            pane.add(buttArr[count], j, k); //place button into position in pane
            k++;
            count++;
            if (k == grid) {
                j++;
                k = 0;
            }
        }

        //iterate through array
        for (i = 0; i < buttArr.length; i++) {
            shape(buttArr[i]); //apply shape method to each button
            buttClick(buttArr[i]); //apply button click instructions to each button
        }

        Scene scene = new Scene(pane, 325, 325); //create scene
        stage.setTitle("Lab 6 A"); //set stage title
        stage.setScene(scene); //place scene in stage
        stage.setResizable(false); //make scene not resizable
        stage.show(); //display stage
    }

    public static void main(String args[]) {
        launch(args);
    }

    //this method applies round shape and black color to buttons
    public static void shape(Button button) {
        button.setShape(new Circle(10));
        button.setMinSize(2 * 10, 2 * 10);
        button.setMaxSize(2 * 10, 2 * 10);
        button.setStyle("-fx-background-color: #000000");
    }

    //this method changes button color when right or left clicked
    public static void buttClick(Button button) {
        button.setOnMouseClicked(event ->
        {
            if (event.getButton() == MouseButton.PRIMARY) {
                button.setStyle("-fx-background-color: #999999"); //left click for white
        }   else if (event.getButton() == MouseButton.SECONDARY) {
                button.setStyle("-fx-background-color: #000000"); //right click for black
            }
        });
    }
}
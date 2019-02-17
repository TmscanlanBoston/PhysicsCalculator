/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package physicscalculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Thomas Scanlan
 */
public class PhysicsCalculator extends Application {

    BorderPane bp;

    // this button clears all the fields and reset the initial y position to 0 meters
    Button clearButton;

    // this button submits all the data in the fields for calculations. 
    Button submitButton;

    // The initial x-position is zero meters. It is the horizontal position
    // at which it will be launched. 
    Label label_xInitial;

    // the textextfieldield for initial y-position is always default set to 0 meters
    TextField textfield_yInitial;
    Label label_yInitial;

    // default value of 0 meters
    final double YPOSIT = 0.0;

    // Initial velocity in x-direction. The user can and should change this 
    // before using it for any calculations. (m/s)
    // Otherwise this will be calculated automactically. 
    TextField textfield_vxInitial;
    Label label_vxInitial;

    // Initial velocity in y-direction. The user can and should change this 
    // before using it for any calculations. (m/s) 
    // Otherwise this will be calculated automatically. 
    TextField textfield_vyInitial;
    Label label_vyInitial;

    // initial launch angle TextField, this cannot be changed by the user
    TextField textfield_launchAngle;
    Label label_launchAngle;

    // The final y-position is always zero (meters), 
    // therefore it doesn't have a TextField.
    Label label_yfinal;

    // The final x-position is the distance the projectile
    // has traveled from the origin (meters).
    TextField textfield_xfinal;
    Label label_xfinal;

    // The magnitude of the initial Velocity (m/s).
    // This is one of the possible requirements to calculate anything. 
    TextField textfield_totalVmagnitude;
    Label label_totalVmagnitude;

    // This is the max height (meters), the user cannot enter any data 
    // into this field. The velocity of the projectile is zero here. 
    // The user cannot change this.
    TextField textfield_maxHeight;
    Label label_maxHeight;

    // The number of seconds that the projectile has traveled, at the point 
    // at which is reaches its maximum height (meters). 
    // The user cannot change this. 
    TextField textfield_timeMaxHeight;
    Label label_timeMaxHeight;

    TextField textfield_totalTime;
    Label label_totalTime;

    TextField textfield_xfinalVelocity;
    Label label_xfinalVelocity;

    TextField textfield_yfinalVelocity;
    Label label_yfinalVelocity;

    TextField textfield_finalAngle;
    Label label_finalAngle;

    TextField textfield_finalV;
    Label label_finalV;

    VBox getVBoxWithWidgets() {

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setSpacing(10);

        // the particle is launched from the origin at varying heights, but 
        // always initial x position is zero
        label_xInitial = getLabel("Initial Horizontal Position is always zero meters");

        label_yInitial = getLabel("Initial Vertical Position (meters): ");
        textfield_yInitial = getTextField(true);
        textfield_yInitial.setText(String.valueOf(YPOSIT));
        HBox hbox_ypos = getHBoxWithTwoFields(label_yInitial, textfield_yInitial);

        label_vxInitial = getLabel("Initial Horizontal Velocity (m/s): ");
        textfield_vxInitial = getTextField(true);
        textfield_vxInitial.setPromptText("..enter data here");
        HBox hbox_vx = getHBoxWithTwoFields(label_vxInitial, textfield_vxInitial);

        label_vyInitial = getLabel("Initial Vertical Velocity (m/s): ");
        textfield_vyInitial = getTextField(true);
        textfield_vyInitial.setPromptText("..enter data here");
        HBox hbox_vy = getHBoxWithTwoFields(label_vyInitial, textfield_vyInitial);

        label_totalVmagnitude = getLabel("Magnitude of Initial Velocity (m/s): ");
        textfield_totalVmagnitude = getTextField(true);
        textfield_totalVmagnitude.setPromptText("..enter data here");
        HBox hbox_totalVMag = getHBoxWithTwoFields(label_totalVmagnitude, textfield_totalVmagnitude);

        label_launchAngle = getLabel("Initial Angle (deg): ");
        textfield_launchAngle = getTextField(false);
        HBox hbox_launchAngle = getHBoxWithTwoFields(label_launchAngle, textfield_launchAngle);

        label_maxHeight = getLabel("Max Height (meters): ");
        textfield_maxHeight = getTextField(false);
        HBox hbox_maxHeight = getHBoxWithTwoFields(label_maxHeight, textfield_maxHeight);

        label_timeMaxHeight = getLabel("Time at Max Height (seconds): ");
        textfield_timeMaxHeight = getTextField(false);
        HBox hbox_timeMaxHeight = getHBoxWithTwoFields(label_timeMaxHeight, textfield_timeMaxHeight);

        label_totalTime = getLabel("Total Time (seconds): ");
        textfield_totalTime = getTextField(false);
        HBox hbox_totalTime = getHBoxWithTwoFields(label_totalTime, textfield_totalTime);

        // the projectile does not travel below 0 vertical meters
        label_yfinal = getLabel("Final Y-Position is always zero meters ");

        label_xfinal = getLabel("Final X-Position (meters from launch): ");
        textfield_xfinal = getTextField(false);
        HBox hbox_xfinal = getHBoxWithTwoFields(label_xfinal, textfield_xfinal);

        label_xfinalVelocity = getLabel("Final Velocity in the x-direction: ");
        textfield_xfinalVelocity = getTextField(false);
        HBox hbox_vxfinal = getHBoxWithTwoFields(label_xfinalVelocity, textfield_xfinalVelocity);

        label_yfinalVelocity = getLabel("Final Velocity in the y-direction: ");
        textfield_yfinalVelocity = getTextField(false);
        HBox hbox_vyfinal = getHBoxWithTwoFields(label_yfinalVelocity, textfield_yfinalVelocity);

        label_finalV = getLabel("Final Velocity's magnitude: ");
        textfield_finalV = getTextField(false);
        HBox hbox_finalV = getHBoxWithTwoFields(label_finalV, textfield_finalV);

        label_finalAngle = getLabel("Final angle: ");
        textfield_finalAngle = getTextField(false);
        HBox hbox_finalAngle = getHBoxWithTwoFields(label_finalAngle, textfield_finalAngle);

        Label instruction = getLabel("Please enter the data!");

        submitButton = getButton("Submit");
        submitButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                if (areVelocityFieldsComplete(textfield_vyInitial, textfield_vxInitial, textfield_totalVmagnitude) || isFieldCorrupt(textfield_yInitial)) {
                    MessageDialogBox mdb = new MessageDialogBox("No negative values or letters."
                            + " Atleast two velocity fields must be completed!");
                } else {

                    boolean flag = true;
                    // a flag to make sure both v-y initial 
                    // and v-x initial are less than the magnitude of v initial

                    double vyInitial = 0;
                    double vxInitial = 0;
                    double totalVmag = 0;
                    double launchAngle = 0;
                    double timeMaxHeight = 0;
                    double maxHeight = 0;
                    double totalTime = 0;
                    double initial_height = 0;
                    double xfinalPosition = 0;
                    double finalVY = 0;
                    double finalVX = 0;
                    double finalV = 0;
                    double finalAngle = 0;

                    if (isFieldCorrupt(textfield_vyInitial)) {

                        // in this scenario the initial velocity 
                        // in the y-direction was not given by the user
                        vxInitial = getTextFieldDouble(textfield_vxInitial);
                        totalVmag = getTextFieldDouble(textfield_totalVmagnitude);
                        if (vxInitial > totalVmag) {
                            flag = false;
                        } else {
                            vyInitial = Physics.calcVY(totalVmag, vxInitial);
                            textfield_vyInitial.setText(String.valueOf(vyInitial));
                        }

                    } else if (isFieldCorrupt(textfield_vxInitial)) {

                        // in this scenario the initial velocity 
                        // in the x-direction was not given by the user
                        vyInitial = getTextFieldDouble(textfield_vyInitial);
                        totalVmag = getTextFieldDouble(textfield_totalVmagnitude);
                        if (vyInitial > totalVmag) {
                            flag = false;
                        } else {
                            vxInitial = Physics.calcVX(totalVmag, vyInitial);
                            textfield_vxInitial.setText(String.valueOf(vxInitial));
                        }

                    } else {
                        // in this scenario the initial velocity's magnitude
                        // is calculated from the user provided 
                        // initial velocity in the x-direction
                        // and the initial velocity in the y-direction
                        vyInitial = getTextFieldDouble(textfield_vyInitial);
                        vxInitial = getTextFieldDouble(textfield_vxInitial);
                        totalVmag = Physics.calcVMagnitude(vxInitial, vyInitial);

                        textfield_totalVmagnitude.setText(String.valueOf(totalVmag));

                    }

                    if (flag) {
                        // get the initial height the user entered, default is zero
                        initial_height = getTextFieldDouble(textfield_yInitial);

                        // calculate the angle at which the projectile is launched
                        launchAngle = Physics.calcAngleDegrees(vxInitial, vyInitial);

                        // calculate the time in seconds, for the projectile 
                        // to reach max height
                        timeMaxHeight = Physics.calcTimeAtMaxHeight(vyInitial);

                        // calculate the max height in meters that the projectile 
                        // will reach
                        maxHeight = Physics.calcMaxHeight(vyInitial, timeMaxHeight, initial_height);

                        // calculate the total time the projectile will take 
                        // from launch, to reach the ground again
                        totalTime = Physics.calcTotalTime(vyInitial, initial_height);

                        // calculate how many meters the projectile has 
                        // traveled in the x-direction
                        xfinalPosition = Physics.calcXfinal(vxInitial, totalTime);

                        // calculate the final velocity in the x-direction at the moment
                        // the projectile hits the ground
                        finalVX = Physics.calcFinalXvelocity(vxInitial);

                        // calculate the final velocity in the y-direction at the moment 
                        // the projectile hits the ground
                        finalVY = Physics.calcFinalYvelocity(vyInitial, totalTime);

                        // calculate the final velocity's magnitude at the moment
                        // the projectile hits the ground
                        finalV = Physics.calcFinalVelocity(finalVY, finalVX);

                        // calculate the final angle the projectile makes with the ground
                        finalAngle = Physics.calcFinalAngleWithGround(finalVY, finalVX);

                        textfield_launchAngle.setText(String.valueOf(launchAngle));
                        textfield_timeMaxHeight.setText(String.valueOf(timeMaxHeight));
                        textfield_maxHeight.setText(String.valueOf(maxHeight));
                        textfield_totalTime.setText(String.valueOf(totalTime));
                        textfield_xfinal.setText(String.valueOf(xfinalPosition));
                        textfield_xfinalVelocity.setText(String.valueOf(finalVX));
                        textfield_yfinalVelocity.setText(String.valueOf(finalVY));
                        textfield_finalV.setText(String.valueOf(finalV));
                        textfield_finalAngle.setText(String.valueOf(finalAngle));

                        ParabolicFunctionGraph parabFuncGraph = new ParabolicFunctionGraph(maxHeight,
                                xfinalPosition, totalTime, vxInitial, vyInitial,
                                initial_height, timeMaxHeight, finalV);
                        bp.setCenter(parabFuncGraph);
                    } else {
                        MessageDialogBox mdb = new MessageDialogBox("An initial velocity component should not exceed "
                                + "the velocity's magnitude. Try again!");
                    }
                }
            }

        });
        clearButton = getButton("Clear");
        clearButton.setOnAction((ActionEvent event) -> {
            clearFields();
        });

        vbox.getChildren().addAll(new Label(""),
                instruction,
                label_xInitial,
                hbox_ypos,
                hbox_vx,
                hbox_vy,
                hbox_totalVMag,
                hbox_launchAngle,
                new Label(""),
                hbox_maxHeight,
                hbox_timeMaxHeight,
                new Label(""),
                hbox_totalTime,
                hbox_xfinal,
                hbox_vxfinal,
                label_yfinal,
                hbox_vyfinal,
                hbox_finalV,
                hbox_finalAngle,
                new Label(""),
                getButtonBox(submitButton, clearButton));

        return vbox;
    }

    double getTextFieldDouble(TextField textfield) {
        try {
            double val = Double.parseDouble(textfield.getText());
            return val;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    boolean isFieldCorrupt(TextField textfield) {

        try {
            double fieldVal = Double.parseDouble(textfield.getText());
            if (fieldVal < 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    boolean areVelocityFieldsComplete(TextField textfield1,
            TextField textfield2, TextField textfield3) {

        int count = 0;
        if (isFieldCorrupt(textfield1)) {
            count++;
        }
        if (isFieldCorrupt(textfield2)) {
            count++;
        }
        if (isFieldCorrupt(textfield3)) {
            count++;
        }
        return count > 1;
    }

    HBox getButtonBox(Button b1, Button b2) {
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(30);
        hbox.getChildren().addAll(b1, b2);
        return hbox;
    }

    HBox getHBoxWithTwoFields(Label label, TextField textfield) {
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(label, textfield);
        return hbox;
    }

    TextField getTextField(boolean isEditable) {
        TextField textfield = new TextField();
        textfield.setEditable(isEditable);
        textfield.setFont(Font.font("Arial", FontWeight.NORMAL,
                FontPosture.REGULAR, 18));
        textfield.setOpacity(.6);
        return textfield;
    }

    Label getLabel(String message) {
        Label label = new Label();
        label.setText(message);
        label.setFont(Font.font("Arial", FontWeight.BOLD,
                FontPosture.REGULAR, 18));
        label.setStyle("-fx-text-fill: yellow");
        label.setOpacity(.5);
        return label;
    }

    void clearFields() {
        textfield_vxInitial.clear();
        textfield_vyInitial.clear();
        textfield_totalVmagnitude.clear();
        textfield_totalTime.clear();
        textfield_launchAngle.clear();
        textfield_maxHeight.clear();
        textfield_timeMaxHeight.clear();
        textfield_xfinal.clear();
        textfield_yInitial.clear();
        textfield_yInitial.setText(String.valueOf(YPOSIT));
        textfield_xfinalVelocity.clear();
        textfield_yfinalVelocity.clear();
        textfield_finalV.clear();
        textfield_finalAngle.clear();

        // changed stuff here
        ParabolicFunctionGraph parabFuncGraph;
        parabFuncGraph = new ParabolicFunctionGraph(0, 0, 0, 0, 0, 0, 0, 0);
        bp.setCenter(parabFuncGraph);
    }

    Button getButton(String message) {
        Button b = new Button();
        b.setText(message);
        b.setStyle("-fx-color: green");
        b.setTextFill(Color.YELLOW);
        b.setFont(Font.font("Arial", FontPosture.REGULAR, 18));
        b.setOpacity(.47);
        return b;
    }

    @Override
    public void start(Stage primaryStage) {

        bp = new BorderPane();
        HBox root = new HBox(100);
        root.setAlignment(Pos.CENTER);
        ParabolicFunctionGraph parabFuncGraph;
        parabFuncGraph = new ParabolicFunctionGraph(0, 0, 0, 0, 0, 0, 0, 0);
        root.setPadding(new Insets(100, 20, 20, 20));

        bp.setCenter(parabFuncGraph);
        root.getChildren().addAll(getVBoxWithWidgets());
        bp.setLeft(root);
        Scene scene = new Scene(bp);

        scene.getStylesheets().addAll(this.getClass().getResource("PhysicsCSS.css").toExternalForm());
        bp.setId("calculator-background");
        bp.setStyle("-fx-border-width: 15; -fx-border-color: black");

        primaryStage.setTitle("Mother_Loving Physics!!");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

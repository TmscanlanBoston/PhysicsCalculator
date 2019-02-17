package physicscalculator;

import java.math.BigDecimal;
import java.math.MathContext;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javafx.util.Duration;

/**
 *
 * @author Thomas Scanlan
 */
@SuppressWarnings("unchecked")
class ParabolicFunctionGraph extends VBox {

    double x, y;
    double gravity = 9.8;
    double time = 0;
    double deltaT = .001;

    XYChart.Series series = new XYChart.Series();
    final LineChart<Number, Number> lineChart;

    String labelY;
    String labelX;

    double maxT = 0;
    double maxY = 0;

    double yMaxPos;
    double xfinalPos;
    double timeYmaxPos;
    double totalTime;
    double initialVX;
    double initialVY;
    double initial_height;
    double finalV;

    ParabolicFunctionGraph(double yMaxPos, double xfinalPos, double totalTime, double initialVX, double initialVY, double initial_height, double timeYmaxPos, double finalV) {

        this.yMaxPos = yMaxPos;
        this.xfinalPos = xfinalPos;
        this.totalTime = totalTime;
        this.initialVX = initialVX;
        this.initialVY = initialVY;
        this.initial_height = initial_height;
        this.timeYmaxPos = timeYmaxPos;
        this.finalV = finalV;

        y = initial_height;

        labelX = "Horizontal Position (Meters)";
        labelY = "Vertical Position (Meters)";

        NumberAxis xAxis = new NumberAxis();
        xAxis.setTickLabelFont(Font.font("Arial", FontWeight.THIN, 12));
        xAxis.setTickLabelFill(Color.YELLOW);

        NumberAxis yAxis = new NumberAxis();
        yAxis.setTickLabelFont(Font.font("Arial", FontWeight.THIN, 12));
        yAxis.setTickLabelFill(Color.YELLOW);

        lineChart = new LineChart<Number, Number>(xAxis, yAxis) {

            @Override
            protected void dataItemAdded(Series<Number, Number> series, int itemIndex, Data<Number, Number> item) {
            }

        };

        this.lineChart.getStylesheets().add(getClass().getResource("PhysicsCSS.css").toExternalForm());
        xAxis.setAutoRanging(false);
        yAxis.setAutoRanging(false);

        lineChart.getData().add(series);
        lineChart.legendVisibleProperty().setValue(Boolean.FALSE);
        lineChart.setTitle("Animating the Trajectory");
        lineChart.setPrefSize(800, 900);

        xAxis.setLabel(labelX);
        xAxis.setTickUnit(2);
        yAxis.setTickUnit(2);
        /*
         yAxis.setLabel(labelY);
         if (initial_height > 10) {
         yAxis.setTickUnit((initialVY)/10); 
         } 
         else {
         yAxis.setTickUnit(initialVY/5);
         }*/

        int numberOfCycles = (int) (totalTime / deltaT) + 1;

        // double bound = (xfinalPos > yMaxPos ? xfinalPos : yMaxPos) * 1.05;
        xAxis.setUpperBound(xfinalPos * 1.1);
        yAxis.setUpperBound(yMaxPos * 1.1);

        Label lb_fractionalError = new Label();
        lb_fractionalError.setTextFill(Color.YELLOW);
        lb_fractionalError.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        lb_fractionalError.setOpacity(.5);

        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
        this.setPadding(new Insets(20, 20, 20, 20));
        this.getChildren().addAll(lineChart);

        EventHandler<ActionEvent> eventHandler = e -> {
            this.myUpdate();
        };

        Timeline animation = new Timeline(
                new KeyFrame(Duration.seconds(deltaT), eventHandler));
        animation.setCycleCount(numberOfCycles); // change this later
        animation.play();
        animation.setOnFinished((ActionEvent ae) -> {
            try {
                BigDecimal bd = new BigDecimal((gravity * deltaT) / Math.abs(finalV));
                bd = bd.round(new MathContext(8));
                lb_fractionalError.setText("The fractional error in Y position: " + bd + ", the fractional error in X position: " + bd);
                this.getChildren().add(lb_fractionalError);
            } catch (NumberFormatException nfe) {
                lb_fractionalError.setText("The fraction error in Y position: " + 0 + ", the fractional error in X position: " + 0);
                this.getChildren().add(lb_fractionalError);
            }
        });

    }

    public void myUpdate() {

        // time is current time
        // x is current x-position
        x = initialVX * time;

        // the following is the original way we graphed the data
        // y is current y-position        
        // 
        // y = (-.5 * gravity * (time * time)) + (initialVY * time) + initial_height;
        y += (initialVY * deltaT); // in this case y is the current y-position
        initialVY += -gravity * deltaT; // initialVY is changed everytime this function is called

        series.getData().add(new XYChart.Data(x, y));
        time += deltaT; // add .001 to current time
    }

}

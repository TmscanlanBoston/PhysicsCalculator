/* 
 * Thomas Scanlan  *
 */
package physicscalculator;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Thomas Scanlan
 */
public class MessageDialogBox {

    MessageDialogBox(String text) {
        Stage okStage = new Stage();
        okStage.setTitle("Error");
        VBox box = new VBox(25);

        Label message = new Label(text);
        message.setOpacity(.8);
        message.setText(text);
        message.setShape(new Rectangle());
        message.setFont(Font.font("Comic Sans MS", FontWeight.BOLD,
                FontPosture.REGULAR, 18));
        message.setTextFill(Color.YELLOW);

        Button okButton = new Button("Okay");
        okButton.setTextFill(Color.YELLOW);
        okButton.setFont(Font.font("Comic Sans MS", FontWeight.EXTRA_BOLD, 20));
        okButton.setStyle("-fx-color: darkgreen");
        okButton.setOnAction((ActionEvent ae) -> {
            okStage.close();
        });

        box.setStyle("-fx-background-color: black;"
                + " -fx-border-color: darkgreen; -fx-border-width: 5;");
        okButton.setOpacity(.7);
        okButton.setAlignment(Pos.CENTER);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(15, 15, 15, 15));
        box.getChildren().addAll(message, okButton);
        Scene scene = new Scene(box);
        okStage.setScene(scene);
        okStage.show();
    }
}

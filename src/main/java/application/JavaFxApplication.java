package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class JavaFxApplication extends Application {

    @Override
    public void start(Stage window) {
        TextField textField = new TextField();
        Label label = new Label();
        Button button = new Button("Update");

        button.setOnAction((event) -> {
            label.setText(textField.getText());
        });


        VBox componentGroup = new VBox();
        componentGroup.setSpacing(20);
        componentGroup.getChildren().addAll(textField, button, label);

        Scene viewport = new Scene(componentGroup);

        window.setScene(viewport);
        window.show();
    }

    public static void main(String[] args) {
        launch(JavaFxApplication.class);
    }
}
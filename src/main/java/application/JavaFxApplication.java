package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Arrays;

public class JavaFxApplication extends Application {

    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();

        HBox texts = new HBox();
        texts.setSpacing(10);

        Label lettersInText = new Label("Letters: 0");
        Label wordsInText  = new Label("Words: 0");
        Label longestWord = new Label("Longest word is: ");
        texts.getChildren().add(lettersInText);
        texts.getChildren().add(wordsInText);
        texts.getChildren().add(longestWord);

        TextArea textArea = new TextArea("");
        textArea.textProperty().addListener((observable, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts).sorted((s1, s2) -> s2.length() - s1.length()).findFirst().get();

            lettersInText.setText("Letters: " + characters);
            wordsInText.setText("Words: " + words);
            longestWord.setText("Longest word is: " + longest);
        });


        layout.setCenter(textArea);
        layout.setBottom(texts);

        Scene viewport = new Scene(layout);

        window.setScene(viewport);
        window.show();
    }

    public static void main(String[] args) {
        launch(JavaFxApplication.class);
    }
}
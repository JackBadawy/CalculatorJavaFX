package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {
    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("CalculatorFX");
        Image icon = new Image(getClass().getResourceAsStream("/calc.png"));
        primaryStage.getIcons().add(icon);

        Parent root = FXMLLoader.load(getClass().getResource("/main.fxml"));

        HBox titleBar = new HBox();
        titleBar.setStyle("-fx-background-color: #2c2c2c; -fx-padding: 10;");
        titleBar.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        
        Label titleLabel = new Label("CalculatorFX");
        titleLabel.setStyle("-fx-text-fill: white;");
        
        Button closeButton = new Button("X");
        closeButton.setStyle("-fx-background-color: #ff0000; -fx-padding: 0; -fx-text-fill: white; -fx-max-width: 24px; -fx-border-color: #ff0000;");
        closeButton.setOnAction(e -> primaryStage.close());
        
        HBox spacer = new HBox();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        
        titleBar.getChildren().addAll(titleLabel, spacer, closeButton);

        titleBar.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        titleBar.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });

        VBox container = new VBox();
        container.setStyle(" -fx-background-radius: 10 10 0 0; -fx-border-radius: 10 10 0 0;");
        container.getChildren().addAll(titleBar, root);

        Scene scene = new Scene(container, 300, 340);
        scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
        
        scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
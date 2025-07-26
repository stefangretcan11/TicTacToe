package samples.demo3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("Mainprincipal.fxml"));
            Scene scene = new Scene(root,600,400);
            scene.getStylesheets().add(getClass().getResource("mainprincipal.css").toExternalForm());
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
package Final_Project_Bagel;
/**
 * @author Jay Patel
 * @version 1.0
 */
// import statements
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class finalBagel extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     *
     * @param primaryStage - will set the stage for the code
     * @throws IOException - will throw an input-output exception
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("bagel.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setTitle("Sheridan Bagel Shop");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

package Assignment6;
/**
 * @author Jay Patel 
 * @version 1.0
 */
// import statements for library access of predefined methods
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.control.Alert;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class salesCommission  extends Application implements EventHandler<ActionEvent>
{
    /*
    private variables to access the data from the user.my label is the label to the user,
    then there are 3 buttons for user which are sales commission, sales amount and exit button
    then there are variables for counting the commissions
     */
    private Label myLabel;
    private TextField myTextField;
    private Button Commission;
    private Button Amount;
    private Button yourButton;
    private double countC;
    private double countA;
    private double commission;
    private double amount;
    FlowPane pane;

    /**
     * init method used for putting layout in-front of user
     */
    public void init()
    {
        //it will set spacing between and around the buttons and the box
        pane = new FlowPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setHgap(20);
        pane.setVgap(20);

        // create label, and buttons
        myLabel = new Label("Please enter the amount : ");
        myTextField = new TextField();
        Commission = new Button ("_Compute Sales Commission");
        Amount = new Button ("_Compute Sales Amount");
        //focus here for shortcut key
        yourButton  =  new Button ("E_xit");
        pane.getChildren().add(myLabel);
        pane.getChildren().add(myTextField);
        pane.getChildren().add(Commission);
        pane.getChildren().add(Amount);
        pane.getChildren().add(yourButton);
        Commission.setOnAction(this);
        Amount.setOnAction(this);
        yourButton.setOnAction(this);
    }

    @Override // Override the start method in the Application class
    /**
     * Start method for layout building
     */
    public void start(Stage primaryStage)
    {
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 370, 200);
        primaryStage.setTitle("Sales Conversion"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent e) {
    /*
    if statement will show error if the input is not a number.
     */
        if (!Commission.getText().matches("[0-9]*")) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Oops! Number Expected!");
            alert.showAndWait();
        }
        /*
    this statements will show the output according to the user.
     */
            Commission = (Button) e.getSource();
            commission = Double.parseDouble((myTextField.getText()));
            // if statements for counting sales commission
            if (commission > 0 && commission < 5001) {
                countC = ((commission * 8) / 100);
            } else if (commission <= 10001) {
                countC = (((commission - 5000) * 10) / 100) + ((5000 * 8) / 100);
            } else {
                countC = ((5000 * 8) / 100) + ((5000 * 10) / 100) + (((commission - 10000) * 12) / 100);
            }

        // if statements for counting sales amount
            Amount = (Button) e.getSource();
            amount = Double.parseDouble((myTextField.getText()));
            if (amount > 0 && amount < 401) {
                countA = ((amount * 8) / 100);
            } else if (amount < 901) {
                countA = (((amount - 400) * 10) / 100) + ((400 * 8) / 100);
            } else {
                countA = ((400 * 8) / 100) + ((500 * 10) / 100) + (((amount - 900) * 12) / 100);
            }
        // if statements for exit
            if (yourButton == e.getSource())
                System.exit(0);   //Platform.exit();
        // if statement for showing message
            if (Commission == e.getSource()) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText("The answer is:");
                alert.setContentText("the Sales Amount of " + String.valueOf(countC)
                        + "\nis needed to make a Sales Commission of " + String.valueOf(countA) + ".");
                alert.showAndWait();
            } else if (Amount == e.getSource()) {
                Alert alertA = new Alert(AlertType.INFORMATION);
                alertA.setTitle("Message");
                alertA.setHeaderText("The answer is:");
                alertA.setContentText("The Sales Commission is " + String.valueOf(countC)
                        + ".\nFor the Sales Amount of " + String.valueOf(countA) + ".");
                alertA.showAndWait();
            }




    }
}

package Final_Project_Bagel;
/**
 * @author Jay Patel
 * @version 1.0
 */
// import statements
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class finalBagelController {

    //main flow pane
    @FXML
    private FlowPane main;
    @FXML
    private Label printRec; //main heading

    // subMain pane for store all the components
    @FXML
    private Pane submain;

    // pane for bagel
    @FXML
    private Pane bagelMain; // main pane to store begal details
    @FXML
    private Label headBagel; //head of label
    @FXML
    private Label bagelQty; // label quantity
    @FXML
    private ToggleGroup Bagel;
    @FXML
    private TextField whe;
    @FXML
    private TextField who;
    @FXML
    private RadioButton bagelNone;
    @FXML
    private RadioButton bagelWho;
    @FXML
    private RadioButton bagelWhi;

    // pane for coffee
    @FXML
    private Pane CoffeeMain;
    @FXML
    private Label headCoffee;
    @FXML
    private ToggleGroup Coffee;
    @FXML
    private RadioButton non;
    @FXML
    private RadioButton regu;
    @FXML
    private RadioButton capp;
    @FXML
    private RadioButton caff;
    @FXML
    private Label qty;
    @FXML
    private TextField caf;
    @FXML
    private TextField cap;
    @FXML
    private TextField reg;

    //pane for toppings
    @FXML
    private Pane toppingsMain;
    @FXML
    private Label headToppings;
    @FXML
    private CheckBox but;
    @FXML
    private CheckBox ras;
    @FXML
    private CheckBox peach;
    @FXML
    private CheckBox cream;
    @FXML
    private CheckBox blue;

    //pane for price summary
    @FXML
    private Pane priceMain;
    @FXML
    private Label sub;
    @FXML
    private Label subTotal;
    @FXML
    private Label tot;
    @FXML
    private Label headPrice;
    @FXML
    private Label tax;
    @FXML
    private Label sale;
    @FXML
    private Label totalSale;

    // bottom menus
    @FXML
    private Button exit;
    @FXML
    private Button calcTotal;
    @FXML
    private Button reset;

    // private variable to store cost and tax of the billing amount
    private double addToPrice;
    private double totalTax;

    /**
     *
     * @return - will return the price of bagel
     */
    @FXML
    public double orderOfBagel() {
        // will count the billing amount and tax amount
        if (bagelWhi.isSelected()) {
            int quantity = Integer.valueOf(whe.getText());
            addToPrice = quantity * 1.25;
            return addToPrice;

        } else if (bagelWho.isSelected()) {
            int quantity = Integer.valueOf(who.getText());
            addToPrice = quantity * 1.50;
            return addToPrice;
        }
        return addToPrice = 0;
    }

    /**
     *
     * @return - will return the price of coffee
     */
    public double orderOfCoffee() {
        if (non.isSelected()) {
            int quantity = 0;
            return addToPrice = 0;
        } else if (regu.isSelected()) {
            int quantity = Integer.valueOf(reg.getText());
            addToPrice = quantity * 1.25;
            return addToPrice;
        } else if (capp.isSelected()) {
            int quantity = Integer.valueOf(cap.getText());
            addToPrice = quantity * 2.00;
            return addToPrice;
        } else if (caff.isSelected()) {
            int quantity = Integer.valueOf(caf.getText());
            addToPrice = quantity * 1.75;
            return addToPrice;
        }
        return addToPrice = 0;
    }

    /**
     *
     * @return - will return the price of toppings
     */
    public double toppings() {
        addToPrice = 0;
        if (cream.isSelected()) {
            addToPrice = addToPrice + 0.50;
        }
        if (but.isSelected()) {
            addToPrice = addToPrice + 0.25;
        }
        if (blue.isSelected()) {
            addToPrice = addToPrice + 0.75;
        }
        if (ras.isSelected()) {
            addToPrice = addToPrice + 0.75;
        }
        if (peach.isSelected()) {
            addToPrice = addToPrice + 0.75;
        }
        return addToPrice;
    }

    /**
     *
     * @param eventTotal - will return the price of total bill
     * @throws FileNotFoundException - if not found the file will throw an exception
     */
    @FXML
    public void calculateTotal(ActionEvent eventTotal) throws FileNotFoundException {
        // will store the value of bagel, coffee, and toppings
        double bagelPriceTot = orderOfBagel();
        double coffeePriceTot = orderOfCoffee();
        double toppingsPriceTot = toppings();
        double totalBillAmt = bagelPriceTot + coffeePriceTot + toppingsPriceTot;
        String totalBillingAmt = String.format("$%6.2f", totalBillAmt);
        subTotal.setText("" + totalBillingAmt);
        totalTax = totalBillAmt * 0.13;

        String totalTaxBill = String.format("$%5.2f", totalTax);
        tax.setText("" + totalTaxBill);
        double finalBillAmt = totalBillAmt + totalTax;

        String finalBillingAmt = String.format("$%6.2f", finalBillAmt);
        totalSale.setText("" + finalBillingAmt);

        // will print the receipt
        try {
            System.out.println("Your Bill is Printing to the file...Success!");
            PrintWriter writer = new PrintWriter("orderReceipt.txt", "UTF-8");

            writer.println("***********SHERIDAN BAGEL SHOP***********");
            writer.println(date.toString());
            writer.println("Item:\t\t\tQty\t\tAmount");
            if (bagelWhi.isSelected()) {
                writer.print("White Bagel\t\t");
                writer.print(whe.getText() + "\t\t$");
                writer.println((1.25 * Double.parseDouble(whe.getText())));
                writer.println("Toppings:");
                if (cream.isSelected()) {
                    writer.print(" Cream Cheese\t1\t\t$0.50");
                }
                if (but.isSelected()) {
                    writer.print("\n Butter\t\t1\t\t$0.25");
                }
                if (blue.isSelected()) {
                    writer.print("\n Blueberry Jam\t\t1\t\t$0.75");
                }
                if (ras.isSelected()) {
                    writer.print("\n Raspberry Jam\t\t1\t\t$0.75");
                }
                if (peach.isSelected()) {
                    writer.print("\n Peach Jelly\t\t1\t\t$0.75");
                }
                if (regu.isSelected()) {
                    writer.print("\nRegular Coffee\t\t");
                    writer.print(Integer.parseInt(reg.getText()));
                    writer.println("\t" + 1.25 * Integer.parseInt(reg.getText()));
                }
                if (capp.isSelected()) {
                    writer.print("\nCappuccino Coffee\t\t");
                    writer.print(Integer.parseInt(cap.getText()));
                    writer.println("\t" + 2.00 * Integer.parseInt(cap.getText()));
                }
                if (caff.isSelected()) {
                    writer.print("\nCafe Au Lait\t\t");
                    writer.print(Integer.parseInt(caf.getText()));
                    writer.println("\t" + 1.25 * Integer.parseInt(caf.getText()));
                }
            }
            if (bagelWho.isSelected()) {
                writer.print("Whole Bagel\t\t");
                writer.print(who.getText() + "\t");
                writer.println((1.50 * Double.parseDouble(who.getText())));
                writer.println("Toppings:");
                if (cream.isSelected()) {
                    writer.print("\n Cream Cheese\t\t1\t\t$0.50");
                }
                if (but.isSelected()) {
                    writer.print("\n Butter\t\t1\t\t$0.25");
                }
                if (blue.isSelected()) {
                    writer.print("\n Blueberry Jam\t\t1\t\t$0.75");
                }
                if (ras.isSelected()) {
                    writer.print("\n Raspberry Jam\t\t1\t\t$0.75");
                }
                if (peach.isSelected()) {
                    writer.print("\n Peach Jelly\t\t1\t\t$0.75");
                }
                if (regu.isSelected()) {
                    writer.print("\nRegular Coffee\t\t");
                    writer.print(Integer.parseInt(reg.getText()));
                    writer.println("\t\t" + 1.25 * Integer.parseInt(reg.getText()));
                }
                if (capp.isSelected()) {
                    writer.print("\nCappuccino Coffee\t\t");
                    writer.print(Integer.parseInt(cap.getText()));
                    writer.println("\t\t" + 2.00 * Integer.parseInt(cap.getText()));
                }
                if (caff.isSelected()) {
                    writer.print("\nCafe Au Lait\t\t");
                    writer.print(Integer.parseInt(caf.getText()));
                    writer.println("\t" + 1.25 * Integer.parseInt(caf.getText()));
                }
            }
            writer.println("\t\t\t\t-------------------");
            writer.println("Pretax Total\t\t\t\t" + subTotal.getText());
            writer.println("Sales Tax 13%\t\t\t\t" + tax.getText());
            writer.println("Total Sale \t\t\t\t\t" + totalSale.getText());
            writer.println("******THANK YOU FOR YOUR ORDER******");
            writer.close();
        } catch (Exception localException) {
            System.out.println("Error in writing the file");
        }
    }

    /**
     *
     * @param reset- will reset the whole form
     */
    public void reset(ActionEvent reset) {
            resetBagel();
            resetCoffee();
            resetToppings();
            resetPrice();
    }

    // will reset the bagel
    public void resetBagel(){
    bagelNone.setSelected(false);
        bagelWhi.setSelected(false);
        bagelWho.setSelected(false);
        whe.setText("");
        who.setText("");
}
        // will reset the coffee
        public void resetCoffee(){
        non.setSelected(false);
        regu.setSelected(false);
        capp.setSelected(false);
        caff.setSelected(false);
        reg.setText("");
        cap.setText("");
        caf.setText("");
    }

    /**
     * will reset the bagel toppings
      */

    public void resetToppings() {
        cream.setSelected(false);
        but.setSelected(false);
        blue.setSelected(false);
        ras.setSelected(false);
        peach.setSelected(false);
    }

        // will reset the price summary
    public void resetPrice(){
        subTotal.setText("$0.00");
        tax.setText("$0.00");
        totalSale.setText("$0.00");
    }

    // will print
    java.util.Date date = new java.util.Date();

    /**
     *
     * @param ex - will exit the form
     */
    @FXML
    public void exit(ActionEvent ex) {
        Stage ext = (Stage) exit.getScene().getWindow();
        ext.close();
    }
}

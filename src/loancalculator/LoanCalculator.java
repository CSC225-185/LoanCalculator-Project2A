/*
 * CSC-225 - Advanced JAVA Programming
 * Project 2A - LoanCalculator Lab Assignment
 * Class Description : This is the driver class for the loan calculator program
 * Author            : Unknown - Code supplied in class
 * Date              : October 5, 2017
 * Filename          : LoanCalculator.java
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * <h1>
 * CSC-225 - Advanced JAVA Programming - LoanCalculator Lab Assignment
 * </h>
 * <p>
 * This is the driver class for the loan calculator program
 * </p>
 *
 * @vewrsion 1.0
 * @since October 5, 2017
 */
 
public class LoanCalculator extends Application {

   /**
    * Main method for driver class
    *
    * @params args legacy component for access to system resources
    */
   
   public static void main (String[] args) {
      launch(args);                                                  // Launch the program (primary Stage)
   }
   
   private TextField tfAnnualInterestRate = new TextField();         // Define text fields
   private TextField tfNumberOfYears = new TextField();
   private TextField tfLoanAmount = new TextField();
   private TextField tfMonthlyPayment = new TextField();
   private TextField tfTotalPayment = new TextField();
   private Button btCalculate = new Button ("Calculate");            // Define button
   
   @Override                                                         // Override the start method in the Appliation class
   public void start(Stage primaryStage) {
        // Create UI
      GridPane gridPane = new GridPane();                            // Create a gridpane pane
      gridPane.setHgap(5);                                           // Set the horizontal gap between the elements
      gridPane.setVgap(5);                                           // Set the vertical gap between the elements
      gridPane.add(new Label("Annual Interest Rate:"), 0, 0);        // Add the Annual Interest Rate label to the gridpane
      gridPane.add(tfAnnualInterestRate, 1, 0);                      // Add the Annual Interest Rate textbox to the gridpane
      gridPane.add(new Label("Number of Years:"), 0, 1);             // Add the Number of Years label to the gridpane
      gridPane.add(tfNumberOfYears, 1, 1);                           // Add the Number of Years textbox to the gridpane
      gridPane.add(new Label("Loan Amount:"), 0, 2);                 // Add the Loan Amount label to the gridpane
      gridPane.add(tfLoanAmount, 1, 2);                              // Add the Loan Amount textbox to the gridpane
      gridPane.add(new Label("Monthly Paynent:"), 0, 3);             // Add the Monthly Payment label to the gridpane
      gridPane.add(tfMonthlyPayment, 1, 3);                          // Add the Monthly Payment textbox to the gridpane
      gridPane.add(new Label("Total Payment:"), 0, 4);				 // Add the Total Payment label to the gridpane
      gridPane.add(tfTotalPayment, 1, 4);							 // Add the Total Payment textbox to the gridpane
      gridPane.add(btCalculate, 1, 5);								 // Add the Calculate button to the gridpane
      
		// Set properties for UI
      gridPane.setAlignment(Pos.CENTER);							// Set gridpane alignment to center
      tfAnnualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);			// Set alignment of Annual Interest Rate textbox to bottom right
      tfNumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);				// Set alignment of Number of Years textbox to bottom right
      tfLoanAmount.setAlignment(Pos.BOTTOM_RIGHT);					// Set alignment of Loan Amount textbox to bottom right
      tfMonthlyPayment.setAlignment(Pos.BOTTOM_RIGHT);				// Set alignment of Monthly Payment textbox to bottom right
      tfTotalPayment.setAlignment(Pos.BOTTOM_RIGHT);				// Set alignment of Total Payment textbox to bottom right
      tfMonthlyPayment.setEditable(false);							// Set the editable property of the Monthly Paymnet textbox to false (not allowed to edit)
      tfTotalPayment.setEditable(false);							// Set the editable property of the Total Payment textbox to false (not allowed to edit)
      GridPane.setHalignment(btCalculate, HPos.RIGHT);				// Set the horizontal alignment of the calculate button to right
      
      // Process events
      btCalculate.setOnAction(e -> calculateLoanPayment());			// Add an action listener to the calculate button
      
      // Create a scene and place it in the stage
      Scene scene = new Scene(gridPane, 400, 250);					// Define and create the new scene with defined parameters (size)
      primaryStage.setTitle("LoanCalculator"); 						// Set title
      primaryStage.setScene(scene); 								// Place the scene in the stage
      primaryStage.show(); 											// Display the stage
   }

   private void calculateLoanPayment() {
      // Get values from text fields
      double interest = Double.parseDouble(tfAnnualInterestRate.getText()); // Get the interest rate from textbox, convert to double and store in variable
      int year = Integer.parseInt(tfNumberOfYears.getText());				// Get the period from the textbox convert to integer and store in variable
      double loanAmount = Double.parseDouble(tfLoanAmount.getText());		// Get the loan amount from the textbox, convert to double and store in variable
      
      // Create a loan object.  Loan defined in listing 10.2
      Loan loan = new Loan(interest, year, loanAmount);				//  Create new object using information read from GUI
      
      //Display monthly payment and total payment
      tfMonthlyPayment.setText(String.format("$%.2f", loan.getMonthlyPayment())); 	// Get the monthly payment from the object, format it to look good and display it in the textbox
      tfTotalPayment.setText(String.format("$%.2f", loan.getTotalPayment())); 		// Get the total payment from the object, format it to look good and display it in the textbox
   }

}
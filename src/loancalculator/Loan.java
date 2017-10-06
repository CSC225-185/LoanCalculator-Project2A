package loancalculator;

/*
 * CSC-225 - Advanced JAVA Programming
 * Project 2A - LoanCalculator Lab Assignment
 * Class Description : This is the driver class for the loan calculator program
 * Author            : Unknown - Code supplied in class
 * Date              : October 5, 2017
 * Filename          : LoanCalculator.java
 */

public class Loan {
   private double annualInterestRate;
   private int numberOfYears;
   private double loanAmount;
   private java.util.Date loanDate;
   
   /** Default constructor */
   public Loan() {
      this(2.5, 1, 1000);
   }
   

      
   /**
    * Construct a loan with specified annual interest rate,
    * number of years, and loan amount
    * 
    * @param annualInterestRate
    * @param numberOfYears
    * @param loanAmount 
    */
      
   public Loan (double annualInterestRate, int numberOfYears,
         double loanAmount) {
      this.annualInterestRate = annualInterestRate;
      this.numberOfYears = numberOfYears;
      this.loanAmount = loanAmount;
      loanDate = new java.util.Date();
   }
   
   /**
    * Return annualInterestRate
    * 
    * @return annualInterestRate
    */
   public double getAnnualInterestRate() {
      return annualInterestRate;   
   }
   
   /**
    * Set a new annualInterestRate
    * 
    * @param annualInterestRate 
    */
   public void setAnnualInterestRate(double annualInterestRate) {
      this.annualInterestRate = annualInterestRate;
   }
   
   /**
    * Return numberOfYears
    * 
    * @return numberOfYears
    */
   public int getNumberOfYears() {
      return numberOfYears;   
   }
   
   /**
    * Set a new numberOfYears
    * 
    * @param numberOfYears 
    */
   public void setNumberOfYears (int numberOfYears) {
      this.numberOfYears = numberOfYears;
   }   
   
   /**
    * Return loan Amount
    * 
    * @return loanAmount
    */
    
   public double getloanAmount() {
      return loanAmount;
   }
   
   /**
    * Set a new loanAmount
    * 
    * @param loanAmount 
    */
   public void setloanAmount(double loanAmount) {
      this.loanAmount = loanAmount;
   }
   
   /**
    * Find monthly payment
    * 
    * @return monthlyPayment
    */
   public double getMonthlyPayment() {
      double monthlyInterestRate = annualInterestRate / 1200;
      double monthlyPayment = loanAmount * monthlyInterestRate / (1 - 
         (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
      return monthlyPayment;
   }
   
   /**
    * Find total payment
    * 
    * @return totalPayment
    */
   public double getTotalPayment() {
      double totalPayment = getMonthlyPayment() * numberOfYears * 12;
      return totalPayment;   
   }
   
   /**
    * Return loan date
    * 
    * @return loanDate
    */
   public java.util.Date getLoanDate() {
      return loanDate;
   }

}
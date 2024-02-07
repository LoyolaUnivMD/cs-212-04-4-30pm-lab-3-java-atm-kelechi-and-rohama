// Programmers:  Kelechi and Rohama
// Course:  CS 212
// Due Date: 10.02.23
// Lab Assignment: 3
// Problem Statement: Helping the user with bank statments 
// Data In: user name, choosing what option they want to use
// Data Out: updated amount of their balance
// Credits: notes

import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
      
      //1. Ask the user to enter their name using Scanner

       System.out.println("Please enter your name:");
       String name = scanner.nextLine();
      
      //2. Initialize the balance by calling the atm() method

      double balance = atm();
       System.out.println("Hello, " + name + "! Please choose what you'd like to do:");
      
      //3. Display a prompt for the user to choose an action: Deposit, Withdraw, Check Balance, or Exit
      
       System.out.println("D eposit \nW ithdraw \nB alance \nE xit");
       String option = scanner.nextLine().toUpperCase().strip();
      
// 4. Based on the user's input, execute the corresponding method: depositFunds(), withdrawFunds(), displayBalance(), or quit the program
      
      while(!option.equals("E")){
        if (option.equals("D")) {
           balance = depositFunds(balance);
         } else if (option.equals("W")) {
           balance = withdrawFunds(balance);
         } else if (option.equals("B")) {
           displayBalance(balance);
         } else { 
           System.out.println("This is not a valid option.");
         }
            System.out.println("Hello, " + name + "! Please choose what you'd like to do:");
           System.out.println("D eposit \nW ithdraw \nB alance \nE xit");
          option = scanner.nextLine().toUpperCase().strip();
       }
    System.out.println("Thanks for banking");
    }
  
//5. The atm() method initializes the balance and displays it

    public static double atm() {
        double balance = 212.90;
        displayBalance(balance);
        return balance;
    }

  //6. The displayBalance() method prints the current balance and checks for a negative balance
  
    public static void displayBalance(double balance) {
        System.out.println("Present Balance is: $" + balance);
        negativeBalance(balance);
    }
//7. The depositFunds() method prompts the user to input the deposit amount and adds it to the balance
  
    public static double depositFunds(double balance) {
        Scanner scanner = new Scanner(System.in);
        double deposit;
        do {
            System.out.println("How much to deposit?");
            deposit = scanner.nextDouble();
        } while (deposit < 0);
        balance += deposit;
        displayBalance(balance);
        return balance;
    }

  //8. The withdrawFunds() method prompts the user to input the withdrawal amount, subtracts it from the balance, and then checks for a negative balance
  
    public static double withdrawFunds(double balance) {
        Scanner scanner = new Scanner(System.in);
        double withdraw;
        do {
            System.out.println("How much to withdraw?");
            withdraw = scanner.nextDouble();
        } while (withdraw < 0);
        balance -= withdraw;
        negativeBalance(balance);
        displayBalance(balance);
        return balance;
    }

  //9. The negativeBalance() method checks if the balance is negative and prints a warning message
  
    public static void negativeBalance(double balance) {
        if (balance < 0) {
            System.out.println("You have a negative balance, 5% charge will occur");
        }
    }

}

import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountSimulation {

private static double balance = 0.0;

private static ArrayList<String> transactions = new ArrayList<>();

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int choice = 0;

    do {
        System.out.println("\n===== BANK ACCOUNT SIMULATION =====");
        System.out.println("1. Deposit Money");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Check Balance");
        System.out.println("4. Transaction History");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");

        if (!sc.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number from 1 to 5.");
            sc.next();
            continue;
        }

        choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.print("Enter amount to deposit: ");

                if (!sc.hasNextDouble()) {
                    System.out.println("Invalid amount!");
                    sc.next();
                    break;
                }

                double depositAmount = sc.nextDouble();

                if (depositAmount <= 0) {
                    System.out.println("Amount must be greater than zero.");
                } else {
                    balance += depositAmount;
                    transactions.add("Deposited: " + depositAmount);
                    System.out.println("Deposit successful!");
                    System.out.printf("Current Balance: %.2f%n", balance);
                }
                break;

            case 2:
                System.out.print("Enter amount to withdraw: ");

                if (!sc.hasNextDouble()) {
                    System.out.println("Invalid amount!");
                    sc.next();
                    break;
                }

                double withdrawAmount = sc.nextDouble();

                if (withdrawAmount <= 0) {
                    System.out.println("Amount must be greater than zero.");
                } else if (withdrawAmount > balance) {
                    System.out.println("Insufficient balance!");
                } else {
                    balance -= withdrawAmount;
                    transactions.add("Withdrawn: " + withdrawAmount);
                    System.out.println("Withdrawal successful!");
                    System.out.printf("Current Balance: %.2f%n", balance);
                }
                break;

            case 3:
                System.out.printf("Current Balance: %.2f%n", balance);
                break;

            case 4:
                System.out.println("\n===== TRANSACTION HISTORY =====");

                if (transactions.isEmpty()) {
                    System.out.println("No transactions yet.");
                } else {
                    for (String transaction : transactions) {
                        System.out.println(transaction);
                    }
                }
                break;

            case 5:
                System.out.println("Thank you for using our banking system!");
                break;

            default:
                System.out.println("Invalid choice! Please select 1 to 5.");
        }

    } while (choice != 5);

    sc.close();
}

}
import java.util.InputMismatchException;
import java.util.Scanner;

public class ATMSystem {

    static class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.printf("Deposited: $%.2f%n", amount);
            } else {
                System.out.println("Invalid deposit amount. Must be greater than zero.");
            }
        }

        public boolean withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.printf("Withdrew: $%.2f%n", amount);
                return true;
            } else {
                System.out.println("Insufficient balance or invalid withdrawal amount. Must be positive and less than or equal to current balance.");
                return false;
            }
        }
    }

    
    static class ATM {
        private BankAccount account;
        private Scanner scanner;

        public ATM(BankAccount account) {
            this.account = account;
            this.scanner = new Scanner(System.in);
        }

        public void showMenu() {
            while (true) {
                System.out.println("\nATM Menu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");

                int choice = getValidInteger("Choose an option: ", 1, 4);

                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        return;
                }
            }
        }

        private void checkBalance() {
            System.out.printf("Current balance: $%.2f%n", account.getBalance());
        }

        private void deposit() {
            double amount = getValidDouble("Enter deposit amount: ");
            account.deposit(amount);
        }

        private void withdraw() {
            double amount = getValidDouble("Enter withdrawal amount: ");
            account.withdraw(amount);
        }

        private int getValidInteger(String prompt, int min, int max) {
            while (true) {
                try {
                    System.out.print(prompt);
                    int choice = scanner.nextInt();
                    if (choice >= min && choice <= max) {
                        return choice;
                    } else {
                        System.out.println("Invalid choice. Please enter a number between " + min + " and " + max + ".");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a numeric value.");
                    scanner.next();
                }
            }
        }

        private double getValidDouble(String prompt) {
            while (true) {
                try {
                    System.out.print(prompt);
                    return scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a numeric value.");
                    scanner.next(); 
                }
            }
        }
    }

    
    public static void main(String[] args) {
        
        BankAccount account = new BankAccount(1000.00); 

  
        ATM atm = new ATM(account);


        atm.showMenu();
    }
}

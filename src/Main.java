import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int attempts = 0;
        boolean loggedIn = false;

        //The log in process with return in the end to terminate if not correct PIN
        do {
            System.out.println("Enter a 4 digit PIN: ");
            int pin = scan.nextInt();
            attempts++;
            if (pin == 1234) loggedIn = true;
            else if (attempts < 3) System.out.println("Invalid PIN. Attempts left: " + (3-attempts));
        }while (!loggedIn && attempts < 3);

        if (!loggedIn) {
            System.out.println("Your account has been locked.");
            return;
        }

        System.out.println("Login successful.");


        //Main menu that is displayed always
        boolean exit = false;
        double balance = 2500.75;
        int transactionCount = 0;

        while (true){
            System.out.println();
            System.out.println("========= ATM =========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show Account Status");
            System.out.println("5. Exit");
            System.out.println("=======================");
            System.out.println("Choose an option: ");
            int option = scan.nextInt();

            switch (option){
                case 1 -> System.out.println("Current balance: " + balance);
                case 2 -> {
                    System.out.println("Enter deposit amount: ");
                    double deposit = scan.nextDouble();

                    if (deposit > 0) {
                        balance += deposit;
                        transactionCount++;
                        System.out.println("Deposit successful.");
                        System.out.println("Updated balance: " + balance);
                    }else System.out.println("Invalid deposit amount");
                }
                case 3 -> {
                    System.out.println("Enter withdrawal amount: ");
                    double withdraw = scan.nextDouble();

                    if (withdraw == 0) System.out.println("Transaction canceled.");
                    else if (withdraw > balance || withdraw < 0) System.out.println("Invalid withdrawal amount.");
                    else{
                        balance -= withdraw;
                        transactionCount++;
                        System.out.println("Withdraw successful.");
                        System.out.println("Updated balance: " + balance);

                        if (balance == 0) System.out.println("Warning: Your account is empty.");
                    }

                }
                case 4 -> {
                    if(balance >= 5000) System.out.println("Account Status: VIP Customer.");
                    else if (balance >= 1000) System.out.println("Account Status: Regular Customer.");
                    else System.out.println("Account Status: Low balance.");
                }
                case 5 -> {
                    System.out.println("Total successful transactions: " + transactionCount);
                    System.out.println("Thank you for using out ATM.");
                    exit = true;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
            if (exit) break;
        }


    }
}
import java.util.*;
import java.text.DecimalFormat;

class Calculator{
    double add(double a, double b) {
        return a + b;
    }
    double sub(double a, double b) {
        return a - b;
    }
    double mul(double a, double b){
        return a*b;
    }
    double div(double a, double b){
        return a/b;
    }
}

public class Calculator_window {

    // Display calculator options
    static void display_options(){
        System.out.println("------------------------------");
        System.out.println("|     Calculator Program      |");
        System.out.println("------------------------------");
        System.out.println("| 1. Addition                 |");
        System.out.println("| 2. Subtraction              |");
        System.out.println("| 3. Multiplication           |");
        System.out.println("| 4. Division                 |");
        System.out.println("| 5. Exit                     |");
        System.out.println("------------------------------");
    }

    // Get input for calculations
    public static double[] get_input(Scanner scanner){
        double[] inputs = new double[2];

        System.out.print("Enter First Number: ");
        inputs[0] = scanner.nextDouble();
        System.out.print("Enter Second Number: ");
        inputs[1] = scanner.nextDouble();

        return  inputs;
    }

    // Clear console to simulate window switching
    public static void clearConsole() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    // Display main menu for selecting the "window"
    public static void display_main_menu() {
        System.out.println("------------------------------");
        System.out.println("|     Main Menu              |");
        System.out.println("------------------------------");
        System.out.println("| 1. Calculator               |");
        System.out.println("| 2. Exit                     |");
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.00");
        Calculator cal1 = new Calculator();
        boolean running = true;

        while(running){
            clearConsole();
            display_main_menu();  // Show the main menu
            System.out.print("Enter Your Choice: ");
            
            int mainChoice = scanner.nextInt();
            
            if (mainChoice == 2) {
                running = false;  // Exit the program
                break;
            } else if (mainChoice == 1) {
                // Calculator menu
                while (true) {
                    clearConsole();  // Clear screen for calculator options
                    display_options();  // Show calculator options
                    System.out.print("Enter Your Choice: ");

                    try {
                        int choice = scanner.nextInt();
                        if (choice == 5) {
                            break;  // Go back to main menu
                        }
                        double[] values = get_input(scanner);
                        double result = 0;

                        switch (choice) {
                            case 1:
                                result = cal1.add(values[0], values[1]);
                                System.out.println("Result, " + values[0] + " + " + values[1] + " = " + df.format(result) + "\n");
                                break;
                            case 2:
                                result = cal1.sub(values[0], values[1]);
                                System.out.println("Result, " + values[0] + " - " + values[1] + " = " + df.format(result) + "\n");
                                break;
                            case 3:
                                result = cal1.mul(values[0], values[1]);
                                System.out.println("Result, " + values[0] + " x " + values[1] + " = " + df.format(result) + "\n");
                                break;
                            case 4:
                                if (values[1] != 0) {
                                    result = cal1.div(values[0], values[1]);
                                    System.out.println("Result, " + values[0] + " / " + values[1] + " = " + df.format(result) + "\n");
                                } else {
                                    System.out.println("Error: Division by zero is undefined.");
                                }
                                break;
                            default:
                                System.out.println("Enter Choice among (1-5)");
                        }
                        System.out.println("Press enter to continue...");
                        scanner.nextLine(); // Consume newline
                        scanner.nextLine(); // Wait for enter
                    } catch (InputMismatchException e) {
                        System.out.println("Enter a number not a string");
                        scanner.nextLine();  // Clear buffer
                    }
                }
            } else {
                System.out.println("Invalid choice, try again.");
            }
        }
        scanner.close();
    }
}


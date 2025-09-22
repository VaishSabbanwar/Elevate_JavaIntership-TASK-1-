import java.util.Scanner;

public class SimpleCalculator {

    // Main method where the program execution begins
    public static void main(String[] args) {
        // Create a Scanner object to read user input from the console
        Scanner scanner = new Scanner(System.in);
        // A boolean flag to control the main calculation loop
        boolean continueCalculating = true;

        System.out.println("Welcome to the Simple Java Calculator!");

        // Main loop for continuous calculations
        while (continueCalculating) {
            try {
                // Prompt the user to enter the first number
                System.out.print("\nEnter the first number: ");
                double num1 = scanner.nextDouble();

                // Prompt for the operation
                System.out.print("Enter an operator (+, -, *, /): ");
                String operator = scanner.next();

                // Prompt for the second number
                System.out.print("Enter the second number: ");
                double num2 = scanner.nextDouble();

                double result = 0;
                boolean validOperation = true;

                // Use a switch statement to perform the correct operation based on the operator input
                switch (operator) {
                    case "+":
                        result = add(num1, num2);
                        break;
                    case "-":
                        result = subtract(num1, num2);
                        break;
                    case "*":
                        result = multiply(num1, num2);
                        break;
                    case "/":
                        // Call the divide method and handle potential division by zero
                        if (num2 == 0) {
                            System.out.println("Error: Division by zero is not allowed.");
                            validOperation = false;
                        } else {
                            result = divide(num1, num2);
                        }
                        break;
                    default:
                        System.out.println("Error: Invalid operator. Please use +, -, *, or /.");
                        validOperation = false;
                        break;
                }

                // If the operation was valid, print the result
                if (validOperation) {
                    System.out.println("Result: " + result);
                }

            } catch (Exception e) {
                // Catch any exceptions (e.g., non-numeric input)
                System.out.println("Invalid input. Please enter numbers.");
                // Clear the scanner buffer to prevent an infinite loop
                scanner.next(); 
            }

            // Ask the user if they want to perform another calculation
            System.out.print("\nDo you want to perform another calculation? (yes/no): ");
            String userChoice = scanner.next();
            // If the user's choice is not "yes" (case-insensitive), exit the loop
            if (!userChoice.equalsIgnoreCase("yes")) {
                continueCalculating = false;
            }
        }

        // Close the scanner object to free up resources
        scanner.close();
        System.out.println("Thank you for using the Simple Java Calculator!");
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }
}

import java.util.InputMismatchException;
import java.util.Scanner;

// defining functions for math computations
public class calculator {
    public static double addition(double a, double b){
        double result = a + b;
        return result;
    }
    public static double subtract(double a, double b){
        double result = a - b;
        return result;
    }
    public static double multiply(double a, double b){
        double result = a * b;
        return result;
    }
    public static double division(double a, double b){
        double result;
        if (a == 0 || b == 0){
            System.out.println("You cannot divide by 0");
        }
        result = a / b;
        return result;
        
    }
    // defining main method
    public static void main (String[] args){
        
        // initializing variable for while loop and creating scanner object
        int x = 0;
        Scanner input = new Scanner(System.in);

        // creating while loop to let user choose to restart program. Recieving user input to choose which method to call.
        while (x == 0){
            System.out.println("What type of computation?\n 1 for addition\n 2 for subtraction\n 3 for multiplication\n 4 for division ");
            double type;

            // checking if user input is a number and accounting for error if it isn't
            if (input.hasNextDouble()){
                type = input.nextDouble();
            }
            else{
                System.out.println("Invalid Command ");
                input.nextLine();
                continue;
            }

            // checking if user inputs an invalid number and accounting for error if so
            if (type > 4 || type < 0){
                System.out.println("Invalid Command ");
                continue;
            }

            //getting first number from user, throwing an exception if a non-double is entered
            System.out.print("Enter your first number: ");
            double first;
            
            try{
                first = input.nextDouble();
            }
            catch(InputMismatchException ex){
                System.out.println("Invalid Command ");
                input.nextLine();
                continue;
            }    
            
            // getting second number, throwing exception if non-double is entered
            System.out.print("Enter your second number: ");
            double second;
            
            try{
                second = input.nextDouble();
            }
            catch(InputMismatchException ex){
                System.out.println("Invalid Command");
                continue;
            }
            
            //initializing variable result2
            double result2 = 0;
            
            // based on the users input selecting a method to envoke and then calling that method and printing results
            if (type == 1){
                result2 = addition(first, second);
                System.out.println(first + " + " + second + " = " + result2);
            }
            else if (type == 2){
                result2 = subtract(first, second);
                System.out.println(first + " - " + second + " = " + result2);
            }
            else if (type == 3){
                result2 = multiply(first, second);
                System.out.println(first + " * " + second + " = " + result2);
            }
            else if (type == 4){
                result2 = division(first, second);
                System.out.println(first + " / " + second + " = " + result2);
            }
            //using .nextLine() method to clear the new line from the input buffer. Polling user if they want to run again.
            input.nextLine();
            System.out.print("Would you like to run again? y/n ");
            String again = input.nextLine();

            // checking users choice accounting for errors and either exiting or continuing the while loop based on input
            if (again.equalsIgnoreCase("n")){
                x = 1;
            }
            else if (again.equalsIgnoreCase("y")){
                x = 0;
            }
            else{
                System.out.print("Invalid Choice. Exiting Program.");
                x = 1;
            }
        }
        input.close();
    }
}
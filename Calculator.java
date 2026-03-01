import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    
    private static double memory = 0;
    private static List<String> history = new ArrayList<>();
    private static final int HISTORY_LIMIT = 10;
    private static boolean isDegreeMode = true;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        printBanner();
        
        while (true) {
            System.out.println("\n+-------------------------------------+");
            System.out.println("|  MAIN MENU                          |");
            System.out.println("+-------------------------------------+");
            System.out.println("|  [1] Basic Operations (+ - * / %)   |");
            System.out.println("|  [2] Scientific Operations          |");
            System.out.println("|  [3] Power & Roots                  |");
            System.out.println("|  [4] Trigonometry (sin, cos, tan)   |");
            System.out.println("|  [5] Memory Functions               |");
            System.out.println("|  [6] View History                   |");
            System.out.println("|  [7] Clear History                  |");
            System.out.println("|  [0] Exit                           |");
            System.out.println("+-------------------------------------+");
            System.out.print("Select option: ");
            
            String choice = scanner.next();
            
            switch (choice) {
                case "1":
                    basicOperations(scanner);
                    break;
                case "2":
                    scientificOperations(scanner);
                    break;
                case "3":
                    powerAndRoots(scanner);
                    break;
                case "4":
                    trigonometry(scanner);
                    break;
                case "5":
                    memoryFunctions(scanner);
                    break;
                case "6":
                    viewHistory();
                    break;
                case "7":
                    clearHistory();
                    break;
                case "0":
                case "exit":
                    System.out.println("\nThank you for using Advanced Calculator!");
                    System.out.println("Final Memory Value: " + memory);
                    scanner.close();
                    return;
                default:
                    System.out.println("[X] Invalid option! Please try again.");
            }
        }
    }
    
    private static void printBanner() {
        System.out.println("+---------------------------------------+");
        System.out.println("|       ADVANCED CALCULATOR             |");
        System.out.println("+---------------------------------------+");
    }
    
    private static void basicOperations(Scanner scanner) {
        System.out.println("\n--- Basic Operations ---");
        double num1 = getDoubleInput(scanner, "Enter first number: ");
        
        System.out.print("Enter operator (+, -, *, /, %): ");
        String operator = scanner.next();
        
        double num2 = getDoubleInput(scanner, "Enter second number: ");
        double result = 0;
        String operation = "";
        
        switch (operator) {
            case "+":
                result = num1 + num2;
                operation = num1 + " + " + num2 + " = " + result;
                break;
            case "-":
                result = num1 - num2;
                operation = num1 + " - " + num2 + " = " + result;
                break;
            case "*":
                result = num1 * num2;
                operation = num1 + " * " + num2 + " = " + result;
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("[X] Error: Cannot divide by zero!");
                    return;
                }
                result = num1 / num2;
                operation = num1 + " / " + num2 + " = " + result;
                break;
            case "%":
                if (num2 == 0) {
                    System.out.println("[X] Error: Cannot modulo by zero!");
                    return;
                }
                result = num1 % num2;
                operation = num1 + " % " + num2 + " = " + result;
                break;
            default:
                System.out.println("[X] Invalid operator!");
                return;
        }
        
        displayResult(result, operation);
    }
    
    private static void scientificOperations(Scanner scanner) {
        System.out.println("\n--- Scientific Operations ---");
        System.out.println("[1] Absolute Value  [2] Logarithm (base 10)");
        System.out.println("[3] Natural Log     [4] Exponential (e^x)");
        System.out.println("[5] Factorial       [6] Round");
        System.out.print("Select: ");
        
        String choice = scanner.next();
        double result = 0;
        String operation = "";
        
        switch (choice) {
            case "1":
                double absVal = getDoubleInput(scanner, "Enter number: ");
                result = Math.abs(absVal);
                operation = "|" + absVal + "| = " + result;
                break;
            case "2":
                double logVal = getDoubleInput(scanner, "Enter number: ");
                if (logVal <= 0) {
                    System.out.println("[X] Error: Logarithm requires positive number!");
                    return;
                }
                result = Math.log10(logVal);
                operation = "log10(" + logVal + ") = " + result;
                break;
            case "3":
                double lnVal = getDoubleInput(scanner, "Enter number: ");
                if (lnVal <= 0) {
                    System.out.println("[X] Error: Natural log requires positive number!");
                    return;
                }
                result = Math.log(lnVal);
                operation = "ln(" + lnVal + ") = " + result;
                break;
            case "4":
                double expVal = getDoubleInput(scanner, "Enter exponent: ");
                result = Math.exp(expVal);
                operation = "e^" + expVal + " = " + result;
                break;
            case "5":
                int factVal = (int) getDoubleInput(scanner, "Enter integer (0-20): ");
                if (factVal < 0 || factVal > 20) {
                    System.out.println("[X] Error: Factorial requires 0-20!");
                    return;
                }
                result = factorial(factVal);
                operation = factVal + "! = " + result;
                break;
            case "6":
                double roundVal = getDoubleInput(scanner, "Enter number: ");
                result = Math.round(roundVal);
                operation = "round(" + roundVal + ") = " + result;
                break;
            default:
                System.out.println("[X] Invalid selection!");
                return;
        }
        
        displayResult(result, operation);
    }
    
    private static void powerAndRoots(Scanner scanner) {
        System.out.println("\n--- Power & Roots ---");
        System.out.println("[1] Power (x^y)     [2] Square Root");
        System.out.println("[3] Cube Root       [4] Nth Root");
        System.out.print("Select: ");
        
        String choice = scanner.next();
        double result = 0;
        String operation = "";
        
        switch (choice) {
            case "1":
                double base = getDoubleInput(scanner, "Enter base: ");
                double exp = getDoubleInput(scanner, "Enter exponent: ");
                result = Math.pow(base, exp);
                operation = base + "^" + exp + " = " + result;
                break;
            case "2":
                double sqrtVal = getDoubleInput(scanner, "Enter number: ");
                if (sqrtVal < 0) {
                    System.out.println("[X] Error: Cannot calculate square root of negative number!");
                    return;
                }
                result = Math.sqrt(sqrtVal);
                operation = "sqrt(" + sqrtVal + ") = " + result;
                break;
            case "3":
                double cbrtVal = getDoubleInput(scanner, "Enter number: ");
                result = Math.cbrt(cbrtVal);
                operation = "cbrt(" + cbrtVal + ") = " + result;
                break;
            case "4":
                double nthVal = getDoubleInput(scanner, "Enter number: ");
                double nth = getDoubleInput(scanner, "Enter root (n): ");
                if (nth == 0) {
                    System.out.println("[X] Error: Root cannot be zero!");
                    return;
                }
                result = Math.pow(nthVal, 1.0 / nth);
                operation = nthVal + "^(1/" + nth + ") = " + result;
                break;
            default:
                System.out.println("[X] Invalid selection!");
                return;
        }
        
        displayResult(result, operation);
    }
    
    private static void trigonometry(Scanner scanner) {
        System.out.println("\n--- Trigonometry ---");
        System.out.println("Mode: " + (isDegreeMode ? "DEGREES" : "RADIANS"));
        System.out.println("[1] Sin    [2] Cos    [3] Tan");
        System.out.println("[4] ASin   [5] ACos   [6] ATan");
        System.out.println("[7] Toggle Degrees/Radians");
        System.out.print("Select: ");
        
        String choice = scanner.next();
        
        if (choice.equals("7")) {
            isDegreeMode = !isDegreeMode;
            System.out.println("[OK] Mode switched to " + (isDegreeMode ? "DEGREES" : "RADIANS"));
            return;
        }
        
        double angle = getDoubleInput(scanner, "Enter value: ");
        double result = 0;
        String operation = "";
        double inputRad = isDegreeMode ? Math.toRadians(angle) : angle;
        
        switch (choice) {
            case "1":
                result = Math.sin(inputRad);
                operation = "sin(" + angle + (isDegreeMode ? " deg" : " rad") + ") = " + result;
                break;
            case "2":
                result = Math.cos(inputRad);
                operation = "cos(" + angle + (isDegreeMode ? " deg" : " rad") + ") = " + result;
                break;
            case "3":
                result = Math.tan(inputRad);
                operation = "tan(" + angle + (isDegreeMode ? " deg" : " rad") + ") = " + result;
                break;
            case "4":
                if (angle < -1 || angle > 1) {
                    System.out.println("[X] Error: ASin requires input between -1 and 1!");
                    return;
                }
                result = isDegreeMode ? Math.toDegrees(Math.asin(angle)) : Math.asin(angle);
                operation = "asin(" + angle + ") = " + result + (isDegreeMode ? " deg" : " rad");
                break;
            case "5":
                if (angle < -1 || angle > 1) {
                    System.out.println("[X] Error: ACos requires input between -1 and 1!");
                    return;
                }
                result = isDegreeMode ? Math.toDegrees(Math.acos(angle)) : Math.acos(angle);
                operation = "acos(" + angle + ") = " + result + (isDegreeMode ? " deg" : " rad");
                break;
            case "6":
                result = isDegreeMode ? Math.toDegrees(Math.atan(angle)) : Math.atan(angle);
                operation = "atan(" + angle + ") = " + result + (isDegreeMode ? " deg" : " rad");
                break;
            default:
                System.out.println("[X] Invalid selection!");
                return;
        }
        
        displayResult(result, operation);
    }
    
    private static void memoryFunctions(Scanner scanner) {
        System.out.println("\n--- Memory Functions ---");
        System.out.println("Current Memory: " + memory);
        System.out.println("[1] Memory Clear (MC)     [2] Memory Recall (MR)");
        System.out.println("[3] Memory Add (M+)       [4] Memory Subtract (M-)");
        System.out.println("[5] Memory Store (MS)     [6] Set Custom Value");
        System.out.print("Select: ");
        
        String choice = scanner.next();
        
        switch (choice) {
            case "1":
                memory = 0;
                System.out.println("[OK] Memory Cleared (MC)");
                break;
            case "2":
                System.out.println("[OK] Memory Recall (MR): " + memory);
                break;
            case "3":
                double addVal = getDoubleInput(scanner, "Enter value to add: ");
                memory += addVal;
                System.out.println("[OK] Added " + addVal + " to memory. New value: " + memory);
                break;
            case "4":
                double subVal = getDoubleInput(scanner, "Enter value to subtract: ");
                memory -= subVal;
                System.out.println("[OK] Subtracted " + subVal + " from memory. New value: " + memory);
                break;
            case "5":
                double storeVal = getDoubleInput(scanner, "Enter value to store: ");
                memory = storeVal;
                System.out.println("[OK] Stored " + storeVal + " in memory (MS)");
                break;
            case "6":
                double customVal = getDoubleInput(scanner, "Enter new memory value: ");
                memory = customVal;
                System.out.println("[OK] Memory set to: " + memory);
                break;
            default:
                System.out.println("[X] Invalid selection!");
        }
    }
    
    private static void viewHistory() {
        System.out.println("\n--- Calculation History ---");
        if (history.isEmpty()) {
            System.out.println("No calculations performed yet.");
            return;
        }
        System.out.println("Last " + history.size() + " calculations:");
        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println("  [" + (history.size() - i) + "] " + history.get(i));
        }
    }
    
    private static void clearHistory() {
        history.clear();
        System.out.println("[OK] History cleared!");
    }
    
    private static void displayResult(double result, String operation) {
        System.out.println("\n+--------------------------------------+");
        System.out.println("|  RESULT: " + String.format("%-26.6f", result) + "|");
        System.out.println("+--------------------------------------+");
        System.out.println("Operation: " + operation);
        
        history.add(operation);
        if (history.size() > HISTORY_LIMIT) {
            history.remove(0);
        }
        
        System.out.print("Store in memory? (y/n): ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.next().equalsIgnoreCase("y")) {
            memory = result;
            System.out.println("[OK] Stored " + result + " in memory");
        }
    }
    
    private static double getDoubleInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("[X] Invalid number! Please enter a valid number.");
            }
        }
    }
    
    private static long factorial(int n) {
        if (n <= 1) return 1;
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
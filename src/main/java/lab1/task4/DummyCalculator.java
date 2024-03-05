package lab1.task4;

import java.util.Scanner;

public class DummyCalculator {
    public void calculate() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
                System.out.println("Input (or type 'quit' to exit):");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Exiting the DummyCalculator.");
                break;
            }

            String[] tokens = input.split(" ");

            if (tokens.length != 3) {
                System.out.println("Invalid expression! Please enter expression in the format: <operand1> <operator> <operand2>");
                continue;
            }

            try {
                double operand1;
                double operand2;
                String operator = tokens[1];

                if (tokens[0].equalsIgnoreCase("true") || tokens[0].equalsIgnoreCase("false")) {
                    boolean boolOperand1 = Boolean.parseBoolean(tokens[0]);
                    boolean boolOperand2 = Boolean.parseBoolean(tokens[2]);

                    if (!operator.equals("&") && !operator.equals("|")) {
                        System.out.println("Invalid operator! Only '&' and '|' are allowed for boolean operands.");
                        continue;
                    }

                    if (operator.equals("&")) {
                        System.out.println(boolOperand1 && boolOperand2);
                    } else {
                        System.out.println(boolOperand1 || boolOperand2);
                    }
                } else {
                    operand1 = Double.parseDouble(tokens[0]);
                    operand2 = Double.parseDouble(tokens[2]);

                    double result = 0.0;

                    switch (operator) {
                        case "+":
                            result = operand1 + operand2;
                            break;
                        case "-":
                            result = operand1 - operand2;
                            break;
                        case "*":
                            result = operand1 * operand2;
                            break;
                        case "/":
                            if (operand2 == 0) {
                                System.out.println("Cannot divide by zero!");
                                continue;
                            }
                            result = operand1 / operand2;
                            break;
                        default:
                            System.out.println("Invalid operator!");
                            continue;
                    }

                    if (result % 1 == 0) {
                        System.out.println((int) result);
                    } else {
                        System.out.println(result);
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please provide numeric operands.");
            }
        }
        scanner.close();
    }
}
/*
 * The program obtains expression from the user,
 * It shows the expression's validation.
 *@return true if the expression is validated, false otherwise
 *
 */


import java.util.*;

/**
 * @author David Yao
 */

public class ExpressionValidation {

    private static Scanner sc = new Scanner(System.in);
    private static Stack<Character> stack = new Stack<>();

    private static String checkingBalance(String str) {


        for (int i = 0; i < str.length(); i++) {

            char ch;

            ch = str.charAt(i);
            if (ch == '[' || ch == '(' || ch == '{' || ch == '<') {
                stack.push(ch);
            } else if ((ch == ']' || ch == '}' || ch == ')' || ch == '>')
                    && (!stack.isEmpty())) {
                if ((stack.peek() == '(' && ch == ')')
                        || (stack.peek() == '{' && ch == '}')
                        || (stack.peek() == '[' && ch == ']')
                        || (stack.peek() == '<' && ch == '>')) {
                    stack.pop();
                } else {
                    return "Not validated";
                }
            } else {
                if ((ch == ']' || ch == '}' || ch == ')' || ch == '>')) {
                    return "Not validated";
                }
            }
        }

        if (stack.isEmpty()) {
            return "The expression is validated.";
        } else {
            return "Not validated";
        }
    }

    public static void main(String[] args) {

        //obtaining user input
        System.out.println("Welcome to the expression validating program.\n");
        System.out.println("Enter your expression: ");
        String input = sc.nextLine();

        System.out.println("Enter the opening character to validate: ");
//        String input2 = sc.next(); // need to enter char -> ({<[
        char value = sc.nextLine().charAt(0);
        System.out.println(value);

        System.out.println("Enter the closing character to validate: ");
        String input3 = sc.next(); // need to enter char -> )}>]
        System.out.println(value);

        if (input.isEmpty()) {
            System.out.println("Empty String");
            return;
        }

        //displays the result
        System.out.println(ExpressionValidation.checkingBalance(input));
    }
}
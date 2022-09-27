package leet.old.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression. Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * Example Questions Candidate Might Ask:
 * Q: Is an empty array a valid input? A: No.
 */
public class _40_EvaluateReversePolishNotion {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (notOperator(token)) {
                stack.push(Integer.valueOf(token));
            } else {
                int t = 0;
                int a = stack.pop();
                int b = stack.pop();
                switch (token) {

                    case "+":
                        t = b + a;
                        break;
                    case "-":
                        t = b - a;
                        break;
                    case "*":
                        t = b * a;
                        break;
                    case "/":
                        t = b / a;
                        break;
                }
                stack.push(t);
            }
        }
        return stack.pop();
    }

    private static boolean notOperator(String token) {
        return !token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/");
    }


    public static int evalRPN2(String[] tokens) {
        Map<String, BiFunction<Integer, Integer, Integer>> functionMap = new HashMap<>();
        functionMap.put("+", Integer::sum);
        functionMap.put("-", (x, y) -> x-y);
        functionMap.put("*", (x, y) -> x*y);
        functionMap.put("/", (x, y) -> x/y);

        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (functionMap.containsKey(token)) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(functionMap.get(token).apply(x, y));
            }else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }


    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }
}

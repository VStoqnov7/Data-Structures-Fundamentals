package P01LinearDataStructuresExercises.implementations;

import P01LinearDataStructuresExercises.interfaces.Solvable;

import java.util.Stack;

public class BalancedParentheses implements Solvable {
    private String parentheses;

    public BalancedParentheses(String parentheses) {
        this.parentheses = parentheses;
    }


    public Boolean solve() {
        Stack<Character> stack = new Stack<>();

        for (char bracket : parentheses.toCharArray()) {
            if (isOpeningBracket(bracket)) {
                stack.push(bracket);
            } else {
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), bracket)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isOpeningBracket(char bracket) {
        return bracket == '(' || bracket == '{' || bracket == '[';
    }

    private boolean isMatchingPair(char openingBracket, char closingBracket) {
        return (openingBracket == '(' && closingBracket == ')') ||
                (openingBracket == '{' && closingBracket == '}') ||
                (openingBracket == '[' && closingBracket == ']');
    }
}

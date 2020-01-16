package leet.stack;

import com.google.common.collect.Sets;
import leet.ICodePoints;

import java.util.*;

/**
 * Question:
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * Example Questions Candidate Might Ask:
 * Q: Is the empty string valid? A: Yes.
 */
public class _41_ValidParentheses {

    public boolean isValid2(String s) {

        Map<Character, Character> map = new HashMap<Character, Character>() {{
                put('(', ')');
                put('[', ']');
                put('{', '}');
            }};
        if (Objects.isNull(s) || s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (stack.isEmpty() || map.get(stack.pop())!=s.charAt(i)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid(String s) {
        if (Objects.isNull(s) || s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    stack.push(s.charAt(i));
                    break;
                case ')':
//                    @ICodePoints("pop之前需要先判断空")
                    if (stack.isEmpty() || stack.pop() != '(')
                        return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[')
                        return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{')
                        return false;
                    break;
                default:
                    return false;
            }
        }
//        @ICodePoints("如果最后栈非空，说明有多余括号")
        return stack.isEmpty();
    }

}

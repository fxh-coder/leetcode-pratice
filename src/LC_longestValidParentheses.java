import java.util.Stack;

public class LC_longestValidParentheses {
    public int longestValidParentheses(String s) {
        if(s.length() == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            if(c1 == '(') {
                stack.push(i);
            } else {
                 stack.pop();
                 if(stack.isEmpty()) {
                     stack.push(i);
                 } else {
                     max = Math.max(max, i - stack.peek());
                 }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LC_longestValidParentheses lc = new LC_longestValidParentheses();
        String s = "(()";
        System.out.println(lc.longestValidParentheses(s));
    }
}

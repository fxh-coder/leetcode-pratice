import java.util.Stack;

public class LC_validParentheses {
    /**
     * 力扣有效的括号
     * @param s 括号字符串
     * @return 是否有效
     */
    public boolean isValid(String s) {
        // 如果是奇数，肯定不成对
        if(s.length() % 2 == 1)
            return false;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println(c + " " + i);
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if(!stack.isEmpty()) {
                Character c1 = stack.pop();
                System.out.println(c1 + " " + i);
                if(c == ')' && c1 != '(')
                    return false;
                else if(c == ']' && c1 != '[')
                    return false;
                else if(c == '}' && c1 != '{')
                    return false;
            } else
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        LC_validParentheses lcValidParentheses = new LC_validParentheses();
        String s = "()";
        System.out.println(lcValidParentheses.isValid(s));
    }
}

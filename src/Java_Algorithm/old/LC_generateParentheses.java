import java.util.ArrayList;
import java.util.List;

public class LC_generateParentheses {
    /**
     * 力扣括号生成
     * @param n 括号对数
     * @return 所有可能并且有效的括号组合
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateRecur(new char[2 * n], 0, res);
        return res;
    }

    public void generateRecur(char[] cur, int pos, List<String> comb) {
        if (pos == cur.length) {
            if (isValid(cur)) {
                comb.add(new String(cur));
            }
        } else {
            cur[pos] = '(';
            generateRecur(cur, pos + 1, comb);
            cur[pos] = ')';
            generateRecur(cur, pos + 1, comb);
        }
    }

    public boolean isValid(char[] cur) {
        int cnt = 0;
        for (char c: cur) {
            if(c == '(')
                cnt++;
            else
                cnt--;
            if(cnt < 0)
                return false;
        }
        return cnt == 0;
    }
}

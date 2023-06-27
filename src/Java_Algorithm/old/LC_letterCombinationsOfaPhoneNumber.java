import java.util.ArrayList;
import java.util.List;

public class LC_letterCombinationsOfaPhoneNumber {
    /**
     * 力扣电话号码的字母组合
     */
    String[] letter_map = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        // 注意边界条件
        if(digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        dfs(digits, new StringBuilder(), 0);
        return res;
    }

    /**
     * 递归对每个数字对应的字母进行组合
     * @param str 给定的数字字符串
     * @param letter 用于存储字母组合
     * @param index 记录长度的下标
     */
    public void dfs(String str, StringBuilder letter, int index) {
        if(index == str.length()) {
            res.add(letter.toString());
            return;
        }

        char c = str.charAt(index);
        int pos = c - '0';
        String map_str = letter_map[pos];
        for (int i = 0; i < map_str.length(); i++) {
            letter.append(map_str.charAt(i));
            dfs(str, letter, index + 1);
            letter.deleteCharAt(letter.length() - 1);
        }
    }
}

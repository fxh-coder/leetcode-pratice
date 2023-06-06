import java.util.HashMap;
import java.util.Map;

public class LC_minimumWindowSubstring {
    /**
     * 力扣最小覆盖子串
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if(s.length() < t.length())
            return "";
        if(s.length() == t.length())
            return s;

        Map<Character, Integer> hs = new HashMap<>();
        Map<Character, Integer> ht = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            ht.put(t.charAt(i), ht.getOrDefault(t.charAt(i), 0) + 1);
        }

        String res = "";
        int len = Integer.MAX_VALUE, cnt = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            hs.put(s.charAt(i), hs.getOrDefault(s.charAt(i), 0) + 1);
            // 如果当前的字母属于 t，并且数量还不够 t中 的数量，那就开始计数
            if(ht.containsKey(s.charAt(i)) && hs.get(s.charAt(i)) <= ht.get(s.charAt(i)))
                cnt++;
            // j < i是必须的，否则就没有必要进行比较了。如果ht中不包含当前的字符或者说hs中当前字符数量超过ht
            // 那就说明当前的串已经不匹配了，所以要从下一个开始（刚开始是从头开始的）
            while(j < i && (!ht.containsKey(s.charAt(j)) || hs.get(s.charAt(j)) > ht.get(s.charAt(j)))) {
                // 因为当前已经不匹配了，所以要从下一个开始，所以对于j的字符要减1，因为j就是每次开始的位置
                int count = hs.get(s.charAt(j)) - 1;
                hs.put(s.charAt(j), count);
                j++;
            }
            // 判断长度是否够并且长度是否更短
            if(cnt == t.length() && i - j + 1 < len) {
                len = i - j + 1;
                res = s.substring(j, i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC_minimumWindowSubstring lc = new LC_minimumWindowSubstring();
        String s = "a", t = "a";
        System.out.println(lc.minWindow(s, t));
    }
}

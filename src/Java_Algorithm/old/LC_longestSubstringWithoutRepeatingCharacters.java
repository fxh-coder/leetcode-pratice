public class LC_longestSubstringWithoutRepeatingCharacters {
    /**
     * 无重复字符的最长子串
     * @param s 给定的字符串
     * @return 返回无重复字符的最长子串的长度
     */
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1)
            return s.length();

        String res = "";
        int i = 0, n = s.length(), max = Integer.MIN_VALUE, start = 0;
        while(i < n) {
            // 判断结果字符串是否含有字符
            if(res.length() > 0) {
                // 判断结果字符串中是否含有当前的字符
                if(res.indexOf(s.charAt(i)) != -1) {
                    max = Math.max(max, res.length());
                    // 如果出现重复，那就从start的下一个位置开始，因为是子串，不是子序列，子串是要连续的
                    i = start + 1;
                    start = i;
                    res = "";
                    if(i < n) {
                        res += s.charAt(i);
                        i++;
                    }
                } else {
                    res += s.charAt(i);
                    i++;
                }
            } else {
                res += s.charAt(i);
                i++;
            }
        }
        return Math.max(max, res.length());
    }

    public static void main(String[] args) {
        LC_longestSubstringWithoutRepeatingCharacters lc = new LC_longestSubstringWithoutRepeatingCharacters();
        String s = "dvdf";
        System.out.println(lc.lengthOfLongestSubstring(s));
    }
}

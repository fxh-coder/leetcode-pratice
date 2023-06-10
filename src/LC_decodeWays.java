package stage6_10;

public class LC_decodeWays {
    /**
     * 力扣解码方法
     * 原理：动态规划  使用f(i)表示前i个字符解码方式的种类数，
     * 对于f(i)来说，如果使用当前字符s[i]匹配，那么f(i)=f(i-1)
     * 如果使用两个字符去进行匹配（保证两个的和在26之内），那么f(i)=f(i-2)
     * 根据是否合适，来累加
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }
}

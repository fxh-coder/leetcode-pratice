package Java_Algorithm;

public class LC_reverseString {
    /**
     * 力扣反转字符串：双指针法：一个从前往后，一个从后往前
     * @param s
     */
    public void reverseString(char[] s) {
        int n = s.length;
        for (int left = 0, right = n - 1; left < right; ++left, --right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }
}

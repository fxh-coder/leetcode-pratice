public class LC_longestPalindromicSubstring {
    public boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if(s.charAt(i) != s.charAt(len - i - 1))
                return false;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        String res = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j <= len; j++) {
                String substr = s.substring(i, j);
                if(isPalindromic(substr) && substr.length() > max) {
                    res = substr;
                    max = Math.max(max, res.length());
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC_longestPalindromicSubstring lc = new LC_longestPalindromicSubstring();
        String s = "ababa";
        System.out.println(lc.longestPalindrome(s));
    }
}

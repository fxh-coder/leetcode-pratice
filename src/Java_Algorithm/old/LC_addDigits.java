public class LC_addDigits {
    /**
     * 力扣各位相加
     */
    class Solution {
        public int addDigits(int num) {
            while (num >= 10) {
                int sum = 0;
                while (num > 0) {
                    sum += num % 10;
                    num /= 10;
                }
                num = sum;
            }
            return num;
        }
    }
}

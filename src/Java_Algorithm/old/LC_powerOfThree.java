package Java_Algorithm;

public class LC_powerOfThree {
    /**
     * 力扣3的幂
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}

package Java_Algorithm;

public class LC_powerOfFour {
    /**
     * 力扣4的幂
     * @param n
     * @return
     */
    public boolean isPowerOfFour(int n) {
        while (n != 0 && n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }
}

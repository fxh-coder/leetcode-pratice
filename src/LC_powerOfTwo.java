public class LC_powerOfTwo {
    /**
     * 力扣2的幂
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) n /= 2;
        return n == 1;
    }
}

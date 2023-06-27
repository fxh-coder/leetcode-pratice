package Java_Algorithm;

public class LC_countingBits {
    /**
     * 力扣比特位计数：奇数比前面的偶数多一个 1，偶数比上一个偶数多一个 1
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        result[0] = 0;
        for(int i = 1; i <= n; i++)
        {
            if(i % 2 == 1)
            {
                result[i] = result[i-1] + 1;
            }
            else
            {
                result[i] = result[i/2];
            }
        }

        return result;
    }
}

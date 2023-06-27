public class LC_multiplyStrings {
    /**
     * 力扣字符串相乘
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        // 有一个为0，就直接返回0
        if(num1.equals("0") || num2.equals("0"))
            return "0";

        int m = num1.length(), n = num2.length();
        // 初始化一个数组，用来记录相应位数字相乘的积
        int[] resArr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                resArr[i + j + 1] += x * y;
            }
        }
        // 判断当前位置是否大于10，是的话就往前进1，本身对10取余
        for (int i = m + n - 1; i > 0; i--) {
            resArr[i - 1] += resArr[i] / 10;
            resArr[i] = resArr[i] % 10;
        }

        // 因为m，n长度的两数相乘，结果位数的范围是[m + n - 1, m + n]，
        // 所以初始化的数组长度是m + n，需要判断最高位是否大于0，不是的话，
        // 就从第一个开始
        int startIdx = resArr[0] == 0 ? 1 : 0;
        StringBuffer res = new StringBuffer();
        while(startIdx < m + n)
            res.append(resArr[startIdx++]);

        return res.toString();
    }

}

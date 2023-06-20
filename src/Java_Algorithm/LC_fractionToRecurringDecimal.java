package Java_Algorithm;

import java.util.HashMap;
import java.util.Map;

public class LC_fractionToRecurringDecimal {
    /**
     * 力扣分数到小数
     * 原理：先计算相除之后的整数部分，然后使用map存储余数相除的部分（每次让余数乘以10在相除）
     *      如果过程中发现有一个数在map中出现过，那这里就是循环体开始的地方
     * @param numerator
     * @param denominator
     * @return
     */
    public String fractionToDecimal(int numerator, int denominator) {
        // 为了防止相除变大，超过int范围（整数除以小数，越除越大）
        long numeratorLong = (long) numerator;
        long denominatorLong = (long) denominator;

        // 如果相除为0，不用考虑小数部分，直接返回
        if(numeratorLong % denominatorLong == 0) {
            return String.valueOf(denominatorLong / denominatorLong);
        }

        StringBuffer res = new StringBuffer();
        // ^异或运算符，相同为0，不同为1，所以如果两者符号相同，那么结果就是0，if不会执行
        // 如果两者符号不同，那么if成立，结果也必然是负数，所以加个 ‘-’
        if(numeratorLong < 0 ^ denominatorLong < 0) {
            res.append('-');
        }

        // 整数部分
        long integerPart = Math.abs(numeratorLong) / Math.abs(denominatorLong);
        res.append(integerPart);
        // 剩余就是小数部分，所以添加 ‘.’
        res.append('.');

        // 小数部分
        StringBuffer fractionPart = new StringBuffer();
        Map<Long, Integer> remainderIdx = new HashMap<>();
        long reminder = numeratorLong % denominatorLong;
        int idx = 0;
        while(reminder != 0 && !remainderIdx.containsKey(reminder)) {
            remainderIdx.put(reminder, idx);
            reminder *= 10;
            // 存储小数
            fractionPart.append(reminder / denominatorLong);
            reminder %= denominatorLong;
            idx++;
        }
        // 出了循环，还不为0.那就是出现了循环体
        if(reminder != 0) {
            // 找到出现循环体的开始位置
            int insertIdx = remainderIdx.get(reminder);
            fractionPart.insert(insertIdx, '(');
            fractionPart.append(')');
        }
        res.append(fractionPart.toString());

        return res.toString();
    }
}

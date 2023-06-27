package Java_Algorithm;

public class LC_firstBadVersion {
    /**
     * 力扣第一个错误的版本
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (isBadVersion(mid)) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }

    /**
     * 这个方法是内部实现的，这里只是为了防止报错
     * @param mid
     * @return
     */
    private boolean isBadVersion(int mid) {
        return true;
    }
}

public class LC_sortColors {
    /**
     * 力扣颜色分类（使用辅助数组进行标记，就算数量不只是0-2，这个方法也适用）
     * @param nums
     */
    public void sortColors(int[] nums) {
        int r = 3;
        // 用来记录各种颜色的数量
        int[] cnt = new int[r];
        for (int num: nums)
            cnt[num]++;

        // 用来记录各种颜色的下标范围
        int[] index = new int[r + 1];
        for (int i = 0; i < r; i++) {
            index[i + 1] = index[i] + cnt[i];
        }

        for (int i = 0; i + 1< index.length; i++) {
            for (int j = index[i]; j < index[i + 1]; j++) {
                nums[j] = i;
            }
        }
    }

    /**
     * 力扣颜色分类（双指针，如果数量范围不只是0-2，就不适用了）
     * @param nums
     */
    public void sortColors2(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1, idx = 0;
        while(idx <= r) {
            // 如果是0，那就加入到左边，如果是1，就继续下一个，如果是2，就从最右边添加
            if(nums[idx] == 0)
                swap(nums, l++, idx++);
            else if(nums[idx] == 1)
                idx++;
            else
                swap(nums, idx, r--);
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

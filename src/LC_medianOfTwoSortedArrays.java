public class LC_medianOfTwoSortedArrays {
    /**
     * 力扣寻找两个正序数组的中位数
     * @param nums1 第一个有序数组
     * @param nums2 第二个有序数组
     * @return 中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int middle;
        double res;
        int flag;
        // 用来判断两个数组的长度和是不是偶数，有利于最后的计算
        if((len1 + len2) % 2 == 0) {
            middle = (len1 + len2) / 2;
            flag = 0;
        } else {
            middle = (len1 + len2) / 2 + 1;
            flag = 1;
        }
        int i = 0, j = 0, cnt = 0;
        int arr[] = new int[len1 + len2];
        // 两个数组都不能为空才能继续，因为数组是有序的，有一个没有直接将剩下的补上就可以了
        while(i < len1 && j < len2) {
            if(nums1[i] < nums2[j]) {
                arr[cnt++] = nums1[i++];
            } else {
                arr[cnt++] = nums2[j++];
            }
        }
        // 如果nums2有剩余
        if(i == len1 && j < len2) {
            for (int k = j; k < len2; k++) {
                arr[cnt++] = nums2[k];
            }
        }
        // 如果nums1有剩余
        if(j == len2 && i < len1) {
            for (int k = i; k < len2; k++) {
                arr[cnt++] = nums1[k];
            }
        }

        if(flag == 0) {
            // 长度为偶数，那就需要两个
            res = arr[middle - 1] + arr[middle];
            res = res / 2;
        } else {
            res = arr[middle - 1];
        }

        return res;
    }

    public static void main(String[] args) {
        LC_medianOfTwoSortedArrays lcMedianOfTwoSortedArrays = new LC_medianOfTwoSortedArrays();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(lcMedianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));
    }
}

public class LC_uniqueBinarySearchTrees {
    /**
     * 力扣不同的二叉搜索树
     * 原理：假设G(n) 表示n个节点的树可以构成的二叉搜索树的数量，F(i)表示以i为根的二叉搜索树数量
     *      则G(n) = f(1) + f(2) + ... + f(n).
     *      当i为根节点时，左子树节点个数为 i- 1 个，则右子树节点个数为 n - i 个
     *      f(i) = G(i - 1) * G(n - i)，就是说假如左边3种可能，右边2种可能，那么一共就是2 * 3
     *      就是不同的组合
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}

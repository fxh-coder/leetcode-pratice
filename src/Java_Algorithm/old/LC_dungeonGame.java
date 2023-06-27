package Java_Algorithm;

import java.util.Arrays;

public class LC_dungeonGame {
    /**
     * 力扣地下城游戏
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[n][m - 1] = dp[n - 1][m] = 1;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);

                dp[i][j] = Math.max(minn - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        LC_dungeonGame lc = new LC_dungeonGame();
        int[][] dungeon = {{0, -2, 3}, {-1, 0, 0}, {-3, -3, -2}};

        lc.calculateMinimumHP(dungeon);
    }
}

public class LC_climbingStairs {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;

        int f1 = 1;
        int f2 = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = f1 + f2;
            f1 = f2;
            f2 = res;
        }
        return res;
    }
}

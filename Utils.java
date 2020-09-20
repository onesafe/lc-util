/**
 * Author: 第九代封妖师
 * Date: 2020/09/16
 */
public class Utils {
    public static int inf = Integer.MAX_VALUE;
    public static int inn = Integer.MIN_VALUE;
    public static int mod = (int)(1e9 + 7);

    // 方向数组
    public static int[][] dirs = new int[][]{
            {1, 0},
            {0, 1}
    };

    // 求阶乘n!
    public int fact(int n) {
        int res = 1;
        for(int i=1; i<=n; i++) {
            res *= i;
        }
        return res;
    }

    // 从n里面选k个不重复的组合数
    public int compose(int n, int k) {
        return fact(n) / (fact(n-k)*fact(k));
    }
}

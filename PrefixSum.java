/**
 * Author: 第九代封妖师
 * Date: 2020/09/15
 */
public class PrefixSum {

    // 前缀和数组
    private final int[] prefix;

    /**
     * 输入一个数组，构造前缀和
     */
    public PrefixSum(int[] nums) {
        prefix = new int[nums.length + 1];
        for (int i=1; i<prefix.length; i++) {
            prefix[i] = prefix[i-1] + nums[i-1];
        }
    }

    /**
     * 查询闭区间[i, j]的累加和
     */
    public int query(int i, int j) {
        return prefix[j+1] - prefix[i];
    }
}

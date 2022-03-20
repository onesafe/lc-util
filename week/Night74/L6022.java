package week.Night74;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 第 74 场双周赛 第三题 将数组和减半的最少操作次数
 *
 * 给你一个正整数数组 nums 。每一次操作中，你可以从 nums 中选择 任意 一个数并将它减小到 恰好 一半。（注意，在后续操作中你可以对减半过的数继续执行操作）
 * 请你返回将 nums 数组和 至少 减少一半的 最少 操作数
 */
public class L6022 {
    public int halveArray(int[] nums) {
        PriorityQueue<BigDecimal> pq = new PriorityQueue<>(Comparator.reverseOrder());
        BigDecimal target = BigDecimal.ZERO, curr = BigDecimal.ZERO;

        for (int num : nums) {
            target = target.add(BigDecimal.valueOf(num).divide(BigDecimal.valueOf(2)));
            pq.add(BigDecimal.valueOf(num));
        }

        int count = 0;
        while(curr.compareTo(target) < 0) {
            BigDecimal tmp = pq.poll().divide(BigDecimal.valueOf(2));
            pq.add(tmp);
            curr = curr.add(tmp);
            count++;
        }
        return count;
    }
}

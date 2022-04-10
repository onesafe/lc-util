package week.normal.normal288;

import java.util.PriorityQueue;

public class L6039 {
    public static int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        if (nums.length == 1) {
            return k + nums[0];
        }
        for (int num : nums) {
            q.offer(num);
        }

        while(!q.isEmpty() && k > 0) {
            int pre = q.poll();
            int cur = q.peek();
            int gap = Math.min(Math.max(1, cur - pre), k);
            k -= gap;
            q.offer(pre + gap);
        }

        long res = q.poll();
        while(!q.isEmpty()) {
            System.out.println(q.peek());
            res = ( res * (q.poll()) ) % 1000000007;
            System.out.println(res);
        }
        System.out.println(res);
        return (int) res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{24,5,64,53,26,38};
        maximumProduct(nums, 54);
    }
}

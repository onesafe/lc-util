package week.night.night76;

public class L6060 {
    public int findClosestNumber(int[] nums) {
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (Math.abs(num) < min) {
                min = Math.abs(num);
                ans = num;
            } else if (Math.abs(num) == min){
                ans = Math.max(num, ans);
            }
        }
        return ans;
    }
}

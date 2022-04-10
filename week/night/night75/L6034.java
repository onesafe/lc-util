package week.night.night75;

public class L6034 {
    public static int triangularSum(int[] nums) {
        int n = nums.length;
        for(int i=n; i>0; i--) {
            for(int j=0; j<i-1; j++) {
                nums[j] = ( nums[j]+nums[j+1] ) % 10;
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5};
        System.out.println(triangularSum(nums));
    }
}

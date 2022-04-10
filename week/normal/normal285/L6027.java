package week.normal.normal285;

import java.util.ArrayList;
import java.util.List;

public class L6027 {
    public int countHillValley(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                continue;
            }
            list.add(nums[i]);
        }
        Integer[] arrs = list.toArray(new Integer[list.size()]);
        int count = 0;
        for(int i=0; i<arrs.length-2; i++) {
            if (arrs[i+1] > arrs[i] && arrs[i+1] > arrs[i+2]) {
                count++;
            }
            if (arrs[i+1] < arrs[i] && arrs[i+1] < arrs[i+2]) {
                count++;
            }
        }
        return count;
    }
}

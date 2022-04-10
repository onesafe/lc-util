package week.normal.normal286;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L5268 {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();

        for(int num : nums1) {
            set1.add(num);
        }
        for(int num : nums2) {
            set2.add(num);
        }
        List<Integer> tmp1 = new ArrayList<>();
        for(int num : nums1) {
            if (!set2.contains(num)) {
                if (!tmp1.contains(num)) {
                    tmp1.add(num);
                }
            }
        }
        res.add(tmp1);

        List<Integer> tmp2 = new ArrayList<>();
        for(int num : nums2) {
            if (!set1.contains(num)) {
                if (!tmp2.contains(num)) {
                    tmp2.add(num);
                }
            }
        }
        res.add(tmp2);

        return res;
    }
}

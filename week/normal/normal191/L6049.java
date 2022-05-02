package week.normal.normal191;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L6049 {
    public int countDistinct(int[] nums, int k, int p) {
        Set<List<Integer>> hs = new HashSet<>();    // 自动去重
        for(int i = 0; i < nums.length; i++) {
            int count = 0;  // 计数
            List<Integer> list = new ArrayList<>();
            for(int j = i; j < nums.length; j++) {
                if(nums[j] % p == 0) {  // 可被整除
                    count++;    // 计数器+1
                }
                if(count > k) { // 能整除的数大于k
                    break;  // 结束此次j循环，即以下标i开头的数组
                }
                list.add(nums[j]);  // 否则，当前下标的元素加入list
                List<Integer> list2 = new ArrayList<>(list);    //new一个新的加到set集合，否则会统计错误，因为传入的是引用地址
                hs.add(list2);
            }
        }
        return hs.size();   // 返回set集合长度
    }
}

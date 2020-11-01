import java.util.Arrays;

/**
 * Author: 第九代封妖师
 * Date: 2020/09/16
 */
public class BinarySearch {

    // 搜索一个数，如果存在，返回其索引，否则返回-1
    public static int findTarget(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 寻找左侧边界
     * [1, 2, 2, 2, 3] 找左侧的2
     */
    public static int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 检查出界情况
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }

    /**
     * 寻找右侧边界
     * [1, 2, 2, 2, 3] 找右侧的2
     */
    public static int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 这里改成收缩左侧边界即可
                left = mid + 1;
            }
        }
        // 检查 right 越界的情况
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }

    /**
     * 5556
     * 0到无穷，找满足条件的点
     *
     * [0, n] 中找[0, mid] 的mid点，满足check，找到最远的mid点
     */
    public int furthestBuilding(int[] h, int b, int la) {
        int n = h.length;
        int l = 0;
        int r = n;
        int[] buf = new int[n];
        while(l < r){
            int m = (l + r + 1) / 2;
            if(check(h, buf, m, b, la)){
                l = m;
            }else{
                r = m - 1;
            }
        }
        return l - 1;
    }

    public boolean check(int[] h, int[] buf, int mid, int b, int l){
        buf[0] = 0;
        for(int i = 1; i < mid; i++){
            buf[i] = Math.max(0, h[i] - h[i - 1]);
        }
        Arrays.sort(buf, 0, mid);
        long sum = 0;
        for(int i = 0; i < mid - l; i++){
            sum += buf[i];
        }
        return sum <= b;
    }
}

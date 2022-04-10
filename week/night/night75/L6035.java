package week.night.night75;

public class L6035 {
    public static long numberOfWays(String s) {
        char[] arr = s.toCharArray();
        // count 数组用于统计左右侧字符的数量。
        int[] count = new int[arr.length];
        long onecount = 0, zerocount = 0, ans = 0;

        // 从右往左遍历，统计每个位置右侧0或者1字符的数量。
        for (int i=arr.length-1; i>=0; i--) {
            // 该位置为0，则统计右侧1的数量
            if (arr[i] == '0') {
                count[i] += onecount;
            } else {
                count[i] += zerocount;
            }
            onecount += arr[i] == '1' ? 1 : 0;
            zerocount += arr[i] == '0' ? 1 : 0;
        }

        onecount = 0;
        zerocount = 0;
        // 从左往右遍历，统计每个位置左侧0或者1字符的数量。这里我们与右侧数量直接相乘得到该位置贡献量。
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == '0') {
                count[i] *= onecount;
            } else {
                count[i] *= zerocount;
            }
            onecount += arr[i] == '1' ? 1 : 0;
            zerocount += arr[i] == '0' ? 1 : 0;
            ans += count[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numberOfWays("0001100100"));
    }
}

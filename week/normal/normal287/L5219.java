package week.normal.normal287;


public class L5219 {
    public static int maximumCandies(int[] candies, long k) {
        long left = 0, right = 10000000;
        while (left < right) {
            long mid = (left + right + 1)/2, count = 0;
            for (int candy : candies) {
                count += candy/mid;
            }
            if (count < k) {
                right = mid-1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }

    public static void main(String[] args) {
        System.out.println(maximumCandies(new int[]{4,9,4,7,8,10,3,10,3,9}, 9));
    }
}

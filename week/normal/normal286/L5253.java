package week.normal.normal286;

public class L5253 {

    public long[] kthPalindrome(int[] queries, int intLength) {
        long[] result = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String s = (long) Math.pow(10, (intLength - 1) / 2) + queries[i] - 1 + "";
            result[i] = s.length() > (intLength + 1) / 2 ? -1
                    : Long.valueOf(s + new StringBuilder(s.substring(0, s.length() - intLength % 2)).reverse());
        }
        return result;
    }
}

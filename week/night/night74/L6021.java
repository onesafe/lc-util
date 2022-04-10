package week.night.night74;

/**
 * 贪心
 */
public class L6021 {
    /**
     若pattern="ac"，那么认为在text的开始添加'a'或者在text的结尾添加'c'这两种情况能得到最大值。
     遍历字符串，并记录初始子序列数量sum，以及'a'和'c'的数量。

     在开始处添加'a'，则子序列数量=初始子序列数量+'c'的数量。
     在结尾处添加'c'，则子序列数量=初始子序列数量+'a'的数量。
     */
    public long maximumSubsequenceCount(String text, String pattern) {
        char a = pattern.charAt(0), b = pattern.charAt(1);
        long ans = 0;
        int aCnt = 0, bCnt = 0;

        for(int i=text.length()-1; i>=0; i--) {
            if(text.charAt(i) == a) {
                aCnt++;
                ans += bCnt;
            } else if(text.charAt(i) == b) {
                bCnt++;
            }
        }

        if(a == b) {
            //所有字符都一样，加入一个a字符后，每个字符都能和后面的所有字符配对
            //这里得用long，否则计算乘积溢出
            long cnt = aCnt + bCnt + 1;
            return ((cnt - 1) + 1) * (cnt - 1) / 2;
        }

        ans += Math.max(aCnt, bCnt);
        return ans;
    }
}

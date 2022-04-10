package week.normal.normal287;

public class L6055 {
    public int convertTime(String current, String correct) {
        String[] c = current.split(":");
        String[] t = correct.split(":");

        Integer x = Integer.valueOf(c[0]);
        Integer y = Integer.valueOf(t[0]);

        int ans = 0;
        if (y > x) {
            ans = y - x;
        } else {
            ans = (y+24) - x;
        }

        Integer m = Integer.valueOf(c[1]);
        Integer n = Integer.valueOf(t[1]);
        if (n > m) {
            int gap = n - m;
            while(gap != 0) {
                if (gap > 15) {
                    ans++;
                    gap -= 15;
                } else if(gap > 5) {
                    ans++;
                    gap -= 5;
                } else {
                    ans++;
                    gap -= 1;
                }
            }
        } else {
            int gap = (n+60) - m;
            while(gap != 0) {
                if (gap > 15) {
                    ans++;
                    gap -= 15;
                } else if(gap > 5) {
                    ans++;
                    gap -= 5;
                } else {
                    ans++;
                    gap -= 1;
                }
            }
            if (y != x) ans--;
        }
        return ans;
    }
}

package week.normal.normal285;

public class L6028 {
    public int countCollisions(String directions) {
        char[] arrs = directions.toCharArray();
        int left = 0, right = arrs.length-1;
        while(left <= right && arrs[left] == 'L') left++;
        while(left <= right && arrs[right] == 'R') right--;

        int count = 0;
        for(int i = left; i <= right; i++) {
            if (arrs[i] == 'L' || arrs[i] == 'R') count++;
        }
        return count;
    }
}

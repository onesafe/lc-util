package week.normal.normal291;

import java.util.HashMap;
import java.util.Map;

public class L6048 {
    public int minimumCardPickup(int[] cards) {
        int left = 0, right = 1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(cards[0], 0);
        int res = Integer.MAX_VALUE;

        while (right < cards.length) {
            if (map.containsKey(cards[right])) {
                res = Math.min(res, right-map.get(cards[right])+1);
                map.put(cards[right], right);
                left++;
                right++;
            } else {
                map.put(cards[right], right);
                right++;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

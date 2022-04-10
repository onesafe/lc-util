package week.normal.normal287;

import java.util.*;

public class L5235 {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> winMap = new HashMap<>();
        Map<Integer, Integer> loseMap = new HashMap<>();

        for (int[] match : matches) {
            int win = match[0];
            int lose = match[1];
            if (winMap.containsKey(win)) {
                winMap.put(win, winMap.get(win) + 1);
            } else {
                winMap.put(win, 1);
            }
            if (loseMap.containsKey(lose)) {
                loseMap.put(lose, loseMap.get(lose) - 1);
            } else {
                loseMap.put(lose, -1);
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> winList = new ArrayList<>();
        List<Integer> loseOne = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : winMap.entrySet()) {
            if (!loseMap.containsKey(entry.getKey())) {
                winList.add(entry.getKey());
            }
        }
        for (Map.Entry<Integer, Integer> entry : loseMap.entrySet()) {
            if (entry.getValue() == -1) {
                loseOne.add(entry.getKey());
            }
        }
        Collections.sort(winList);
        Collections.sort(loseOne);
        res.add(winList);
        res.add(loseOne);
        return res;
    }
}

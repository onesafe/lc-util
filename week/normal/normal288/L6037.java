package week.normal.normal288;

import java.util.*;

public class L6037 {
    public int largestInteger(int num) {
        String numStr = String.valueOf(num);
        char[] numArray = numStr.toCharArray();
        PriorityQueue<Character> ji = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Character> ou = new PriorityQueue<>(Comparator.reverseOrder());

        for (char c : numArray) {
            if (c % 2 == 0) {
                ou.offer(c);
            } else {
                ji.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char c : numArray) {
            if (c % 2 == 0) {
                char x = ou.poll();
                sb.append(x);
            } else {
                char x = ji.poll();
                sb.append(x);
            }
        }
        return Integer.parseInt(sb.toString());
    }
}

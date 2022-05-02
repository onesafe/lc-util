package week.normal.normal289;

import java.util.HashMap;

public class L6071 {

    public static int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        int count = 0;
        for (Integer key : map.keySet()) {
            int value = map.get(key);
            System.out.println("key = " + key + " value = " + value + " count = " + countNum(value));
            if (!rightNum(value)) return -1;
            count += countNum(value);
        }
        return count;
    }

    private static int countNum(int num) {
        if (num == 3 || num == 2) return 1;
        if (num == 4) return 2;
        int min = Integer.MAX_VALUE;
        if (num % 3 == 0) {
            min = Math.min(num/3, min);
        }
        if (num % 2 == 0) {
            min = Math.min(num/2, min);
        }

        System.out.println("RightNum(num) is: " + num + " " + rightNum(num));
        int x = 3;
        if (rightNum(num)) {
            int c = 0;
            while(num >= x) {
                num -= x;
                c++;
                if(num -x == 0) {
                    c++;
                    break;
                }
                if(num - x < 2) {
                    c += num / 2;
                    break;
                }
            }
            return Math.min(c, min);
        }
        return -1;
    }

    private static boolean rightNum(int num) {
        if (num % 3 == 0 || num % 2 == 0) return true;

        int x = 3;
        while (num > x) {
            if ((num - x) % 2 == 0) {
                return true;
            }
            num -= x;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] tasks = new int[]{69,65,62,64,70,68,69,67,60,65,69,62,65,65,61,66,68,61,65,63,60,66,68,66,67,65,63,65,70,69,70,62,68,70,60,68,65,61,64,65,63,62,62,62,67,62,62,61,66,69};
        System.out.println(minimumRounds(tasks));
    }
}

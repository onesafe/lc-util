package week.night.night76;

public class L6061 {

    public static long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if (total < cost1 && total < cost2) return 1;
        if (total < cost1 && total > cost2) {
            return total / cost2 + 1;
        }
        if (total > cost1 && total < cost2) {
            return total / cost1 + 1;
        }

        long count = 0;
        if (cost1 >= cost2) {
            while (total >= 0) {
                count += (total / cost2) + 1;
                total -= cost1;
            }
        } else {
            while (total >= 0) {
                count += (total / cost1) + 1;
                total -= cost2;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        long r = waysToBuyPensPencils(1000000, 1, 1);
        System.out.println(r);
    }
}

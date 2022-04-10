package week.night.night75;

public class L6033 {
    public static int minBitFlips(int start, int goal) {
        int count = 0;
        String s = Integer.toBinaryString(start);
        String g = Integer.toBinaryString(goal);

        if (s.length() > g.length()) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<s.length()-g.length(); i++) {
                sb.append("0");
            }
            g = sb.toString() + g;
        } else if (g.length() > s.length()){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<g.length()-s.length(); i++) {
                sb.append("0");
            }
            s = sb.toString() + s;
        }

        for(int i=0; i<s.length(); i++) {
            if (s.charAt(i) != g.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minBitFlips(38, 5));
    }
}

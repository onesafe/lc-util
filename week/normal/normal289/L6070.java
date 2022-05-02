package week.normal.normal289;

import java.util.ArrayList;
import java.util.List;

public class L6070 {

    public static void main(String[] args) {
       // String o = digitSum("11111222223", 3);
        String o = digitSum("1234", 2);
        System.out.println(o);
    }

    public static String digitSum(String s, int k) {
        while(s.length() > k) {
            s = trans(sp(s, k));
        }
        return s;
    }

    private static List<String> sp(String s, int k) {
        List<String> list = new ArrayList<>();
        char[] strArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<strArray.length; i++) {
            if (i != 0 && i % k == 0) {
                list.add(sb.toString());
                sb = new StringBuilder();
            }
            sb.append(strArray[i]);
        }

        list.add(sb.toString());
        return list;
    }

    private static String trans(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String l : list) {
            sb.append(comba(l));
        }
        return sb.toString();
    }

    private static String comba(String ori) {
        System.out.println("ori = " + ori);
        char[] oriArray = ori.toCharArray();
        int res = 0;
        for (char o : oriArray) {
            res += o-'0';
        }
        return String.valueOf(res);
    }
}

package week.normal.normal191;

public class L6047 {
    public String removeDigit(String number, char digit) {
        char[] str = number.toCharArray();
        String res = "";


        for (int i=0; i<str.length; i++) {
            if (digit == str[i]) {
                String tmp = number.substring(0, i) + number.substring(i+1);
                if (res.compareTo(tmp) < 0) {
                    res = tmp;
                }
            }
        }

        return res;
    }
}

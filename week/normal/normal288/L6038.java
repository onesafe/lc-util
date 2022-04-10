package week.normal.normal288;

public class L6038 {
    public static String minimizeResult(String expression) {
        String[] or = expression.split("\\+");
        String pre = or[0];
        String after = or[1];

        String a="", b="", c="", d="";
        int minVal = Integer.MAX_VALUE;

        for (int i=pre.length()-1; i>=0; i--) {
            String preAdd = pre.substring(i);
            String preC = pre.substring(0, i);
            for (int j=0; j<after.length(); j++) {
                String afterAdd = after.substring(0, j+1);
                String afterC = after.substring(j+1);

                int curVal = Integer.parseInt(preAdd) + Integer.parseInt(afterAdd);
                if (!preC.equals("")) {
                    int preCVal = Integer.parseInt(preC);
                    curVal = curVal * preCVal;
                }
                if (!afterC.equals("")) {
                    int afterCVal = Integer.parseInt(afterC);
                    curVal = curVal * afterCVal;
                }
                if (curVal < minVal) {
                    minVal = curVal;
                    a = preC;
                    b = preAdd;
                    c = afterAdd;
                    d = afterC;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append("(");
        sb.append(b);
        sb.append("+");
        sb.append(c);
        sb.append(")");
        sb.append(d);
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        minimizeResult("247+38");
        minimizeResult("12+34");
        minimizeResult("999+999");
    }
}

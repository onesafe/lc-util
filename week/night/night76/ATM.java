package week.night.night76;

public class ATM {

    long[] bank; // 20, 50, 100, 200, 500
    long[] value;

    public ATM() {
        bank = new long[5];
        value = new long[]{20, 50, 100, 200, 500};
    }

    public void deposit(int[] banknotesCount) {
        for (int i=0; i<banknotesCount.length; i++) {
            bank[i] += banknotesCount[i] * value[i];
        }
    }

    public int[] withdraw(int amoun) {
        long amount = amoun;
        long[] tmp = new long[5];
        for (int i=0; i<bank.length; i++) {
            tmp[i] = bank[i];
        }

        int[] res = new int[5];
        for (int i=tmp.length-1; i>=0; i--) {
            int x = (int)Math.min(amount / value[i], tmp[i] / value[i]);
            amount = amount - (x * value[i]);
            res[i] = x;
            tmp[i] -= (x * value[i]);
        }

        if (amount != 0) return new int[]{-1};
        for (int i=0; i<bank.length; i++) {
            bank[i] = tmp[i];
        }
        return res;
    }
}

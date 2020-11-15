import java.util.Deque;
import java.util.LinkedList;

/**
 * Author: 第九代封妖师
 * Date: 2020/11/15
 */
public class DandiaoStack {

    public void dandiaoStack(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }
    }
}

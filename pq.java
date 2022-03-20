import java.math.BigDecimal;
import java.util.Comparator;
import java.util.PriorityQueue;

public class pq {

    // 最大堆
    PriorityQueue<BigDecimal> p = new PriorityQueue<>(Comparator.reverseOrder());

    // 最小堆
    PriorityQueue<BigDecimal> q = new PriorityQueue<>();
}

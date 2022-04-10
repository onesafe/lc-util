package queue;

import java.util.*;

public class L1606 {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        //存放空闲的服务器编号，0~k-1，treeset集合去重默认升序
        TreeSet<Integer> available = new TreeSet<Integer>();

        for (int i = 0; i < k; i++) {
            available.add(i);  //初始化，全部空闲可用
        }

        //优先队列，正在工作的服务器，以最早结束时间做小根堆
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        //每个服务器的以工作数量，答案就是这个数组中最大的，下标就代表服务器号
        int[] requests = new int[k];

        //升序的到达时间，直接遍历所有请求
        for (int i = 0; i < arrival.length; i++) {

            //因为到达时间升序，直接判断，到达之前有没有结束的服务器，放到空闲列表中
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                available.add(busy.poll()[1]);
            }

            //到达时没有空闲服务器，直接忽略这个请求
            if (available.isEmpty()) {
                continue;
            }

            //api方法，寻找空闲服务器中的，大于等于i%k的最小服务器序号，没有则返回空
            Integer p = available.ceiling(i % k);
            //i%k之后没有空闲的，直接找最小编号的空闲服务器
            if (p == null) {
                p = available.first();
            }

            //使用p号服务器执行当前请求
            requests[p]++;
            //将执行记录加入到优先队列中， 结束时间-服务器号，结束时间为请到达时间+请求处理时间
            busy.offer(new int[]{arrival[i] + load[i], p});
            //空闲集合中删除p号服务器
            available.remove(p);
        }

        //所有请求都处理完了，取请求数最大的服务器号
        int maxRequest = Arrays.stream(requests).max().getAsInt();

        //如果有相同最大的处理请求数，加入答案集合
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            if (requests[i] == maxRequest) {
                ret.add(i);
            }
        }
        return ret;
    }
}

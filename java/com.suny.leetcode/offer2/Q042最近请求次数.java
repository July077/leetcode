package offer2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer II 042. 最近请求次数
 * <p>
 * 写一个RecentCounter类来计算特定时间范围内最近的请求。
 * <p>
 * 请实现 RecentCounter 类：
 * <p>
 * RecentCounter() 初始化计数器，请求数为 0 。
 * int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
 * 保证 每次对 ping 的调用都使用比之前更大的 t 值。
 * <p>
 *
 * <p>
 * 示例：
 * <p>
 * 输入：
 * inputs = ["RecentCounter", "ping", "ping", "ping", "ping"]
 * inputs = [[], [1], [100], [3001], [3002]]
 * 输出：
 * [null, 1, 2, 3, 3]
 * <p>
 * 解释：
 * RecentCounter recentCounter = new RecentCounter();
 * recentCounter.ping(1);     // requests = [1]，范围是 [-2999,1]，返回 1
 * recentCounter.ping(100);   // requests = [1, 100]，范围是 [-2900,100]，返回 2
 * recentCounter.ping(3001);  // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
 * recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/21 下午10:54
 */
public class Q042最近请求次数 {
    Deque<Integer> deque;

    public Q042最近请求次数() {
        deque = new LinkedList<>();
    }

    public int ping(int t) {
        deque.offerLast(t);

        while (deque.peekFirst() < t - 3000) {
            deque.pollFirst();
        }
        return deque.size();
    }
}

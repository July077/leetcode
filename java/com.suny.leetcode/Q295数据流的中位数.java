import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 * <p>
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4]的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-27 9:24
 */
public class Q295数据流的中位数 {

    private PriorityQueue<Integer> queueMin;
    private PriorityQueue<Integer> queueMax;

    /**
     * initialize your data structure here.
     */
    public Q295数据流的中位数() {
        queueMin = new PriorityQueue<>((a, b) -> (b - a));
        queueMax = new PriorityQueue<>((a, b) -> (a - b));

    }

    public void addNum(int num) {
        if (queueMin.isEmpty() || num <= queueMin.peek()) {
            queueMin.offer(num);
            if (queueMax.size() + 1 < queueMin.size()) {
                queueMax.offer(queueMin.poll());
            }
        } else {
            queueMax.offer(num);
            if (queueMax.size() > queueMin.size()) {
                queueMin.offer(queueMax.poll());
            }
        }

    }

    public double findMedian() {
        if (queueMin.size() > queueMax.size()) {
            return queueMin.peek();
        }

        return (queueMin.peek() + queueMax.peek()) / 2.0;
    }
}

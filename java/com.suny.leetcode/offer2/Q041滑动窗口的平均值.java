package offer2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer II 041. 滑动窗口的平均值
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。
 * <p>
 * 实现 MovingAverage 类：
 * <p>
 * MovingAverage(int size) 用窗口大小 size 初始化对象。
 * double next(int val)成员函数 next每次调用的时候都会往滑动窗口增加一个整数，请计算并返回数据流中最后 size 个值的移动平均值，即滑动窗口里所有数字的平均值。
 *
 * <p>
 * 示例：
 * <p>
 * 输入：
 * inputs = ["MovingAverage", "next", "next", "next", "next"]
 * inputs = [[3], [1], [10], [3], [5]]
 * 输出：
 * [null, 1.0, 5.5, 4.66667, 6.0]
 * <p>
 * 解释：
 * MovingAverage movingAverage = new MovingAverage(3);
 * movingAverage.next(1); // 返回 1.0 = 1 / 1
 * movingAverage.next(10); // 返回 5.5 = (1 + 10) / 2
 * movingAverage.next(3); // 返回 4.66667 = (1 + 10 + 3) / 3
 * movingAverage.next(5); // 返回 6.0 = (10 + 3 + 5) / 3
 * <p>
 * 先传入一个 MovingAverage 和 3，表示初始化滑动窗口的大小为 3
 * 传入 next 和 1，表示数据流里填入一个 1，我们用 [] 表示滑动窗口，这时候数据流可以表示为：[1]
 * 传入 next 和 10，数据流里再填入一个 10，这时候数据流可以表示为：[1, 10]
 * 传入 next 和 3，数据流里再填入一个 3，这时候数据流可以表示为：[1, 10, 3]
 * 传入 next 和 5，数据流里再填入一个 5，窗口右移，这时候数据流可以表示为：1, [10, 3, 5]
 * 最后输出的就是窗口里的平均值，注意类型为 double 即可
 *
 * @author sunjianrong
 * @date 2021/8/21 下午10:41
 */
public class Q041滑动窗口的平均值 {
    Queue<Integer> queue;
    int size;
    double total = 0;


    public Q041滑动窗口的平均值(int size) {
        this.size = size;
        queue = new LinkedList<>();
    }

    public double next(int val) {
        total += val;
        if (queue.size() < size) {
            queue.offer(val);
        } else {
            total -= queue.poll();
            queue.offer(val);
        }

        return total / queue.size();
    }

}

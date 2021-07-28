package offer;

import java.util.Stack;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 *
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * <p>
 *
 * @author sunjianrong
 * @date 2021/7/28 下午9:39
 */
public class Q30包含min函数的栈 {

    // a栈顶放最大值 b栈顶放最小值
    Stack<Integer> a;
    Stack<Integer> b;

    /**
     * initialize your data structure here.
     */
    public Q30包含min函数的栈() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(int x) {
        a.add(x);

        // 如果当前添加的数值比 b 栈顶小的话才放上去，否则等下取不到最小值
        if (b.isEmpty() || b.peek() >= x) {
            b.add(x);
        }

    }

    public void pop() {
        // a直接弹出，如果弹出的值跟b栈顶一样就一起弹出去，保持最小值
        if (a.pop().equals(b.peek())) {
            b.pop();
        }

    }

    public int top() {
        return a.peek();
    }

    public int min() {
        return b.peek();
    }

}

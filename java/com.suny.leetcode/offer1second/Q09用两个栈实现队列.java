import java.util.LinkedList;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead
 * ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * 
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 * 
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 */
class Q09用两个栈实现队列 {
    LinkedList<Integer> list1;
    LinkedList<Integer> list2;

    public Q09用两个栈实现队列() {
        list1 = new LinkedList();
        list2 = new LinkedList();
    }

    public void appendTail(int value) {
        list1.addLast(value);
    }

    public int deleteHead() {
        if (!list2.isEmpty()) {
            return list2.removeLast();
        }
        if (list1.isEmpty()) {
            return -1;
        }

        while (!list1.isEmpty()) {
            list2.add(list1.removeLast());
        }
        return list2.removeLast();
    }
}
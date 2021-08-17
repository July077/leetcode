package offer2;

import java.util.*;

/**
 * 剑指 Offer II 030. 插入、删除和随机访问都是 O(1) 的容器
 * 设计一个支持在平均时间复杂度 O(1)下，执行以下操作的数据结构：
 * <p>
 * insert(val)：当元素 val 不存在时返回 true，并向集合中插入该项，否则返回 false 。
 * remove(val)：当元素 val 存在时返回 true，并从集合中移除该项，否则f返回 true。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 *
 * <p>
 * 示例 :
 * <p>
 * 输入: inputs = ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * 输出: [null, true, false, true, 2, true, false, 2]
 * 解释:
 * RandomizedSet randomSet = new RandomizedSet();  // 初始化一个空的集合
 * randomSet.insert(1); // 向集合中插入 1 ， 返回 true 表示 1 被成功地插入
 * <p>
 * randomSet.remove(2); // 返回 false，表示集合中不存在 2
 * <p>
 * randomSet.insert(2); // 向集合中插入 2 返回 true ，集合现在包含 [1,2]
 * <p>
 * randomSet.getRandom(); // getRandom 应随机返回 1 或 2
 * <p>
 * randomSet.remove(1); // 从集合中移除 1 返回 true 。集合现在包含 [2]
 * <p>
 * randomSet.insert(2); // 2 已在集合中，所以返回 false
 * <p>
 * randomSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-17 12:01
 */
public class Q030插入删除和随机访问都是O1的容器 {

    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random random = new Random();


    /**
     * Initialize your data structure here.
     */
    public Q030插入删除和随机访问都是O1的容器() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int lastElement = list.get(list.size() - 1);

        // 将最后一个元素放到被删除元素的位置上去
        final Integer removeElementIndex = map.get(val);
        list.set(removeElementIndex, lastElement);

        // map 中的元素进行替换
        map.put(lastElement, removeElementIndex);

        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        int val = 1;
        final Q030插入删除和随机访问都是O1的容器 obj = new Q030插入删除和随机访问都是O1的容器();
        boolean param1 = obj.insert(val);
        System.out.println(param1);
        boolean param2 = obj.remove(val);
        System.out.println(param2);
        int param3 = obj.getRandom();
        System.out.println(param3);
    }
}

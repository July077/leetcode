package offer2;

import java.util.*;

/**
 * 剑指 Offer II 109. 开密码锁
 * 一个密码锁由 4个环形拨轮组成，每个拨轮都有 10 个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为'0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，请给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * <p>
 *
 * <p>
 * 示例 1:
 * <p>
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，因为当拨动到 "0102" 时这个锁就会被锁定。
 * <p>
 * <p>
 *
 * @author sunjianrong
 * @date 2021/9/13 下午10:49
 */
public class Q109开密码锁 {

    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }

        Set<String> deadStr = new HashSet<>(Arrays.asList(deadends));
        if (deadStr.contains("0000")) {
            return -1;
        }

        // 初始化
        Set<String> seen = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        seen.add("0000");

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ++step;
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                for (String nextStatus : get(poll)) {
                    if (!deadStr.contains(nextStatus) && !seen.contains(nextStatus)) {
                        if (nextStatus.equals(target)) {
                            return step;
                        }
                        queue.add(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }

        return -1;
    }

    private char preNum(char num) {
        return num == '0' ? '9' : (char) (num - 1);
    }

    private char nextNum(char num) {
        return num == '9' ? '0' : (char) (num + 1);
    }

    public List<String> get(String status) {
        List<String> list = new ArrayList<>();
        char[] chars = status.toCharArray();
        for (int i = 0; i < 4; i++) {
            // 修改某一位数字
            char num = chars[i];
            // num-1
            chars[i] = preNum(num);
            list.add(new String(chars));

            // num+1
            chars[i] = nextNum(num);
            list.add(new String(chars));

            // 恢复 cs[i]
            chars[i] = num;
        }
        return list;
    }


}

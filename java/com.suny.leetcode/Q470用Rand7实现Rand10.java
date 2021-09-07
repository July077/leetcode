/**
 * 470. 用 Rand7() 实现 Rand10()
 * <p>
 * 已有方法rand7可生成 1 到 7 范围内的均匀随机整数，试写一个方法rand10生成 1 到 10 范围内的均匀随机整数。
 * <p>
 * 不要使用系统的Math.random()方法。
 * <p>
 *
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: [7]
 * 示例 2:
 * <p>
 * 输入: 2
 * 输出: [8,4]
 * <p>
 * <p>
 *
 * @author sunjianrong
 * @date 2021/9/5 下午4:00
 */
public class Q470用Rand7实现Rand10 {


    public int rand10() {
        int num = (rand7() - 1) * 7 + rand7();
        while (num > 10) {
            num = (rand7() - 1) * 7 + rand7();
        }
        return num;
    }

    private int rand7() {
        return -1;
    }
}

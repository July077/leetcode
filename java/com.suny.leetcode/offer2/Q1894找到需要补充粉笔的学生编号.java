package offer2;

import java.util.Arrays;

/**
 * 1894. 找到需要补充粉笔的学生编号
 * <p>
 * 一个班级里有n个学生，编号为 0到 n - 1。每个学生会依次回答问题，编号为 0的学生先回答，然后是编号为 1的学生，以此类推，直到编号为 n - 1的学生，然后老师会重复这个过程，重新从编号为 0的学生开始回答问题。
 * <p>
 * 给你一个长度为 n且下标从 0开始的整数数组chalk和一个整数k。一开始粉笔盒里总共有k支粉笔。当编号为i的学生回答问题时，他会消耗 chalk[i]支粉笔。如果剩余粉笔数量 严格小于chalk[i]，那么学生 i需要 补充粉笔。
 * <p>
 * 请你返回需要 补充粉笔的学生 编号。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：chalk = [5,1,5], k = 22
 * 输出：0
 * 解释：学生消耗粉笔情况如下：
 * - 编号为 0 的学生使用 5 支粉笔，然后 k = 17 。
 * - 编号为 1 的学生使用 1 支粉笔，然后 k = 16 。
 * - 编号为 2 的学生使用 5 支粉笔，然后 k = 11 。
 * - 编号为 0 的学生使用 5 支粉笔，然后 k = 6 。
 * - 编号为 1 的学生使用 1 支粉笔，然后 k = 5 。
 * - 编号为 2 的学生使用 5 支粉笔，然后 k = 0 。
 * 编号为 0 的学生没有足够的粉笔，所以他需要补充粉笔。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-09-10 9:26
 */
public class Q1894找到需要补充粉笔的学生编号 {

    public int chalkReplacer(int[] chalk, long k) {
        final long sum = Arrays.stream(chalk).mapToLong(i -> i).sum();
        System.out.println("开始缩小范围 k % sum = " + k);
        k = k % sum;

        System.out.println("初始化" + k + "根粉笔");
        for (int i = 0; i < chalk.length; i++) {
            k = k - chalk[i];
            if (k < 0) {
                return i;
            }
            System.out.println("学生" + i + "本次消耗" + chalk[i] + "根粉笔,剩余" + k + "根粉笔");

        }
        return -1;
    }


    public static void main(String[] args) {
        final int[] ints = {5, 1, 5};
        final Q1894找到需要补充粉笔的学生编号 q1894 = new Q1894找到需要补充粉笔的学生编号();
        System.out.println(q1894.chalkReplacer(ints, 22));
    }
}

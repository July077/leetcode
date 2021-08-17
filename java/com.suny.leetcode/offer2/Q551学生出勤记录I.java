package offer2;

/**
 * 551. 学生出勤记录 I
 * 给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * <p>
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 * <p>
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 3 天以上的迟到（'L'）记录。
 * 如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "PPALLP"
 * 输出：true
 * 解释：学生缺勤次数少于 2 次，且不存在 3 天或以上的连续迟到记录。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-08-17 9:32
 */
public class Q551学生出勤记录I {

    public boolean checkRecord(String s) {
        int total = s.length();
        int absentNum = 0;
        int lateNum = 0;

        for (int i = 0; i < total; i++) {
            final char c = s.charAt(i);
            if (c == 'A') {
                ++absentNum;
                if (absentNum >= 2) {
                    return false;
                }
            }
            if (c == 'L') {
                ++lateNum;

                if (lateNum >= 3) {
                    return false;
                }
            } else {
                lateNum = 0;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        final Q551学生出勤记录I q551 = new Q551学生出勤记录I();
        // System.out.println(q551.checkRecord("PPALLL"));
        // System.out.println(q551.checkRecord("LLLALL"));
        System.out.println(q551.checkRecord("LLLALL"));
    }
}

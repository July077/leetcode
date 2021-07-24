/**
 * 1736. 替换隐藏数字得到的最晚时间
 * 给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
 * <p>
 * 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
 * <p>
 * 替换time 中隐藏的数字，返回你可以得到的最晚有效时间。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：time = "2?:?0"
 * 输出："23:50"
 * 解释：以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。
 * 示例 2：
 * <p>
 * 输入：time = "0?:3?"
 * 输出："09:39"
 * 示例 3：
 * <p>
 * 输入：time = "1?:22"
 * 输出："19:22"
 *
 * @author sunjianrong
 * @date 2021/7/24 下午10:44
 */
public class Q1736替换隐藏数字得到的最晚时间 {

    public String maximumTime(String time) {
        StringBuilder sb = new StringBuilder();

        if (time.charAt(0) == '?') {
            if (time.charAt(1) == '?' || time.charAt(1) < '4') {
                sb.append("2");
            } else {
                sb.append("1");
            }
        } else {
            sb.append(time.charAt(0));
        }


        if (time.charAt(1) == '?') {
            if (time.charAt(0) == '2' || time.charAt(0) == '?') {
                sb.append("3");
            } else {
                sb.append("9");
            }
        } else {
            sb.append(time.charAt(1));
        }

        sb.append(":");


        if (time.charAt(3) == '?') {
            sb.append("5");
        } else {
            sb.append(time.charAt(3));
        }


        if (time.charAt(4) == '?') {
            sb.append("9");
        } else {
            sb.append(time.charAt(4));
        }

        return sb.toString();
    }


}

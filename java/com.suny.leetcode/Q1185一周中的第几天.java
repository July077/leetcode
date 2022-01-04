/**
 * 1185. 一周中的第几天
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 * <p>
 * 输入为三个整数：day、month 和 year，分别表示日、月、年。
 * <p>
 * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：day = 31, month = 8, year = 2019
 * 输出："Saturday"
 * 示例 2：
 * <p>
 * 输入：day = 18, month = 7, year = 1999
 * 输出："Sunday"
 * 示例 3：
 * <p>
 * 输入：day = 15, month = 8, year = 1993
 * 输出："Sunday"
 *
 * @author sunjianrong
 * @date 2022/1/3 下午10:01
 */
public class Q1185一周中的第几天 {

    public static final String[] weeks = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday","Sunday"};

    public String dayOfTheWeek(int day, int month, int year) {
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};

        int days = 365 * (year - 1971) + (year - 1969) / 4;

        for (int i = 0; i < month - 1; i++) {
            days += monthDays[i];
        }

        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
            days += 1;
        }

        days += day;
        return weeks[(days + 3) % 7];
    }
}

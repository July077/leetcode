package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author sunjianrong
 * @date 2021/7/26 下午4:55
 */
public class ReportDateTransform {


    /**
     * 获取报表选定周日期列表
     *
     * @param year       报表选定年份
     * @param weekOfYear 每年第几周
     * @return 本周日期列表
     */
    public static List<Date> getWeekDateList(int year, int weekOfYear) {
        List<Date> dateList = new ArrayList<>();

        // 初始化报表选定日期
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.WEEK_OF_YEAR, weekOfYear);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);

        // 获取本周日期
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        calendar.add(Calendar.DATE, calendar.getFirstDayOfWeek() - day);
        dateList.add(calendar.getTime());

        IntStream.range(1, 7).forEachOrdered(i -> {
            calendar.add(Calendar.DATE, 1);
            dateList.add(calendar.getTime());
        });


        return dateList;
    }

    /**
     * 获取报表选定周日期字符串列表
     *
     * @param year       报表选定年份
     * @param weekOfYear 每年第几周
     * @return 指定周周日期字符串列表
     */
    public static List<String> getWeekDateStringList(int year, int weekOfYear) {
        return getWeekDateList(year, weekOfYear).stream().map(e -> new SimpleDateFormat("yyyy-MM-dd").format(e)).collect(Collectors.toList());
    }


    public static void main(String[] args) {
        List<Date> dateList = getWeekDateList(2021, 16);
        System.out.println(dateList);


        List<String> dateStringList = getWeekDateStringList(2021, 16);
        System.out.println(dateStringList);

    }


}

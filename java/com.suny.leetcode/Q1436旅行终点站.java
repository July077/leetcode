import java.util.ArrayList;
import java.util.List;

/**
 * 1436. 旅行终点站
 * <p>
 * 给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi 。请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
 * <p>
 * 题目数据保证线路图会形成一条不存在循环的线路，因此恰有一个旅行终点站。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
 * 输出："Sao Paulo"
 * 解释：从 "London" 出发，最后抵达终点站 "Sao Paulo" 。本次旅行的路线是 "London" -> "New York" -> "Lima" -> "Sao Paulo" 。
 * <p>
 *
 * @author sunjianrong
 * @date 2021-10-01 21:55
 */
public class Q1436旅行终点站 {

    public String destCity(List<List<String>> paths) {
        List<String> start = new ArrayList<>();
        for (List<String> path : paths) {
            start.add(path.get(0));
        }

        for (List<String> path : paths) {
            if (!start.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }
}

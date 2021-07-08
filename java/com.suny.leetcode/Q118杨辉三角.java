import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * <p>
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * @author sunjianrong
 * @date 2021/7/8 下午10:54
 */
public class Q118杨辉三角 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> externalList = new ArrayList<List<Integer>>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(externalList.get(i - 1).get(j - 1) + externalList.get(i - 1).get(j));
                }
            }
            externalList.add(list);
        }

        return externalList;
    }
}

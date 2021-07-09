import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * <p>
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * @author sunjianrong
 * @date 2021-07-09 8:57
 */
public class Q119杨辉三角II {


    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>(rowIndex + 1);
        ans.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            int leftOperand = 1;
            int nextLeft;
            for (int j = 1; j < i; j++) {
                // 在 set(j) 之前记住 ans[j] 的值,给下一轮的循环去使用
                nextLeft = ans.get(j);
                ans.set(j, leftOperand + ans.get(j));

                leftOperand = nextLeft;
            }

            // 一行的最后1
            ans.add(1);

        }

        return ans;
    }
}

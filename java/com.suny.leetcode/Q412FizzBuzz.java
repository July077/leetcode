import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * <p>
 * 1. 如果n是3的倍数，输出“Fizz”；
 * <p>
 * 2. 如果n是5的倍数，输出“Buzz”；
 * <p>
 * 3.如果n同时是3和5的倍数，输出 “FizzBuzz”。
 * <p>
 * 示例：
 * <p>
 * n = 15,
 * <p>
 * 返回:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 * <p>
 *
 * @author sunjianrong
 * @date 2021-10-13 9:34
 */
public class Q412FizzBuzz {


    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
                continue;
            }

            if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }


        }
        return res;
    }
}

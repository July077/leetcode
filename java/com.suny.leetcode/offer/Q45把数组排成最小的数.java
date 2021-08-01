package offer;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 * <p>
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 *
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: "102"
 * 示例2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/1 下午10:03
 */
public class Q45把数组排成最小的数 {

    public String minNumber0(int[] nums) {
        return IntStream.of(nums).mapToObj(String::valueOf).sorted((o1, o2) -> (o1 + o2).compareTo((o2 + o1))).collect(Collectors.joining());
    }

    public String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        quickSort(strings, 0, strings.length - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            stringBuilder.append(string);
        }

        return stringBuilder.toString();

    }

    private void quickSort(String[] strs, int l, int r) {
        if (l >= r) {
            return;
        }

        int i = l;
        int j = r;
        String tmp = strs[i];
        while (i < j) {
            while ((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) {
                j--;
            }
            while ((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) {
                i++;
            }

            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }

        strs[i] = strs[l];
        strs[l] = tmp;
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
    }

}

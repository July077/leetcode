import java.util.ArrayList;
import java.util.Arrays;

/**
 * 66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * @author sunjianrong
 * @date 2021/6/18 下午10:47
 */
public class Q66加一 {

    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        // 说明全是9
        int[] temp = new int[digits.length + 1];
        temp[0] = 1;
        return temp;


    }

    public static void main(String[] args) {
        Q66加一 q66 = new Q66加一();
        System.out.println(Arrays.equals(q66.plusOne(new int[]{0}), new int[]{1}));
        System.out.println(Arrays.equals(q66.plusOne(new int[]{9, 9}), new int[]{1, 0, 0}));
    }

}

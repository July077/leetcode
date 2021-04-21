/**
 * @author sunjianrong
 * @date 2021/4/21 下午9:13
 */
public class Q7整数反转 {

    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            // 每次取到末尾数字
            int tmp = x % 10;

            // 判断是否大于最大的32位整数
            if (res > Integer.MAX_VALUE || (res == Integer.MAX_VALUE && tmp > 7)) {
                return 0;
            }

            // 判断是否小于最小的32位整数
            if (res < Integer.MIN_VALUE || (res == Integer.MIN_VALUE && tmp < -8)) {
                return 0;
            }

            res = res * 10 + tmp;
            x = x / 10;
        }


        return res;
    }


    public static void main(String[] args) {
        int reverse = reverse(12345);
        System.out.println(reverse);
    }
}

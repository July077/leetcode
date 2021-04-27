/**
 * @author sunjianrong
 * @date 2021/4/27 下午9:05
 */
public class Q12整数转罗马数字 {
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (index < 13) {
            if (num >= nums[index]) {
                stringBuilder.append(romans[index]);
                num = num - nums[index];
            } else {
                index++;
            }
        }

        return stringBuilder.toString();
    }
}

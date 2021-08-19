import java.util.HashSet;
import java.util.Set;

/**
 * 345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："hello"
 * 输出："holle"
 *
 * @author sunjianrong
 * @date 2021-08-19 9:13
 */
public class Q345反转字符串中的元音字母 {


    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        final char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            final char a = chars[left];
            final char b = chars[right];

            if (!vowels.contains(a)) {
                left++;
            }

            if (!vowels.contains(b)) {
                right--;
            }

            if (vowels.contains(a) && vowels.contains(b)) {
                swap(chars, left, right);
                left++;
                right--;
            }

        }

        return new String(chars);
    }


    private void swap(char[] chars, int left, int right) {
        final char tmp = chars[right];
        chars[right] = chars[left];
        chars[left] = tmp;
    }


    public static void main(String[] args) {
        final Q345反转字符串中的元音字母 q345 = new Q345反转字符串中的元音字母();
        System.out.println(q345.reverseVowels("hello"));
    }
}

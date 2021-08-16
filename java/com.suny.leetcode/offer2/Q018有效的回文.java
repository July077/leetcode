package offer2;

/**
 * 剑指 Offer II 018. 有效的回文
 * 给定一个字符串 s ，验证 s是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 本题中，将空字符串定义为有效的回文串。
 * <p>
 *
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * <p>
 *
 * @author sunjianrong
 * @date 2021/8/13 下午10:08
 */
public class Q018有效的回文 {

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        int n = sb.length();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (Character.toLowerCase(sb.charAt(left)) != Character.toLowerCase(sb.charAt(right))) {
                return false;
            }

            ++left;
            --right;
        }

        return true;
    }

    public boolean isPalindrome0(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        return new StringBuilder(sb).reverse().toString().equals(sb.toString());
    }

    public static void main(String[] args) {
        Q018有效的回文 q18 = new Q018有效的回文();
        System.out.println(q18.isPalindrome0("race a car"));
    }
}

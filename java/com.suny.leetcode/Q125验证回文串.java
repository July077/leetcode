/**
 * 125. 验证回文串
 * <p>
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * @author sunjianrong
 * @date 2021/7/11 上午11:13
 */
public class Q125验证回文串 {

    public boolean isPalindrome2(String s) {
        int length = s.length();
        int left = 0;
        int right = length - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }

                left++;
                right--;
            }

        }
        return true;
    }

    public boolean isPalindrome1(String s) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();

        for (int i = 0; i < length; i++) {
            char charAt = s.charAt(i);
            if (Character.isLetterOrDigit(charAt)) {
                sb.append(Character.toLowerCase(charAt));
            }
        }

        int left = 0;
        int right = sb.length() - 1;

        while (left < right) {
            if (Character.toLowerCase(sb.charAt(left)) != Character.toLowerCase(sb.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;

    }


    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();

        for (int i = 0; i < length; i++) {
            char charAt = s.charAt(i);
            if (Character.isLetterOrDigit(charAt)) {
                sb.append(Character.toLowerCase(charAt));
            }
        }

        StringBuilder reverse = new StringBuilder(sb).reverse();
        return sb.toString().equals(reverse.toString());
    }
}

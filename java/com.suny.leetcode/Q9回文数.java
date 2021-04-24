/**
 * @author sunjianrong
 * @date 2021/4/24 下午10:00
 */
public class Q9回文数 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x = x / 10;
        }


        return x == revertedNumber || x == revertedNumber / 10;
    }
}

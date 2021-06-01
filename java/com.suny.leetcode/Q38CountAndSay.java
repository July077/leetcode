/**
 * 38. 外观数列
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * <p>
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 *
 * @author sunjianrong
 * @date 2021/6/1 下午11:07
 */
public class Q38CountAndSay {

    public static void main(String[] args) {
        Q38CountAndSay say = new Q38CountAndSay();
        String res = say.countAndSay(30);
        System.out.println(res);
    }

    public String countAndSay(int n) {
        String s = "1";
        for (int i = 0; i < n - 1; i++) {
            s = handler(s);
        }
        return s;
    }

    private String handler(String s) {
        StringBuilder r = new StringBuilder();
        if (s.length() == 1) {
            r.append("1");
            r.append(s);
        }

        int num = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                num = num + 1;
            } else {
                r.append(num);
                r.append(s.charAt(i - 1));
                num = 1;
            }

            if (i == s.length() - 1) {
                r.append(num);
                r.append(s.charAt(i));
            }


        }
        return r.toString();
    }
}

/**
 * 171. Excel表列序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * <p>
 * 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * <p>
 *
 * @author sunjianrong
 * @date 2021-07-30 9:16
 */
public class Q171Excel表列序号 {

    public int titleToNumber(String columnTitle) {
        int res = 0;
        final char[] chars = columnTitle.toCharArray();

        // 从左到右遍历每个字符，计算 ascii 码
        for (char c : chars) {
            res = res * 26 + c - 'A' + 1;
        }

        return res;
    }


    public static void main(String[] args) {
        final Q171Excel表列序号 q171 = new Q171Excel表列序号();
        final int toNumber = q171.titleToNumber("CB");
        System.out.println(toNumber);
    }
}

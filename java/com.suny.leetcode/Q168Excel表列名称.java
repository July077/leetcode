/**
 * 168. Excel表列名称
 * <p>
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 *
 * @author sunjianrong
 * @date 2021/6/29 下午9:36
 */
public class Q168Excel表列名称 {

    public String convertToTitle(int columnNumber) {

        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            int i = columnNumber % 26 + 'A';
            sb.append((char) i);
            System.out.println("append " + i + " [" + (char) i + "]");
            System.out.println("columnNumber = " + columnNumber + "/26= " + columnNumber / 26);
            columnNumber = columnNumber / 26;
        }

        sb.reverse();
        return sb.toString();
    }


    public static void main(String[] args) {
        Q168Excel表列名称 q168 = new Q168Excel表列名称();
        String convertToTitle = q168.convertToTitle(200);
        System.out.println(convertToTitle);
    }
}

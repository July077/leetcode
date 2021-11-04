/**
 * 331. 验证二叉树的前序序列化
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 * <p>
 * _9_
 * /   \
 * 3     2
 * / \   / \
 * 4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 * <p>
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 * <p>
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 * <p>
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如"1,,3" 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * 输出: true
 * 示例2:
 * <p>
 * 输入: "1,#"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: "9,#,#,1"
 * 输出: false
 * <p>
 *
 * @author sunjianrong
 * @date 2021-11-04 11:58
 */
public class Q331验证二叉树的前序序列化 {


    public boolean isValidSerialization(String preorder) {
        int degrees = 1;

        for (int i = 0; i < preorder.length(); i++) {
            if (degrees == 0) {
                return false;
            }

            if (preorder.charAt(i) == ',' && preorder.charAt(i - 1) != '#') {
                degrees++;
            } else if (preorder.charAt(i) == '#') {
                degrees--;
            }
        }

        return degrees == 0;

    }

}

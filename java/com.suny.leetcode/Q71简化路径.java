import java.util.Deque;
import java.util.LinkedList;

/**
 * 71. 简化路径
 * <p>
 * 给你一个字符串 path ，表示指向某一文件或目录的Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 * <p>
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..）表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 * <p>
 * 请注意，返回的 规范路径 必须遵循下述格式：
 * <p>
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * 返回简化后得到的 规范路径 。
 *
 * @author sunjianrong
 * @date 2021/6/21 下午9:23
 */
public class Q71简化路径 {

    public String simplifyPath(String path) {
        // 参照 linux 路径思路 , 用栈进行处理
        Deque<String> stack = new LinkedList<>();
        String[] split = path.split("/");

        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            // " " "."直接忽略
            if (s.equals("") || s.equals(".")) {
                continue;
                // .. 返回上一级，把栈里面的元素弹出去
            } else if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else {
                // 压栈
                stack.offer(s);
            }

        }

        // 拼接路径,默认至少需要一个 /
        StringBuilder sb = new StringBuilder("/");

        // 方法一
//        while (!stack.isEmpty()) {
//            sb.append(stack.poll());
        // 如果还有下级路径那么就需要拼上 /
//            if (!stack.isEmpty()) {
//                sb.append("/");
//            }
//        }
//        String s = sb.toString();
//        return s.equals("") ? "/" : s;


        // 方法二
        return "/" + String.join("/", stack);

    }
}

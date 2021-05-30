import java.util.*;

/**
 * 36. 有效的数独
 * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 注意：
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 *
 * @author sunjianrong
 * @date 2021/5/30 下午10:51
 */
public class Q36ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int) num;
                    int boxIndex = (i / 3) * 3 + j / 3;

                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[i].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[boxIndex].put(n, boxes[boxIndex].getOrDefault(n, 0) + 1);

                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[boxIndex].get(n) > 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }


    public boolean isValidSudoku1(char[][] board) {
        char dot = '.';
        List<Character> list = new ArrayList<>();
        list.add(dot);
        list.add('1');
        list.add('2');
        list.add('3');
        list.add('4');
        list.add('5');
        list.add('6');
        list.add('7');
        list.add('8');
        list.add('9');

        for (int x = 0; x < 8; x++) {
            Map<Element, Character> rows = new HashMap<>();
            for (int y = 0; y < 8; y++) {
                Element key = new Element(x, y);
                char value = board[x][y];
                // 除了0-9 . 其它字符为非法
                if (!list.contains(value)) {
                    return false;
                }

                // 检查横向. x固定 y变化
                for (int k = y; k > 0; k--) {
                    Element checkElement = new Element(x, k);
                    if (rows.containsKey(checkElement) && rows.get(checkElement) == value) {
                        return false;
                    }
                }

                // 检查纵向. x变化 y固定
                for (int l = x; l > 0; l--) {
                    Element checkElement = new Element(l, y);
                    if (rows.containsKey(checkElement) && rows.get(checkElement) == value) {
                        return false;
                    }
                }

                // 检查九宫格


                // 放入元素
                rows.put(key, value);


            }
        }

        return true;
    }

    static class Element {
        private final int rowIndex;
        private final int colIndex;

        public Element(int rowIndex, int colIndex) {
            this.rowIndex = rowIndex;
            this.colIndex = colIndex;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Element element = (Element) o;
            return rowIndex == element.rowIndex && colIndex == element.colIndex;
        }

        @Override
        public int hashCode() {
            return Objects.hash(rowIndex, colIndex);
        }
    }

}

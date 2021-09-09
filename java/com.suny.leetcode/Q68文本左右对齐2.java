import java.util.ArrayList;
import java.util.List;

/**
 * 68. 文本左右对齐
 *
 * @author sunjianrong
 * @date 2021-09-09 9:23
 */
public class Q68文本左右对齐2 {


    public List<String> fullJustify(String[] words, int maxWidth) {
        final String[] space = new String[maxWidth + 1];
        final StringBuffer sb = new StringBuffer();

        for (int i = 0; i < maxWidth + 1; i++) {
            space[i] = sb.toString();
            sb.append(" ");
        }

        List<String> pWords = new ArrayList<>();
        //遍历 words
        for (int i = 0; i < words.length; i++) {
            int length = words[i].length();
            int start = i;
            while (i < words.length - 1 && length < maxWidth) {
                i++;
                // 每读一个单词都要加一个空格
                length = length + words[i].length() + 1;
            }
            // 多读了一个单词
            if (length > maxWidth) {
                length = length - words[i].length() - 1;
                i--;
            }
            pWords.add(processCurLine(words, start, i, length, maxWidth, space));
        }
        return pWords;
    }


    public String processCurLine(String[] words, int startIndex, int endIndex, int currentLength, int maxWidth, String[] space) {
        final StringBuffer sb = new StringBuffer();
        int gap = endIndex - startIndex;
        // 记录总共几个空格
        int addSpace = maxWidth - currentLength + gap;
        if (gap == 0) {
            sb.append(words[endIndex]);
            sb.append(space[addSpace]);
            return sb.toString();
        }

        // 排版最后一行
        if (endIndex == words.length - 1) {
            for (int i = startIndex; i < endIndex; i++) {
                sb.append(words[i]).append(" ");
            }
            sb.append(words[endIndex]);
            sb.append(space[addSpace - gap]);
            return sb.toString();
        }

        int allAddSpace = addSpace / gap;
        int left = addSpace % gap + startIndex;
        for (int i = startIndex; i < endIndex; i++) {
            sb.append(words[i]).append(space[allAddSpace]);
            if (i < left) {
                sb.append(" ");
            }

        }
        sb.append(words[endIndex]);
        return sb.toString();
    }


}

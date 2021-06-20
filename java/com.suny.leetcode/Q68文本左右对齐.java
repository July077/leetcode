import java.util.LinkedList;
import java.util.List;

/**
 * 68. 文本左右对齐
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * <p>
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * <p>
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * <p>
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * <p>
 * 说明:
 * <p>
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 *
 * @author sunjianrong
 * @date 2021/6/20 下午10:23
 */
public class Q68文本左右对齐 {


    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<>();
        int length = words.length;

        StringBuilder sb = new StringBuilder();
        String[] spaces = new String[maxWidth];
        for (int i = 0; i < maxWidth; i++) {
            spaces[i] = sb.toString();
            sb.append(" ");
        }

        // 当前长度
        int currentLen = 0;
        List<String> currentLineWords = new LinkedList<>();
        for (String currentWord : words) {
            // 当前单词和一个空格的长度  因为少了一个空格
            int currentWordWithSingleSpaceLength = currentWord.length() + 1;

            // 这里-1 因为最后一个单词不需要空格
            if (currentWordWithSingleSpaceLength + currentLen - 1 > maxWidth) {
                // 处理当前行的单词
                processCurrentLine(res, currentLineWords, spaces, maxWidth);
                // 清空到下一行
                currentLineWords.clear();
                currentLen = 0;

            }

            // 累加单词长度
            currentLen += currentWordWithSingleSpaceLength;
            currentLineWords.add(currentWord);

        }

        processCurrentLine(res, currentLineWords, spaces, maxWidth);
        // 处理最后一行
        String ss = res.get(res.size() - 1);
        res.remove(res.size() - 1);


        ss = ss.replaceAll("\\s+", " ");
        // 对齐
        res.add(ss + spaces[maxWidth - ss.length()]);
        return res;

    }

    public void processCurrentLine(List<String> ans, List<String> currentLineWords, String[] spaces, int maxWidth) {
        if (currentLineWords.size() == 1) {
            String word = currentLineWords.get(0);
            ans.add(word + spaces[maxWidth - word.length()]);
        } else {
            int wordsLength = 0;
            for (String currentLineWord : currentLineWords) {
                wordsLength += currentLineWord.length();
            }

            int spaceNumber = maxWidth - wordsLength;
            int gap = (spaceNumber) / (currentLineWords.size() - 1);
            String[] spaceWords = new String[currentLineWords.size() - 1];

            // 多余的空格
            int left = spaceNumber - (gap * (currentLineWords.size() - 1));
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < currentLineWords.size(); i++) {
                String word = currentLineWords.get(i);
                if (i == currentLineWords.size() - 1) {
                    // 最后一行不需要空格
                    sb.append(word);
                } else {
                    sb.append(word).append(i < left ? spaces[gap + 1] : spaces[gap]);
                }
            }
            ans.add(sb.toString());
        }
    }
}

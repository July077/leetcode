import java.util.Arrays;

public class Q1996游戏中弱角色的数量 {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int ans = 0;
        int max = 0;
        for (int i = properties.length - 1; i >= 0; i--) {
            if (properties[i][1] < max) {
                ans++;
            } else {
                max = properties[i][1];
            }
        }

        return ans;
    }
}

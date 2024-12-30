import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution514 {
    public static final int INF = Integer.MAX_VALUE / 2;

    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();

        Map<Character, List<Integer>> idxListMap = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            idxListMap.computeIfAbsent(ring.charAt(i), ele -> new ArrayList<>()).add(i);
        }

        // f[i][j] 表示从前往后拼写出  key 的第 i 个字符，ring 的第 j 个字符与 12:00 方向对齐的最少步数
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(f[i], INF);
        }
        for (int i : idxListMap.getOrDefault(key.charAt(0), new ArrayList<>())) {
            f[0][i] = Math.min(i, n - i) + 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j : idxListMap.getOrDefault(key.charAt(i), new ArrayList<>())) {
                for (int k : idxListMap.getOrDefault(key.charAt(i - 1), new ArrayList<>())) {
                    f[i][j] = Math.min(f[i][j],
                            f[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1);
                }
            }
        }
        return Arrays.stream(f[m - 1]).min().orElseThrow();
    }
}
/*
514. 自由之路
https://leetcode.cn/problems/freedom-trail/

电子游戏“辐射4”中，任务 “通向自由” 要求玩家到达名为 “Freedom Trail Ring” 的金属表盘，并使用表盘拼写特定关键词才能开门。
给定一个字符串 ring ，表示刻在外环上的编码；给定另一个字符串 key ，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
最初，ring 的第一个字符与 12:00 方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
旋转 ring 拼出 key 字符 key[i] 的阶段中：
1.您可以将 ring 顺时针或逆时针旋转 一个位置 ，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
2.如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。
提示：
1 <= ring.length, key.length <= 100
ring 和 key 只包含小写英文字母
保证 字符串 key 一定可以由字符串  ring 旋转拼出

动态规划
时间复杂度 O(m·n^2)
空间复杂度 O(m·n)
 */
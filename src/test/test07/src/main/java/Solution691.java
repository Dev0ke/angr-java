import java.util.Arrays;

public class Solution691 {
    private String[] stickers;
    private String target;
    private int[] memo;

    // 时间复杂度 O((C+m)*n*2^m) 其中 n = stickers.length, C = |stickers[i]|
    public int minStickers(String[] stickers, String target) {
        this.stickers = stickers;
        this.target = target;
        int m = target.length();
        memo = new int[1 << m];
        Arrays.fill(memo, -1);
        // 如果 mask 为空集，则贴纸数为 0
        memo[0] = 0;
        int res = dp((1 << m) - 1);
        return res <= m ? res : -1;
    }

    private int dp(int mask) {
        int m = target.length();
        if (memo[mask] != -1) {
            return memo[mask];
        }

        int min = m + 1;
        for (String sticker : stickers) {
            // 未被覆盖的其他字符
            int left = mask;
            int[] cntArr = new int[26];
            for (char ch : sticker.toCharArray()) {
                cntArr[ch - 'a']++;
            }
            for (int k = 0; k < m; k++) {
                char ch = target.charAt(k);
                if (((mask >> k) & 1) == 1 && cntArr[ch - 'a'] > 0) {
                    cntArr[ch - 'a']--;
                    left = left ^ (1 << k);
                }
            }
            if (left < mask) {
                min = Math.min(min, dp(left) + 1);
            }
        }
        memo[mask] = min;
        return min;
    }
}
/*
691. 贴纸拼词
https://leetcode.cn/problems/stickers-to-spell-word/

我们有 n 种不同的贴纸。每个贴纸上都有一个小写的英文单词。
您想要拼写出给定的字符串 target ，方法是从收集的贴纸中切割单个字母并重新排列它们。如果你愿意，你可以多次使用每个贴纸，每个贴纸的数量是无限的。
返回你需要拼出 target 的最小贴纸数量。如果任务不可能，则返回 -1 。
注意：在所有的测试用例中，所有的单词都是从 1000 个最常见的美国英语单词中随机选择的，并且 target 被选择为两个随机单词的连接。
提示:
n == stickers.length
1 <= n <= 50
1 <= stickers[i].length <= 10
1 <= target.length <= 15
stickers[i] 和 target 由小写英文单词组成

直接状态压缩枚举时间复杂度 O(2^n)
状态压缩动态规划
记忆化搜索
相似题目: 1125. 最小的必要团队
https://leetcode.cn/problems/smallest-sufficient-team/
 */
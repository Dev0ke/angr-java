import java.util.Arrays;

public class Solution2430 {
    public int deleteString(String s) {
        int n = s.length();

        // f[i] 表示删除 [i,n-1] 所需的最大操作数，则结果为 f[0]
        // [i,i+j), [i+j,i+2j)
        int[] f = new int[n];
        // 初始状态
        Arrays.fill(f, 1);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; i + j * 2 <= n; j++) {
                // 状态转移 剪枝
                if (f[i + j] + 1 > f[i] && s.substring(i, i + j).equals(s.substring(i + j, i + j * 2))) {
                    f[i] = f[i + j] + 1;
                }
            }
        }
        return f[0];
    }
}
/*
2430. 对字母串可执行的最大删除数
https://leetcode.cn/problems/maximum-deletions-on-a-string/

第 313 场周赛 T4。

给你一个仅由小写英文字母组成的字符串 s 。在一步操作中，你可以：
- 删除 整个字符串 s ，或者
- 对于满足 1 <= i <= s.length / 2 的任意 i ，如果 s 中的 前 i 个字母和接下来的 i 个字母 相等 ，删除 前 i 个字母。
例如，如果 s = "ababc" ，那么在一步操作中，你可以删除 s 的前两个字母得到 "abc" ，因为 s 的前两个字母和接下来的两个字母都等于 "ab" 。
返回删除 s 所需的最大操作数。
提示：
1 <= s.length <= 4000
s 仅由小写英文字母组成

动态规划。
时间复杂度 O(n^3) 理论上界 4000*2000*2000
https://github.com/LeetCode-Feedback/LeetCode-Feedback/issues?q=is%3Aissue+is%3Aopen+in%3Atitle+2430
 */
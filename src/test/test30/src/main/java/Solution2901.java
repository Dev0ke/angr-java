import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution2901 {
    // 序列 DP
    // 1、子序列 + 不考虑相邻元素：选或不选。代表：0-1 背包
    // 2、子序列 + 考虑相邻元素：枚举选哪个。代表：LIS
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] f = new int[n];
        // 记录转移来源
        int[] from = new int[n];
        Arrays.fill(from, -1);

        int maxI = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (f[i] < f[j] && groups[j] != groups[i] && hammingEq1(words[j], words[i])) {
                    f[i] = f[j];
                    from[i] = j;
                }
            }
            // 加一写在这里
            f[i]++;
            if (f[i] > f[maxI]) {
                maxI = i;
            }
        }

        List<String> ans = new ArrayList<>();
        while (maxI != -1) {
            ans.add(words[maxI]);
            maxI = from[maxI];
        }
        Collections.reverse(ans);
        return ans;
    }

    private boolean hammingEq1(String x, String y) {
        if (x.length() != y.length()) {
            return false;
        }
        int cnt = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) != y.charAt(i)) {
                cnt++;
                if (cnt > 1) return false;
            }
        }
        return cnt == 1;
    }
}
/*
2901. 最长相邻不相等子序列 II
https://leetcode.cn/problems/longest-unequal-adjacent-groups-subsequence-ii/description/

第 115 场双周赛 T3。

给你一个整数 n 和一个下标从 0 开始的字符串数组 words ，和一个下标从 0 开始的数组 groups ，两个数组长度都是 n 。
两个长度相等字符串的 汉明距离 定义为对应位置字符 不同 的数目。
你需要从下标 [0, 1, ..., n - 1] 中选出一个 最长子序列 ，将这个子序列记作长度为 k 的 [i0, i1, ..., ik - 1] ，它需要满足以下条件：
- 相邻 下标对应的 groups 值 不同。即，对于所有满足 0 < j + 1 < k 的 j 都有 groups[ij] != groups[ij + 1] 。
- 对于所有 0 < j + 1 < k 的下标 j ，都满足 words[ij] 和 words[ij + 1] 的长度 相等 ，且两个字符串之间的 汉明距离 为 1 。
请你返回一个字符串数组，它是下标子序列 依次 对应 words 数组中的字符串连接形成的字符串数组。如果有多个答案，返回任意一个。
子序列 指的是从原数组中删掉一些（也可能一个也不删掉）元素，剩余元素不改变相对位置得到的新的数组。
注意：words 中的字符串长度可能 不相等 。
提示：
1 <= n == words.length == groups.length <= 1000
1 <= words[i].length <= 10
1 <= groups[i] <= n
words 中的字符串 互不相同 。
words[i] 只包含小写英文字母。

序列 DP 记录转移来源
时间复杂度 O(n^2)
空间复杂度 O(n)
相似题目: 368. 最大整除子集
https://leetcode.cn/problems/largest-divisible-subset/
 */
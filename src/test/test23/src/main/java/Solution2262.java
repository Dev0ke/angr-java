import java.util.Arrays;

public class Solution2262 {
    public long appealSum(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();

        // 字符最后一次出现的下标
        int[] lastIdx = new int[26];
        Arrays.fill(lastIdx, -1);

        long cnt = 0;
        long lastSum = 0;
        // 滑动窗口
        for (int i = 0; i < len; i++) {
            // 与跟前一个相同字符的间隔
            long diff = i - lastIdx[chars[i] - 'a'];
            lastIdx[chars[i] - 'a'] = i;
            lastSum += diff;
            cnt += lastSum;
        }
        return cnt;
    }
}
/*
2262. 字符串的总引力
https://leetcode.cn/problems/total-appeal-of-a-string/

第 291 场周赛 T4。

字符串的 引力 定义为：字符串中 不同 字符的数量。
- 例如，"abbca" 的引力为 3 ，因为其中有 3 个不同字符 'a'、'b' 和 'c' 。
给你一个字符串 s ，返回 其所有子字符串的总引力 。
子字符串 定义为：字符串中的一个连续字符序列。
提示：
1 <= s.length <= 10^5
s 由小写英文字母组成

数据范围 s.length <= 10^5，两层 for 循环显然会 TLE。
对于这种题型和数据范围，可以 AC 的时间复杂度一般为 O(nlogn) 或 O(n)，尝试先按字典序来个排序，发现总引力会变化，说明总引力跟顺序有关，排除排序的方向。
考虑是否存在 O(n) 的解法。单独观察每个字符对总引力的贡献。发现跟前一个相同字符的位置有关。
时间复杂度: O(n)
相似题目: 828. 统计子串中的唯一字符
https://leetcode.cn/problems/count-unique-characters-of-all-substrings-of-a-given-string/
 */
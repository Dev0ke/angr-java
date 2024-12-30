public class Solution2315 {
    public int countAsterisks(String s) {
        int pair = 0;
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '|') {
                pair++;
            }
            if (ch == '*' && pair % 2 == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
/*
2315. 统计星号
https://leetcode.cn/problems/count-asterisks/

第 81 场双周赛 T1。

给你一个字符串 s ，每 两个 连续竖线 '|' 为 一对 。换言之，第一个和第二个 '|' 为一对，第三个和第四个 '|' 为一对，以此类推。
请你返回 不在 竖线对之间，s 中 '*' 的数目。
注意，每个竖线 '|' 都会 恰好 属于一个对。
提示：
1 <= s.length <= 1000
s 只包含小写英文字母，竖线 '|' 和星号 '*' 。
s 包含 偶数 个竖线 '|' 。

模拟。
时间复杂度 O(n)
 */
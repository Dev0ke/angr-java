public class Solution3168 {
    public int minimumChairs(String s) {
        int ans = 0, sum = 0;
        for (char c : s.toCharArray()) {
            if (c == 'E') sum++;
            else sum--;
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
/*
3168. 候诊室中的最少椅子数
https://leetcode.cn/problems/minimum-number-of-chairs-in-a-waiting-room/description/

第 400 场周赛 T1。

给你一个字符串 s，模拟每秒钟的事件 i：
- 如果 s[i] == 'E'，表示有一位顾客进入候诊室并占用一把椅子。
- 如果 s[i] == 'L'，表示有一位顾客离开候诊室，从而释放一把椅子。
返回保证每位进入候诊室的顾客都能有椅子坐的 最少 椅子数，假设候诊室最初是 空的 。
提示：
1 <= s.length <= 50
s 仅由字母 'E' 和 'L' 组成。
s 表示一个有效的进出序列。

遍历，将 E 看成 1，将 L 看成 -1，和取最大值即可。
时间复杂度 O(n)。
 */
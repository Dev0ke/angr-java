public class Solution481 {
    // https://leetcode.cn/problems/magical-string/solutions/1938214/by-endlesscheng-z8o1
    public int magicalString(int n) {
        int[] s = new int[n + 2];
        s[0] = 1;
        s[1] = s[2] = 2;
        int c = 2;
        for (int i = 2, j = 3; j < n; i++) {
            c ^= 3; // 在 1 和 2 之间切换
            s[j++] = c;
            if (s[i] == 2) {
                s[j++] = c;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += s[i] == 1 ? 1 : 0;
        }
        return ans;
    }
}
/*
481. 神奇字符串
https://leetcode.cn/problems/magical-string/description/

神奇字符串 s 仅由 '1' 和 '2' 组成，并需要遵守下面的规则：
- 神奇字符串 s 的神奇之处在于，串联字符串中 '1' 和 '2' 的连续出现次数可以生成该字符串。
s 的前几个元素是 s = "1221121221221121122……" 。如果将 s 中连续的若干 1 和 2 进行分组，可以得到 "1 22 11 2 1 22 1 22 11 2 11 22 ......" 。每组中 1 或者 2 的出现次数分别是 "1 2 2 1 1 2 1 2 2 1 2 2 ......" 。上面的出现次数正是 s 自身。
给你一个整数 n ，返回在神奇字符串 s 的前 n 个数字中 1 的数目。
提示：
1 <= n <= 10^5

模拟 构造。
时间复杂度 O(n)
 */
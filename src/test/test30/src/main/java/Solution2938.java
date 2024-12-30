public class Solution2938 {
    public long minimumSteps(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int r = lastIndexOf(cs, '0', n - 1);
        int l = lastIndexOf(cs, '1', r - 1);
        long ans = 0;
        while (r >= 0 && l >= 0) {
            ans += r - l;
            cs[r] = '1';
            cs[l] = '0';
            r = lastIndexOf(cs, '0', r - 1);
            l = lastIndexOf(cs, '1', l - 1);
        }
        return ans;
    }

    private int lastIndexOf(char[] cs, int ch, int fromIndex) {
        for (int i = fromIndex; i >= 0; i--) {
            if (cs[i] == ch) return i;
        }
        return -1;
    }

    // 累加每个 0 左边的 1 的个数
    public long minimumSteps2(String s) {
        long ans = 0, cnt1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') cnt1++;
            else ans += cnt1;
        }
        return ans;
    }
}
/*
2938. 区分黑球与白球
https://leetcode.cn/problems/separate-black-and-white-balls/description/

第 372 场周赛 T2。

桌子上有 n 个球，每个球的颜色不是黑色，就是白色。
给你一个长度为 n 、下标从 0 开始的二进制字符串 s，其中 1 和 0 分别代表黑色和白色的球。
在每一步中，你可以选择两个相邻的球并交换它们。
返回「将所有黑色球都移到右侧，所有白色球都移到左侧所需的 最小步数」。
提示：
1 <= n == s.length <= 10^5
s[i] 不是 '0'，就是 '1'。

双指针 / 脑筋急转弯。
累加每个 0 左边的 1 的个数。
 */
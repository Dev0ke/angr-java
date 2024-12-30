public class Solution2396 {
    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n - 2; i++) {
            if (!isPal(Integer.toString(n, i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isPal(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isStrictlyPalindromic2(int n) {
        return false;
    }
}
/*
2396. 严格回文的数字
https://leetcode.cn/problems/strictly-palindromic-number/

第 86 场双周赛 T2。

如果一个整数 n 在 b 进制下（b 为 2 到 n - 2 之间的所有整数）对应的字符串 全部 都是 回文的 ，那么我们称这个数 n 是 严格回文 的。
给你一个整数 n ，如果 n 是 严格回文 的，请返回 true ，否则返回 false 。
如果一个字符串从前往后读和从后往前读完全相同，那么这个字符串是 回文的 。
提示：
4 <= n <= 10^5

脑筋急转弯。
当 n > 4 时，n-2 进制均为 12，不是回文的；
当 n = 4 时，2 进制为 100，不是回文的；
时间复杂度 O(1)
相似题目: 877. 石子游戏
https://leetcode.cn/problems/stone-game/
 */
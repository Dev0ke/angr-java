public class Solution87 {
    // -1 表示 false, 1 表示 true, 0 表示 未计算
    private int[][][] memo;
    private String s1;
    private String s2;

    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        this.memo = new int[len][len][len + 1];
        this.s1 = s1;
        this.s2 = s2;
        return dfs(0, 0, len);
    }

    // 第一个字符串从 i1 开始，第二个字符串从 i2 开始，子串长度为 len，是否和谐
    private boolean dfs(int i1, int i2, int len) {
        if (memo[i1][i2][len] != 0) {
            return memo[i1][i2][len] == 1;
        }

        // 子串是否相等
        if (s1.substring(i1, i1 + len).equals(s2.substring(i2, i2 + len))) {
            memo[i1][i2][len] = 1;
            return true;
        }

        // 子串是否相似
        if (!isSimilar(i1, i2, len)) {
            memo[i1][i2][len] = -1;
            return false;
        }

        // 枚举分割位置
        for (int i = 1; i < len; i++) {
            // 不交换
            if (dfs(i1, i2, i) && dfs(i1 + i, i2 + i, len - i)) {
                memo[i1][i2][len] = 1;
                return true;
            }
            // 交换
            if (dfs(i1, i2 + len - i, i) && dfs(i1 + i, i2, len - i)) {
                memo[i1][i2][len] = 1;
                return true;
            }
        }

        memo[i1][i2][len] = -1;
        return false;
    }

    // 是否相似
    private boolean isSimilar(int i1, int i2, int len) {
        char[] cntArr1 = new char[26];
        char[] cntArr2 = new char[26];
        for (int i = i1; i < i1 + len; i++) {
            cntArr1[s1.charAt(i) - 'a']++;
        }
        for (int i = i2; i < i2 + len; i++) {
            cntArr2[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cntArr1[i] != cntArr2[i]) {
                return false;
            }
        }
        return true;
    }
}
/*
87. 扰乱字符串
https://leetcode.cn/problems/scramble-string/

使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
1.如果字符串的长度为 1 ，算法停止
2.如果字符串的长度 > 1 ，执行下述步骤：
 - 在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
 - 随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
 - 在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
给你两个 长度相等 的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。如果是，返回 true ；否则，返回 false 。
提示：
s1.length == s2.length
1 <= s1.length <= 30
s1 和 s2 由小写英文字母组成

动态规划
时间复杂度 O(n^4)
空间复杂度 O(n^3)
 */
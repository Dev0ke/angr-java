public class Solution854 {
    private char[] str1, str2;
    private int ans = 0;

    public int kSimilarity(String s1, String s2) {
        int n = s1.length();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                sb1.append(s1.charAt(i));
                sb2.append(s2.charAt(i));
            }
        }
        str1 = sb1.toString().toCharArray();
        str2 = sb2.toString().toCharArray();
        if (str1.length == 0) return 0;

        ans = s1.length() - 1;
        dfs(0, 0);
        return ans;
    }

    private void dfs(int pos, int cost) {
        if (cost > ans) return;
        while (pos < str1.length && str1[pos] == str2[pos]) {
            pos++;
        }
        if (pos == str1.length) {
            ans = cost;
            return;
        }
        // 当前状态的交换次数下限大于等于当前的最小交换次数
        if (cost + minSwap(pos) >= ans) return;
        for (int i = pos + 1; i < str1.length; i++) {
            if (str1[i] == str2[pos]) {
                swap(i, pos);
                dfs(pos + 1, cost + 1);
                swap(i, pos);
            }
        }
    }

    private int minSwap(int pos) {
        int res = 0;
        for (int i = pos; i < str1.length; i++) {
            if (str1[i] != str2[i]) res++;
        }
        return (res + 1) / 2;
    }

    private void swap(int i, int j) {
        char tmp = str1[i];
        str1[i] = str1[j];
        str1[j] = tmp;
    }
}
/*
854. 相似度为 K 的字符串
https://leetcode.cn/problems/k-similar-strings/description/

对于某些非负整数 k ，如果交换 s1 中两个字母的位置恰好 k 次，能够使结果字符串等于 s2 ，则认为字符串 s1 和 s2 的 相似度为 k 。
给你两个字母异位词 s1 和 s2 ，返回 s1 和 s2 的相似度 k 的最小值。
提示：
1 <= s1.length <= 20
s2.length == s1.length
s1 和 s2  只包含集合 {'a', 'b', 'c', 'd', 'e', 'f'} 中的小写字母
s2 是 s1 的一个字母异位词

DFS。（DFS 比 动态规划 解法要快，剪枝的力量）
时间复杂度 O(能过)。
官方题解：https://leetcode.cn/problems/k-similar-strings/solutions/1836897/xiang-si-du-wei-k-de-zi-fu-chuan-by-leet-8z10/
该方法时空复杂度分析较为复杂，暂不讨论。
 */
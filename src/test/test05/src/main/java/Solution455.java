import java.util.Arrays;

public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        // 贪心 胃口值 g[i] 饼干尺寸 s[j]
        Arrays.sort(g);
        Arrays.sort(s);
        // 双指针
        int p = g.length - 1;
        int q = s.length - 1;
        int res = 0;
        while (p >= 0 && q >= 0) {
            if (s[q] >= g[p]) {
                q--;
                res++;
            }
            p--;
        }
        return res;
    }
}
/*
455. 分发饼干
https://leetcode.cn/problems/assign-cookies/

假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。
如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
提示：
1 <= g.length <= 3 * 10^4
0 <= s.length <= 3 * 10^4
1 <= g[i], s[j] <= 2^31 - 1

贪心。排序后双指针。
 */
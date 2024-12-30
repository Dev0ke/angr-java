import java.util.ArrayList;
import java.util.List;

public class Solution3333 {
    private static final int MOD = (int) (1e9 + 7);

    public int possibleStringCount(String word, int k) {
        int n = word.length();
        if (n < k) { // 无法满足要求
            return 0;
        }

        List<Integer> cnts = new ArrayList<>();
        long ans = 1;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt++;
            if (i == n - 1 || word.charAt(i) != word.charAt(i + 1)) {
                // 如果 cnt = 1，这组字符串必选，无需参与计算
                if (cnt > 1) {
                    if (k > 0) {
                        cnts.add(cnt - 1);
                    }
                    ans = ans * cnt % MOD;
                }
                k--; // 注意这里把 k 减小了
                cnt = 0;
            }
        }

        if (k <= 0) {
            return (int) ans;
        }

        int m = cnts.size();
        int[][] f = new int[m + 1][k];
        f[0][0] = 1;
        int[] s = new int[k + 1];
        for (int i = 0; i < m; i++) {
            // 计算 f[i] 的前缀和数组 s
            for (int j = 0; j < k; j++) {
                s[j + 1] = (s[j] + f[i][j]) % MOD;
            }
            int c = cnts.get(i);
            // 计算子数组和
            for (int j = 0; j < k; j++) {
                f[i + 1][j] = (s[j + 1] - s[Math.max(j - c, 0)]) % MOD;
            }
        }

        for (int x : f[m]) {
            ans -= x;
        }
        return (int) ((ans % MOD + MOD) % MOD); // 保证结果非负
    }
}
/*
3333. 找到初始输入字符串 II
https://leetcode.cn/problems/find-the-original-typed-string-ii/description/

第 142 场双周赛 T4。

Alice 正在她的电脑上输入一个字符串。但是她打字技术比较笨拙，她 可能 在一个按键上按太久，导致一个字符被输入 多次 。
给你一个字符串 word ，它表示 最终 显示在 Alice 显示屏上的结果。同时给你一个 正 整数 k ，表示一开始 Alice 输入字符串的长度 至少 为 k 。
请你返回 Alice 一开始可能想要输入字符串的总方案数。
由于答案可能很大，请你将它对 10^9 + 7 取余 后返回。
提示：
1 <= word.length <= 5 * 10^5
word 只包含小写英文字母。
1 <= k <= 2000

正难则反+多重背包+前缀和优化
https://leetcode.cn/problems/find-the-original-typed-string-ii/solutions/2966856/zheng-nan-ze-fan-qian-zhui-he-you-hua-dp-5mi9/
时间复杂度 O(n + k^2)。
rating 2634 (clist.by)
 */
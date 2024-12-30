import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1655 {
    public boolean canDistribute(int[] nums, int[] quantity) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int x : nums) {
            cntMap.put(x, cntMap.getOrDefault(x, 0) + 1);
        }
        List<Integer> cntList = new ArrayList<>(cntMap.values());

        int n = cntList.size();
        int m = quantity.length;
        int[] sum = new int[1 << m];
        for (int i = 1; i < (1 << m); i++) {
            for (int j = 0; j < m; j++) {
                if ((i & (1 << j)) != 0) {
                    int left = i - (1 << j);
                    sum[i] = sum[left] + quantity[j];
                    break;
                }
            }
        }

        boolean[][] dp = new boolean[n][1 << m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (1 << m); j++) {
                if (i > 0 && dp[i - 1][j]) {
                    dp[i][j] = true;
                    continue;
                }
                // 子集枚举，详见 https://oi-wiki.org/math/bit/#_14
                for (int s = j; s != 0; s = ((s - 1) & j)) {
                    // 前 i-1 个元素需要满足子集 prev = j-s
                    int prev = j - s;
                    // cnt[0..i-1] 能否满足子集 prev
                    boolean last = (i == 0) ? (prev == 0) : dp[i - 1][prev];
                    // cnt[i] 能否满足子集 s
                    boolean need = sum[s] <= cntList.get(i);
                    if (last && need) {
                        dp[i][j] = true;
                        break;
                    }
                }
            }
        }
        return dp[n - 1][(1 << m) - 1];
    }
}
/*
1655. 分配重复整数
https://leetcode.cn/problems/distribute-repeating-integers/

给你一个长度为 n 的整数数组 nums ，这个数组中至多有 50 个不同的值。同时你有 m 个顾客的订单 quantity ，其中，整数 quantity[i] 是第 i 位顾客订单的数目。请你判断是否能将 nums 中的整数分配给这些顾客，且满足：
- 第 i 位顾客 恰好 有 quantity[i] 个整数。
- 第 i 位顾客拿到的整数都是 相同的 。
- 每位顾客都满足上述两个要求。
如果你可以分配 nums 中的整数满足上面的要求，那么请返回 true ，否则返回 false 。
提示：
n == nums.length
1 <= n <= 10^5
1 <= nums[i] <= 1000
m == quantity.length
1 <= m <= 10
1 <= quantity[i] <= 10^5
nums 中至多有 50 个不同的数字。

状压 DP
https://leetcode.cn/problems/distribute-repeating-integers/solution/zi-ji-mei-ju-jing-dian-tao-lu-zhuang-ya-dp-by-arse/
时间复杂度 O(n*3^m)
空间复杂度 O(n*2^m)
 */
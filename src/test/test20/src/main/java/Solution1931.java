import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1931 {
    private static final int MOD = (int) (1e9 + 7);

    public int colorTheGrid(int m, int n) {
        Map<Integer, int[]> validMap = new HashMap<>();

        // 三进制 bitmask
        // 哈希映射 valid 存储所有满足要求的对一行进行涂色的方案
        // 键表示 mask，值表示 mask 的三进制串（以数组的形式存储）
        int maskMax = (int) Math.pow(3, m);
        for (int mask = 0; mask < maskMax; mask++) {
            int[] color = new int[m];
            int mm = mask;
            for (int i = 0; i < m; ++i) {
                color[i] = mm % 3;
                mm /= 3;
            }
            boolean check = true;
            for (int i = 1; i < m; i++) {
                if (color[i - 1] == color[i]) {
                    check = false;
                    break;
                }
            }
            if (check) {
                validMap.put(mask, color);
            }
        }

        // 预处理所有的 (mask1, mask2) 二元组，满足 mask1 和 mask2 作为相邻行时，同一列上两个格子的颜色不同
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (Map.Entry<Integer, int[]> entry1 : validMap.entrySet()) {
            int mask1 = entry1.getKey();
            int[] color1 = entry1.getValue();
            for (Map.Entry<Integer, int[]> entry2 : validMap.entrySet()) {
                int mask2 = entry2.getKey();
                int[] color2 = entry2.getValue();

                boolean check = true;
                for (int i = 0; i < m; i++) {
                    if (color1[i] == color2[i]) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    adj.computeIfAbsent(mask1, key -> new ArrayList<>()).add(mask2);
                }
            }
        }

        // 我们用 f[i][mask] 表示我们已经对 0,1,⋯,i 行进行了涂色，并且第 i 行的涂色方案对应的三进制表示为 mask 的前提下的总方案数
        int[] f = new int[maskMax];
        for (int mask : validMap.keySet()) {
            f[mask] = 1;
        }
        for (int i = 1; i < n; i++) {
            int[] g = new int[maskMax];
            for (int mask2 : validMap.keySet()) {
                for (int mask1 : adj.getOrDefault(mask2, new ArrayList<>())) {
                    g[mask2] = (g[mask2] + f[mask1]) % MOD;
                }
            }
            f = g;
        }

        int res = 0;
        for (int x : f) {
            res = (res + x) % MOD;
        }
        return res;
    }
}
/*
1931. 用三种不同颜色为网格涂色
https://leetcode.cn/problems/painting-a-grid-with-three-different-colors/

第 249 场周赛 T3。

给你两个整数 m 和 n 。构造一个 m x n 的网格，其中每个单元格最开始是白色。请你用 红、绿、蓝 三种颜色为每个单元格涂色。所有单元格都需要被涂色。
涂色方案需要满足：不存在相邻两个单元格颜色相同的情况 。返回网格涂色的方法数。因为答案可能非常大， 返回 对 10^9 + 7 取余 的结果。
提示：
1 <= m <= 5
1 <= n <= 1000

状态压缩动态规划
时间复杂度 O(3^2m * n)
- 预处理 mask 的时间复杂度 O(m·3^m)
- 预处理 (mask, mask') 二元组的时间复杂度 O(3^2m)
- 动态规划的时间复杂度 O(3^2m * n)
空间复杂度 O(3^2m)
- 存储 mask 的哈希映射需要的空间为 O(m·3^m)
- 存储 (mask, mask') 二元组需要的空间为 O(3^2m)
- 动态规划存储状态需要的空间为 O(3^m)
相似题目: 1411. 给 N x 3 网格图涂色的方案数
https://leetcode.cn/problems/number-of-ways-to-paint-n-3-grid/
 */
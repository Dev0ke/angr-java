import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2857 {
    public int countPairs(List<List<Integer>> coordinates, int k) {
        int ans = 0;
        Map<Long, Integer> map = new HashMap<>();
        for (List<Integer> p : coordinates) {
            int x1 = p.get(0), y1 = p.get(1);
            for (int xor_x = 0; xor_x <= k; xor_x++) {
                int xor_y = k - xor_x;
                int x2 = xor_x ^ x1;
                int y2 = xor_y ^ y1;
                long key2 = (long) x2 << 32 | y2;
                ans += map.getOrDefault(key2, 0);
            }
            long key1 = (long) x1 << 32 | y1;
            map.put(key1, map.getOrDefault(key1, 0) + 1);
        }
        return ans;
    }
}
/*
2857. 统计距离为 k 的点对
https://leetcode.cn/problems/count-pairs-of-points-with-distance-k/

第 113 场双周赛 T3。

给你一个 二维 整数数组 coordinates 和一个整数 k ，其中 coordinates[i] = [xi, yi] 是第 i 个点在二维平面里的坐标。
我们定义两个点 (x1, y1) 和 (x2, y2) 的 距离 为 (x1 XOR x2) + (y1 XOR y2) ，XOR 指的是按位异或运算。
请你返回满足 i < j 且点 i 和点 j之间距离为 k 的点对数目。
提示：
2 <= coordinates.length <= 50000
0 <= xi, yi <= 10^6
0 <= k <= 100

枚举 + 哈希表。
k 范围只有 100，按两数之和的思路来枚举即可。
时间复杂度 O(nk)
 */
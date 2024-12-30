import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3209 {
    public long countSubarrays(int[] nums, int K) {
        int n = nums.length;
        Map<Integer, Long> cnt = new HashMap<>();
        // v,l,r
        List<int[]> b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            for (int[] p : b) {
                p[0] &= x;
            }
            b.add(new int[]{x, i, i + 1});
            int k = 0;
            for (int j = 1; j < b.size(); j++) {
                int[] q = b.get(j);
                if (b.get(k)[0] == q[0]) {
                    b.get(k)[2] = q[2];
                } else {
                    k++;
                    b.set(k, q);
                }
            }
            // b = b[:k+1]
            b.subList(k + 1, b.size()).clear();
            for (int[] p : b) {
                cnt.put(p[0], cnt.getOrDefault(p[0], 0L) + p[2] - p[1]);
            }
        }

        return cnt.getOrDefault(K, 0L);
    }
}
/*
3209. 子数组按位与值为 K 的数目
https://leetcode.cn/problems/number-of-subarrays-with-and-value-of-k/description/

第 134 场双周赛 T4。

给你一个整数数组 nums 和一个整数 k ，请你返回 nums 中有多少个 子数组 满足：子数组中所有元素按位 AND 的结果为 k 。
提示：
1 <= nums.length <= 10^5
0 <= nums[i], k <= 10^9

logTrick
时间复杂度 O(nlogU)。
相似题目: D. CGCDSSQ
https://codeforces.com/contest/475/problem/D
3097. 或值至少为 K 的最短子数组 II
https://leetcode.cn/problems/shortest-subarray-with-or-at-least-k-ii/description/
3171. 找到按位与最接近 K 的子数组
https://leetcode.cn/problems/find-subarray-with-bitwise-and-closest-to-k/description/
 */
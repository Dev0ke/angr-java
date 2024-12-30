import java.util.ArrayList;
import java.util.List;

public class Solution3097 {
    public int minimumSubarrayLength(int[] nums, int L) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        // 存 tuple: 按位或的值 + 对应子数组左端点的最大值
        List<int[]> ors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            ors.add(new int[]{0, i});
            int k = 0;
            for (int[] p : ors) {
                // 都或上 num
                p[0] |= num;
                if (p[0] >= L) {
                    ans = Math.min(ans, i - p[1] + 1);
                }
                // 去重/合并 取最小下标
                if (ors.get(k)[0] == p[0]) {
                    ors.get(k)[1] = p[1];
                } else {
                    k++;
                    ors.set(k, p);
                }
            }
            // del ors[k+1:]
            ors.subList(k + 1, ors.size()).clear();
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
/*
3097. 或值至少为 K 的最短子数组 II
https://leetcode.cn/problems/shortest-subarray-with-or-at-least-k-ii/description/

第 127 场双周赛 T3。

给你一个 非负 整数数组 nums 和一个整数 k 。
如果一个数组中所有元素的按位或运算 OR 的值 至少 为 k ，那么我们称这个数组是 特别的 。
请你返回 nums 中 最短特别非空 子数组 的长度，如果特别子数组不存在，那么返回 -1 。
提示：
1 <= nums.length <= 2 * 10^5
0 <= nums[i] <= 10^9
0 <= k <= 10^9

子数组 OR/AND/GCD 通用模板
内层多加一个 if 即可。
时间复杂度 O(nlogU)
相似题目: 2411. 按位或最大的最小子数组长度
https://leetcode.cn/problems/smallest-subarrays-with-maximum-bitwise-or/
 */
import java.util.ArrayList;
import java.util.List;

public class Solution2411 {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        // 存 tuple: 按位或的值 + 对应子数组右端点的最小值
        List<int[]> ors = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            ors.add(new int[]{0, i});
            int k = 0;
            for (int[] p : ors) {
                // 都或上 num
                p[0] |= num;
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
            ans[i] = ors.get(0)[1] - i + 1;
        }
        return ans;
    }
}
/*
2411. 按位或最大的最小子数组长度
https://leetcode.cn/problems/smallest-subarrays-with-maximum-bitwise-or/

第 87 场双周赛 T3。

给你一个长度为 n 下标从 0 开始的数组 nums ，数组中所有数字均为非负整数。对于 0 到 n - 1 之间的每一个下标 i ，
你需要找出 nums 中一个 最小 非空子数组，它的起始位置为 i （包含这个位置），同时有 最大 的 按位或运算值 。
- 换言之，令 Bij 表示子数组 nums[i...j] 的按位或运算的结果，你需要找到一个起始位置为 i 的最小子数组，这个子数组的按位或运算的结果等于 max(Bik) ，其中 i <= k <= n - 1 。
一个数组的按位或运算值是这个数组里所有数字按位或运算的结果。
请你返回一个大小为 n 的整数数组 answer，其中 answer[i]是开始位置为 i ，按位或运算结果最大，且 最短 子数组的长度。
子数组 是数组里一段连续非空元素组成的序列。
提示：
n == nums.length
1 <= n <= 10^5
0 <= nums[i] <= 10^9

难点在于需要在时间复杂度 `O(1)` 内知道区间的按位或，比赛时用了前缀和思想 + 二分查找求解。
时间复杂度 O(nlogn) 常数为 logmax(nums) 可看作 30
相似题目: 898. 子数组按位或操作
https://leetcode.cn/problems/bitwise-ors-of-subarrays/
1521. 找到最接近目标值的函数值
https://leetcode.cn/problems/find-a-value-of-a-mysterious-function-closest-to-target/
2654. 使数组所有元素变成 1 的最少操作次数
https://leetcode.cn/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1/
 */
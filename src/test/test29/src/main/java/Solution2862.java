import java.util.List;

public class Solution2862 {
    public long maximumSum(List<Integer> nums) {
        int n = nums.size();
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            long s = 0;
            for (int j = 1; i * j * j <= n; j++) {
                int id = i * j * j;
                s += nums.get(id - 1);
            }
            ans = Math.max(ans, s);
        }
        return ans;
    }
}
/*
2862. 完全子集的最大元素和
https://leetcode.cn/problems/maximum-element-sum-of-a-complete-subset-of-indices/

第 363 场周赛 T4。

给你一个下标从 1 开始、由 n 个整数组成的数组。
如果一组数字中每对元素的乘积都是一个完全平方数，则称这组数字是一个 完全集 。
下标集 {1, 2, ..., n} 的子集可以表示为 {i1, i2, ..., ik}，我们定义对应该子集的 元素和 为 nums[i1] + nums[i2] + ... + nums[ik] 。
返回下标集 {1, 2, ..., n} 的 完全子集 所能取到的 最大元素和 。
完全平方数是指可以表示为一个整数和其自身相乘的数。
提示：
1 <= n == nums.length <= 10^4
1 <= nums[i] <= 10^9

枚举。
时间复杂度 O(n)
 */
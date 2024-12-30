import java.util.List;

public class Solution2897 {
    private static final int MOD = (int) (1e9 + 7);

    // 1、能不能拆位做？
    // 2、xor and or
    // 3、trie
    // 操作的本质
    // 当 x < y 的时候，且 x 有个比特位是 1，y 有个比特位是 0
    // 那么可以把 x 中的 1 移到 y 中的 0 上
    // 如果可以操作，就尽量操作
    // 从集合的角度理解，最后小的数对应的集合，一定是大的数对应的集合的子集
    // 1、统计每一位有多少个 1
    // 2、每次构造/组合一个数，使用尽量多的 1
    public int maxSum(List<Integer> nums, int k) {
        int[] cnt = new int[30];
        for (Integer x : nums) {
            for (int i = 0; i < 30; i++) {
                if ((x >> i & 1) == 1) {
                    cnt[i]++;
                }
            }
        }

        long ans = 0;
        while (k-- > 0) {
            int x = 0;
            for (int i = 0; i < 30; i++) {
                if (cnt[i] > 0) {
                    cnt[i]--;
                    x |= 1 << i;
                }
            }
            ans = (ans + (long) x * x) % MOD;
        }
        return (int) ans;
    }
}
/*
2897. 对数组执行操作使平方和最大
https://leetcode.cn/problems/apply-operations-on-array-to-maximize-sum-of-squares/description/

第 366 场周赛 T4。

给你一个下标从 0 开始的整数数组 nums 和一个 正 整数 k 。
你可以对数组执行以下操作 任意次 ：
- 选择两个互不相同的下标 i 和 j ，同时 将 nums[i] 更新为 (nums[i] AND nums[j]) 且将 nums[j] 更新为 (nums[i] OR nums[j]) ，OR 表示按位 或 运算，AND 表示按位 与 运算。
你需要从最终的数组里选择 k 个元素，并计算它们的 平方 之和。
请你返回你可以得到的 最大 平方和。
由于答案可能会很大，将答案对 10^9 + 7 取余 后返回。
提示：
1 <= k <= nums.length <= 10^5
1 <= nums[i] <= 10^9

把 1 都聚在一起
时间复杂度 O(nlogU) 其中 U 最大取到 1e9 < 2^30
时间复杂度 O(logU)
相似题目: D. AND, OR and square sum
https://codeforces.com/contest/1368/problem/D
 */
import java.util.function.Function;

public class SolutionP2936 {
    public int countBlocks(BigArray nums) {
        long n = nums.size();
        int ans = 0;
        for (long i = 0; i < n; ans++) {
            int cur = nums.at(i);
            long finalI = i;
            i += sortSearch(n - i, j -> nums.at(finalI + j) != cur);
        }
        return ans;
    }

    // func Search(n int, f func(int) bool) int { ... }
    private long sortSearch(long n, Function<Long, Boolean> f) {
        long l = 0, r = n;
        while (l < r) {
            long mid = l + (r - l) / 2;
            if (f.apply(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    // UT
    interface BigArray {
        public int at(long index);

        public long size();
    }
}
/*
$2936. 包含相等值数字块的数量
https://leetcode.cn/problems/number-of-equal-numbers-blocks/description/

给定一个整数数组 nums，其 下标从 0 开始。对于 nums，有以下性质：
- 所有相同值的元素都是相邻的。换句话说，如果存在两个下标 i < j，使得 nums[i] == nums[j]，那么对于所有下标 k，满足 i < k < j，都有 nums[k] == nums[i]。
由于 nums 是一个非常大的数组，这里提供了一个 BigArray 类的实例，该实例具有以下函数：
- int at(long long index): 返回 nums[i] 的值。
- long long size(): 返回 nums.length。
让我们把数组分成 最大 的块，使得每个块包含 相等的值。返回这些块的数量。
请注意，如果要使用自定义测试测试解决方案，对于 nums.length > 10 的测试行为是未定义的。
提示：
1 <= nums.length <= 10^15
1 <= nums[i] <= 10^9
在生成的输入中所有相同值的元素是相邻的。
nums 的所有元素之和最多为 10^15。

从 i=0 开始循环，每次找后面不等于 nums[i] 的数的最小下标，作为下一轮循环的 i。
循环直到 i=n 时停止。循环次数即为答案。
时间复杂度 O(sqrtS * logS)。其中 S = sum(nums[i])。
 */
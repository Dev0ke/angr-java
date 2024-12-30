public class SolutionP2198 {
    public long singleDivisorTriplet(int[] nums) {
        int[] cnts = new int[101];
        for (int i : nums) cnts[i]++;

        long ans = 0;
        for (int i = 1; i <= 100; ++i) {
            for (int j = i; j <= 100; ++j) {
                for (int k = j; k <= 100; ++k) {
                    int s = i + j + k;
                    if (((s % i == 0 ? 1 : 0) + (s % j == 0 ? 1 : 0) + ((s % k == 0) ? 1 : 0)) == 1) {
                        if (i != j && j != k) {
                            ans += 6L * cnts[i] * cnts[j] * cnts[k];
                        } else if (i == j) {
                            ans += 3L * cnts[i] * (cnts[i] - 1) * cnts[k];
                        } else {
                            ans += 3L * cnts[i] * cnts[j] * (cnts[j] - 1);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
/*
$2198. 单因数三元组
https://leetcode.cn/problems/number-of-single-divisor-triplets/description/

给定一个下标从 0 开始的正整数数组 nums。由三个 不同 索引 (i, j, k) 组成的三元组，如果 nums[i] + nums[j] + nums[k] 能被 nums[i]、nums[j] 或 nums[k] 中的 一个 整除，则称为 nums 的 单因数三元组。
返回 nums 的单因数三元组。
提示:
3 <= nums.length <= 10^5
1 <= nums[i] <= 100

枚举+计数。
由于 数字最大为 100，因此我们只需枚举 1≤i≤j≤k≤100，如果 i+j+k 能被 i,j,k 之一整除
https://leetcode.cn/problems/number-of-single-divisor-triplets/solutions/1337599/ji-shu-by-newhar-oaeg/
 */
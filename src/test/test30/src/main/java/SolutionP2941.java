import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionP2941 {
    public long maxGcdSum(int[] nums, int k) {
        long mx = Arrays.stream(nums).max().orElseThrow();
        long ans = 0; // 处理 k=1 的特殊情况
        if (k == 1) ans = mx * mx;
        Map<Long, long[]> g1 = new HashMap<>(); // 旧的gcd记录
        for (long num : nums) {
            Map<Long, long[]> g2 = new HashMap<>(); // 新的gcd记录
            g2.put(num, new long[]{num, 1}); // 初始化为自身
            for (Map.Entry<Long, long[]> entry : g1.entrySet()) {
                long g = entry.getKey();
                long[] val = entry.getValue();
                long gnew = getGCD(g, num);
                // 更新每个gcd的最大子数组和与最长子数组长度
                if (!g2.containsKey(gnew) || (g2.get(gnew)[0] < val[0] + num)) {
                    g2.put(gnew, new long[]{val[0] + num, val[1] + 1});
                }
                // 更新答案
                if (g2.get(gnew)[1] >= k && g2.get(gnew)[0] * gnew > ans) {
                    ans = g2.get(gnew)[0] * gnew;
                }
            }
            g1 = g2; // 更新 g1 为 g2
        }
        return ans;
    }

    private long getGCD(long num1, long num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
$2941. 子数组的最大 GCD-Sum
https://leetcode.cn/problems/maximum-gcd-sum-of-a-subarray/description/

给定一个整数数组 nums 和一个整数 k.
数组 a 的 gcd-sum 计算方法如下：
- 设 s 为 a 的所有元素的和。
- 设 g 为 a 的所有元素的 最大公约数。
- a 的 gcd-sum 等于 s * g.
返回 nums 的至少包含 k 个元素的子数组的 最大 gcd-sum。
提示：
n == nums.length
1 <= n <= 10^5
1 <= nums[i] <= 10^6
1 <= k <= n

https://leetcode.cn/problems/maximum-gcd-sum-of-a-subarray/solutions/2541372/ben-ti-he-xin-zai-yu-yi-ren-yi-yuan-su-j-vy7w/
我们可以边遍历数组，边维护每个最大公约数对应的最大子数组和。例如[2,12,18,9]，当遍历到元素18时，gcd为2的子数组和为32，gcd为6的子数组和为30，gcd为18的子数组和为18。而新增元素9时，原gcd为2现再gcd为1，原gcd为6现在gcd为3，原gcd为18现在gcd为9，此时应有记录为{1：41，3：39，9：27}。如果再增加新元素，还是依照这个方法。如果原gcd不同而新gcd相同，总是要取尽量大的子数组和（如本例再增加15，gcd为3的子数组和应该是54而不是42）。另外由于数组长度有下限要求，记录最大子数组和时同时要记录元素数量，累加子数组和时要把数量也加1，如果数量太少，则不能更新答案。
但可能有人就有疑问了，随着元素越来越多，gcd的记录量会不会滚雪球？注意以任意元素为结尾的连续子数组gcd，一定都是该元素的因子，如遍历到18时，gcd记录里只可能有1，2，3，6，9，18中的几个。而且事实上这6个也不会都有，有记录的gcd在排序之后一定满足前一个整除后一个，否则会出现元素多了，子数组gcd的某个素因数的幂次反而减少，这是不合逻辑，无法构造的。因此实际gcd数量为num所有素因子的幂次总和。对于本题的数据范围，可能有最多gcd记录的是524288，理论上能同时有20个不同的gcd，这样总时间是完全允许的。
时间复杂度 O(nlog^2 U)。
相似题目: 898. 子数组按位或操作
https://leetcode.cn/problems/bitwise-ors-of-subarrays/
1521. 找到最接近目标值的函数值
https://leetcode.cn/problems/find-a-value-of-a-mysterious-function-closest-to-target/
 */
public class Solution974 {
    public int subarraysDivByK(int[] nums, int k) {
        // 模 k 下的前缀和
        int sumMod = 0;
        int ans = 0;
        // 前缀和 频次
        int[] modCnt = new int[k];
        modCnt[0] = 1;
        for (int num : nums) {
            sumMod = ((sumMod + num) % k + k) % k;
            ans += modCnt[sumMod];
            modCnt[sumMod]++;
        }
        return ans;
    }
}
/*
974. 和可被 K 整除的子数组
https://leetcode.cn/problems/subarray-sums-divisible-by-k/

第 119 场周赛 T3。

给定一个整数数组 nums 和一个整数 k ，返回其中元素之和可被 k 整除的（连续、非空） 子数组 的数目。
子数组 是数组的 连续 部分。
提示:
1 <= nums.length <= 3 * 10^4
-10^4 <= nums[i] <= 10^4
2 <= k <= 10^4

很自然想到 前缀和 + 枚举连续子数组的方法，但其时间复杂度 O(n^2) 方法本题会超时
可根据数论同余定理，只需 preSum[j + 1] % k == preSum[i] % k 即可，时间复杂度降低为 O(n)
根据排列组合公式统计组合数
相似题目: 523. 连续的子数组和
https://leetcode.cn/problems/continuous-subarray-sum/
560. 和为K的子数组
https://leetcode.cn/problems/subarray-sum-equals-k/
930. 和相同的二元子数组
https://leetcode.cn/problems/binary-subarrays-with-sum/
1371. 每个元音包含偶数次的最长子字符串
https://leetcode.cn/problems/find-the-longest-substring-containing-vowels-in-even-counts/
1542. 找出最长的超赞子字符串
https://leetcode.cn/problems/find-longest-awesome-substring/
1590. 使数组和能被 P 整除
https://leetcode.cn/problems/make-sum-divisible-by-p/
1915. 最美子字符串的数目
https://leetcode.cn/problems/number-of-wonderful-substrings/
 */
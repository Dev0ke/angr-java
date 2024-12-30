public class Solution2302 {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + nums[i];
        }

        long ans = 0L;
        // 枚举每个 i
        for (int i = 0; i < n; i++) {
            int left = i;
            int right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                if ((ps[mid + 1] - ps[i]) * (mid - i + 1L) >= k) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            // 每个 i 的贡献
            ans += left - i + 1;
        }
        return ans - n;
    }

    public long countSubarrays2(int[] nums, long k) {
        int n = nums.length, l = 0, r = 0;
        long ans = 0, sum = 0;
        while (r < n) {
            sum += nums[r];
            while ((r - l + 1) * sum >= k) {
                sum -= nums[l];
                l++;
            }
            ans += r - l + 1;
            r++;
        }
        return ans;
    }
}
/*
2302. 统计得分小于 K 的子数组数目
https://leetcode.cn/problems/count-subarrays-with-score-less-than-k/

第 80 场双周赛 T4。

一个数字的 分数 定义为数组之和 乘以 数组的长度。
- 比方说，[1, 2, 3, 4, 5] 的分数为 (1 + 2 + 3 + 4 + 5) * 5 = 75 。
给你一个正整数数组 nums 和一个整数 k ，请你返回 nums 中分数 严格小于 k 的 非空整数子数组数目。
子数组 是数组中的一个连续元素序列。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
1 <= k <= 10^15

固定每个 i，二分查找求最右边界 j。
时间复杂度 O(nlogn)
也可用双指针在时间复杂度 O(n) 内求解。
 */
public class Solution992 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int[] cnt1 = new int[n + 1];
        int[] cnt2 = new int[n + 1];
        int sz1 = 0, sz2 = 0;
        int l1 = 0, l2 = 0, r = 0;
        int ans = 0;
        while (r < n) {
            if (++cnt1[nums[r]] == 1) sz1++;
            if (++cnt2[nums[r]] == 1) sz2++;

            while (sz1 > k) {
                if (--cnt1[nums[l1]] == 0) sz1--;
                l1++;
            }
            // 第三指针
            while (sz2 > k - 1) {
                if (--cnt2[nums[l2]] == 0) sz2--;
                l2++;
            }
            ans += l2 - l1;
            r++;
        }
        return ans;
    }
}
/*
992. K 个不同整数的子数组
https://leetcode.cn/problems/subarrays-with-k-different-integers/

给定一个正整数数组 nums和一个整数 k ，返回 num 中 「好子数组」 的数目。
如果 nums 的某个子数组中不同整数的个数恰好为 k，则称 nums 的这个连续、不一定不同的子数组为 「好子数组 」。
- 例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。
子数组 是数组的 连续 部分。
提示：
1 <= nums.length <= 2 * 10^4
1 <= nums[i], k <= nums.length

双指针（没见过的三指针版本）
对于每一个右指针下标，找到左区间 [left1, left2]
相似题目: 3306. 元音辅音字符串计数 II
https://leetcode.cn/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/description/
 */
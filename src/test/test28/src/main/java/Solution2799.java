import java.util.HashSet;
import java.util.Set;

public class Solution2799 {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;

        // 整个数组不同元素的数目
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        int k = set.size();

        // 三指针
        int ans = 0;
        int l1 = 0, l2 = 0, r = 0;
        int cnt1 = 0, cnt2 = 0;
        int[] cntArr1 = new int[2005], cntArr2 = new int[2005];
        while (r < n) {
            cntArr1[nums[r]]++;
            if (cntArr1[nums[r]] == 1) cnt1++;
            cntArr2[nums[r]]++;
            if (cntArr2[nums[r]] == 1) cnt2++;

            while (cnt1 > k) {
                cntArr1[nums[l1]]--;
                if (cntArr1[nums[l1]] == 0) cnt1--;
                l1++;
            }
            while (cnt2 > k - 1) {
                cntArr2[nums[l2]]--;
                if (cntArr2[nums[l2]] == 0) cnt2--;
                l2++;
            }

            ans += l2 - l1;
            r++;
        }
        return ans;
    }
}
/*
2799. 统计完全子数组的数目
https://leetcode.cn/problems/count-complete-subarrays-in-an-array/

第 356 场周赛 T2。

给你一个由 正 整数组成的数组 nums 。
如果数组中的某个子数组满足下述条件，则称之为 完全子数组 ：
- 子数组中 不同 元素的数目等于整个数组不同元素的数目。
返回数组中 完全子数组 的数目。
子数组 是数组中的一个连续非空序列。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 2000

双指针/三指针
时间复杂度 O(n)
相似题目: 992. K 个不同整数的子数组
https://leetcode.cn/problems/subarrays-with-k-different-integers/
 */
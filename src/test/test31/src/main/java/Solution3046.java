import java.util.Arrays;

public class Solution3046 {
    public boolean isPossibleToSplit(int[] nums) {
        int[] cnt = new int[105];
        for (int v : nums) {
            cnt[v]++;
        }
        return Arrays.stream(cnt).max().orElseThrow() <= 2;
    }
}
/*
3046. 分割数组
https://leetcode.cn/problems/split-the-array/description/

第 386 场周赛 T1。

给你一个长度为 偶数 的整数数组 nums 。你需要将这个数组分割成 nums1 和 nums2 两部分，要求：
- nums1.length == nums2.length == nums.length / 2 。
- nums1 应包含 互不相同 的元素。
- nums2也应包含 互不相同 的元素。
如果能够分割数组就返回 true ，否则返回 false 。
提示：
1 <= nums.length <= 100
nums.length % 2 == 0
1 <= nums[i] <= 100

最大频次不能超过 2
时间复杂度 O(n)
 */
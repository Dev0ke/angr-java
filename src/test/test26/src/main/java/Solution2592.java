import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Solution2592 {
    public int maximizeGreatness(int[] nums) {
        int n = nums.length;
        int[] nums2 = nums.clone();
        int[] perm = advantageCount(nums, nums2);

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (perm[i] > nums2[i]) {
                res++;
            }
        }
        return res;
    }

    private int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Arrays.sort(nums1);
        Integer[] id2 = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        Arrays.sort(id2, Comparator.comparingInt(o -> nums2[o]));

        int[] res = new int[n];
        int l = 0, r = n - 1;
        for (int n1 : nums1) {
            if (n1 > nums2[id2[l]]) {
                res[id2[l]] = n1;
                l++;
            } else {
                res[id2[r]] = n1;
                r--;
            }
        }
        return res;
    }
}
/*
2592. 最大化数组的伟大值
https://leetcode.cn/problems/maximize-greatness-of-an-array/

第 100 场双周赛 T2。

给你一个下标从 0 开始的整数数组 nums 。你需要将 nums 重新排列成一个新的数组 perm 。
定义 nums 的 伟大值 为满足 0 <= i < nums.length 且 perm[i] > nums[i] 的下标数目。
请你返回重新排列 nums 后的 最大 伟大值。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^9

"田忌赛马" 经典问题。
相似题目: 870. 优势洗牌
https://leetcode.cn/problems/advantage-shuffle/
时间复杂度 O(nlogn)
 */
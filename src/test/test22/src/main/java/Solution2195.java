import java.util.Arrays;

public class Solution2195 {
    public long minimalKSum(int[] nums, int k) {
        nums = Arrays.stream(nums).distinct().sorted().toArray();
//        Arrays.sort(nums);

        long repeat = 0;
        for (int num : nums) {
            if (num <= k) {
                repeat += num;
                k++;
            }
        }

        long totalK = (1L + k) * (k) / 2;

        return totalK - repeat;
    }
}
/*
2195. 向数组中追加 K 个整数
https://leetcode.cn/problems/append-k-integers-with-minimal-sum/

第 283 场周赛 T2。

给你一个整数数组 nums 和一个整数 k 。请你向 nums 中追加 k 个 未 出现在 nums 中的、互不相同 的 正 整数，并使结果数组的元素和 最小 。
返回追加到 nums 中的 k 个整数之和。
提示：
1 <= nums.length <= 10^5
1 <= nums[i], k <= 10^9

本题容易想到基于贪心思想从最小的数添加，显然逐个枚举会TLE。因此考虑等差数列求和公式: (首项+末项)*项数/2. 求和后再减去重复项的和即可。如果前面有重复的，k 要相应后移。
比赛时 WA 了两次：
第一次 WA 没有考虑到 k 后移可能引入新的重复项
第二次 WA 没有考虑到 nums 中有重复项
还好周赛能看到错误用例，否则难以 AC。
 */
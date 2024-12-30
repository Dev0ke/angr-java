public class Solution798 {
    public int bestRotation(int[] nums) {
        int n = nums.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            int low = (i + 1) % n;
            int high = (i - nums[i] + n + 1) % n;
            diff[low] += 1;
            diff[high] -= 1;
            if (low >= high) {
                diff[0] += 1;
            }
        }

        int score = 0, maxScore = 0, maxI = 0;
        for (int i = 0; i < n; i++) {
            score += diff[i];
            if (maxScore < score) {
                maxScore = score;
                maxI = i;
            }
        }
        return maxI;
    }
}
/*
798. 得分最高的最小轮调
https://leetcode.cn/problems/smallest-rotation-with-highest-score/description/

给你一个数组 nums，我们可以将它按一个非负整数 k 进行轮调，这样可以使数组变为 [nums[k], nums[k + 1], ... nums[nums.length - 1], nums[0], nums[1], ..., nums[k-1]] 的形式。此后，任何值小于或等于其索引的项都可以记作一分。
- 例如，数组为 nums = [2,4,1,3,0]，我们按 k = 2 进行轮调后，它将变成 [1,3,0,2,4]。这将记为 3 分，因为 1 > 0 [不计分]、3 > 1 [不计分]、0 <= 2 [计 1 分]、2 <= 3 [计 1 分]，4 <= 4 [计 1 分]。
在所有可能的轮调中，返回我们所能得到的最高分数对应的轮调下标 k 。如果有多个答案，返回满足条件的最小的下标 k 。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] < nums.length

HPC 初赛题目。
差分数组。
时间复杂度 O(n)。
 */
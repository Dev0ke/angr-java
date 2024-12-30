public class Solution3357 {
    public int minDifference(int[] nums) {
        int n = nums.length;
        // 和空位相邻的最小数字 minL 和最大数字 maxR
        int minL = Integer.MAX_VALUE;
        int maxR = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != -1 && (i > 0 && nums[i - 1] == -1 || i < n - 1 && nums[i + 1] == -1)) {
                minL = Math.min(minL, nums[i]);
                maxR = Math.max(maxR, nums[i]);
            }
        }

        int preI = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == -1) {
                continue;
            }
            if (preI >= 0) {
                if (i - preI == 1) {
                    ans = Math.max(ans, Math.abs(nums[i] - nums[preI]));
                } else {
                    updateAns(Math.min(nums[preI], nums[i]), Math.max(nums[preI], nums[i]), i - preI > 2, minL, maxR);
                }
            } else if (i > 0) {
                updateAns(nums[i], nums[i], false, minL, maxR);
            }
            preI = i;
        }
        if (0 <= preI && preI < n - 1) {
            updateAns(nums[preI], nums[preI], false, minL, maxR);
        }
        return ans;
    }

    private int ans;

    private void updateAns(int l, int r, boolean big, int minL, int maxR) {
        int d = (Math.min(r - minL, maxR - l) + 1) / 2;
        if (big) {
            d = Math.min(d, (maxR - minL + 2) / 3); // d 不能超过上界
        }
        ans = Math.max(ans, d);
    }
}
/*
3357. 最小化相邻元素的最大差值
https://leetcode.cn/problems/minimize-the-maximum-adjacent-element-difference/description/

第 424 场周赛 T4。

给你一个整数数组 nums 。nums 中的一些值 缺失 了，缺失的元素标记为 -1 。
你需要选择 一个正 整数数对 (x, y) ，并将 nums 中每一个 缺失 元素用 x 或者 y 替换。
你的任务是替换 nums 中的所有缺失元素，最小化 替换后数组中相邻元素 绝对差值 的 最大值 。
请你返回上述要求下的 最小值 。
提示：
2 <= nums.length <= 10^5
nums[i] 要么是 -1 ，要么是范围 [1, 10^9] 中的一个整数。

O(n) 贪心。
https://leetcode.cn/problems/minimize-the-maximum-adjacent-element-difference/solutions/2991784/on-tan-xin-pythonjavacgo-by-endlesscheng-1bxe/
rating 2884 (clist.by)
 */
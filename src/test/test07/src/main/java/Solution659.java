public class Solution659 {
    public boolean isPossible(int[] nums) {
        // 先调整为正数
        int offset = 1005;
        int[] cntMp = new int[offset * 2];
        int[] endMp = new int[offset * 2];
        for (int x : nums) {
            cntMp[x + offset]++;
        }

        for (int x : nums) {
            x += offset;
            if (cntMp[x] > 0) {
                int prevEndCnt = endMp[x - 1];
                if (prevEndCnt > 0) {
                    cntMp[x]--;
                    endMp[x - 1]--;
                    endMp[x]++;
                } else {
                    if (cntMp[x + 1] > 0 && cntMp[x + 2] > 0) {
                        cntMp[x]--;
                        cntMp[x + 1]--;
                        cntMp[x + 2]--;
                        endMp[x + 2]++;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
/*
659. 分割数组为连续子序列
https://leetcode.cn/problems/split-array-into-consecutive-subsequences/description/

给你一个按 非递减顺序 排列的整数数组 nums 。
请你判断是否能在将 nums 分割成 一个或多个子序列 的同时满足下述 两个 条件：
- 每个子序列都是一个 连续递增序列（即，每个整数 恰好 比前一个整数大 1 ）。
- 所有子序列的长度 至少 为 3 。
如果可以分割 nums 并满足上述条件，则返回 true ；否则，返回 false 。
提示：
1 <= nums.length <= 10^4
-1000 <= nums[i] <= 1000
nums 按非递减顺序排列

贪心。
时间复杂度 O(n)。
将 x 加入已有的子序列总是比新建一个只包含 x 的子序列更优
https://leetcode.cn/problems/split-array-into-consecutive-subsequences/solutions/508610/fen-ge-shu-zu-wei-lian-xu-zi-xu-lie-by-l-lbs5/
 */
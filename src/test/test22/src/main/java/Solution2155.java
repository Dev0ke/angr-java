import java.util.ArrayList;
import java.util.List;

public class Solution2155 {
    public List<Integer> maxScoreIndices(int[] nums) {
        int len = nums.length;
        // 前缀和
        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        List<Integer> resList = new ArrayList<>();
        int max = 0;
        // 枚举分割点
        for (int i = 0; i <= len; i++) {
            // numsleft 中 0 的个数
            int left = i - (preSum[i] - preSum[0]);
            // numsright 中 1 的个数
            int right = preSum[len] - preSum[i];

            if (left + right > max) {
                max = left + right;
                resList.clear();
                resList.add(i);
            } else if (left + right == max) {
                resList.add(i);
            }
        }
        return resList;
    }
}
/*
2155. 分组得分最高的所有下标
https://leetcode.cn/problems/all-divisions-with-the-highest-score-of-a-binary-array/

第 278 场周赛 T2。

给你一个下标从 0 开始的二进制数组 nums ，数组长度为 n 。nums 可以按下标 i（ 0 <= i <= n ）拆分成两个数组（可能为空）：numsleft 和 numsright 。
- numsleft 包含 nums 中从下标 0 到 i - 1 的所有元素（包括 0 和 i - 1 ），而 numsright 包含 nums 中从下标 i 到 n - 1 的所有元素（包括 i 和 n - 1 ）。
- 如果 i == 0 ，numsleft 为 空 ，而 numsright 将包含 nums 中的所有元素。
- 如果 i == n ，numsleft 将包含 nums 中的所有元素，而 numsright 为 空 。
下标 i 的 分组得分 为 numsleft 中 0 的个数和 numsright 中 1 的个数之 和 。
返回 分组得分 最高 的 所有不同下标 。你可以按 任意顺序 返回答案。
提示：
n == nums.length
1 <= n <= 10^5
nums[i] 为 0 或 1

前缀和。
时间复杂度 O(n)
 */
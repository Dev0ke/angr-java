import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution3371 {
    public int getLargestOutlier(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : nums) {
            cnt.merge(v, 1, Integer::sum);
        }

        int ans = Integer.MIN_VALUE;
        for (int v : nums) {
            int tot = sum - v;
            if (Math.floorMod(tot, 2) == 1) continue;
            tot /= 2;
            Integer tot_cnt = cnt.getOrDefault(tot, 0);
            if (tot == v && tot_cnt >= 2 || tot != v && tot_cnt >= 1) {
                ans = Math.max(ans, v);
            }
        }
        return ans;
    }
}
/*
100444. 识别数组中的最大异常值
https://leetcode.cn/problems/identify-the-largest-outlier-in-an-array/description/

第 426 场周赛 T2。

给你一个整数数组 nums。该数组包含 n 个元素，其中 恰好 有 n - 2 个元素是 特殊数字 。剩下的 两个 元素中，一个是这些 特殊数字 的 和 ，另一个是 异常值 。
异常值 的定义是：既不是原始特殊数字之一，也不是表示这些数字元素和的数字。
注意，特殊数字、和 以及 异常值 的下标必须 不同 ，但可以共享 相同 的值。
返回 nums 中可能的 最大异常值。
提示：
3 <= nums.length <= 10^5
-1000 <= nums[i] <= 1000
输入保证 nums 中至少存在 一个 可能的异常值。

哈希表。
 */
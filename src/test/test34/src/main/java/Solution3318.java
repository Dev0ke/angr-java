import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3318 {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < k; i++) {
            cnt.merge(nums[i], 1, Integer::sum);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = getAns(cnt, x);
        for (int i = k; i < n; i++) {
            cnt.merge(nums[i], 1, Integer::sum);
            if (cnt.merge(nums[i - k], -1, Integer::sum) == 0) {
                cnt.remove(nums[i - k]);
            }
            ans[i - k + 1] = getAns(cnt, x);
        }
        return ans;
    }

    private int getAns(Map<Integer, Integer> cnt, int x) {
        List<Map.Entry<Integer, Integer>> entryArrayList = new ArrayList<>(cnt.entrySet());
        entryArrayList.sort((o1, o2) -> {
            if (o2.getValue().equals(o1.getValue())) {
                return Integer.compare(o2.getKey(), o1.getKey());
            }
            return Integer.compare(o2.getValue(), o1.getValue());
        });
        int res = 0;
        for (int i = 0; i < x && i < entryArrayList.size(); i++) {
            res += entryArrayList.get(i).getValue() * entryArrayList.get(i).getKey();
        }
        return res;
    }
}
/*
3318. 计算子数组的 x-sum I
https://leetcode.cn/problems/find-x-sum-of-all-k-long-subarrays-i/description/

第 419 场周赛 T1。

给你一个由 n 个整数组成的数组 nums，以及两个整数 k 和 x。
数组的 x-sum 计算按照以下步骤进行：
- 统计数组中所有元素的出现次数。
- 仅保留出现次数最多的前 x 个元素的每次出现。如果两个元素的出现次数相同，则数值 较大 的元素被认为出现次数更多。
- 计算结果数组的和。
注意，如果数组中的不同元素少于 x 个，则其 x-sum 是数组的元素总和。
返回一个长度为 n - k + 1 的整数数组 answer，其中 answer[i] 是 子数组 nums[i..i + k - 1] 的 x-sum。
子数组 是数组内的一个连续 非空 的元素序列。
提示：
1 <= n == nums.length <= 50
1 <= nums[i] <= 50
1 <= x <= k <= nums.length

暴力。
同: 3321. 计算子数组的 x-sum II
https://leetcode.cn/problems/find-x-sum-of-all-k-long-subarrays-ii/description/
 */
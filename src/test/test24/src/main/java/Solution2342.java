import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2342 {
    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> cntMap = new HashMap<>();
        for (int num : nums) {
            int digitsSum = getDigitsSum(num);
            cntMap.computeIfAbsent(digitsSum, key -> new ArrayList<>()).add(num);
        }

        int max = -1;
        for (Map.Entry<Integer, List<Integer>> entry : cntMap.entrySet()) {
            List<Integer> list = entry.getValue();
            int size = list.size();
            if (size > 1) {
                // 取 top1 top2
                Collections.sort(list);
                max = Math.max(max, list.get(size - 1) + list.get(size - 2));
            }
        }
        return max;
    }

    // 数位和
    private int getDigitsSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
/*
2342. 数位和相等数对的最大和
https://leetcode.cn/problems/max-sum-of-a-pair-with-equal-sum-of-digits/

第 302 场周赛 T2。

给你一个下标从 0 开始的数组 nums ，数组中的元素都是 正 整数。请你选出两个下标 i 和 j（i != j），且 nums[i] 的数位和 与  nums[j] 的数位和相等。
请你找出所有满足条件的下标 i 和 j ，找出并返回 nums[i] + nums[j] 可以得到的 最大值 。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

贪心。
预处理所有数位和对应的 num，找 top2 元素更新最大值。
时间复杂度 O(nlogn)
 */
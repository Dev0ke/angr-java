import java.util.ArrayList;
import java.util.List;

public class Solution2750 {
    private static final int MOD = (int) (1e9 + 7);

    public int numberOfGoodSubarraySplits(int[] nums) {
        int n = nums.length;
        List<Integer> idList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                idList.add(i);
            }
        }

        if (idList.isEmpty()) return 0;
        long ans = 1;
        int sz = idList.size();
        for (int i = 1; i < sz; i++) {
            int d = idList.get(i) - idList.get(i - 1);
            ans = ans * d % MOD;
        }
        return (int) ans;
    }
}
/*
2750. 将数组划分成若干好子数组的方式
https://leetcode.cn/problems/ways-to-split-array-into-good-subarrays/

第 351 场周赛 T3。

给你一个二元数组 nums 。
如果数组中的某个子数组 恰好 只存在 一 个值为 1 的元素，则认为该子数组是一个 好子数组 。
请你统计将数组 nums 划分成若干 好子数组 的方法数，并以整数形式返回。由于数字可能很大，返回其对 10^9 + 7 取余 之后的结果。
子数组是数组中的一个连续 非空 元素序列。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 1

乘法原理。
时间复杂度 O(n)
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2449 {
    public long makeSimilar(int[] nums, int[] target) {
        Arrays.sort(nums);
        Arrays.sort(target);

        List<Integer> numsRemain0List = new ArrayList<>();
        List<Integer> numsRemain1List = new ArrayList<>();
        List<Integer> targetRemain0List = new ArrayList<>();
        List<Integer> targetRemain1List = new ArrayList<>();

        for (int x : nums) {
            if (x % 2 == 0) {
                numsRemain0List.add(x);
            } else {
                numsRemain1List.add(x);
            }
        }
        for (int x : target) {
            if (x % 2 == 0) {
                targetRemain0List.add(x);
            } else {
                targetRemain1List.add(x);
            }
        }

        long res = 0;
        for (int i = 0; i < numsRemain0List.size(); i++) {
            res += Math.max(0, numsRemain0List.get(i) - targetRemain0List.get(i)) / 2;
        }
        for (int i = 0; i < numsRemain1List.size(); i++) {
            res += Math.max(0, numsRemain1List.get(i) - targetRemain1List.get(i)) / 2;
        }
        return res;
    }
}
/*
2449. 使数组相似的最少操作次数
https://leetcode.cn/problems/minimum-number-of-operations-to-make-arrays-similar/

第 316 场周赛 T4。

给你两个正整数数组 nums 和 target ，两个数组长度相等。
在一次操作中，你可以选择两个 不同 的下标 i 和 j ，其中 0 <= i, j < nums.length ，并且：
- 令 nums[i] = nums[i] + 2 且
- 令 nums[j] = nums[j] - 2 。
如果两个数组中每个元素出现的频率相等，我们称两个数组是 相似 的。
请你返回将 nums 变得与 target 相似的最少操作次数。测试数据保证 nums 一定能变得与 target 相似。
提示：
n == nums.length == target.length
1 <= n <= 10^5
1 <= nums[i], target[i] <= 10^6
nums 一定可以变得与 target 相似。

每次操作变为加减 k，那么只有 % k 相等的数才能互相变换。
排序后分组后计算
时间复杂度 O(nlogn)
 */
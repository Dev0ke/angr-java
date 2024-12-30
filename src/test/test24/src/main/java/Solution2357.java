import java.util.HashSet;
import java.util.Set;

public class Solution2357 {
    public int minimumOperations(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                hashSet.add(num);
            }
        }
        return hashSet.size();
    }
}
/*
2357. 使数组中所有元素都等于零
https://leetcode.cn/problems/make-array-zero-by-subtracting-equal-amounts/

第 304 场周赛 T1。

给你一个非负整数数组 nums 。在一步操作中，你必须：
- 选出一个正整数 x ，x 需要小于或等于 nums 中 最小 的 非零 元素。
- nums 中的每个正整数都减去 x。
返回使 nums 中所有元素都等于 0 需要的 最少 操作数。
提示：
1 <= nums.length <= 100
0 <= nums[i] <= 100

去重，统计非 0 元素个数。
 */
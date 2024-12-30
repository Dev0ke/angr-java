import java.util.HashMap;
import java.util.Map;

public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 如果存在重复元素 并且 下标距离至多为 k
            if (map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
/*
219. 存在重复元素 II
https://leetcode.cn/problems/contains-duplicate-ii/

给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
提示：
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
0 <= k <= 10^5

难度增加，多了个下标距离至多为 k 的约束。
使用 Map。key 记录数值 value 记录下标。
 */
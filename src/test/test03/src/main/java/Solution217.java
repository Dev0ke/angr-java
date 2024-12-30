import java.util.HashSet;
import java.util.Set;

public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            // 已有的元素中是否有重复
            if (!set.contains(num)) {
                set.add(num);
            } else {
                return true;
            }
        }
        return false;
    }
}
/*
217. 存在重复元素
https://leetcode.cn/problems/contains-duplicate/

给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
提示：
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9

使用 Set 判断是否存在重复元素。
 */
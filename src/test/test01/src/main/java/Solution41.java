import java.util.HashSet;
import java.util.Set;

public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }

        // 枚举
        for (int i = 1; i <= len; i++) {
            if (!hashSet.contains(i)) {
                return i;
            }
        }
        return len + 1;
    }
}
/*
41. 缺失的第一个正数
https://leetcode.cn/problems/first-missing-positive/

给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
提示：
1 <= nums.length <= 5 * 10^5
-2^31 <= nums[i] <= 2^31 - 1

时间复杂度 O(n)
如果空间复杂度为 O(n) 那么用 HashSet 很直观即可求出。
 */
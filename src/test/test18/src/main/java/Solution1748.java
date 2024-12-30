import java.util.HashMap;
import java.util.Map;

public class Solution1748 {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() == 1) {
                sum += entry.getKey();
            }
        }
        return sum;
    }
}
/*
1748. 唯一元素的和
https://leetcode.cn/problems/sum-of-unique-elements/

给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
请你返回 nums 中唯一元素的 和 。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100

HashMap 统计频次。
 */
import java.util.HashMap;
import java.util.Map;

public class Solution137 {
    /**
     * HashMap
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     * 数字电路设计优化
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public int singleNumber2(int[] nums) {
        int a = 0;
        int b = 0;
        for (int num : nums) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
        }
        return b;
    }
}
/*
137. 只出现一次的数字 II
https://leetcode.cn/problems/single-number-ii/

给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
你必须设计并实现线性时间复杂度的算法且不使用额外空间来解决此问题。
提示：
1 <= nums.length <= 3 * 10^4
-2^31 <= nums[i] <= 2^31 - 1
nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次

相似题目: 136. 只出现一次的数字
https://leetcode.cn/problems/single-number/
260. 只出现一次的数字 III
https://leetcode.cn/problems/single-number-iii/
 */
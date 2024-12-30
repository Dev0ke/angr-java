import java.util.HashMap;
import java.util.Map;

public class Solution136 {
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
     * 位运算
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public int singleNumber2(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
/*
136. 只出现一次的数字
https://leetcode.cn/problems/single-number/

给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
提示：
1 <= nums.length <= 3 * 10^4
-3 * 10^4 <= nums[i] <= 3 * 10^4
除了某个元素只出现一次以外，其余每个元素均出现两次。

HashMap 统计/位运算
相似题目: 137. 只出现一次的数字 II
https://leetcode.cn/problems/single-number-ii/
260. 只出现一次的数字 III
https://leetcode.cn/problems/single-number-iii/
 */
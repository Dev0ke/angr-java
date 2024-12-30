import java.util.HashMap;
import java.util.Map;

public class Solution961 {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length / 2;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() == n) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
/*
961. 在长度 2N 的数组中找出重复 N 次的元素
https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/

给你一个整数数组 nums ，该数组具有以下属性：
- nums.length == 2 * n.
- nums 包含 n + 1 个 不同的 元素
- nums 中恰有一个元素重复 n 次
找出并返回重复了 n 次的那个元素。
提示：
2 <= n <= 5000
nums.length == 2 * n
0 <= nums[i] <= 10^4
nums 由 n + 1 个 不同的 元素组成，且其中一个元素恰好重复 n 次

HashMap 统计频次。
 */
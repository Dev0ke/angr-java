import java.util.HashMap;
import java.util.Map;

public class Solution1726 {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int key = nums[i] * nums[j];
                cntMap.put(key, cntMap.getOrDefault(key, 0) + 1);
            }
        }
        int ans = 0;
        for (Integer c : cntMap.values()) {
            ans += c * (c - 1) * 4;
        }
        return ans;
    }
}
/*
1726. 同积元组
https://leetcode.cn/problems/tuple-with-same-product/description/

给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。其中 a、b、c 和 d 都是 nums 中的元素，且 a != b != c != d 。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 10^4
nums 中的所有元素 互不相同

哈希表统计频次，组合数。
时间复杂度 O(n^2)
空间复杂度 O(n^2)
 */
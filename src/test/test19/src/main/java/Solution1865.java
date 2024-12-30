import java.util.HashMap;
import java.util.Map;

public class Solution1865 {
    static class FindSumPairs {
        int[] nums1, nums2;
        Map<Integer, Integer> cnt;

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            cnt = new HashMap<>();
            for (int v : nums2) cnt.merge(v, 1, Integer::sum);
        }

        public void add(int index, int val) {
            cnt.merge(nums2[index], -1, Integer::sum);
            nums2[index] += val;
            cnt.merge(nums2[index], 1, Integer::sum);
        }

        public int count(int tot) {
            int ans = 0;
            for (int v : nums1) {
                if (cnt.containsKey(tot - v)) ans += cnt.get(tot - v);
            }
            return ans;
        }
    }
}
/*
1865. 找出和为指定值的下标对
https://leetcode.cn/problems/finding-pairs-with-a-certain-sum/description/

给你两个整数数组 nums1 和 nums2 ，请你实现一个支持下述两类查询的数据结构：
1.累加 ，将一个正整数加到 nums2 中指定下标对应元素上。
2.计数 ，统计满足 nums1[i] + nums2[j] 等于指定值的下标对 (i, j) 数目（0 <= i < nums1.length 且 0 <= j < nums2.length）。
实现 FindSumPairs 类：
- FindSumPairs(int[] nums1, int[] nums2) 使用整数数组 nums1 和 nums2 初始化 FindSumPairs 对象。
- void add(int index, int val) 将 val 加到 nums2[index] 上，即，执行 nums2[index] += val 。
- int count(int tot) 返回满足 nums1[i] + nums2[j] == tot 的下标对 (i, j) 数目。
提示：
1 <= nums1.length <= 1000
1 <= nums2.length <= 10^5
1 <= nums1[i] <= 10^9
1 <= nums2[i] <= 10^5
0 <= index < nums2.length
1 <= val <= 10^5
1 <= tot <= 10^9
最多调用 add 和 count 函数各 1000 次

哈希表。
时间复杂度:
  FindSumPairs: O(m)。其中 n = |nums1|, m = |nums2|。
  add: O(1)。
  count: O(n)。
 */
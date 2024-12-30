public class Solution169 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
/*
169. 多数元素
https://leetcode.cn/problems/majority-element/

给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
提示：
n == nums.length
1 <= n <= 5 * 10^4
-10^9 <= nums[i] <= 10^9
进阶：
尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。

Boyer-Moore 投票算法
同: 剑指 Offer 39. 数组中出现次数超过一半的数字
https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
时间复杂度 O(n)
空间复杂度 O(1)
 */

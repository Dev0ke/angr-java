import java.util.Random;

public class Solution398 {
    static class Solution {
        private final int[] nums;
        private final Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            this.random = new Random();
        }

        public int pick(int target) {
            int ans = 0;
            for (int i = 0, cnt = 0; i < nums.length; ++i) {
                if (nums[i] == target) {
                    // 第 cnt 次遇到 target
                    cnt++;
                    if (random.nextInt(cnt) == 0) {
                        ans = i;
                    }
                }
            }
            return ans;
        }
    }
}
/*
398. 随机数索引
https://leetcode.cn/problems/random-pick-index/

给你一个可能含有 重复元素 的整数数组 nums ，请你随机输出给定的目标数字 target 的索引。你可以假设给定的数字一定存在于数组中。
实现 Solution 类：
- Solution(int[] nums) 用数组 nums 初始化对象。
- int pick(int target) 从 nums 中选出一个满足 nums[i] == target 的随机索引 i 。如果存在多个有效的索引，则每个索引的返回概率应当相等。
提示：
1 <= nums.length <= 2 * 10^4
-2^31 <= nums[i] <= 2^31 - 1
target 是 nums 中的一个整数
最多调用 pick 函数 10^4 次

水塘抽样。
遍历 nums，当我们第 i 次遇到值为 target 的元素时，随机选择区间 [0,i) 内的一个整数，如果其等于 0，则将返回值置为该元素的下标，否则返回值不变。
相似题目: 382. 链表随机节点
https://leetcode.cn/problems/linked-list-random-node/
 */
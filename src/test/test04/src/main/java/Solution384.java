import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution384 {
    static class Solution {
        private final int[] raw;

        public Solution(int[] nums) {
            this.raw = Arrays.copyOf(nums, nums.length);
        }

        public int[] reset() {
            return raw;
        }

        public int[] shuffle() {
            List<Integer> list = Arrays.stream(raw).boxed().collect(Collectors.toList());
            Collections.shuffle(list);
            return list.stream().mapToInt(i -> i).toArray();
        }
    }
}
/*
384. 打乱数组
https://leetcode.cn/problems/shuffle-an-array/

给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
实现 Solution class:
- Solution(int[] nums) 使用整数数组 nums 初始化对象
- int[] reset() 重设数组到它的初始状态并返回
- int[] shuffle() 返回数组随机打乱后的结果
提示：
1 <= nums.length <= 200
-10^6 <= nums[i] <= 10^6
nums 中的所有元素都是 唯一的
最多可以调用 5 * 10^4 次 reset 和 shuffle

洗牌算法。
Collections.shuffle()
 */
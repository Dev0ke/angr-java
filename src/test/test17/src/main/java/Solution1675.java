import java.util.Comparator;
import java.util.TreeSet;

public class Solution1675 {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> mp = new TreeSet<>(Comparator.reverseOrder());
        for (int v : nums) {
            if (v % 2 == 1) mp.add(v * 2);
            else mp.add(v);
        }
        int ans = mp.first() - mp.last();
        while (mp.first() % 2 == 0) {
            Integer top = mp.pollFirst();
            mp.add(top / 2);
            ans = Math.min(ans, mp.first() - mp.last());
        }
        return ans;
    }
}
/*
1675. 数组的最小偏移量
https://leetcode.cn/problems/minimize-deviation-in-array/description/

给你一个由 n 个正整数组成的数组 nums 。
你可以对数组的任意元素执行任意次数的两类操作：
- 如果元素是 偶数 ，除以 2
  - 例如，如果数组是 [1,2,3,4] ，那么你可以对最后一个元素执行此操作，使其变成 [1,2,3,2]
- 如果元素是 奇数 ，乘上 2
  - 例如，如果数组是 [1,2,3,4] ，那么你可以对第一个元素执行此操作，使其变成 [2,2,3,4]
数组的 偏移量 是数组中任意两个元素之间的 最大差值 。
返回数组在执行某些操作之后可以拥有的 最小偏移量 。
提示：
n == nums.length
2 <= n <= 5 * 10^4
1 <= nums[i] <= 10^9

第一步：先把所有奇数乘 2，这样就等价于只有操作 1。
第二步：操作 1 的只会减少某个数的值，而只有减少最大值结果才可能更优。
第三步：使用平衡树或堆维护最大值，直到最大值为奇数不能再操作为止。
 */
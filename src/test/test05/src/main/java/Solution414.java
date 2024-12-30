import java.util.TreeSet;

public class Solution414 {
    public int thirdMax(int[] nums) {
        // a < b < c
        long a = Long.MIN_VALUE;
        long b = Long.MIN_VALUE;
        long c = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > a) {
                c = b;
                b = a;
                a = num;
            } else if (a > num && num > b) {
                c = b;
                b = num;
            } else if (b > num && num > c) {
                c = num;
            }
        }
        return (int) (c == Long.MIN_VALUE ? a : c);
    }

    public int thirdMax2(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            treeSet.add(num);
        }
        if (treeSet.size() < 3) {
            return treeSet.last();
        } else {
            treeSet.pollLast();
            treeSet.pollLast();
            return treeSet.last();
        }
    }
}
/*
414. 第三大的数
https://leetcode.cn/problems/third-maximum-number/

给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
提示：
1 <= nums.length <= 10^4
-2^31 <= nums[i] <= 2^31 - 1
进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？

排序/线性遍历
时间复杂度 O(n)
 */
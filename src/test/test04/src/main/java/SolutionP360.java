public class SolutionP360 {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int len = nums.length;
        int[] res = new int[len];

        int left = 0;
        int right = len - 1;

        if (a > 0) {
            // 同 solution977
            // 抛物线开口向上，两端大，中间小。由大到小
            int id = len - 1;
            while (left <= right) {
                int lans = f(nums[left], a, b, c);
                int rans = f(nums[right], a, b, c);
                if (lans > rans) {
                    res[id--] = lans;
                    left++;
                } else {
                    res[id--] = rans;
                    right--;
                }
            }
        } else if (a < 0) {
            // 抛物线开口向下，两端小，中间大。由小到大
            int id = 0;
            while (left <= right) {
                int lans = f(nums[left], a, b, c);
                int rans = f(nums[right], a, b, c);
                if (lans < rans) {
                    res[id++] = lans;
                    left++;
                } else {
                    res[id++] = rans;
                    right--;
                }
            }
        } else {
            // 一元一次方程 bx + c
            if (b > 0) {
                int id = 0;
                for (int x : nums) {
                    res[id++] = f(x, a, b, c);
                }
            } else {
                int id = len - 1;
                for (int x : nums) {
                    res[id--] = f(x, a, b, c);
                }
            }
        }
        return res;
    }

    private int f(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
/*
$360. 有序转化数组
https://leetcode.cn/problems/sort-transformed-array/

给你一个已经 排好序 的整数数组 nums 和整数 a 、 b 、 c 。对于数组中的每一个元素 nums[i] ，计算函数值 f(x) = ax2 + bx + c ，请 按升序返回数组 。
提示：
1 <= nums.length <= 200
-100 <= nums[i], a, b, c <= 100
nums 按照 升序排列
进阶：你可以在时间复杂度为 O(n) 的情况下解决这个问题吗？

双指针
时间复杂度 O(n)
相似题目: 977. 有序数组的平方
https://leetcode.cn/problems/squares-of-a-sorted-array/
 */
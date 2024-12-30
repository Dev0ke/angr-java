public class Solution556 {
    public int nextGreaterElement(int n) {
        char[] chars = String.valueOf(n).toCharArray();

        // Solution31
        int i = chars.length - 2;
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = chars.length - 1;
            while (j >= 0 && chars[i] >= chars[j]) {
                j--;
            }
            swap(chars, i, j);
        } else {
            return -1;
        }
        reverse(chars, i + 1);

        // case to int
        long num = Long.parseLong(new String(chars));
        if (num <= Integer.MAX_VALUE) {
            return (int) num;
        }
        return -1;
    }

    private void swap(char[] nums, int i, int j) {
        char tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(char[] nums, int start) {
        int right = nums.length - 1;
        while (start < right) {
            swap(nums, start, right);
            start++;
            right--;
        }
    }
}
/*
556. 下一个更大元素 III
https://leetcode.cn/problems/next-greater-element-iii/

给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
提示：
1 <= n <= 2^31 - 1

贪心。
时间复杂度 O(n)
空间复杂度 O(n)
相似题目: 31. 下一个排列
https://leetcode.cn/problems/next-permutation/
 */
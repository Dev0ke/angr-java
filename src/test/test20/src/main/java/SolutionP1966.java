import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class SolutionP1966 {
    public int binarySearchableNumbers(int[] nums) {
        int n = nums.length;
        Deque<Integer> st = new ArrayDeque<>();
        for (int v : nums) {
            while (!st.isEmpty() && v < st.peek()) st.pop();
            st.push(v);
        }
        Set<Integer> set = new HashSet<>(st);

        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] > st.peek()) st.pop();
            st.push(nums[i]);
        }

        int ans = 0;
        while (!st.isEmpty()) {
            if (set.contains(st.pop())) ans++;
        }
        return ans;
    }
}
/*
$1966. 未排序数组中的可被二分搜索的数
https://leetcode.cn/problems/binary-searchable-numbers-in-an-unsorted-array/description/

有一个 类似 二分搜索的方法。 这个方法有两个入参: sequence 是一个整数数组， target 是一个整数。 这个方法可以判断 target 是否存在 sequence中。
该方法的伪代码如下：
func(sequence, target)
  while sequence is not empty
    randomly choose an element from sequence as the pivot
    if pivot = target, return true
    else if pivot < target, remove pivot and all elements to its left from the sequence
    else, remove pivot and all elements to its right from the sequence
  end while
  return false
当 sequence 是排好序时, 这个方法对 所有 值都可正常判断。如果 sequence 不是排好序的, 该方法并不是对所有值都可正常判断, 但对一些 值仍可正常判断。
给定一个仅包含不同数字的数组 nums表示 sequence， nums是否排序未知，对于 所有可能的选择, 返回通过这个方法保证能找到的值的数量。
提示:
1 <= nums.length <= 10^5
-10^5 <= nums[i] <= 10^5
nums 中所有值都 不同.
提升: 如果 nums 存在 重复的值, 你会如何修改你的算法吗?

单调栈 + 集合。
时间复杂度 O(n)。
 */
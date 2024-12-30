import java.util.Arrays;

public class Solution75 {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }
}
/*
75. 颜色分类
https://leetcode.cn/problems/sort-colors/

给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
提示：
n == nums.length
1 <= n <= 300
nums[i] 为 0、1 或 2

本题是经典的「荷兰国旗问题」，由计算机科学家 Edsger W. Dijkstra 首先提出。
快速排序。
 */
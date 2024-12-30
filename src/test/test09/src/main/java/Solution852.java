public class Solution852 {
    // 遍历 时间复杂度 O(n)
    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;

        // 枚举 "峰顶"
        for (int top = 1; top <= len - 2; top++) {
            if (arr[top] > arr[top - 1] && arr[top] > arr[top + 1]) {
                return top;
            }
        }
        return -1;
    }

    // 二分查找 时间复杂度 O(logn)
    public int peakIndexInMountainArray2(int[] arr) {
        int len = arr.length;

        int left = 1;
        int right = len - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
/*
852. 山脉数组的峰顶索引
https://leetcode.cn/problems/peak-index-in-a-mountain-array/

第 89 场周赛 T1。

符合下列属性的数组 arr 称为 山脉数组 ：
- arr.length >= 3
- 存在 i（0 < i < arr.length - 1）使得：
  - arr[0] < arr[1] < ... arr[i-1] < arr[i]
  - arr[i] > arr[i+1] > ... > arr[arr.length - 1]
给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
提示：
3 <= arr.length <= 10^4
0 <= arr[i] <= 10^6
题目数据保证 arr 是一个山脉数组
进阶：很容易想到时间复杂度 O(n) 的解决方案，你可以设计一个 O(log(n)) 的解决方案吗？

二分查找。
相似题目: 845. 数组中的最长山脉
https://leetcode.cn/problems/longest-mountain-in-array/
1095. 山脉数组中查找目标值
https://leetcode.cn/problems/find-in-mountain-array/
 */
public class Solution845 {
    // 时间复杂度 O(n) 枚举山脚
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int l = 0;
        while (l + 2 < n) {
            int r = l + 1;
            if (arr[l] < arr[l + 1]) {
                while (r + 1 < n && arr[r] < arr[r + 1]) {
                    r++;
                }
                if (r + 1 < n && arr[r] > arr[r + 1]) {
                    while (r + 1 < n && arr[r] > arr[r + 1]) {
                        r++;
                    }
                    ans = Math.max(ans, r - l + 1);
                } else {
                    r++;
                }
            }
            l = r;
        }
        return ans;
    }
}
/*
845. 数组中的最长山脉
https://leetcode.cn/problems/longest-mountain-in-array/

第 87 场周赛 T2。

把符合下列属性的数组 arr 称为 山脉数组 ：
- arr.length >= 3
- 存在下标 i（0 < i < arr.length - 1），满足
  - arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
  - arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
给出一个整数数组 arr，返回最长山脉子数组的长度。如果不存在山脉子数组，返回 0 。
提示：
1 <= arr.length <= 10^4
0 <= arr[i] <= 10^4
进阶：
你可以仅用一趟扫描解决此问题吗？
你可以用 O(1) 空间解决此问题吗？

双指针。枚举山脚，右指针指向下一个山脚
时间复杂度 O(n)
 */

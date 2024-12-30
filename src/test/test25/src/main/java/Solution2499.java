public class Solution2499 {
    public long minimumTotalCost(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int swapCnt = 0;
        int modeCnt = 0;
        // 众数
        int mode = 0;

        long res = 0L;
        int[] cntArr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int x = nums1[i];
            if (x == nums2[i]) {
                res += i;
                swapCnt++;
                cntArr[x]++;
                if (modeCnt < cntArr[x]) {
                    modeCnt = cntArr[x];
                    mode = x;
                }
            }
        }

        for (int i = 0; i < n && modeCnt * 2 > swapCnt; i++) {
            int x = nums1[i];
            int y = nums2[i];
            if (x != y && x != mode && y != mode) {
                res += i;
                swapCnt++;
            }
        }

        return (modeCnt * 2 > swapCnt) ? -1 : res;
    }
}
/*
2499. 让数组不相等的最小总代价
https://leetcode.cn/problems/minimum-total-cost-to-make-arrays-unequal/

第 93 场双周赛 T3。

给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，两者长度都为 n 。
每次操作中，你可以选择交换 nums1 中任意两个下标处的值。操作的 开销 为两个下标的 和 。
你的目标是对于所有的 0 <= i <= n - 1 ，都满足 nums1[i] != nums2[i] ，你可以进行 任意次 操作，请你返回达到这个目标的 最小 总代价。
请你返回让 nums1 和 nums2 满足上述条件的 最小总代价 ，如果无法达成目标，返回 -1 。
提示：
n == nums1.length == nums2.length
1 <= n <= 10^5
1 <= nums1[i], nums2[i] <= n
 */
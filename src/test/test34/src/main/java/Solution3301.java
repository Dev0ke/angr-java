import java.util.Arrays;

public class Solution3301 {
    public long maximumTotalSum(int[] maximumHeight) {
        int n = maximumHeight.length;
        reverseSort(maximumHeight);
        int pre = maximumHeight[0];
        long ans = pre;
        for (int i = 1; i < n; i++) {
            int hi = maximumHeight[i];
            if (hi >= pre) {
                hi = pre - 1;
                if (hi <= 0) return -1;
            }
            ans += hi;
            pre = hi;
        }
        return ans;
    }

    private void reverseSort(int[] a) {
        Arrays.sort(a);
        for (int l = 0, r = a.length - 1; l < r; l++, r--) {
            int tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;
        }
    }
}
/*
3301. 高度互不相同的最大塔高和
https://leetcode.cn/problems/maximize-the-total-height-of-unique-towers/description/

第 140 场双周赛 T2。

给你一个数组 maximumHeight ，其中 maximumHeight[i] 表示第 i 座塔可以达到的 最大 高度。
你的任务是给每一座塔分别设置一个高度，使得：
1.第 i 座塔的高度是一个正整数，且不超过 maximumHeight[i] 。
2.所有塔的高度互不相同。
请你返回设置完所有塔的高度后，可以达到的 最大 总高度。如果没有合法的设置，返回 -1 。
提示：
1 <= maximumHeight.length <= 10^5
1 <= maximumHeight[i] <= 10^9

排序后贪心。
时间复杂度 O(nlogn)。
 */
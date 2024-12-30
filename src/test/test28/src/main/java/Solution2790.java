import java.util.Comparator;
import java.util.List;

public class Solution2790 {
    private List<Integer> usageLimits;

    public int maxIncreasingGroups(List<Integer> usageLimits) {
        usageLimits.sort(Comparator.reverseOrder());
        this.usageLimits = usageLimits;

        int left = 0;
        int right = usageLimits.size() + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private boolean checkMid(int mid) {
        int gap = 0;
        for (Integer x : usageLimits) {
            gap = Math.min(gap + x - mid, 0);
            if (mid > 0) {
                mid -= 1;
            }
        }
        return gap == 0;
    }

    // https://www.bilibili.com/video/BV1n8411m7Fs/
    public int maxIncreasingGroups2(List<Integer> usageLimits) {
        int n = usageLimits.size();
        usageLimits.sort(null);
        long sum = 0;
        long k = 0;
        for (int i = 0; i < n; i++) {
            sum += usageLimits.get(i);
            if ((k + 1) * (k + 2) / 2 <= sum) {
                k++;
            }
        }
        return (int) k;
    }
}
/*
2790. 长度递增组的最大数目
https://leetcode.cn/problems/maximum-number-of-groups-with-increasing-length/

第 355 场周赛 T3。

给你一个下标从 0 开始、长度为 n 的数组 usageLimits 。
你的任务是使用从 0 到 n - 1 的数字创建若干组，并确保每个数字 i 在 所有组 中使用的次数总共不超过 usageLimits[i] 次。此外，还必须满足以下条件：
- 每个组必须由 不同 的数字组成，也就是说，单个组内不能存在重复的数字。
- 每个组（除了第一个）的长度必须 严格大于 前一个组。
在满足所有条件的情况下，以整数形式返回可以创建的最大组数。
提示：
1 <= usageLimits.length <= 10^5
1 <= usageLimits[i] <= 10^9

二分答案。但注意这个check函数复杂度不能高于 O(n)
https://leetcode.cn/problems/maximum-number-of-groups-with-increasing-length/solution/pai-xu-er-fen-tu-jie-ban-by-yzq-a-smlx/
也可以参考灵神的 https://www.bilibili.com/video/BV1n8411m7Fs/
 */
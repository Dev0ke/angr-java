import java.util.Arrays;

public class Solution2226 {
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        // 无法保证每个小孩至少能得到 1 颗糖果
        if (sum < k) {
            return 0;
        }

        Arrays.sort(candies);

        int left = 2;
        int right = (int) (sum / k + 1);
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(candies, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private boolean checkMid(int[] candies, long k, int mid) {
        // 贪心，从最大开始
        for (int i = candies.length - 1; i >= 0 && k > 0; i--) {
            int cnt = candies[i] / mid;
            k -= cnt;
        }
        return k <= 0;
    }
}
/*
2226. 每个小孩最多能分到多少糖果
https://leetcode.cn/problems/maximum-candies-allocated-to-k-children/

第 287 场周赛 T3。

给你一个 下标从 0 开始 的整数数组 candies 。数组中的每个元素表示大小为 candies[i] 的一堆糖果。你可以将每堆糖果分成任意数量的 子堆 ，但 无法 再将两堆合并到一起。
另给你一个整数 k 。你需要将这些糖果分配给 k 个小孩，使每个小孩分到 相同 数量的糖果。每个小孩可以拿走 至多一堆 糖果，有些糖果可能会不被分配。
返回每个小孩可以拿走的 最大糖果数目 。
提示：
1 <= candies.length <= 10^5
1 <= candies[i] <= 10^7
1 <= k <= 10^12

假设 每个小孩可以拿走的 糖果数目 为 k，那么肯定也能拿走 k-1 颗糖果，结果存在单调性，可使用二分查找解决。
时间复杂度 O(nlogn)
 */
import java.util.Arrays;

public class Solution1889 {
    private static final long MOD = 1000000007;

    public int minWastedSpace(int[] packages, int[][] boxes) {
        int len = packages.length;
        // 升序
        Arrays.sort(packages);

        // 包裹尺寸和
        long sum = Arrays.stream(packages).asLongStream().sum();

        long min = Long.MAX_VALUE;
        for (int[] box : boxes) {
            int n = box.length;
            // 升序
            Arrays.sort(box);

            // 最大的箱子装不下最大的包裹，下一个供应商
            if (box[n - 1] < packages[len - 1]) {
                continue;
            }

            int packageI = 0;
            long wasteSum = 0;
            for (int j = 0; j < n && packageI < len; j++) {
                if (box[j] < packages[packageI]) {
                    continue;
                }

                int packageJ = binarySearchLeftBound(packages, box[j]);
                wasteSum += (long) (packageJ - packageI) * box[j];
                packageI = packageJ;
            }
            min = Math.min(min, wasteSum - sum);
        }
        return min == Long.MAX_VALUE ? -1 : (int) (min % MOD);
    }

    // packages 中第一个大于 target 的下标
    private int binarySearchLeftBound(int[] packages, int target) {
        int left = 0;
        int right = packages.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (packages[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
/*
1889. 装包裹的最小浪费空间
https://leetcode.cn/problems/minimum-space-wasted-from-packaging/

给你 n 个包裹，你需要把它们装在箱子里，每个箱子装一个包裹。总共有 m 个供应商提供 不同尺寸 的箱子（每个规格都有无数个箱子）。
如果一个包裹的尺寸 小于等于 一个箱子的尺寸，那么这个包裹就可以放入这个箱子之中。
包裹的尺寸用一个整数数组 packages 表示，其中 packages[i] 是第 i 个包裹的尺寸。供应商用二维数组 boxes 表示，其中 boxes[j] 是第 j 个供应商提供的所有箱子尺寸的数组。
你想要选择 一个供应商 并只使用该供应商提供的箱子，使得 总浪费空间最小 。
对于每个装了包裹的箱子，我们定义 浪费的 空间等于 箱子的尺寸 - 包裹的尺寸 。总浪费空间 为 所有 箱子中浪费空间的总和。
- 比方说，如果你想要用尺寸数组为 [4,8] 的箱子装下尺寸为 [2,3,5] 的包裹，你可以将尺寸为 2 和 3 的两个包裹装入两个尺寸为 4 的箱子中，
同时把尺寸为 5 的包裹装入尺寸为 8 的箱子中。总浪费空间为 (4-2) + (4-3) + (8-5) = 6 。
请你选择 最优 箱子供应商，使得 总浪费空间最小 。如果 无法 将所有包裹放入箱子中，请你返回 -1 。由于答案可能会 很大 ，请返回它对 10^9 + 7 取余 的结果。
提示：
n == packages.length
m == boxes.length
1 <= n <= 10^5
1 <= m <= 10^5
1 <= packages[i] <= 10^5
1 <= boxes[j].length <= 10^5
1 <= boxes[j][k] <= 10^5
sum(boxes[j].length) <= 10^5
boxes[j] 中的元素 互不相同 。

二分
与其遍历每一个「包裹」选择「箱子」，我们不如遍历每一个「箱子」并匹配「包裹」。
 */
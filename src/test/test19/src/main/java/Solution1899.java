public class Solution1899 {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int ai = target[0], bi = target[1], ci = target[2];

        int maxa = 0, maxb = 0, maxc = 0;
        for (int[] triplet : triplets) {
            if (triplet[0] <= ai && triplet[1] <= bi && triplet[2] <= ci) {
                maxa = Math.max(maxa, triplet[0]);
                maxb = Math.max(maxb, triplet[1]);
                maxc = Math.max(maxc, triplet[2]);
            }
        }
        return maxa == ai && maxb == bi && maxc == ci;
    }
}
/*
1899. 合并若干三元组以形成目标三元组
https://leetcode.cn/problems/merge-triplets-to-form-target-triplet/

三元组 是一个由三个整数组成的数组。给你一个二维整数数组 triplets ，其中 triplets[i] = [ai, bi, ci] 表示第 i 个 三元组 。同时，给你一个整数数组 target = [x, y, z] ，表示你想要得到的 三元组 。
为了得到 target ，你需要对 triplets 执行下面的操作 任意次（可能 零 次）：
- 选出两个下标（下标 从 0 开始 计数）i 和 j（i != j），并 更新 triplets[j] 为 [max(ai, aj), max(bi, bj), max(ci, cj)] 。
  - 例如，triplets[i] = [2, 5, 3] 且 triplets[j] = [1, 7, 5]，triplets[j] 将会更新为 [max(2, 1), max(5, 7), max(3, 5)] = [2, 7, 5] 。
如果通过以上操作我们可以使得目标 三元组 target 成为 triplets 的一个 元素 ，则返回 true ；否则，返回 false 。
提示：
1 <= triplets.length <= 10^5
triplets[i].length == target.length == 3
1 <= ai, bi, ci, x, y, z <= 1000

贪心。由于只取 max 值，因此只有超过 target 的数会影响结果。将剩余的数合并，如果能刚好等于目标三元组，则成立。
时间复杂度 O(n)
空间复杂度 O(1)
 */
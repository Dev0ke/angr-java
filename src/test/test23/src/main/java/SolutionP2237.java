public class SolutionP2237 {
    public int meetRequirement(int n, int[][] lights, int[] requirement) {
        int[] diff = new int[n + 1];
        for (int[] l : lights) {
            int p = l[0], r = l[1];
            diff[Math.max(0, p - r)] += 1;
            diff[Math.min(n, p + r + 1)] -= 1;
        }
        int ans = 0, cur = 0;
        for (int i = 0; i < n; i++) {
            int r = requirement[i], d = diff[i];
            cur += d;
            ans += cur >= r ? 1 : 0;
        }
        return ans;
    }
}
/*
$2237. 计算街道上满足所需亮度的位置数量
https://leetcode.cn/problems/count-positions-on-street-with-required-brightness/description/

给你一个整数 n。一条完全笔直的街道用一条从 0 到 n - 1 的数轴表示。给你一个二维整数数组 lights，表示街道上的路灯。每个 lights[i] = [positioni, rangei] 表示在位置 positioni 有一盏路灯，从 [max(0, positioni - rangei), min(n - 1, positioni + rangei)] (包含边界) 开始照亮该区域。
位置 p 的 亮度 定义为点亮位置 p 的路灯的数量。给定一个大小为 n 的整数数组 requirement，数组的 下标从 0 开始，其中 requirement[i] 是街道上第 i 个位置的最小 亮度。
返回街道上 0 到 n - 1 之间 亮度至少满足 requirement[i] 的位置 i 的数量。
提示:
1 <= n <= 10^5
1 <= lights.length <= 10^5
0 <= positioni < n
0 <= rangei <= 10^5
requirement.length == n
0 <= requirement[i] <= 10^5

差分数组。
https://leetcode.cn/problems/count-positions-on-street-with-required-brightness/solutions/
 */
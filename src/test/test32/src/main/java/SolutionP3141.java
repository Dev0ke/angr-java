import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class SolutionP3141 {
    public int[] maxHammingDistances(int[] nums, int m) {
        int full = (1 << m) - 1;
        int[] dist = new int[full + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Integer> q = new ArrayDeque<>();
        for (int num : nums) {
            if (dist[num] > 0) {
                dist[num] = 0;
                q.add(num);
            }
        }
        while (!q.isEmpty()) {
            int num = q.remove();
            for (int i = 0; i < m; i++) {
                int next = num ^ (1 << i);
                if (dist[next] > dist[num] + 1) {
                    dist[next] = dist[num] + 1;
                    q.add(next);
                }
            }
        }
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = m - dist[nums[i] ^ full];
        }
        return ans;
    }
}
/*
$3141. 最大汉明距离
https://leetcode.cn/problems/maximum-hamming-distances/description/

给定一个数组 nums 和一个整数 m，每个元素 nums[i] 满足 0 <= nums[i] < 2m，返回数组 answer。answer 数组应该与 nums  有相同的长度，每个元素 answer[i] 表示 nums[i] 和数组中其它任何元素 nums[j] 的最大 汉明距离。
两个二进制整数之间的 汉明距离 定义为对应位上二进制位不同的数量（如果需要，添加前置零）。
提示：
1 <= m <= 17
2 <= nums.length <= 2^m
0 <= nums[i] < 2^m

BFS。
计算 full 和数组中的其他元素的最小汉明距离 distance，则 num 和数组中的其他元素的最大汉明距离等于 m−distance。
时间复杂度 O(2^m * m)。
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1787 {
    // x 的范围为 [0, 2^10)
    private static final int C = 1 << 10;
    private static final int INF = (int) 1e9;

    public int minChanges(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[C];
        // f(-1, 0) = 0
        Arrays.fill(f, INF);
        f[0] = 0;

        for (int i = 0; i < k; i++) {
            // 第 i 个组的哈希映射
            Map<Integer, Integer> cnt = new HashMap<>();
            int size = 0;
            for (int j = i; j < n; j += k) {
                cnt.merge(nums[j], 1, Integer::sum);
                size++;
            }

            // 求出 t2
            int t2min = Arrays.stream(f).min().orElseThrow();
            int[] g = new int[C];
            Arrays.fill(g, t2min);
            for (int mask = 0; mask < C; mask++) {
                // t1 则需要枚举 x 才能求出
                for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                    int x = entry.getKey(), cnt_x = entry.getValue();
                    g[mask] = Math.min(g[mask], f[mask ^ x] - cnt_x);
                }
            }

            // 别忘了加上 size
            for (int j = 0; j < C; j++) {
                g[j] += size;
            }
            f = g;
        }
        return f[0];
    }
}
/*
1787. 使所有区间的异或结果为零
https://leetcode.cn/problems/make-the-xor-of-all-segments-equal-to-zero/description/

给你一个整数数组 nums 和一个整数 k 。区间 [left, right]（left <= right）的 异或结果 是对下标位于 left 和 right（包括 left 和 right ）之间所有元素进行 XOR 运算的结果：nums[left] XOR nums[left+1] XOR ... XOR nums[right] 。
返回数组中 要更改的最小元素数 ，以使所有长度为 k 的区间异或结果等于零。
提示：
1 <= k <= nums.length <= 2000
0 <= nums[i] < 2^10

动态规划。
答案数组必然是每 k 个一组进行重复的。
时间复杂度 O(2^C * k + n)。其中 2^C = 1024。
 */
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution2818 {
    private static final int MOD = (int) (1e9 + 7);
    private static final int MX = (int) (1e5 + 1);
    private static final int[] omega = new int[MX];

    static {
        // O(MX * loglogMX)
        for (int i = 2; i < MX; i++) {
            // i 是质数
            if (omega[i] == 0) {
                for (int j = i; j < MX; j += i) {
                    // i 是 j 的一个质因子
                    omega[j]++;
                }
            }
        }
    }

    public int maximumScore(List<Integer> nums, int k) {
        // 1、预处理 不同质因子的数目 omega
        // 2、如果 k=1，应该选哪个子数组？
        // 3、右边的质数分数【更大】的最近数的下标 left[i]
        // 左边的质数分数【大于等于】 b[i] 的最近数的下标 right[i]
        // 子数组个数 tot = (i - left[i]) * (right[i] - i)
        // 从大到小遍历 nums[i]
        // 贡献 nums[i] ^ min(k, tot)
        int n = nums.size();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nums.get(i);
        }

        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1);
        for (int i = 0; i < n; i++) {
            while (st.size() > 1 && omega[a[st.peek()]] < omega[a[i]]) {
                right[st.pop()] = i;
            }
            left[i] = st.peek();
            st.push(i);
        }

        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, (o1, o2) -> Integer.compare(a[o2], a[o1]));

        long ans = 1;
        for (Integer i : ids) {
            long tot = (long) (i - left[i]) * (right[i] - i);
            if (tot >= k) {
                ans = ans * quickPow(a[i], k) % MOD;
                break;
            }
            ans = ans * quickPow(a[i], tot) % MOD;
            k -= (int) tot;
        }
        return (int) ans;
    }

    // 模下的 a^b
    private long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
2818. 操作使得分最大
https://leetcode.cn/problems/apply-operations-to-maximize-score/

第 358 场周赛 T4。

给你一个长度为 n 的正整数数组 nums 和一个整数 k 。
一开始，你的分数为 1 。你可以进行以下操作至多 k 次，目标是使你的分数最大：
- 选择一个之前没有选过的 非空 子数组 nums[l, ..., r] 。
- 从 nums[l, ..., r] 里面选择一个 质数分数 最高的元素 x 。如果多个元素质数分数相同且最高，选择下标最小的一个。
- 将你的分数乘以 x 。
nums[l, ..., r] 表示 nums 中起始下标为 l ，结束下标为 r 的子数组，两个端点都包含。
一个整数的 质数分数 等于 x 不同质因子的数目。比方说， 300 的质数分数为 3 ，因为 300 = 2 * 2 * 3 * 5 * 5 。
请你返回进行至多 k 次操作后，可以得到的 最大分数 。
由于答案可能很大，请你将结果对 10^9 + 7 取余后返回。
提示：
1 <= nums.length == n <= 10^5
1 <= nums[i] <= 10^5
1 <= k <= min(n * (n + 1) / 2, 10^9)

分解质因数 + 单调栈 + 计算贡献
 */
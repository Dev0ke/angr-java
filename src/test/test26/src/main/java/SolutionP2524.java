import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class SolutionP2524 {
    private static final int MOD = (int) (1e9 + 7);

    public int maxFrequencyScore(int[] nums, int k) {
        int ans = 0;
        long score = 0;
        Map<Integer, Deque<Integer>> stMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int x = nums[i];
            if (!stMap.containsKey(x)) {
                score += x;
                Deque<Integer> st = new ArrayDeque<>();
                st.push(x);
                stMap.put(x, st);
            } else {
                Deque<Integer> st = stMap.get(x);
                long last = st.peek(), cur = last * x % MOD;
                score += cur - last;
                st.push((int) cur);
            }
            if (i >= k - 1) {
                ans = Math.max(ans, (int) ((score % MOD + MOD) % MOD));
                x = nums[i - k + 1];
                Deque<Integer> st = stMap.get(x);
                score -= st.pop();
                if (st.isEmpty()) stMap.remove(x);
                else score += st.peek();
            }
        }
        return ans;
    }
}
/*
$2524. 子数组的最大频率分数
https://leetcode.cn/problems/maximum-frequency-score-of-a-subarray/description/

给定一个整数数组 nums 和一个 正 整数 k 。
数组的 频率得分 是数组中 不同 值的 幂次 之和，并将和对 10^9 + 7 取模。
例如，数组 [5,4,5,7,4,4] 的频率得分为 (43 + 52 + 71) modulo (10^9 + 7) = 96 。
返回 nums 中长度为 k 的 子数组 的 最大 频率得分。你需要返回取模后的最大值，而不是实际值。
子数组 是一个数组的连续部分。
提示：
1 <= k <= nums.length <= 10^5
1 <= nums[i] <= 10^6

https://leetcode.cn/problems/maximum-frequency-score-of-a-subarray/solutions/2088763/xian-xing-zuo-fa-bu-yong-kuai-su-mi-pyth-bqhe/
本题是一个长度固定为 k 的滑动窗口题。
对每个 x=nums[i] 创建一个栈，每遇到一个 x 就把 x 与栈顶的乘积入栈，滑出窗口时同理。这样就可以 O(1) 地计算分数的变化量了。
 */
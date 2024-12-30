import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2910 {
    private static final int INF = (int) 1e9;
    private int[] cnt;

    public int minGroupsForValidAssignment(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int x : nums) {
            cntMap.put(x, cntMap.getOrDefault(x, 0) + 1);
        }
        cnt = cntMap.values().stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(cnt);

        int ans = INF;
        for (int i = 0; i <= cnt[0]; i++) {
            ans = Math.min(ans, getAns(i));
        }
        return ans;
    }

    private int getAns(int i) {
        int[] sz = new int[]{i, i + 1};
        int ans = 0;
        for (int v : cnt) {
            int c = (v + sz[1] - 1) / sz[1];
            if (v >= c * sz[0] && v <= c * sz[1]) {
                ans += c;
            } else {
                ans = INF;
                break;
            }
        }
        return ans;
    }
}
/*
2910. 合法分组的最少组数
https://leetcode.cn/problems/minimum-number-of-groups-to-create-a-valid-assignment/description/

第 368 场周赛 T3。

给你一个长度为 n 下标从 0 开始的整数数组 nums 。
我们想将下标进行分组，使得 [0, n - 1] 内所有下标 i 都 恰好 被分到其中一组。
如果以下条件成立，我们说这个分组方案是合法的：
- 对于每个组 g ，同一组内所有下标在 nums 中对应的数值都相等。
- 对于任意两个组 g1 和 g2 ，两个组中 下标数量 的 差值不超过 1 。
请你返回一个整数，表示得到一个合法分组方案的 最少 组数。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

枚举，每次枚举 组内数量下限 i，上限 i+1
时间复杂度 O(n)
空间复杂度 O(n)
 */
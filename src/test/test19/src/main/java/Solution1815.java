import java.util.HashMap;
import java.util.Map;

public class Solution1815 {
    private int m;
    private int[] val;
    private Map<Integer, Integer> memo;

    // https://leetcode.cn/problems/maximum-number-of-groups-getting-fresh-donuts/solutions/2072545/by-endlesscheng-r5ve
    public int maxHappyGroups(int batchSize, int[] groups) {
        m = batchSize;
        int ans = 0;
        int[] cnt = new int[m];
        for (int x : groups) {
            x %= m;
            // 把 0 排在前面后。剩下的顾客，尽可能地两两一对安排，每一对中都有一批开心的顾客。
            if (x == 0) {
                ans++;
            } else if (cnt[m - x] > 0) {
                // 可以配对
                cnt[m - x]--;
                ans++;
            } else {
                cnt[x]++;
            }
        }

        // m 最大取到 9，剩余没有配对的顾客，至多有 4 种
        // 高 4 位：left，低 20 位（每 5 位）：剩余未安排的顾客个数 cnt
        int mask = 0;
        int n = 0;
        for (int c : cnt) {
            if (c > 0) n++;
        }
        val = new int[n];
        memo = new HashMap<>();
        for (int x = 1; x < m; x++) {
            if (cnt[x] > 0) {
                // val 越靠后的，在 mask 中的比特位越高
                val[--n] = x;
                mask = mask << 5 | cnt[x];
            }
        }
        return ans + dfs(mask);
    }

    private int dfs(int mask) {
        if (memo.containsKey(mask)) {
            return memo.get(mask);
        }
        int res = 0;
        int left = mask >> 20;
        int msk = mask & ((1 << 20) - 1);
        for (int i = 0, j = 0; i < val.length; i++, j += 5) {
            // 31 = 0b11111
            if ((msk >> j & 31) > 0) {
                // cnt[val[i]] > 0
                int newLeft = (left + val[i]) % m << 20;
                int newMask = newLeft | msk - (1 << j);
                res = Math.max(res, (left == 0 ? 1 : 0) + dfs(newMask));
            }
        }
        memo.put(mask, res);
        return res;
    }
}
/*
1815. 得到新鲜甜甜圈的最多组数
https://leetcode.cn/problems/maximum-number-of-groups-getting-fresh-donuts/description/

有一个甜甜圈商店，每批次都烤 batchSize 个甜甜圈。这个店铺有个规则，就是在烤一批新的甜甜圈时，之前 所有 甜甜圈都必须已经全部销售完毕。给你一个整数 batchSize 和一个整数数组 groups ，数组中的每个整数都代表一批前来购买甜甜圈的顾客，其中 groups[i] 表示这一批顾客的人数。每一位顾客都恰好只要一个甜甜圈。
当有一批顾客来到商店时，他们所有人都必须在下一批顾客来之前购买完甜甜圈。如果一批顾客中第一位顾客得到的甜甜圈不是上一组剩下的，那么这一组人都会很开心。
你可以随意安排每批顾客到来的顺序。请你返回在此前提下，最多 有多少组人会感到开心。
提示：
1 <= batchSize <= 9
1 <= groups.length <= 30
1 <= groups[i] <= 10^9

记忆化搜索 + 状态压缩
 */
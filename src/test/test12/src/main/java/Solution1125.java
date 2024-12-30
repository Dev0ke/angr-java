import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1125 {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int m = req_skills.length;
        int n = people.size();

        // 0 ~ m 项技能
        Map<String, Integer> skillIdxMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            skillIdxMap.put(req_skills[i], i);
        }

        // 0 ~ n 个人
        int[] peopleMask = new int[n];
        for (int i = 0; i < n; i++) {
            for (String x : people.get(i)) {
                peopleMask[i] |= (1 << skillIdxMap.get(x));
            }
        }

        // dp[mask] 技能为 mask 时，最佳方案为 dp[mask]，人数为 Long.bitCount(dp[mask])
        long[] dp = new long[1 << m];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int mask = (1 << m) - 1; mask >= 0; mask--) {
                // 不可达
                if (dp[mask] == -1) {
                    continue;
                }
                int nextMask = mask | peopleMask[i];
                if (dp[nextMask] == -1
                        || Long.bitCount(dp[nextMask]) > Long.bitCount(dp[mask]) + 1) {
                    dp[nextMask] = dp[mask] | (1L << i);
                }
            }
        }

        long resState = dp[(1 << m) - 1];
        List<Integer> resList = new ArrayList<>();
        for (int k = 0; k < n; k++) {
            if (((resState >> k) & 1) == 1) {
                resList.add(k);
            }
        }
        return resList.stream().mapToInt(i -> i).toArray();
    }

    private int m;
    private int n;
    private int[] peopleMask;
    private long[] memo;

    // 记忆化搜索
    public int[] smallestSufficientTeam2(String[] req_skills, List<List<String>> people) {
        m = req_skills.length;
        n = people.size();

        // 0 ~ m 项技能
        Map<String, Integer> skillIdxMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            skillIdxMap.put(req_skills[i], i);
        }

        // 0 ~ n 个人
        peopleMask = new int[n];
        for (int i = 0; i < n; i++) {
            for (String x : people.get(i)) {
                peopleMask[i] |= (1 << skillIdxMap.get(x));
            }
        }

        memo = new long[1 << m];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        long resState = dp((1 << m) - 1);

        // => int[]
        List<Integer> resList = new ArrayList<>();
        for (int k = 0; k < n; k++) {
            if (((resState >> k) & 1) == 1) {
                resList.add(k);
            }
        }
        return resList.stream().mapToInt(i -> i).toArray();
    }

    // dp[mask] 技能为 mask 时，方案为 dp[mask]，人数为 Long.bitCount(dp[mask])
    private long dp(int mask) {
        if (memo[mask] != -1) {
            return memo[mask];
        }

        int min = n;
        long minMask = (1L << n) - 1;
        for (int i = 0; i < n; i++) {
            int x = peopleMask[i];
            int left = mask;
            for (int k = 0; k < m; k++) {
                if (((mask >> k) & 1) == 1 && ((x >> k) & 1) == 1) {
                    left = left ^ (1 << k);
                }
            }
            if (left < mask) {
                long dpLeft = dp(left);
                if (min > Long.bitCount(dpLeft) + 1) {
                    min = Long.bitCount(dpLeft) + 1;
                    minMask = dpLeft | (1L << i);
                }
            }
        }
        memo[mask] = minMask;
        return minMask;
    }
}
/*
1125. 最小的必要团队
https://leetcode.cn/problems/smallest-sufficient-team/

作为项目经理，你规划了一份需求的技能清单 req_skills，并打算从备选人员名单 people 中选出些人组成一个「必要团队」（ 编号为 i 的备选人员 people[i] 含有一份该备选人员掌握的技能列表）。
所谓「必要团队」，就是在这个团队中，对于所需求的技能列表 req_skills 中列出的每项技能，团队中至少有一名成员已经掌握。可以用每个人的编号来表示团队中的成员：
- 例如，团队 team = [0, 1, 3] 表示掌握技能分别为 people[0]，people[1]，和 people[3] 的备选人员。
请你返回 任一 规模最小的必要团队，团队成员用人员编号表示。你可以按 任意顺序 返回答案，题目数据保证答案存在。
提示：
1 <= req_skills.length <= 16
1 <= req_skills[i].length <= 16
req_skills[i] 由小写英文字母组成
req_skills 中的所有字符串 互不相同
1 <= people.length <= 60
0 <= people[i].length <= 16
1 <= people[i][j].length <= 16
people[i][j] 由小写英文字母组成
people[i] 中的所有字符串 互不相同
people[i] 中的每个技能是 req_skills 中的技能
题目数据保证「必要团队」一定存在

状态压缩动态规划
记忆化搜索
时间复杂度 O(n*2^m)
相似题目: 691. 贴纸拼词
https://leetcode.cn/problems/stickers-to-spell-word/
 */
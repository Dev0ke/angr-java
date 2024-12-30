import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution2225 {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> players = new HashSet<>();
        // 入度
        Map<Integer, Integer> deg = new HashMap<>();
        for (int[] match : matches) {
            int u = match[0];
            int v = match[1];
            deg.put(v, deg.getOrDefault(v, 0) + 1);
            players.add(u);
            players.add(v);
        }

        // 统计入度
        List<Integer> answer0 = new ArrayList<>();
        List<Integer> answer1 = new ArrayList<>();
        for (int player : players) {
            int inDegree = deg.getOrDefault(player, 0);
            if (inDegree == 0) {
                answer0.add(player);
            } else if (inDegree == 1) {
                answer1.add(player);
            }
        }
        Collections.sort(answer0);
        Collections.sort(answer1);
        return Arrays.asList(answer0, answer1);
    }
}
/*
2225. 找出输掉零场或一场比赛的玩家
https://leetcode.cn/problems/find-players-with-zero-or-one-losses/

第 287 场周赛 T2。

给你一个整数数组 matches 其中 matches[i] = [winneri, loseri] 表示在一场比赛中 winneri 击败了 loseri 。
返回一个长度为 2 的列表 answer ：
- answer[0] 是所有 没有 输掉任何比赛的玩家列表。
- answer[1] 是所有恰好输掉 一场 比赛的玩家列表。
两个列表中的值都应该按 递增 顺序返回。
注意：
- 只考虑那些参与 至少一场 比赛的玩家。
- 生成的测试用例保证 不存在 两场比赛结果 相同 。
提示：
1 <= matches.length <= 10^5
matches[i].length == 2
1 <= winneri, loseri <= 10^5
winneri != loseri
所有 matches[i] 互不相同

图论知识，matches[i] = [winneri, loseri] 看作是 winneri 到 loseri 的一条有向边
answer[0] 是所有 没有 输掉任何比赛的玩家列表。 即入度为 0
answer[1] 是所有恰好输掉 一场 比赛的玩家列表。 即入度为 1
 */
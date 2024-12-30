import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SolutionP1244 {
    static class Leaderboard {
        // score playerIds
        private final TreeMap<Integer, Set<Integer>> treeMap;
        // playerId score
        private final Map<Integer, Integer> hashMap;

        public Leaderboard() {
            treeMap = new TreeMap<>(Comparator.reverseOrder());
            hashMap = new HashMap<>();
        }

        public void addScore(int playerId, int score) {
            if (hashMap.containsKey(playerId)) {
                int oldScore = hashMap.get(playerId);
                int newScore = oldScore + score;
                treeMap.get(oldScore).remove(playerId);
                treeMap.computeIfAbsent(newScore, key -> new HashSet<>()).add(playerId);
                hashMap.put(playerId, newScore);
            } else {
                treeMap.computeIfAbsent(score, key -> new HashSet<>()).add(playerId);
                hashMap.put(playerId, score);
            }
        }

        public int top(int K) {
            int sum = 0;
            for (Map.Entry<Integer, Set<Integer>> entry : treeMap.entrySet()) {
                sum += entry.getKey() * Math.min(K, entry.getValue().size());
                K -= entry.getValue().size();
                if (K <= 0) {
                    break;
                }
            }
            return sum;
        }

        public void reset(int playerId) {
            int score = hashMap.get(playerId);
            hashMap.remove(playerId);
            treeMap.get(score).remove(playerId);
        }
    }
}
/*
$1244. 力扣排行榜
https://leetcode.cn/problems/design-a-leaderboard/

新一轮的「力扣杯」编程大赛即将启动，为了动态显示参赛者的得分数据，需要设计一个排行榜 Leaderboard。
请你帮忙来设计这个 Leaderboard 类，使得它有如下 3 个函数：
1.addScore(playerId, score)：
 - 假如参赛者已经在排行榜上，就给他的当前得分增加 score 点分值并更新排行。
 - 假如该参赛者不在排行榜上，就把他添加到榜单上，并且将分数设置为 score。
2.top(K)：返回前 K 名参赛者的 得分总和。
3.reset(playerId)：将指定参赛者的成绩清零（换句话说，将其从排行榜中删除）。题目保证在调用此函数前，该参赛者已有成绩，并且在榜单上。
请注意，在初始状态下，排行榜是空的。
提示：
1 <= playerId, K <= 10000
题目保证 K 小于或等于当前参赛者的数量
1 <= score <= 100
最多进行 1000 次函数调用

HashMap + TreeMap 模拟。
相似题目: 2034. 股票价格波动
https://leetcode.cn/problems/stock-price-fluctuation/
 */
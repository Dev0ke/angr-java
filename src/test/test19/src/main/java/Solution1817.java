import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> mp = new HashMap<>();
        for (int[] p : logs) {
            int id = p[0], time = p[1];
            mp.computeIfAbsent(id, e -> new HashSet<>()).add(time);
        }
        int[] ans = new int[k];
        for (Set<Integer> minutes : mp.values()) {
            ans[minutes.size() - 1]++;
        }
        return ans;
    }
}
/*
1817. 查找用户活跃分钟数
https://leetcode.cn/problems/finding-the-users-active-minutes/description/

给你用户在 LeetCode 的操作日志，和一个整数 k 。日志用一个二维整数数组 logs 表示，其中每个 logs[i] = [IDi, timei] 表示 ID 为 IDi 的用户在 timei 分钟时执行了某个操作。
多个用户 可以同时执行操作，单个用户可以在同一分钟内执行 多个操作 。
指定用户的 用户活跃分钟数（user active minutes，UAM） 定义为用户对 LeetCode 执行操作的 唯一分钟数 。 即使一分钟内执行多个操作，也只能按一分钟计数。
请你统计用户活跃分钟数的分布情况，统计结果是一个长度为 k 且 下标从 1 开始计数 的数组 answer ，对于每个 j（1 <= j <= k），answer[j] 表示 用户活跃分钟数 等于 j 的用户数。
返回上面描述的答案数组 answer 。
提示：
1 <= logs.length <= 10^4
0 <= IDi <= 10^9
1 <= timei <= 10^5
k 的取值范围是 [用户的最大用户活跃分钟数, 10^5]

哈希表。
时间复杂度 O(n + k)。
 */
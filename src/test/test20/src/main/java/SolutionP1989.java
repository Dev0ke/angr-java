public class SolutionP1989 {
    public int catchMaximumAmountofPeople(int[] team, int dist) {
        int len = team.length;
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < len) {
            if (team[right] == 1) {
                left = Math.max(left, right - dist);
                while (left < len && left <= right + dist && team[left] == 1) {
                    left++;
                }
                if (left < len && left <= right + dist) {
                    left++;
                    res++;
                }
            }
            right++;
        }
        return res;
    }
}
/*
$1989. 捉迷藏中可捕获的最大人数
https://leetcode.cn/problems/maximum-number-of-people-that-can-be-caught-in-tag/

你正在和你的朋友玩捉迷藏游戏。在捉迷藏比赛中，人们被分成两组：是 “鬼” 的人，和不是 “鬼” 的人。是 “鬼” 的人想要抓住尽可能多的不是 “鬼” 的人。
给定一个 从 0 开始建立索引 的整数数组 team，其中只包含 0 (表示 不是 “鬼” 的人) 和 1 (表示是 “鬼” 的人)，以及一个整数 dist。索引 i 为 “鬼” 的人可以捕获索引在 [i - dist, i + dist](包括) 范围内且 不是 “鬼” 的任何一个人。
返回 “鬼” 所能捕获的最大人数。
提示:
1 <= team.length <= 105
0 <= team[i] <= 1
1 <= dist <= team.length

很多 0 找 1。（误
抓人游戏，1 抓 0，每个 1 只能抓 1 个 0，且只能抓以它为中心 [i - dist, i + dist] 范围内的 0，问队伍 1 抓 0 的最优解。
双指针。
 */
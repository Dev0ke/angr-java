import java.util.Arrays;

public class Solution2491 {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        Arrays.sort(skill);
        int sum = skill[0] + skill[n - 1];
        long res = 0L;
        for (int i = 0; i < n / 2; i++) {
            if (skill[i] + skill[n - 1 - i] == sum) {
                res += (long) skill[i] * skill[n - 1 - i];
            } else {
                return -1;
            }
        }
        return res;
    }
}
/*
2491. 划分技能点相等的团队
https://leetcode.cn/problems/divide-players-into-teams-of-equal-skill/

第 322 场周赛 T2。

给你一个正整数数组 skill ，数组长度为 偶数 n ，其中 skill[i] 表示第 i 个玩家的技能点。将所有玩家分成 n / 2 个 2 人团队，使每一个团队的技能点之和 相等 。
团队的 化学反应 等于团队中玩家的技能点 乘积 。
返回所有团队的 化学反应 之和，如果无法使每个团队的技能点之和相等，则返回 -1 。
提示：
2 <= skill.length <= 10^5
skill.length 是偶数
1 <= skill[i] <= 1000

排序后 判断每对 最小+最大。
时间复杂度 O(nlogn)
 */
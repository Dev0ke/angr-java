import java.util.ArrayList;
import java.util.List;

public class Solution2432 {
    public int hardestWorker(int n, int[][] logs) {
        int len = logs.length;

        List<Integer> idList = new ArrayList<>();
        // 第 0 个任务从时刻 0 开始。
        int time = logs[0][1];
        int id = logs[0][0];
        int max = time;
        idList.add(id);
        for (int i = 1; i < len; i++) {
            time = logs[i][1] - logs[i - 1][1];
            id = logs[i][0];
            if (time > max) {
                max = time;
                idList.clear();
                idList.add(id);
            } else if (time == max) {
                idList.add(id);
            }
        }
        return idList.stream().min(Integer::compareTo).orElseThrow();
    }
}
/*
2432. 处理用时最长的那个任务的员工
https://leetcode.cn/problems/the-employee-that-worked-on-the-longest-task/

第 314 场周赛 T1。

共有 n 位员工，每位员工都有一个从 0 到 n - 1 的唯一 id 。
给你一个二维整数数组 logs ，其中 logs[i] = [idi, leaveTimei] ：
- idi 是处理第 i 个任务的员工的 id ，且
- leaveTimei 是员工完成第 i 个任务的时刻。所有 leaveTimei 的值都是 唯一 的。
注意，第 i 个任务在第 (i - 1) 个任务结束后立即开始，且第 0 个任务从时刻 0 开始。
返回处理用时最长的那个任务的员工的 id 。如果存在两个或多个员工同时满足，则返回几人中 最小 的 id 。
提示：
2 <= n <= 500
1 <= logs.length <= 500
logs[i].length == 2
0 <= idi <= n - 1
1 <= leaveTimei <= 500
idi != idi + 1
leaveTimei 按严格递增顺序排列

贪心。
时间复杂度 O(n)
 */
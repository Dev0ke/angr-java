import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2933 {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, List<Integer>> empTimes = new HashMap<>();
        for (List<String> accessTime : access_times) {
            String emp = accessTime.get(0);
            String hh = accessTime.get(1).substring(0, 2);
            String mm = accessTime.get(1).substring(2, 4);
            int time = Integer.parseInt(hh) * 60 + Integer.parseInt(mm);
            empTimes.computeIfAbsent(emp, e -> new ArrayList<>()).add(time);
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : empTimes.entrySet()) {
            String emp = entry.getKey();
            List<Integer> time = entry.getValue();
            time.sort(null);
            int sz = time.size();
            for (int i = 2; i < sz; i++) {
                if (time.get(i) - time.get(i - 2) < 60) {
                    ans.add(emp);
                    break;
                }
            }
        }
        return ans;
    }
}
/*
2933. 高访问员工
https://leetcode.cn/problems/high-access-employees/description/

第 371 场周赛 T2。

给你一个长度为 n 、下标从 0 开始的二维字符串数组 access_times 。对于每个 i（0 <= i <= n - 1 ），access_times[i][0] 表示某位员工的姓名，access_times[i][1] 表示该员工的访问时间。access_times 中的所有条目都发生在同一天内。
访问时间用 四位 数字表示， 符合 24 小时制 ，例如 "0800" 或 "2250" 。
如果员工在 同一小时内 访问系统 三次或更多 ，则称其为 高访问 员工。
时间间隔正好相差一小时的时间 不 被视为同一小时内。例如，"0815" 和 "0915" 不属于同一小时内。
一天开始和结束时的访问时间不被计算为同一小时内。例如，"0005" 和 "2350" 不属于同一小时内。
以列表形式，按任意顺序，返回所有 高访问 员工的姓名。
提示：
1 <= access_times.length <= 100
access_times[i].length == 2
1 <= access_times[i][0].length <= 10
access_times[i][0] 仅由小写英文字母组成。
access_times[i][1].length == 4
access_times[i][1] 采用24小时制表示时间。
access_times[i][1] 仅由数字 '0' 到 '9' 组成。

哈希表 + 排序
时间复杂度 O(nlogn)
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        // 统计频次
        int[] cntArr = new int[26];
        for (char task : tasks) {
            cntArr[task - 'A']++;
        }

        // 贪心
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (cntArr[i] > 0) {
                maxHeap.add(cntArr[i]);
            }
        }
        int cnt = 0;
        while (!maxHeap.isEmpty()) {
            // 两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间
            int size = Math.min(maxHeap.size(), n + 1);
            List<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int cur = maxHeap.remove();
                if (cur > 1) {
                    tmpList.add(cur - 1);
                }
                cnt++;
            }
            maxHeap.addAll(tmpList);

            // 最后一轮不需要继续 "待命"
            if (!maxHeap.isEmpty()) {
                cnt += n + 1 - size;
            }
        }
        return cnt;
    }
}
/*
621. 任务调度器
https://leetcode.cn/problems/task-scheduler/

给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。
任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
你需要计算完成所有任务所需要的 最短时间 。
提示：
1 <= task.length <= 10^4
tasks[i] 是大写英文字母
n 的取值范围为 [0, 100]

贪心，优先取 n+1 个不同的任务
相似题目: $358. K 距离间隔重排字符串
https://leetcode.cn/problems/rearrange-string-k-distance-apart/
1405. 最长快乐字符串
https://leetcode.cn/problems/longest-happy-string/
 */
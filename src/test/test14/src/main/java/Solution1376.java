import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution1376 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // HashMap 预处理
        Map<Integer, List<Integer>> idxListMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> idxList = idxListMap.getOrDefault(manager[i], new ArrayList<>());
            idxList.add(i);
            idxListMap.put(manager[i], idxList);
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(headID);
        // 也可以直接原数组上操作
        int[] informTimeCopy = new int[n];
        System.arraycopy(informTime, 0, informTimeCopy, 0, n);

        int max = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.remove();
                max = Math.max(max, informTimeCopy[cur]);

                List<Integer> idxList = idxListMap.getOrDefault(cur, new ArrayList<>());
                for (int next : idxList) {
                    informTimeCopy[next] += informTimeCopy[cur];
                    queue.add(next);
                }
            }
        }
        return max;
    }
}
/*
1376. 通知所有员工所需的时间
https://leetcode.cn/problems/time-needed-to-inform-all-employees/

公司里有 n 名员工，每个员工的 ID 都是独一无二的，编号从 0 到 n - 1。公司的总负责人通过 headID 进行标识。
在 manager 数组中，每个员工都有一个直属负责人，其中 manager[i] 是第 i 名员工的直属负责人。对于总负责人，manager[headID] = -1。题目保证从属关系可以用树结构显示。
公司总负责人想要向公司所有员工通告一条紧急消息。他将会首先通知他的直属下属们，然后由这些下属通知他们的下属，直到所有的员工都得知这条紧急消息。
第 i 名员工需要 informTime[i] 分钟来通知它的所有直属下属（也就是说在 informTime[i] 分钟后，他的所有直属下属都可以开始传播这一消息）。
返回通知所有员工这一紧急消息所需要的 分钟数 。
提示：
1 <= n <= 10^5
0 <= headID < n
manager.length == n
0 <= manager[i] < n
manager[headID] == -1
informTime.length == n
0 <= informTime[i] <= 1000
如果员工 i 没有下属，informTime[i] == 0 。
题目 保证 所有员工都可以收到通知。

BFS。
时间复杂度 O(n)
 */
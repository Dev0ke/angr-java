import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution1345 {
    public int minJumps(int[] arr) {
        int len = arr.length;
        if (len == 1) {
            return 0;
        }

        // 统计每个数值的所有下标
        Map<Integer, List<Integer>> idxListMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            List<Integer> idxList = idxListMap.getOrDefault(arr[i], new ArrayList<>());
            idxList.add(i);
            idxListMap.put(arr[i], idxList);
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[len];
        queue.add(0);
        visited[0] = true;

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curIdx = queue.remove();
                if (curIdx == len - 1) {
                    return step;
                }

                // i + 1 满足：i + 1 < arr.length
                int next1 = curIdx + 1;
                if (next1 < len) {
                    if (!visited[next1]) {
                        visited[next1] = true;
                        queue.add(next1);
                    }
                }
                // i - 1 满足：i - 1 >= 0
                int next2 = curIdx - 1;
                if (next2 >= 0) {
                    if (!visited[next2]) {
                        visited[next2] = true;
                        queue.add(next2);
                    }
                }
                // j 满足：arr[i] == arr[j] 且 i != j
                // 注意此处需剪枝到 O(n) 否则 TLE
                if (idxListMap.containsKey(arr[curIdx])) {
                    for (int idx : idxListMap.get(arr[curIdx])) {
                        if (!visited[idx]) {
                            visited[idx] = true;
                            queue.add(idx);
                        }
                    }
                    idxListMap.remove(arr[curIdx]);
                }
            }
            step++;
        }
        return -1;
    }
}
/*
1345. 跳跃游戏 IV
https://leetcode.cn/problems/jump-game-iv/

第 19 场双周赛 T4。

给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
每一步，你可以从下标 i 跳到下标：
- i + 1 满足：i + 1 < arr.length
- i - 1 满足：i - 1 >= 0
- j 满足：arr[i] == arr[j] 且 i != j
请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
注意：任何时候你都不能跳到数组外面。
提示：
1 <= arr.length <= 5 * 10^4
-10^8 <= arr[i] <= 10^8

常规 BFS 时间复杂度 O(n^2) 本题会超时。需要剪枝到 O(n)
 */
import java.util.LinkedList;
import java.util.Queue;

public class Solution1306 {
    public boolean canReach(int[] arr, int start) {
        int len = arr.length;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] visited = new boolean[len];
        visited[start] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curIdx = queue.remove();
                if (arr[curIdx] == 0) {
                    return true;
                }

                // 可以跳到 i + arr[i] 或者 i - arr[i]
                if (curIdx - arr[curIdx] >= 0 && !visited[curIdx - arr[curIdx]]) {
                    visited[curIdx - arr[curIdx]] = true;
                    queue.add(curIdx - arr[curIdx]);
                }
                if (curIdx + arr[curIdx] < len && !visited[curIdx + arr[curIdx]]) {
                    visited[curIdx + arr[curIdx]] = true;
                    queue.add(curIdx + arr[curIdx]);
                }
            }
        }
        return false;
    }
}
/*
1306. 跳跃游戏 III
https://leetcode.cn/problems/jump-game-iii/

这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。
注意，不管是什么情况下，你都无法跳到数组之外。
提示：
1 <= arr.length <= 5 * 10^4
0 <= arr[i] < arr.length
0 <= start < arr.length

BFS。
 */
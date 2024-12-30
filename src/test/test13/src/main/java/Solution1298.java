import java.util.ArrayDeque;
import java.util.Queue;

public class Solution1298 {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;

        boolean[] canOpen = new boolean[n];
        boolean[] hasBox = new boolean[n];
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            canOpen[i] = (status[i] == 1);
        }

        int ans = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for (int box : initialBoxes) {
            hasBox[box] = true;
            if (canOpen[box]) {
                q.add(box);
                used[box] = true;
                ans += candies[box];
            }
        }
        while (!q.isEmpty()) {
            int x = q.remove();
            for (int y : keys[x]) {
                canOpen[y] = true;
                if (!used[y] && hasBox[y]) {
                    q.add(y);
                    used[y] = true;
                    ans += candies[y];
                }
            }
            for (int y : containedBoxes[x]) {
                hasBox[y] = true;
                if (!used[y] && canOpen[y]) {
                    q.add(y);
                    used[y] = true;
                    ans += candies[y];
                }
            }
        }
        return ans;
    }
}
/*
1298. 你能从盒子里获得的最大糖果数
https://leetcode.cn/problems/maximum-candies-you-can-get-from-boxes/description/

给你 n 个盒子，每个盒子的格式为 [status, candies, keys, containedBoxes] ，其中：
- 状态字 status[i]：整数，如果 box[i] 是开的，那么是 1 ，否则是 0 。
- 糖果数 candies[i]: 整数，表示 box[i] 中糖果的数目。
- 钥匙 keys[i]：数组，表示你打开 box[i] 后，可以得到一些盒子的钥匙，每个元素分别为该钥匙对应盒子的下标。
- 内含的盒子 containedBoxes[i]：整数，表示放在 box[i] 里的盒子所对应的下标。
给你一个 initialBoxes 数组，表示你现在得到的盒子，你可以获得里面的糖果，也可以用盒子里的钥匙打开新的盒子，还可以继续探索从这个盒子里找到的其他盒子。
请你按照上述规则，返回可以获得糖果的 最大数目 。
提示：
1 <= status.length <= 1000
status.length == candies.length == keys.length == containedBoxes.length == n
status[i] 要么是 0 要么是 1 。
1 <= candies[i] <= 1000
0 <= keys[i].length <= status.length
0 <= keys[i][j] < status.length
keys[i] 中的值都是互不相同的。
0 <= containedBoxes[i].length <= status.length
0 <= containedBoxes[i][j] < status.length
containedBoxes[i] 中的值都是互不相同的。
每个盒子最多被一个盒子包含。
0 <= initialBoxes.length <= status.length
0 <= initialBoxes[i] < status.length

BFS。
时间复杂度 O(n)。
 */
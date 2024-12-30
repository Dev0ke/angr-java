import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1705 {
    public int eatenApples(int[] apples, int[] days) {
        // 一连 n 天
        int n = apples.length;
        // [腐败日期, 数量] 小顶堆
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        int cnt = 0;
        // 当天
        int today = 0;
        for (int i = 0; i < n; i++) {
            today = i + 1;
            // 腐败日期
            int lastDay = today + days[i];
            // 苹果数量
            int amount = apples[i];
            minHeap.add(new int[]{lastDay, amount});

            // 扔掉已腐败的苹果
            while (!minHeap.isEmpty() && minHeap.peek()[0] <= today) {
                minHeap.poll();
            }

            if (!minHeap.isEmpty()) {
                int[] peek = minHeap.poll();
                if (peek[1] > 1) {
                    // 吃掉 1 个
                    peek[1] -= 1;
                    minHeap.add(peek);
                }
                // 扔掉数量为 0 的
                cnt++;
            }
        }
        // 继续吃
        while (!minHeap.isEmpty()) {
            today++;
            // 已腐败的扔掉
            while (!minHeap.isEmpty() && minHeap.peek()[0] <= today) {
                minHeap.poll();
            }
            if (!minHeap.isEmpty()) {
                int[] peek = minHeap.poll();
                if (peek[1] > 1) {
                    // 吃掉 1 个
                    peek[1] -= 1;
                    minHeap.add(peek);
                }
                // 扔掉数量为 0 的
                cnt++;
            }
        }
        return cnt;
    }
}
/*
1705. 吃苹果的最大数目
https://leetcode.cn/problems/maximum-number-of-eaten-apples/

第 221 场周赛 T2。

有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。在第 i 天，树上会长出 apples[i] 个苹果，这些苹果将会在 days[i] 天后
（也就是说，第 i + days[i] 天时）腐烂，变得无法食用。也可能有那么几天，树上不会长出新的苹果，此时用 apples[i] == 0 且 days[i] == 0 表示。
你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。
给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。
提示：
apples.length == n
days.length == n
1 <= n <= 2 * 10^4
0 <= apples[i], days[i] <= 2 * 10^4
只有在 apples[i] = 0 时，days[i] = 0 才成立

贪心，每天吃腐败日期最小的苹果，优先队列存储。
因为苹果总数可达到 2 * 10^4 * 2 * 10^4 = 4*10^8 因此不能将苹果打散存储。
 */
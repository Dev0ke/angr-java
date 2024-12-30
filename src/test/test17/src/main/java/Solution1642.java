import java.util.PriorityQueue;

public class Solution1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int len = heights.length;

        int needBricks = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 1; i < len; i++) {
            int diff = heights[i] - heights[i - 1];
            if (diff > 0) {
                minHeap.add(diff);
                if (minHeap.size() > ladders) {
                    needBricks += minHeap.remove();
                }
                if (needBricks > bricks) {
                    return i - 1;
                }
            }
        }
        return len - 1;
    }
}
/*
1642. 可以到达的最远建筑
https://leetcode.cn/problems/furthest-building-you-can-reach/

给你一个整数数组 heights ，表示建筑物的高度。另有一些砖块 bricks 和梯子 ladders 。
你从建筑物 0 开始旅程，不断向后面的建筑物移动，期间可能会用到砖块或梯子。
当从建筑物 i 移动到建筑物 i+1（下标 从 0 开始 ）时：
- 如果当前建筑物的高度 大于或等于 下一建筑物的高度，则不需要梯子或砖块
- 如果当前建筑的高度 小于 下一个建筑的高度，您可以使用 一架梯子 或 (h[i+1] - h[i]) 个砖块
如果以最佳方式使用给定的梯子和砖块，返回你可以到达的最远建筑物的下标（下标 从 0 开始 ）。
提示：
1 <= heights.length <= 10^5
1 <= heights[i] <= 10^6
0 <= bricks <= 10^9
0 <= ladders <= heights.length

贪心。
优先使用梯子，梯子不够就选最小高度差用砖块代替
时间复杂度 O(nlog(ladders))
空间复杂度 O(ladders)
 */
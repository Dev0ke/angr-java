import java.util.PriorityQueue;

public class SolutionP1199 {
    public int minBuildTime(int[] blocks, int split) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int block : blocks) {
            minHeap.add(block);
        }

        while (minHeap.size() > 1) {
            int min = minHeap.remove();
            int secMin = minHeap.remove();
            minHeap.add(split + secMin);
        }
        return minHeap.remove();
    }
}
/*
$1199. 建造街区的最短时间
https://leetcode.cn/problems/minimum-time-to-build-blocks/

你是个城市规划工作者，手里负责管辖一系列的街区。在这个街区列表中 blocks[i] = t 意味着第  i 个街区需要 t 个单位的时间来建造。
由于一个街区只能由一个工人来完成建造。
所以，一个工人要么需要再召唤一个工人（工人数增加 1）；要么建造完一个街区后回家。这两个决定都需要花费一定的时间。
一个工人再召唤一个工人所花费的时间由整数 split 给出。
注意：如果两个工人同时召唤别的工人，那么他们的行为是并行的，所以时间花费仍然是 split。
最开始的时候只有 一个 工人，请你最后输出建造完所有街区所需要的最少时间。
提示：
1 <= blocks.length <= 1000
1 <= blocks[i] <= 10^5
1 <= split <= 100

哈夫曼算法思想
https://leetcode.cn/problems/minimum-time-to-build-blocks/solution/cong-fen-lie-gong-ren-dao-he-bing-jie-qu-tan-xin-c/
 */
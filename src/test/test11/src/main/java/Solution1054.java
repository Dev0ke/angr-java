import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution1054 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;

        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int x : barcodes) {
            cntMap.put(x, cntMap.getOrDefault(x, 0) + 1);
        }
        // num, cnt
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o2[1], o1[1]);
        });

        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            int k = entry.getKey(), v = entry.getValue();
            maxHeap.add(new int[]{k, v});
        }

        int[] res = new int[n];
        int id = 0;
        while (!maxHeap.isEmpty()) {
            if (maxHeap.size() == 1) {
                int[] top = maxHeap.remove();
                res[id] = top[0];
                break;
            }
            int[] top1 = maxHeap.remove(), top2 = maxHeap.remove();
            res[id++] = top1[0];
            res[id++] = top2[0];
            top1[1]--;
            top2[1]--;
            if (top1[1] > 0) maxHeap.add(top1);
            if (top2[1] > 0) maxHeap.add(top2);
        }
        return res;
    }
}
/*
1054. 距离相等的条形码
https://leetcode.cn/problems/distant-barcodes/

在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。
请你重新排列这些条形码，使其中任意两个相邻的条形码不能相等。 你可以返回任何满足该要求的答案，此题保证存在答案。
提示：
1 <= barcodes.length <= 10000
1 <= barcodes[i] <= 10000

大顶堆
相似题目: 767. 重构字符串
https://leetcode.cn/problems/reorganize-string/
 */
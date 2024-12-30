import java.util.ArrayList;
import java.util.List;

public class Solution1090 {
    private static final int MAX_N = (int) (2e4 + 1);

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Node(values[i], labels[i]));
        }
        list.sort((o1, o2) -> {
            if (o1.val == o2.val) {
                return Integer.compare(o1.label, o2.label);
            }
            return Integer.compare(o2.val, o1.val);
        });

        int sum = 0;
        int[] cnt = new int[MAX_N];
        for (int i = 0; i < n && numWanted > 0; i++) {
            Node node = list.get(i);
            int val = node.val, label = node.label;

            cnt[label]++;
            if (cnt[label] <= useLimit) {
                sum += val;
                numWanted--;
            }
        }
        return sum;
    }

    private static class Node {
        int val;
        int label;

        public Node(int val, int label) {
            this.val = val;
            this.label = label;
        }
    }
}
/*
1090. 受标签影响的最大值
https://leetcode.cn/problems/largest-values-from-labels/

我们有一个 n 项的集合。给出两个整数数组 values 和 labels ，第 i 个元素的值和标签分别是 values[i] 和 labels[i]。还会给出两个整数 numWanted 和 useLimit 。
从 n 个元素中选择一个子集 s :
- 子集 s 的大小 小于或等于 numWanted 。
- s 中 最多 有相同标签的 useLimit 项。
一个子集的 分数 是该子集的值之和。
返回子集 s 的最大 分数 。
提示：
n == values.length == labels.length
1 <= n <= 2 * 10^4
0 <= values[i], labels[i] <= 2 * 10^4
1 <= numWanted, useLimit <= n

贪心。由大到小枚举，能取就取。
时间复杂度 O(nlogn)
 */
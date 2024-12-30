import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SolutionP358 {
    public String rearrangeString(String s, int k) {
        // 特判
        if (k == 0) {
            return s;
        }

        // 统计频次
        Map<Character, Integer> cntMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            cntMap.put(ch, cntMap.getOrDefault(ch, 0) + 1);
        }

        // 优先使用频次高的
        PriorityQueue<Node> maxHeap = new PriorityQueue<>((o1, o2) -> {
            if (o1.cnt == o2.cnt) {
                return Character.compare(o1.ch, o2.ch);
            }
            return Integer.compare(o2.cnt, o1.cnt);
        });
        for (Map.Entry<Character, Integer> entry : cntMap.entrySet()) {
            maxHeap.add(new Node(entry.getKey(), entry.getValue()));
        }

        int n = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i += k) {
            List<Node> tmpList = new ArrayList<>();
            for (int j = 0; j < k && i + j < n; j++) {
                Node node = maxHeap.poll();
                if (node == null) {
                    return "";
                }
                stringBuilder.append(node.ch);
                if (node.cnt - 1 > 0) {
                    tmpList.add(new Node(node.ch, node.cnt - 1));
                }
            }
            maxHeap.addAll(tmpList);
        }
        return stringBuilder.toString();
    }

    private static class Node {
        char ch;
        int cnt;

        public Node(char ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }
    }
}
/*
$358. K 距离间隔重排字符串
https://leetcode.cn/problems/rearrange-string-k-distance-apart/

给你一个非空的字符串 s 和一个整数 k ，你要将这个字符串 s 中的字母进行重新排列，使得重排后的字符串中相同字母的位置间隔距离 至少 为 k 。如果无法做到，请返回一个空字符串 ""。
提示：
1 <= s.length <= 3 * 10^5
s 仅由小写英文字母组成
0 <= k <= s.length

贪心，优先使用频次高的，一次取 top k 个
相似题目: 621. 任务调度器
https://leetcode.cn/problems/task-scheduler/
1405. 最长快乐字符串
https://leetcode.cn/problems/longest-happy-string/
 */
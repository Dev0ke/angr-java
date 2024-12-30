import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution767 {
    public String reorganizeString(String s) {
        Map<Character, Integer> cntMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            cntMap.put(ch, cntMap.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Node> maxHeap = new PriorityQueue<>((o1, o2) -> {
            if (o1.cnt == o2.cnt) {
                return Character.compare(o1.ch, o2.ch);
            }
            return Integer.compare(o2.cnt, o1.cnt);
        });
        for (Map.Entry<Character, Integer> entry : cntMap.entrySet()) {
            maxHeap.add(new Node(entry.getKey(), entry.getValue()));
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            if (maxHeap.size() == 1) {
                Node top1 = maxHeap.remove();
                stringBuilder.append(top1.ch);
                break;
            } else {
                Node top1 = maxHeap.remove();
                Node top2 = maxHeap.remove();
                stringBuilder.append(top1.ch);
                stringBuilder.append(top2.ch);
                top1.cnt--;
                top2.cnt--;
                if (top1.cnt > 0) {
                    maxHeap.add(top1);
                }
                if (top2.cnt > 0) {
                    maxHeap.add(top2);
                }
            }
        }
        return stringBuilder.length() == s.length() ? stringBuilder.toString() : "";
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
767. 重构字符串
https://leetcode.cn/problems/reorganize-string/

给定一个字符串 s ，检查是否能重新排布其中的字母，使得两相邻的字符不同。
返回 s 的任意可能的重新排列。若不可行，返回空字符串 "" 。
提示:
1 <= s.length <= 500
s 只包含小写字母

贪心。频次 TOP1 TOP2 的交替着放
相似题目: 1054. 距离相等的条形码
https://leetcode.cn/problems/distant-barcodes/
 */
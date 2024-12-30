import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution451 {
    public String frequencySort(String s) {
        Map<Character, Integer> cntMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            cntMap.put(ch, cntMap.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Node> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.cnt, o1.cnt));
        for (Map.Entry<Character, Integer> entry : cntMap.entrySet()) {
            maxHeap.add(new Node(entry.getKey(), entry.getValue()));
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Node cur = maxHeap.poll();
            stringBuilder.append(String.valueOf(cur.ch).repeat(Math.max(0, cur.cnt)));
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
451. 根据字符出现频率排序
https://leetcode.cn/problems/sort-characters-by-frequency/

给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
提示:
1 <= s.length <= 5 * 10^5
s 由大小写英文字母和数字组成

HashMap 统计频次 + 优先队列。
 */
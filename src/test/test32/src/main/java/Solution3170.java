import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution3170 {
    public String clearStars(String s) {
        int n = s.length();
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.ch == o2.ch) {
                return Integer.compare(o2.i, o1.i);
            }
            return Character.compare(o1.ch, o2.ch);
        });
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                pq.remove();
            } else {
                pq.add(new Node(ch, i));
            }
        }

        List<Node> list = new ArrayList<>(pq);
        list.sort(Comparator.comparingInt(o -> o.i));
        StringBuilder ans = new StringBuilder();
        for (Node node : list) {
            ans.append(node.ch);
        }
        return ans.toString();
    }

    static class Node {
        char ch;
        int i;

        public Node(char ch, int i) {
            this.ch = ch;
            this.i = i;
        }
    }
}
/*
3170. 删除星号以后字典序最小的字符串
https://leetcode.cn/problems/lexicographically-minimum-string-after-removing-stars/description/

第 400 场周赛 T3。

给你一个字符串 s 。它可能包含任意数量的 '*' 字符。你的任务是删除所有的 '*' 字符。
当字符串还存在至少一个 '*' 字符时，你可以执行以下操作：
- 删除最左边的 '*' 字符，同时删除该星号字符左边一个字典序 最小 的字符。如果有多个字典序最小的字符，你可以删除它们中的任意一个。
请你返回删除所有 '*' 字符以后，剩余字符连接而成的 字典序最小 的字符串。
提示：
1 <= s.length <= 10^5
s 只含有小写英文字母和 '*' 字符。
输入保证操作可以删除所有的 '*' 字符。

贪心。想明白有多个字典序最小的字符时，要使字典序最小，删下标最大的字符即可。
可以开 26 个栈，但感觉用优先队列好写一点。
时间复杂度 O(nlogn)。
 */
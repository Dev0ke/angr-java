import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution1625 {
    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();

        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        Set<String> visitedSet = new HashSet<>();
        visitedSet.add(s);

        String ans = s;
        while (!queue.isEmpty()) {
            String cur = queue.remove();
            if (cur.compareTo(ans) < 0) {
                ans = cur;
            }

            // 累加
            char[] cs = cur.toCharArray();
            for (int i = 1; i < n; i += 2) {
                cs[i] = (char) ((cs[i] - '0' + a) % 10 + '0');
            }
            String add = new String(cs);
            if (!visitedSet.contains(add)) {
                visitedSet.add(add);
                queue.add(add);
            }

            // 轮转
            String rotate = cur.substring(n - b) + cur.substring(0, n - b);
            if (!visitedSet.contains(rotate)) {
                visitedSet.add(rotate);
                queue.add(rotate);
            }
        }
        return ans;
    }
}
/*
1625. 执行操作后字典序最小的字符串
https://leetcode.cn/problems/lexicographically-smallest-string-after-applying-operations/

给你一个字符串 s 以及两个整数 a 和 b 。其中，字符串 s 的长度为偶数，且仅由数字 0 到 9 组成。
你可以在 s 上按任意顺序多次执行下面两个操作之一：
- 累加：将 a 加到 s 中所有下标为奇数的元素上（下标从 0 开始）。数字一旦超过 9 就会变成 0，如此循环往复。例如，s = "3456" 且 a = 5，则执行此操作后 s 变成 "3951"。
- 轮转：将 s 向右轮转 b 位。例如，s = "3456" 且 b = 1，则执行此操作后 s 变成 "6345"。
请你返回在 s 上执行上述操作任意次后可以得到的 字典序最小 的字符串。
如果两个字符串长度相同，那么字符串 a 字典序比字符串 b 小可以这样定义：在 a 和 b 出现不同的第一个位置上，字符串 a 中的字符出现在字母表中的时间早于 b 中的对应字符。
例如，"0158” 字典序比 "0190" 小，因为不同的第一个位置是在第三个字符，显然 '5' 出现在 '9' 之前。
提示：
2 <= s.length <= 100
s.length 是偶数
s 仅由数字 0 到 9 组成
1 <= a <= 9
1 <= b <= s.length - 1

BFS 枚举。
时间复杂度 O(n^2 * d^2)
 */
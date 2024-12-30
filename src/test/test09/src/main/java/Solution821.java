import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution821 {
    public int[] shortestToChar(String s, char c) {
        int len = s.length();

        int[] res = new int[len];
        Arrays.fill(res, -1);

        // 多源 BFS
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c) {
                queue.add(i);
                res[i] = 0;
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curIdx = queue.remove();
                int curStep = res[curIdx];

                if (curIdx + 1 < len && res[curIdx + 1] == -1) {
                    res[curIdx + 1] = curStep + 1;
                    queue.add(curIdx + 1);
                }
                if (curIdx - 1 >= 0 && res[curIdx - 1] == -1) {
                    res[curIdx - 1] = curStep + 1;
                    queue.add(curIdx - 1);
                }
            }
        }
        return res;
    }
}
/*
821. 字符的最短距离
https://leetcode.cn/problems/shortest-distance-to-a-character/

给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
提示：
1 <= s.length <= 10^4
s[i] 和 c 均为小写英文字母
题目数据保证 c 在 s 中至少出现一次

多源 BFS
 */
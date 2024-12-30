import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution397 {
    public int integerReplacement(int n) {
        Queue<Long> queue = new LinkedList<>();
        queue.add((long) n);
        Set<Long> visited = new HashSet<>();
        visited.add((long) n);
        int cnt = 0;
        // BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                long cur = queue.remove();
                if (cur == 1) {
                    return cnt;
                }
                if (cur % 2 == 0) {
                    long next = cur / 2;
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                } else {
                    long next1 = cur + 1;
                    long next2 = cur - 1;
                    if (!visited.contains(next1)) {
                        visited.add(next1);
                        queue.add(next1);
                    }
                    if (!visited.contains(next2)) {
                        visited.add(next2);
                        queue.add(next2);
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }
}
/*
397. 整数替换
https://leetcode.cn/problems/integer-replacement/

给定一个正整数 n ，你可以做如下操作：
1. 如果 n 是偶数，则用 n / 2替换 n 。
2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
n 变为 1 所需的最小替换次数是多少？
提示：
1 <= n <= 2^31 - 1

BFS
 */
import java.util.ArrayDeque;
import java.util.Queue;

public class SolutionP1999 {
    public int findInteger(int k, int digit1, int digit2) {
        if (digit1 == 0 && digit2 == 0) return -1;
        if (digit1 > digit2) {
            int tmp = digit1;
            digit1 = digit2;
            digit2 = tmp;
        }

        Queue<Long> q = new ArrayDeque<>();
        q.add((long) digit1);
        q.add((long) digit2);
        while (!q.isEmpty()) {
            long x = q.remove();
            if (x > Integer.MAX_VALUE) return -1;
            if (x % k == 0 && x > k) return (int) x;
            q.add(x * 10 + digit1);
            q.add(x * 10 + digit2);
        }
        return -1;
    }
}
/*
$1999. 最小的仅由两个数组成的倍数
https://leetcode.cn/problems/smallest-greater-multiple-made-of-two-digits/description/

给你三个整数, k, digit1和 digit2, 你想要找到满足以下条件的 最小 整数：
- 大于k 且是 k 的倍数
- 仅由digit1 和 digit2 组成，即 每一位数 均是 digit1 或 digit2
请你返回 最小的满足这两个条件的整数，如果不存在这样的整数，或者最小的满足这两个条件的整数不在32位整数范围（0~231-1），就返回 -1 。
提示：
1 <= k <= 1000
0 <= digit1 <= 9
0 <= digit2 <= 9

BFS。
注意判范围要写在当前层，不然遇到 0 会死循环。
 */
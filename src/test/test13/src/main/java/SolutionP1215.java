import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SolutionP1215 {
    public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> resList = new ArrayList<>();
        if (low == 0) {
            resList.add(0);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < 10; i++) {
            queue.add(i);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int x = queue.remove();
                if (x > high) {
                    resList.sort(null);
                    return resList;
                }
                if (x >= low) {
                    resList.add(x);
                }

                int last = x % 10;
                if (last != 0) {
                    queue.add(x * 10 + last - 1);
                }
                if (last != 9) {
                    queue.add(x * 10 + last + 1);
                }
            }
        }
        resList.sort(null);
        return resList;
    }
}
/*
$1215. 步进数
https://leetcode.cn/problems/stepping-numbers/

如果一个整数上的每一位数字与其相邻位上的数字的绝对差都是 1，那么这个数就是一个「步进数」。
例如，321 是一个步进数，而 421 不是。
给你两个整数，low 和 high，请你找出在 [low, high] 范围内的所有步进数，并返回 排序后 的结果。
提示：
0 <= low <= high <= 2 * 10^9

BFS
时间复杂度 O(n)
 */
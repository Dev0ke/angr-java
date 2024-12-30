import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2231 {
    public int largestInteger(int num) {
        String numStr = String.valueOf(num);
        int len = numStr.length();

        // 贪心
        PriorityQueue<Integer> oddMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> evenMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < len; i++) {
            int n = numStr.charAt(i) - '0';
            if (n % 2 == 1) {
                oddMaxHeap.add(n);
            } else {
                evenMaxHeap.add(n);
            }
        }

        // res
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int n = numStr.charAt(i) - '0';
            if (n % 2 == 1) {
                stringBuilder.append(oddMaxHeap.remove());
            } else {
                stringBuilder.append(evenMaxHeap.remove());
            }
        }
        return Integer.parseInt(stringBuilder.toString());
    }
}
/*
2231. 按奇偶性交换后的最大数字
https://leetcode.cn/problems/largest-number-after-digit-swaps-by-parity/

第 288 场周赛 T1。

给你一个正整数 num 。你可以交换 num 中 奇偶性 相同的任意两位数字（即，都是奇数或者偶数）。
返回交换 任意 次之后 num 的 最大 可能值。
示：
1 <= num <= 10^9

贪心。将大的数字放前面，小的数字放后面即可。
 */
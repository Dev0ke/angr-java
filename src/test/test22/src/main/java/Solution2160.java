import java.util.PriorityQueue;

public class Solution2160 {
    public int minimumSum(int num) {
        int num1 = num / 1000 % 10;
        int num2 = num / 100 % 10;
        int num3 = num / 10 % 10;
        int num4 = num % 10;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add((num1 + num2) * 10 + (num3 + num4));
        minHeap.add((num1 + num3) * 10 + (num2 + num4));
        minHeap.add((num1 + num4) * 10 + (num2 + num3));
        minHeap.add((num2 + num3) * 10 + (num1 + num4));
        minHeap.add((num2 + num4) * 10 + (num1 + num3));
        minHeap.add((num3 + num4) * 10 + (num1 + num2));
        return minHeap.remove();
    }
}
/*
2160. 拆分数位后四位数字的最小和
https://leetcode.cn/problems/minimum-sum-of-four-digit-number-after-splitting-digits/

第 71 场双周赛 T1。

给你一个四位 正 整数 num 。请你使用 num 中的 数位 ，将 num 拆成两个新的整数 new1 和 new2 。new1 和 new2 中可以有 前导 0 ，且 num 中 所有 数位都必须使用。
- 比方说，给你 num = 2932 ，你拥有的数位包括：两个 2 ，一个 9 和一个 3 。一些可能的 [new1, new2] 数对为 [22, 93]，[23, 92]，[223, 9] 和 [2, 329] 。
请你返回可以得到的 new1 和 new2 的 最小 和。
提示：
1000 <= num <= 9999

枚举。n1,n2,n3,n4 = n1n2,n1n3,n1n4,n2n3,n2n4,n3n4 共 6 种情况。数量很少，可直接硬编码。
 */
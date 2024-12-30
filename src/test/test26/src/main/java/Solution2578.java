import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution2578 {
    public int splitNum(int num) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        while (num > 0) {
            minHeap.add(num % 10);
            num /= 10;
        }

        List<StringBuilder> sbs = new ArrayList<>();
        sbs.add(new StringBuilder());
        sbs.add(new StringBuilder());

        int i = 0;
        while (!minHeap.isEmpty()) {
            sbs.get(i).append(minHeap.remove());
            i = 1 - i;
        }
        return Integer.parseInt(sbs.get(0).toString()) + Integer.parseInt(sbs.get(1).toString());
    }
}
/*
2578. 最小和分割
https://leetcode.cn/problems/split-with-minimum-sum/

第 99 场双周赛 T1。

给你一个正整数 num ，请你将它分割成两个非负整数 num1 和 num2 ，满足：
- num1 和 num2 直接连起来，得到 num 各数位的一个排列。
  - 换句话说，num1 和 num2 中所有数字出现的次数之和等于 num 中所有数字出现的次数。
- num1 和 num2 可以包含前导 0 。
请你返回 num1 和 num2 可以得到的和的 最小 值。
注意：
- num 保证没有前导 0 。
- num1 和 num2 中数位顺序可以与 num 中数位顺序不同。
提示：
10 <= num <= 10^9

贪心。
时间复杂度 O(nlogn) 其中 n <= 9
 */
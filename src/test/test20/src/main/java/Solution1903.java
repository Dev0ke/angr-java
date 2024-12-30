import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1903 {
    public String largestOddNumber(String num) {
        String[] odds = {"1", "3", "5", "7", "9"};
        // 优先队列-大顶堆（降序排列）
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (String odd : odds) {
            maxHeap.add(num.lastIndexOf(odd));
        }
        Integer maxIndex = maxHeap.poll();
        return num.substring(0, maxIndex + 1);
    }
}
/*
1903. 字符串中的最大奇数
https://leetcode.cn/problems/largest-odd-number-in-string/

第 246 场周赛 T1。

给你一个字符串 num ，表示一个大整数。请你在字符串 num 的所有 非空子字符串 中找出 值最大的奇数 ，并以字符串形式返回。如果不存在奇数，则返回一个空字符串 "" 。
子字符串 是字符串中的一个连续的字符序列。
提示：
1 <= num.length <= 10^5
num 仅由数字组成且不含前导零

从后往前找到第一个奇数的下标，截取的子字符串即为最大奇数。
 */
import java.util.Arrays;

public class Solution1798 {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int x = 0;
        for (int y : coins) {
            if (y > x + 1) {
                break;
            }
            x += y;
        }
        return x + 1;
    }
}
/*
1798. 你能构造出连续值的最大数目
https://leetcode.cn/problems/maximum-number-of-consecutive-values-you-can-make/

给你一个长度为 n 的整数数组 coins ，它代表你拥有的 n 个硬币。第 i 个硬币的值为 coins[i] 。如果你从这些硬币中选出一部分硬币，它们的和为 x ，那么称，你可以 构造 出 x 。
请返回从 0 开始（包括 0 ），你最多能 构造 出多少个连续整数。
你可能有多个相同值的硬币。
提示：
coins.length == n
1 <= n <= 4 * 10^4
1 <= coins[i] <= 4 * 10^4

数学
如果 x+1 在区间 [y,y+x] 中，那么元素 y 就会使得构造出的连续整数的范围从 [0,x] 增加到 [0,y+x]；否则，元素 y 不会对答案产生任何影响。
 */
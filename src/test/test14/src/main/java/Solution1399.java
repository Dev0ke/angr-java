import java.util.HashMap;
import java.util.Map;

public class Solution1399 {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int max_cnt = 0;
        for (int i = 1; i <= n; i++) {
            int digitSum = digitSum(i);
            max_cnt = Math.max(max_cnt, cnt.merge(digitSum, 1, Integer::sum));
        }

        int ans = 0;
        for (Integer c : cnt.values()) {
            if (c == max_cnt) ans++;
        }
        return ans;
    }

    private int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
/*
1399. 统计最大组的数目
https://leetcode.cn/problems/count-largest-group/description/

给你一个整数 n 。请你先求出从 1 到 n 的每个整数 10 进制表示下的数位和（每一位上的数字相加），然后把数位和相等的数字放到同一个组中。
请你统计每个组中的数字数目，并返回数字数目并列最多的组有多少个。
提示：
1 <= n <= 10^4

哈希表 模拟。
时间复杂度 O(nlogn)。 求数位和需要 log 级别的时间复杂度。
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2698 {
    private static final int[] TABLES = {1, 9, 10, 36, 45, 55, 82, 91, 99, 100, 235, 297, 369, 370, 379, 414, 657, 675, 703, 756, 792, 909, 918, 945, 964, 990, 991, 999, 1000};

    public int punishmentNumber(int n) {
        int ans = 0;
        for (int x : TABLES) {
            if (x <= n) {
                ans += x * x;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        for (long i = 1; i <= 1000; i++) {
            Set<Long> set = new HashSet<>(dfs(String.valueOf(i * i)));
            if (set.contains(i)) {
                list.add(i);
            }
        }
        System.out.println(list);
    }

    private static List<Long> dfs(String s) {
        int n = s.length();
        List<Long> sums = new ArrayList<>();
        sums.add(Long.parseLong(s));
        for (int L = 1; L <= n - 1; L++) {
            List<Long> left = dfs(s.substring(0, L));
            List<Long> right = dfs(s.substring(L, n));
            for (long l1 : left) {
                for (long l2 : right) {
                    sums.add(l1 + l2);
                }
            }
        }
        return sums;
    }
}
/*
2698. 求一个整数的惩罚数
https://leetcode.cn/problems/find-the-punishment-number-of-an-integer/

第 346 场周赛 T3。

给你一个正整数 n ，请你返回 n 的 惩罚数 。
n 的 惩罚数 定义为所有满足以下条件 i 的数的平方和：
- 1 <= i <= n
- i * i 的十进制表示的字符串可以分割成若干连续子字符串，且这些子字符串对应的整数值之和等于 i 。
提示：
1 <= n <= 1000

回溯 打表
时间复杂度 O(1)
 */
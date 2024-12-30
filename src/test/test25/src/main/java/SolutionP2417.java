public class SolutionP2417 {
    public int closestFair(int n) {
        int length = String.valueOf(n).length();
        if (length % 2 == 1) {
            // 如果位数是奇数，直接构造 l+1 位里最小的
            return Integer.parseInt("1" + "0".repeat((length + 1) / 2) + "1".repeat(length / 2));
        }

        // 验证给定整数是否满足题意
        for (int j = n; j < (int) Math.pow(10, length); j++) {
            if (check(j)) {
                return j;
            }
        }
        // 遇到了前半部分全 9 的坑人情况，返回 l+2 位里最小的
        return Integer.parseInt("1" + "0".repeat(length / 2 + 1) + "1".repeat(length / 2));
    }

    // 验证给定整数是否满足题意
    private boolean check(int k) {
        int even = 0, odd = 0;
        while (k > 0) {
            int cur = k % 10;
            if (cur % 2 == 0) {
                even++;
            } else {
                odd++;
            }
            k /= 10;
        }
        return even == odd;
    }
}
/*
$2417. 最近的公平整数
https://leetcode.cn/problems/closest-fair-integer/description/

给定一个 正整数 n。
如果一个整数 k 中的 偶数 位数与 奇数 位数相等，那么我们称 k 为公平整数。
返回 大于或等于 n 的 最小 的公平整数。
提示:
1 <= n <= 10^9

分类讨论，对偶数长度的n可以直接暴力找。
https://leetcode.cn/problems/closest-fair-integer/solutions/1841067/fen-lei-tao-lun-by-v5qyy4q65w-nc8d/
时间复杂度 O(sqrtn * logn)。
本题还可以贪心构造 O(logn)
 */
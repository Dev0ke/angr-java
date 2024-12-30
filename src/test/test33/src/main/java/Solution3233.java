import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Solution3233 {
    static List<Integer> squareNumber = new ArrayList<>();

    static {
        for (int i = 1; i * i <= 1e9; i++) {
            if (isPrime(i)) {
                squareNumber.add(i * i);
            }
        }
    }

    static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; ++i) {
            if (num % i == 0) return false;
        }
        return true;
    }

    static int sortSearch(int n, Function<Integer, Boolean> f) {
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (f.apply(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    public int nonSpecialCount(int l, int r) {
        int ans = r - l + 1;
        int i = sortSearch(squareNumber.size(), m -> squareNumber.get(m) >= l);
        int j = sortSearch(squareNumber.size(), m -> squareNumber.get(m) > r);
        ans -= j - i;
        return ans;
    }
}
/*
3233. 统计不是特殊数字的数字数量
https://leetcode.cn/problems/find-the-count-of-numbers-which-are-not-special/description/

第 408 场周赛 T2。

给你两个 正整数 l 和 r。对于任何数字 x，x 的所有正因数（除了 x 本身）被称为 x 的 真因数。
如果一个数字恰好仅有两个 真因数，则称该数字为 特殊数字。例如：
- 数字 4 是 特殊数字，因为它的真因数为 1 和 2。
- 数字 6 不是 特殊数字，因为它的真因数为 1、2 和 3。
返回区间 [l, r] 内 不是 特殊数字 的数字数量。
提示：
1 <= l <= r <= 10^9

预处理 + 二分。
时间复杂度 O(nlogU)。其中 U = squareNumber.size() = 3401
 */
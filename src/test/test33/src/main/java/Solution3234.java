import java.util.ArrayList;
import java.util.List;

public class Solution3234 {
    public int numberOfSubstrings(String s) {
        // 1、把所有的 0 的下标找到
        int n = s.length();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') a.add(i);
        }

        int tot1 = n - a.size(); // 目前所有的 1 的个数
        a.add(n); // 哨兵，方便处理 0111 的情况

        int ans = 0, i = 0;
        for (int left = 0; left < n; left++) { // 枚举子串左端点
            // 枚举子串有多少个 0
            // 枚举 0 的下标
            for (int k = i; k < a.size() - 1; k++) {
                int cnt0 = k - i + 1;
                if (cnt0 * cnt0 > tot1) {
                    break;
                }
                int p = a.get(k), q = a.get(k + 1);
                int cnt1 = p - left - (k - i);
                if (cnt1 >= cnt0 * cnt0) {
                    // p,p+1,p+2,...,q-1 都可以作为子串的右端点
                    // 这些左端点在 left，右端点在 p,p+1,p+2,...,q-1 的子串都恰好包含 cnt0 个 0
                    ans += q - p;
                } else {
                    // cnt1 的个数少，补充 cnt0 * cnt0 - cnt1 个
                    // p + (cnt0 * cnt0 - cnt1), ..., q-1
                    ans += Math.max(q - p - (cnt0 * cnt0 - cnt1), 0);
                }
            }

            // 没有 0 的情况
            if (s.charAt(left) == '0') {
                i++; // a[i] 已经在 left 的左边了，无需枚举
            } else {
                ans += a.get(i) - left;
                tot1--;
            }
        }
        return ans;
    }
}
/*
3234. 统计 1 显著的字符串的数量
https://leetcode.cn/problems/count-the-number-of-substrings-with-dominant-ones/description/

第 408 场周赛 T3。

给你一个二进制字符串 s。
请你统计并返回其中 1 显著 的 子字符串 的数量。
如果字符串中 1 的数量 大于或等于 0 的数量的 平方，则认为该字符串是一个 1 显著 的字符串 。
提示：
1 <= s.length <= 4 * 10^4
s 仅包含字符 '0' 和 '1'。

枚举左端点 + 枚举 0 的个数。
时间复杂度 O(n + sqrt(n))。
rating 2554 (clist.by)
 */

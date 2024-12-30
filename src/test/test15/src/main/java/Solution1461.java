import java.util.HashSet;
import java.util.Set;

public class Solution1461 {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        int full = 1 << k;
        // 一共 n-k+1 个子数组
        if (n - k + 1 < full) return false;

        Set<Integer> set = new HashSet<>();
        int bin = 0;
        for (int i = 0; i < k; i++) {
            bin = bin * 2 + (s.charAt(i) - '0');
        }
        set.add(bin);
        for (int i = k; i < n; i++) {
            bin = bin * 2 + (s.charAt(i) - '0');
            bin = bin & (full - 1); // 去掉最高位
            set.add(bin);
        }
        return set.size() == full;
    }
}
/*
1461. 检查一个字符串是否包含所有长度为 K 的二进制子串
https://leetcode.cn/problems/check-if-a-string-contains-all-binary-codes-of-size-k/description/

给你一个二进制字符串 s 和一个整数 k 。如果所有长度为 k 的二进制字符串都是 s 的子串，请返回 true ，否则请返回 false 。
提示：
1 <= s.length <= 5 * 10^5
s[i] 不是'0' 就是 '1'
1 <= k <= 20

定长滑动窗口 + 集合。
时间复杂度 O(n)。
 */
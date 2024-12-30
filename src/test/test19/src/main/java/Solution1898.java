import java.util.HashSet;
import java.util.Set;

public class Solution1898 {
    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0;
        int right = removable.length + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(s, p, removable, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    // 移除这些下标对应的 mid 个字符，p 是否仍然是 s 的一个 子序列。TTTFFF
    private boolean checkMid(String s, String p, int[] removable, int mid) {
        Set<Integer> rmIdxSet = new HashSet<>();
        for (int i = 0; i < mid; i++) {
            rmIdxSet.add(removable[i]);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!rmIdxSet.contains(i)) {
                stringBuilder.append(s.charAt(i));
            }
        }

        // p 是否仍然是 s 的一个 子序
        int len1 = stringBuilder.length();
        int len2 = p.length();
        int p1 = 0;
        int p2 = 0;
        while (p1 < len1 && p2 < len2) {
            if (stringBuilder.charAt(p1) == p.charAt(p2)) {
                p1++;
                p2++;
            } else {
                p1++;
            }
        }
        return p2 == len2 && stringBuilder.charAt(p1 - 1) == p.charAt(p2 - 1);
    }
}
/*
1898. 可移除字符的最大数目
https://leetcode.cn/problems/maximum-number-of-removable-characters/

给你两个字符串 s 和 p ，其中 p 是 s 的一个 子序列 。同时，给你一个元素 互不相同 且下标 从 0 开始 计数的整数数组 removable ，
该数组是 s 中下标的一个子集（s 的下标也 从 0 开始 计数）。
请你找出一个整数 k（0 <= k <= removable.length），选出 removable 中的 前 k 个下标，然后从 s 中移除这些下标对应的 k 个字符。
整数 k 需满足：在执行完上述步骤后， p 仍然是 s 的一个 子序列 。更正式的解释是，对于每个 0 <= i < k ，先标记出位于 s[removable[i]] 的字符，
接着移除所有标记过的字符，然后检查 p 是否仍然是 s 的一个子序列。
返回你可以找出的 最大 k ，满足在移除字符后 p 仍然是 s 的一个子序列。
字符串的一个 子序列 是一个由原字符串生成的新字符串，生成过程中可能会移除原字符串中的一些字符（也可能不移除）但不改变剩余字符之间的相对顺序。
提示：
1 <= p.length <= s.length <= 10^5
0 <= removable.length < s.length
0 <= removable[i] < s.length
p 是 s 的一个 子字符串
s 和 p 都由小写英文字母组成
removable 中的元素 互不相同

二分
时间复杂度 O(nlogn)
 */
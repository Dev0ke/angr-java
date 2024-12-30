import java.util.HashSet;
import java.util.Set;

public class Solution1796 {
    public int secondHighest(String s) {
        Set<Integer> hashSet = new HashSet<>();
        for (char ch : s.toCharArray()) {
            int num = ch - '0';
            if (num >= 0 && num <= 9) {
                hashSet.add(num);
            }
        }
        boolean second = false;
        for (int i = 9; i >= 0; i--) {
            if (hashSet.contains(i)) {
                if (second) {
                    return i;
                }
                second = true;
            }
        }
        return -1;
    }
}
/*
1796. 字符串中第二大的数字
https://leetcode.cn/problems/second-largest-digit-in-a-string/

给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
混合字符串 由小写英文字母和数字组成。
提示：
1 <= s.length <= 500
s 只包含小写英文字母和（或）数字。

枚举
时间复杂度 O(n)
 */
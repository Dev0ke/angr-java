public class Solution1653 {
    public int minimumDeletions(String s) {
        int rightA = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a') {
                rightA++;
            }
        }

        int leftB = 0;
        // 注意不是 min = s.length()
        int min = rightA;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                rightA--;
            } else {
                leftB++;
            }
            min = Math.min(min, rightA + leftB);
        }
        return min;
    }
}
/*
1653. 使字符串平衡的最少删除次数
https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/

给你一个字符串 s ，它仅包含字符 'a' 和 'b'。
你可以删除 s 中任意数目的字符，使得 s 平衡 。当不存在下标对 (i,j) 满足 i < j ，且 s[i] = 'b' 的同时 s[j]= 'a' ，此时认为 s 是 平衡 的。
请你返回使 s 平衡 的 最少 删除次数。
提示：
1 <= s.length <= 10^5
s[i] 要么是 'a' 要么是 'b'。

枚举
通过删除部分字符串，使得字符串达到下列三种情况之一，即为平衡状态：
- 字符串全为 a
- 字符串全为 b
- 字符串既有 a 也有 b，且所有 a 都在所有 b 左侧。
时间复杂度 O(n)
空间复杂度 O(1)
 */
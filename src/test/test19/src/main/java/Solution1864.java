import java.util.HashSet;
import java.util.Set;

public class Solution1864 {
    // NC60245C 如果只能交换两个相邻的字符
    public int minSwaps(String S) {
        int n = S.length();
        char[] s = S.toCharArray();
        Set<Integer> ones = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (s[i] == '1') {
                ones.add(i);
            }
        }
        int zeros = n - ones.size();
        if (Math.abs(zeros - ones.size()) > 1) return -1;

        if (n % 2 == 1) {
            int begin = zeros > ones.size() ? 1 : 0;
            return getAns(begin, ones);
        }
        return Math.min(getAns(0, ones), getAns(1, ones));
    }

    // 第 1 个 '1' 在下标 begin 处
    private int getAns(int begin, Set<Integer> ones) {
        int ans = 0;
        for (int from : ones) {
            if (!ones.contains(begin)) ans++;
            begin += 2;
        }
        return ans;
    }
}
/*
1864. 构成交替字符串需要的最小交换次数
https://leetcode.cn/problems/minimum-number-of-swaps-to-make-the-binary-string-alternating/description/

给你一个二进制字符串 s ，现需要将其转化为一个 交替字符串 。请你计算并返回转化所需的 最小 字符交换次数，如果无法完成转化，返回 -1 。
交替字符串 是指：相邻字符之间不存在相等情况的字符串。例如，字符串 "010" 和 "1010" 属于交替字符串，但 "0100" 不是。
任意两个字符都可以进行交换，不必相邻 。
提示：
1 <= s.length <= 1000
s[i] 的值为 '0' 或 '1'

贪心 + 双指针。
时间复杂度 O(n)。
相似题目: 游游的交换字符
https://ac.nowcoder.com/acm/contest/60245/C
 */
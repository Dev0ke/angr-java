import java.util.HashSet;
import java.util.Set;

public class SolutionP2168 {
    static final int base = 233;

    public int equalDigitFrequency(String s) {
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < s.length(); ++i) {
            int[] cnts = new int[10];
            long cur = 0;
            int maxV = 0, maxC = 0, curC = 0;
            for (int k = i; k < s.length(); ++k) {
                cur = cur * base + (s.charAt(k) - '0') + 1;
                int cnt = ++cnts[s.charAt(k) - '0'];
                if (cnt == 1) {
                    ++curC;
                }
                if (cnt > maxV) {
                    maxV = cnt;
                    maxC = 1;
                } else if (cnt == maxV) {
                    ++maxC;
                }
                if (maxC == curC) {
                    set.add(cur);
                }
            }
        }
        return set.size();
    }
}
/*
$2168. 每个数字的频率都相同的独特子字符串的数量
https://leetcode.cn/problems/unique-substrings-with-equal-digit-frequency/description/

给你一个由数字组成的字符串 s，返回 s 中独特子字符串数量，其中的每一个数字出现的频率都相同。
解释:
1 <= s.length <= 1000
s 只包含阿拉伯数字.

用字符串 hash 快速判断重复子串。
我们可以在遍历时 动态维护 各个数字出现次数的最大值的数量，如果数量 = 数字出现的个数，那么就满足条件。每次操作是 O(1) 的，和数字的个数无关。因此没有常数项 10。
https://leetcode.cn/problems/unique-substrings-with-equal-digit-frequency/solutions/1350965/o-by-newhar-ztml/
时间复杂度 O(n^2)。
 */
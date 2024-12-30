import java.math.BigInteger;

public class Solution1849 {
    private int n;
    private String s;

    public boolean splitString(String s) {
        this.n = s.length();
        this.s = s;
        for (int firstEnd = 0; firstEnd < n - 1; firstEnd++) {
            if (valid(0, firstEnd)) {
                return true;
            }
        }
        return false;
    }

    private boolean valid(int firstBegin, int firstEnd) {
        while (firstEnd <= n - 1) {
            BigInteger first = new BigInteger(s.substring(firstBegin, firstEnd + 1));
            String second = first.subtract(BigInteger.ONE).toString();
            int secondBegin = firstEnd + 1;
            // "10"
            while (secondBegin < n - 1 && s.charAt(secondBegin) == '0') {
                secondBegin++;
            }
            int secondEnd = secondBegin + second.length() - 1;
            if (secondEnd >= n || !second.equals(s.substring(secondBegin, secondEnd + 1))) {
                break;
            }
            if (secondEnd == n - 1) {
                return true;
            }
            firstBegin = secondBegin;
            firstEnd = secondEnd;
        }
        return false;
    }
}
/*
1849. 将字符串拆分为递减的连续值
https://leetcode.cn/problems/splitting-a-string-into-descending-consecutive-values/description/

给你一个仅由数字组成的字符串 s 。
请你判断能否将 s 拆分成两个或者多个 非空子字符串 ，使子字符串的 数值 按 降序 排列，且每两个 相邻子字符串 的数值之 差 等于 1 。
- 例如，字符串 s = "0090089" 可以拆分成 ["0090", "089"] ，数值为 [90,89] 。这些数值满足按降序排列，且相邻值相差 1 ，这种拆分方法可行。
- 另一个例子中，字符串 s = "001" 可以拆分成 ["0", "01"]、["00", "1"] 或 ["0", "0", "1"] 。然而，所有这些拆分方法都不可行，因为对应数值分别是 [0,1]、[0,1] 和 [0,0,1] ，都不满足按降序排列的要求。
如果可以按要求拆分 s ，返回 true ；否则，返回 false 。
子字符串 是字符串中的一个连续字符序列。
提示：
1 <= s.length <= 20
s 仅由数字组成

暴力 / 枚举。
第一个数确定后，整个序列就确定了。
时间复杂度 O(n^2)。
相似题目: 306. 累加数
https://leetcode.cn/problems/additive-number/description/
842. 将数组拆分成斐波那契序列
https://leetcode.cn/problems/split-array-into-fibonacci-sequence/description/
 */
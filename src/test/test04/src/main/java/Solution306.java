import java.math.BigInteger;

public class Solution306 {
    private int n;
    private String num;

    public boolean isAdditiveNumber(String num) {
        this.n = num.length();
        this.num = num;
        for (int secondBegin = 1; secondBegin < n - 1; secondBegin++) {
            if (num.charAt(0) == '0' && secondBegin != 1) {
                break;
            }
            for (int secondEnd = secondBegin; secondEnd < n - 1; secondEnd++) {
                // "1023" 不合法
                if (num.charAt(secondBegin) == '0' && secondEnd != secondBegin) {
                    break;
                }
                if (valid(secondBegin, secondEnd)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean valid(int secondBegin, int secondEnd) {
        int firstBegin = 0, firstEnd = secondBegin - 1;
        while (secondEnd <= n - 1) {
            BigInteger first = new BigInteger(num.substring(firstBegin, firstEnd + 1));
            BigInteger second = new BigInteger(num.substring(secondBegin, secondEnd + 1));
            String third = first.add(second).toString();
            int thirdBegin = secondEnd + 1, thirdEnd = secondEnd + third.length();
            if (thirdEnd >= n || !third.equals(num.substring(thirdBegin, thirdEnd + 1))) {
                break;
            }
            if (thirdEnd == n - 1) {
                return true;
            }
            firstBegin = secondBegin;
            firstEnd = secondEnd;
            secondBegin = thirdBegin;
            secondEnd = thirdEnd;
        }
        return false;
    }
}
/*
306. 累加数
https://leetcode.cn/problems/additive-number/description/

累加数 是一个字符串，组成它的数字可以形成累加序列。
一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，序列中的每个后续数字必须是它之前两个数字之和。
给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。
说明：累加序列里的数，除数字 0 之外，不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
提示：
1 <= num.length <= 35
num 仅由数字（0 - 9）组成
进阶：你计划如何处理由过大的整数输入导致的溢出?

枚举 / 暴力。
第一个数字和第二个数字以及总长度确定后，整个累加序列也就确定了。
时间复杂度 O(n^3)
相似题目: 842. 将数组拆分成斐波那契序列
https://leetcode.cn/problems/split-array-into-fibonacci-sequence/description/
1849. 将字符串拆分为递减的连续值
https://leetcode.cn/problems/splitting-a-string-into-descending-consecutive-values/description/
 */
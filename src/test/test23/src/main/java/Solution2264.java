public class Solution2264 {
    private static final String[] STRINGS = {"999", "888", "777", "666", "555", "444", "333", "222", "111", "000"};

    public String largestGoodInteger(String num) {
        for (String str : STRINGS) {
            if (num.contains(str)) {
                return str;
            }
        }
        return "";
    }
}
/*
2264. 字符串中最大的 3 位相同数字
https://leetcode.cn/problems/largest-3-same-digit-number-in-string/

第 292 场周赛 T1。

给你一个字符串 num ，表示一个大整数。如果一个整数满足下述所有条件，则认为该整数是一个 优质整数 ：
- 该整数是 num 的一个长度为 3 的 子字符串 。
- 该整数由唯一一个数字重复 3 次组成。
- 以字符串形式返回 最大的优质整数 。如果不存在满足要求的整数，则返回一个空字符串 "" 。
注意：
- 子字符串 是字符串中的一个连续字符序列。
- num 或优质整数中可能存在 前导零 。
提示：
3 <= num.length <= 1000
num 仅由数字（0 - 9）组成

贪心，从 "999" 枚举到 "000"
 */
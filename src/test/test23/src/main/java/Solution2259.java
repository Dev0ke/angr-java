public class Solution2259 {
    public String removeDigit(String number, char digit) {
        int len = number.length();

        String max = "";
        for (int i = 0; i < len; i++) {
            if (number.charAt(i) == digit) {
                String num = number.substring(0, i) + number.substring(i + 1, len);
                // num > res
                if (num.compareTo(max) > 0) {
                    max = num;
                }
            }
        }
        return max;
    }
}
/*
2259. 移除指定数字得到的最大结果
https://leetcode.cn/problems/remove-digit-from-number-to-maximize-result/

第 291 场周赛 T1。

给你一个表示某个正整数的字符串 number 和一个字符 digit 。
从 number 中 恰好 移除 一个 等于 digit 的字符后，找出并返回按 十进制 表示 最大 的结果字符串。生成的测试用例满足 digit 在 number 中出现至少一次。
提示：
2 <= number.length <= 100
number 由数字 '1' 到 '9' 组成
digit 是 '1' 到 '9' 中的一个数字
digit 在 number 中出现至少一次

模拟。移除一个字符后，长度是固定的，用库函数 String#compareTo(String anotherString) 比较字典序即可。
时间复杂度: 大于 O(n)，库函数不讨论时间复杂度。
 */
public class Solution2710 {
    public String removeTrailingZeros(String num) {
        return num.replaceAll("0+$", "");
    }
}
/*
2710. 移除字符串中的尾随零
https://leetcode.cn/problems/remove-trailing-zeros-from-a-string/

第 347 场周赛 T1。

给你一个用字符串表示的正整数 num ，请你以字符串形式返回不含尾随零的整数 num 。
提示：
1 <= num.length <= 1000
num 仅由数字 0 到 9 组成
num 不含前导零

正则表达式。
时间复杂度：库函数不讨论时间复杂度。
 */
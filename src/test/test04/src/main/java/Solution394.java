public class Solution394 {
    public String decodeString(String s) {
        // 最后一个 '['
        int leftIdx = s.lastIndexOf("[");
        if (leftIdx >= 0) {
            // 最后一个 '[' 配对的 ']'
            int rightIdx = s.indexOf("]", leftIdx);
            // 重复部分
            String repeat = s.substring(leftIdx + 1, rightIdx);
            // 数字左边界
            int numLeft = 0;
            for (int i = leftIdx - 1; i >= 0; i--) {
                // 第一个非数字
                if (!Character.isDigit(s.charAt(i))) {
                    numLeft = i + 1;
                    break;
                }
            }
            int time = Integer.parseInt(s.substring(numLeft, leftIdx));
            String newStr
                    // first
                    = s.substring(0, numLeft)
                    // middle
                    + repeat.repeat(time)
                    // last
                    + s.substring(rightIdx + 1);
            return decodeString(newStr);
        } else {
            return s;
        }
    }
}
/*
394. 字符串解码
https://leetcode.cn/problems/decode-string/

给定一个经过编码的字符串，返回它解码后的字符串。
编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
提示：
1 <= s.length <= 30
s 由小写英文字母、数字和方括号 '[]' 组成
s 保证是一个 有效 的输入。
s 中所有整数的取值范围为 [1, 300] 

类似某次科目一考试的题目。。
 */
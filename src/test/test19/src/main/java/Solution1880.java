public class Solution1880 {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int firstNum = caseStringToInteger(firstWord);
        int secondNum = caseStringToInteger(secondWord);
        int targetNum = caseStringToInteger(targetWord);
        return firstNum + secondNum == targetNum;
    }

    private int caseStringToInteger(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : word.toCharArray()) {
            stringBuilder.append(ch - 'a');
        }
        return Integer.parseInt(stringBuilder.toString());
    }
}
/*
1880. 检查某单词是否等于两单词之和
https://leetcode.cn/problems/check-if-word-equals-summation-of-two-words/

第 243 场周赛 T1。

字母的 字母值 取决于字母在字母表中的位置，从 0 开始 计数。即，'a' -> 0、'b' -> 1、'c' -> 2，以此类推。
对某个由小写字母组成的字符串 s 而言，其 数值 就等于将 s 中每个字母的 字母值 按顺序 连接 并 转换 成对应整数。
- 例如，s = "acb" ，依次连接每个字母的字母值可以得到 "021" ，转换为整数得到 21 。
给你三个字符串 firstWord、secondWord 和 targetWord ，每个字符串都由从 'a' 到 'j' （含 'a' 和 'j' ）的小写英文字母组成。
如果 firstWord 和 secondWord 的 数值之和 等于 targetWord 的数值，返回 true ；否则，返回 false 。
提示：
1 <= firstWord.length, secondWord.length, targetWord.length <= 8
firstWord、secondWord 和 targetWord 仅由从 'a' 到 'j' （含 'a' 和 'j' ）的小写英文字母组成。

按要求将字符串转对应数字运算即可。
 */
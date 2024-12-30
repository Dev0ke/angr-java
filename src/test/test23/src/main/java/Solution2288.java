public class Solution2288 {
    public String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.startsWith("$")) {
                try {
                    double price = Double.parseDouble(word.substring(1));
                    double newPrice = price * (100.0 - discount) / 100.0;
                    words[i] = String.format("$%.2f", newPrice);
                } catch (Exception ignored) {
                }
            }
        }
        return String.join(" ", words);
    }
}
/*
2288. 价格减免
https://leetcode.cn/problems/apply-discount-to-prices/

第 295 场周赛 T2。

句子 是由若干个单词组成的字符串，单词之间用单个空格分隔，其中每个单词可以包含数字、小写字母、和美元符号 '$' 。
如果单词的形式为美元符号后跟着一个非负实数，那么这个单词就表示一个价格。
- 例如 "$100"、"$23" 和 "$6.75" 表示价格，而 "100"、"$" 和 "2$3" 不是。
注意：本题输入中的价格均为整数。
给你一个字符串 sentence  和一个整数 discount 。对于每个表示价格的单词，都在价格的基础上减免 discount% ，并 更新 该单词到句子中。
所有更新后的价格应该表示为一个 恰好保留小数点后两位 的数字。
返回表示修改后句子的字符串。
提示：
1 <= sentence.length <= 10^5
sentence 由小写英文字母、数字、' ' 和 '$' 组成
sentence 不含前导和尾随空格
sentence 的所有单词都用单个空格分隔
所有价格都是 正 整数且不含前导零
所有价格 最多 为  10 位数字
0 <= discount <= 100

模拟。字符串操作。
 */
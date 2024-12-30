public class Solution3042 {
}
/*
3042. 统计前后缀下标对 I
https://leetcode.cn/problems/count-prefix-and-suffix-pairs-i/description/

第 385 场周赛 T1。

给你一个下标从 0 开始的字符串数组 words 。
定义一个 布尔 函数 isPrefixAndSuffix ，它接受两个字符串参数 str1 和 str2 ：
- 当 str1 同时是 str2 的前缀（prefix）和后缀（suffix）时，isPrefixAndSuffix(str1, str2) 返回 true，否则返回 false。
例如，isPrefixAndSuffix("aba", "ababa") 返回 true，因为 "aba" 既是 "ababa" 的前缀，也是 "ababa" 的后缀，但是 isPrefixAndSuffix("abc", "abcd") 返回 false。
以整数形式，返回满足 i < j 且 isPrefixAndSuffix(words[i], words[j]) 为 true 的下标对 (i, j) 的 数量 。
提示：
1 <= words.length <= 50
1 <= words[i].length <= 10
words[i] 仅由小写英文字母组成。

同: 3045. 统计前后缀下标对 II
https://leetcode.cn/problems/count-prefix-and-suffix-pairs-ii/description/
 */
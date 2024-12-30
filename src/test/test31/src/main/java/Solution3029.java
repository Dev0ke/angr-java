public class Solution3029 {
}
/*
3029. 将单词恢复初始状态所需的最短时间 I
https://leetcode.cn/problems/minimum-time-to-revert-word-to-initial-state-i/description/

第 383 场周赛 T2。

给你一个下标从 0 开始的字符串 word 和一个整数 k 。
在每一秒，你必须执行以下操作：
- 移除 word 的前 k 个字符。
- 在 word 的末尾添加 k 个任意字符。
注意 添加的字符不必和移除的字符相同。但是，必须在每一秒钟都执行 两种 操作。
返回将 word 恢复到其 初始 状态所需的 最短 时间（该时间必须大于零）。
提示：
1 <= word.length <= 50
1 <= k <= word.length
word仅由小写英文字母组成。

同: 3031. 将单词恢复初始状态所需的最短时间 II
https://leetcode.cn/problems/minimum-time-to-revert-word-to-initial-state-ii/description/
 */
public class Solution1668 {
    public int maxRepeating(String sequence, String word) {
        int cnt = 0;
        String curWork = word;
        while (sequence.contains(curWork)) {
            cnt++;
            curWork += word;
        }
        return cnt;
    }
}
/*
1668. 最大重复子字符串
https://leetcode.cn/problems/maximum-repeating-substring/

第 40 场双周赛 T1。

给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，那么单词 word 的 重复值为 k 。
单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。如果 word 不是 sequence 的子串，那么重复值 k 为 0 。
给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。
提示：
1 <= sequence.length <= 100
1 <= word.length <= 100
sequence 和 word 都只包含小写英文字母。

使用 String.contains() 判断是否为子串。
 */
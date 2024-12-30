public class Solution3307 {
    public char kthCharacter(long k, int[] operations) {
        String bin = Long.toBinaryString(k - 1);
        int n = bin.length();
        char ans = 'a';
        for (int i = 0; i < n; i++) {
            if (bin.charAt(n - 1 - i) == '1' && operations[i] == 1) {
                ans = nextChar(ans);
            }
        }
        return ans;
    }

    private char nextChar(char ch) {
        return (char) ('a' + (ch - 'a' + 1) % 26);
    }
}
/*
3307. 找出第 K 个字符 II
https://leetcode.cn/problems/find-the-k-th-character-in-string-game-ii/description/

第 417 场周赛 T4。

Alice 和 Bob 正在玩一个游戏。最初，Alice 有一个字符串 word = "a"。
给定一个正整数 k 和一个整数数组 operations，其中 operations[i] 表示第 i 次操作的类型。
现在 Bob 将要求 Alice 按顺序执行 所有 操作：
- 如果 operations[i] == 0，将 word 的一份 副本追加 到它自身。
- 如果 operations[i] == 1，将 word 中的每个字符 更改 为英文字母表中的 下一个 字符来生成一个新字符串，并将其 追加 到原始的 word。例如，对 "c" 进行操作生成 "cd"，对 "zb" 进行操作生成 "zbac"。
在执行所有操作后，返回 word 中第 k 个字符的值。
注意，在第二种类型的操作中，字符 'z' 可以变成 'a'。
提示：
1 <= k <= 10^14
1 <= operations.length <= 100
operations[i] 可以是 0 或 1。
输入保证在执行所有操作后，word 至少有 k 个字符。

找到倍增规律，与二进制进行结合。
相似题目: 3304. 找出第 K 个字符 I
https://leetcode.cn/problems/find-the-k-th-character-in-string-game-i/description/
 */
public class Solution1415 {
    public String getHappyString(int n, int k) {
        if (total(n) < k) return "";
        char[] ans = new char[n];
        int idx = 0;
        while (idx < n) {
            char pre = idx == 0 ? '0' : ans[idx - 1];
            ans[idx] = pre == 'a' ? 'b' : 'a';
            int len = 1 << (n - idx - 1);
            while (k > len) {
                ans[idx] = (char) (ans[idx] + 1);
                if (ans[idx] == pre) {
                    ans[idx] = (char) (ans[idx] + 1);
                }
                k -= len;
            }
            idx++;
        }
        return new String(ans);
    }

    private int total(int n) {
        return 3 * (1 << (n - 1));
    }
}
/*
1415. 长度为 n 的开心字符串中字典序第 k 小的字符串
https://leetcode.cn/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description/

一个 「开心字符串」定义为：
- 仅包含小写字母 ['a', 'b', 'c'].
- 对所有在 1 到 s.length - 1 之间的 i ，满足 s[i] != s[i + 1] （字符串的下标从 1 开始）。
比方说，字符串 "abc"，"ac"，"b" 和 "abcbabcbcb" 都是开心字符串，但是 "aa"，"baa" 和 "ababbc" 都不是开心字符串。
给你两个整数 n 和 k ，你需要将长度为 n 的所有开心字符串按字典序排序。
请你返回排序后的第 k 个开心字符串，如果长度为 n 的开心字符串少于 k 个，那么请你返回 空字符串 。
提示：
1 <= n <= 10
1 <= k <= 100

直接回溯的时间复杂度是 O(n*2^n)。
该题与字典序第 n 个 10 进制数思想一样
整个题解空间就是根节点包含 3 个子节点，其他非叶节点包含两个子节点（因为相邻的字母不相同）
按照第 2 步，不断判断当前已确定前缀下，子树的节点数目同目标值大小比较，寻找所在的子树
该方法可以适配解决比如总字符长度到 30，k 值到 1 个亿的取值范围
https://leetcode.cn/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/solutions/289393/jian-dan-dai-ma-shuang-100jie-ti-si-xiang-ke-kuo-z/
相似题目: 60. 排列序列
https://leetcode.cn/problems/permutation-sequence/
 */
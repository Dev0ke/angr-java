public class Solution3019 {
    public int countKeyChanges(String s) {
        int n = s.length();
        s = s.toLowerCase();
        int i = 0;
        int ans = 0;
        while (i < n) {
            for (i++; i < n && s.charAt(i) == s.charAt(i - 1); i++) {
            }
            ans++;
        }
        return ans - 1;
    }
}
/*
3019. 按键变更的次数
https://leetcode.cn/problems/number-of-changing-keys/description/

第 382 场周赛 T1。

给你一个下标从 0 开始的字符串 s ，该字符串由用户输入。按键变更的定义是：使用与上次使用的按键不同的键。例如 s = "ab" 表示按键变更一次，而 s = "bBBb" 不存在按键变更。
返回用户输入过程中按键变更的次数。
注意：shift 或 caps lock 等修饰键不计入按键变更，也就是说，如果用户先输入字母 'a' 然后输入字母 'A' ，不算作按键变更。
提示：
1 <= s.length <= 100
s 仅由英文大写字母和小写字母组成。

分组循环
时间复杂度 O(n)
 */
public class Solution1528 {
    public String restoreString(String s, int[] indices) {
        int len = s.length();
        char[] resArr = new char[len];
        for (int i = 0; i < len; i++) {
            resArr[indices[i]] = s.charAt(i);
        }
        return new String(resArr);
    }
}
/*
1528. 重新排列字符串
https://leetcode.cn/problems/shuffle-string/

第 199 场周赛 T1。

给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
返回重新排列后的字符串。
提示：
s.length == indices.length == n
1 <= n <= 100
s 仅包含小写英文字母
0 <= indices[i] < n
indices 的所有的值都是 唯一 的

模拟。
 */
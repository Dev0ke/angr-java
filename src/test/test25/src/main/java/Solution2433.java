public class Solution2433 {
    public int[] findArray(int[] pref) {
        int len = pref.length;
        int[] res = new int[len];
        res[0] = pref[0];
        for (int i = 1; i < len; i++) {
            res[i] = pref[i] ^ pref[i - 1];
        }
        return res;
    }
}
/*
2433. 找出前缀异或的原始数组
https://leetcode.cn/problems/find-the-original-array-of-prefix-xor/

第 314 场周赛 T2。

给你一个长度为 n 的 整数 数组 pref 。找出并返回满足下述条件且长度为 n 的数组 arr ：
- pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i].
注意 ^ 表示 按位异或（bitwise-xor）运算。
可以证明答案是 唯一 的。
提示：
1 <= pref.length <= 10^5
0 <= pref[i] <= 10^6

一次遍历
时间复杂度 O(n)
 */
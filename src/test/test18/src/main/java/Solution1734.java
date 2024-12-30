public class Solution1734 {
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        // 全部元素的异或运算结果
        int tot = 0;
        for (int v = 1; v <= n; v++) tot ^= v;
        // 除了 perm[0] 以外的全部元素的异或运算结果
        int odd_xor = 0;
        for (int i = 1; i < n - 1; i += 2) {
            odd_xor ^= encoded[i];
        }

        int[] ans = new int[n];
        ans[0] = tot ^ odd_xor;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] ^ encoded[i - 1];
        }
        return ans;
    }
}
/*
1734. 解码异或后的排列
https://leetcode.cn/problems/decode-xored-permutation/description/

给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
提示：
3 <= n < 10^5
n 是奇数。
encoded.length == n - 1

先求出第一个元素。然后和 1720 题一样。
相似题目: 1720. 解码异或后的数组
https://leetcode.cn/problems/decode-xored-array/description/
 */
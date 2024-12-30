public class Solution1652 {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k == 0) return ans;

        if (k > 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= k; j++) {
                    ans[i] += code[(i + j) % n];
                }
            }
        } else {
            k = -k;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= k; j++) {
                    ans[i] += code[(i - j + n) % n];
                }
            }
        }
        return ans;
    }
}
/*
1652. 拆炸弹
https://leetcode.cn/problems/defuse-the-bomb/description/

你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 n 的 循环 数组 code 以及一个密钥 k 。
为了获得正确的密码，你需要替换掉每一个数字。所有数字会 同时 被替换。
- 如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
- 如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
- 如果 k == 0 ，将第 i 个数字用 0 替换。
由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，且 code[0] 前一个元素是 code[n-1] 。
给你 循环 数组 code 和整数密钥 k ，请你返回解密后的结果来拆除炸弹！
提示：
n == code.length
1 <= n <= 100
1 <= code[i] <= 100
-(n - 1) <= k <= n - 1

模拟。
时间复杂度 O(nk)。
 */
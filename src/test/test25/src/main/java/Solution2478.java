public class Solution2478 {
    private static final int MOD = (int) (1e9 + 7);

    public int beautifulPartitions(String s, int k, int minLength) {
        int n = s.length();
        // 预处理 sn[i]==1 为质数
        int[] sn = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '2' || s.charAt(i) == '3' || s.charAt(i) == '5' || s.charAt(i) == '7') {
                sn[i] = 1;
            }
        }
        // 特判
        if (sn[0] == 0 || sn[n - 1] == 1) {
            return 0;
        }

        int[][] f = new int[k + 1][n + 1];
        f[0][0] = 1;
        for (int i = 1; i < k + 1; i++) {
            long tot = 0L;
            // 循环优化：枚举的起点和终点需要给前后的子串预留出足够的长度
            for (int j = i * minLength; j <= n - (k - i) * minLength; j++) {
                if (j - minLength == 0 || j - minLength == n || sn[j - minLength - 1] == 0 && sn[j - minLength] == 1) {
                    tot = (tot + f[i - 1][j - minLength]) % MOD;
                }
                if (j == 0 || j == n || sn[j - 1] == 0 && sn[j] == 1) {
                    f[i][j] = (int) tot;
                }
            }
        }
        return f[k][n];
    }
}
/*
2478. 完美分割的方案数
https://leetcode.cn/problems/number-of-beautiful-partitions/

第 320 场周赛 T4。

给你一个字符串 s ，每个字符是数字 '1' 到 '9' ，再给你两个整数 k 和 minLength 。
如果对 s 的分割满足以下条件，那么我们认为它是一个 完美 分割：
- s 被分成 k 段互不相交的子字符串。
- 每个子字符串长度都 至少 为 minLength 。
- 每个子字符串的第一个字符都是一个 质数 数字，最后一个字符都是一个 非质数 数字。质数数字为 '2' ，'3' ，'5' 和 '7' ，剩下的都是非质数数字。
请你返回 s 的 完美 分割数目。由于答案可能很大，请返回答案对 10^9 + 7 取余 后的结果。
一个 子字符串 是字符串中一段连续字符串序列。
提示：
1 <= k, minLength <= s.length <= 1000
s 每个字符都为数字 '1' 到 '9' 之一。

划分型 DP
1、问题中有哪些变量？
分割的个数 k
字符串的长度 n
2、重新复述一遍问题，替换变量名
把一个长为 j 的字符串，分割出 i 段的合法方案数
3、（关键）最后一步发生了什么
分割出 一个 子串
长为为 x
且这子串是 s 的一个后缀
4、去掉最后一步，问题规模缩小了，变成什么样了？
把一个长为 j-x 的字符串，分割出 i-1 段的合法方案数
5、得到状态转移方程
2 => f[i][j] 表示把 s 的前 j 个字符分割成 i 段的合法方案数
4 => f[i][j] += f[i-1][j'] j' 是第 i 段的开始下标
  枚举 j'
  j-j'+1 >= minLength
  s[j'] 是质数 s[j] 不是质数
6、初始化和答案
f[0][0] = 1
ans = f[k][n]
7、优化转移
j 变大的时候，j' 也在变大
前缀和优化 += 枚举 j'
时间复杂度 O(kn)
空间复杂度 O(kn)
 */
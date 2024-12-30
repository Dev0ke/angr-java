import java.util.ArrayList;
import java.util.List;

public class Solution2338 {
    static final int MOD = (int) (1e9 + 7);
    static final int MAX_N = (int) (1e4 + 5);
    static final int MAX_K = 13; // 至多 13 个质因数
    static List<Integer>[] ks = new ArrayList[MAX_N]; // ks[x] 为 x 分解质因数后，每个质因数的个数列表
    static long[][] c = new long[MAX_N + MAX_K][MAX_K + 1]; // 组合数

    static {
        for (int i = 1; i < MAX_N; i++) {
            ks[i] = new ArrayList<>();
            int x = i;
            for (int p = 2; p * p <= x; ++p) {
                if (x % p == 0) {
                    int k = 1;
                    for (x /= p; x % p == 0; x /= p) {
                        ++k;
                    }
                    ks[i].add(k);
                }
            }
            if (x > 1) {
                ks[i].add(1);
            }
        }

        c[0][0] = 1;
        for (int i = 1; i < MAX_N + MAX_K; i++) {
            c[i][0] = 1;
            for (int j = 1; j <= Math.min(i, MAX_K); j++) {
                c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % MOD;
            }
        }
    }

    public int idealArrays(int n, int maxValue) {
        long ans = 0L;
        for (int x = 1; x <= maxValue; x++) {
            long mul = 1L;
            for (int k : ks[x]) {
                mul = mul * c[n + k - 1][k] % MOD;
            }
            ans += mul;
        }
        return (int) (ans % MOD);
    }
}
/*
2338. 统计理想数组的数目
https://leetcode.cn/problems/count-the-number-of-ideal-arrays/description/

给你两个整数 n 和 maxValue ，用于描述一个 理想数组 。
对于下标从 0 开始、长度为 n 的整数数组 arr ，如果满足以下条件，则认为该数组是一个 理想数组 ：
- 每个 arr[i] 都是从 1 到 maxValue 范围内的一个值，其中 0 <= i < n 。
- 每个 arr[i] 都可以被 arr[i - 1] 整除，其中 0 < i < n 。
返回长度为 n 的 不同 理想数组的数目。由于答案可能很大，返回对 10^9 + 7 取余的结果。
提示：
2 <= n <= 10^4
1 <= maxValue <= 10^4

Prime omega function https://en.wikipedia.org/wiki/Prime_omega_function
https://leetcode.cn/problems/count-the-number-of-ideal-arrays/solutions/1659088/shu-lun-zu-he-shu-xue-zuo-fa-by-endlessc-iouh/
相似题目: 2818. 操作使得分最大
https://leetcode.cn/problems/apply-operations-to-maximize-score/
 */
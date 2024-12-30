import java.util.Arrays;

public class SolutionP1259 {
    private static final int MOD = (int) (1e9 + 7);

    public int numberOfWays(int numPeople) {
        // f[i] 表示 i 个人连线不会相交的握手方案数
        long[] f = new long[numPeople + 1];
        Arrays.fill(f, 1);

        for (int i = 2; i <= numPeople; i += 2) {
            f[i] = 0;
            for (int j = 1; j < i; j += 2) {
                f[i] = (f[i] + f[j - 1] * f[i - j - 1]) % MOD;
            }
        }
        return (int) f[numPeople];
    }
}
/*
$1259. 不相交的握手
https://leetcode.cn/problems/handshakes-that-dont-cross/

偶数 个人站成一个圆，总人数为 num_people 。每个人与除自己外的一个人握手，所以总共会有 num_people / 2 次握手。
将握手的人之间连线，请你返回连线不会相交的握手方案数。
由于结果可能会很大，请你返回答案 模 10^9+7 后的结果。
提示：
2 <= num_people <= 1000
num_people % 2 == 0

动态规划。
 */
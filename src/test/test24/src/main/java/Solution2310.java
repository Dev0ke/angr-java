public class Solution2310 {
    public int minimumNumbers(int num, int k) {
        if (num == 0) {
            return 0;
        }

        // 个数
        for (int i = 1; i <= 10; i++) {
            int product = k * i;
            // 个位数字
            if (num % 10 == product % 10 && num >= product) {
                return i;
            }
        }
        return -1;
    }
}
/*
2310. 个位数字为 K 的整数之和
https://leetcode.cn/problems/sum-of-numbers-with-units-digit-k/

第 298 场周赛 T2。

给你两个整数 num 和 k ，考虑具有以下属性的正整数多重集：
- 每个整数个位数字都是 k 。
- 所有整数之和是 num 。
返回该多重集的最小大小，如果不存在这样的多重集，返回 -1 。
注意：
- 多重集与集合类似，但多重集可以包含多个同一整数，空多重集的和为 0 。
- 个位数字 是数字最右边的数位。
提示：
0 <= num <= 3000
0 <= k <= 9

数学。从 九九乘法表 中可以观察出，对 0-9 每个数而言，循环最多不会超过 10。
0 需要进行特判。
 */
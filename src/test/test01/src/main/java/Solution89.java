import java.util.ArrayList;
import java.util.List;

public class Solution89 {
    public List<Integer> grayCode(int n) {
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            resList.add(g(i));
        }
        return resList;
    }

    private int g(int n) {
        return n ^ (n >> 1);
    }
}
/*
89. 格雷编码
https://leetcode.cn/problems/gray-code/

n 位格雷码序列 是一个由 2^n 个整数组成的序列，其中：
- 每个整数都在范围 [0, 2^n - 1] 内（含 0 和 2^n - 1）
- 第一个整数是 0
- 一个整数在序列中出现 不超过一次
- 每对 相邻 整数的二进制表示 恰好一位不同 ，且
- 第一个 和 最后一个 整数的二进制表示 恰好一位不同
给你一个整数 n ，返回任一有效的 n 位格雷码序列 。
提示：
1 <= n <= 16

位运算
时间复杂度 O(2^n)
相似题目: 1238. 循环码排列
https://leetcode.cn/problems/circular-permutation-in-binary-representation/
1611. 使整数变为 0 的最少操作次数
https://leetcode.cn/problems/minimum-one-bit-operations-to-make-integers-zero/description/
 */
import java.util.ArrayList;
import java.util.List;

public class Solution1238 {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            resList.add(start ^ g(i));
        }
        return resList;
    }

    private int g(int n) {
        return n ^ (n >> 1);
    }
}
/*
1238. 循环码排列
https://leetcode.cn/problems/circular-permutation-in-binary-representation/

给你两个整数 n 和 start。你的任务是返回任意 (0,1,2,,...,2^n-1) 的排列 p，并且满足：
- p[0] = start
- p[i] 和 p[i+1] 的二进制表示形式只有一位不同
- p[0] 和 p[2^n -1] 的二进制表示形式也只有一位不同
提示：
1 <= n <= 16
0 <= start < 2^n

格雷码
相似题目: 89. 格雷编码
https://leetcode.cn/problems/gray-code/
 */
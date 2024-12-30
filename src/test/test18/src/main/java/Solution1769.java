public class Solution1769 {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        char[] cs = boxes.toCharArray();

        // lcnt1 表示 [0,i] '1' 的数量, rcnt1 表示 [i+1,n-1] '1' 的数量
        int lcnt1 = cs[0] - '0', rcnt1 = 0;
        // 操作数
        int ops = 0;
        for (int i = 1; i < n; i++) {
            if (cs[i] == '1') {
                rcnt1++;
                ops += i;
            }
        }

        int[] res = new int[n];
        res[0] = ops;
        for (int i = 1; i < n; i++) {
            ops += lcnt1 - rcnt1;
            if (cs[i] == '1') {
                lcnt1++;
                rcnt1--;
            }
            res[i] = ops;
        }
        return res;
    }
}
/*
1769. 移动所有球到每个盒子所需的最小操作数
https://leetcode.cn/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/

有 n 个盒子。给你一个长度为 n 的二进制字符串 boxes ，其中 boxes[i] 的值为 '0' 表示第 i 个盒子是 空 的，而 boxes[i] 的值为 '1' 表示盒子里有 一个 小球。
在一步操作中，你可以将 一个 小球从某个盒子移动到一个与之相邻的盒子中。第 i 个盒子和第 j 个盒子相邻需满足 abs(i - j) == 1 。注意，操作执行后，某些盒子中可能会存在不止一个小球。
返回一个长度为 n 的数组 answer ，其中 answer[i] 是将所有小球移动到第 i 个盒子所需的 最小 操作数。
每个 answer[i] 都需要根据盒子的 初始状态 进行计算。
提示：
n == boxes.length
1 <= n <= 2000
boxes[i] 为 '0' 或 '1'

递推。根据前一个盒子的操作数得到下一个盒子的操作数
时间复杂度 O(n)
 */
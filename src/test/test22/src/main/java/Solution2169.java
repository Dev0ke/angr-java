public class Solution2169 {
    public int countOperations(int num1, int num2) {
        int cnt = 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }
            cnt++;
        }
        return cnt;
    }
}
/*
2169. 得到 0 的操作数
https://leetcode.cn/problems/count-operations-to-obtain-zero/

第 280 场周赛 T1。

给你两个 非负 整数 num1 和 num2 。
每一步 操作 中，如果 num1 >= num2 ，你必须用 num1 减 num2 ；否则，你必须用 num2 减 num1 。
- 例如，num1 = 5 且 num2 = 4 ，应该用 num1 减 num2 ，因此，得到 num1 = 1 和 num2 = 4 。然而，如果 num1 = 4且 num2 = 5 ，一步操作后，得到 num1 = 4 和 num2 = 1 。
返回使 num1 = 0 或 num2 = 0 的 操作数 。
提示：
0 <= num1, num2 <= 10^5

模拟。
 */
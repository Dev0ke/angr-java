public class SolutionP1088 {
    private static final int[] NUM = {0, 1, 6, 8, 9};
    private static final int[] REV = {0, 1, 9, 8, 6};
    private int n;
    private int res;

    public int confusingNumberII(int n) {
        this.n = n;
        res = 0;
        dfs(0, 0, 0);
        return res;
    }

    private void dfs(int cur, int rev, int digit) {
        if (cur > n) {
            return;
        }
        if (cur != rev) {
            res++;
        }

        for (int i = 0; i < 5; i++) {
            if (digit == 0 && i == 0) {
                // 前导零不符合要求
                continue;
            }
            if (cur > n / 10) {
                // 剪枝 重要！
                return;
            }
            int nextCur = cur * 10 + NUM[i];
            int nextRev = REV[i] * (int) Math.pow(10, digit) + rev;
            dfs(nextCur, nextRev, digit + 1);
        }
    }
}
/*
$1088. 易混淆数 II
https://leetcode.cn/problems/confusing-number-ii/

易混淆数（Confusing Number）指的是一个数字在整体旋转 180° 以后，能够得到一个和原来 不同 的数，且 新数字的每一位都应该是有效的。
本题我们会将数字旋转 180° 来生成一个新的数字。
- 当 0、1、6、8、9 旋转 180° 以后，我们得到的新数字分别为 0、1、9、8、6。
- 当 2、3、4、5、7 旋转 180° 后，是 无法 得到任何数字的。
请注意，在旋转一个数字之后，我们可以忽略前导零。
- 例如，在旋转 8000 之后，我们有 0008 ，它被认为只是 8 。
给出正整数 n，请你返回  [1, n] 范围内的 易混淆数 的数量 。
提示：
1 <= n <= 10^9

DFS
相似题目: $1056. 易混淆数
https://leetcode.cn/problems/confusing-number/
 */
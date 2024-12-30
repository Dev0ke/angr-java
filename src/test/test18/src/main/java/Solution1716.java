public class Solution1716 {
    private int[] nums;
    private int[] preSum;

    public int totalMoney(int n) {
        if (nums == null) {
            nums = new int[1001];
            int monday = 1;
            // 1 <= n <= 1000
            for (int i = 1; i <= 1000; i++) {
                if (i % 7 == 1) {
                    nums[i] = monday++;
                } else {
                    nums[i] = nums[i - 1] + 1;
                }
            }
            int len = nums.length;
            preSum = new int[len + 1];
            for (int i = 0; i < len; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
            }
        }
        return preSum[n + 1] - preSum[1];
    }
}
/*
1716. 计算力扣银行的钱
https://leetcode.cn/problems/calculate-money-in-leetcode-bank/

第 43 场双周赛 T1。

Hercy 想要为购买第一辆车存钱。他 每天 都往力扣银行里存钱。
最开始，他在周一的时候存入 1 块钱。从周二到周日，他每天都比前一天多存入 1 块钱。在接下来每一个周一，他都会比 前一个周一 多存入 1 块钱。
给你 n ，请你返回在第 n 天结束的时候他在力扣银行总共存了多少块钱。
提示：
1 <= n <= 1000

预处理前缀和。
时间复杂度 O(n)
 */
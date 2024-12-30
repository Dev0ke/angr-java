public class Solution2241 {
    static class ATM {
        private static final int[] DENOMINATION = {20, 50, 100, 200, 500};
        private final long[] bank;

        public ATM() {
            bank = new long[5];
        }

        public void deposit(int[] banknotesCount) {
            for (int i = 0; i < 5; i++) {
                bank[i] += banknotesCount[i];
            }
        }

        public int[] withdraw(int amount) {
            int[] yes = new int[5];
            int[] no = {-1};

            // 取款时，机器会优先取 较大 数额的钱。
            for (int i = 4; i >= 0; i--) {
                yes[i] = (int) Math.min(bank[i], amount / DENOMINATION[i]);
                amount -= yes[i] * DENOMINATION[i];
            }
            if (amount == 0) {
                for (int i = 0; i < 5; i++) {
                    bank[i] -= yes[i];
                }
                return yes;
            }
            return no;
        }
    }

}
/*
2241. 设计一个 ATM 机器
https://leetcode.cn/problems/design-an-atm-machine/

第 76 场双周赛 T3。

一个 ATM 机器，存有 5 种面值的钞票：20 ，50 ，100 ，200 和 500 美元。初始时，ATM 机是空的。用户可以用它存或者取任意数目的钱。
取款时，机器会优先取 较大 数额的钱。
- 比方说，你想取 $300 ，并且机器里有 2 张 $50 的钞票，1 张 $100 的钞票和1 张 $200 的钞票，那么机器会取出 $100 和 $200 的钞票。
- 但是，如果你想取 $600 ，机器里有 3 张 $200 的钞票和1 张 $500 的钞票，那么取款请求会被拒绝，因为机器会先取出 $500 的钞票，
然后无法取出剩余的 $100 。注意，因为有 $500 钞票的存在，机器 不能 取 $200 的钞票。
请你实现 ATM 类：
- ATM() 初始化 ATM 对象。
- void deposit(int[] banknotesCount) 分别存入 $20 ，$50，$100，$200 和 $500 钞票的数目。
- int[] withdraw(int amount) 返回一个长度为 5 的数组，分别表示 $20 ，$50，$100 ，$200 和 $500 钞票的数目，
并且更新 ATM 机里取款后钞票的剩余数量。如果无法取出指定数额的钱，请返回 [-1] （这种情况下 不 取出任何钞票）。
提示：
banknotesCount.length == 5
0 <= banknotesCount[i] <= 10^9
1 <= amount <= 10^9
总共 最多有 5000 次 withdraw 和 deposit 的调用。
函数 withdraw 和 deposit 至少各有 一次 调用。

比赛时看了大半个小时没看懂题。错误理解成要将面额较大的钱取完才能取面额较小的钱，不能跳面额。。。
想取 $600 ，机器里有 3 张 $200 的钞票和1 张 $500 的钞票 => 因为有 $500 钞票的存在，机器 不能 取 $200 的钞票
想取 $600 ，机器里有 1 张 $100 ，2 张 $200 和 1 张 $500 的钞票 => 机器返回 1 张 $100 和 1 张 $500 的钞票
 */
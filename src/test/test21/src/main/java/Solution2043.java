import java.util.HashMap;
import java.util.Map;

public class Solution2043 {
    static class Bank {
        private final Map<Integer, Long> hashMap;

        public Bank(long[] balance) {
            hashMap = new HashMap<>();
            for (int i = 0; i < balance.length; i++) {
                hashMap.put(i + 1, balance[i]);
            }
        }

        public boolean transfer(int account1, int account2, long money) {
            if (hashMap.containsKey(account1) && hashMap.containsKey(account2)) {
                long balance1 = hashMap.get(account1);
                if (balance1 >= money) {
                    hashMap.put(account1, balance1 - money);
                    hashMap.put(account2, hashMap.get(account2) + money);
                    return true;
                }
            }
            return false;
        }

        public boolean deposit(int account, long money) {
            if (hashMap.containsKey(account)) {
                long balance = hashMap.get(account);
                hashMap.put(account, balance + money);
                return true;
            }
            return false;
        }

        public boolean withdraw(int account, long money) {
            if (hashMap.containsKey(account)) {
                long balance = hashMap.get(account);
                if (balance >= money) {
                    hashMap.put(account, balance - money);
                    return true;
                }
            }
            return false;
        }
    }
}
/*
2043. 简易银行系统
https://leetcode.cn/problems/simple-bank-system/

第 263 场周赛 T2。

你的任务是为一个很受欢迎的银行设计一款程序，以自动化执行所有传入的交易（转账，存款和取款）。银行共有 n 个账户，编号从 1 到 n 。
每个账号的初始余额存储在一个下标从 0 开始的整数数组 balance 中，其中第 (i + 1) 个账户的初始余额是 balance[i] 。
请你执行所有 有效的 交易。如果满足下面全部条件，则交易 有效 ：
- 指定的账户数量在 1 和 n 之间，且
- 取款或者转账需要的钱的总数 小于或者等于 账户余额。
实现 Bank 类：
- Bank(long[] balance) 使用下标从 0 开始的整数数组 balance 初始化该对象。
- boolean transfer(int account1, int account2, long money) 从编号为 account1 的账户向编号为 account2 的账户转帐 money 美元。
如果交易成功，返回 true ，否则，返回 false 。
- boolean deposit(int account, long money) 向编号为 account 的账户存款 money 美元。如果交易成功，返回 true ；否则，返回 false 。
- boolean withdraw(int account, long money) 从编号为 account 的账户取款 money 美元。如果交易成功，返回 true ；否则，返回 false 。

HashMap 模拟。
2021-10-20 rejudge WA: transfer account1 account2 是同一个账户时的情况
 */
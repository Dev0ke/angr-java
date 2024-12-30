import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2043Tests {
    @Test
    public void example1() {
        long[] balance = {10, 100, 20, 50, 30};
        Solution2043.Bank bank = new Solution2043.Bank(balance);

        // 返回 true ，账户 3 的余额是 $20 ，所以可以取款 $10 。
        Assertions.assertTrue(bank.withdraw(3, 10));

        // 账户 3 余额为 $20 - $10 = $10 。
        // 返回 true ，账户 5 的余额是 $30 ，所以可以转账 $20 。
        Assertions.assertTrue(bank.transfer(5, 1, 20));

        // 账户 5 的余额为 $30 - $20 = $10 ，账户 1 的余额为 $10 + $20 = $30 。
        // 返回 true ，可以向账户 5 存款 $20 。
        Assertions.assertTrue(bank.deposit(5, 20));

        // 账户 5 的余额为 $10 + $20 = $30 。
        // 返回 false ，账户 3 的当前余额是 $10 。
        Assertions.assertFalse(bank.transfer(3, 4, 15));

        // 所以无法转账 $15 。
        // 返回 false ，交易无效，因为账户 10 并不存在。
        Assertions.assertFalse(bank.withdraw(10, 50));
    }

    // 补充用例
    @Test
    public void example2() {
        long[] balance = {0};
        Solution2043.Bank bank = new Solution2043.Bank(balance);
        Assertions.assertTrue(bank.deposit(1, 2));
        Assertions.assertTrue(bank.transfer(1, 1, 1));
        Assertions.assertFalse(bank.transfer(1, 1, 3));
    }
}

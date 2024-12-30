import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2241Tests {
    @Test
    public void example1() {
        Solution2241.ATM atm = new Solution2241.ATM();
        // 存入 1 张 $100 ，2 张 $200 和 1 张 $500 的钞票。
        atm.deposit(new int[]{0, 0, 1, 2, 1});
        // 返回 [0,0,1,0,1] 。机器返回 1 张 $100 和 1 张 $500 的钞票。机器里剩余钞票的数量为 [0,0,0,2,0] 。
        Assertions.assertArrayEquals(new int[]{0, 0, 1, 0, 1}, atm.withdraw(600));
        // 存入 1 张 $50 ，1 张 $200 和 1 张 $500 的钞票。
        atm.deposit(new int[]{0, 1, 0, 1, 1});
        // 机器中剩余钞票数量为 [0,1,0,3,1] 。
        // 返回 [-1] 。机器会尝试取出 $500 的钞票，然后无法得到剩余的 $100 ，所以取款请求会被拒绝。
        Assertions.assertArrayEquals(new int[]{-1}, atm.withdraw(600));
        // 由于请求被拒绝，机器中钞票的数量不会发生改变。
        // 返回 [0,1,0,0,1] ，机器会返回 1 张 $50 的钞票和 1 张 $500 的钞票。
        Assertions.assertArrayEquals(new int[]{0, 1, 0, 0, 1}, atm.withdraw(550));
    }
}

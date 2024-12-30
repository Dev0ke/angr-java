import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2806Tests {
    private final Solution2806 solution2806 = new Solution2806();

    @Test
    public void example1() {
        int purchaseAmount = 9;
        int expected = 90;
        Assertions.assertEquals(expected, solution2806.accountBalanceAfterPurchase(purchaseAmount));
    }

    @Test
    public void example2() {
        int purchaseAmount = 15;
        int expected = 80;
        Assertions.assertEquals(expected, solution2806.accountBalanceAfterPurchase(purchaseAmount));
    }
}
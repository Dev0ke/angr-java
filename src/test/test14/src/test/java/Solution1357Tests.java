import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1357Tests {
    @Test
    public void example1() {
        int n = 3;
        int discount = 50;
        int[] products = {1, 2, 3, 4, 5, 6, 7};
        int[] prices = {100, 200, 300, 400, 300, 200, 100};
        Solution1357.Cashier cashier = new Solution1357.Cashier(n, discount, products, prices);

        // 返回 500.0, 账单金额为 = 1 * 100 + 2 * 200 = 500.
        int[] product = {1, 2};
        int[] amount = {1, 2};
        double expected = 500.0;
        Assertions.assertEquals(expected, cashier.getBill(product, amount));

        // 返回 4000.0
        product = new int[]{3, 7};
        amount = new int[]{10, 10};
        expected = 4000.0;
        Assertions.assertEquals(expected, cashier.getBill(product, amount));

        // 返回 800.0 ，账单原本为 1600.0 ，但由于该顾客是第三位顾客，他将得到 50% 的折扣，所以实际金额为 1600 - 1600 * (50 / 100) = 800 。
        product = new int[]{1, 2, 3, 4, 5, 6, 7};
        amount = new int[]{1, 1, 1, 1, 1, 1, 1};
        expected = 800.0;
        Assertions.assertEquals(expected, cashier.getBill(product, amount));

        // 返回 4000.0
        product = new int[]{4};
        amount = new int[]{10};
        expected = 4000.0;
        Assertions.assertEquals(expected, cashier.getBill(product, amount));

        // 返回 4000.0
        product = new int[]{7, 3};
        amount = new int[]{10, 10};
        expected = 4000.0;
        Assertions.assertEquals(expected, cashier.getBill(product, amount));

        // 返回 7350.0 ，账单原本为 14700.0 ，但由于系统计数再次达到三，该顾客将得到 50% 的折扣，实际金额为 7350.0 。
        product = new int[]{7, 5, 3, 1, 6, 4, 2};
        amount = new int[]{10, 10, 10, 9, 9, 9, 7};
        expected = 7350.0;
        Assertions.assertEquals(expected, cashier.getBill(product, amount));

        // 返回 2500.0
        product = new int[]{2, 3, 5};
        amount = new int[]{5, 3, 2};
        expected = 2500.0;
        Assertions.assertEquals(expected, cashier.getBill(product, amount));
    }
}
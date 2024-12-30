import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2288Tests {
    private final Solution2288 solution2288 = new Solution2288();

    @Test
    public void example1() {
        String sentence = "there are $1 $2 and 5$ candies in the shop";
        int discount = 50;
        String expected = "there are $0.50 $1.00 and 5$ candies in the shop";
        Assertions.assertEquals(expected, solution2288.discountPrices(sentence, discount));
    }

    @Test
    public void example2() {
        String sentence = "1 2 $3 4 $5 $6 7 8$ $9 $10$";
        int discount = 100;
        String expected = "1 2 $0.00 4 $0.00 $0.00 7 8$ $0.00 $10$";
        Assertions.assertEquals(expected, solution2288.discountPrices(sentence, discount));
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3099Tests {
    private final Solution3099 solution3099 = new Solution3099();

    @Test
    public void example1() {
        int x = 18;
        int expected = 9;
        Assertions.assertEquals(expected, solution3099.sumOfTheDigitsOfHarshadNumber(x));
    }

    @Test
    public void example2() {
        int x = 23;
        int expected = -1;
        Assertions.assertEquals(expected, solution3099.sumOfTheDigitsOfHarshadNumber(x));
    }
}
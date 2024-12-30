import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1281Tests {
    private final Solution1281 solution1281 = new Solution1281();

    @Test
    public void example1() {
        int n = 234;
        int expected = 15;
        Assertions.assertEquals(expected, solution1281.subtractProductAndSum(n));
    }

    @Test
    public void example2() {
        int n = 4421;
        int expected = 21;
        Assertions.assertEquals(expected, solution1281.subtractProductAndSum(n));
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution371Tests {
    private final Solution371 solution371 = new Solution371();

    @Test
    public void example1() {
        int a = 1;
        int b = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution371.getSum(a, b));
    }

    @Test
    public void example2() {
        int a = 2;
        int b = 3;
        int expected = 5;
        Assertions.assertEquals(expected, solution371.getSum(a, b));
    }
}
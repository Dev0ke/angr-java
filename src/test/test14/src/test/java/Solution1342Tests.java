import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1342Tests {
    private final Solution1342 solution1342 = new Solution1342();

    @Test
    public void example1() {
        int num = 14;
        int expected = 6;
        Assertions.assertEquals(expected, solution1342.numberOfSteps(num));
    }

    @Test
    public void example2() {
        int num = 8;
        int expected = 4;
        Assertions.assertEquals(expected, solution1342.numberOfSteps(num));
    }

    @Test
    public void example3() {
        int num = 123;
        int expected = 12;
        Assertions.assertEquals(expected, solution1342.numberOfSteps(num));
    }
}

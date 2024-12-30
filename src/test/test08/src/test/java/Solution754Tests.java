import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution754Tests {
    private final Solution754 solution754 = new Solution754();

    @Test
    public void example1() {
        int target = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution754.reachNumber(target));
    }

    @Test
    public void example2() {
        int target = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution754.reachNumber(target));
    }
}
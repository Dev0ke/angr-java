import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution461Tests {
    private final Solution461 solution461 = new Solution461();

    @Test
    public void example1() {
        int x = 1;
        int y = 4;
        int expected = 2;
        Assertions.assertEquals(expected, solution461.hammingDistance(x, y));
    }

    @Test
    public void example2() {
        int x = 3;
        int y = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution461.hammingDistance(x, y));
    }
}

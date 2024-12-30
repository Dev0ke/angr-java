import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2954Tests {
    private final Solution2954 solution2954 = new Solution2954();

    @Test
    public void example1() {
        int n = 5;
        int[] sick = {0, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solution2954.numberOfSequence(n, sick));
    }

    @Test
    public void example2() {
        int n = 4;
        int[] sick = {1};
        int expected = 3;
        Assertions.assertEquals(expected, solution2954.numberOfSequence(n, sick));
    }
}
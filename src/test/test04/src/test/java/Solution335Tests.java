import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution335Tests {
    private final Solution335 solution335 = new Solution335();

    @Test
    public void example1() {
        int[] distance = {2, 1, 1, 2};
        Assertions.assertTrue(solution335.isSelfCrossing(distance));
    }

    @Test
    public void example2() {
        int[] distance = {1, 2, 3, 4};
        Assertions.assertFalse(solution335.isSelfCrossing(distance));
    }

    @Test
    public void example3() {
        int[] distance = {1, 1, 1, 1};
        Assertions.assertTrue(solution335.isSelfCrossing(distance));
    }
}

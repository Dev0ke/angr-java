import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2244Tests {
    private final Solution2244 solution2244 = new Solution2244();

    @Test
    public void example1() {
        int[] tasks = {2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solution2244.minimumRounds(tasks));
    }

    @Test
    public void example2() {
        int[] tasks = {2, 3, 3};
        int expected = -1;
        Assertions.assertEquals(expected, solution2244.minimumRounds(tasks));
    }
}

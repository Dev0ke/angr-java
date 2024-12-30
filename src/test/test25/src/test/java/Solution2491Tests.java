import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2491Tests {
    private final Solution2491 solution2491 = new Solution2491();

    @Test
    public void example1() {
        int[] skill = {3, 2, 5, 1, 3, 4};
        int expected = 22;
        Assertions.assertEquals(expected, solution2491.dividePlayers(skill));
    }

    @Test
    public void example2() {
        int[] skill = {3, 4};
        int expected = 12;
        Assertions.assertEquals(expected, solution2491.dividePlayers(skill));
    }

    @Test
    public void example3() {
        int[] skill = {1, 1, 2, 3};
        int expected = -1;
        Assertions.assertEquals(expected, solution2491.dividePlayers(skill));
    }
}

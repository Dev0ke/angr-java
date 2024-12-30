import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2399Tests {
    private final Solution2399 solution2399 = new Solution2399();

    @Test
    public void example1() {
        String s = "abaccb";
        int[] distance = {1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Assertions.assertTrue(solution2399.checkDistances(s, distance));
    }

    @Test
    public void example2() {
        String s = "aa";
        int[] distance = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Assertions.assertFalse(solution2399.checkDistances(s, distance));
    }
}

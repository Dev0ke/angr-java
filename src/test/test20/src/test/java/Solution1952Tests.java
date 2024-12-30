import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1952Tests {
    private final Solution1952 solution1952 = new Solution1952();

    @Test
    public void example1() {
        int n = 2;
        Assertions.assertFalse(solution1952.isThree(n));
    }

    @Test
    public void example2() {
        int n = 4;
        Assertions.assertTrue(solution1952.isThree(n));
    }
}

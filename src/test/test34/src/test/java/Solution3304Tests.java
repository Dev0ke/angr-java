import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3304Tests {
    private final Solution3304 solution3304 = new Solution3304();

    @Test
    public void example1() {
        int k = 5;
        char expected = 'b';
        Assertions.assertEquals(expected, solution3304.kthCharacter(k));
    }

    @Test
    public void example2() {
        int k = 10;
        char expected = 'c';
        Assertions.assertEquals(expected, solution3304.kthCharacter(k));
    }
}
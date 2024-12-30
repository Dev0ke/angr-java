import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3307Tests {
    private final Solution3307 solution3307 = new Solution3307();

    @Test
    public void example1() {
        long k = 5;
        int[] operations = {0, 0, 0};
        char expected = 'a';
        Assertions.assertEquals(expected, solution3307.kthCharacter(k, operations));
    }

    @Test
    public void example2() {
        long k = 10;
        int[] operations = {0, 1, 0, 1};
        char expected = 'b';
        Assertions.assertEquals(expected, solution3307.kthCharacter(k, operations));
    }
}
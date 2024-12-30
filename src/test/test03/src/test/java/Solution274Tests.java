import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution274Tests {
    private final Solution274 solution274 = new Solution274();

    @Test
    public void example1() {
        int[] citations = {3, 0, 6, 1, 5};
        int expected = 3;
        Assertions.assertEquals(expected, solution274.hIndex(citations));
    }

    @Test
    public void example2() {
        int[] citations = {1, 3, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution274.hIndex(citations));
    }
}

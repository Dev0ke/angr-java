import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1444Tests {
    private final Solution1444 solution1444 = new Solution1444();

    @Test
    public void example1() {
        String[] pizza = {"A..", "AAA", "..."};
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution1444.ways(pizza, k));
    }

    @Test
    public void example2() {
        String[] pizza = {"A..", "AA.", "..."};
        int k = 3;
        int expected = 1;
        Assertions.assertEquals(expected, solution1444.ways(pizza, k));
    }

    @Test
    public void example3() {
        String[] pizza = {"A..", "A..", "..."};
        int k = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution1444.ways(pizza, k));
    }
}
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution386Tests {
    private final Solution386 solution386 = new Solution386();

    @Test
    public void example1() {
        int n = 13;
        List<Integer> expected = List.of(1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9);
        Assertions.assertEquals(expected, solution386.lexicalOrder(n));
    }

    @Test
    public void example2() {
        int n = 2;
        List<Integer> expected = List.of(1, 2);
        Assertions.assertEquals(expected, solution386.lexicalOrder(n));
    }
}

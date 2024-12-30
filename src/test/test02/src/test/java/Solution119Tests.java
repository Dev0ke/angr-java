import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution119Tests {
    private final Solution119 solution119 = new Solution119();

    @Test
    public void example1() {
        int numRows = 3;
        List<Integer> expected = List.of(1, 3, 3, 1);
        Assertions.assertEquals(expected, solution119.getRow(numRows));
    }

    @Test
    public void example2() {
        int numRows = 0;
        List<Integer> expected = List.of(1);
        Assertions.assertEquals(expected, solution119.getRow(numRows));
    }

    @Test
    public void example3() {
        int numRows = 1;
        List<Integer> expected = List.of(1, 1);
        Assertions.assertEquals(expected, solution119.getRow(numRows));
    }
}

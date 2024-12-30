import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1104Tests {
    private final Solution1104 solution1104 = new Solution1104();

    @Test
    public void example1() {
        int label = 14;
        List<Integer> expected = List.of(1, 3, 4, 14);
        Assertions.assertEquals(expected, solution1104.pathInZigZagTree(label));
    }

    @Test
    public void example2() {
        int label = 26;
        List<Integer> expected = List.of(1, 2, 6, 10, 26);
        Assertions.assertEquals(expected, solution1104.pathInZigZagTree(label));
    }
}
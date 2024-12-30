import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution658Tests {
    private final Solution658 solution658 = new Solution658();

    @Test
    public void example1() {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        List<Integer> expected = List.of(1, 2, 3, 4);
        Assertions.assertEquals(expected, solution658.findClosestElements(arr, k, x));
    }

    @Test
    public void example2() {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = -1;
        List<Integer> expected = List.of(1, 2, 3, 4);
        Assertions.assertEquals(expected, solution658.findClosestElements(arr, k, x));
    }
}

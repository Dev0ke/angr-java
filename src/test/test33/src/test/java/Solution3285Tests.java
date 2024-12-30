import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution3285Tests {
    private final Solution3285 solution3285 = new Solution3285();

    @Test
    public void example1() {
        int[] height = {1, 2, 3, 4, 5};
        int threshold = 2;
        List<Integer> expected = Arrays.asList(3, 4);
        Assertions.assertEquals(expected, solution3285.stableMountains(height, threshold));
    }

    @Test
    public void example2() {
        int[] height = {10, 1, 10, 1, 10};
        int threshold = 3;
        List<Integer> expected = Arrays.asList(1, 3);
        Assertions.assertEquals(expected, solution3285.stableMountains(height, threshold));
    }

    @Test
    public void example3() {
        int[] height = {10, 1, 10, 1, 10};
        int threshold = 10;
        List<Integer> expected = Arrays.asList();
        Assertions.assertEquals(expected, solution3285.stableMountains(height, threshold));
    }
}
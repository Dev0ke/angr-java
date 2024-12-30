import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution2951Tests {
    private final Solution2951 solution2951 = new Solution2951();

    @Test
    public void example1() {
        int[] mountain = {2, 4, 4};
        List<Integer> expected = Arrays.asList();
        Assertions.assertEquals(expected, solution2951.findPeaks(mountain));
    }

    @Test
    public void example2() {
        int[] mountain = {1, 4, 3, 8, 5};
        List<Integer> expected = Arrays.asList(1, 3);
        Assertions.assertEquals(expected, solution2951.findPeaks(mountain));
    }
}
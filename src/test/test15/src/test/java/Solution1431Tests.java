import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1431Tests {
    private final Solution1431 solution1431 = new Solution1431();

    @Test
    public void example1() {
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        List<Boolean> expected = List.of(true, true, true, false, true);
        Assertions.assertEquals(expected, solution1431.kidsWithCandies(candies, extraCandies));
    }

    @Test
    public void example2() {
        int[] candies = {4, 2, 1, 1, 2};
        int extraCandies = 1;
        List<Boolean> expected = List.of(true, false, false, false, false);
        Assertions.assertEquals(expected, solution1431.kidsWithCandies(candies, extraCandies));
    }

    @Test
    public void example3() {
        int[] candies = {12, 1, 12};
        int extraCandies = 10;
        List<Boolean> expected = List.of(true, false, true);
        Assertions.assertEquals(expected, solution1431.kidsWithCandies(candies, extraCandies));
    }
}

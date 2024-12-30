import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP1213Tests {
    private final SolutionP1213 solutionP1213 = new SolutionP1213();

    @Test
    public void example1() {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 5, 7, 9};
        int[] arr3 = {1, 3, 4, 5, 8};
        List<Integer> expected = List.of(1, 5);
        Assertions.assertEquals(expected, solutionP1213.arraysIntersection(arr1, arr2, arr3));
    }

    @Test
    public void example2() {
        int[] arr1 = {197, 418, 523, 876, 1356};
        int[] arr2 = {501, 880, 1593, 1710, 1870};
        int[] arr3 = {521, 682, 1337, 1395, 1764};
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solutionP1213.arraysIntersection(arr1, arr2, arr3));
    }
}

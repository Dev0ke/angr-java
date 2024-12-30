import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution989Tests {
    private final Solution989 solution989 = new Solution989();

    @Test
    public void example1() {
        int[] num = {1, 2, 0, 0};
        int k = 34;
        List<Integer> expected = List.of(1, 2, 3, 4);
        Assertions.assertEquals(expected, solution989.addToArrayForm(num, k));
    }

    @Test
    public void example2() {
        int[] num = {2, 7, 4};
        int k = 181;
        List<Integer> expected = List.of(4, 5, 5);
        Assertions.assertEquals(expected, solution989.addToArrayForm(num, k));
    }

    @Test
    public void example3() {
        int[] num = {2, 1, 5};
        int k = 806;
        List<Integer> expected = List.of(1, 0, 2, 1);
        Assertions.assertEquals(expected, solution989.addToArrayForm(num, k));
    }

    @Test
    public void example4() {
        int[] num = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        int k = 1;
        List<Integer> expected = List.of(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Assertions.assertEquals(expected, solution989.addToArrayForm(num, k));
    }
}

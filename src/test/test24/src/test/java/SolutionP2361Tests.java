import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2361Tests {
    private final SolutionP2361 solutionP2361 = new SolutionP2361();

    @Test
    public void example1() {
        int[] regular = {1, 6, 9, 5};
        int[] express = {5, 2, 3, 10};
        int expressCost = 8;
        long[] expected = {1, 7, 14, 19};
        Assertions.assertArrayEquals(expected, solutionP2361.minimumCosts(regular, express, expressCost));
    }

    @Test
    public void example2() {
        int[] regular = {11, 5, 13};
        int[] express = {7, 10, 6};
        int expressCost = 3;
        long[] expected = {10, 15, 24};
        Assertions.assertArrayEquals(expected, solutionP2361.minimumCosts(regular, express, expressCost));
    }
}
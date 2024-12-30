import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2838Tests {
    private final SolutionP2838 solutionP2838 = new SolutionP2838();

    @Test
    public void example1() {
        int[] heroes = {1, 4, 2};
        int[] monsters = {1, 1, 5, 2, 3};
        int[] coins = {2, 3, 4, 5, 6};
        long[] expected = {5, 16, 10};
        Assertions.assertArrayEquals(expected, solutionP2838.maximumCoins(heroes, monsters, coins));
    }

    @Test
    public void example2() {
        int[] heroes = {5};
        int[] monsters = {2, 3, 1, 2};
        int[] coins = {10, 6, 5, 2};
        long[] expected = {23};
        Assertions.assertArrayEquals(expected, solutionP2838.maximumCoins(heroes, monsters, coins));
    }

    @Test
    public void example3() {
        int[] heroes = {4, 4};
        int[] monsters = {5, 7, 8};
        int[] coins = {1, 1, 1};
        long[] expected = {0, 0};
        Assertions.assertArrayEquals(expected, solutionP2838.maximumCoins(heroes, monsters, coins));
    }
}
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3155Tests {
    private final SolutionP3155 solutionP3155 = new SolutionP3155();

    @Test
    public void example1() {
        int[] count = {4, 3};
        int[] upgrade = {3, 5};
        int[] sell = {4, 2};
        int[] money = {8, 9};
        int[] expected = {3, 2};
        Assertions.assertArrayEquals(expected, solutionP3155.maxUpgrades(count, upgrade, sell, money));
    }

    @Test
    public void example2() {
        int[] count = {1};
        int[] upgrade = {2};
        int[] sell = {1};
        int[] money = {1};
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, solutionP3155.maxUpgrades(count, upgrade, sell, money));
    }
}
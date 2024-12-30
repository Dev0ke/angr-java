import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2604Tests {
    private final SolutionP2604 solutionP2604 = new SolutionP2604();

    @Test
    public void example1() {
        int[] hens = {3, 6, 7};
        int[] grains = {2, 4, 7, 9};
        int expected = 2;
        Assertions.assertEquals(expected, solutionP2604.minimumTime(hens, grains));
    }

    @Test
    public void example2() {
        int[] hens = {4, 6, 109, 111, 213, 215};
        int[] grains = {5, 110, 214};
        int expected = 1;
        Assertions.assertEquals(expected, solutionP2604.minimumTime(hens, grains));
    }
}
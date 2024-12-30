import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2450Tests {
    private final SolutionP2450 solutionP2450 = new SolutionP2450();

    @Test
    public void example1() {
        String s = "1001";
        int k = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solutionP2450.countDistinctStrings(s, k));
    }

    @Test
    public void example2() {
        String s = "10110";
        int k = 5;
        int expected = 2;
        Assertions.assertEquals(expected, solutionP2450.countDistinctStrings(s, k));
    }
}
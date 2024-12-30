import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1175Tests {
    private final Solution1175 solution1175 = new Solution1175();

    @Test
    public void example1() {
        int n = 5;
        int expected = 12;
        Assertions.assertEquals(expected, solution1175.numPrimeArrangements(n));
        Assertions.assertEquals(expected, solution1175.numPrimeArrangements2(n));
    }

    @Test
    public void example2() {
        int n = 100;
        int expected = 682289015;
        Assertions.assertEquals(expected, solution1175.numPrimeArrangements(n));
        Assertions.assertEquals(expected, solution1175.numPrimeArrangements2(n));
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3135Tests {
    private final SolutionP3135 solutionP3135 = new SolutionP3135();

    @Test
    public void example1() {
        String initial = "abcde";
        String target = "cdef";
        int expected = 3;
        Assertions.assertEquals(expected, solutionP3135.minOperations(initial, target));
    }

    @Test
    public void example2() {
        String initial = "axxy";
        String target = "yabx";
        int expected = 6;
        Assertions.assertEquals(expected, solutionP3135.minOperations(initial, target));
    }

    @Test
    public void example3() {
        String initial = "xyz";
        String target = "xyz";
        int expected = 0;
        Assertions.assertEquals(expected, solutionP3135.minOperations(initial, target));
    }
}
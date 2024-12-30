import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3137Tests {
    private final Solution3137 solution3137 = new Solution3137();

    @Test
    public void example1() {
        String word = "leetcodeleet";
        int k = 4;
        int expected = 1;
        Assertions.assertEquals(expected, solution3137.minimumOperationsToMakeKPeriodic(word, k));
    }

    @Test
    public void example2() {
        String word = "leetcoleet";
        int k = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution3137.minimumOperationsToMakeKPeriodic(word, k));
    }
}
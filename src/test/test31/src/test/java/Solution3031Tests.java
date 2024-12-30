import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3031Tests {
    private final Solution3031 solution3031 = new Solution3031();

    @Test
    public void example1() {
        String word = "abacaba";
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution3031.minimumTimeToInitialState(word, k));
    }

    @Test
    public void example2() {
        String word = "abacaba";
        int k = 4;
        int expected = 1;
        Assertions.assertEquals(expected, solution3031.minimumTimeToInitialState(word, k));
    }

    @Test
    public void example3() {
        String word = "abcbabcd";
        int k = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution3031.minimumTimeToInitialState(word, k));
    }
}
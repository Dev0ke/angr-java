import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution779Tests {
    private final Solution779 solution779 = new Solution779();

    @Test
    public void example1() {
        int n = 1;
        int k = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution779.kthGrammar(n, k));
    }

    @Test
    public void example2() {
        int n = 2;
        int k = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution779.kthGrammar(n, k));
    }

    @Test
    public void example3() {
        int n = 2;
        int k = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution779.kthGrammar(n, k));
    }
}
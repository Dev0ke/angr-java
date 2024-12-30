import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution990Tests {
    private final Solution990 solution990 = new Solution990();

    @Test
    public void example1() {
        String[] equations = {"a==b", "b!=a"};
        Assertions.assertFalse(solution990.equationsPossible(equations));
    }

    @Test
    public void example2() {
        String[] equations = {"b==a", "a==b"};
        Assertions.assertTrue(solution990.equationsPossible(equations));
    }

    @Test
    public void example3() {
        String[] equations = {"a==b", "b==c", "a==c"};
        Assertions.assertTrue(solution990.equationsPossible(equations));
    }

    @Test
    public void example4() {
        String[] equations = {"a==b", "b!=c", "c==a"};
        Assertions.assertFalse(solution990.equationsPossible(equations));
    }

    @Test
    public void example5() {
        String[] equations = {"c==c", "b==d", "x!=z"};
        Assertions.assertTrue(solution990.equationsPossible(equations));
    }
}

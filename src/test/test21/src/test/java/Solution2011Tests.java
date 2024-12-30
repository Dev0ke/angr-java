import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2011Tests {
    private final Solution2011 solution2011 = new Solution2011();

    @Test
    public void example1() {
        String[] operations = {"--X", "X++", "X++"};
        int expected = 1;
        Assertions.assertEquals(expected, solution2011.finalValueAfterOperations(operations));
    }

    @Test
    public void example2() {
        String[] operations = {"++X", "++X", "X++"};
        int expected = 3;
        Assertions.assertEquals(expected, solution2011.finalValueAfterOperations(operations));
    }

    @Test
    public void example3() {
        String[] operations = {"X++", "++X", "--X", "X--"};
        int expected = 0;
        Assertions.assertEquals(expected, solution2011.finalValueAfterOperations(operations));
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution528Tests {
    @Test
    public void example1() {
        Solution528.Solution solution = new Solution528.Solution(new int[]{1});
        int expected = 0;
        Assertions.assertEquals(expected, solution.pickIndex());
    }
}

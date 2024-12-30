import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1927Tests {
    private final Solution1927 solution1927 = new Solution1927();

    @Test
    public void example1() {
        String num = "5023";
        Assertions.assertFalse(solution1927.sumGame(num));
    }

    @Test
    public void example2() {
        String num = "25??";
        Assertions.assertTrue(solution1927.sumGame(num));
    }

    @Test
    public void example3() {
        String num = "?3295???";
        Assertions.assertFalse(solution1927.sumGame(num));
    }
}

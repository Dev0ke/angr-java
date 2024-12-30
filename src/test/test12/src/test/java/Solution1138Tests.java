import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1138Tests {
    private final Solution1138 solution1138 = new Solution1138();

    @Test
    public void example1() {
        String target = "leet";
        String expected = "DDR!UURRR!!DDD!";
        Assertions.assertEquals(expected, solution1138.alphabetBoardPath(target));
    }

    @Test
    public void example2() {
        String target = "code";
        String expected = "RR!DDRR!UUL!R!";
        Assertions.assertEquals(expected, solution1138.alphabetBoardPath(target));
    }
}
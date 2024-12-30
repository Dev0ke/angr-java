import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2309Tests {
    private final Solution2309 solution2309 = new Solution2309();

    @Test
    public void example1() {
        String s = "lEeTcOdE";
        String expected = "E";
        Assertions.assertEquals(expected, solution2309.greatestLetter(s));
    }

    @Test
    public void example2() {
        String s = "arRAzFif";
        String expected = "R";
        Assertions.assertEquals(expected, solution2309.greatestLetter(s));
    }

    @Test
    public void example3() {
        String s = "AbCdEfGhIjK";
        String expected = "";
        Assertions.assertEquals(expected, solution2309.greatestLetter(s));
    }
}

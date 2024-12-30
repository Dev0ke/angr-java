import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1678Tests {
    private final Solution1678 solution1678 = new Solution1678();

    @Test
    public void example1() {
        String command = "G()(al)";
        String expected = "Goal";
        Assertions.assertEquals(expected, solution1678.interpret(command));
    }

    @Test
    public void example2() {
        String command = "G()()()()(al)";
        String expected = "Gooooal";
        Assertions.assertEquals(expected, solution1678.interpret(command));
    }

    @Test
    public void example3() {
        String command = "(al)G(al)()()G";
        String expected = "alGalooG";
        Assertions.assertEquals(expected, solution1678.interpret(command));
    }
}

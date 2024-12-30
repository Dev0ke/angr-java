import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3248Tests {
    private final Solution3248 solution3248 = new Solution3248();

    @Test
    public void example1() {
        int n = 2;
        List<String> commands = List.of("RIGHT", "DOWN");
        int expected = 3;
        Assertions.assertEquals(expected, solution3248.finalPositionOfSnake(n, commands));
    }

    @Test
    public void example2() {
        int n = 3;
        List<String> commands = List.of("DOWN", "RIGHT", "UP");
        int expected = 1;
        Assertions.assertEquals(expected, solution3248.finalPositionOfSnake(n, commands));
    }
}
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution412Tests {
    private final Solution412 solution412 = new Solution412();

    @Test
    public void example1() {
        int n = 15;
        List<String> expected = List.of(
                "1",
                "2",
                "Fizz",
                "4",
                "Buzz",
                "Fizz",
                "7",
                "8",
                "Fizz",
                "Buzz",
                "11",
                "Fizz",
                "13",
                "14",
                "FizzBuzz"
        );
        Assertions.assertEquals(expected, solution412.fizzBuzz(n));
    }
}

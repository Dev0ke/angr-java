import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution282Tests {
    private final Solution282 solution282 = new Solution282();

    @Test
    public void example1() {
        String num = "123";
        int target = 6;
        List<String> expected = new ArrayList<>(List.of("1+2+3", "1*2*3"));
        List<String> actual = solution282.addOperators(num, target);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        String num = "232";
        int target = 8;
        List<String> expected = new ArrayList<>(List.of("2*3+2", "2+3*2"));
        List<String> actual = solution282.addOperators(num, target);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        String num = "3456237490";
        int target = 9191;
        List<String> expected = new ArrayList<>();
        List<String> actual = solution282.addOperators(num, target);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }
}

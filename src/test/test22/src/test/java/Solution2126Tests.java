import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2126Tests {
    private final Solution2126 solution2126 = new Solution2126();

    @Test
    public void example1() {
        int mass = 10;
        int[] asteroids = {3, 9, 19, 5, 21};
        Assertions.assertTrue(solution2126.asteroidsDestroyed(mass, asteroids));
    }

    @Test
    public void example2() {
        int mass = 5;
        int[] asteroids = {4, 9, 23, 4};
        Assertions.assertFalse(solution2126.asteroidsDestroyed(mass, asteroids));
    }

    // 补充用例
    @Test
    public void example3() {
        int mass = 375;
        int[] asteroids = {5, 6, 24246, 51305, 87775, 12816};
        Assertions.assertFalse(solution2126.asteroidsDestroyed(mass, asteroids));
    }
}

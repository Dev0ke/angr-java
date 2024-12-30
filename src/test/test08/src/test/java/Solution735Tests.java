import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution735Tests {
    private final Solution735 solution735 = new Solution735();

    @Test
    public void example1() {
        int[] asteroids = {5, 10, -5};
        int[] expected = {5, 10};
        Assertions.assertArrayEquals(expected, solution735.asteroidCollision(asteroids));
    }

    @Test
    public void example2() {
        int[] asteroids = {8, -8};
        int[] expected = {};
        Assertions.assertArrayEquals(expected, solution735.asteroidCollision(asteroids));
    }

    @Test
    public void example3() {
        int[] asteroids = {10, 2, -5};
        int[] expected = {10};
        Assertions.assertArrayEquals(expected, solution735.asteroidCollision(asteroids));
    }

    @Test
    public void example4() {
        int[] asteroids = {-2, -1, 1, 2};
        int[] expected = {-2, -1, 1, 2};
        Assertions.assertArrayEquals(expected, solution735.asteroidCollision(asteroids));
    }
}

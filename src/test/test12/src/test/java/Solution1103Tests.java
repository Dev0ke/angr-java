import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1103Tests {
    private final Solution1103 solution1103 = new Solution1103();

    @Test
    public void example1() {
        int candies = 7;
        int num_people = 4;
        int[] expected = {1, 2, 3, 1};
        Assertions.assertArrayEquals(expected, solution1103.distributeCandies(candies, num_people));
    }

    @Test
    public void example2() {
        int candies = 10;
        int num_people = 3;
        int[] expected = {5, 2, 3};
        Assertions.assertArrayEquals(expected, solution1103.distributeCandies(candies, num_people));
    }
}
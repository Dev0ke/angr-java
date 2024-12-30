import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution167Tests {
    private final Solution167 solution167 = new Solution167();

    @Test
    public void example1() {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {1, 2};
        Assertions.assertArrayEquals(expected, solution167.twoSum(numbers, target));
        Assertions.assertArrayEquals(expected, solution167.twoSum2(numbers, target));
        Assertions.assertArrayEquals(expected, solution167.twoSum3(numbers, target));
    }

    @Test
    public void example2() {
        int[] numbers = {2, 3, 4};
        int target = 6;
        int[] expected = {1, 3};
        Assertions.assertArrayEquals(expected, solution167.twoSum(numbers, target));
        Assertions.assertArrayEquals(expected, solution167.twoSum2(numbers, target));
        Assertions.assertArrayEquals(expected, solution167.twoSum3(numbers, target));
    }

    @Test
    public void example3() {
        int[] numbers = {-1, 0};
        int target = -1;
        int[] expected = {1, 2};
        Assertions.assertArrayEquals(expected, solution167.twoSum(numbers, target));
        Assertions.assertArrayEquals(expected, solution167.twoSum2(numbers, target));
        Assertions.assertArrayEquals(expected, solution167.twoSum3(numbers, target));
    }
}

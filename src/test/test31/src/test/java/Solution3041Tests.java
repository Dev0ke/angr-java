import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3041Tests {
    private final Solution3041.V1 solution3041_v1 = new Solution3041.V1();
    private final Solution3041.V2 solution3041_v2 = new Solution3041.V2();

    @Test
    public void example1() {
        int[] nums = {2, 1, 5, 1, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution3041_v1.maxSelectedElements(nums));
        Assertions.assertEquals(expected, solution3041_v2.maxSelectedElements(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 4, 7, 10};
        int expected = 1;
        Assertions.assertEquals(expected, solution3041_v1.maxSelectedElements(nums));
        Assertions.assertEquals(expected, solution3041_v2.maxSelectedElements(nums));
    }
}
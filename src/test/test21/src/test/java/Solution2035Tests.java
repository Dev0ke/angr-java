import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class Solution2035Tests {
    private final Solution2035 solution2035 = new Solution2035();

    @Test
    public void example1() {
        int[] nums = {3, 9, 7, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution2035.minimumDifference(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-36, 36};
        int expected = 72;
        Assertions.assertEquals(expected, solution2035.minimumDifference(nums));
    }

    @Test
    public void example3() {
        int[] nums = {2, -1, 0, 4, -2, -9};
        int expected = 0;
        Assertions.assertEquals(expected, solution2035.minimumDifference(nums));
    }

    // 补充用例
    @Test
    public void example4() {
        int[] nums = {-52706, 66649, -25761, -25402, -78514, -22173, 64310, -94230, 30731, 5190, 23665, 42545, 4378, 11126, 45917, -57771, 76046, -12994};
        int expected = 0;
        Assertions.assertEquals(expected, solution2035.minimumDifference(nums));
    }

    @Test
    public void example4_2() {
        int[] nums = {-52706, 66649, -25761, -25402, -78514, -22173, 64310, -94230, 30731, 5190, 23665, 42545, 4378, 11126, 45917, -57771, 76046, -12994};
        int expected = 0;
        Assertions.assertEquals(expected, solution2035.minimumDifference2(nums));
    }

    @Test
    public void example5() {
        int[] nums = {7772197, 4460211, -7641449, -8856364, 546755, -3673029, 527497, -9392076, 3130315, -5309187, -4781283, 5919119, 3093450, 1132720, 6380128, -3954678, -1651499, -7944388, -3056827, 1610628, 7711173, 6595873, 302974, 7656726, -2572679, 0, 2121026, -5743797, -8897395, -9699694};
        int expected = 1;
        Assertions.assertEquals(expected, solution2035.minimumDifference(nums));
    }

    @Test
    @Disabled
    public void example5_2() {
        // -Xms4G -Xmx4G
        int[] nums = {7772197, 4460211, -7641449, -8856364, 546755, -3673029, 527497, -9392076, 3130315, -5309187, -4781283, 5919119, 3093450, 1132720, 6380128, -3954678, -1651499, -7944388, -3056827, 1610628, 7711173, 6595873, 302974, 7656726, -2572679, 0, 2121026, -5743797, -8897395, -9699694};
        int expected = 1;
        Assertions.assertEquals(expected, solution2035.minimumDifference2(nums));
    }
}
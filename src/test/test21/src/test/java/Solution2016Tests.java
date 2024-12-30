import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2016Tests {
    private final Solution2016 solution2016 = new Solution2016();

    @Test
    public void example1() {
        int[] nums = {7, 1, 5, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solution2016.maximumDifference(nums));
    }

    @Test
    public void example2() {
        int[] nums = {9, 4, 3, 2};
        int expected = -1;
        Assertions.assertEquals(expected, solution2016.maximumDifference(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 5, 2, 10};
        int expected = 9;
        Assertions.assertEquals(expected, solution2016.maximumDifference(nums));
    }

    // 补充用例
    @Test
    public void example4() {
        int[] nums = {999, 997, 980, 976, 948, 940, 938, 928, 924, 917, 907, 907, 881, 878, 864, 862, 859, 857, 848, 840, 824, 824, 824, 805, 802, 798, 788, 777, 775, 766, 755, 748, 735, 732, 727, 705, 700, 697, 693, 679, 676, 644, 634, 624, 599, 596, 588, 583, 562, 558, 553, 539, 537, 536, 509, 491, 485, 483, 454, 449, 438, 425, 403, 368, 345, 327, 287, 285, 270, 263, 255, 248, 235, 234, 224, 221, 201, 189, 187, 183, 179, 168, 155, 153, 150, 144, 107, 102, 102, 87, 80, 57, 55, 49, 48, 45, 26, 26, 23, 15};
        int expected = -1;
        Assertions.assertEquals(expected, solution2016.maximumDifference(nums));
    }
}

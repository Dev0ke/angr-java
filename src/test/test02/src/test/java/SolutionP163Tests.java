import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP163Tests {
    private final SolutionP163 solutionP163 = new SolutionP163();

    @Test
    public void example1() {
        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;
        List<String> expected = List.of("2", "4->49", "51->74", "76->99");
        Assertions.assertEquals(expected, solutionP163.findMissingRanges(nums, lower, upper));
    }
}

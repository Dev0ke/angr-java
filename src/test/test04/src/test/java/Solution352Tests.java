import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution352Tests {
    @Test
    public void example1() {
        Solution352.SummaryRanges summaryRanges = new Solution352.SummaryRanges();
        // arr = [1]
        summaryRanges.addNum(1);
        // 返回 [[1, 1]]
        Assertions.assertArrayEquals(UtUtils.stringToInts2("[[1, 1]]"), summaryRanges.getIntervals());
        // arr = [1, 3]
        summaryRanges.addNum(3);
        // 返回 [[1, 1], [3, 3]]
        Assertions.assertArrayEquals(UtUtils.stringToInts2("[[1, 1], [3, 3]]"), summaryRanges.getIntervals());
        // arr = [1, 3, 7]
        summaryRanges.addNum(7);
        // 返回 [[1, 1], [3, 3], [7, 7]]
        Assertions.assertArrayEquals(UtUtils.stringToInts2("[[1, 1], [3, 3], [7, 7]]"), summaryRanges.getIntervals());
        // arr = [1, 2, 3, 7]
        summaryRanges.addNum(2);
        // 返回 [[1, 3], [7, 7]]
        Assertions.assertArrayEquals(UtUtils.stringToInts2("[[1, 3], [7, 7]]"), summaryRanges.getIntervals());
        // arr = [1, 2, 3, 6, 7]
        summaryRanges.addNum(6);
        // 返回 [[1, 3], [6, 7]]
        Assertions.assertArrayEquals(UtUtils.stringToInts2("[[1, 3], [6, 7]]"), summaryRanges.getIntervals());
    }
}

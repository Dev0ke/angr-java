import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution295Tests {
    @Test
    public void example1() {
        Solution295.MedianFinder medianFinder = new Solution295.MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        Assertions.assertEquals(1.5, medianFinder.findMedian());
        medianFinder.addNum(3);
        Assertions.assertEquals(2, medianFinder.findMedian());
    }
}
